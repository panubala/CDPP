package cd.frontend.parser;

import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.tree.TerminalNode;

import cd.frontend.parser.JavaliParser.ADDexprContext;
import cd.frontend.parser.JavaliParser.ANDexprContext;
import cd.frontend.parser.JavaliParser.ActualParamListContext;
import cd.frontend.parser.JavaliParser.ArrayTypeContext;
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
import cd.frontend.parser.JavaliParser.IdentAccessHeadContext;
import cd.frontend.parser.JavaliParser.IdentAccessTailContext;
import cd.frontend.parser.JavaliParser.IfStmtContext;
import cd.frontend.parser.JavaliParser.LEQexprContext;
import cd.frontend.parser.JavaliParser.LESexprContext;
import cd.frontend.parser.JavaliParser.LITexprContext;
import cd.frontend.parser.JavaliParser.MODexprContext;
import cd.frontend.parser.JavaliParser.MULTexprContext;
import cd.frontend.parser.JavaliParser.MemberListContext;
import cd.frontend.parser.JavaliParser.MethodCallExprContext;
import cd.frontend.parser.JavaliParser.MethodCallStmtContext;
import cd.frontend.parser.JavaliParser.MethodDeclContext;
import cd.frontend.parser.JavaliParser.NEGexprContext;
import cd.frontend.parser.JavaliParser.NOTexprContext;
import cd.frontend.parser.JavaliParser.NULLlitContext;
import cd.frontend.parser.JavaliParser.NewExprContext;
import cd.frontend.parser.JavaliParser.ORexprContext;
import cd.frontend.parser.JavaliParser.PARexprContext;
import cd.frontend.parser.JavaliParser.POSexprContext;
import cd.frontend.parser.JavaliParser.PrimitiveTypeContext;
import cd.frontend.parser.JavaliParser.ReadExprContext;
import cd.frontend.parser.JavaliParser.ReferenceTypeContext;
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

	// TODO not tested
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

	// TODO implement 'this'
	@Override
	public List<Ast> visitIdentAccessHead(IdentAccessHeadContext ctx) {
		System.out.println("==Ident Access Head");
		return visitChildren(ctx);
	}

	@Override
	public List<Ast> visitIdentAccessTail(IdentAccessTailContext ctx) {
		System.out.println("==Ident Access Tail");
		ArrayList<Ast> astList = new ArrayList<>();
		astList.add(new Ast.Var(ctx.getText()));
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
			statements.addAll(visit(currentStmt));
		}
		Seq body = new Ast.Seq(statements);

		astList.add(new Ast.MethodDecl(returnType, name, formalParams, decls, body));
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

	// TODO implement
	@Override
	public List<Ast> visitMethodCallStmt(MethodCallStmtContext ctx) {
		System.out.println("==Method Call");
		return visitChildren(ctx);
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

	// TODO implement
	@Override
	public List<Ast> visitMethodCallExpr(MethodCallExprContext ctx) {
		System.out.println("==Method Call");

		// ctx.

		// new Ast.MethodCallExpr(Expr rcvr, String methodName, List<Expr>
		// arguments)
		return visitChildren(ctx);
	}

	// TODO implement
	@Override
	public List<Ast> visitIfStmt(IfStmtContext ctx) {
		System.out.println("==If stmt");
		return visitChildren(ctx);
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

	// TODO implement
	@Override
	public List<Ast> visitActualParamList(ActualParamListContext ctx) {
		System.out.println("==Actual Param List");
		return visitChildren(ctx);
	}

	// TODO implement
	@Override
	public List<Ast> visitStmt(StmtContext ctx) {
		System.out.println("==Stmt");
		return visitChildren(ctx);
	}

	////////////////////////////////////////////////////////////////////////////////////////////////
	// Expressions

	// TODO implement
	@Override
	public List<Ast> visitLITexpr(LITexprContext ctx) {
		return super.visitLITexpr(ctx);
	}

	// TODO implement
	// identAccesHead
	@Override
	public List<Ast> visitIAHexpr(IAHexprContext ctx) {
		return super.visitIAHexpr(ctx);
	}

	// TODO implement
	// cast
	@Override
	public List<Ast> visitCASTexpr(CASTexprContext ctx) {
		return super.visitCASTexpr(ctx);
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

	// Types
	// ReferenceType
	// TODO implement
	@Override
	public List<Ast> visitReferenceType(ReferenceTypeContext ctx) {
		System.out.println("==RefType");
		return super.visitReferenceType(ctx);
	}

	// Type
	// TODO implement
	@Override
	public List<Ast> visitType(TypeContext ctx) {
		System.out.println("==Type");
		return super.visitType(ctx);
	}

	// PrimitiveType
	// TODO implement
	@Override
	public List<Ast> visitPrimitiveType(PrimitiveTypeContext ctx) {
		return super.visitPrimitiveType(ctx);
	}

	// TODO implement
	// arrayType
	@Override
	public List<Ast> visitArrayType(ArrayTypeContext ctx) {
		return super.visitArrayType(ctx);
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
