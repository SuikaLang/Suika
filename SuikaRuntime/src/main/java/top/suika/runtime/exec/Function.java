package top.suika.runtime.exec;

public final class Function{
  
  public final Opcode[] code;
  public final int localCount;
  
  public Function(Opcode[] code, int localCount){
    this.code = code;
    this.localCount = localCount;
  }
  
}
