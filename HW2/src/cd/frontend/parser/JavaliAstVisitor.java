package cd.frontend.parser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.antlr.v4.runtime.tree.TerminalNode;
import org.stringtemplate.v4.debug.AddAttributeEvent;

import cd.frontend.parser.JavaliParser.ADDexprContext;
import cd.frontend.parser.JavaliParser.ANDexprContext;
import cd.frontend.parser.JavaliParser.ActualParamListContext;
import cd.frontend.parser.JavaliParser.ArrayTypeContext;
import cd.frontend.parser.JavaliParser.ArrayTypeIdentContext;
import cd.frontend.parser.JavaliParser.ArrayTypePrimitiveContext;
import cd.frontend.parser.JavaliParser.AssignmentStmtContext;
import cd.frontend.parser.JavaliParser.BOOLlitContext;
import cd.frontend.parser.JavaliParser.CASTexprContext;

import cd.frontend.parser.JavaliParser.ClassDeclContext;
import cd.frontend.parser.JavaliParser.DIVexprContext;
import cd.frontend.parser.JavaliParser.EQexprContext;
import cd.frontend.parser.JavaliParser.FormalParamListContext;
import cd.frontend.parser.JavaliParser.GEQexprContext;
import cd.frontend.parser.JavaliParser.GRTexprContext;

import cd.frontend.parser.JavaliParser.IAHexprContext;
import cd.frontend.parser.JavaliParser.INTlitContext;
import cd.frontend.parser.JavaliParser.IdentArrayContext;
import cd.frontend.parser.JavaliParser.IdentFieldContext;
import cd.frontend.parser.JavaliParser.IdentIdentContext;
import cd.frontend.parser.JavaliParser.IdentMethodContext;
import cd.frontend.parser.JavaliParser.IdentMethodFieldContext;
import cd.frontend.parser.JavaliParser.IdentThisContext;
import cd.frontend.parser.JavaliParser.IfStmtContext;
import cd.frontend.parser.JavaliParser.LEQexprContext;
import cd.frontend.parser.JavaliParser.LESexprContext;
import cd.frontend.parser.JavaliParser.LITexprContext;
import cd.frontend.parser.JavaliParser.MODexprContext;
import cd.frontend.parser.JavaliParser.MULTexprContext;
import cd.frontend.parser.JavaliParser.MemberListContext;


import cd.frontend.parser.JavaliParser.MethodCallStmtContext;
import cd.frontend.parser.JavaliParser.MethodDeclContext;

import cd.frontend.parser.JavaliParser.NEGexprContext;
import cd.frontend.parser.JavaliParser.NOTexprContext;
import cd.frontend.parser.JavaliParser.NULLlitContext;
import cd.frontend.parser.JavaliParser.NewExprContext;
import cd.frontend.parser.JavaliParser.ORexprContext;
import cd.frontend.parser.JavaliParser.PARexprContext;
import cd.frontend.parser.JavaliParser.POSexprContext;
import cd.frontend.parser.JavaliParser.PrimTypeContext;
import cd.frontend.parser.JavaliParser.PrimitiveTypeContext;
import cd.frontend.parser.JavaliParser.ReadExprContext;
import cd.frontend.parser.JavaliParser.RefTypeContext;
import cd.frontend.parser.JavaliParser.ReferenceTypeArrayContext;
import cd.frontend.parser.JavaliParser.ReferenceTypeContext;
import cd.frontend.parser.JavaliParser.ReferenceTypeIdentContext;
import cd.frontend.parser.JavaliParser.ReturnStmtContext;
import cd.frontend.parser.JavaliParser.SUBexprContext;
import cd.frontend.parser.JavaliParser.StmtBlockContext;
import cd.frontend.parser.JavaliParser.StmtContext;

import cd.frontend.parser.JavaliParser.TypeContext;
import cd.frontend.parser.JavaliParser.UEQexprContext;
import cd.frontend.parser.JavaliParser.UnitContext;
import cd.frontend.parser.JavaliParser.VarDeclContext;
import cd.frontend.parser.JavaliParser.WhileStmtContext;
import cd.frontend.parser.JavaliParser.WriteStmtContext;
import cd.ir.Ast;
import cd.ir.Ast.ClassDecl;
import cd.ir.Ast.Expr;
import cd.ir.Ast.Seq;
import cd.ir.Ast.VarDecl;
import cd.util.Pair;

public final class JavaliAstVisitor extends JavaliBaseVisitor<List<Ast>> {

	@Override
	public List<Ast> visitUnit(UnitContext ctx) {
		System.out.println("==Unit");
		return visitChildren(ctx);
	}

	public List<ClassDecl> classDecls = new ArrayList<>();

	@Override
	public List<Ast> visitClassDecl(ClassDeclContext ctx) {
		System.out.println("==ClassDecl");
		
		String name = ctx.getChild(1).getText();
		
		String superClass = "Object";
		if(ctx.getChild(2).getText().equals("extends")) //not so beautiful
			superClass = ctx.getChild(3).getText();
		
		List<Ast> members = visit(ctx.memberList());

		classDecls.add(new Ast.ClassDecl(name, superClass, members));
		return null;
	}
	
	// TODO implement
	@Override
	public List<Ast> visitMemberList(MemberListContext ctx) {
		System.out.println("==Member List");
		ArrayList<Ast> astList = new ArrayList<Ast>();
		
		for(MethodDeclContext current:ctx.methodDecl()){
			astList.addAll(visit(current));
		}
		return astList;
	}

	// TODO implement
	@Override
	public List<Ast> visitNewExpr(NewExprContext ctx) {
		System.out.println("==New Expr");
		
		return null;
	}

	// not tested
	@Override
	public List<Ast> visitWhileStmt(WhileStmtContext ctx) {
		ArrayList<Ast> astList = new ArrayList<Ast>();
		astList.add(new Ast.WhileLoop((Ast.Expr) visit(ctx.expr()).get(0), visit(ctx.stmtBlock()).get(0)));
		return astList;
	}

	@Override
	public List<Ast> visitFormalParamList(FormalParamListContext ctx) {
		System.out.println("==Formal ParamList");
		ArrayList<Ast> astList = new ArrayList<Ast>();
		for (int i = 0; i < ctx.type().size(); i++) {
			astList.add(new Ast.VarDecl(ctx.type(i).getText(), ctx.Ident(i).getText()));
		}
		return astList;
	}

	@Override
	public List<Ast> visitReadExpr(ReadExprContext ctx) {
		System.out.println("==Read Expr");
		ArrayList<Ast> astList = new ArrayList<Ast>();
		astList.add(new Ast.BuiltInRead());
		return astList;
	}


	@Override
	public List<Ast> visitMethodDecl(MethodDeclContext ctx) {
		System.out.println("==Method Decl"); // TODO not void
		ArrayList<Ast> astList = new ArrayList<>();

		String returnType = ctx.getChild(0).getText();
		String name = ctx.getChild(1).getText();

		// Arguments
		ArrayList<Pair<String>> formalParams = new ArrayList<Pair<String>>();
		if (ctx.formalParamList() != null) {
			List<Ast> argVisited = visit(ctx.formalParamList());
			for (Ast currArg : argVisited) {
				VarDecl var = (VarDecl) currArg;
				formalParams.add(new Pair(var.type, var.name));
			}
		}

		// Declarations
		Seq decls = null;
		ArrayList<Ast> declVisited = new ArrayList<Ast>();
		if (ctx.varDecl() != null) {
			for (VarDeclContext a : ctx.varDecl()) {
				List<Ast> b = visit(a);
				declVisited.addAll(b);
			}
		}
		decls = new Ast.Seq(declVisited);

		// Statements
		ArrayList<Ast> statements = new ArrayList<>();
		for (StmtContext currentStmt : ctx.stmt()) {
			System.out.println(currentStmt.getText());
			statements.addAll(visit(currentStmt));
		}
		Seq body = new Ast.Seq(statements);

		astList.add(new Ast.MethodDecl(returnType, name, formalParams, decls, body));
		return astList;
	}

	@Override
	public List<Ast> visitIdentThis(IdentThisContext ctx) {
		ArrayList<Ast> astList = new ArrayList<Ast>();
		astList.add(new Ast.ThisRef());
		return astList;
	}

	@Override
	public List<Ast> visitIdentIdent(IdentIdentContext ctx) {
		ArrayList<Ast> astList = new ArrayList<Ast>();
		String name = ctx.Ident().toString();
		
		astList.add(new Ast.Var(name));
		
		return astList;
	}

	@Override
	public List<Ast> visitIdentArray(IdentArrayContext ctx) {

		ArrayList<Ast> astList = new ArrayList<Ast>();
		
		Ast.Expr array = (Ast.Expr) visit(ctx.identAccess()).get(0);
		Ast.Expr index = (Ast.Expr) visit(ctx.expr()).get(0);
		
		astList.add(new Ast.Index(array, index));
		
		return astList;
	}



	@Override
	public List<Ast> visitIdentMethod(IdentMethodContext ctx) {
		ArrayList<Ast> astList = new ArrayList<Ast>();
		ArrayList<Ast.Expr> args = new ArrayList<Ast.Expr>();
		
		Ast.Expr rcvr = new Ast.ThisRef();
		
		if (ctx.actualParamList() != null){
			for(Ast ast: visit(ctx.actualParamList())){
				 Ast.Expr expr = (Ast.Expr) ast;
	             args.add(expr);
			}
		}
		
		String methodName = ctx.Ident().toString();
		
		astList.add(new Ast.MethodCallExpr(rcvr, methodName, args));
		
		return astList;
	}

	@Override
	public List<Ast> visitIdentMethodField(IdentMethodFieldContext ctx) {
		ArrayList<Ast> astList = new ArrayList<Ast>();
		ArrayList<Ast.Expr> args = new ArrayList<Ast.Expr>();
		
		Ast.Expr rcvr = new Ast.ThisRef();
		
		if (ctx.actualParamList() != null){
			for(Ast ast: visit(ctx.actualParamList())){
				 Ast.Expr expr = (Ast.Expr) ast;
	             args.add(expr);
			}
		}
		
		String methodName = ctx.Ident().toString();
		
		astList.add(new Ast.MethodCallExpr(rcvr, methodName, args));
		
		return astList;
	}

	@Override
	public List<Ast> visitIdentField(IdentFieldContext ctx) {
		ArrayList<Ast> astList = new ArrayList<Ast>();
		
		String fieldName = ctx.Ident().toString();
		
		Ast.Expr arg = (Ast.Expr) visit(ctx.identAccess()).get(0);
		
		astList.add(new Ast.Field(arg, fieldName));
		
		return astList;
	}

	@Override
	public List<Ast> visitMethodCallStmt(MethodCallStmtContext ctx) {
		ArrayList<Ast> astList = new ArrayList<Ast>();
		ArrayList<Ast.Expr> args = new ArrayList<Ast.Expr>();
		
		Ast.Expr rcvr = new Ast.ThisRef();
		
		if (ctx.actualParamList() != null){
			for(Ast ast: visit(ctx.actualParamList())){
				 Ast.Expr expr = (Ast.Expr) ast;
	             args.add(expr);
			}
		}
		
		String methodName = ctx.Ident().toString();
		
		astList.add(new Ast.MethodCallExpr(rcvr, methodName, args));
		
		return astList;
	}

	

	@Override
	public List<Ast> visitWriteStmt(WriteStmtContext ctx) {
		System.out.println("==Write Stmt");
		ArrayList<Ast> astList = new ArrayList<Ast>();

		if (ctx.expr() != null) { // write()
			astList.add(new Ast.BuiltInWrite((Ast.Expr) visit(ctx.expr()).get(0)));
		} else { // writeln()
			astList.add(new Ast.BuiltInWriteln());
		}
		return astList;
	}

	@Override
	public List<Ast> visitReturnStmt(ReturnStmtContext ctx) {
		System.out.println("==Return Stmt");
		ArrayList<Ast> astList = new ArrayList<Ast>();
		astList.add(new Ast.ReturnStmt((Ast.Expr) visit(ctx.expr()).get(0)));
		return astList;
	}


	@Override
	public List<Ast> visitStmtBlock(StmtBlockContext ctx) {
		System.out.println("==Stmt Block");
		List<Ast> astList = new ArrayList<>();
		for (StmtContext s : ctx.stmt()) {
			astList.addAll(visit(s));
		}
		return astList;
	}


	// not tested
	//What happen if we have several else-Stmt?
	//What happen if there is no stmt in thenBlock?
	@Override
	public List<Ast> visitIfStmt(IfStmtContext ctx) {
		System.out.println("==If stmt");
		
		ArrayList<Ast> astList = new ArrayList<Ast>();
		
		Ast.Expr conditionBlock = (Ast.Expr) visit(ctx.expr()).get(0);
		
		//Does this work? Something strange
		Ast.Seq  thenBlock = new Ast.Seq(visit(ctx.stmtBlock(0)));
		Ast elseBlock;
		
		if (ctx.stmtBlock().size() == 1){
			elseBlock = new Ast.Nop();
		}else{
			elseBlock = new Ast.Seq(visit(ctx.stmtBlock(1)));
		}
			
		
		astList.add(new Ast.IfElse(conditionBlock, thenBlock, elseBlock));
		return astList;
	}

	@Override
	public List<Ast> visitVarDecl(VarDeclContext ctx) {
		System.out.println("==Var Decl");

		ArrayList<Ast> astList = new ArrayList<>();
		String type = ctx.type().getText();

		for (TerminalNode currentIdent : ctx.Ident()) {
			astList.add(new Ast.VarDecl(type, currentIdent.getText()));
		}

		return astList;
	}

	@Override
	public List<Ast> visitAssignmentStmt(AssignmentStmtContext ctx) {
		System.out.println("==Ass Stmt");
		ArrayList<Ast> astList = new ArrayList<>();

		Expr left = (Expr) visit(ctx.getChild(0)).get(0);
		Expr right = (Expr) visit(ctx.getChild(2)).get(0);

		astList.add(new Ast.Assign(left, right));

		return astList;
	}

	//not tested
	@Override
	public List<Ast> visitActualParamList(ActualParamListContext ctx) {
		System.out.println("==Actual Param List");
		ArrayList<Ast> astList = new ArrayList<>();
		
		for (int i = 0; i < ctx.expr().size(); i++) {
			astList.add(visit(ctx.expr(i)).get(0));
		}
		
		return astList;
	}

	// TODO implement
	@Override
	public List<Ast> visitStmt(StmtContext ctx) {
		System.out.println("==Stmt");
		
		return visitChildren(ctx);
	}

	////////////////////////////////////////////////////////////////////////////////////////////////
	// Expressions

	@Override
	public List<Ast> visitLITexpr(LITexprContext ctx) {
		System.out.println("==LITexpr");
		return visit(ctx.literal());
	}

	
	@Override
	public List<Ast> visitIAHexpr(IAHexprContext ctx) {
		System.out.println("==IAexpr");
		return visit(ctx.identAccess());
	}

	// not tested
	// cast
	@Override
	public List<Ast> visitCASTexpr(CASTexprContext ctx) {
		System.out.println("==CASTexpr");
		ArrayList<Ast> astList = new ArrayList<>();
		
		
		Ast.Expr expr = (Ast.Expr) visit(ctx.expr()).get(0);
		String typeName = ctx.referenceType().getText();
		
		astList.add(new Ast.Cast(expr, typeName));
		
		return astList;
	}

	// parantheses
	@Override
	public List<Ast> visitPARexpr(PARexprContext ctx) {
		System.out.println("parantheseExpr");
		return visit(ctx.expr());
	}

	// Addition
	@Override
	public List<Ast> visitADDexpr(ADDexprContext ctx) {
		System.out.println("==ADDexpr");
		ArrayList<Ast> astList = new ArrayList<>();
		astList.add(new Ast.BinaryOp((Ast.Expr) visit(ctx.expr(0)).get(0), Ast.BinaryOp.BOp.B_PLUS,
				(Ast.Expr) visit(ctx.expr(1)).get(0)));
		return astList;
	}

	// Subtraction
	@Override
	public List<Ast> visitSUBexpr(SUBexprContext ctx) {
		System.out.println("==SUBexpr");
		ArrayList<Ast> astList = new ArrayList<>();
		astList.add(new Ast.BinaryOp((Ast.Expr) visit(ctx.expr(0)).get(0), Ast.BinaryOp.BOp.B_MINUS,
				(Ast.Expr) visit(ctx.expr(1)).get(0)));
		return astList;
	}

	// Multiplication
	@Override
	public List<Ast> visitMULTexpr(MULTexprContext ctx) {
		System.out.println("==MULexpr");
		ArrayList<Ast> astList = new ArrayList<>();
		astList.add(new Ast.BinaryOp((Ast.Expr) visit(ctx.expr(0)).get(0), Ast.BinaryOp.BOp.B_TIMES,
				(Ast.Expr) visit(ctx.expr(1)).get(0)));
		return astList;
	}

	// Division
	@Override
	public List<Ast> visitDIVexpr(DIVexprContext ctx) {
		System.out.println("==DIVexpr");
		ArrayList<Ast> astList = new ArrayList<>();
		astList.add(new Ast.BinaryOp((Ast.Expr) visit(ctx.expr(0)).get(0), Ast.BinaryOp.BOp.B_DIV,
				(Ast.Expr) visit(ctx.expr(1)).get(0)));
		return astList;
	}

	// Modulo
	@Override
	public List<Ast> visitMODexpr(MODexprContext ctx) {
		System.out.println("==MODexpr");
		ArrayList<Ast> astList = new ArrayList<>();
		astList.add(new Ast.BinaryOp((Ast.Expr) visit(ctx.expr(0)).get(0), Ast.BinaryOp.BOp.B_MOD,
				(Ast.Expr) visit(ctx.expr(1)).get(0)));
		return astList;
	}

	// Equality
	@Override
	public List<Ast> visitEQexpr(EQexprContext ctx) {
		System.out.println("==EQexpr");
		ArrayList<Ast> astList = new ArrayList<>();
		astList.add(new Ast.BinaryOp((Ast.Expr) visit(ctx.expr(0)).get(0), Ast.BinaryOp.BOp.B_EQUAL,
				(Ast.Expr) visit(ctx.expr(1)).get(0)));
		return astList;
	}

	// not equal
	@Override
	public List<Ast> visitUEQexpr(UEQexprContext ctx) {
		System.out.println("==UEQexpr");
		ArrayList<Ast> astList = new ArrayList<>();
		astList.add(new Ast.BinaryOp((Ast.Expr) visit(ctx.expr(0)).get(0), Ast.BinaryOp.BOp.B_NOT_EQUAL,
				(Ast.Expr) visit(ctx.expr(1)).get(0)));
		return astList;
	}

	// Less or Equal
	@Override
	public List<Ast> visitLEQexpr(LEQexprContext ctx) {
		System.out.println("==LEQexpr");
		ArrayList<Ast> astList = new ArrayList<>();
		astList.add(new Ast.BinaryOp((Ast.Expr) visit(ctx.expr(0)).get(0), Ast.BinaryOp.BOp.B_LESS_OR_EQUAL,
				(Ast.Expr) visit(ctx.expr(1)).get(0)));
		return astList;
	}

	// less
	@Override
	public List<Ast> visitLESexpr(LESexprContext ctx) {
		System.out.println("==LESexpr");
		ArrayList<Ast> astList = new ArrayList<>();
		astList.add(new Ast.BinaryOp((Ast.Expr) visit(ctx.expr(0)).get(0), Ast.BinaryOp.BOp.B_LESS_THAN,
				(Ast.Expr) visit(ctx.expr(1)).get(0)));
		return astList;
	}

	// Greater or equal
	@Override
	public List<Ast> visitGEQexpr(GEQexprContext ctx) {
		System.out.println("==GEQexpr");
		ArrayList<Ast> astList = new ArrayList<>();
		astList.add(new Ast.BinaryOp((Ast.Expr) visit(ctx.expr(0)).get(0), Ast.BinaryOp.BOp.B_GREATER_OR_EQUAL,
				(Ast.Expr) visit(ctx.expr(1)).get(0)));
		return astList;
	}

	// greater
	@Override
	public List<Ast> visitGRTexpr(GRTexprContext ctx) {
		System.out.println("==GRTexpr");
		ArrayList<Ast> astList = new ArrayList<>();
		astList.add(new Ast.BinaryOp((Ast.Expr) visit(ctx.expr(0)).get(0), Ast.BinaryOp.BOp.B_GREATER_THAN,
				(Ast.Expr) visit(ctx.expr(1)).get(0)));
		return astList;
	}

	// And
	@Override
	public List<Ast> visitANDexpr(ANDexprContext ctx) {
		System.out.println("==ANDexpr");
		ArrayList<Ast> astList = new ArrayList<>();
		astList.add(new Ast.BinaryOp((Ast.Expr) visit(ctx.expr(0)).get(0), Ast.BinaryOp.BOp.B_AND,
				(Ast.Expr) visit(ctx.expr(1)).get(0)));
		return astList;
	}

	// Or
	@Override
	public List<Ast> visitORexpr(ORexprContext ctx) {
		System.out.println("==ORexpr");
		ArrayList<Ast> astList = new ArrayList<>();
		astList.add(new Ast.BinaryOp((Ast.Expr) visit(ctx.expr(0)).get(0), Ast.BinaryOp.BOp.B_OR,
				(Ast.Expr) visit(ctx.expr(1)).get(0)));
		return astList;
	}

	////////////////////////////////////////////////////////////////////////////////////////////////
	// Unary Expressions
	// Positive
	@Override
	public List<Ast> visitPOSexpr(POSexprContext ctx) {
		System.out.println("==POSexpr");
		ArrayList<Ast> astList = new ArrayList<>();
		astList.add(new Ast.UnaryOp(Ast.UnaryOp.UOp.U_PLUS, (Ast.Expr) visit(ctx.expr()).get(0)));
		return astList;
	}

	// negativ
	@Override
	public List<Ast> visitNEGexpr(NEGexprContext ctx) {
		System.out.println("==NEGexpr");
		ArrayList<Ast> astList = new ArrayList<>();
		astList.add(new Ast.UnaryOp(Ast.UnaryOp.UOp.U_MINUS, (Ast.Expr) visit(ctx.expr()).get(0)));
		return astList;
	}

	// not
	@Override
	public List<Ast> visitNOTexpr(NOTexprContext ctx) {
		System.out.println("==POSexpr");
		ArrayList<Ast> astList = new ArrayList<>();
		astList.add(new Ast.UnaryOp(Ast.UnaryOp.UOp.U_BOOL_NOT, (Ast.Expr) visit(ctx.expr()).get(0)));
		return astList;
	}

	////////////////////////////////////////////////////////////////////////////////////////////////


	@Override
	public List<Ast> visitReferenceTypeArray(ReferenceTypeArrayContext ctx) {
		return visit(ctx.arrayType());
	}

	@Override
	public List<Ast> visitRefType(RefTypeContext ctx) {
		return visit(ctx.referenceType());
	}

	@Override
	public List<Ast> visitPrimType(PrimTypeContext ctx) {
		return visit(ctx.primitiveType());
	}

	@Override
	public List<Ast> visitReferenceTypeIdent(ReferenceTypeIdentContext ctx) {
		ArrayList<Ast> astList = new ArrayList<>();
		astList.add(new VarDecl(null, null));
		return astList;
	}

	// PrimitiveType
	@Override
	public List<Ast> visitPrimitiveType(PrimitiveTypeContext ctx) {
		
		ArrayList<Ast> astList = new ArrayList<>();
		
		String type = ctx.getText();
		
		//TODO: instead of null?
		astList.add(new VarDecl(type, null));
		
		return astList;
	}

	@Override
	public List<Ast> visitArrayTypePrimitive(ArrayTypePrimitiveContext ctx) {
		ArrayList<Ast> astList = new ArrayList<>();
		
		Ast.VarDecl varDecl = (Ast.VarDecl) visit(ctx.primitiveType()).get(0);
		astList.add(varDecl);
		
		
		return astList;
	}

	@Override
	public List<Ast> visitArrayTypeIdent(ArrayTypeIdentContext ctx) {
		ArrayList<Ast> astList = new ArrayList<>();
		astList.add(new Ast.VarDecl(null, null));
		return astList;
	}

	// Literals ////////////////////////
	// Boolean
	@Override
	public List<Ast> visitBOOLlit(BOOLlitContext ctx) {
		System.out.println("==BoolLit");
		ArrayList<Ast> astList = new ArrayList<>();
		astList.add(new Ast.BooleanConst(Boolean.parseBoolean(ctx.Boolean().getText())));
		return astList;
	}

	// Integer
	@Override
	public List<Ast> visitINTlit(INTlitContext ctx) {
		System.out.println("==IntLit");
		ArrayList<Ast> astList = new ArrayList<>();
		astList.add(new Ast.IntConst(Integer.parseInt(ctx.getText())));
		return astList;
	}

	// Null
	@Override
	public List<Ast> visitNULLlit(NULLlitContext ctx) {
		System.out.println("==NullLit");
		ArrayList<Ast> astList = new ArrayList<>();
		astList.add(new Ast.NullConst());
		return astList;
	}

	/////////////////
}
