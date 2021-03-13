package top.suika.runtime.parse;

import top.suika.runtime.type.SValue;

import java.util.HashMap;

public final class SkcFile{

  public final SValue[] constants;
  public final HashMap<String, SValue> bounds;
  
  public SkcFile(SValue[] constants, HashMap<String, SValue> bounds){
    this.constants = constants;
    this.bounds = bounds;
  }

}
