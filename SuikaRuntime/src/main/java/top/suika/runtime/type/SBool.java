package top.suika.runtime.type;

public final class SBool extends SValue{
  
  public final boolean value;
  
  private SBool(boolean value){
    this.value = value;
  }
  
  public static final SBool valueOf(boolean value){ return value ? TRUE : FALSE; }
  
  public static final SBool TRUE = new SBool(true);
  public static final SBool FALSE = new SBool(false);
  
}
