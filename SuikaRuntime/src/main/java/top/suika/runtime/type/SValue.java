package top.suika.runtime.type;

import top.suika.runtime.exception.TypeException;

public abstract class SValue{
  
  // General
  public abstract String asString();
  
  // Math ops
  public SValue opAdd(SValue right){
    throw new TypeException("Type" + this.getClass().getCanonicalName() + "doesn't support operator + with type "
        + right.getClass().getCanonicalName());
  }
  
  public SValue opSub(SValue right){
    throw new TypeException("Type" + this.getClass().getCanonicalName() + "doesn't support operator - with type "
        + right.getClass().getCanonicalName());
  }
  
  public SValue opMul(SValue right){
    throw new TypeException("Type" + this.getClass().getCanonicalName() + "doesn't support operator * with type "
        + right.getClass().getCanonicalName());
  }
  
  public SValue opDiv(SValue right){
    throw new TypeException("Type" + this.getClass().getCanonicalName() + "doesn't support operator / with type "
        + right.getClass().getCanonicalName());
  }
  
  public SValue opMod(SValue right){
    throw new TypeException("Type" + this.getClass().getCanonicalName() + "doesn't support operator % with type "
        + right.getClass().getCanonicalName());
  }
  
  public SValue opNeg(){
    throw new TypeException("Type" + this.getClass().getCanonicalName() + "doesn't support operator - (Negate)");
  }
  
  // Relational ops
  public SValue opGtr(SValue right){
    throw new TypeException("Type" + this.getClass().getCanonicalName() + "doesn't support operator > with type "
        + right.getClass().getCanonicalName());
  }
  
  public SValue opLss(SValue right){
    throw new TypeException("Type" + this.getClass().getCanonicalName() + "doesn't support operator < with type "
        + right.getClass().getCanonicalName());
  }
  
  public SValue opGeq(SValue right){
    throw new TypeException("Type" + this.getClass().getCanonicalName() + "doesn't support operator >= with type "
        + right.getClass().getCanonicalName());
  }
  
  public SValue opLeq(SValue right){
    throw new TypeException("Type" + this.getClass().getCanonicalName() + "doesn't support operator <= with type "
        + right.getClass().getCanonicalName());
  }
  
  // Equality ops
  public SValue opEq(SValue right){
    return SBool.valueOf(this == right);
  }
  public SValue opNeq(SValue right){
    return SBool.valueOf(this != right);
  }
  
  // Logic ops
  public SValue opAnd(SValue right){
    throw new TypeException("Type" + this.getClass().getCanonicalName() + "doesn't support operator & with type "
        + right.getClass().getCanonicalName());
  }
  
  public SValue opOr(SValue right){
    throw new TypeException("Type" + this.getClass().getCanonicalName() + "doesn't support operator | with type "
        + right.getClass().getCanonicalName());
  }
  
  public SValue opNot(){
    throw new TypeException("Type" + this.getClass().getCanonicalName() + "doesn't support operator !");
  }
  
  
}
