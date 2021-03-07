package top.suika.runtime.exec;

import top.suika.runtime.parse.SkcFile;
import top.suika.runtime.type.*;
import top.suika.runtime.util.LimitedStack;

import java.util.HashMap;

public class Interpreter{
  
  private final LimitedStack<ExecContext> stackFrames = new LimitedStack<>(65536);
  private HashMap<String, SValue> globalVars;
  private SValue[] constants;
  
  private Instruction[] code;
  private int index;
  private SValue[] locals;
  private LimitedStack<SValue> operands;
  
  public Interpreter(SkcFile sf){
    this.globalVars = sf.bounds;
    this.constants = sf.constants;
  }
  
  public void exec(){
    mainloop:
    while(true){
      Instruction opcode = code[index++];
      SValue left, right;
      switch(opcode.type){
        case Instruction.Types.NOPE:
          continue;
        case Instruction.Types.ADD:
          right = operands.pop();
          left = operands.pop();
          operands.push(new SNum(((SNum) left).value + ((SNum) right).value));
          continue;
        case Instruction.Types.SUB:
          right = operands.pop();
          left = operands.pop();
          operands.push(new SNum(((SNum) left).value - ((SNum) right).value));
          continue;
        case Instruction.Types.MUL:
          right = operands.pop();
          left = operands.pop();
          operands.push(new SNum(((SNum) left).value * ((SNum) right).value));
          continue;
        case Instruction.Types.DIV:
          right = operands.pop();
          left = operands.pop();
          operands.push(new SNum(((SNum) left).value / ((SNum) right).value));
          continue;
        case Instruction.Types.MOD:
          right = operands.pop();
          left = operands.pop();
          operands.push(new SNum(((SNum) left).value % ((SNum) right).value));
          continue;
        case Instruction.Types.NEG:
          left = operands.pop();
          operands.push(new SNum(-((SNum) left).value));
          continue;
        case Instruction.Types.GTR:
          right = operands.pop();
          left = operands.pop();
          operands.push(SBool.valueOf(((SNum) left).value > ((SNum) right).value));
          continue;
        case Instruction.Types.LSS:
          right = operands.pop();
          left = operands.pop();
          operands.push(SBool.valueOf(((SNum) left).value < ((SNum) right).value));
          continue;
        case Instruction.Types.GEQ:
          right = operands.pop();
          left = operands.pop();
          operands.push(SBool.valueOf(((SNum) left).value >= ((SNum) right).value));
          continue;
        case Instruction.Types.LEQ:
          right = operands.pop();
          left = operands.pop();
          operands.push(SBool.valueOf(((SNum) left).value <= ((SNum) right).value));
          continue;
        case Instruction.Types.AND:
          right = operands.pop();
          left = operands.pop();
          operands.push(SBool.valueOf(left == SBool.TRUE && right == SBool.TRUE));
          continue;
        case Instruction.Types.OR:
          right = operands.pop();
          left = operands.pop();
          operands.push(SBool.valueOf(left == SBool.TRUE || right == SBool.TRUE));
          continue;
        case Instruction.Types.NOT:
          left = operands.pop();
          operands.push(left == SBool.TRUE ? SBool.FALSE : SBool.TRUE);
          continue;
        case Instruction.Types.EQ:
          right = operands.pop();
          left = operands.pop();
          operands.push(SBool.valueOf(left == right));
          continue;
        case Instruction.Types.NEQ:
          right = operands.pop();
          left = operands.pop();
          operands.push(SBool.valueOf(left != right));
          continue;
        case Instruction.Types.GOTO:
          index = opcode.arg;
          continue;
        case Instruction.Types.IF:
          if(operands.pop() == SBool.TRUE) index = opcode.arg;
          continue;
        case Instruction.Types.CALL:
          left = operands.pop();
          stackFrames.push(new ExecContext(code, index, locals, operands));
          code = ((SFunctionRef) left).value.code;
          index = 0;
          locals = new SValue[((SFunctionRef) left).value.localCount];
          operands = new LimitedStack<>(4096);
          continue;
        case Instruction.Types.RET:
          if(stackFrames.count() == 0) break mainloop;
          SValue retVal = operands.peek();
          ExecContext ctx = stackFrames.pop();
          code = ctx.code;
          index = ctx.index;
          locals = ctx.locals;
          operands = ctx.operands;
          operands.push(retVal);
          continue;
        case Instruction.Types.POP:
          operands.pop();
          continue;
        case Instruction.Types.DUPE:
          operands.push(operands.peek());
          continue;
        case Instruction.Types.SWAP:
          right = operands.pop();
          left = operands.pop();
          operands.push(left);
          operands.push(right);
          continue;
        case Instruction.Types.CONST:
          operands.push(constants[opcode.arg]);
          continue;
        case Instruction.Types.CONST_NULL:
          operands.push(SNull.INSTANCE);
          continue;
        case Instruction.Types.CONST_TRUE:
          operands.push(SBool.TRUE);
          continue;
        case Instruction.Types.CONST_FALSE:
          operands.push(SBool.FALSE);
          continue;
        case Instruction.Types.LOAD:
          operands.push(locals[opcode.arg]);
          continue;
        case Instruction.Types.STORE:
          locals[opcode.arg] = operands.pop();
          continue;
        case Instruction.Types.LOADGV:;
          operands.push(globalVars.get(((SStr) constants[opcode.arg]).value));
          continue;
        case Instruction.Types.STOREGV:
          globalVars.put(((SStr) constants[opcode.arg]).value, operands.pop());
          continue;
      }
    }
  }
  
}
