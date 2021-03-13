package top.suika.runtime.cli;

import top.suika.runtime.exec.Interpreter;
import top.suika.runtime.parse.SkcParser;

import java.io.File;

public class Main{
  public static void main(String[] args) throws Exception{
    new Interpreter(SkcParser.parse(new File(args[0]))).exec();
  }
}
