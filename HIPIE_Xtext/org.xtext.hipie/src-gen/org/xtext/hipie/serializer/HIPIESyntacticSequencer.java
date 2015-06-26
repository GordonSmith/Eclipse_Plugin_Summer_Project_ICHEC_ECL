/*
 * generated by Xtext
 */
package org.xtext.hipie.serializer;

import com.google.inject.Inject;
import java.util.List;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.AbstractElementAlias;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.AlternativeAlias;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.GroupAlias;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.TokenAlias;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynNavigable;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynTransition;
import org.eclipse.xtext.serializer.sequencer.AbstractSyntacticSequencer;
import org.xtext.hipie.services.HIPIEGrammarAccess;

@SuppressWarnings("all")
public class HIPIESyntacticSequencer extends AbstractSyntacticSequencer {

	protected HIPIEGrammarAccess grammarAccess;
	protected AbstractElementAlias match_category_type_list___CommaKeyword_1_0_Category_typeParserRuleCall_1_1__a;
	protected AbstractElementAlias match_contract_instance___IDTerminalRuleCall_1_0_ColonKeyword_1_1__q;
	protected AbstractElementAlias match_ecl_integer_INTTerminalRuleCall_1_q;
	protected AbstractElementAlias match_ecl_qstring_INTTerminalRuleCall_1_q;
	protected AbstractElementAlias match_ecl_string_INTTerminalRuleCall_1_q;
	protected AbstractElementAlias match_ecl_unicode_INTTerminalRuleCall_1_q;
	protected AbstractElementAlias match_ecl_unsigned_INTTerminalRuleCall_1_q;
	protected AbstractElementAlias match_ecl_varstring_INTTerminalRuleCall_1_q;
	protected AbstractElementAlias match_ecl_varunicode_INTTerminalRuleCall_1_q;
	protected AbstractElementAlias match_generate_body_PROFILEKeyword_1_5_1_or_SCOREDSEARCHKeyword_1_5_0;
	protected AbstractElementAlias match_generate_body___ColonKeyword_0_1_10_or_CommaKeyword_0_1_9_or_ECL_CODETerminalRuleCall_0_1_4_or_EqualsSignKeyword_0_1_11_or_FullStopKeyword_0_1_6_or_HyphenMinusKeyword_0_1_14_or_IDTerminalRuleCall_0_1_0_or_INTTerminalRuleCall_0_1_1_or_LeftCurlyBracketKeyword_0_1_12_or_LeftParenthesisKeyword_0_1_7_or_RightCurlyBracketKeyword_0_1_13_or_RightParenthesisKeyword_0_1_8_or_STRINGTerminalRuleCall_0_1_3_or_SemicolonKeyword_0_1_5_or_WSTerminalRuleCall_0_1_2__a;
	protected AbstractElementAlias match_out_type___ACTIONKeyword_0_3_or_BOOLKeyword_0_0_or_INTKeyword_0_1_or_STRINGKeyword_0_2__q;
	protected AbstractElementAlias match_visualization_BARKeyword_0_0_4_or_CHOROKeyword_0_0_0_or_LINEKeyword_0_0_1_or_PIEKeyword_0_0_3_or_TABLEKeyword_0_0_5_or_TIMELINEKeyword_0_0_2;
	
	@Inject
	protected void init(IGrammarAccess access) {
		grammarAccess = (HIPIEGrammarAccess) access;
		match_category_type_list___CommaKeyword_1_0_Category_typeParserRuleCall_1_1__a = new GroupAlias(true, true, new TokenAlias(false, false, grammarAccess.getCategory_type_listAccess().getCommaKeyword_1_0()), new TokenAlias(false, false, grammarAccess.getCategory_type_listAccess().getCategory_typeParserRuleCall_1_1()));
		match_contract_instance___IDTerminalRuleCall_1_0_ColonKeyword_1_1__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getContract_instanceAccess().getIDTerminalRuleCall_1_0()), new TokenAlias(false, false, grammarAccess.getContract_instanceAccess().getColonKeyword_1_1()));
		match_ecl_integer_INTTerminalRuleCall_1_q = new TokenAlias(false, true, grammarAccess.getEcl_integerAccess().getINTTerminalRuleCall_1());
		match_ecl_qstring_INTTerminalRuleCall_1_q = new TokenAlias(false, true, grammarAccess.getEcl_qstringAccess().getINTTerminalRuleCall_1());
		match_ecl_string_INTTerminalRuleCall_1_q = new TokenAlias(false, true, grammarAccess.getEcl_stringAccess().getINTTerminalRuleCall_1());
		match_ecl_unicode_INTTerminalRuleCall_1_q = new TokenAlias(false, true, grammarAccess.getEcl_unicodeAccess().getINTTerminalRuleCall_1());
		match_ecl_unsigned_INTTerminalRuleCall_1_q = new TokenAlias(false, true, grammarAccess.getEcl_unsignedAccess().getINTTerminalRuleCall_1());
		match_ecl_varstring_INTTerminalRuleCall_1_q = new TokenAlias(false, true, grammarAccess.getEcl_varstringAccess().getINTTerminalRuleCall_1());
		match_ecl_varunicode_INTTerminalRuleCall_1_q = new TokenAlias(false, true, grammarAccess.getEcl_varunicodeAccess().getINTTerminalRuleCall_1());
		match_generate_body_PROFILEKeyword_1_5_1_or_SCOREDSEARCHKeyword_1_5_0 = new AlternativeAlias(false, false, new TokenAlias(false, false, grammarAccess.getGenerate_bodyAccess().getPROFILEKeyword_1_5_1()), new TokenAlias(false, false, grammarAccess.getGenerate_bodyAccess().getSCOREDSEARCHKeyword_1_5_0()));
		match_generate_body___ColonKeyword_0_1_10_or_CommaKeyword_0_1_9_or_ECL_CODETerminalRuleCall_0_1_4_or_EqualsSignKeyword_0_1_11_or_FullStopKeyword_0_1_6_or_HyphenMinusKeyword_0_1_14_or_IDTerminalRuleCall_0_1_0_or_INTTerminalRuleCall_0_1_1_or_LeftCurlyBracketKeyword_0_1_12_or_LeftParenthesisKeyword_0_1_7_or_RightCurlyBracketKeyword_0_1_13_or_RightParenthesisKeyword_0_1_8_or_STRINGTerminalRuleCall_0_1_3_or_SemicolonKeyword_0_1_5_or_WSTerminalRuleCall_0_1_2__a = new AlternativeAlias(true, true, new TokenAlias(false, false, grammarAccess.getGenerate_bodyAccess().getColonKeyword_0_1_10()), new TokenAlias(false, false, grammarAccess.getGenerate_bodyAccess().getCommaKeyword_0_1_9()), new TokenAlias(false, false, grammarAccess.getGenerate_bodyAccess().getECL_CODETerminalRuleCall_0_1_4()), new TokenAlias(false, false, grammarAccess.getGenerate_bodyAccess().getEqualsSignKeyword_0_1_11()), new TokenAlias(false, false, grammarAccess.getGenerate_bodyAccess().getFullStopKeyword_0_1_6()), new TokenAlias(false, false, grammarAccess.getGenerate_bodyAccess().getHyphenMinusKeyword_0_1_14()), new TokenAlias(false, false, grammarAccess.getGenerate_bodyAccess().getIDTerminalRuleCall_0_1_0()), new TokenAlias(false, false, grammarAccess.getGenerate_bodyAccess().getINTTerminalRuleCall_0_1_1()), new TokenAlias(false, false, grammarAccess.getGenerate_bodyAccess().getLeftCurlyBracketKeyword_0_1_12()), new TokenAlias(false, false, grammarAccess.getGenerate_bodyAccess().getLeftParenthesisKeyword_0_1_7()), new TokenAlias(false, false, grammarAccess.getGenerate_bodyAccess().getRightCurlyBracketKeyword_0_1_13()), new TokenAlias(false, false, grammarAccess.getGenerate_bodyAccess().getRightParenthesisKeyword_0_1_8()), new TokenAlias(false, false, grammarAccess.getGenerate_bodyAccess().getSTRINGTerminalRuleCall_0_1_3()), new TokenAlias(false, false, grammarAccess.getGenerate_bodyAccess().getSemicolonKeyword_0_1_5()), new TokenAlias(false, false, grammarAccess.getGenerate_bodyAccess().getWSTerminalRuleCall_0_1_2()));
		match_out_type___ACTIONKeyword_0_3_or_BOOLKeyword_0_0_or_INTKeyword_0_1_or_STRINGKeyword_0_2__q = new AlternativeAlias(false, true, new TokenAlias(false, false, grammarAccess.getOut_typeAccess().getACTIONKeyword_0_3()), new TokenAlias(false, false, grammarAccess.getOut_typeAccess().getBOOLKeyword_0_0()), new TokenAlias(false, false, grammarAccess.getOut_typeAccess().getINTKeyword_0_1()), new TokenAlias(false, false, grammarAccess.getOut_typeAccess().getSTRINGKeyword_0_2()));
		match_visualization_BARKeyword_0_0_4_or_CHOROKeyword_0_0_0_or_LINEKeyword_0_0_1_or_PIEKeyword_0_0_3_or_TABLEKeyword_0_0_5_or_TIMELINEKeyword_0_0_2 = new AlternativeAlias(false, false, new TokenAlias(false, false, grammarAccess.getVisualizationAccess().getBARKeyword_0_0_4()), new TokenAlias(false, false, grammarAccess.getVisualizationAccess().getCHOROKeyword_0_0_0()), new TokenAlias(false, false, grammarAccess.getVisualizationAccess().getLINEKeyword_0_0_1()), new TokenAlias(false, false, grammarAccess.getVisualizationAccess().getPIEKeyword_0_0_3()), new TokenAlias(false, false, grammarAccess.getVisualizationAccess().getTABLEKeyword_0_0_5()), new TokenAlias(false, false, grammarAccess.getVisualizationAccess().getTIMELINEKeyword_0_0_2()));
	}
	
	@Override
	protected String getUnassignedRuleCallToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if(ruleCall.getRule() == grammarAccess.getECL_CODERule())
			return getECL_CODEToken(semanticObject, ruleCall, node);
		else if(ruleCall.getRule() == grammarAccess.getIDRule())
			return getIDToken(semanticObject, ruleCall, node);
		else if(ruleCall.getRule() == grammarAccess.getINTRule())
			return getINTToken(semanticObject, ruleCall, node);
		else if(ruleCall.getRule() == grammarAccess.getSTRINGRule())
			return getSTRINGToken(semanticObject, ruleCall, node);
		else if(ruleCall.getRule() == grammarAccess.getWSRule())
			return getWSToken(semanticObject, ruleCall, node);
		else if(ruleCall.getRule() == grammarAccess.getCategory_typeRule())
			return getcategory_typeToken(semanticObject, ruleCall, node);
		else if(ruleCall.getRule() == grammarAccess.getFormfield_optionRule())
			return getformfield_optionToken(semanticObject, ruleCall, node);
		else if(ruleCall.getRule() == grammarAccess.getInputtype_optionsRule())
			return getinputtype_optionsToken(semanticObject, ruleCall, node);
		return "";
	}
	
	/**
	 * terminal ECL_CODE :
	 * '%' (!'%')* '%'
	 * ;
	 */
	protected String getECL_CODEToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "%%";
	}
	
	/**
	 * terminal ID  		: '^'?('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;
	 */
	protected String getIDToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "";
	}
	
	/**
	 * terminal INT returns ecore::EInt:
	 * ('0'..'9')+;
	 */
	protected String getINTToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "";
	}
	
	/**
	 * terminal STRING :
	 * '"' ( '\\'('b'|'t'|'n'|'f'|'r'|'u'|'"'|"'"|'\\') | !('\\'|'"') )* '"' |
	 * "'" ( '\\'('b'|'t'|'n'|'f'|'r'|'u'|'"'|"'"|'\\') | !('\\'|"'") )* "'";
	 */
	protected String getSTRINGToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "\"\"";
	}
	
	/**
	 * terminal WS :  (' '|'\t'|'\r'|'\n')+ ;
	 */
	protected String getWSToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return " ";
	}
	
	/**
	 * category_type: 'CLEAN' | 'INPUT' | 'APPEND' | 'LINK' | 'ANALYSIS' | 'CUSTOM' | 'VISUALIZE' | 'OUTPUT' ;
	 */
	protected String getcategory_typeToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "CLEAN";
	}
	
	/**
	 * formfield_option: ('CHECKBOX'|'RADIO'|'SELECT'|'MULTIPLESELECT'|'TEXTAREA'|'HIDDEN'|'TEXT');
	 */
	protected String getformfield_optionToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "CHECKBOX";
	}
	
	/**
	 * inputtype_options: inputtype_option ( ',' inputtype_option )*;
	 */
	protected String getinputtype_optionsToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "STRING";
	}
	
	@Override
	protected void emitUnassignedTokens(EObject semanticObject, ISynTransition transition, INode fromNode, INode toNode) {
		if (transition.getAmbiguousSyntaxes().isEmpty()) return;
		List<INode> transitionNodes = collectNodes(fromNode, toNode);
		for (AbstractElementAlias syntax : transition.getAmbiguousSyntaxes()) {
			List<INode> syntaxNodes = getNodesFor(transitionNodes, syntax);
			if(match_category_type_list___CommaKeyword_1_0_Category_typeParserRuleCall_1_1__a.equals(syntax))
				emit_category_type_list___CommaKeyword_1_0_Category_typeParserRuleCall_1_1__a(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_contract_instance___IDTerminalRuleCall_1_0_ColonKeyword_1_1__q.equals(syntax))
				emit_contract_instance___IDTerminalRuleCall_1_0_ColonKeyword_1_1__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_ecl_integer_INTTerminalRuleCall_1_q.equals(syntax))
				emit_ecl_integer_INTTerminalRuleCall_1_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_ecl_qstring_INTTerminalRuleCall_1_q.equals(syntax))
				emit_ecl_qstring_INTTerminalRuleCall_1_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_ecl_string_INTTerminalRuleCall_1_q.equals(syntax))
				emit_ecl_string_INTTerminalRuleCall_1_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_ecl_unicode_INTTerminalRuleCall_1_q.equals(syntax))
				emit_ecl_unicode_INTTerminalRuleCall_1_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_ecl_unsigned_INTTerminalRuleCall_1_q.equals(syntax))
				emit_ecl_unsigned_INTTerminalRuleCall_1_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_ecl_varstring_INTTerminalRuleCall_1_q.equals(syntax))
				emit_ecl_varstring_INTTerminalRuleCall_1_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_ecl_varunicode_INTTerminalRuleCall_1_q.equals(syntax))
				emit_ecl_varunicode_INTTerminalRuleCall_1_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_generate_body_PROFILEKeyword_1_5_1_or_SCOREDSEARCHKeyword_1_5_0.equals(syntax))
				emit_generate_body_PROFILEKeyword_1_5_1_or_SCOREDSEARCHKeyword_1_5_0(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_generate_body___ColonKeyword_0_1_10_or_CommaKeyword_0_1_9_or_ECL_CODETerminalRuleCall_0_1_4_or_EqualsSignKeyword_0_1_11_or_FullStopKeyword_0_1_6_or_HyphenMinusKeyword_0_1_14_or_IDTerminalRuleCall_0_1_0_or_INTTerminalRuleCall_0_1_1_or_LeftCurlyBracketKeyword_0_1_12_or_LeftParenthesisKeyword_0_1_7_or_RightCurlyBracketKeyword_0_1_13_or_RightParenthesisKeyword_0_1_8_or_STRINGTerminalRuleCall_0_1_3_or_SemicolonKeyword_0_1_5_or_WSTerminalRuleCall_0_1_2__a.equals(syntax))
				emit_generate_body___ColonKeyword_0_1_10_or_CommaKeyword_0_1_9_or_ECL_CODETerminalRuleCall_0_1_4_or_EqualsSignKeyword_0_1_11_or_FullStopKeyword_0_1_6_or_HyphenMinusKeyword_0_1_14_or_IDTerminalRuleCall_0_1_0_or_INTTerminalRuleCall_0_1_1_or_LeftCurlyBracketKeyword_0_1_12_or_LeftParenthesisKeyword_0_1_7_or_RightCurlyBracketKeyword_0_1_13_or_RightParenthesisKeyword_0_1_8_or_STRINGTerminalRuleCall_0_1_3_or_SemicolonKeyword_0_1_5_or_WSTerminalRuleCall_0_1_2__a(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_out_type___ACTIONKeyword_0_3_or_BOOLKeyword_0_0_or_INTKeyword_0_1_or_STRINGKeyword_0_2__q.equals(syntax))
				emit_out_type___ACTIONKeyword_0_3_or_BOOLKeyword_0_0_or_INTKeyword_0_1_or_STRINGKeyword_0_2__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_visualization_BARKeyword_0_0_4_or_CHOROKeyword_0_0_0_or_LINEKeyword_0_0_1_or_PIEKeyword_0_0_3_or_TABLEKeyword_0_0_5_or_TIMELINEKeyword_0_0_2.equals(syntax))
				emit_visualization_BARKeyword_0_0_4_or_CHOROKeyword_0_0_0_or_LINEKeyword_0_0_1_or_PIEKeyword_0_0_3_or_TABLEKeyword_0_0_5_or_TIMELINEKeyword_0_0_2(semanticObject, getLastNavigableState(), syntaxNodes);
			else acceptNodes(getLastNavigableState(), syntaxNodes);
		}
	}

	/**
	 * Ambiguous syntax:
	 *     (',' category_type)*
	 *
	 * This ambiguous syntax occurs at:
	 *     name=category_type (ambiguity) (rule end)
	 */
	protected void emit_category_type_list___CommaKeyword_1_0_Category_typeParserRuleCall_1_1__a(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     (ID ':')?
	 *
	 * This ambiguous syntax occurs at:
	 *     name='INSTANCE' (ambiguity) vals+=value
	 */
	protected void emit_contract_instance___IDTerminalRuleCall_1_0_ColonKeyword_1_1__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     INT?
	 *
	 * This ambiguous syntax occurs at:
	 *     (rule start) 'INTEGER' (ambiguity) name=ID
	 */
	protected void emit_ecl_integer_INTTerminalRuleCall_1_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     INT?
	 *
	 * This ambiguous syntax occurs at:
	 *     (rule start) 'QSTRING' (ambiguity) name=ID
	 */
	protected void emit_ecl_qstring_INTTerminalRuleCall_1_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     INT?
	 *
	 * This ambiguous syntax occurs at:
	 *     (rule start) 'STRING' (ambiguity) name=ID
	 */
	protected void emit_ecl_string_INTTerminalRuleCall_1_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     INT?
	 *
	 * This ambiguous syntax occurs at:
	 *     (rule start) 'UNICODE' (ambiguity) name=ID
	 */
	protected void emit_ecl_unicode_INTTerminalRuleCall_1_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     INT?
	 *
	 * This ambiguous syntax occurs at:
	 *     (rule start) 'UNSIGNED' (ambiguity) name=ID
	 */
	protected void emit_ecl_unsigned_INTTerminalRuleCall_1_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     INT?
	 *
	 * This ambiguous syntax occurs at:
	 *     (rule start) 'VARSTRING' (ambiguity) name=ID
	 */
	protected void emit_ecl_varstring_INTTerminalRuleCall_1_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     INT?
	 *
	 * This ambiguous syntax occurs at:
	 *     (rule start) 'VARUNICODE' (ambiguity) name=ID
	 */
	protected void emit_ecl_varunicode_INTTerminalRuleCall_1_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     'SCOREDSEARCH' | 'PROFILE'
	 *
	 * This ambiguous syntax occurs at:
	 *     name='SALT' '(' ID ')' ':' (ambiguity) (rule end)
	 */
	protected void emit_generate_body_PROFILEKeyword_1_5_1_or_SCOREDSEARCHKeyword_1_5_0(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     (
	  *         ID | 
	  *         INT | 
	  *         WS | 
	  *         STRING | 
	  *         ECL_CODE | 
	  *         ';' | 
	  *         '.' | 
	  *         '(' | 
	  *         ')' | 
	  *         ',' | 
	  *         ':' | 
	  *         '=' | 
	  *         '{' | 
	  *         '}' | 
	  *         '-'
	  *     )*
	 *
	 * This ambiguous syntax occurs at:
	 *     name='INLINE' (ambiguity) (rule end)
	 */
	protected void emit_generate_body___ColonKeyword_0_1_10_or_CommaKeyword_0_1_9_or_ECL_CODETerminalRuleCall_0_1_4_or_EqualsSignKeyword_0_1_11_or_FullStopKeyword_0_1_6_or_HyphenMinusKeyword_0_1_14_or_IDTerminalRuleCall_0_1_0_or_INTTerminalRuleCall_0_1_1_or_LeftCurlyBracketKeyword_0_1_12_or_LeftParenthesisKeyword_0_1_7_or_RightCurlyBracketKeyword_0_1_13_or_RightParenthesisKeyword_0_1_8_or_STRINGTerminalRuleCall_0_1_3_or_SemicolonKeyword_0_1_5_or_WSTerminalRuleCall_0_1_2__a(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     ('BOOL' | 'INT' | 'STRING' | 'ACTION')?
	 *
	 * This ambiguous syntax occurs at:
	 *     (rule start) (ambiguity) name=ID
	 *     (rule start) (ambiguity) name=STRING
	 *     (rule start) (ambiguity) type=INT
	 */
	protected void emit_out_type___ACTIONKeyword_0_3_or_BOOLKeyword_0_0_or_INTKeyword_0_1_or_STRINGKeyword_0_2__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     (
	  *         'CHORO' | 
	  *         'LINE' | 
	  *         'TIMELINE' | 
	  *         'PIE' | 
	  *         'BAR' | 
	  *         'TABLE'
	  *     )
	 *
	 * This ambiguous syntax occurs at:
	 *     (rule start) (ambiguity) name=ID
	 */
	protected void emit_visualization_BARKeyword_0_0_4_or_CHOROKeyword_0_0_0_or_LINEKeyword_0_0_1_or_PIEKeyword_0_0_3_or_TABLEKeyword_0_0_5_or_TIMELINEKeyword_0_0_2(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
}
