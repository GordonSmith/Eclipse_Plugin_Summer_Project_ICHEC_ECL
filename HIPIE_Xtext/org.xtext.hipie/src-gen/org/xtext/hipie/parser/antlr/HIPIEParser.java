/*
 * generated by Xtext
 */
package org.xtext.hipie.parser.antlr;

import com.google.inject.Inject;

import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.xtext.hipie.services.HIPIEGrammarAccess;

public class HIPIEParser extends org.eclipse.xtext.parser.antlr.AbstractAntlrParser {
	
	@Inject
	private HIPIEGrammarAccess grammarAccess;
	
	@Override
	protected void setInitialHiddenTokens(XtextTokenStream tokenStream) {
		tokenStream.setInitialHiddenTokens("RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT");
	}
	
	@Override
	protected org.xtext.hipie.parser.antlr.internal.InternalHIPIEParser createParser(XtextTokenStream stream) {
		return new org.xtext.hipie.parser.antlr.internal.InternalHIPIEParser(stream, getGrammarAccess());
	}
	
	@Override 
	protected String getDefaultRuleName() {
		return "program";
	}
	
	public HIPIEGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}
	
	public void setGrammarAccess(HIPIEGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
	
}
