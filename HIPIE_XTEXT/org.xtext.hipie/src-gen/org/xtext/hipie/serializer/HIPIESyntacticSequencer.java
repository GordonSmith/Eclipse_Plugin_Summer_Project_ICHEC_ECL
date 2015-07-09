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
	protected AbstractElementAlias match_CustomPermissionLevel_GROUPKeyword_0_1_or_USERKeyword_0_0;
	protected AbstractElementAlias match_ECLDecType_INTTerminalRuleCall_1_q;
	protected AbstractElementAlias match_ECLInteger_INTTerminalRuleCall_1_q;
	protected AbstractElementAlias match_ECLNumType_INTTerminalRuleCall_1_q;
	protected AbstractElementAlias match_ECLQstring_INTTerminalRuleCall_1_q;
	protected AbstractElementAlias match_ECLString_INTTerminalRuleCall_1_q;
	protected AbstractElementAlias match_ECLUnicode_INTTerminalRuleCall_1_q;
	protected AbstractElementAlias match_ECLUnsigned_INTTerminalRuleCall_1_q;
	protected AbstractElementAlias match_ECLVarstring_INTTerminalRuleCall_1_q;
	protected AbstractElementAlias match_ECLVarunicode_INTTerminalRuleCall_1_q;
	protected AbstractElementAlias match_Function___SCALEKeyword_6_0_LeftParenthesisKeyword_6_1___AggFunctionParserRuleCall_6_2_1_or_CountFunctionParserRuleCall_6_2_0___CommaKeyword_6_3_INTTerminalRuleCall_6_4_RightParenthesisKeyword_6_5___or_____AggFunctionParserRuleCall_2_or_CountFunctionParserRuleCall_4___or___HyphenMinusKeyword_3_0_AggFunctionParserRuleCall_3_1___or___HyphenMinusKeyword_5_0_CountFunctionParserRuleCall_5_1____;
	protected AbstractElementAlias match_GenerateBodySalt_PROFILEKeyword_6_1_or_SCOREDSEARCHKeyword_6_0;
	protected AbstractElementAlias match_InstanceOption_LABELKeyword_0_0_or_VERSIONKeyword_0_1;
	protected AbstractElementAlias match_OutTypeSimple___ACTIONKeyword_0_3_or_BOOLKeyword_0_0_or_INTKeyword_0_1_or_STRINGKeyword_0_2__q;
	protected AbstractElementAlias match_OutputOption_FILLSKeyword_4_0_1_or_SOAPKeyword_4_0_2_or_WUIDKeyword_4_0_0;
	protected AbstractElementAlias match_OutputOption_FROMKeyword_1_0_1_or_WUIDKeyword_1_0_0;
	protected AbstractElementAlias match_Permission_PRIVATEKeyword_2_1_or_PUBLICKeyword_2_0;
	protected AbstractElementAlias match_ResourceOption_CLUSTERKeyword_0_7_or_DALIIPKeyword_0_6_or_DESCRIPTIONKeyword_0_2_or_FILENAMEKeyword_0_3_or_FONTKeyword_0_0_or_LABELKeyword_0_4_or_URLKeyword_0_5_or_VALUEKeyword_0_1;
	protected AbstractElementAlias match_VisFilter_LeftParenthesisKeyword_0_p;
	
	@Inject
	protected void init(IGrammarAccess access) {
		grammarAccess = (HIPIEGrammarAccess) access;
		match_CustomPermissionLevel_GROUPKeyword_0_1_or_USERKeyword_0_0 = new AlternativeAlias(false, false, new TokenAlias(false, false, grammarAccess.getCustomPermissionLevelAccess().getGROUPKeyword_0_1()), new TokenAlias(false, false, grammarAccess.getCustomPermissionLevelAccess().getUSERKeyword_0_0()));
		match_ECLDecType_INTTerminalRuleCall_1_q = new TokenAlias(false, true, grammarAccess.getECLDecTypeAccess().getINTTerminalRuleCall_1());
		match_ECLInteger_INTTerminalRuleCall_1_q = new TokenAlias(false, true, grammarAccess.getECLIntegerAccess().getINTTerminalRuleCall_1());
		match_ECLNumType_INTTerminalRuleCall_1_q = new TokenAlias(false, true, grammarAccess.getECLNumTypeAccess().getINTTerminalRuleCall_1());
		match_ECLQstring_INTTerminalRuleCall_1_q = new TokenAlias(false, true, grammarAccess.getECLQstringAccess().getINTTerminalRuleCall_1());
		match_ECLString_INTTerminalRuleCall_1_q = new TokenAlias(false, true, grammarAccess.getECLStringAccess().getINTTerminalRuleCall_1());
		match_ECLUnicode_INTTerminalRuleCall_1_q = new TokenAlias(false, true, grammarAccess.getECLUnicodeAccess().getINTTerminalRuleCall_1());
		match_ECLUnsigned_INTTerminalRuleCall_1_q = new TokenAlias(false, true, grammarAccess.getECLUnsignedAccess().getINTTerminalRuleCall_1());
		match_ECLVarstring_INTTerminalRuleCall_1_q = new TokenAlias(false, true, grammarAccess.getECLVarstringAccess().getINTTerminalRuleCall_1());
		match_ECLVarunicode_INTTerminalRuleCall_1_q = new TokenAlias(false, true, grammarAccess.getECLVarunicodeAccess().getINTTerminalRuleCall_1());
		match_Function___SCALEKeyword_6_0_LeftParenthesisKeyword_6_1___AggFunctionParserRuleCall_6_2_1_or_CountFunctionParserRuleCall_6_2_0___CommaKeyword_6_3_INTTerminalRuleCall_6_4_RightParenthesisKeyword_6_5___or_____AggFunctionParserRuleCall_2_or_CountFunctionParserRuleCall_4___or___HyphenMinusKeyword_3_0_AggFunctionParserRuleCall_3_1___or___HyphenMinusKeyword_5_0_CountFunctionParserRuleCall_5_1____ = new AlternativeAlias(false, false, new AlternativeAlias(false, false, new AlternativeAlias(false, false, new TokenAlias(false, false, grammarAccess.getFunctionAccess().getAggFunctionParserRuleCall_2()), new TokenAlias(false, false, grammarAccess.getFunctionAccess().getCountFunctionParserRuleCall_4())), new GroupAlias(false, false, new TokenAlias(false, false, grammarAccess.getFunctionAccess().getHyphenMinusKeyword_3_0()), new TokenAlias(false, false, grammarAccess.getFunctionAccess().getAggFunctionParserRuleCall_3_1())), new GroupAlias(false, false, new TokenAlias(false, false, grammarAccess.getFunctionAccess().getHyphenMinusKeyword_5_0()), new TokenAlias(false, false, grammarAccess.getFunctionAccess().getCountFunctionParserRuleCall_5_1()))), new GroupAlias(false, false, new TokenAlias(false, false, grammarAccess.getFunctionAccess().getSCALEKeyword_6_0()), new TokenAlias(false, false, grammarAccess.getFunctionAccess().getLeftParenthesisKeyword_6_1()), new AlternativeAlias(false, false, new TokenAlias(false, false, grammarAccess.getFunctionAccess().getAggFunctionParserRuleCall_6_2_1()), new TokenAlias(false, false, grammarAccess.getFunctionAccess().getCountFunctionParserRuleCall_6_2_0())), new TokenAlias(false, false, grammarAccess.getFunctionAccess().getCommaKeyword_6_3()), new TokenAlias(false, false, grammarAccess.getFunctionAccess().getINTTerminalRuleCall_6_4()), new TokenAlias(false, false, grammarAccess.getFunctionAccess().getRightParenthesisKeyword_6_5())));
		match_GenerateBodySalt_PROFILEKeyword_6_1_or_SCOREDSEARCHKeyword_6_0 = new AlternativeAlias(false, false, new TokenAlias(false, false, grammarAccess.getGenerateBodySaltAccess().getPROFILEKeyword_6_1()), new TokenAlias(false, false, grammarAccess.getGenerateBodySaltAccess().getSCOREDSEARCHKeyword_6_0()));
		match_InstanceOption_LABELKeyword_0_0_or_VERSIONKeyword_0_1 = new AlternativeAlias(false, false, new TokenAlias(false, false, grammarAccess.getInstanceOptionAccess().getLABELKeyword_0_0()), new TokenAlias(false, false, grammarAccess.getInstanceOptionAccess().getVERSIONKeyword_0_1()));
		match_OutTypeSimple___ACTIONKeyword_0_3_or_BOOLKeyword_0_0_or_INTKeyword_0_1_or_STRINGKeyword_0_2__q = new AlternativeAlias(false, true, new TokenAlias(false, false, grammarAccess.getOutTypeSimpleAccess().getACTIONKeyword_0_3()), new TokenAlias(false, false, grammarAccess.getOutTypeSimpleAccess().getBOOLKeyword_0_0()), new TokenAlias(false, false, grammarAccess.getOutTypeSimpleAccess().getINTKeyword_0_1()), new TokenAlias(false, false, grammarAccess.getOutTypeSimpleAccess().getSTRINGKeyword_0_2()));
		match_OutputOption_FILLSKeyword_4_0_1_or_SOAPKeyword_4_0_2_or_WUIDKeyword_4_0_0 = new AlternativeAlias(false, false, new TokenAlias(false, false, grammarAccess.getOutputOptionAccess().getFILLSKeyword_4_0_1()), new TokenAlias(false, false, grammarAccess.getOutputOptionAccess().getSOAPKeyword_4_0_2()), new TokenAlias(false, false, grammarAccess.getOutputOptionAccess().getWUIDKeyword_4_0_0()));
		match_OutputOption_FROMKeyword_1_0_1_or_WUIDKeyword_1_0_0 = new AlternativeAlias(false, false, new TokenAlias(false, false, grammarAccess.getOutputOptionAccess().getFROMKeyword_1_0_1()), new TokenAlias(false, false, grammarAccess.getOutputOptionAccess().getWUIDKeyword_1_0_0()));
		match_Permission_PRIVATEKeyword_2_1_or_PUBLICKeyword_2_0 = new AlternativeAlias(false, false, new TokenAlias(false, false, grammarAccess.getPermissionAccess().getPRIVATEKeyword_2_1()), new TokenAlias(false, false, grammarAccess.getPermissionAccess().getPUBLICKeyword_2_0()));
		match_ResourceOption_CLUSTERKeyword_0_7_or_DALIIPKeyword_0_6_or_DESCRIPTIONKeyword_0_2_or_FILENAMEKeyword_0_3_or_FONTKeyword_0_0_or_LABELKeyword_0_4_or_URLKeyword_0_5_or_VALUEKeyword_0_1 = new AlternativeAlias(false, false, new TokenAlias(false, false, grammarAccess.getResourceOptionAccess().getCLUSTERKeyword_0_7()), new TokenAlias(false, false, grammarAccess.getResourceOptionAccess().getDALIIPKeyword_0_6()), new TokenAlias(false, false, grammarAccess.getResourceOptionAccess().getDESCRIPTIONKeyword_0_2()), new TokenAlias(false, false, grammarAccess.getResourceOptionAccess().getFILENAMEKeyword_0_3()), new TokenAlias(false, false, grammarAccess.getResourceOptionAccess().getFONTKeyword_0_0()), new TokenAlias(false, false, grammarAccess.getResourceOptionAccess().getLABELKeyword_0_4()), new TokenAlias(false, false, grammarAccess.getResourceOptionAccess().getURLKeyword_0_5()), new TokenAlias(false, false, grammarAccess.getResourceOptionAccess().getVALUEKeyword_0_1()));
		match_VisFilter_LeftParenthesisKeyword_0_p = new TokenAlias(true, false, grammarAccess.getVisFilterAccess().getLeftParenthesisKeyword_0());
	}
	
	@Override
	protected String getUnassignedRuleCallToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if(ruleCall.getRule() == grammarAccess.getAggFunctionRule())
			return getAggFunctionToken(semanticObject, ruleCall, node);
		else if(ruleCall.getRule() == grammarAccess.getCountFunctionRule())
			return getCountFunctionToken(semanticObject, ruleCall, node);
		else if(ruleCall.getRule() == grammarAccess.getECLDECIMALTYPERule())
			return getECLDECIMALTYPEToken(semanticObject, ruleCall, node);
		else if(ruleCall.getRule() == grammarAccess.getECLNUMBEREDTYPERule())
			return getECLNUMBEREDTYPEToken(semanticObject, ruleCall, node);
		else if(ruleCall.getRule() == grammarAccess.getGEN_BLOCKRule())
			return getGEN_BLOCKToken(semanticObject, ruleCall, node);
		else if(ruleCall.getRule() == grammarAccess.getINTRule())
			return getINTToken(semanticObject, ruleCall, node);
		else if(ruleCall.getRule() == grammarAccess.getTOKENRule())
			return getTOKENToken(semanticObject, ruleCall, node);
		else if(ruleCall.getRule() == grammarAccess.getVisNameRule())
			return getVisNameToken(semanticObject, ruleCall, node);
		return "";
	}
	
	/**
	 * AggFunction:
	 * 	('SUM'|'AVE'|'MAX'|'MIN') '(' TOKEN  ')'
	 * ;
	 */
	protected String getAggFunctionToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "SUM()";
	}
	
	/**
	 * CountFunction: 
	 * 	'COUNT'
	 * ;
	 */
	protected String getCountFunctionToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "COUNT";
	}
	
	/**
	 * terminal ECLDECIMALTYPE: 
	 * 	('DECIMAL')('0'..'9')*
	 * ;
	 */
	protected String getECLDECIMALTYPEToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "DECIMAL";
	}
	
	/**
	 * terminal ECLNUMBEREDTYPE:
	 * 	('UNICODE'|'STRING'|'UNSIGNED'|'INTEGER'|'QSTRING'|'VARSTRING'|'VARUNICODE'|'REAL')('0'..'9')*
	 * ;
	 */
	protected String getECLNUMBEREDTYPEToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "UNICODE";
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
	 * terminal INT returns ecore::EInt:
	 * 	('0'..'9')+
	 * ;
	 */
	protected String getINTToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "";
	}
	
	/**
	 * TOKEN :
	 * 	ID
	 * ;
	 */
	protected String getTOKENToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "";
	}
	
	/**
	 * VisName :
	 * 	('CHORO'|'LINE'|'TIMELINE'|'PIE'|'BAR'|'TABLE'|'GRAPH'|'FORM'|'GROUP'|'SLIDER')
	 * ;
	 */
	protected String getVisNameToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "CHORO";
	}
	
	@Override
	protected void emitUnassignedTokens(EObject semanticObject, ISynTransition transition, INode fromNode, INode toNode) {
		if (transition.getAmbiguousSyntaxes().isEmpty()) return;
		List<INode> transitionNodes = collectNodes(fromNode, toNode);
		for (AbstractElementAlias syntax : transition.getAmbiguousSyntaxes()) {
			List<INode> syntaxNodes = getNodesFor(transitionNodes, syntax);
			if(match_CustomPermissionLevel_GROUPKeyword_0_1_or_USERKeyword_0_0.equals(syntax))
				emit_CustomPermissionLevel_GROUPKeyword_0_1_or_USERKeyword_0_0(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_ECLDecType_INTTerminalRuleCall_1_q.equals(syntax))
				emit_ECLDecType_INTTerminalRuleCall_1_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_ECLInteger_INTTerminalRuleCall_1_q.equals(syntax))
				emit_ECLInteger_INTTerminalRuleCall_1_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_ECLNumType_INTTerminalRuleCall_1_q.equals(syntax))
				emit_ECLNumType_INTTerminalRuleCall_1_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_ECLQstring_INTTerminalRuleCall_1_q.equals(syntax))
				emit_ECLQstring_INTTerminalRuleCall_1_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_ECLString_INTTerminalRuleCall_1_q.equals(syntax))
				emit_ECLString_INTTerminalRuleCall_1_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_ECLUnicode_INTTerminalRuleCall_1_q.equals(syntax))
				emit_ECLUnicode_INTTerminalRuleCall_1_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_ECLUnsigned_INTTerminalRuleCall_1_q.equals(syntax))
				emit_ECLUnsigned_INTTerminalRuleCall_1_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_ECLVarstring_INTTerminalRuleCall_1_q.equals(syntax))
				emit_ECLVarstring_INTTerminalRuleCall_1_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_ECLVarunicode_INTTerminalRuleCall_1_q.equals(syntax))
				emit_ECLVarunicode_INTTerminalRuleCall_1_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_Function___SCALEKeyword_6_0_LeftParenthesisKeyword_6_1___AggFunctionParserRuleCall_6_2_1_or_CountFunctionParserRuleCall_6_2_0___CommaKeyword_6_3_INTTerminalRuleCall_6_4_RightParenthesisKeyword_6_5___or_____AggFunctionParserRuleCall_2_or_CountFunctionParserRuleCall_4___or___HyphenMinusKeyword_3_0_AggFunctionParserRuleCall_3_1___or___HyphenMinusKeyword_5_0_CountFunctionParserRuleCall_5_1____.equals(syntax))
				emit_Function___SCALEKeyword_6_0_LeftParenthesisKeyword_6_1___AggFunctionParserRuleCall_6_2_1_or_CountFunctionParserRuleCall_6_2_0___CommaKeyword_6_3_INTTerminalRuleCall_6_4_RightParenthesisKeyword_6_5___or_____AggFunctionParserRuleCall_2_or_CountFunctionParserRuleCall_4___or___HyphenMinusKeyword_3_0_AggFunctionParserRuleCall_3_1___or___HyphenMinusKeyword_5_0_CountFunctionParserRuleCall_5_1____(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_GenerateBodySalt_PROFILEKeyword_6_1_or_SCOREDSEARCHKeyword_6_0.equals(syntax))
				emit_GenerateBodySalt_PROFILEKeyword_6_1_or_SCOREDSEARCHKeyword_6_0(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_InstanceOption_LABELKeyword_0_0_or_VERSIONKeyword_0_1.equals(syntax))
				emit_InstanceOption_LABELKeyword_0_0_or_VERSIONKeyword_0_1(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_OutTypeSimple___ACTIONKeyword_0_3_or_BOOLKeyword_0_0_or_INTKeyword_0_1_or_STRINGKeyword_0_2__q.equals(syntax))
				emit_OutTypeSimple___ACTIONKeyword_0_3_or_BOOLKeyword_0_0_or_INTKeyword_0_1_or_STRINGKeyword_0_2__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_OutputOption_FILLSKeyword_4_0_1_or_SOAPKeyword_4_0_2_or_WUIDKeyword_4_0_0.equals(syntax))
				emit_OutputOption_FILLSKeyword_4_0_1_or_SOAPKeyword_4_0_2_or_WUIDKeyword_4_0_0(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_OutputOption_FROMKeyword_1_0_1_or_WUIDKeyword_1_0_0.equals(syntax))
				emit_OutputOption_FROMKeyword_1_0_1_or_WUIDKeyword_1_0_0(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_Permission_PRIVATEKeyword_2_1_or_PUBLICKeyword_2_0.equals(syntax))
				emit_Permission_PRIVATEKeyword_2_1_or_PUBLICKeyword_2_0(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_ResourceOption_CLUSTERKeyword_0_7_or_DALIIPKeyword_0_6_or_DESCRIPTIONKeyword_0_2_or_FILENAMEKeyword_0_3_or_FONTKeyword_0_0_or_LABELKeyword_0_4_or_URLKeyword_0_5_or_VALUEKeyword_0_1.equals(syntax))
				emit_ResourceOption_CLUSTERKeyword_0_7_or_DALIIPKeyword_0_6_or_DESCRIPTIONKeyword_0_2_or_FILENAMEKeyword_0_3_or_FONTKeyword_0_0_or_LABELKeyword_0_4_or_URLKeyword_0_5_or_VALUEKeyword_0_1(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_VisFilter_LeftParenthesisKeyword_0_p.equals(syntax))
				emit_VisFilter_LeftParenthesisKeyword_0_p(semanticObject, getLastNavigableState(), syntaxNodes);
			else acceptNodes(getLastNavigableState(), syntaxNodes);
		}
	}

	/**
	 * Syntax:
	 *     'USER' | 'GROUP'
	 */
	protected void emit_CustomPermissionLevel_GROUPKeyword_0_1_or_USERKeyword_0_0(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     INT?
	 */
	protected void emit_ECLDecType_INTTerminalRuleCall_1_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     INT?
	 */
	protected void emit_ECLInteger_INTTerminalRuleCall_1_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     INT?
	 */
	protected void emit_ECLNumType_INTTerminalRuleCall_1_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     INT?
	 */
	protected void emit_ECLQstring_INTTerminalRuleCall_1_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     INT?
	 */
	protected void emit_ECLString_INTTerminalRuleCall_1_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     INT?
	 */
	protected void emit_ECLUnicode_INTTerminalRuleCall_1_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     INT?
	 */
	protected void emit_ECLUnsigned_INTTerminalRuleCall_1_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     INT?
	 */
	protected void emit_ECLVarstring_INTTerminalRuleCall_1_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     INT?
	 */
	protected void emit_ECLVarunicode_INTTerminalRuleCall_1_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     (
	     (
	         'SCALE' 
	         '(' 
	         (CountFunction | AggFunction) 
	         ',' 
	         INT 
	         ')'
	     ) | 
	     (('-' AggFunction) | ('-' CountFunction) | (AggFunction | CountFunction))
	 )
	 */
	protected void emit_Function___SCALEKeyword_6_0_LeftParenthesisKeyword_6_1___AggFunctionParserRuleCall_6_2_1_or_CountFunctionParserRuleCall_6_2_0___CommaKeyword_6_3_INTTerminalRuleCall_6_4_RightParenthesisKeyword_6_5___or_____AggFunctionParserRuleCall_2_or_CountFunctionParserRuleCall_4___or___HyphenMinusKeyword_3_0_AggFunctionParserRuleCall_3_1___or___HyphenMinusKeyword_5_0_CountFunctionParserRuleCall_5_1____(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     'SCOREDSEARCH' | 'PROFILE'
	 */
	protected void emit_GenerateBodySalt_PROFILEKeyword_6_1_or_SCOREDSEARCHKeyword_6_0(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     'LABEL' | 'VERSION'
	 */
	protected void emit_InstanceOption_LABELKeyword_0_0_or_VERSIONKeyword_0_1(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     ('BOOL' | 'INT' | 'STRING' | 'ACTION')?
	 */
	protected void emit_OutTypeSimple___ACTIONKeyword_0_3_or_BOOLKeyword_0_0_or_INTKeyword_0_1_or_STRINGKeyword_0_2__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     'WUID' | 'FILLS' | 'SOAP'
	 */
	protected void emit_OutputOption_FILLSKeyword_4_0_1_or_SOAPKeyword_4_0_2_or_WUIDKeyword_4_0_0(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     'WUID' | 'FROM'
	 */
	protected void emit_OutputOption_FROMKeyword_1_0_1_or_WUIDKeyword_1_0_0(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     'PUBLIC' | 'PRIVATE'
	 */
	protected void emit_Permission_PRIVATEKeyword_2_1_or_PUBLICKeyword_2_0(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     (
	     'FONT' | 
	     'VALUE' | 
	     'DESCRIPTION' | 
	     'FILENAME' | 
	     'LABEL' | 
	     'URL' | 
	     'DALIIP' | 
	     'CLUSTER'
	 )
	 */
	protected void emit_ResourceOption_CLUSTERKeyword_0_7_or_DALIIPKeyword_0_6_or_DESCRIPTIONKeyword_0_2_or_FILENAMEKeyword_0_3_or_FONTKeyword_0_0_or_LABELKeyword_0_4_or_URLKeyword_0_5_or_VALUEKeyword_0_1(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     '('+
	 */
	protected void emit_VisFilter_LeftParenthesisKeyword_0_p(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
}
