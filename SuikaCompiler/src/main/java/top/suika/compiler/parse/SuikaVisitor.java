// Generated from Suika.g4 by ANTLR 4.9.1

package top.suika.compiler.parse;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link SuikaParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface SuikaVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link SuikaParser#chunk}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitChunk(SuikaParser.ChunkContext ctx);
	/**
	 * Visit a parse tree produced by {@link SuikaParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(SuikaParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link SuikaParser#funDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunDecl(SuikaParser.FunDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link SuikaParser#args}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgs(SuikaParser.ArgsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprStat}
	 * labeled alternative in {@link SuikaParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprStat(SuikaParser.ExprStatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BlockStat}
	 * labeled alternative in {@link SuikaParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlockStat(SuikaParser.BlockStatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code VarDecl}
	 * labeled alternative in {@link SuikaParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarDecl(SuikaParser.VarDeclContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IfStat}
	 * labeled alternative in {@link SuikaParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStat(SuikaParser.IfStatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code WhileStat}
	 * labeled alternative in {@link SuikaParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileStat(SuikaParser.WhileStatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BreakStat}
	 * labeled alternative in {@link SuikaParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBreakStat(SuikaParser.BreakStatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ContinueStat}
	 * labeled alternative in {@link SuikaParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitContinueStat(SuikaParser.ContinueStatContext ctx);
	/**
	 * Visit a parse tree produced by {@link SuikaParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtom(SuikaParser.AtomContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IdentExpr}
	 * labeled alternative in {@link SuikaParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentExpr(SuikaParser.IdentExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AndOrExpr}
	 * labeled alternative in {@link SuikaParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAndOrExpr(SuikaParser.AndOrExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code RelationExpr}
	 * labeled alternative in {@link SuikaParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelationExpr(SuikaParser.RelationExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AssignmentExpr}
	 * labeled alternative in {@link SuikaParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignmentExpr(SuikaParser.AssignmentExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AtomExpr}
	 * labeled alternative in {@link SuikaParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtomExpr(SuikaParser.AtomExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code UnaryExpr}
	 * labeled alternative in {@link SuikaParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryExpr(SuikaParser.UnaryExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IndexExpr}
	 * labeled alternative in {@link SuikaParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIndexExpr(SuikaParser.IndexExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code EqualityExpr}
	 * labeled alternative in {@link SuikaParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqualityExpr(SuikaParser.EqualityExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MulDivModExpr}
	 * labeled alternative in {@link SuikaParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMulDivModExpr(SuikaParser.MulDivModExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IsExpr}
	 * labeled alternative in {@link SuikaParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIsExpr(SuikaParser.IsExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CallExpr}
	 * labeled alternative in {@link SuikaParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCallExpr(SuikaParser.CallExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ParenExpr}
	 * labeled alternative in {@link SuikaParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenExpr(SuikaParser.ParenExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AddSubExpr}
	 * labeled alternative in {@link SuikaParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddSubExpr(SuikaParser.AddSubExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AttrExpr}
	 * labeled alternative in {@link SuikaParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttrExpr(SuikaParser.AttrExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link SuikaParser#exprs}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprs(SuikaParser.ExprsContext ctx);
}