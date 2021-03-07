package top.suika.runtime.exec;

import top.suika.runtime.type.SValue;
import top.suika.runtime.util.LimitedStack;

public final class ExecContext{
  
  public final Instruction[] code;
  public final int index;
  public final SValue[] locals;
  public final LimitedStack<SValue> operands;
  
  public ExecContext(Instruction[] code, int index, SValue[] locals, LimitedStack<SValue> operands){
    this.code = code;
    this.index = index;
    this.locals = locals;
    this.operands = operands;
  }
  
}
