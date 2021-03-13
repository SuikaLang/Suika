package top.suika.runtime.type;

import top.suika.runtime.exception.TypeException;

public final class SBool extends SValue{
  
  public final boolean value;
  
  private SBool(boolean value){
    this.value = value;
  }
  
  public static SBool valueOf(boolean value){ return value ? TRUE : FALSE; }
  
  public static final SBool TRUE = new SBool(true);
  public static final SBool FALSE = new SBool(false);
  
  @Override
  public String asString(){
    return this.value ? "true" : "false";
  }
  
  @Override
  public SBool opAnd(SValue right){
    if(right instanceof SBool)
      return valueOf(value && ((SBool) right).value);
    throw new TypeException("SBool doesn't support operator & with that type: " + right.getClass().getCanonicalName());
  }
  
  @Override
  public SBool opOr(SValue right){
    if(right instanceof SBool)
      return valueOf(value || ((SBool) right).value);
    throw new TypeException("SBool doesn't support operator | with that type: " + right.getClass().getCanonicalName());
  }
  
  @Override
  public SBool opNot(){
    return value ? FALSE : TRUE;
  }
}
