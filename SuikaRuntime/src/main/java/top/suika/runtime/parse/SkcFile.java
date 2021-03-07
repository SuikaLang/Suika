package top.suika.runtime.parse;

import top.suika.runtime.exec.Function;
import top.suika.runtime.type.SValue;

import java.util.HashMap;

public final class SkcFile{

  public final String filename;
  public final SValue[] constants;
  public final Function[] functions;
  public final HashMap<String, SValue> bounds;
  
  public SkcFile(String filename, SValue[] constants, Function[] functions, HashMap<String, SValue> bounds){
    this.filename = filename;
    this.constants = constants;
    this.functions = functions;
    this.bounds = bounds;
  }

}
