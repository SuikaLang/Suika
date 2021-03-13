package top.suika.runtime.exec;

import top.suika.runtime.parse.SkcFile;
import top.suika.runtime.type.*;
import top.suika.runtime.util.LimitedStack;

import java.util.HashMap;

public class Interpreter{
  
  private final LimitedStack<ExecContext> stackFrames = new LimitedStack<>(65536);
  private final HashMap<String, SValue> globalVars;
  private final SValue[] constants;
  
  private Opcode[] code;
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
      Opcode opcode = code[index++];
      SValue left, right;
      switch(opcode.type){
        case OpcodeType.NOPE:
          continue;
          
        case OpcodeType.ADD:
          right = operands.pop();
          left = operands.pop();
          operands.push(left.opAdd(right));
          continue;
          
        case OpcodeType.SUB:
          right = operands.pop();
          left = operands.pop();
          operands.push(left.opSub(right));
          continue;
          
        case OpcodeType.MUL:
          right = operands.pop();
          left = operands.pop();
          operands.push(left.opMul(right));
          continue;
          
        case OpcodeType.DIV:
          right = operands.pop();
          left = operands.pop();
          operands.push(left.opDiv(right));
          continue;
          
        case OpcodeType.MOD:
          right = operands.pop();
          left = operands.pop();
          operands.push(left.opMod(right));
          continue;
          
        case OpcodeType.NEG:
          left = operands.pop();
          operands.push(left.opNeg());
          continue;
          
        case OpcodeType.GTR:
          right = operands.pop();
          left = operands.pop();
          operands.push(left.opGtr(right));
          continue;
          
        case OpcodeType.LSS:
          right = operands.pop();
          left = operands.pop();
          operands.push(left.opLss(right));
          continue;
          
        case OpcodeType.GEQ:
          right = operands.pop();
          left = operands.pop();
          operands.push(left.opGeq(right));
          continue;
          
        case OpcodeType.LEQ:
          right = operands.pop();
          left = operands.pop();
          operands.push(left.opLeq(right));
          continue;
          
        case OpcodeType.AND:
          right = operands.pop();
          left = operands.pop();
          operands.push(left.opAnd(right));
          continue;
          
        case OpcodeType.OR:
          right = operands.pop();
          left = operands.pop();
          operands.push(left.opOr(right));
          continue;
          
        case OpcodeType.NOT:
          left = operands.pop();
          operands.push(left.opNot());
          continue;
          
        case OpcodeType.EQ:
          right = operands.pop();
          left = operands.pop();
          operands.push(left.opEq(right));
          continue;
          
        case OpcodeType.NEQ:
          right = operands.pop();
          left = operands.pop();
          operands.push(left.opNeq(right));
          continue;
          
        case OpcodeType.GOTO:
          index = opcode.arg;
          continue;
          
        case OpcodeType.IF:
          if(operands.pop() == SBool.FALSE) index = opcode.arg;
          continue;
          
        case OpcodeType.CALL:
          left = operands.pop();
          if(opcode.arg > ((SFunctionRef) left).value.localCount)
            throw new ArrayIndexOutOfBoundsException("arg count > local count");
          var args = new SValue[opcode.arg];
          for(int i = opcode.arg - 1; i >= 0; --i){
            args[i] = operands.pop();
          }
          stackFrames.push(new ExecContext(code, index, locals, operands));
          code = ((SFunctionRef) left).value.code;
          index = 0;
          locals = new SValue[((SFunctionRef) left).value.localCount];
          System.arraycopy(args, 0, locals, 0, args.length);
          operands = new LimitedStack<>(4096);
          continue;
          
        case OpcodeType.RET:
          if(stackFrames.count() == 0) break mainloop;
          SValue retVal = operands.peek();
          ExecContext ctx = stackFrames.pop();
          code = ctx.code;
          index = ctx.index;
          locals = ctx.locals;
          operands = ctx.operands;
          operands.push(retVal);
          continue;
          
        case OpcodeType.POP:
          operands.pop();
          continue;
          
        case OpcodeType.DUPE:
          operands.push(operands.peek());
          continue;
          
        case OpcodeType.SWAP:
          right = operands.pop();
          left = operands.pop();
          operands.push(left);
          operands.push(right);
          continue;
          
        case OpcodeType.CONST:
          operands.push(constants[opcode.arg]);
          continue;
          
        case OpcodeType.CONST_NULL:
          operands.push(SNull.INSTANCE);
          continue;
          
        case OpcodeType.CONST_TRUE:
          operands.push(SBool.TRUE);
          continue;
          
        case OpcodeType.CONST_FALSE:
          operands.push(SBool.FALSE);
          continue;
          
        case OpcodeType.LOAD:
          operands.push(locals[opcode.arg]);
          continue;
          
        case OpcodeType.STORE:
          locals[opcode.arg] = operands.pop();
          continue;
          
        case OpcodeType.LOADGV:;
          operands.push(globalVars.get(((SStr) constants[opcode.arg]).value));
          continue;
          
        case OpcodeType.STOREGV:
          globalVars.put(((SStr) constants[opcode.arg]).value, operands.pop());
          continue;
      }
    }
  }
  
}
