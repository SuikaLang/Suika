package top.suika.vm.exec;

import java.util.UUID;

public final class Function{
  
  public final UUID id;
  public final Instruction[] code;
  public final int localCount;
  
  public Function(UUID uuid, Instruction[] code, int localCount){
    this.id = uuid;
    this.code = code;
    this.localCount = localCount;
  }
  
}
