package org.everbuild.terrascript.formatting

import com.intellij.formatting.ASTBlock
import com.intellij.formatting.Alignment
import com.intellij.formatting.Block
import com.intellij.formatting.ChildAttributes
import com.intellij.formatting.Indent
import com.intellij.formatting.Spacing
import com.intellij.formatting.SpacingBuilder
import com.intellij.formatting.Wrap
import com.intellij.lang.ASTNode
import com.intellij.openapi.util.TextRange
import com.intellij.psi.TokenType // Import TokenType
import com.intellij.psi.codeStyle.CodeStyleSettings
import com.intellij.psi.tree.TokenSet
import org.everbuild.terrascript.TerrascriptLanguage
import org.everbuild.terrascript.psi.TesfTypes

class TerrascriptBlock(
    private val node: ASTNode,
    private val alignment: Alignment?,
    private val indent: Indent?,
    private val wrap: Wrap?,
    private val settings: CodeStyleSettings
) : ASTBlock {
    private val spacingBuilder = createSpacingBuilder(settings)

    override fun getNode(): ASTNode = node
    override fun getTextRange(): TextRange = node.textRange
    override fun getWrap(): Wrap? = wrap
    override fun getIndent(): Indent? = indent
    override fun getAlignment(): Alignment? = alignment
    override fun isLeaf(): Boolean = node.firstChildNode == null
    override fun isIncomplete(): Boolean = false
    override fun getChildAttributes(newChildIndex: Int): ChildAttributes {
        if (node.elementType == TesfTypes.BLOCK ||
            node.elementType == TesfTypes.IF_STATEMENT ||
            node.elementType == TesfTypes.FOR_LOOP ||
            node.elementType == TesfTypes.WHILE_LOOP) {
            return ChildAttributes(Indent.getNormalIndent(), null)
        }
        return ChildAttributes(Indent.getNoneIndent(), null)
    }

    override fun getSubBlocks(): List<Block> {
        val blocks = ArrayList<Block>()
        var child = node.firstChildNode
        while (child != null) {
            if (child.elementType != TokenType.WHITE_SPACE && child.textLength > 0) {
                val block = TerrascriptBlock(
                    child,
                    null,
                    calcIndent(child),
                    null,
                    settings
                )
                blocks.add(block)
            }
            child = child.treeNext
        }
        return blocks
    }

    private fun calcIndent(child: ASTNode): Indent? {
        val parentType = node.elementType
        val childType = child.elementType

        if (parentType == TesfTypes.BLOCK) {
            if (childType != TesfTypes.LBRACE && childType != TesfTypes.RBRACE) {
                return Indent.getNormalIndent()
            }
        } else if (parentType == TesfTypes.FOR_LOOP ||
                  parentType == TesfTypes.WHILE_LOOP ||
                  parentType == TesfTypes.IF_STATEMENT) {
            if (childType == TesfTypes.BLOCK) {
                return Indent.getNormalIndent()
            }
        }
        return Indent.getNoneIndent()
    }

    override fun getSpacing(child1: Block?, child2: Block): Spacing? {
        return spacingBuilder.getSpacing(this, child1, child2)
    }

    companion object {
        private val operators = TokenSet.create(
            TesfTypes.PLUS,
            TesfTypes.MINUS,
            TesfTypes.MUL,
            TesfTypes.DIV,
            TesfTypes.MOD,
            TesfTypes.EQ,
            TesfTypes.EQEQ,
            TesfTypes.NEQ,
            TesfTypes.LT,
            TesfTypes.GT,
            TesfTypes.LE,
            TesfTypes.GE,
            TesfTypes.L_AND,
            TesfTypes.L_OR
        )

        private fun createSpacingBuilder(settings: CodeStyleSettings): SpacingBuilder {
            return SpacingBuilder(settings, TerrascriptLanguage)
                .around(operators).spaceIf(true)
                .after(TesfTypes.COMMA).spaceIf(true)
                .afterInside(TesfTypes.SEMICOLON, TesfTypes.FOR_LOOP).spaceIf(true)
                .before(TesfTypes.LBRACE).spaceIf(true)
                .after(TesfTypes.LBRACE).lineBreakInCode()
                .before(TesfTypes.RBRACE).lineBreakInCode()
                .between(TesfTypes.IF_STATEMENT, TesfTypes.ELSE_BLOCK).spaceIf(true)
                .beforeInside(TesfTypes.BLOCK, TesfTypes.IF_STATEMENT).spaceIf(true)
                .around(TesfTypes.ELSE).spaceIf(true)
                .before(TesfTypes.ELSE).spaceIf(true)
                .after(TesfTypes.LPAREN).spaceIf(false)
                .before(TesfTypes.RPAREN).spaceIf(false)
                .between(TesfTypes.IF, TesfTypes.LPAREN).spaceIf(true)
                .between(TesfTypes.FOR, TesfTypes.LPAREN).spaceIf(true)
                .between(TesfTypes.WHILE, TesfTypes.LPAREN).spaceIf(true)
                .between(TesfTypes.SEMICOLON, TesfTypes.EXPRESSION).lineBreakInCode()
                .between(TesfTypes.SEMICOLON, TesfTypes.VARIABLE_DECLARATION).lineBreakInCode()
                .between(TesfTypes.SEMICOLON, TesfTypes.IF_STATEMENT).lineBreakInCode()
                .between(TesfTypes.SEMICOLON, TesfTypes.FOR_LOOP).lineBreakInCode()
                .between(TesfTypes.SEMICOLON, TesfTypes.WHILE_LOOP).lineBreakInCode()
                .after(TesfTypes.BLOCK).lineBreakInCode()
        }
    }
}