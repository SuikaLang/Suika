package top.suika.runtime.exec;

public final class Opcode{
  
  public final byte type;
  public final int arg;
  
  public Opcode(byte t, int arg){
    this.type = t;
    this.arg = arg;
  }
  
}
