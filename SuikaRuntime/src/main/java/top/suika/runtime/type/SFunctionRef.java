package top.suika.runtime.type;

import top.suika.runtime.exec.Function;

public class SFunctionRef extends SValue{
  
  public final Function value;
  
  public SFunctionRef(Function value){
    this.value = value;
  }
  
}
