package top.suika.vm.exec;

import top.suika.vm.parse.SkcFile;

import java.util.*;

public class Environment{
  
  private static final HashMap<String, SkcFile> loadedFiles = new HashMap<>();
  private static final HashMap<UUID, Function> functions = new HashMap<>();
  
}
