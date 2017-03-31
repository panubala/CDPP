// Generated from /Users/panuyabalasuntharam/Desktop/CDPP/HW2/src/cd/frontend/parser/Javali.g4 by ANTLR 4.4

	// Java header
	package cd.frontend.parser;
	

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class JavaliParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.4", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__38=1, T__37=2, T__36=3, T__35=4, T__34=5, T__33=6, T__32=7, T__31=8, 
		T__30=9, T__29=10, T__28=11, T__27=12, T__26=13, T__25=14, T__24=15, T__23=16, 
		T__22=17, T__21=18, T__20=19, T__19=20, T__18=21, T__17=22, T__16=23, 
		T__15=24, T__14=25, T__13=26, T__12=27, T__11=28, T__10=29, T__9=30, T__8=31, 
		T__7=32, T__6=33, T__5=34, T__4=35, T__3=36, T__2=37, T__1=38, T__0=39, 
		Integer=40, Hex=41, Boolean=42, Ident=43, COMMENT=44, LINE_COMMENT=45, 
		WS=46;
	public static final String[] tokenNames = {
		"<INVALID>", "'/'", "'new'", "'return'", "'!='", "'class'", "'||'", "'while'", 
		"'void'", "';'", "'{'", "'&&'", "'='", "'}'", "'extends'", "'if'", "'<='", 
		"'int'", "'null'", "'('", "'*'", "'this'", "','", "'.'", "'boolean'", 
		"'write'", "'>='", "'['", "'writeln'", "'=='", "'<'", "']'", "'>'", "'!'", 
		"'%'", "'read'", "'else'", "')'", "'+'", "'-'", "Integer", "Hex", "Boolean", 
		"Ident", "COMMENT", "LINE_COMMENT", "WS"
	};
	public static final int
		RULE_unit = 0, RULE_classDecl = 1, RULE_memberList = 2, RULE_varDecl = 3, 
		RULE_methodDecl = 4, RULE_formalParamList = 5, RULE_stmt = 6, RULE_stmtBlock = 7, 
		RULE_methodCallStmt = 8, RULE_assignmentStmt = 9, RULE_writeStmt = 10, 
		RULE_ifStmt = 11, RULE_whileStmt = 12, RULE_returnStmt = 13, RULE_newExpr = 14, 
		RULE_readExpr = 15, RULE_actualParamList = 16, RULE_identAccess = 17, 
		RULE_expr = 18, RULE_literal = 19, RULE_type = 20, RULE_primitiveType = 21, 
		RULE_referenceType = 22, RULE_arrayType = 23;
	public static final String[] ruleNames = {
		"unit", "classDecl", "memberList", "varDecl", "methodDecl", "formalParamList", 
		"stmt", "stmtBlock", "methodCallStmt", "assignmentStmt", "writeStmt", 
		"ifStmt", "whileStmt", "returnStmt", "newExpr", "readExpr", "actualParamList", 
		"identAccess", "expr", "literal", "type", "primitiveType", "referenceType", 
		"arrayType"
	};

	@Override
	public String getGrammarFileName() { return "Javali.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public JavaliParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class UnitContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(JavaliParser.EOF, 0); }
		public ClassDeclContext classDecl(int i) {
			return getRuleContext(ClassDeclContext.class,i);
		}
		public List<ClassDeclContext> classDecl() {
			return getRuleContexts(ClassDeclContext.class);
		}
		public UnitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unit; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaliVisitor ) return ((JavaliVisitor<? extends T>)visitor).visitUnit(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UnitContext unit() throws RecognitionException {
		UnitContext _localctx = new UnitContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_unit);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(48); classDecl();
			setState(52);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__34) {
				{
				{
				setState(49); classDecl();
				}
				}
				setState(54);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(55); match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ClassDeclContext extends ParserRuleContext {
		public List<TerminalNode> Ident() { return getTokens(JavaliParser.Ident); }
		public TerminalNode Ident(int i) {
			return getToken(JavaliParser.Ident, i);
		}
		public MemberListContext memberList() {
			return getRuleContext(MemberListContext.class,0);
		}
		public ClassDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classDecl; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaliVisitor ) return ((JavaliVisitor<? extends T>)visitor).visitClassDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassDeclContext classDecl() throws RecognitionException {
		ClassDeclContext _localctx = new ClassDeclContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_classDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(57); match(T__34);
			setState(58); match(Ident);
			setState(61);
			_la = _input.LA(1);
			if (_la==T__25) {
				{
				setState(59); match(T__25);
				setState(60); match(Ident);
				}
			}

			setState(63); match(T__29);
			setState(64); memberList();
			setState(65); match(T__26);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MemberListContext extends ParserRuleContext {
		public List<MethodDeclContext> methodDecl() {
			return getRuleContexts(MethodDeclContext.class);
		}
		public VarDeclContext varDecl(int i) {
			return getRuleContext(VarDeclContext.class,i);
		}
		public List<VarDeclContext> varDecl() {
			return getRuleContexts(VarDeclContext.class);
		}
		public MethodDeclContext methodDecl(int i) {
			return getRuleContext(MethodDeclContext.class,i);
		}
		public MemberListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_memberList; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaliVisitor ) return ((JavaliVisitor<? extends T>)visitor).visitMemberList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MemberListContext memberList() throws RecognitionException {
		MemberListContext _localctx = new MemberListContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_memberList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(71);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__31) | (1L << T__22) | (1L << T__15) | (1L << Ident))) != 0)) {
				{
				setState(69);
				switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
				case 1:
					{
					setState(67); varDecl();
					}
					break;
				case 2:
					{
					setState(68); methodDecl();
					}
					break;
				}
				}
				setState(73);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VarDeclContext extends ParserRuleContext {
		public List<TerminalNode> Ident() { return getTokens(JavaliParser.Ident); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode Ident(int i) {
			return getToken(JavaliParser.Ident, i);
		}
		public VarDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varDecl; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaliVisitor ) return ((JavaliVisitor<? extends T>)visitor).visitVarDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarDeclContext varDecl() throws RecognitionException {
		VarDeclContext _localctx = new VarDeclContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_varDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(74); type();
			setState(75); match(Ident);
			setState(80);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__17) {
				{
				{
				setState(76); match(T__17);
				setState(77); match(Ident);
				}
				}
				setState(82);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(83); match(T__30);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MethodDeclContext extends ParserRuleContext {
		public TerminalNode Ident() { return getToken(JavaliParser.Ident, 0); }
		public VarDeclContext varDecl(int i) {
			return getRuleContext(VarDeclContext.class,i);
		}
		public List<VarDeclContext> varDecl() {
			return getRuleContexts(VarDeclContext.class);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public FormalParamListContext formalParamList() {
			return getRuleContext(FormalParamListContext.class,0);
		}
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public MethodDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodDecl; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaliVisitor ) return ((JavaliVisitor<? extends T>)visitor).visitMethodDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MethodDeclContext methodDecl() throws RecognitionException {
		MethodDeclContext _localctx = new MethodDeclContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_methodDecl);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(87);
			switch (_input.LA(1)) {
			case T__22:
			case T__15:
			case Ident:
				{
				setState(85); type();
				}
				break;
			case T__31:
				{
				setState(86); match(T__31);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(89); match(Ident);
			setState(90); match(T__20);
			setState(92);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__22) | (1L << T__15) | (1L << Ident))) != 0)) {
				{
				setState(91); formalParamList();
				}
			}

			setState(94); match(T__2);
			setState(95); match(T__29);
			setState(99);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(96); varDecl();
					}
					} 
				}
				setState(101);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			}
			setState(105);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__36) | (1L << T__32) | (1L << T__24) | (1L << T__18) | (1L << T__14) | (1L << T__11) | (1L << Ident))) != 0)) {
				{
				{
				setState(102); stmt();
				}
				}
				setState(107);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(108); match(T__26);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FormalParamListContext extends ParserRuleContext {
		public List<TerminalNode> Ident() { return getTokens(JavaliParser.Ident); }
		public TypeContext type(int i) {
			return getRuleContext(TypeContext.class,i);
		}
		public List<TypeContext> type() {
			return getRuleContexts(TypeContext.class);
		}
		public TerminalNode Ident(int i) {
			return getToken(JavaliParser.Ident, i);
		}
		public FormalParamListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_formalParamList; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaliVisitor ) return ((JavaliVisitor<? extends T>)visitor).visitFormalParamList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FormalParamListContext formalParamList() throws RecognitionException {
		FormalParamListContext _localctx = new FormalParamListContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_formalParamList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(110); type();
			setState(111); match(Ident);
			setState(118);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__17) {
				{
				{
				setState(112); match(T__17);
				setState(113); type();
				setState(114); match(Ident);
				}
				}
				setState(120);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StmtContext extends ParserRuleContext {
		public StmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stmt; }
	 
		public StmtContext() { }
		public void copyFrom(StmtContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class StmtReturnContext extends StmtContext {
		public ReturnStmtContext returnStmt() {
			return getRuleContext(ReturnStmtContext.class,0);
		}
		public StmtReturnContext(StmtContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaliVisitor ) return ((JavaliVisitor<? extends T>)visitor).visitStmtReturn(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StmtMethodContext extends StmtContext {
		public MethodCallStmtContext methodCallStmt() {
			return getRuleContext(MethodCallStmtContext.class,0);
		}
		public StmtMethodContext(StmtContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaliVisitor ) return ((JavaliVisitor<? extends T>)visitor).visitStmtMethod(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StmtWriteContext extends StmtContext {
		public WriteStmtContext writeStmt() {
			return getRuleContext(WriteStmtContext.class,0);
		}
		public StmtWriteContext(StmtContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaliVisitor ) return ((JavaliVisitor<? extends T>)visitor).visitStmtWrite(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StmtAssignContext extends StmtContext {
		public AssignmentStmtContext assignmentStmt() {
			return getRuleContext(AssignmentStmtContext.class,0);
		}
		public StmtAssignContext(StmtContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaliVisitor ) return ((JavaliVisitor<? extends T>)visitor).visitStmtAssign(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StmtIfContext extends StmtContext {
		public IfStmtContext ifStmt() {
			return getRuleContext(IfStmtContext.class,0);
		}
		public WhileStmtContext whileStmt() {
			return getRuleContext(WhileStmtContext.class,0);
		}
		public StmtIfContext(StmtContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaliVisitor ) return ((JavaliVisitor<? extends T>)visitor).visitStmtIf(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StmtContext stmt() throws RecognitionException {
		StmtContext _localctx = new StmtContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_stmt);
		try {
			setState(127);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				_localctx = new StmtAssignContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(121); assignmentStmt();
				}
				break;
			case 2:
				_localctx = new StmtMethodContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(122); methodCallStmt();
				}
				break;
			case 3:
				_localctx = new StmtIfContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(123); ifStmt();
				}
				break;
			case 4:
				_localctx = new StmtIfContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(124); whileStmt();
				}
				break;
			case 5:
				_localctx = new StmtReturnContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(125); returnStmt();
				}
				break;
			case 6:
				_localctx = new StmtWriteContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(126); writeStmt();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StmtBlockContext extends ParserRuleContext {
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public StmtBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stmtBlock; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaliVisitor ) return ((JavaliVisitor<? extends T>)visitor).visitStmtBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StmtBlockContext stmtBlock() throws RecognitionException {
		StmtBlockContext _localctx = new StmtBlockContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_stmtBlock);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(129); match(T__29);
			setState(133);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__36) | (1L << T__32) | (1L << T__24) | (1L << T__18) | (1L << T__14) | (1L << T__11) | (1L << Ident))) != 0)) {
				{
				{
				setState(130); stmt();
				}
				}
				setState(135);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(136); match(T__26);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MethodCallStmtContext extends ParserRuleContext {
		public TerminalNode Ident() { return getToken(JavaliParser.Ident, 0); }
		public ActualParamListContext actualParamList() {
			return getRuleContext(ActualParamListContext.class,0);
		}
		public IdentAccessContext identAccess() {
			return getRuleContext(IdentAccessContext.class,0);
		}
		public MethodCallStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodCallStmt; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaliVisitor ) return ((JavaliVisitor<? extends T>)visitor).visitMethodCallStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MethodCallStmtContext methodCallStmt() throws RecognitionException {
		MethodCallStmtContext _localctx = new MethodCallStmtContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_methodCallStmt);
		int _la;
		try {
			setState(153);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(138); match(Ident);
				setState(139); match(T__20);
				setState(141);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__21) | (1L << T__20) | (1L << T__18) | (1L << T__6) | (1L << T__1) | (1L << T__0) | (1L << Integer) | (1L << Boolean) | (1L << Ident))) != 0)) {
					{
					setState(140); actualParamList();
					}
				}

				setState(143); match(T__2);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(144); identAccess(0);
				setState(145); match(T__16);
				setState(146); match(Ident);
				setState(147); match(T__20);
				setState(149);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__21) | (1L << T__20) | (1L << T__18) | (1L << T__6) | (1L << T__1) | (1L << T__0) | (1L << Integer) | (1L << Boolean) | (1L << Ident))) != 0)) {
					{
					setState(148); actualParamList();
					}
				}

				setState(151); match(T__2);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AssignmentStmtContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public NewExprContext newExpr() {
			return getRuleContext(NewExprContext.class,0);
		}
		public ReadExprContext readExpr() {
			return getRuleContext(ReadExprContext.class,0);
		}
		public IdentAccessContext identAccess() {
			return getRuleContext(IdentAccessContext.class,0);
		}
		public AssignmentStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignmentStmt; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaliVisitor ) return ((JavaliVisitor<? extends T>)visitor).visitAssignmentStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignmentStmtContext assignmentStmt() throws RecognitionException {
		AssignmentStmtContext _localctx = new AssignmentStmtContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_assignmentStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(155); identAccess(0);
			setState(156); match(T__27);
			setState(160);
			switch (_input.LA(1)) {
			case T__21:
			case T__20:
			case T__18:
			case T__6:
			case T__1:
			case T__0:
			case Integer:
			case Boolean:
			case Ident:
				{
				setState(157); expr(0);
				}
				break;
			case T__37:
				{
				setState(158); newExpr();
				}
				break;
			case T__4:
				{
				setState(159); readExpr();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(162); match(T__30);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class WriteStmtContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public WriteStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_writeStmt; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaliVisitor ) return ((JavaliVisitor<? extends T>)visitor).visitWriteStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WriteStmtContext writeStmt() throws RecognitionException {
		WriteStmtContext _localctx = new WriteStmtContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_writeStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(172);
			switch (_input.LA(1)) {
			case T__14:
				{
				setState(164); match(T__14);
				setState(165); match(T__20);
				setState(166); expr(0);
				setState(167); match(T__2);
				}
				break;
			case T__11:
				{
				setState(169); match(T__11);
				setState(170); match(T__20);
				setState(171); match(T__2);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(174); match(T__30);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IfStmtContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public List<StmtBlockContext> stmtBlock() {
			return getRuleContexts(StmtBlockContext.class);
		}
		public StmtBlockContext stmtBlock(int i) {
			return getRuleContext(StmtBlockContext.class,i);
		}
		public IfStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifStmt; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaliVisitor ) return ((JavaliVisitor<? extends T>)visitor).visitIfStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfStmtContext ifStmt() throws RecognitionException {
		IfStmtContext _localctx = new IfStmtContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_ifStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(176); match(T__24);
			setState(177); match(T__20);
			setState(178); expr(0);
			setState(179); match(T__2);
			setState(180); stmtBlock();
			setState(183);
			_la = _input.LA(1);
			if (_la==T__3) {
				{
				setState(181); match(T__3);
				setState(182); stmtBlock();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class WhileStmtContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public StmtBlockContext stmtBlock() {
			return getRuleContext(StmtBlockContext.class,0);
		}
		public WhileStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whileStmt; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaliVisitor ) return ((JavaliVisitor<? extends T>)visitor).visitWhileStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WhileStmtContext whileStmt() throws RecognitionException {
		WhileStmtContext _localctx = new WhileStmtContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_whileStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(185); match(T__32);
			setState(186); match(T__20);
			setState(187); expr(0);
			setState(188); match(T__2);
			setState(189); stmtBlock();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ReturnStmtContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ReturnStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnStmt; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaliVisitor ) return ((JavaliVisitor<? extends T>)visitor).visitReturnStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReturnStmtContext returnStmt() throws RecognitionException {
		ReturnStmtContext _localctx = new ReturnStmtContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_returnStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(191); match(T__36);
			setState(193);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__21) | (1L << T__20) | (1L << T__18) | (1L << T__6) | (1L << T__1) | (1L << T__0) | (1L << Integer) | (1L << Boolean) | (1L << Ident))) != 0)) {
				{
				setState(192); expr(0);
				}
			}

			setState(195); match(T__30);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NewExprContext extends ParserRuleContext {
		public NewExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_newExpr; }
	 
		public NewExprContext() { }
		public void copyFrom(NewExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class NewMethodContext extends NewExprContext {
		public TerminalNode Ident() { return getToken(JavaliParser.Ident, 0); }
		public NewMethodContext(NewExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaliVisitor ) return ((JavaliVisitor<? extends T>)visitor).visitNewMethod(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NewArrayContext extends NewExprContext {
		public TerminalNode Ident() { return getToken(JavaliParser.Ident, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public NewArrayContext(NewExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaliVisitor ) return ((JavaliVisitor<? extends T>)visitor).visitNewArray(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NewTypeContext extends NewExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public PrimitiveTypeContext primitiveType() {
			return getRuleContext(PrimitiveTypeContext.class,0);
		}
		public NewTypeContext(NewExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaliVisitor ) return ((JavaliVisitor<? extends T>)visitor).visitNewType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NewExprContext newExpr() throws RecognitionException {
		NewExprContext _localctx = new NewExprContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_newExpr);
		try {
			setState(213);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				_localctx = new NewMethodContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(197); match(T__37);
				setState(198); match(Ident);
				setState(199); match(T__20);
				setState(200); match(T__2);
				}
				break;
			case 2:
				_localctx = new NewArrayContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(201); match(T__37);
				setState(202); match(Ident);
				setState(203); match(T__12);
				setState(204); expr(0);
				setState(205); match(T__8);
				}
				break;
			case 3:
				_localctx = new NewTypeContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(207); match(T__37);
				setState(208); primitiveType();
				setState(209); match(T__12);
				setState(210); expr(0);
				setState(211); match(T__8);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ReadExprContext extends ParserRuleContext {
		public ReadExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_readExpr; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaliVisitor ) return ((JavaliVisitor<? extends T>)visitor).visitReadExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReadExprContext readExpr() throws RecognitionException {
		ReadExprContext _localctx = new ReadExprContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_readExpr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(215); match(T__4);
			setState(216); match(T__20);
			setState(217); match(T__2);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ActualParamListContext extends ParserRuleContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public ActualParamListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_actualParamList; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaliVisitor ) return ((JavaliVisitor<? extends T>)visitor).visitActualParamList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ActualParamListContext actualParamList() throws RecognitionException {
		ActualParamListContext _localctx = new ActualParamListContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_actualParamList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(219); expr(0);
			setState(224);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__17) {
				{
				{
				setState(220); match(T__17);
				setState(221); expr(0);
				}
				}
				setState(226);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IdentAccessContext extends ParserRuleContext {
		public IdentAccessContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identAccess; }
	 
		public IdentAccessContext() { }
		public void copyFrom(IdentAccessContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class IdentThisContext extends IdentAccessContext {
		public IdentThisContext(IdentAccessContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaliVisitor ) return ((JavaliVisitor<? extends T>)visitor).visitIdentThis(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IdentMethodContext extends IdentAccessContext {
		public TerminalNode Ident() { return getToken(JavaliParser.Ident, 0); }
		public ActualParamListContext actualParamList() {
			return getRuleContext(ActualParamListContext.class,0);
		}
		public IdentMethodContext(IdentAccessContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaliVisitor ) return ((JavaliVisitor<? extends T>)visitor).visitIdentMethod(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IdentFieldContext extends IdentAccessContext {
		public TerminalNode Ident() { return getToken(JavaliParser.Ident, 0); }
		public IdentAccessContext identAccess() {
			return getRuleContext(IdentAccessContext.class,0);
		}
		public IdentFieldContext(IdentAccessContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaliVisitor ) return ((JavaliVisitor<? extends T>)visitor).visitIdentField(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IdentMethodFieldContext extends IdentAccessContext {
		public TerminalNode Ident() { return getToken(JavaliParser.Ident, 0); }
		public ActualParamListContext actualParamList() {
			return getRuleContext(ActualParamListContext.class,0);
		}
		public IdentAccessContext identAccess() {
			return getRuleContext(IdentAccessContext.class,0);
		}
		public IdentMethodFieldContext(IdentAccessContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaliVisitor ) return ((JavaliVisitor<? extends T>)visitor).visitIdentMethodField(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IdentArrayContext extends IdentAccessContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public IdentAccessContext identAccess() {
			return getRuleContext(IdentAccessContext.class,0);
		}
		public IdentArrayContext(IdentAccessContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaliVisitor ) return ((JavaliVisitor<? extends T>)visitor).visitIdentArray(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IdentIdentContext extends IdentAccessContext {
		public TerminalNode Ident() { return getToken(JavaliParser.Ident, 0); }
		public IdentIdentContext(IdentAccessContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaliVisitor ) return ((JavaliVisitor<? extends T>)visitor).visitIdentIdent(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IdentAccessContext identAccess() throws RecognitionException {
		return identAccess(0);
	}

	private IdentAccessContext identAccess(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		IdentAccessContext _localctx = new IdentAccessContext(_ctx, _parentState);
		IdentAccessContext _prevctx = _localctx;
		int _startState = 34;
		enterRecursionRule(_localctx, 34, RULE_identAccess, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(236);
			switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
			case 1:
				{
				_localctx = new IdentIdentContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(228); match(Ident);
				}
				break;
			case 2:
				{
				_localctx = new IdentThisContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(229); match(T__18);
				}
				break;
			case 3:
				{
				_localctx = new IdentMethodContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(230); match(Ident);
				setState(231); match(T__20);
				setState(233);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__21) | (1L << T__20) | (1L << T__18) | (1L << T__6) | (1L << T__1) | (1L << T__0) | (1L << Integer) | (1L << Boolean) | (1L << Ident))) != 0)) {
					{
					setState(232); actualParamList();
					}
				}

				setState(235); match(T__2);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(256);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(254);
					switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
					case 1:
						{
						_localctx = new IdentFieldContext(new IdentAccessContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_identAccess);
						setState(238);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(239); match(T__16);
						setState(240); match(Ident);
						}
						break;
					case 2:
						{
						_localctx = new IdentArrayContext(new IdentAccessContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_identAccess);
						setState(241);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(242); match(T__12);
						setState(243); expr(0);
						setState(244); match(T__8);
						}
						break;
					case 3:
						{
						_localctx = new IdentMethodFieldContext(new IdentAccessContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_identAccess);
						setState(246);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(247); match(T__16);
						setState(248); match(Ident);
						setState(249); match(T__20);
						setState(251);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__21) | (1L << T__20) | (1L << T__18) | (1L << T__6) | (1L << T__1) | (1L << T__0) | (1L << Integer) | (1L << Boolean) | (1L << Ident))) != 0)) {
							{
							setState(250); actualParamList();
							}
						}

						setState(253); match(T__2);
						}
						break;
					}
					} 
				}
				setState(258);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class ExprContext extends ParserRuleContext {
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	 
		public ExprContext() { }
		public void copyFrom(ExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class CASTexprContext extends ExprContext {
		public ReferenceTypeContext referenceType() {
			return getRuleContext(ReferenceTypeContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public CASTexprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaliVisitor ) return ((JavaliVisitor<? extends T>)visitor).visitCASTexpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class EQexprContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public EQexprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaliVisitor ) return ((JavaliVisitor<? extends T>)visitor).visitEQexpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DIVexprContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public DIVexprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaliVisitor ) return ((JavaliVisitor<? extends T>)visitor).visitDIVexpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class UEQexprContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public UEQexprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaliVisitor ) return ((JavaliVisitor<? extends T>)visitor).visitUEQexpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PARexprContext extends ExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public PARexprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaliVisitor ) return ((JavaliVisitor<? extends T>)visitor).visitPARexpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class GRTexprContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public GRTexprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaliVisitor ) return ((JavaliVisitor<? extends T>)visitor).visitGRTexpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class POSexprContext extends ExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public POSexprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaliVisitor ) return ((JavaliVisitor<? extends T>)visitor).visitPOSexpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MODexprContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public MODexprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaliVisitor ) return ((JavaliVisitor<? extends T>)visitor).visitMODexpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NOTexprContext extends ExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public NOTexprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaliVisitor ) return ((JavaliVisitor<? extends T>)visitor).visitNOTexpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MULTexprContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public MULTexprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaliVisitor ) return ((JavaliVisitor<? extends T>)visitor).visitMULTexpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LEQexprContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public LEQexprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaliVisitor ) return ((JavaliVisitor<? extends T>)visitor).visitLEQexpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ANDexprContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public ANDexprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaliVisitor ) return ((JavaliVisitor<? extends T>)visitor).visitANDexpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class GEQexprContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public GEQexprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaliVisitor ) return ((JavaliVisitor<? extends T>)visitor).visitGEQexpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LITexprContext extends ExprContext {
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public LITexprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaliVisitor ) return ((JavaliVisitor<? extends T>)visitor).visitLITexpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LESexprContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public LESexprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaliVisitor ) return ((JavaliVisitor<? extends T>)visitor).visitLESexpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SUBexprContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public SUBexprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaliVisitor ) return ((JavaliVisitor<? extends T>)visitor).visitSUBexpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NEGexprContext extends ExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public NEGexprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaliVisitor ) return ((JavaliVisitor<? extends T>)visitor).visitNEGexpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ADDexprContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public ADDexprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaliVisitor ) return ((JavaliVisitor<? extends T>)visitor).visitADDexpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ORexprContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public ORexprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaliVisitor ) return ((JavaliVisitor<? extends T>)visitor).visitORexpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IAHexprContext extends ExprContext {
		public IdentAccessContext identAccess() {
			return getRuleContext(IdentAccessContext.class,0);
		}
		public IAHexprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaliVisitor ) return ((JavaliVisitor<? extends T>)visitor).visitIAHexpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 36;
		enterRecursionRule(_localctx, 36, RULE_expr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(277);
			switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
			case 1:
				{
				_localctx = new POSexprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(260); match(T__1);
				setState(261); expr(17);
				}
				break;
			case 2:
				{
				_localctx = new NEGexprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(262); match(T__0);
				setState(263); expr(16);
				}
				break;
			case 3:
				{
				_localctx = new NOTexprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(264); match(T__6);
				setState(265); expr(15);
				}
				break;
			case 4:
				{
				_localctx = new CASTexprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(266); match(T__20);
				setState(267); referenceType();
				setState(268); match(T__2);
				setState(269); expr(14);
				}
				break;
			case 5:
				{
				_localctx = new LITexprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(271); literal();
				}
				break;
			case 6:
				{
				_localctx = new IAHexprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(272); identAccess(0);
				}
				break;
			case 7:
				{
				_localctx = new PARexprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(273); match(T__20);
				setState(274); expr(0);
				setState(275); match(T__2);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(320);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,28,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(318);
					switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
					case 1:
						{
						_localctx = new MULTexprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(279);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(280); match(T__19);
						setState(281); expr(14);
						}
						break;
					case 2:
						{
						_localctx = new DIVexprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(282);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(283); match(T__38);
						setState(284); expr(13);
						}
						break;
					case 3:
						{
						_localctx = new MODexprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(285);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(286); match(T__5);
						setState(287); expr(12);
						}
						break;
					case 4:
						{
						_localctx = new ADDexprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(288);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(289); match(T__1);
						setState(290); expr(11);
						}
						break;
					case 5:
						{
						_localctx = new SUBexprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(291);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(292); match(T__0);
						setState(293); expr(10);
						}
						break;
					case 6:
						{
						_localctx = new LESexprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(294);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(295); match(T__9);
						setState(296); expr(9);
						}
						break;
					case 7:
						{
						_localctx = new LEQexprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(297);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(298); match(T__23);
						setState(299); expr(8);
						}
						break;
					case 8:
						{
						_localctx = new GRTexprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(300);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(301); match(T__7);
						setState(302); expr(7);
						}
						break;
					case 9:
						{
						_localctx = new GEQexprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(303);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(304); match(T__13);
						setState(305); expr(6);
						}
						break;
					case 10:
						{
						_localctx = new EQexprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(306);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(307); match(T__10);
						setState(308); expr(5);
						}
						break;
					case 11:
						{
						_localctx = new UEQexprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(309);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(310); match(T__35);
						setState(311); expr(4);
						}
						break;
					case 12:
						{
						_localctx = new ANDexprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(312);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(313); match(T__28);
						setState(314); expr(3);
						}
						break;
					case 13:
						{
						_localctx = new ORexprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(315);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(316); match(T__33);
						setState(317); expr(2);
						}
						break;
					}
					} 
				}
				setState(322);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,28,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class LiteralContext extends ParserRuleContext {
		public LiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literal; }
	 
		public LiteralContext() { }
		public void copyFrom(LiteralContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class NULLlitContext extends LiteralContext {
		public NULLlitContext(LiteralContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaliVisitor ) return ((JavaliVisitor<? extends T>)visitor).visitNULLlit(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BOOLlitContext extends LiteralContext {
		public TerminalNode Boolean() { return getToken(JavaliParser.Boolean, 0); }
		public BOOLlitContext(LiteralContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaliVisitor ) return ((JavaliVisitor<? extends T>)visitor).visitBOOLlit(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class INTlitContext extends LiteralContext {
		public TerminalNode Integer() { return getToken(JavaliParser.Integer, 0); }
		public INTlitContext(LiteralContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaliVisitor ) return ((JavaliVisitor<? extends T>)visitor).visitINTlit(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LiteralContext literal() throws RecognitionException {
		LiteralContext _localctx = new LiteralContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_literal);
		try {
			setState(326);
			switch (_input.LA(1)) {
			case T__21:
				_localctx = new NULLlitContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(323); match(T__21);
				}
				break;
			case Boolean:
				_localctx = new BOOLlitContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(324); match(Boolean);
				}
				break;
			case Integer:
				_localctx = new INTlitContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(325); match(Integer);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeContext extends ParserRuleContext {
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
	 
		public TypeContext() { }
		public void copyFrom(TypeContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class RefTypeContext extends TypeContext {
		public ReferenceTypeContext referenceType() {
			return getRuleContext(ReferenceTypeContext.class,0);
		}
		public RefTypeContext(TypeContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaliVisitor ) return ((JavaliVisitor<? extends T>)visitor).visitRefType(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PrimTypeContext extends TypeContext {
		public PrimitiveTypeContext primitiveType() {
			return getRuleContext(PrimitiveTypeContext.class,0);
		}
		public PrimTypeContext(TypeContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaliVisitor ) return ((JavaliVisitor<? extends T>)visitor).visitPrimType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_type);
		try {
			setState(330);
			switch ( getInterpreter().adaptivePredict(_input,30,_ctx) ) {
			case 1:
				_localctx = new PrimTypeContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(328); primitiveType();
				}
				break;
			case 2:
				_localctx = new RefTypeContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(329); referenceType();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PrimitiveTypeContext extends ParserRuleContext {
		public PrimitiveTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primitiveType; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaliVisitor ) return ((JavaliVisitor<? extends T>)visitor).visitPrimitiveType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrimitiveTypeContext primitiveType() throws RecognitionException {
		PrimitiveTypeContext _localctx = new PrimitiveTypeContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_primitiveType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(332);
			_la = _input.LA(1);
			if ( !(_la==T__22 || _la==T__15) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ReferenceTypeContext extends ParserRuleContext {
		public ReferenceTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_referenceType; }
	 
		public ReferenceTypeContext() { }
		public void copyFrom(ReferenceTypeContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ReferenceTypeIdentContext extends ReferenceTypeContext {
		public TerminalNode Ident() { return getToken(JavaliParser.Ident, 0); }
		public ReferenceTypeIdentContext(ReferenceTypeContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaliVisitor ) return ((JavaliVisitor<? extends T>)visitor).visitReferenceTypeIdent(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ReferenceTypeArrayContext extends ReferenceTypeContext {
		public ArrayTypeContext arrayType() {
			return getRuleContext(ArrayTypeContext.class,0);
		}
		public ReferenceTypeArrayContext(ReferenceTypeContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaliVisitor ) return ((JavaliVisitor<? extends T>)visitor).visitReferenceTypeArray(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReferenceTypeContext referenceType() throws RecognitionException {
		ReferenceTypeContext _localctx = new ReferenceTypeContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_referenceType);
		try {
			setState(336);
			switch ( getInterpreter().adaptivePredict(_input,31,_ctx) ) {
			case 1:
				_localctx = new ReferenceTypeIdentContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(334); match(Ident);
				}
				break;
			case 2:
				_localctx = new ReferenceTypeArrayContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(335); arrayType();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArrayTypeContext extends ParserRuleContext {
		public ArrayTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayType; }
	 
		public ArrayTypeContext() { }
		public void copyFrom(ArrayTypeContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ArrayTypeIdentContext extends ArrayTypeContext {
		public TerminalNode Ident() { return getToken(JavaliParser.Ident, 0); }
		public ArrayTypeIdentContext(ArrayTypeContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaliVisitor ) return ((JavaliVisitor<? extends T>)visitor).visitArrayTypeIdent(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ArrayTypePrimitiveContext extends ArrayTypeContext {
		public PrimitiveTypeContext primitiveType() {
			return getRuleContext(PrimitiveTypeContext.class,0);
		}
		public ArrayTypePrimitiveContext(ArrayTypeContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaliVisitor ) return ((JavaliVisitor<? extends T>)visitor).visitArrayTypePrimitive(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArrayTypeContext arrayType() throws RecognitionException {
		ArrayTypeContext _localctx = new ArrayTypeContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_arrayType);
		try {
			setState(345);
			switch (_input.LA(1)) {
			case Ident:
				_localctx = new ArrayTypeIdentContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(338); match(Ident);
				setState(339); match(T__12);
				setState(340); match(T__8);
				}
				break;
			case T__22:
			case T__15:
				_localctx = new ArrayTypePrimitiveContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(341); primitiveType();
				setState(342); match(T__12);
				setState(343); match(T__8);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 17: return identAccess_sempred((IdentAccessContext)_localctx, predIndex);
		case 18: return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean identAccess_sempred(IdentAccessContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0: return precpred(_ctx, 4);
		case 1: return precpred(_ctx, 3);
		case 2: return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 3: return precpred(_ctx, 13);
		case 4: return precpred(_ctx, 12);
		case 5: return precpred(_ctx, 11);
		case 6: return precpred(_ctx, 10);
		case 7: return precpred(_ctx, 9);
		case 8: return precpred(_ctx, 8);
		case 9: return precpred(_ctx, 7);
		case 10: return precpred(_ctx, 6);
		case 11: return precpred(_ctx, 5);
		case 12: return precpred(_ctx, 4);
		case 13: return precpred(_ctx, 3);
		case 14: return precpred(_ctx, 2);
		case 15: return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\60\u015e\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\3\2\3\2\7\2\65\n\2\f\2\16\28\13\2\3\2\3\2\3\3\3\3\3\3\3\3\5\3@\n\3\3"+
		"\3\3\3\3\3\3\3\3\4\3\4\7\4H\n\4\f\4\16\4K\13\4\3\5\3\5\3\5\3\5\7\5Q\n"+
		"\5\f\5\16\5T\13\5\3\5\3\5\3\6\3\6\5\6Z\n\6\3\6\3\6\3\6\5\6_\n\6\3\6\3"+
		"\6\3\6\7\6d\n\6\f\6\16\6g\13\6\3\6\7\6j\n\6\f\6\16\6m\13\6\3\6\3\6\3\7"+
		"\3\7\3\7\3\7\3\7\3\7\7\7w\n\7\f\7\16\7z\13\7\3\b\3\b\3\b\3\b\3\b\3\b\5"+
		"\b\u0082\n\b\3\t\3\t\7\t\u0086\n\t\f\t\16\t\u0089\13\t\3\t\3\t\3\n\3\n"+
		"\3\n\5\n\u0090\n\n\3\n\3\n\3\n\3\n\3\n\3\n\5\n\u0098\n\n\3\n\3\n\5\n\u009c"+
		"\n\n\3\13\3\13\3\13\3\13\3\13\5\13\u00a3\n\13\3\13\3\13\3\f\3\f\3\f\3"+
		"\f\3\f\3\f\3\f\3\f\5\f\u00af\n\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\5"+
		"\r\u00ba\n\r\3\16\3\16\3\16\3\16\3\16\3\16\3\17\3\17\5\17\u00c4\n\17\3"+
		"\17\3\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3"+
		"\20\3\20\3\20\3\20\5\20\u00d8\n\20\3\21\3\21\3\21\3\21\3\22\3\22\3\22"+
		"\7\22\u00e1\n\22\f\22\16\22\u00e4\13\22\3\23\3\23\3\23\3\23\3\23\3\23"+
		"\5\23\u00ec\n\23\3\23\5\23\u00ef\n\23\3\23\3\23\3\23\3\23\3\23\3\23\3"+
		"\23\3\23\3\23\3\23\3\23\3\23\3\23\5\23\u00fe\n\23\3\23\7\23\u0101\n\23"+
		"\f\23\16\23\u0104\13\23\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3"+
		"\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\5\24\u0118\n\24\3\24\3\24"+
		"\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24"+
		"\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24"+
		"\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\7\24\u0141\n\24\f\24\16"+
		"\24\u0144\13\24\3\25\3\25\3\25\5\25\u0149\n\25\3\26\3\26\5\26\u014d\n"+
		"\26\3\27\3\27\3\30\3\30\5\30\u0153\n\30\3\31\3\31\3\31\3\31\3\31\3\31"+
		"\3\31\5\31\u015c\n\31\3\31\2\4$&\32\2\4\6\b\n\f\16\20\22\24\26\30\32\34"+
		"\36 \"$&(*,.\60\2\3\4\2\23\23\32\32\u017f\2\62\3\2\2\2\4;\3\2\2\2\6I\3"+
		"\2\2\2\bL\3\2\2\2\nY\3\2\2\2\fp\3\2\2\2\16\u0081\3\2\2\2\20\u0083\3\2"+
		"\2\2\22\u009b\3\2\2\2\24\u009d\3\2\2\2\26\u00ae\3\2\2\2\30\u00b2\3\2\2"+
		"\2\32\u00bb\3\2\2\2\34\u00c1\3\2\2\2\36\u00d7\3\2\2\2 \u00d9\3\2\2\2\""+
		"\u00dd\3\2\2\2$\u00ee\3\2\2\2&\u0117\3\2\2\2(\u0148\3\2\2\2*\u014c\3\2"+
		"\2\2,\u014e\3\2\2\2.\u0152\3\2\2\2\60\u015b\3\2\2\2\62\66\5\4\3\2\63\65"+
		"\5\4\3\2\64\63\3\2\2\2\658\3\2\2\2\66\64\3\2\2\2\66\67\3\2\2\2\679\3\2"+
		"\2\28\66\3\2\2\29:\7\2\2\3:\3\3\2\2\2;<\7\7\2\2<?\7-\2\2=>\7\20\2\2>@"+
		"\7-\2\2?=\3\2\2\2?@\3\2\2\2@A\3\2\2\2AB\7\f\2\2BC\5\6\4\2CD\7\17\2\2D"+
		"\5\3\2\2\2EH\5\b\5\2FH\5\n\6\2GE\3\2\2\2GF\3\2\2\2HK\3\2\2\2IG\3\2\2\2"+
		"IJ\3\2\2\2J\7\3\2\2\2KI\3\2\2\2LM\5*\26\2MR\7-\2\2NO\7\30\2\2OQ\7-\2\2"+
		"PN\3\2\2\2QT\3\2\2\2RP\3\2\2\2RS\3\2\2\2SU\3\2\2\2TR\3\2\2\2UV\7\13\2"+
		"\2V\t\3\2\2\2WZ\5*\26\2XZ\7\n\2\2YW\3\2\2\2YX\3\2\2\2Z[\3\2\2\2[\\\7-"+
		"\2\2\\^\7\25\2\2]_\5\f\7\2^]\3\2\2\2^_\3\2\2\2_`\3\2\2\2`a\7\'\2\2ae\7"+
		"\f\2\2bd\5\b\5\2cb\3\2\2\2dg\3\2\2\2ec\3\2\2\2ef\3\2\2\2fk\3\2\2\2ge\3"+
		"\2\2\2hj\5\16\b\2ih\3\2\2\2jm\3\2\2\2ki\3\2\2\2kl\3\2\2\2ln\3\2\2\2mk"+
		"\3\2\2\2no\7\17\2\2o\13\3\2\2\2pq\5*\26\2qx\7-\2\2rs\7\30\2\2st\5*\26"+
		"\2tu\7-\2\2uw\3\2\2\2vr\3\2\2\2wz\3\2\2\2xv\3\2\2\2xy\3\2\2\2y\r\3\2\2"+
		"\2zx\3\2\2\2{\u0082\5\24\13\2|\u0082\5\22\n\2}\u0082\5\30\r\2~\u0082\5"+
		"\32\16\2\177\u0082\5\34\17\2\u0080\u0082\5\26\f\2\u0081{\3\2\2\2\u0081"+
		"|\3\2\2\2\u0081}\3\2\2\2\u0081~\3\2\2\2\u0081\177\3\2\2\2\u0081\u0080"+
		"\3\2\2\2\u0082\17\3\2\2\2\u0083\u0087\7\f\2\2\u0084\u0086\5\16\b\2\u0085"+
		"\u0084\3\2\2\2\u0086\u0089\3\2\2\2\u0087\u0085\3\2\2\2\u0087\u0088\3\2"+
		"\2\2\u0088\u008a\3\2\2\2\u0089\u0087\3\2\2\2\u008a\u008b\7\17\2\2\u008b"+
		"\21\3\2\2\2\u008c\u008d\7-\2\2\u008d\u008f\7\25\2\2\u008e\u0090\5\"\22"+
		"\2\u008f\u008e\3\2\2\2\u008f\u0090\3\2\2\2\u0090\u0091\3\2\2\2\u0091\u009c"+
		"\7\'\2\2\u0092\u0093\5$\23\2\u0093\u0094\7\31\2\2\u0094\u0095\7-\2\2\u0095"+
		"\u0097\7\25\2\2\u0096\u0098\5\"\22\2\u0097\u0096\3\2\2\2\u0097\u0098\3"+
		"\2\2\2\u0098\u0099\3\2\2\2\u0099\u009a\7\'\2\2\u009a\u009c\3\2\2\2\u009b"+
		"\u008c\3\2\2\2\u009b\u0092\3\2\2\2\u009c\23\3\2\2\2\u009d\u009e\5$\23"+
		"\2\u009e\u00a2\7\16\2\2\u009f\u00a3\5&\24\2\u00a0\u00a3\5\36\20\2\u00a1"+
		"\u00a3\5 \21\2\u00a2\u009f\3\2\2\2\u00a2\u00a0\3\2\2\2\u00a2\u00a1\3\2"+
		"\2\2\u00a3\u00a4\3\2\2\2\u00a4\u00a5\7\13\2\2\u00a5\25\3\2\2\2\u00a6\u00a7"+
		"\7\33\2\2\u00a7\u00a8\7\25\2\2\u00a8\u00a9\5&\24\2\u00a9\u00aa\7\'\2\2"+
		"\u00aa\u00af\3\2\2\2\u00ab\u00ac\7\36\2\2\u00ac\u00ad\7\25\2\2\u00ad\u00af"+
		"\7\'\2\2\u00ae\u00a6\3\2\2\2\u00ae\u00ab\3\2\2\2\u00af\u00b0\3\2\2\2\u00b0"+
		"\u00b1\7\13\2\2\u00b1\27\3\2\2\2\u00b2\u00b3\7\21\2\2\u00b3\u00b4\7\25"+
		"\2\2\u00b4\u00b5\5&\24\2\u00b5\u00b6\7\'\2\2\u00b6\u00b9\5\20\t\2\u00b7"+
		"\u00b8\7&\2\2\u00b8\u00ba\5\20\t\2\u00b9\u00b7\3\2\2\2\u00b9\u00ba\3\2"+
		"\2\2\u00ba\31\3\2\2\2\u00bb\u00bc\7\t\2\2\u00bc\u00bd\7\25\2\2\u00bd\u00be"+
		"\5&\24\2\u00be\u00bf\7\'\2\2\u00bf\u00c0\5\20\t\2\u00c0\33\3\2\2\2\u00c1"+
		"\u00c3\7\5\2\2\u00c2\u00c4\5&\24\2\u00c3\u00c2\3\2\2\2\u00c3\u00c4\3\2"+
		"\2\2\u00c4\u00c5\3\2\2\2\u00c5\u00c6\7\13\2\2\u00c6\35\3\2\2\2\u00c7\u00c8"+
		"\7\4\2\2\u00c8\u00c9\7-\2\2\u00c9\u00ca\7\25\2\2\u00ca\u00d8\7\'\2\2\u00cb"+
		"\u00cc\7\4\2\2\u00cc\u00cd\7-\2\2\u00cd\u00ce\7\35\2\2\u00ce\u00cf\5&"+
		"\24\2\u00cf\u00d0\7!\2\2\u00d0\u00d8\3\2\2\2\u00d1\u00d2\7\4\2\2\u00d2"+
		"\u00d3\5,\27\2\u00d3\u00d4\7\35\2\2\u00d4\u00d5\5&\24\2\u00d5\u00d6\7"+
		"!\2\2\u00d6\u00d8\3\2\2\2\u00d7\u00c7\3\2\2\2\u00d7\u00cb\3\2\2\2\u00d7"+
		"\u00d1\3\2\2\2\u00d8\37\3\2\2\2\u00d9\u00da\7%\2\2\u00da\u00db\7\25\2"+
		"\2\u00db\u00dc\7\'\2\2\u00dc!\3\2\2\2\u00dd\u00e2\5&\24\2\u00de\u00df"+
		"\7\30\2\2\u00df\u00e1\5&\24\2\u00e0\u00de\3\2\2\2\u00e1\u00e4\3\2\2\2"+
		"\u00e2\u00e0\3\2\2\2\u00e2\u00e3\3\2\2\2\u00e3#\3\2\2\2\u00e4\u00e2\3"+
		"\2\2\2\u00e5\u00e6\b\23\1\2\u00e6\u00ef\7-\2\2\u00e7\u00ef\7\27\2\2\u00e8"+
		"\u00e9\7-\2\2\u00e9\u00eb\7\25\2\2\u00ea\u00ec\5\"\22\2\u00eb\u00ea\3"+
		"\2\2\2\u00eb\u00ec\3\2\2\2\u00ec\u00ed\3\2\2\2\u00ed\u00ef\7\'\2\2\u00ee"+
		"\u00e5\3\2\2\2\u00ee\u00e7\3\2\2\2\u00ee\u00e8\3\2\2\2\u00ef\u0102\3\2"+
		"\2\2\u00f0\u00f1\f\6\2\2\u00f1\u00f2\7\31\2\2\u00f2\u0101\7-\2\2\u00f3"+
		"\u00f4\f\5\2\2\u00f4\u00f5\7\35\2\2\u00f5\u00f6\5&\24\2\u00f6\u00f7\7"+
		"!\2\2\u00f7\u0101\3\2\2\2\u00f8\u00f9\f\3\2\2\u00f9\u00fa\7\31\2\2\u00fa"+
		"\u00fb\7-\2\2\u00fb\u00fd\7\25\2\2\u00fc\u00fe\5\"\22\2\u00fd\u00fc\3"+
		"\2\2\2\u00fd\u00fe\3\2\2\2\u00fe\u00ff\3\2\2\2\u00ff\u0101\7\'\2\2\u0100"+
		"\u00f0\3\2\2\2\u0100\u00f3\3\2\2\2\u0100\u00f8\3\2\2\2\u0101\u0104\3\2"+
		"\2\2\u0102\u0100\3\2\2\2\u0102\u0103\3\2\2\2\u0103%\3\2\2\2\u0104\u0102"+
		"\3\2\2\2\u0105\u0106\b\24\1\2\u0106\u0107\7(\2\2\u0107\u0118\5&\24\23"+
		"\u0108\u0109\7)\2\2\u0109\u0118\5&\24\22\u010a\u010b\7#\2\2\u010b\u0118"+
		"\5&\24\21\u010c\u010d\7\25\2\2\u010d\u010e\5.\30\2\u010e\u010f\7\'\2\2"+
		"\u010f\u0110\5&\24\20\u0110\u0118\3\2\2\2\u0111\u0118\5(\25\2\u0112\u0118"+
		"\5$\23\2\u0113\u0114\7\25\2\2\u0114\u0115\5&\24\2\u0115\u0116\7\'\2\2"+
		"\u0116\u0118\3\2\2\2\u0117\u0105\3\2\2\2\u0117\u0108\3\2\2\2\u0117\u010a"+
		"\3\2\2\2\u0117\u010c\3\2\2\2\u0117\u0111\3\2\2\2\u0117\u0112\3\2\2\2\u0117"+
		"\u0113\3\2\2\2\u0118\u0142\3\2\2\2\u0119\u011a\f\17\2\2\u011a\u011b\7"+
		"\26\2\2\u011b\u0141\5&\24\20\u011c\u011d\f\16\2\2\u011d\u011e\7\3\2\2"+
		"\u011e\u0141\5&\24\17\u011f\u0120\f\r\2\2\u0120\u0121\7$\2\2\u0121\u0141"+
		"\5&\24\16\u0122\u0123\f\f\2\2\u0123\u0124\7(\2\2\u0124\u0141\5&\24\r\u0125"+
		"\u0126\f\13\2\2\u0126\u0127\7)\2\2\u0127\u0141\5&\24\f\u0128\u0129\f\n"+
		"\2\2\u0129\u012a\7 \2\2\u012a\u0141\5&\24\13\u012b\u012c\f\t\2\2\u012c"+
		"\u012d\7\22\2\2\u012d\u0141\5&\24\n\u012e\u012f\f\b\2\2\u012f\u0130\7"+
		"\"\2\2\u0130\u0141\5&\24\t\u0131\u0132\f\7\2\2\u0132\u0133\7\34\2\2\u0133"+
		"\u0141\5&\24\b\u0134\u0135\f\6\2\2\u0135\u0136\7\37\2\2\u0136\u0141\5"+
		"&\24\7\u0137\u0138\f\5\2\2\u0138\u0139\7\6\2\2\u0139\u0141\5&\24\6\u013a"+
		"\u013b\f\4\2\2\u013b\u013c\7\r\2\2\u013c\u0141\5&\24\5\u013d\u013e\f\3"+
		"\2\2\u013e\u013f\7\b\2\2\u013f\u0141\5&\24\4\u0140\u0119\3\2\2\2\u0140"+
		"\u011c\3\2\2\2\u0140\u011f\3\2\2\2\u0140\u0122\3\2\2\2\u0140\u0125\3\2"+
		"\2\2\u0140\u0128\3\2\2\2\u0140\u012b\3\2\2\2\u0140\u012e\3\2\2\2\u0140"+
		"\u0131\3\2\2\2\u0140\u0134\3\2\2\2\u0140\u0137\3\2\2\2\u0140\u013a\3\2"+
		"\2\2\u0140\u013d\3\2\2\2\u0141\u0144\3\2\2\2\u0142\u0140\3\2\2\2\u0142"+
		"\u0143\3\2\2\2\u0143\'\3\2\2\2\u0144\u0142\3\2\2\2\u0145\u0149\7\24\2"+
		"\2\u0146\u0149\7,\2\2\u0147\u0149\7*\2\2\u0148\u0145\3\2\2\2\u0148\u0146"+
		"\3\2\2\2\u0148\u0147\3\2\2\2\u0149)\3\2\2\2\u014a\u014d\5,\27\2\u014b"+
		"\u014d\5.\30\2\u014c\u014a\3\2\2\2\u014c\u014b\3\2\2\2\u014d+\3\2\2\2"+
		"\u014e\u014f\t\2\2\2\u014f-\3\2\2\2\u0150\u0153\7-\2\2\u0151\u0153\5\60"+
		"\31\2\u0152\u0150\3\2\2\2\u0152\u0151\3\2\2\2\u0153/\3\2\2\2\u0154\u0155"+
		"\7-\2\2\u0155\u0156\7\35\2\2\u0156\u015c\7!\2\2\u0157\u0158\5,\27\2\u0158"+
		"\u0159\7\35\2\2\u0159\u015a\7!\2\2\u015a\u015c\3\2\2\2\u015b\u0154\3\2"+
		"\2\2\u015b\u0157\3\2\2\2\u015c\61\3\2\2\2#\66?GIRY^ekx\u0081\u0087\u008f"+
		"\u0097\u009b\u00a2\u00ae\u00b9\u00c3\u00d7\u00e2\u00eb\u00ee\u00fd\u0100"+
		"\u0102\u0117\u0140\u0142\u0148\u014c\u0152\u015b";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}