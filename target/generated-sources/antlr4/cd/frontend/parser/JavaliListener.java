// Generated from Javali.g4 by ANTLR 4.4

	// Java header
	package cd.frontend.parser;
	

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link JavaliParser}.
 */
public interface JavaliListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by the {@code StmtReturn}
	 * labeled alternative in {@link JavaliParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterStmtReturn(@NotNull JavaliParser.StmtReturnContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StmtReturn}
	 * labeled alternative in {@link JavaliParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitStmtReturn(@NotNull JavaliParser.StmtReturnContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IdentThis}
	 * labeled alternative in {@link JavaliParser#identAccess}.
	 * @param ctx the parse tree
	 */
	void enterIdentThis(@NotNull JavaliParser.IdentThisContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IdentThis}
	 * labeled alternative in {@link JavaliParser#identAccess}.
	 * @param ctx the parse tree
	 */
	void exitIdentThis(@NotNull JavaliParser.IdentThisContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaliParser#formalParamList}.
	 * @param ctx the parse tree
	 */
	void enterFormalParamList(@NotNull JavaliParser.FormalParamListContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaliParser#formalParamList}.
	 * @param ctx the parse tree
	 */
	void exitFormalParamList(@NotNull JavaliParser.FormalParamListContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StmtAssign}
	 * labeled alternative in {@link JavaliParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterStmtAssign(@NotNull JavaliParser.StmtAssignContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StmtAssign}
	 * labeled alternative in {@link JavaliParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitStmtAssign(@NotNull JavaliParser.StmtAssignContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MULTexpr}
	 * labeled alternative in {@link JavaliParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterMULTexpr(@NotNull JavaliParser.MULTexprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MULTexpr}
	 * labeled alternative in {@link JavaliParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitMULTexpr(@NotNull JavaliParser.MULTexprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code GEQexpr}
	 * labeled alternative in {@link JavaliParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterGEQexpr(@NotNull JavaliParser.GEQexprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code GEQexpr}
	 * labeled alternative in {@link JavaliParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitGEQexpr(@NotNull JavaliParser.GEQexprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IdentIdent}
	 * labeled alternative in {@link JavaliParser#identAccess}.
	 * @param ctx the parse tree
	 */
	void enterIdentIdent(@NotNull JavaliParser.IdentIdentContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IdentIdent}
	 * labeled alternative in {@link JavaliParser#identAccess}.
	 * @param ctx the parse tree
	 */
	void exitIdentIdent(@NotNull JavaliParser.IdentIdentContext ctx);
	/**
	 * Enter a parse tree produced by the {@code SUBexpr}
	 * labeled alternative in {@link JavaliParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterSUBexpr(@NotNull JavaliParser.SUBexprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SUBexpr}
	 * labeled alternative in {@link JavaliParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitSUBexpr(@NotNull JavaliParser.SUBexprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code NEGexpr}
	 * labeled alternative in {@link JavaliParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterNEGexpr(@NotNull JavaliParser.NEGexprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NEGexpr}
	 * labeled alternative in {@link JavaliParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitNEGexpr(@NotNull JavaliParser.NEGexprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ADDexpr}
	 * labeled alternative in {@link JavaliParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterADDexpr(@NotNull JavaliParser.ADDexprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ADDexpr}
	 * labeled alternative in {@link JavaliParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitADDexpr(@NotNull JavaliParser.ADDexprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StmtIf}
	 * labeled alternative in {@link JavaliParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterStmtIf(@NotNull JavaliParser.StmtIfContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StmtIf}
	 * labeled alternative in {@link JavaliParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitStmtIf(@NotNull JavaliParser.StmtIfContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IAHexpr}
	 * labeled alternative in {@link JavaliParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterIAHexpr(@NotNull JavaliParser.IAHexprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IAHexpr}
	 * labeled alternative in {@link JavaliParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitIAHexpr(@NotNull JavaliParser.IAHexprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code arrayTypePrimitive}
	 * labeled alternative in {@link JavaliParser#arrayType}.
	 * @param ctx the parse tree
	 */
	void enterArrayTypePrimitive(@NotNull JavaliParser.ArrayTypePrimitiveContext ctx);
	/**
	 * Exit a parse tree produced by the {@code arrayTypePrimitive}
	 * labeled alternative in {@link JavaliParser#arrayType}.
	 * @param ctx the parse tree
	 */
	void exitArrayTypePrimitive(@NotNull JavaliParser.ArrayTypePrimitiveContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaliParser#whileStmt}.
	 * @param ctx the parse tree
	 */
	void enterWhileStmt(@NotNull JavaliParser.WhileStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaliParser#whileStmt}.
	 * @param ctx the parse tree
	 */
	void exitWhileStmt(@NotNull JavaliParser.WhileStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaliParser#classDecl}.
	 * @param ctx the parse tree
	 */
	void enterClassDecl(@NotNull JavaliParser.ClassDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaliParser#classDecl}.
	 * @param ctx the parse tree
	 */
	void exitClassDecl(@NotNull JavaliParser.ClassDeclContext ctx);
	/**
	 * Enter a parse tree produced by the {@code GRTexpr}
	 * labeled alternative in {@link JavaliParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterGRTexpr(@NotNull JavaliParser.GRTexprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code GRTexpr}
	 * labeled alternative in {@link JavaliParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitGRTexpr(@NotNull JavaliParser.GRTexprContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaliParser#returnStmt}.
	 * @param ctx the parse tree
	 */
	void enterReturnStmt(@NotNull JavaliParser.ReturnStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaliParser#returnStmt}.
	 * @param ctx the parse tree
	 */
	void exitReturnStmt(@NotNull JavaliParser.ReturnStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code POSexpr}
	 * labeled alternative in {@link JavaliParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterPOSexpr(@NotNull JavaliParser.POSexprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code POSexpr}
	 * labeled alternative in {@link JavaliParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitPOSexpr(@NotNull JavaliParser.POSexprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MODexpr}
	 * labeled alternative in {@link JavaliParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterMODexpr(@NotNull JavaliParser.MODexprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MODexpr}
	 * labeled alternative in {@link JavaliParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitMODexpr(@NotNull JavaliParser.MODexprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code referenceTypeArray}
	 * labeled alternative in {@link JavaliParser#referenceType}.
	 * @param ctx the parse tree
	 */
	void enterReferenceTypeArray(@NotNull JavaliParser.ReferenceTypeArrayContext ctx);
	/**
	 * Exit a parse tree produced by the {@code referenceTypeArray}
	 * labeled alternative in {@link JavaliParser#referenceType}.
	 * @param ctx the parse tree
	 */
	void exitReferenceTypeArray(@NotNull JavaliParser.ReferenceTypeArrayContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaliParser#stmtBlock}.
	 * @param ctx the parse tree
	 */
	void enterStmtBlock(@NotNull JavaliParser.StmtBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaliParser#stmtBlock}.
	 * @param ctx the parse tree
	 */
	void exitStmtBlock(@NotNull JavaliParser.StmtBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaliParser#unit}.
	 * @param ctx the parse tree
	 */
	void enterUnit(@NotNull JavaliParser.UnitContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaliParser#unit}.
	 * @param ctx the parse tree
	 */
	void exitUnit(@NotNull JavaliParser.UnitContext ctx);
	/**
	 * Enter a parse tree produced by the {@code NULLlit}
	 * labeled alternative in {@link JavaliParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterNULLlit(@NotNull JavaliParser.NULLlitContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NULLlit}
	 * labeled alternative in {@link JavaliParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitNULLlit(@NotNull JavaliParser.NULLlitContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LESexpr}
	 * labeled alternative in {@link JavaliParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterLESexpr(@NotNull JavaliParser.LESexprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LESexpr}
	 * labeled alternative in {@link JavaliParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitLESexpr(@NotNull JavaliParser.LESexprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code EQexpr}
	 * labeled alternative in {@link JavaliParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterEQexpr(@NotNull JavaliParser.EQexprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code EQexpr}
	 * labeled alternative in {@link JavaliParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitEQexpr(@NotNull JavaliParser.EQexprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code referenceTypeIdent}
	 * labeled alternative in {@link JavaliParser#referenceType}.
	 * @param ctx the parse tree
	 */
	void enterReferenceTypeIdent(@NotNull JavaliParser.ReferenceTypeIdentContext ctx);
	/**
	 * Exit a parse tree produced by the {@code referenceTypeIdent}
	 * labeled alternative in {@link JavaliParser#referenceType}.
	 * @param ctx the parse tree
	 */
	void exitReferenceTypeIdent(@NotNull JavaliParser.ReferenceTypeIdentContext ctx);
	/**
	 * Enter a parse tree produced by the {@code DIVexpr}
	 * labeled alternative in {@link JavaliParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterDIVexpr(@NotNull JavaliParser.DIVexprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code DIVexpr}
	 * labeled alternative in {@link JavaliParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitDIVexpr(@NotNull JavaliParser.DIVexprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IdentArray}
	 * labeled alternative in {@link JavaliParser#identAccess}.
	 * @param ctx the parse tree
	 */
	void enterIdentArray(@NotNull JavaliParser.IdentArrayContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IdentArray}
	 * labeled alternative in {@link JavaliParser#identAccess}.
	 * @param ctx the parse tree
	 */
	void exitIdentArray(@NotNull JavaliParser.IdentArrayContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StmtMethod}
	 * labeled alternative in {@link JavaliParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterStmtMethod(@NotNull JavaliParser.StmtMethodContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StmtMethod}
	 * labeled alternative in {@link JavaliParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitStmtMethod(@NotNull JavaliParser.StmtMethodContext ctx);
	/**
	 * Enter a parse tree produced by the {@code refType}
	 * labeled alternative in {@link JavaliParser#type}.
	 * @param ctx the parse tree
	 */
	void enterRefType(@NotNull JavaliParser.RefTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code refType}
	 * labeled alternative in {@link JavaliParser#type}.
	 * @param ctx the parse tree
	 */
	void exitRefType(@NotNull JavaliParser.RefTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BOOLlit}
	 * labeled alternative in {@link JavaliParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterBOOLlit(@NotNull JavaliParser.BOOLlitContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BOOLlit}
	 * labeled alternative in {@link JavaliParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitBOOLlit(@NotNull JavaliParser.BOOLlitContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaliParser#methodDecl}.
	 * @param ctx the parse tree
	 */
	void enterMethodDecl(@NotNull JavaliParser.MethodDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaliParser#methodDecl}.
	 * @param ctx the parse tree
	 */
	void exitMethodDecl(@NotNull JavaliParser.MethodDeclContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LEQexpr}
	 * labeled alternative in {@link JavaliParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterLEQexpr(@NotNull JavaliParser.LEQexprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LEQexpr}
	 * labeled alternative in {@link JavaliParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitLEQexpr(@NotNull JavaliParser.LEQexprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ANDexpr}
	 * labeled alternative in {@link JavaliParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterANDexpr(@NotNull JavaliParser.ANDexprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ANDexpr}
	 * labeled alternative in {@link JavaliParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitANDexpr(@NotNull JavaliParser.ANDexprContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaliParser#memberList}.
	 * @param ctx the parse tree
	 */
	void enterMemberList(@NotNull JavaliParser.MemberListContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaliParser#memberList}.
	 * @param ctx the parse tree
	 */
	void exitMemberList(@NotNull JavaliParser.MemberListContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LITexpr}
	 * labeled alternative in {@link JavaliParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterLITexpr(@NotNull JavaliParser.LITexprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LITexpr}
	 * labeled alternative in {@link JavaliParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitLITexpr(@NotNull JavaliParser.LITexprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ORexpr}
	 * labeled alternative in {@link JavaliParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterORexpr(@NotNull JavaliParser.ORexprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ORexpr}
	 * labeled alternative in {@link JavaliParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitORexpr(@NotNull JavaliParser.ORexprContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaliParser#assignmentStmt}.
	 * @param ctx the parse tree
	 */
	void enterAssignmentStmt(@NotNull JavaliParser.AssignmentStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaliParser#assignmentStmt}.
	 * @param ctx the parse tree
	 */
	void exitAssignmentStmt(@NotNull JavaliParser.AssignmentStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaliParser#actualParamList}.
	 * @param ctx the parse tree
	 */
	void enterActualParamList(@NotNull JavaliParser.ActualParamListContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaliParser#actualParamList}.
	 * @param ctx the parse tree
	 */
	void exitActualParamList(@NotNull JavaliParser.ActualParamListContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaliParser#primitiveType}.
	 * @param ctx the parse tree
	 */
	void enterPrimitiveType(@NotNull JavaliParser.PrimitiveTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaliParser#primitiveType}.
	 * @param ctx the parse tree
	 */
	void exitPrimitiveType(@NotNull JavaliParser.PrimitiveTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code primType}
	 * labeled alternative in {@link JavaliParser#type}.
	 * @param ctx the parse tree
	 */
	void enterPrimType(@NotNull JavaliParser.PrimTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code primType}
	 * labeled alternative in {@link JavaliParser#type}.
	 * @param ctx the parse tree
	 */
	void exitPrimType(@NotNull JavaliParser.PrimTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code NewMethod}
	 * labeled alternative in {@link JavaliParser#newExpr}.
	 * @param ctx the parse tree
	 */
	void enterNewMethod(@NotNull JavaliParser.NewMethodContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NewMethod}
	 * labeled alternative in {@link JavaliParser#newExpr}.
	 * @param ctx the parse tree
	 */
	void exitNewMethod(@NotNull JavaliParser.NewMethodContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CASTexpr}
	 * labeled alternative in {@link JavaliParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterCASTexpr(@NotNull JavaliParser.CASTexprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CASTexpr}
	 * labeled alternative in {@link JavaliParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitCASTexpr(@NotNull JavaliParser.CASTexprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code UEQexpr}
	 * labeled alternative in {@link JavaliParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterUEQexpr(@NotNull JavaliParser.UEQexprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code UEQexpr}
	 * labeled alternative in {@link JavaliParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitUEQexpr(@NotNull JavaliParser.UEQexprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IdentField}
	 * labeled alternative in {@link JavaliParser#identAccess}.
	 * @param ctx the parse tree
	 */
	void enterIdentField(@NotNull JavaliParser.IdentFieldContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IdentField}
	 * labeled alternative in {@link JavaliParser#identAccess}.
	 * @param ctx the parse tree
	 */
	void exitIdentField(@NotNull JavaliParser.IdentFieldContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StmtWrite}
	 * labeled alternative in {@link JavaliParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterStmtWrite(@NotNull JavaliParser.StmtWriteContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StmtWrite}
	 * labeled alternative in {@link JavaliParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitStmtWrite(@NotNull JavaliParser.StmtWriteContext ctx);
	/**
	 * Enter a parse tree produced by the {@code PARexpr}
	 * labeled alternative in {@link JavaliParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterPARexpr(@NotNull JavaliParser.PARexprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code PARexpr}
	 * labeled alternative in {@link JavaliParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitPARexpr(@NotNull JavaliParser.PARexprContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaliParser#readExpr}.
	 * @param ctx the parse tree
	 */
	void enterReadExpr(@NotNull JavaliParser.ReadExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaliParser#readExpr}.
	 * @param ctx the parse tree
	 */
	void exitReadExpr(@NotNull JavaliParser.ReadExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaliParser#writeStmt}.
	 * @param ctx the parse tree
	 */
	void enterWriteStmt(@NotNull JavaliParser.WriteStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaliParser#writeStmt}.
	 * @param ctx the parse tree
	 */
	void exitWriteStmt(@NotNull JavaliParser.WriteStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaliParser#methodCallStmt}.
	 * @param ctx the parse tree
	 */
	void enterMethodCallStmt(@NotNull JavaliParser.MethodCallStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaliParser#methodCallStmt}.
	 * @param ctx the parse tree
	 */
	void exitMethodCallStmt(@NotNull JavaliParser.MethodCallStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code NOTexpr}
	 * labeled alternative in {@link JavaliParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterNOTexpr(@NotNull JavaliParser.NOTexprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NOTexpr}
	 * labeled alternative in {@link JavaliParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitNOTexpr(@NotNull JavaliParser.NOTexprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code INTlit}
	 * labeled alternative in {@link JavaliParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterINTlit(@NotNull JavaliParser.INTlitContext ctx);
	/**
	 * Exit a parse tree produced by the {@code INTlit}
	 * labeled alternative in {@link JavaliParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitINTlit(@NotNull JavaliParser.INTlitContext ctx);
	/**
	 * Enter a parse tree produced by the {@code NewType}
	 * labeled alternative in {@link JavaliParser#newExpr}.
	 * @param ctx the parse tree
	 */
	void enterNewType(@NotNull JavaliParser.NewTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NewType}
	 * labeled alternative in {@link JavaliParser#newExpr}.
	 * @param ctx the parse tree
	 */
	void exitNewType(@NotNull JavaliParser.NewTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code NewArray}
	 * labeled alternative in {@link JavaliParser#newExpr}.
	 * @param ctx the parse tree
	 */
	void enterNewArray(@NotNull JavaliParser.NewArrayContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NewArray}
	 * labeled alternative in {@link JavaliParser#newExpr}.
	 * @param ctx the parse tree
	 */
	void exitNewArray(@NotNull JavaliParser.NewArrayContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaliParser#ifStmt}.
	 * @param ctx the parse tree
	 */
	void enterIfStmt(@NotNull JavaliParser.IfStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaliParser#ifStmt}.
	 * @param ctx the parse tree
	 */
	void exitIfStmt(@NotNull JavaliParser.IfStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IdentMethod}
	 * labeled alternative in {@link JavaliParser#identAccess}.
	 * @param ctx the parse tree
	 */
	void enterIdentMethod(@NotNull JavaliParser.IdentMethodContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IdentMethod}
	 * labeled alternative in {@link JavaliParser#identAccess}.
	 * @param ctx the parse tree
	 */
	void exitIdentMethod(@NotNull JavaliParser.IdentMethodContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IdentMethodField}
	 * labeled alternative in {@link JavaliParser#identAccess}.
	 * @param ctx the parse tree
	 */
	void enterIdentMethodField(@NotNull JavaliParser.IdentMethodFieldContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IdentMethodField}
	 * labeled alternative in {@link JavaliParser#identAccess}.
	 * @param ctx the parse tree
	 */
	void exitIdentMethodField(@NotNull JavaliParser.IdentMethodFieldContext ctx);
	/**
	 * Enter a parse tree produced by the {@code arrayTypeIdent}
	 * labeled alternative in {@link JavaliParser#arrayType}.
	 * @param ctx the parse tree
	 */
	void enterArrayTypeIdent(@NotNull JavaliParser.ArrayTypeIdentContext ctx);
	/**
	 * Exit a parse tree produced by the {@code arrayTypeIdent}
	 * labeled alternative in {@link JavaliParser#arrayType}.
	 * @param ctx the parse tree
	 */
	void exitArrayTypeIdent(@NotNull JavaliParser.ArrayTypeIdentContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaliParser#varDecl}.
	 * @param ctx the parse tree
	 */
	void enterVarDecl(@NotNull JavaliParser.VarDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaliParser#varDecl}.
	 * @param ctx the parse tree
	 */
	void exitVarDecl(@NotNull JavaliParser.VarDeclContext ctx);
}