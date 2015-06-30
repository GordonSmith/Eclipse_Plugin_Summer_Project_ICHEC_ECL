/*
 * generated by Xtext
 */
package org.xtext.hipie.validation

import org.eclipse.xtext.validation.Check
import org.xtext.hipie.hIPIE.* ;
import org.xtext.hipie.hIPIE.base_prop;


//import org.eclipse.xtext.validation.Check

/**
 * This class contains custom validation rules. 
 *
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#validation
 */
class HIPIEValidator extends AbstractHIPIEValidator {

  public static val INVALID_NAME = 'Argument should be a string.'

	@Check
	def checkIfBPString(base_prop base) {
	// Checks if some of the base_props are strings					
		if (base.name == "LABEL" || base.name == "DESCRIPTION" || base.name == "AUTHOR" || base.name == "VERSION" || base.name == "COPYRIGHT" || base.name == "LICENSE") {
			for (i : 0..<base.vals.vals.size())
			{
				if (base.vals.vals.get(i).str_val == null)
				{
					error("Input should be a string." , HIPIEPackage::eINSTANCE.getbase_prop_Vals) ;
					return ;
				}				
			}
		}
		return ;
	}
}
