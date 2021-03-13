package top.suika.runtime.parse;

import top.suika.runtime.exec.Function;
import top.suika.runtime.exec.Opcode;
import top.suika.runtime.exec.OpcodeType;
import top.suika.runtime.type.*;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public final class SkcParser{
  
  public static SkcFile parse(File f) throws IOException{
    return parse(new DataInputStream(new BufferedInputStream(new FileInputStream(f), 8192)));
  }
  
  public static SkcFile parse(byte[] src) throws IOException{
    return parse(new DataInputStream(new ByteArrayInputStream(src)));
  }
  
  public static SkcFile parse(InputStream src) throws IOException{
    return parse(new DataInputStream(src));
  }
  
  public static SkcFile parse(DataInputStream src) throws IOException{
    if(src.readInt() != 0x73_6B_63_21) return null; // Verify magic number.
    
    var constCount = src.readUnsignedShort();
    var constants = new SValue[constCount];
    for(var i = 0; i < constCount; ++i){
      switch(src.read()){
        case ConstantType.INTEGER:
          constants[i] = new SNum(src.readInt());
        case ConstantType.FLOAT:
          constants[i] = new SNum(src.readFloat());
        case ConstantType.STRING:
          constants[i] = new SStr(src.readUTF());
      }
    }
    
    var funCount = src.readUnsignedShort();
    var bounds = new HashMap<String, SValue>();
    for(var i = 0; i < constCount; ++i){
      var boundName = ((SStr) constants[src.readUnsignedShort()]).value;
      var locals = src.readUnsignedShort();
      var code = new byte[src.readInt()];
      src.read(code);
      bounds.put(boundName, new SFunctionRef(new Function(parseFunCode(code), locals)));
    }
    
    return new SkcFile(constants, bounds);
  }
  
  private static Opcode[] parseFunCode(byte[] code){
    ArrayList<Opcode> result = new ArrayList<>(code.length);
    for(int index = 0; index < code.length;){
      int arg = 0;
      switch(code[index]){
        case OpcodeType.CALL:
        case OpcodeType.GOTO:
        case OpcodeType.CONST:
        case OpcodeType.LOADGV:
        case OpcodeType.STOREGV:
        case OpcodeType.LOAD:
        case OpcodeType.STORE:
          arg = code[++index] << 8 | code[++index];
          // fallthrough
        default:
          result.add(new Opcode(code[index], arg));
      }
    }
    return result.toArray(new Opcode[0]);
  }
  
}
