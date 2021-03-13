package top.suika.runtime.type;

import top.suika.runtime.exec.Function;

public final class SFunctionRef extends SValue{
  
  public final Function value;
  
  public SFunctionRef(Function value){
    this.value = value;
  }
  
  @Override
  public String asString(){
    return "function";
  }
  
  @Override
  public SBool opEq(SValue right){
    if(right instanceof SFunctionRef)
      return SBool.valueOf(value == ((SFunctionRef) right).value);
    return SBool.FALSE;
  }
  
  @Override
  public SBool opNeq(SValue right){
    if(right instanceof SFunctionRef)
      return SBool.valueOf(value != ((SFunctionRef) right).value);
    return SBool.TRUE;
  }
  
}
