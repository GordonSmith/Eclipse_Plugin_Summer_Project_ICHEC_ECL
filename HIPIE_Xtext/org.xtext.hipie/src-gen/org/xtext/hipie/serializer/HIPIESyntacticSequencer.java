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
	protected AbstractElementAlias match_generate_body_salt_PROFILEKeyword_6_1_or_SCOREDSEARCHKeyword_6_0;
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
		match_generate_body_salt_PROFILEKeyword_6_1_or_SCOREDSEARCHKeyword_6_0 = new AlternativeAlias(false, false, new TokenAlias(false, false, grammarAccess.getGenerate_body_saltAccess().getPROFILEKeyword_6_1()), new TokenAlias(false, false, grammarAccess.getGenerate_body_saltAccess().getSCOREDSEARCHKeyword_6_0()));
		match_out_type___ACTIONKeyword_0_3_or_BOOLKeyword_0_0_or_INTKeyword_0_1_or_STRINGKeyword_0_2__q = new AlternativeAlias(false, true, new TokenAlias(false, false, grammarAccess.getOut_typeAccess().getACTIONKeyword_0_3()), new TokenAlias(false, false, grammarAccess.getOut_typeAccess().getBOOLKeyword_0_0()), new TokenAlias(false, false, grammarAccess.getOut_typeAccess().getINTKeyword_0_1()), new TokenAlias(false, false, grammarAccess.getOut_typeAccess().getSTRINGKeyword_0_2()));
		match_visualization_BARKeyword_0_0_4_or_CHOROKeyword_0_0_0_or_LINEKeyword_0_0_1_or_PIEKeyword_0_0_3_or_TABLEKeyword_0_0_5_or_TIMELINEKeyword_0_0_2 = new AlternativeAlias(false, false, new TokenAlias(false, false, grammarAccess.getVisualizationAccess().getBARKeyword_0_0_4()), new TokenAlias(false, false, grammarAccess.getVisualizationAccess().getCHOROKeyword_0_0_0()), new TokenAlias(false, false, grammarAccess.getVisualizationAccess().getLINEKeyword_0_0_1()), new TokenAlias(false, false, grammarAccess.getVisualizationAccess().getPIEKeyword_0_0_3()), new TokenAlias(false, false, grammarAccess.getVisualizationAccess().getTABLEKeyword_0_0_5()), new TokenAlias(false, false, grammarAccess.getVisualizationAccess().getTIMELINEKeyword_0_0_2()));
	}
	
	@Override
	protected String getUnassignedRuleCallToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if(ruleCall.getRule() == grammarAccess.getGEN_BLOCKRule())
			return getGEN_BLOCKToken(semanticObject, ruleCall, node);
		else if(ruleCall.getRule() == grammarAccess.getIDRule())
			return getIDToken(semanticObject, ruleCall, node);
		else if(ruleCall.getRule() == grammarAccess.getINTRule())
			return getINTToken(semanticObject, ruleCall, node);
		else if(ruleCall.getRule() == grammarAccess.getCategory_typeRule())
			return getcategory_typeToken(semanticObject, ruleCall, node);
		else if(ruleCall.getRule() == grammarAccess.getFormfield_optionRule())
			return getformfield_optionToken(semanticObject, ruleCall, node);
		else if(ruleCall.getRule() == grammarAccess.getInputtype_optionsRule())
			return getinputtype_optionsToken(semanticObject, ruleCall, node);
		return "";
	}
	
	/**
	 * terminal GEN_BLOCK :
	 * 	'INLINE' -> 'ENDGENERATES'
	 * ;
	 */
	protected String getGEN_BLOCKToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "INLINE";
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
			else if(match_generate_body_salt_PROFILEKeyword_6_1_or_SCOREDSEARCHKeyword_6_0.equals(syntax))
				emit_generate_body_salt_PROFILEKeyword_6_1_or_SCOREDSEARCHKeyword_6_0(semanticObject, getLastNavigableState(), syntaxNodes);
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
	 *     name='GENERATES' 'SALT' '(' ID ')' ':' (ambiguity) 'ENDGENERATES' (rule end)
	 */
	protected void emit_generate_body_salt_PROFILEKeyword_6_1_or_SCOREDSEARCHKeyword_6_0(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
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
