// Generated from /Users/panuyabalasuntharam/Desktop/CDPP/HW2/src/cd/frontend/parser/Javali.g4 by ANTLR 4.4

	// Java header
	package cd.frontend.parser;
	

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link JavaliParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface JavaliVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by the {@code StmtReturn}
	 * labeled alternative in {@link JavaliParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmtReturn(@NotNull JavaliParser.StmtReturnContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IdentThis}
	 * labeled alternative in {@link JavaliParser#identAccess}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentThis(@NotNull JavaliParser.IdentThisContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaliParser#formalParamList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFormalParamList(@NotNull JavaliParser.FormalParamListContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StmtAssign}
	 * labeled alternative in {@link JavaliParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmtAssign(@NotNull JavaliParser.StmtAssignContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MULTexpr}
	 * labeled alternative in {@link JavaliParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMULTexpr(@NotNull JavaliParser.MULTexprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code GEQexpr}
	 * labeled alternative in {@link JavaliParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGEQexpr(@NotNull JavaliParser.GEQexprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IdentIdent}
	 * labeled alternative in {@link JavaliParser#identAccess}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentIdent(@NotNull JavaliParser.IdentIdentContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SUBexpr}
	 * labeled alternative in {@link JavaliParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSUBexpr(@NotNull JavaliParser.SUBexprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code NEGexpr}
	 * labeled alternative in {@link JavaliParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNEGexpr(@NotNull JavaliParser.NEGexprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ADDexpr}
	 * labeled alternative in {@link JavaliParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitADDexpr(@NotNull JavaliParser.ADDexprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StmtIf}
	 * labeled alternative in {@link JavaliParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmtIf(@NotNull JavaliParser.StmtIfContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IAHexpr}
	 * labeled alternative in {@link JavaliParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIAHexpr(@NotNull JavaliParser.IAHexprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code arrayTypePrimitive}
	 * labeled alternative in {@link JavaliParser#arrayType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayTypePrimitive(@NotNull JavaliParser.ArrayTypePrimitiveContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaliParser#whileStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileStmt(@NotNull JavaliParser.WhileStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaliParser#classDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassDecl(@NotNull JavaliParser.ClassDeclContext ctx);
	/**
	 * Visit a parse tree produced by the {@code GRTexpr}
	 * labeled alternative in {@link JavaliParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGRTexpr(@NotNull JavaliParser.GRTexprContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaliParser#returnStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnStmt(@NotNull JavaliParser.ReturnStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code POSexpr}
	 * labeled alternative in {@link JavaliParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPOSexpr(@NotNull JavaliParser.POSexprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MODexpr}
	 * labeled alternative in {@link JavaliParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMODexpr(@NotNull JavaliParser.MODexprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code referenceTypeArray}
	 * labeled alternative in {@link JavaliParser#referenceType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReferenceTypeArray(@NotNull JavaliParser.ReferenceTypeArrayContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaliParser#stmtBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmtBlock(@NotNull JavaliParser.StmtBlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaliParser#unit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnit(@NotNull JavaliParser.UnitContext ctx);
	/**
	 * Visit a parse tree produced by the {@code NULLlit}
	 * labeled alternative in {@link JavaliParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNULLlit(@NotNull JavaliParser.NULLlitContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LESexpr}
	 * labeled alternative in {@link JavaliParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLESexpr(@NotNull JavaliParser.LESexprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code EQexpr}
	 * labeled alternative in {@link JavaliParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEQexpr(@NotNull JavaliParser.EQexprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code referenceTypeIdent}
	 * labeled alternative in {@link JavaliParser#referenceType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReferenceTypeIdent(@NotNull JavaliParser.ReferenceTypeIdentContext ctx);
	/**
	 * Visit a parse tree produced by the {@code DIVexpr}
	 * labeled alternative in {@link JavaliParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDIVexpr(@NotNull JavaliParser.DIVexprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IdentArray}
	 * labeled alternative in {@link JavaliParser#identAccess}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentArray(@NotNull JavaliParser.IdentArrayContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StmtMethod}
	 * labeled alternative in {@link JavaliParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmtMethod(@NotNull JavaliParser.StmtMethodContext ctx);
	/**
	 * Visit a parse tree produced by the {@code refType}
	 * labeled alternative in {@link JavaliParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRefType(@NotNull JavaliParser.RefTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BOOLlit}
	 * labeled alternative in {@link JavaliParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBOOLlit(@NotNull JavaliParser.BOOLlitContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaliParser#methodDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodDecl(@NotNull JavaliParser.MethodDeclContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LEQexpr}
	 * labeled alternative in {@link JavaliParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLEQexpr(@NotNull JavaliParser.LEQexprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ANDexpr}
	 * labeled alternative in {@link JavaliParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitANDexpr(@NotNull JavaliParser.ANDexprContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaliParser#memberList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMemberList(@NotNull JavaliParser.MemberListContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LITexpr}
	 * labeled alternative in {@link JavaliParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLITexpr(@NotNull JavaliParser.LITexprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ORexpr}
	 * labeled alternative in {@link JavaliParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitORexpr(@NotNull JavaliParser.ORexprContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaliParser#assignmentStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignmentStmt(@NotNull JavaliParser.AssignmentStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaliParser#actualParamList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitActualParamList(@NotNull JavaliParser.ActualParamListContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaliParser#primitiveType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimitiveType(@NotNull JavaliParser.PrimitiveTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code primType}
	 * labeled alternative in {@link JavaliParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimType(@NotNull JavaliParser.PrimTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code NewMethod}
	 * labeled alternative in {@link JavaliParser#newExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNewMethod(@NotNull JavaliParser.NewMethodContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CASTexpr}
	 * labeled alternative in {@link JavaliParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCASTexpr(@NotNull JavaliParser.CASTexprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code UEQexpr}
	 * labeled alternative in {@link JavaliParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUEQexpr(@NotNull JavaliParser.UEQexprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IdentField}
	 * labeled alternative in {@link JavaliParser#identAccess}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentField(@NotNull JavaliParser.IdentFieldContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StmtWrite}
	 * labeled alternative in {@link JavaliParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmtWrite(@NotNull JavaliParser.StmtWriteContext ctx);
	/**
	 * Visit a parse tree produced by the {@code PARexpr}
	 * labeled alternative in {@link JavaliParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPARexpr(@NotNull JavaliParser.PARexprContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaliParser#readExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReadExpr(@NotNull JavaliParser.ReadExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaliParser#writeStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWriteStmt(@NotNull JavaliParser.WriteStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaliParser#methodCallStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodCallStmt(@NotNull JavaliParser.MethodCallStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code NOTexpr}
	 * labeled alternative in {@link JavaliParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNOTexpr(@NotNull JavaliParser.NOTexprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code INTlit}
	 * labeled alternative in {@link JavaliParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitINTlit(@NotNull JavaliParser.INTlitContext ctx);
	/**
	 * Visit a parse tree produced by the {@code NewType}
	 * labeled alternative in {@link JavaliParser#newExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNewType(@NotNull JavaliParser.NewTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code NewArray}
	 * labeled alternative in {@link JavaliParser#newExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNewArray(@NotNull JavaliParser.NewArrayContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaliParser#ifStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStmt(@NotNull JavaliParser.IfStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IdentMethod}
	 * labeled alternative in {@link JavaliParser#identAccess}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentMethod(@NotNull JavaliParser.IdentMethodContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IdentMethodField}
	 * labeled alternative in {@link JavaliParser#identAccess}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentMethodField(@NotNull JavaliParser.IdentMethodFieldContext ctx);
	/**
	 * Visit a parse tree produced by the {@code arrayTypeIdent}
	 * labeled alternative in {@link JavaliParser#arrayType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayTypeIdent(@NotNull JavaliParser.ArrayTypeIdentContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaliParser#varDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarDecl(@NotNull JavaliParser.VarDeclContext ctx);
}