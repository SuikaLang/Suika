package top.suika.runtime.type;

public final class SNull extends SValue{
  
  private SNull(){}
  
  public static final SNull INSTANCE = new SNull();
  
  @Override
  public String asString(){
    return "null";
  }
  
}
