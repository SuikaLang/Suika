package top.suika.runtime.parse;

import top.suika.runtime.exec.Function;
import top.suika.runtime.exec.Instruction;
import top.suika.runtime.type.*;
import top.suika.runtime.type.SValue;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

public final class SkcParser{
  
  public static SkcFile parse(File f) throws IOException{
    return parse(new DataInputStream(new BufferedInputStream(new FileInputStream(f), 8192)), f.getName());
  }
  
  public static SkcFile parse(byte[] src, String name) throws IOException{
    return parse(new DataInputStream(new ByteArrayInputStream(src)), name);
  }
  
  public static SkcFile parse(InputStream src, String name) throws IOException{
    return parse(new DataInputStream(src), name);
  }
  
  public static SkcFile parse(DataInputStream src, String name) throws IOException{
    if(src.readInt() != 0x73_6B_63_21) return null; // Verify magic number.
    
    int constCount = src.readUnsignedShort();
    SValue[] constants = new SValue[constCount];
    for(int i = 0; i < constCount; ++i){
      switch(src.read()){
        case ConstantTypes.INTEGER:
          constants[i] = new SNum(src.readInt());
        case ConstantTypes.FLOAT:
          constants[i] = new SNum(src.readFloat());
        case ConstantTypes.STRING:
          constants[i] = new SStr(src.readUTF());
      }
    }
    
    int funCount = src.readUnsignedShort();
    Function[] functions = new Function[constCount];
    HashMap<String, SValue> bounds = new HashMap<>();
    for(int i = 0; i < constCount; ++i){
      String boundName = ((SStr) constants[src.readUnsignedShort()]).value;
      int locals = src.readUnsignedShort();
      byte[] code = new byte[src.readInt()];
      src.read(code);
      Function func = new Function(UUID.randomUUID(), parseFunCode(code), locals);
      functions[i] = func;
      bounds.put(boundName, new SFunctionRef(func));
    }
    
    return new SkcFile(name, constants, functions, bounds);
  }
  
  private static Instruction[] parseFunCode(byte[] code){
    ArrayList<Instruction> result = new ArrayList<>(code.length);
    for(int index = 0; index < code.length;){
      int arg = 0;
      switch(code[index]){
        case Instruction.Types.GOTO:
        case Instruction.Types.CONST:
        case Instruction.Types.LOADGV:
        case Instruction.Types.STOREGV:
        case Instruction.Types.LOAD:
        case Instruction.Types.STORE:
          arg = code[++index] << 8 | code[++index];
          // fallthrough
        default:
          result.add(new Instruction(code[index], arg));
      }
    }
    return result.toArray(new Instruction[0]);
  }
  
}
