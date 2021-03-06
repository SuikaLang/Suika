package top.suika.vm.type;

import top.suika.vm.exec.Function;

public class SFunctionRef extends SValue{
  
  public final Function value;
  
  public SFunctionRef(Function value){
    this.value = value;
  }
  
}
