grammar Suika;

options {
	language = Java;
}

@header{
package top.suika.compiler.parse;
}

chunk: stat* EOF;

funDecl: 'fn' name=Ident '(' args ')' body=(block)
args= Ident? (',' Ident)*;

block: '{' stat* '}';

stat
: expr EOS																																												# ExprStat
| block                                                   																				# BlockStat
| 'var' name=Ident ('=' init=expr)? EOS                    																				# VarDecl
| expr EOS                                                                                        # ExprStat
| 'if' '(' ifc=expr ')' ifb=stat ('elif' '(' elc=expr ')' elb=stat)* ('else' elseb=stat)?         # IfStat
| 'while' '(' cond=expr ')' body=stat                                                             # WhileStat
| 'break' EOS                                                                                     # BreakStat
| 'continue' EOS                                                                                  # ContinueStat
;

atom: Int | Float | Bool | Str | Null;
listLiteral: '[' exprs ']';
mapLiteral: '{' kvPairs '}';
expr
: '(' expr ')'                                              # ParenExpr
| atom 																									    # AtomExpr
| Ident 																		                # IdentExpr
| expr (op='[' index=expr ']')+                             # IndexExpr
| expr (op='.' attr=Ident)+                    						  # AttrExpr
| expr ('(' params=exprs ')')+                              # CallExpr
| (op=('+' | '-' | '!'))* expr                              # UnaryExpr
| expr (op=('*' | '/' | '%') expr)+                         # MulDivModExpr
| expr (op=('+' | '-') expr)+                               # AddSubExpr
| expr (op=('>' | '<' | '>=' | '<=') expr)+                 # RelationExpr
| expr (op='is' expr)+																			# IsExpr
| expr (op=('!=' | '==') expr)+													    # EqualityExpr
| expr (op=('&' | '|') expr)+															  # AndOrExpr
| expr (op='=' expr)+ 										                  # AssignmentExpr
;
exprs: expr? (',' expr)*;
kvPair: key=Ident '=' value=expr;
kvPairs: pair=kvPair? (',' pair=kvPair)*;

structDecl: 'struct' name=Ident '{' (attr=Ident)? (',' attr=Ident)* '}';

Int: [0-9]+;
Float: [0-9]+ '.' [0-9]+;
Bool: 'true' | 'false';
Str: ('"' | '\'') ('\\"' | .)* ('"' | '\'');
Null: 'null';

Ident: [a-zA-Z_$] [a-zA-Z0-9_$]*;

Comment: ('/*' .*? '*/' | '//' ~[\r\n]*) -> skip;

EOS: ';' | '\r' | '\n';

Hidden: ([ \t]+ | '\\' [\r\n]*) -> skip;