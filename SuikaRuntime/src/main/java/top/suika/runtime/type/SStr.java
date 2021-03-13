package top.suika.runtime.type;

import top.suika.runtime.exception.TypeException;

public final class SStr extends SValue{
  
  public final String value;
  
  public SStr(String value){
    this.value = value;
  }
  
  @Override
  public String asString(){
    return value;
  }
  
  @Override
  public SStr opAdd(SValue right){
    return new SStr(this.value + right.asString());
  }
  
  // I really want string repeat sugar in java
  @Override
  public SStr opMul(SValue right){
    if(right instanceof SNum)
      return new SStr(value.repeat((int) ((SNum) right).value));
    throw new TypeException("SStr doesn't support operator * with that type: " + right.getClass().getCanonicalName());
  }
  
  @Override
  public SBool opEq(SValue right){
    if(right instanceof SStr)
      return SBool.valueOf(this.value.equals(((SStr) right).value));
    return SBool.FALSE;
  }
  
  @Override
  public SBool opNeq(SValue right){
    if(right instanceof SStr)
      return SBool.valueOf(!this.value.equals(((SStr) right).value));
    return SBool.TRUE;
  }
  
}
