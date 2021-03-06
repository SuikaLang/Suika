package top.suika.vm.exec;

public final class Instruction{
  
  public final byte type;
  public final int arg;
  
  public Instruction(byte t, int arg){
    this.type = t;
    this.arg = arg;
  }
  
  public static final class Types{
    public static final byte
        NOPE = 0x00,
        ADD = 0x01,
        SUB = 0x02,
        MUL = 0x03,
        DIV = 0x04,
        MOD = 0x05,
        NEG = 0x06,
        GTR = 0x07,
        LSS = 0x08,
        GEQ = 0x09,
        LEQ = 0x0A,
        AND = 0x0B,
        OR = 0x0C,
        NOT = 0x0D,
        EQ = 0x0E,
        NEQ = 0x0F,
        GOTO = 0x10,
        IF = 0x11,
        CALL = 0x12,
        RET = 0x13,
        POP = 0x14,
        DUPE = 0x15,
        SWAP = 0x16,
        CONST = 0x17,
        CONST_NULL = 0x18,
        CONST_TRUE = 0x19,
        CONST_FALSE = 0x1A,
        LOAD = 0x1B,
        STORE = 0x1C,
        LOADGV = 0x1D,
        STOREGV = 0x1E;
  }
  
}
