package top.suika.runtime.type;

import top.suika.runtime.exception.TypeException;

public final class SNum extends SValue{
  
  public final double value;
  
  public SNum(double value){
    this.value = value;
  }
  
  @Override
  public String asString(){
    return Double.toString(value);
  }
  
  @Override
  public SNum opAdd(SValue right){
    if(right instanceof SNum)
      return new SNum(this.value + ((SNum) right).value);
    throw new TypeException("SNum doesn't support operator + with that type: " + right.getClass().getCanonicalName());
  }
  
  @Override
  public SNum opSub(SValue right){
    if(right instanceof SNum)
      return new SNum(this.value + ((SNum) right).value);
    throw new TypeException("SNum doesn't support operator + with that type: " + right.getClass().getCanonicalName());
  }
  
  @Override
  public SNum opMul(SValue right){
    if(right instanceof SNum)
      return new SNum(this.value + ((SNum) right).value);
    throw new TypeException("SNum doesn't support operator + with that type: " + right.getClass().getCanonicalName());
  }
  
  @Override
  public SNum opDiv(SValue right){
    if(right instanceof SNum)
      return new SNum(this.value + ((SNum) right).value);
    throw new TypeException("SNum doesn't support operator + with that type: " + right.getClass().getCanonicalName());
  }
  
  @Override
  public SNum opMod(SValue right){
    if(right instanceof SNum)
      return new SNum(this.value + ((SNum) right).value);
    throw new TypeException("SNum doesn't support operator + with that type: " + right.getClass().getCanonicalName());
  }
  
  @Override
  public SNum opNeg(){
    return new SNum(-this.value);
  }
  
  @Override
  public SBool opGtr(SValue right){
    if(right instanceof SNum)
      return SBool.valueOf(this.value > ((SNum) right).value);
    throw new TypeException("SNum doesn't support operator > with that type: " + right.getClass().getCanonicalName());
  }
  
  @Override
  public SBool opLss(SValue right){
    if(right instanceof SNum)
      return SBool.valueOf(this.value < ((SNum) right).value);
    throw new TypeException("SNum doesn't support operator < with that type: " + right.getClass().getCanonicalName());
  }
  
  @Override
  public SBool opGeq(SValue right){
    if(right instanceof SNum)
      return SBool.valueOf(this.value >= ((SNum) right).value);
    throw new TypeException("SNum doesn't support operator >= with that type: " + right.getClass().getCanonicalName());
  }
  
  @Override
  public SBool opLeq(SValue right){
    if(right instanceof SNum)
      return SBool.valueOf(this.value <= ((SNum) right).value);
    throw new TypeException("SNum doesn't support operator <= with that type: " + right.getClass().getCanonicalName());
  }
  
  @Override
  public SBool opEq(SValue right){
    if(right instanceof SNum)
      return SBool.valueOf(this.value == ((SNum) right).value);
    return SBool.FALSE;
  }
  
  @Override
  public SBool opNeq(SValue right){
    if(right instanceof SNum)
      return SBool.valueOf(this.value != ((SNum) right).value);
    return SBool.TRUE;
  }
  
}
