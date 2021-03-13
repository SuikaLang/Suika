package top.suika.runtime.util;

import java.io.IOException;
import java.io.InputStream;

/**
 * Use DataInputStream instead.
 * Modifying this class is not on the schedule
 */
public class HelperInputStream extends InputStream{
  
  private final InputStream source;
  
  public HelperInputStream(InputStream source){
    super();
    this.source = source;
  }
  
  public byte readByte(){
    return (byte) this.read();
  }
  
  public byte[] readBytes(int len){
    byte[] res = new byte[len];
    this.read(res, 0, len);
    return res;
  }
  
  public int readInt(){
    return Bytes.bytes2Int(readBytes(4));
  }
  
  public long readLong(){
    return Bytes.bytes2Long(readBytes(8));
  }
  
  public int readInt16(){
    return Bytes.bytes2Int16(readBytes(2));
  }
  
  public byte[] readAvailable(){
    byte[] res = new byte[this.available()];
    this.read(res, 0, res.length);
    return res;
  }
  
  // inherited from InputStream
  
  @Override
  public int read(){
    try{
      return source.read();
    }catch(IOException e){
      e.printStackTrace();
      return 0;
    }
  }
  
  @Override
  public int read(byte[] b){
    return read(b, 0, b.length);
  }
  
  @Override
  public int read(byte[] b, int off, int len){
    try{
      return source.read(b, off, len);
    }catch(IOException e){
      e.printStackTrace();
      return 0;
    }
  }
  
  @Override
  public long skip(long n){
    try{
      return source.skip(n);
    }catch(IOException e){
      e.printStackTrace();
      return 0;
    }
  }
  
  @Override
  public int available(){
    try{
      return source.available();
    }catch(IOException e){
      e.printStackTrace();
      return 0;
    }
  }
  
  @Override
  public void close(){
    try{
      source.close();
    }catch(IOException e){
      e.printStackTrace();
    }
  }
  
}
