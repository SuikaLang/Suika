java -cp ./antlr.jar org.antlr.v4.Tool Suika.g4 -no-listener -visitor -o ../src/main/java/top/suika/compiler/parse
cd..
cd src/main/java/top/suika/compiler/parse
del *.interp
del *.tokens