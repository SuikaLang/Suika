package top.suika.runtime.util;

public final class Bytes{
  
  private Bytes(){}
  
  public static byte[] int2Bytes(int i){
    return new byte[]{
        (byte) (i>>24 & 0xFF),
        (byte) (i>>16 & 0xFF),
        (byte) (i>>8  & 0xFF),
        (byte) (i     & 0xFF),
    };
  }
  
  public static byte[] long2Bytes(long l){
    return new byte[]{
        (byte) (l>>56 & 0xFF),
        (byte) (l>>48 & 0xFF),
        (byte) (l>>40 & 0xFF),
        (byte) (l>>32 & 0xFF),
        (byte) (l>>24 & 0xFF),
        (byte) (l>>16 & 0xFF),
        (byte) (l>>8  & 0xFF),
        (byte) (l     & 0xFF),
    };
  }
  
  public static byte[] int162Bytes(int i){
    return new byte[]{
        (byte) (i>>8  & 0xFF),
        (byte) (i     & 0xFF),
    };
  }
  
  public static int bytes2Int(byte[] src){
    return (src[0] & 0xFF) << 24
        |  (src[1] & 0xFF) << 16
        |  (src[2] & 0xFF) << 8
        |  (src[3] & 0xFF)
        ;
  }
  
  public static long bytes2Long(byte[] src){
    return ((long) src[0] & 0xFF) << 56
        |  ((long) src[1] & 0xFF) << 48
        |  ((long) src[2] & 0xFF) << 40
        |  ((long) src[3] & 0xFF) << 32
        |  ((long) src[4] & 0xFF) << 24
        |  (       src[5] & 0xFF) << 16
        |  (       src[6] & 0xFF) << 8
        |  (       src[7] & 0xFF)
        ;
  }
  
  public static int bytes2Int16(byte[] src){
    return (src[0] & 0xFF) << 8
        |  (src[1] & 0xFF)
        ;
  }
  
}
