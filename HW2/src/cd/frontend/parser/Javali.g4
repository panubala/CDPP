grammar Javali; // parser grammar, parses streams of tokens

@header {
	// Java header
	package cd.frontend.parser;
	
}

// PARSER RULES

//* // TODO: declare appropriate parser rules
//* // NOTE: Remove //* from the beginning of each line.
//* 

//unit
//:
//	classDecl EOF
//;

//start : expr EOF;

// program structure 

unit
:
	classDecl
	(
		classDecl
	)* EOF
;

classDecl
:
	'class' Ident
	(
		'extends' Ident
	)? '{' memberList '}'
;

memberList
:
	(
		varDecl
		| methodDecl
	)*
;

varDecl
:
	type Ident
	(
		',' Ident
	)* ';'
;

methodDecl
:
	(
		type
		| 'void'
	) Ident '('
	(
		formalParamList
	)? ')' '{'
	(
		varDecl
	)*
	(
		stmt
	)* '}'
;

formalParamList
:
	type Ident
	(
		',' type Ident
	)*
;

// statements

stmt
:
	assignmentStmt
	| methodCallStmt
	| ifStmt
	| whileStmt
	| returnStmt
	| writeStmt
;

stmtBlock
:
	'{'
	(
		stmt
	)* '}'
;

methodCallStmt
:
	methodCallExpr ';'
;

assignmentStmt
:
	identAccessHead '='
	(
		expr
		| newExpr
		| readExpr
	) ';'
;

writeStmt
:
	(
		'write' '(' expr ')'
		| 'writeln' '(' ')'
	) ';'
;

ifStmt
:
	'if' '(' expr ')' stmtBlock
	(
		'else' stmtBlock
	)?
;

whileStmt
:
	'while' '(' expr ')' stmtBlock
;

returnStmt
:
	'return'
	(
		expr
	)? ';'
;

// expressions

newExpr
:
	'new'
	(
		Ident '(' ')'
		| Ident '[' expr ']'
		| primitiveType '[' expr ']'
	)
;

readExpr
:
	'read' '(' ')'
;

//MethodCallExpr //Original
//:
//	Ident '(' (ActualParamList)? ')'
//	| IdentAccess '.' Ident '(' (ActualParamList)? ')'
//;

methodCallExpr
:
	Ident '('(actualParamList)? ')' #call
	| 'this' '.' identAccessTail #localCall
	| Ident '('(actualParamList)? ')' '.' identAccessTail #refCall
;

actualParamList
:
	expr
	(
		',' expr
	)*
;

//IdentAccess //Original //TODO Überlegungen richtig?
//:
//	Ident
//	| 'this'
//	| IdentAccess'.'Ident		//'this' ist immer am Anfang
//	| IdentAccess '[' expr ']' //[] sind immer am Schluss
//	| MethodCallExpr			//MethodC ist immer am Anfang
//; 

identAccessHead
:
	identAccessTail
	| 'this'
	| 'this' '.' identAccessTail
;

identAccessTail
:
	| Ident
	| Ident '.' identAccessTail
	| Ident '[' expr ']'
	| methodCallExpr
	| methodCallExpr '.' identAccessTail
;

expr
:
	literal  #LITexpr
	| identAccessHead  #IAHexpr
	| '(' expr ')'  #PARexpr
	| '+' expr # POSexpr
	| '-' expr # NEGexpr
	| '!' expr # NOTexpr
	| '(' referenceType ')' expr # CASTexpr
	| expr '*' expr # MULTexpr
	| expr '/' expr # DIVexpr
	| expr '%' expr # MODexpr
	| expr '+' expr # ADDexpr
	| expr '-' expr # SUBexpr
	| expr '<' expr #LESexpr
	| expr '<=' expr #LEQexpr
	| expr '>' expr #GRTexpr
	| expr '>=' expr #GEQexpr
	| expr '==' expr #EQexpr
	| expr '!=' expr #UEQexpr
	| expr '&&' expr #ANDexpr
	| expr '||' expr #ORexpr
;

// LEXER RULES
// TODO: provide appropriate lexer rules for numbers and boolean literals


// Java(li) identifiers:

//Identifier
//:
//	Letter
//	(
//		Letter
//		| Digit
//	)*
//;

fragment
Letter
:
	[a-zA-Z]
;

//'A' .. 'Z'
//	| 'a' .. 'z'

fragment
Digit
:
	[0-9]
;

fragment
HexDigit
:
	Digit
	| [a-f]
	| [A-F]
;

Integer
:
	Hex
	| Decimal
;

fragment
Decimal
:
	'0'
	| [1-9]
	(
		Digit
	)*
;

Hex
:
	(
		'0x'
		| '0X'
	) HexDigit
	(
		HexDigit
	)*
;

Boolean
:
	'false'
	| 'true'
;

Ident
:
	Letter
	(
		Letter
		| Digit
	)*
;

literal
:
	'null' #NULLlit
	| Boolean #BOOLlit
	| Integer #INTlit
;

// types

primitiveType
:
	'boolean'
	| 'int'
;

type
:
	primitiveType
	| referenceType
;

referenceType
:
	Ident
	| arrayType
;

arrayType
:
	Ident '[' ']'
	| primitiveType '[' ']'
;

// comments and white space does not produce tokens:

COMMENT
:
	'/*' .*? '*/' -> skip
;

LINE_COMMENT
:
	'//' ~( '\n' | '\r' )* -> skip
;

WS
:
	(
		' '
		| '\r'
		| '\t'
		| '\n'
	) -> skip
;
