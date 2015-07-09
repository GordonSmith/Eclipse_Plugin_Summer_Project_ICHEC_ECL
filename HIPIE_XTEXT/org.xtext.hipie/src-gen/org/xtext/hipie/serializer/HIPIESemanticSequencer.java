package org.xtext.hipie.serializer;

import com.google.inject.Inject;
import com.google.inject.Provider;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.serializer.acceptor.ISemanticSequenceAcceptor;
import org.eclipse.xtext.serializer.acceptor.SequenceFeeder;
import org.eclipse.xtext.serializer.diagnostic.ISemanticSequencerDiagnosticProvider;
import org.eclipse.xtext.serializer.diagnostic.ISerializationDiagnostic.Acceptor;
import org.eclipse.xtext.serializer.sequencer.AbstractDelegatingSemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.GenericSequencer;
import org.eclipse.xtext.serializer.sequencer.ISemanticNodeProvider.INodesForEObjectProvider;
import org.eclipse.xtext.serializer.sequencer.ISemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService.ValueTransient;
import org.xtext.hipie.hIPIE.Assign;
import org.xtext.hipie.hIPIE.AssignList;
import org.xtext.hipie.hIPIE.BaseProp;
import org.xtext.hipie.hIPIE.Bool;
import org.xtext.hipie.hIPIE.CategoryTypeList;
import org.xtext.hipie.hIPIE.CompositionHeader;
import org.xtext.hipie.hIPIE.ContractInstance;
import org.xtext.hipie.hIPIE.CustomPermissionLevel;
import org.xtext.hipie.hIPIE.CustomSection;
import org.xtext.hipie.hIPIE.Dataset;
import org.xtext.hipie.hIPIE.ECLBoolean;
import org.xtext.hipie.hIPIE.ECLData;
import org.xtext.hipie.hIPIE.ECLDecType;
import org.xtext.hipie.hIPIE.ECLInteger;
import org.xtext.hipie.hIPIE.ECLNumType;
import org.xtext.hipie.hIPIE.ECLQstring;
import org.xtext.hipie.hIPIE.ECLReal;
import org.xtext.hipie.hIPIE.ECLString;
import org.xtext.hipie.hIPIE.ECLUnicode;
import org.xtext.hipie.hIPIE.ECLUnsigned;
import org.xtext.hipie.hIPIE.ECLVarstring;
import org.xtext.hipie.hIPIE.ECLVarunicode;
import org.xtext.hipie.hIPIE.EnumDecl;
import org.xtext.hipie.hIPIE.EnumEntry;
import org.xtext.hipie.hIPIE.EnumList;
import org.xtext.hipie.hIPIE.FieldDecl;
import org.xtext.hipie.hIPIE.Function;
import org.xtext.hipie.hIPIE.GenerateBodyInline;
import org.xtext.hipie.hIPIE.GenerateBodyKel;
import org.xtext.hipie.hIPIE.GenerateBodySalt;
import org.xtext.hipie.hIPIE.Group;
import org.xtext.hipie.hIPIE.HIPIEPackage;
import org.xtext.hipie.hIPIE.InputOption;
import org.xtext.hipie.hIPIE.InputOptions;
import org.xtext.hipie.hIPIE.InputSection;
import org.xtext.hipie.hIPIE.InputtypeOptions;
import org.xtext.hipie.hIPIE.InstanceID;
import org.xtext.hipie.hIPIE.InstanceOptions;
import org.xtext.hipie.hIPIE.IntVar;
import org.xtext.hipie.hIPIE.IntegrateSection;
import org.xtext.hipie.hIPIE.KelAttrDecl;
import org.xtext.hipie.hIPIE.KelBase;
import org.xtext.hipie.hIPIE.KelEntityDecl;
import org.xtext.hipie.hIPIE.KelEntityDeclSimple;
import org.xtext.hipie.hIPIE.LinkOption;
import org.xtext.hipie.hIPIE.OutDataset;
import org.xtext.hipie.hIPIE.OutTypeSimple;
import org.xtext.hipie.hIPIE.OutfieldDecl;
import org.xtext.hipie.hIPIE.OutputBase;
import org.xtext.hipie.hIPIE.OutputOption;
import org.xtext.hipie.hIPIE.OutputOptions;
import org.xtext.hipie.hIPIE.OutputSection;
import org.xtext.hipie.hIPIE.Permission;
import org.xtext.hipie.hIPIE.Permissions;
import org.xtext.hipie.hIPIE.Program;
import org.xtext.hipie.hIPIE.Real;
import org.xtext.hipie.hIPIE.Record;
import org.xtext.hipie.hIPIE.ResourceOption;
import org.xtext.hipie.hIPIE.ResourceOptions;
import org.xtext.hipie.hIPIE.ResourceSection;
import org.xtext.hipie.hIPIE.ResourceType;
import org.xtext.hipie.hIPIE.SelectOption;
import org.xtext.hipie.hIPIE.Service;
import org.xtext.hipie.hIPIE.ServiceInputSection;
import org.xtext.hipie.hIPIE.StringVar;
import org.xtext.hipie.hIPIE.Value;
import org.xtext.hipie.hIPIE.ValueList;
import org.xtext.hipie.hIPIE.VisBasis;
import org.xtext.hipie.hIPIE.VisBasisParens;
import org.xtext.hipie.hIPIE.VisBasisQualifiers;
import org.xtext.hipie.hIPIE.VisFilter;
import org.xtext.hipie.hIPIE.VisibilityOption;
import org.xtext.hipie.hIPIE.VisualCustomOption;
import org.xtext.hipie.hIPIE.VisualMultival;
import org.xtext.hipie.hIPIE.VisualOption;
import org.xtext.hipie.hIPIE.VisualOptions;
import org.xtext.hipie.hIPIE.VisualSection;
import org.xtext.hipie.hIPIE.VisualSectionOption;
import org.xtext.hipie.hIPIE.VisualSectionOptions;
import org.xtext.hipie.hIPIE.Visualization;
import org.xtext.hipie.hIPIE.VizAssign;
import org.xtext.hipie.hIPIE.VizAssignList;
import org.xtext.hipie.hIPIE.VizEnumDecl;
import org.xtext.hipie.services.HIPIEGrammarAccess;

@SuppressWarnings("all")
public class HIPIESemanticSequencer extends AbstractDelegatingSemanticSequencer {

	@Inject
	private HIPIEGrammarAccess grammarAccess;
	
	public void createSequence(EObject context, EObject semanticObject) {
		if(semanticObject.eClass().getEPackage() == HIPIEPackage.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
			case HIPIEPackage.ASSIGN:
				if(context == grammarAccess.getAssignRule()) {
					sequence_Assign(context, (Assign) semanticObject); 
					return; 
				}
				else break;
			case HIPIEPackage.ASSIGN_LIST:
				if(context == grammarAccess.getAssignListRule()) {
					sequence_AssignList(context, (AssignList) semanticObject); 
					return; 
				}
				else break;
			case HIPIEPackage.BASE_PROP:
				if(context == grammarAccess.getBasePropRule()) {
					sequence_BaseProp(context, (BaseProp) semanticObject); 
					return; 
				}
				else break;
			case HIPIEPackage.BOOL:
				if(context == grammarAccess.getBoolRule() ||
				   context == grammarAccess.getDatatypeRule() ||
				   context == grammarAccess.getInputSimpleTypesRule() ||
				   context == grammarAccess.getOutfieldDeclRule()) {
					sequence_Bool(context, (Bool) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getInputValueRule()) {
					sequence_Bool_InputValue(context, (Bool) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getVisInputValueRule()) {
					sequence_Bool_VisInputValue(context, (Bool) semanticObject); 
					return; 
				}
				else break;
			case HIPIEPackage.CATEGORY_TYPE_LIST:
				if(context == grammarAccess.getCategoryTypeListRule()) {
					sequence_CategoryTypeList(context, (CategoryTypeList) semanticObject); 
					return; 
				}
				else break;
			case HIPIEPackage.COMPOSITION_HEADER:
				if(context == grammarAccess.getCompositionHeaderRule()) {
					sequence_CompositionHeader(context, (CompositionHeader) semanticObject); 
					return; 
				}
				else break;
			case HIPIEPackage.CONTRACT_INSTANCE:
				if(context == grammarAccess.getContractInstanceRule()) {
					sequence_ContractInstance(context, (ContractInstance) semanticObject); 
					return; 
				}
				else break;
			case HIPIEPackage.CUSTOM_PERMISSION_LEVEL:
				if(context == grammarAccess.getCustomPermissionLevelRule()) {
					sequence_CustomPermissionLevel(context, (CustomPermissionLevel) semanticObject); 
					return; 
				}
				else break;
			case HIPIEPackage.CUSTOM_SECTION:
				if(context == grammarAccess.getCustomSectionRule()) {
					sequence_CustomSection(context, (CustomSection) semanticObject); 
					return; 
				}
				else break;
			case HIPIEPackage.DATASET:
				if(context == grammarAccess.getDatasetRule() ||
				   context == grammarAccess.getDatatypeRule()) {
					sequence_Dataset(context, (Dataset) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getInputValueRule()) {
					sequence_Dataset_InputValue(context, (Dataset) semanticObject); 
					return; 
				}
				else break;
			case HIPIEPackage.ECL_BOOLEAN:
				if(context == grammarAccess.getECLBooleanRule() ||
				   context == grammarAccess.getECLfieldTypeRule() ||
				   context == grammarAccess.getPosVizDataRule()) {
					sequence_ECLBoolean(context, (ECLBoolean) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getECLOutputDeclRule()) {
					sequence_ECLBoolean_ECLOutputDecl(context, (ECLBoolean) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getServiceInputValueRule()) {
					sequence_ECLBoolean_ServiceInputValue(context, (ECLBoolean) semanticObject); 
					return; 
				}
				else break;
			case HIPIEPackage.ECL_DATA:
				if(context == grammarAccess.getECLDataRule() ||
				   context == grammarAccess.getECLfieldTypeRule() ||
				   context == grammarAccess.getPosVizDataRule()) {
					sequence_ECLData(context, (ECLData) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getECLOutputDeclRule()) {
					sequence_ECLData_ECLOutputDecl(context, (ECLData) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getServiceInputValueRule()) {
					sequence_ECLData_ServiceInputValue(context, (ECLData) semanticObject); 
					return; 
				}
				else break;
			case HIPIEPackage.ECL_DEC_TYPE:
				if(context == grammarAccess.getECLDecTypeRule() ||
				   context == grammarAccess.getECLfieldTypeRule() ||
				   context == grammarAccess.getPosVizDataRule()) {
					sequence_ECLDecType(context, (ECLDecType) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getECLOutputDeclRule()) {
					sequence_ECLDecType_ECLOutputDecl(context, (ECLDecType) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getServiceInputValueRule()) {
					sequence_ECLDecType_ServiceInputValue(context, (ECLDecType) semanticObject); 
					return; 
				}
				else break;
			case HIPIEPackage.ECL_INTEGER:
				if(context == grammarAccess.getECLIntegerRule() ||
				   context == grammarAccess.getECLfieldTypeRule() ||
				   context == grammarAccess.getPosVizDataRule()) {
					sequence_ECLInteger(context, (ECLInteger) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getECLOutputDeclRule()) {
					sequence_ECLInteger_ECLOutputDecl(context, (ECLInteger) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getServiceInputValueRule()) {
					sequence_ECLInteger_ServiceInputValue(context, (ECLInteger) semanticObject); 
					return; 
				}
				else break;
			case HIPIEPackage.ECL_NUM_TYPE:
				if(context == grammarAccess.getECLNumTypeRule() ||
				   context == grammarAccess.getECLfieldTypeRule() ||
				   context == grammarAccess.getPosVizDataRule()) {
					sequence_ECLNumType(context, (ECLNumType) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getECLOutputDeclRule()) {
					sequence_ECLNumType_ECLOutputDecl(context, (ECLNumType) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getServiceInputValueRule()) {
					sequence_ECLNumType_ServiceInputValue(context, (ECLNumType) semanticObject); 
					return; 
				}
				else break;
			case HIPIEPackage.ECL_QSTRING:
				if(context == grammarAccess.getECLOutputDeclRule()) {
					sequence_ECLOutputDecl_ECLQstring(context, (ECLQstring) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getECLQstringRule() ||
				   context == grammarAccess.getECLfieldTypeRule() ||
				   context == grammarAccess.getPosVizDataRule()) {
					sequence_ECLQstring(context, (ECLQstring) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getServiceInputValueRule()) {
					sequence_ECLQstring_ServiceInputValue(context, (ECLQstring) semanticObject); 
					return; 
				}
				else break;
			case HIPIEPackage.ECL_REAL:
				if(context == grammarAccess.getECLOutputDeclRule()) {
					sequence_ECLOutputDecl_ECLReal(context, (ECLReal) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getECLRealRule() ||
				   context == grammarAccess.getECLfieldTypeRule() ||
				   context == grammarAccess.getPosVizDataRule()) {
					sequence_ECLReal(context, (ECLReal) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getServiceInputValueRule()) {
					sequence_ECLReal_ServiceInputValue(context, (ECLReal) semanticObject); 
					return; 
				}
				else break;
			case HIPIEPackage.ECL_STRING:
				if(context == grammarAccess.getECLOutputDeclRule()) {
					sequence_ECLOutputDecl_ECLString(context, (ECLString) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getECLStringRule() ||
				   context == grammarAccess.getECLfieldTypeRule() ||
				   context == grammarAccess.getPosVizDataRule()) {
					sequence_ECLString(context, (ECLString) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getServiceInputValueRule()) {
					sequence_ECLString_ServiceInputValue(context, (ECLString) semanticObject); 
					return; 
				}
				else break;
			case HIPIEPackage.ECL_UNICODE:
				if(context == grammarAccess.getECLOutputDeclRule()) {
					sequence_ECLOutputDecl_ECLUnicode(context, (ECLUnicode) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getECLUnicodeRule() ||
				   context == grammarAccess.getECLfieldTypeRule() ||
				   context == grammarAccess.getPosVizDataRule()) {
					sequence_ECLUnicode(context, (ECLUnicode) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getServiceInputValueRule()) {
					sequence_ECLUnicode_ServiceInputValue(context, (ECLUnicode) semanticObject); 
					return; 
				}
				else break;
			case HIPIEPackage.ECL_UNSIGNED:
				if(context == grammarAccess.getECLOutputDeclRule()) {
					sequence_ECLOutputDecl_ECLUnsigned(context, (ECLUnsigned) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getECLUnsignedRule() ||
				   context == grammarAccess.getECLfieldTypeRule() ||
				   context == grammarAccess.getPosVizDataRule()) {
					sequence_ECLUnsigned(context, (ECLUnsigned) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getServiceInputValueRule()) {
					sequence_ECLUnsigned_ServiceInputValue(context, (ECLUnsigned) semanticObject); 
					return; 
				}
				else break;
			case HIPIEPackage.ECL_VARSTRING:
				if(context == grammarAccess.getECLOutputDeclRule()) {
					sequence_ECLOutputDecl_ECLVarstring(context, (ECLVarstring) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getECLVarstringRule() ||
				   context == grammarAccess.getECLfieldTypeRule() ||
				   context == grammarAccess.getPosVizDataRule()) {
					sequence_ECLVarstring(context, (ECLVarstring) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getServiceInputValueRule()) {
					sequence_ECLVarstring_ServiceInputValue(context, (ECLVarstring) semanticObject); 
					return; 
				}
				else break;
			case HIPIEPackage.ECL_VARUNICODE:
				if(context == grammarAccess.getECLOutputDeclRule()) {
					sequence_ECLOutputDecl_ECLVarunicode(context, (ECLVarunicode) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getECLVarunicodeRule() ||
				   context == grammarAccess.getECLfieldTypeRule() ||
				   context == grammarAccess.getPosVizDataRule()) {
					sequence_ECLVarunicode(context, (ECLVarunicode) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getServiceInputValueRule()) {
					sequence_ECLVarunicode_ServiceInputValue(context, (ECLVarunicode) semanticObject); 
					return; 
				}
				else break;
			case HIPIEPackage.ENUM_DECL:
				if(context == grammarAccess.getDatatypeRule() ||
				   context == grammarAccess.getEnumDeclRule() ||
				   context == grammarAccess.getInputSimpleTypesRule()) {
					sequence_EnumDecl(context, (EnumDecl) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getInputValueRule()) {
					sequence_EnumDecl_InputValue(context, (EnumDecl) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getVisInputValueRule()) {
					sequence_EnumDecl_VisInputValue(context, (EnumDecl) semanticObject); 
					return; 
				}
				else break;
			case HIPIEPackage.ENUM_ENTRY:
				if(context == grammarAccess.getEnumEntryRule()) {
					sequence_EnumEntry(context, (EnumEntry) semanticObject); 
					return; 
				}
				else break;
			case HIPIEPackage.ENUM_LIST:
				if(context == grammarAccess.getEnumListRule()) {
					sequence_EnumList(context, (EnumList) semanticObject); 
					return; 
				}
				else break;
			case HIPIEPackage.FIELD_DECL:
				if(context == grammarAccess.getFieldDeclRule() ||
				   context == grammarAccess.getPosVizDataRule()) {
					sequence_FieldDecl(context, (FieldDecl) semanticObject); 
					return; 
				}
				else break;
			case HIPIEPackage.FUNCTION:
				if(context == grammarAccess.getFunctionRule() ||
				   context == grammarAccess.getQFunctionRule()) {
					sequence_Function(context, (Function) semanticObject); 
					return; 
				}
				else break;
			case HIPIEPackage.GENERATE_BODY_INLINE:
				if(context == grammarAccess.getGenerateBodyInlineRule() ||
				   context == grammarAccess.getGenerateSectionRule()) {
					sequence_GenerateBodyInline(context, (GenerateBodyInline) semanticObject); 
					return; 
				}
				else break;
			case HIPIEPackage.GENERATE_BODY_KEL:
				if(context == grammarAccess.getGenerateBodyKelRule() ||
				   context == grammarAccess.getGenerateSectionRule()) {
					sequence_GenerateBodyKel(context, (GenerateBodyKel) semanticObject); 
					return; 
				}
				else break;
			case HIPIEPackage.GENERATE_BODY_SALT:
				if(context == grammarAccess.getGenerateBodySaltRule() ||
				   context == grammarAccess.getGenerateSectionRule()) {
					sequence_GenerateBodySalt(context, (GenerateBodySalt) semanticObject); 
					return; 
				}
				else break;
			case HIPIEPackage.GROUP:
				if(context == grammarAccess.getDatatypeRule() ||
				   context == grammarAccess.getGroupRule()) {
					sequence_Group(context, (Group) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getInputValueRule()) {
					sequence_Group_InputValue(context, (Group) semanticObject); 
					return; 
				}
				else break;
			case HIPIEPackage.INPUT_OPTION:
				if(context == grammarAccess.getInputOptionRule()) {
					sequence_InputOption(context, (InputOption) semanticObject); 
					return; 
				}
				else break;
			case HIPIEPackage.INPUT_OPTIONS:
				if(context == grammarAccess.getInputOptionsRule()) {
					sequence_InputOptions(context, (InputOptions) semanticObject); 
					return; 
				}
				else break;
			case HIPIEPackage.INPUT_SECTION:
				if(context == grammarAccess.getInputSectionRule()) {
					sequence_InputSection(context, (InputSection) semanticObject); 
					return; 
				}
				else break;
			case HIPIEPackage.INPUTTYPE_OPTIONS:
				if(context == grammarAccess.getInputtypeOptionsRule()) {
					sequence_InputtypeOptions(context, (InputtypeOptions) semanticObject); 
					return; 
				}
				else break;
			case HIPIEPackage.INSTANCE_ID:
				if(context == grammarAccess.getInstanceIDRule()) {
					sequence_InstanceID(context, (InstanceID) semanticObject); 
					return; 
				}
				else break;
			case HIPIEPackage.INSTANCE_OPTIONS:
				if(context == grammarAccess.getInstanceOptionsRule()) {
					sequence_InstanceOptions(context, (InstanceOptions) semanticObject); 
					return; 
				}
				else break;
			case HIPIEPackage.INT_VAR:
				if(context == grammarAccess.getInputValueRule()) {
					sequence_InputValue_IntVar(context, (IntVar) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getDatatypeRule() ||
				   context == grammarAccess.getInputSimpleTypesRule() ||
				   context == grammarAccess.getIntVarRule() ||
				   context == grammarAccess.getOutfieldDeclRule()) {
					sequence_IntVar(context, (IntVar) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getVisInputValueRule()) {
					sequence_IntVar_VisInputValue(context, (IntVar) semanticObject); 
					return; 
				}
				else break;
			case HIPIEPackage.INTEGRATE_SECTION:
				if(context == grammarAccess.getIntegrateSectionRule()) {
					sequence_IntegrateSection(context, (IntegrateSection) semanticObject); 
					return; 
				}
				else break;
			case HIPIEPackage.KEL_ATTR_DECL:
				if(context == grammarAccess.getKelAttrDeclRule()) {
					sequence_KelAttrDecl(context, (KelAttrDecl) semanticObject); 
					return; 
				}
				else break;
			case HIPIEPackage.KEL_BASE:
				if(context == grammarAccess.getInputValueRule()) {
					sequence_InputValue_KelBase(context, (KelBase) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getDatatypeRule() ||
				   context == grammarAccess.getKelBaseRule()) {
					sequence_KelBase(context, (KelBase) semanticObject); 
					return; 
				}
				else break;
			case HIPIEPackage.KEL_ENTITY_DECL:
				if(context == grammarAccess.getKelEntityDeclRule()) {
					sequence_KelEntityDecl(context, (KelEntityDecl) semanticObject); 
					return; 
				}
				else break;
			case HIPIEPackage.KEL_ENTITY_DECL_SIMPLE:
				if(context == grammarAccess.getKelEntityDeclSimpleRule()) {
					sequence_KelEntityDeclSimple(context, (KelEntityDeclSimple) semanticObject); 
					return; 
				}
				else break;
			case HIPIEPackage.LINK_OPTION:
				if(context == grammarAccess.getLinkOptionRule() ||
				   context == grammarAccess.getVisualOptionRule()) {
					sequence_LinkOption(context, (LinkOption) semanticObject); 
					return; 
				}
				else break;
			case HIPIEPackage.OUT_DATASET:
				if(context == grammarAccess.getECLOutputDeclRule() ||
				   context == grammarAccess.getNestedDatasetDeclRule() ||
				   context == grammarAccess.getServiceInputValueRule()) {
					sequence_NestedDatasetDecl_OutDataset(context, (OutDataset) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getOutDatasetRule()) {
					sequence_OutDataset(context, (OutDataset) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getOutputValueRule()) {
					sequence_OutDataset_OutputValue(context, (OutDataset) semanticObject); 
					return; 
				}
				else break;
			case HIPIEPackage.OUT_TYPE_SIMPLE:
				if(context == grammarAccess.getOutTypeSimpleRule()) {
					sequence_OutTypeSimple(context, (OutTypeSimple) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getOutputValueRule()) {
					sequence_OutTypeSimple_OutputValue(context, (OutTypeSimple) semanticObject); 
					return; 
				}
				else break;
			case HIPIEPackage.OUTFIELD_DECL:
				if(context == grammarAccess.getOutfieldDeclRule()) {
					sequence_OutfieldDecl(context, (OutfieldDecl) semanticObject); 
					return; 
				}
				else break;
			case HIPIEPackage.OUTPUT_BASE:
				if(context == grammarAccess.getOutputBaseRule()) {
					sequence_OutputBase(context, (OutputBase) semanticObject); 
					return; 
				}
				else break;
			case HIPIEPackage.OUTPUT_OPTION:
				if(context == grammarAccess.getOutputOptionRule()) {
					sequence_OutputOption(context, (OutputOption) semanticObject); 
					return; 
				}
				else break;
			case HIPIEPackage.OUTPUT_OPTIONS:
				if(context == grammarAccess.getOutputOptionsRule()) {
					sequence_OutputOptions(context, (OutputOptions) semanticObject); 
					return; 
				}
				else break;
			case HIPIEPackage.OUTPUT_SECTION:
				if(context == grammarAccess.getOutputSectionRule()) {
					sequence_OutputSection(context, (OutputSection) semanticObject); 
					return; 
				}
				else break;
			case HIPIEPackage.PERMISSION:
				if(context == grammarAccess.getPermissionRule()) {
					sequence_Permission(context, (Permission) semanticObject); 
					return; 
				}
				else break;
			case HIPIEPackage.PERMISSIONS:
				if(context == grammarAccess.getPermissionsRule()) {
					sequence_Permissions(context, (Permissions) semanticObject); 
					return; 
				}
				else break;
			case HIPIEPackage.PROGRAM:
				if(context == grammarAccess.getProgramRule()) {
					sequence_Program(context, (Program) semanticObject); 
					return; 
				}
				else break;
			case HIPIEPackage.REAL:
				if(context == grammarAccess.getInputValueRule()) {
					sequence_InputValue_Real(context, (Real) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getDatatypeRule() ||
				   context == grammarAccess.getInputSimpleTypesRule() ||
				   context == grammarAccess.getRealRule()) {
					sequence_Real(context, (Real) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getVisInputValueRule()) {
					sequence_Real_VisInputValue(context, (Real) semanticObject); 
					return; 
				}
				else break;
			case HIPIEPackage.RECORD:
				if(context == grammarAccess.getInputValueRule()) {
					sequence_InputValue_Record(context, (Record) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getDatatypeRule() ||
				   context == grammarAccess.getRecordRule()) {
					sequence_Record(context, (Record) semanticObject); 
					return; 
				}
				else break;
			case HIPIEPackage.RESOURCE_OPTION:
				if(context == grammarAccess.getResourceOptionRule()) {
					sequence_ResourceOption(context, (ResourceOption) semanticObject); 
					return; 
				}
				else break;
			case HIPIEPackage.RESOURCE_OPTIONS:
				if(context == grammarAccess.getResourceOptionsRule()) {
					sequence_ResourceOptions(context, (ResourceOptions) semanticObject); 
					return; 
				}
				else break;
			case HIPIEPackage.RESOURCE_SECTION:
				if(context == grammarAccess.getResourceSectionRule()) {
					sequence_ResourceSection(context, (ResourceSection) semanticObject); 
					return; 
				}
				else break;
			case HIPIEPackage.RESOURCE_TYPE:
				if(context == grammarAccess.getResourceTypeRule()) {
					sequence_ResourceType(context, (ResourceType) semanticObject); 
					return; 
				}
				else break;
			case HIPIEPackage.SELECT_OPTION:
				if(context == grammarAccess.getSelectOptionRule() ||
				   context == grammarAccess.getVisualOptionRule()) {
					sequence_SelectOption(context, (SelectOption) semanticObject); 
					return; 
				}
				else break;
			case HIPIEPackage.SERVICE:
				if(context == grammarAccess.getOutputValueRule()) {
					sequence_OutputValue_Service(context, (Service) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getServiceRule()) {
					sequence_Service(context, (Service) semanticObject); 
					return; 
				}
				else break;
			case HIPIEPackage.SERVICE_INPUT_SECTION:
				if(context == grammarAccess.getServiceInputSectionRule()) {
					sequence_ServiceInputSection(context, (ServiceInputSection) semanticObject); 
					return; 
				}
				else break;
			case HIPIEPackage.STRING_VAR:
				if(context == grammarAccess.getInputValueRule()) {
					sequence_InputValue_StringVar(context, (StringVar) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getDatatypeRule() ||
				   context == grammarAccess.getInputSimpleTypesRule() ||
				   context == grammarAccess.getOutfieldDeclRule() ||
				   context == grammarAccess.getStringVarRule()) {
					sequence_StringVar(context, (StringVar) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getVisInputValueRule()) {
					sequence_StringVar_VisInputValue(context, (StringVar) semanticObject); 
					return; 
				}
				else break;
			case HIPIEPackage.VALUE:
				if(context == grammarAccess.getResourceValueRule()) {
					sequence_ResourceValue_Value(context, (Value) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getSelectOptionRule() ||
				   context == grammarAccess.getVisualOptionRule()) {
					sequence_SelectOption_Value(context, (Value) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getCustomValueRule() ||
				   context == grammarAccess.getSelectEventRule() ||
				   context == grammarAccess.getValueRule()) {
					sequence_Value(context, (Value) semanticObject); 
					return; 
				}
				else break;
			case HIPIEPackage.VALUE_LIST:
				if(context == grammarAccess.getInstanceOptionRule() ||
				   context == grammarAccess.getValueListRule()) {
					sequence_ValueList(context, (ValueList) semanticObject); 
					return; 
				}
				else break;
			case HIPIEPackage.VIS_BASIS:
				if(context == grammarAccess.getVisBasisRule()) {
					sequence_VisBasis(context, (VisBasis) semanticObject); 
					return; 
				}
				else break;
			case HIPIEPackage.VIS_BASIS_PARENS:
				if(context == grammarAccess.getVisBasisParensRule()) {
					sequence_VisBasisParens(context, (VisBasisParens) semanticObject); 
					return; 
				}
				else break;
			case HIPIEPackage.VIS_BASIS_QUALIFIERS:
				if(context == grammarAccess.getNestBasisQualifierRule() ||
				   context == grammarAccess.getQFunctionRule() ||
				   context == grammarAccess.getVisBasisQualifiersRule()) {
					sequence_VisBasisQualifiers(context, (VisBasisQualifiers) semanticObject); 
					return; 
				}
				else break;
			case HIPIEPackage.VIS_FILTER:
				if(context == grammarAccess.getVisFilterRule()) {
					sequence_VisFilter(context, (VisFilter) semanticObject); 
					return; 
				}
				else break;
			case HIPIEPackage.VISIBILITY_OPTION:
				if(context == grammarAccess.getVisibilityOptionRule()) {
					sequence_VisibilityOption(context, (VisibilityOption) semanticObject); 
					return; 
				}
				else break;
			case HIPIEPackage.VISUAL_CUSTOM_OPTION:
				if(context == grammarAccess.getResourceOptionRule()) {
					sequence_ResourceOption_VisualCustomOption(context, (VisualCustomOption) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getVisualCustomOptionRule()) {
					sequence_VisualCustomOption(context, (VisualCustomOption) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getVisualOptionRule()) {
					sequence_VisualCustomOption_VisualOption(context, (VisualCustomOption) semanticObject); 
					return; 
				}
				else break;
			case HIPIEPackage.VISUAL_MULTIVAL:
				if(context == grammarAccess.getVisualMultivalRule()) {
					sequence_VisualMultival(context, (VisualMultival) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getVisualOptionRule()) {
					sequence_VisualMultival_VisualOption(context, (VisualMultival) semanticObject); 
					return; 
				}
				else break;
			case HIPIEPackage.VISUAL_OPTION:
				if(context == grammarAccess.getVisualOptionRule()) {
					sequence_VisualOption(context, (VisualOption) semanticObject); 
					return; 
				}
				else break;
			case HIPIEPackage.VISUAL_OPTIONS:
				if(context == grammarAccess.getVisualOptionsRule()) {
					sequence_VisualOptions(context, (VisualOptions) semanticObject); 
					return; 
				}
				else break;
			case HIPIEPackage.VISUAL_SECTION:
				if(context == grammarAccess.getVisualSectionRule()) {
					sequence_VisualSection(context, (VisualSection) semanticObject); 
					return; 
				}
				else break;
			case HIPIEPackage.VISUAL_SECTION_OPTION:
				if(context == grammarAccess.getVisualSectionOptionRule()) {
					sequence_VisualSectionOption(context, (VisualSectionOption) semanticObject); 
					return; 
				}
				else break;
			case HIPIEPackage.VISUAL_SECTION_OPTIONS:
				if(context == grammarAccess.getVisualSectionOptionsRule()) {
					sequence_VisualSectionOptions(context, (VisualSectionOptions) semanticObject); 
					return; 
				}
				else break;
			case HIPIEPackage.VISUALIZATION:
				if(context == grammarAccess.getVisualizationRule()) {
					sequence_Visualization(context, (Visualization) semanticObject); 
					return; 
				}
				else break;
			case HIPIEPackage.VIZ_ASSIGN:
				if(context == grammarAccess.getVizAssignRule()) {
					sequence_VizAssign(context, (VizAssign) semanticObject); 
					return; 
				}
				else break;
			case HIPIEPackage.VIZ_ASSIGN_LIST:
				if(context == grammarAccess.getVizAssignListRule()) {
					sequence_VizAssignList(context, (VizAssignList) semanticObject); 
					return; 
				}
				else break;
			case HIPIEPackage.VIZ_ENUM_DECL:
				if(context == grammarAccess.getVizEnumDeclRule()) {
					sequence_VizEnumDecl(context, (VizEnumDecl) semanticObject); 
					return; 
				}
				else break;
			}
		if (errorAcceptor != null) errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Constraint:
	 *     (assigns+=Assign assigns+=Assign*)
	 */
	protected void sequence_AssignList(EObject context, AssignList semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (vals_l=Value vals_r=ValueList)
	 */
	protected void sequence_Assign(EObject context, Assign semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, HIPIEPackage.Literals.ASSIGN__VALS_L) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, HIPIEPackage.Literals.ASSIGN__VALS_L));
			if(transientValues.isValueTransient(semanticObject, HIPIEPackage.Literals.ASSIGN__VALS_R) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, HIPIEPackage.Literals.ASSIGN__VALS_R));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getAssignAccess().getVals_lValueParserRuleCall_0_0(), semanticObject.getVals_l());
		feeder.accept(grammarAccess.getAssignAccess().getVals_rValueListParserRuleCall_2_0(), semanticObject.getVals_r());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         (
	 *             (
	 *                 name='NAME' | 
	 *                 name='DESCRIPTION' | 
	 *                 name='AUTHOR' | 
	 *                 name='LICENSE' | 
	 *                 name='COPYRIGHT' | 
	 *                 name='VERSION' | 
	 *                 name='LABEL' | 
	 *                 name='ID' | 
	 *                 name='TEMPLATE'
	 *             ) 
	 *             val_list=ValueList
	 *         ) | 
	 *         (name='CATEGORY' cat_list=CategoryTypeList)
	 *     )
	 */
	protected void sequence_BaseProp(EObject context, BaseProp semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     name=TOKEN
	 */
	protected void sequence_Bool(EObject context, Bool semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=TOKEN input_op_list=InputOptions?)
	 */
	protected void sequence_Bool_InputValue(EObject context, Bool semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=TOKEN in_ops=InputOptions?)
	 */
	protected void sequence_Bool_VisInputValue(EObject context, Bool semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (cats+=CategoryType cats+=CategoryType*)
	 */
	protected void sequence_CategoryTypeList(EObject context, CategoryTypeList semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name='HEADER' assigns+=Assign*)
	 */
	protected void sequence_CompositionHeader(EObject context, CompositionHeader semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (sec_name='INSTANCE' instId=InstanceID instance_ops=InstanceOptions? assigns+=Assign*)
	 */
	protected void sequence_ContractInstance(EObject context, ContractInstance semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (vals+=Value vals+=Value*)
	 */
	protected void sequence_CustomPermissionLevel(EObject context, CustomPermissionLevel semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name='CUSTOM' cust_vals+=CustomValue*)
	 */
	protected void sequence_CustomSection(EObject context, CustomSection semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     name=TOKEN
	 */
	protected void sequence_Dataset(EObject context, Dataset semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=TOKEN input_op_list=InputOptions?)
	 */
	protected void sequence_Dataset_InputValue(EObject context, Dataset semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     name=TOKEN
	 */
	protected void sequence_ECLBoolean(EObject context, ECLBoolean semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=TOKEN options=OutputOptions?)
	 */
	protected void sequence_ECLBoolean_ECLOutputDecl(EObject context, ECLBoolean semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=TOKEN in_ops=InputOptions?)
	 */
	protected void sequence_ECLBoolean_ServiceInputValue(EObject context, ECLBoolean semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     name=TOKEN
	 */
	protected void sequence_ECLData(EObject context, ECLData semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=TOKEN options=OutputOptions?)
	 */
	protected void sequence_ECLData_ECLOutputDecl(EObject context, ECLData semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=TOKEN in_ops=InputOptions?)
	 */
	protected void sequence_ECLData_ServiceInputValue(EObject context, ECLData semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     name=TOKEN
	 */
	protected void sequence_ECLDecType(EObject context, ECLDecType semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=TOKEN options=OutputOptions?)
	 */
	protected void sequence_ECLDecType_ECLOutputDecl(EObject context, ECLDecType semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=TOKEN in_ops=InputOptions?)
	 */
	protected void sequence_ECLDecType_ServiceInputValue(EObject context, ECLDecType semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     name=TOKEN
	 */
	protected void sequence_ECLInteger(EObject context, ECLInteger semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=TOKEN options=OutputOptions?)
	 */
	protected void sequence_ECLInteger_ECLOutputDecl(EObject context, ECLInteger semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=TOKEN in_ops=InputOptions?)
	 */
	protected void sequence_ECLInteger_ServiceInputValue(EObject context, ECLInteger semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     name=TOKEN
	 */
	protected void sequence_ECLNumType(EObject context, ECLNumType semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=TOKEN options=OutputOptions?)
	 */
	protected void sequence_ECLNumType_ECLOutputDecl(EObject context, ECLNumType semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=TOKEN in_ops=InputOptions?)
	 */
	protected void sequence_ECLNumType_ServiceInputValue(EObject context, ECLNumType semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=TOKEN options=OutputOptions?)
	 */
	protected void sequence_ECLOutputDecl_ECLQstring(EObject context, ECLQstring semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=TOKEN options=OutputOptions?)
	 */
	protected void sequence_ECLOutputDecl_ECLReal(EObject context, ECLReal semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=TOKEN options=OutputOptions?)
	 */
	protected void sequence_ECLOutputDecl_ECLString(EObject context, ECLString semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=TOKEN options=OutputOptions?)
	 */
	protected void sequence_ECLOutputDecl_ECLUnicode(EObject context, ECLUnicode semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=TOKEN options=OutputOptions?)
	 */
	protected void sequence_ECLOutputDecl_ECLUnsigned(EObject context, ECLUnsigned semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=TOKEN options=OutputOptions?)
	 */
	protected void sequence_ECLOutputDecl_ECLVarstring(EObject context, ECLVarstring semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=TOKEN options=OutputOptions?)
	 */
	protected void sequence_ECLOutputDecl_ECLVarunicode(EObject context, ECLVarunicode semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     name=TOKEN
	 */
	protected void sequence_ECLQstring(EObject context, ECLQstring semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=TOKEN in_ops=InputOptions?)
	 */
	protected void sequence_ECLQstring_ServiceInputValue(EObject context, ECLQstring semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     name=TOKEN
	 */
	protected void sequence_ECLReal(EObject context, ECLReal semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=TOKEN in_ops=InputOptions?)
	 */
	protected void sequence_ECLReal_ServiceInputValue(EObject context, ECLReal semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     name=TOKEN
	 */
	protected void sequence_ECLString(EObject context, ECLString semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=TOKEN in_ops=InputOptions?)
	 */
	protected void sequence_ECLString_ServiceInputValue(EObject context, ECLString semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     name=TOKEN
	 */
	protected void sequence_ECLUnicode(EObject context, ECLUnicode semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=TOKEN in_ops=InputOptions?)
	 */
	protected void sequence_ECLUnicode_ServiceInputValue(EObject context, ECLUnicode semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     name=TOKEN
	 */
	protected void sequence_ECLUnsigned(EObject context, ECLUnsigned semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=TOKEN in_ops=InputOptions?)
	 */
	protected void sequence_ECLUnsigned_ServiceInputValue(EObject context, ECLUnsigned semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     name=TOKEN
	 */
	protected void sequence_ECLVarstring(EObject context, ECLVarstring semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=TOKEN in_ops=InputOptions?)
	 */
	protected void sequence_ECLVarstring_ServiceInputValue(EObject context, ECLVarstring semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     name=TOKEN
	 */
	protected void sequence_ECLVarunicode(EObject context, ECLVarunicode semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=TOKEN in_ops=InputOptions?)
	 */
	protected void sequence_ECLVarunicode_ServiceInputValue(EObject context, ECLVarunicode semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (enum_dec='ENUM' enum_list=EnumList)
	 */
	protected void sequence_EnumDecl(EObject context, EnumDecl semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (enum_dec='ENUM' enum_list=EnumList input_op_list=InputOptions?)
	 */
	protected void sequence_EnumDecl_InputValue(EObject context, EnumDecl semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (enum_dec='ENUM' enum_list=EnumList in_ops=InputOptions?)
	 */
	protected void sequence_EnumDecl_VisInputValue(EObject context, EnumDecl semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (val_l=Value val_r=Value?)
	 */
	protected void sequence_EnumEntry(EObject context, EnumEntry semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (en_ents+=EnumEntry en_ents+=EnumEntry*)
	 */
	protected void sequence_EnumList(EObject context, EnumList semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=TOKEN input_ops=InputOptions?)
	 */
	protected void sequence_FieldDecl(EObject context, FieldDecl semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (vals=Value | vals=Value)?
	 */
	protected void sequence_Function(EObject context, Function semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     name='GENERATES'
	 */
	protected void sequence_GenerateBodyInline(EObject context, GenerateBodyInline semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, HIPIEPackage.Literals.GENERATE_SECTION__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, HIPIEPackage.Literals.GENERATE_SECTION__NAME));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getGenerateBodyInlineAccess().getNameGENERATESKeyword_0_0(), semanticObject.getName());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     name='GENERATES'
	 */
	protected void sequence_GenerateBodyKel(EObject context, GenerateBodyKel semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, HIPIEPackage.Literals.GENERATE_SECTION__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, HIPIEPackage.Literals.GENERATE_SECTION__NAME));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getGenerateBodyKelAccess().getNameGENERATESKeyword_0_0(), semanticObject.getName());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     name='GENERATES'
	 */
	protected void sequence_GenerateBodySalt(EObject context, GenerateBodySalt semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, HIPIEPackage.Literals.GENERATE_SECTION__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, HIPIEPackage.Literals.GENERATE_SECTION__NAME));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getGenerateBodySaltAccess().getNameGENERATESKeyword_0_0(), semanticObject.getName());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     name=TOKEN
	 */
	protected void sequence_Group(EObject context, Group semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=TOKEN input_op_list=InputOptions? vals+=InputValue*)
	 */
	protected void sequence_Group_InputValue(EObject context, Group semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         name='OPTIONAL' | 
	 *         name='DEFINED' | 
	 *         name='DISABLED' | 
	 *         name='MAPBYTYPE' | 
	 *         name='MAPBYNAME' | 
	 *         name='MANY' | 
	 *         (name='FORMFIELD' form_op=FormfieldOption) | 
	 *         (name='ENABLE' assigns_list=AssignList) | 
	 *         (name='TYPE' type_op=InputtypeOptions) | 
	 *         (
	 *             (
	 *                 name='RANGE' | 
	 *                 name='DEFAULT' | 
	 *                 name='MAXLENGTH' | 
	 *                 name='DISABLED' | 
	 *                 name='DESCRIPTION' | 
	 *                 name='NULL' | 
	 *                 name='FIELDLENGTH' | 
	 *                 name='ROWS' | 
	 *                 name='COLS' | 
	 *                 name='_HTML_STYLECLASS' | 
	 *                 name='LABEL'
	 *             ) 
	 *             vals+=ValueList
	 *         )
	 *     )
	 */
	protected void sequence_InputOption(EObject context, InputOption semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (input_ops+=InputOption input_ops+=InputOption*)
	 */
	protected void sequence_InputOptions(EObject context, InputOptions semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name='INPUTS' inputs+=InputValue+)
	 */
	protected void sequence_InputSection(EObject context, InputSection semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=TOKEN input_op_list=InputOptions?)
	 */
	protected void sequence_InputValue_IntVar(EObject context, IntVar semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=TOKEN input_op_list=InputOptions? (kel_ops+=KelEntityDecl | kel_ops+=KelEntityDeclSimple | kel_ops+=KelAttrDecl)*)
	 */
	protected void sequence_InputValue_KelBase(EObject context, KelBase semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=TOKEN input_op_list=InputOptions?)
	 */
	protected void sequence_InputValue_Real(EObject context, Real semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=TOKEN input_op_list=InputOptions?)
	 */
	protected void sequence_InputValue_Record(EObject context, Record semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=TOKEN input_op_list=InputOptions?)
	 */
	protected void sequence_InputValue_StringVar(EObject context, StringVar semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (in_type_op+=InputtypeOption in_type_op+=InputtypeOption*)
	 */
	protected void sequence_InputtypeOptions(EObject context, InputtypeOptions semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     name=TOKEN
	 */
	protected void sequence_InstanceID(EObject context, InstanceID semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, HIPIEPackage.Literals.INSTANCE_ID__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, HIPIEPackage.Literals.INSTANCE_ID__NAME));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getInstanceIDAccess().getNameTOKENParserRuleCall_1_0(), semanticObject.getName());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (in_ops+=InstanceOption in_ops+=InstanceOption*)
	 */
	protected void sequence_InstanceOptions(EObject context, InstanceOptions semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     name=TOKEN
	 */
	protected void sequence_IntVar(EObject context, IntVar semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=TOKEN in_ops=InputOptions?)
	 */
	protected void sequence_IntVar_VisInputValue(EObject context, IntVar semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name='INTEGRATE' outputs+=OutputValue+)
	 */
	protected void sequence_IntegrateSection(EObject context, IntegrateSection semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=TOKEN input_ops=InputOptions?)
	 */
	protected void sequence_KelAttrDecl(EObject context, KelAttrDecl semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     name=TOKEN
	 */
	protected void sequence_KelBase(EObject context, KelBase semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=TOKEN input_ops=InputOptions?)
	 */
	protected void sequence_KelEntityDeclSimple(EObject context, KelEntityDeclSimple semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=TOKEN input_ops=InputOptions? attrdecl=KelAttrDecl?)
	 */
	protected void sequence_KelEntityDecl(EObject context, KelEntityDecl semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=TOKEN ops+=VisualOption*)
	 */
	protected void sequence_LinkOption(EObject context, LinkOption semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=TOKEN out_base=OutputBase? ops=OutputOptions? options=OutputOptions? decl+=ECLOutputDecl+)
	 */
	protected void sequence_NestedDatasetDecl_OutDataset(EObject context, OutDataset semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=TOKEN out_base=OutputBase? ops=OutputOptions?)
	 */
	protected void sequence_OutDataset(EObject context, OutDataset semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=TOKEN out_base=OutputBase? ops=OutputOptions? ecl_vars+=ECLOutputDecl*)
	 */
	protected void sequence_OutDataset_OutputValue(EObject context, OutDataset semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     val=Value
	 */
	protected void sequence_OutTypeSimple(EObject context, OutTypeSimple semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (val=Value ops=OutputOptions?)
	 */
	protected void sequence_OutTypeSimple_OutputValue(EObject context, OutTypeSimple semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     fields+=FieldDecl
	 */
	protected void sequence_OutfieldDecl(EObject context, OutfieldDecl semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     base=[Datatype|TOKEN]
	 */
	protected void sequence_OutputBase(EObject context, OutputBase semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, HIPIEPackage.Literals.OUTPUT_BASE__BASE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, HIPIEPackage.Literals.OUTPUT_BASE__BASE));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getOutputBaseAccess().getBaseDatatypeTOKENParserRuleCall_1_0_1(), semanticObject.getBase());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         name='SIDE' | 
	 *         name='LARGE' | 
	 *         name='SMALL' | 
	 *         name='FEW' | 
	 *         name='WUID' | 
	 *         name='APPEND' | 
	 *         name='SCOREDSEARCH' | 
	 *         name='DATABOMB' | 
	 *         name='OPTIONAL' | 
	 *         name=TOKEN | 
	 *         assigns=AssignList | 
	 *         name=TOKEN | 
	 *         vals=ValueList | 
	 *         ((name='DESCRIPTION' | name='SOAP' | name='JSON' | name='ROXIE' | name='XPATH') vals=Value)
	 *     )
	 */
	protected void sequence_OutputOption(EObject context, OutputOption semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (output_ops+=OutputOption output_ops+=OutputOption*)
	 */
	protected void sequence_OutputOptions(EObject context, OutputOptions semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name='OUTPUTS' outputs+=OutputValue+)
	 */
	protected void sequence_OutputSection(EObject context, OutputSection semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=TOKEN ops=OutputOptions serv=ServiceInputSection? ecl_vars+=ECLOutputDecl*)
	 */
	protected void sequence_OutputValue_Service(EObject context, Service semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     ((name='VIEW' | name='EDIT' | name='RUN') (cust_levs+=CustomPermissionLevel cust_levs+=CustomPermissionLevel?)?)
	 */
	protected void sequence_Permission(EObject context, Permission semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name='PERMISSIONS' perms+=Permission*)
	 */
	protected void sequence_Permissions(EObject context, Permissions semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         composition_header+=CompositionHeader? 
	 *         base_props+=BaseProp+ 
	 *         permissions=Permissions? 
	 *         input_section+=InputSection? 
	 *         contract_instances+=ContractInstance* 
	 *         output_section+=OutputSection? 
	 *         integrate_section=IntegrateSection? 
	 *         visual_section+=VisualSection* 
	 *         generate_section+=GenerateSection? 
	 *         custom_section+=CustomSection? 
	 *         resource_section+=ResourceSection?
	 *     )
	 */
	protected void sequence_Program(EObject context, Program semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     name=TOKEN
	 */
	protected void sequence_Real(EObject context, Real semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=TOKEN in_ops=InputOptions?)
	 */
	protected void sequence_Real_VisInputValue(EObject context, Real semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     name=TOKEN
	 */
	protected void sequence_Record(EObject context, Record semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     vals=Value
	 */
	protected void sequence_ResourceOption(EObject context, ResourceOption semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, HIPIEPackage.Literals.RESOURCE_OPTION__VALS) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, HIPIEPackage.Literals.RESOURCE_OPTION__VALS));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getResourceOptionAccess().getValsValueParserRuleCall_2_0(), semanticObject.getVals());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (name=TOKEN vals=Value)
	 */
	protected void sequence_ResourceOption_VisualCustomOption(EObject context, VisualCustomOption semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (res_ops+=ResourceOption res_ops+=ResourceOption*)
	 */
	protected void sequence_ResourceOptions(EObject context, ResourceOptions semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name='RESOURCES' res_vals+=ResourceValue+)
	 */
	protected void sequence_ResourceSection(EObject context, ResourceSection semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         name='LOGICALFILE' | 
	 *         name='INDEX' | 
	 *         name='SUPERFILE' | 
	 *         name='ECL' | 
	 *         name='FILE' | 
	 *         name='IMAGE'
	 *     )
	 */
	protected void sequence_ResourceType(EObject context, ResourceType semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     ((name=UTOKEN | name=TOKEN | int_val=INT | str_val=STRING) res_ops=ResourceOptions?)
	 */
	protected void sequence_ResourceValue_Value(EObject context, Value semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (maps+=SelectOptionMapping maps+=SelectOptionMapping*)
	 */
	protected void sequence_SelectOption(EObject context, SelectOption semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     ((name=UTOKEN | name=TOKEN | int_val=INT | str_val=STRING) maps+=SelectOptionMapping maps+=SelectOptionMapping*)
	 */
	protected void sequence_SelectOption_Value(EObject context, Value semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     servs+=ServiceInputValue+
	 */
	protected void sequence_ServiceInputSection(EObject context, ServiceInputSection semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=TOKEN ops=OutputOptions serv=ServiceInputSection?)
	 */
	protected void sequence_Service(EObject context, Service semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     name=TOKEN
	 */
	protected void sequence_StringVar(EObject context, StringVar semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=TOKEN in_ops=InputOptions?)
	 */
	protected void sequence_StringVar_VisInputValue(EObject context, StringVar semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (vals+=Value vals+=Value*)
	 */
	protected void sequence_ValueList(EObject context, ValueList semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=UTOKEN | name=TOKEN | int_val=INT | str_val=STRING)
	 */
	protected void sequence_Value(EObject context, Value semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     input=VisBasis
	 */
	protected void sequence_VisBasisParens(EObject context, VisBasisParens semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, HIPIEPackage.Literals.VIS_BASIS_PARENS__INPUT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, HIPIEPackage.Literals.VIS_BASIS_PARENS__INPUT));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getVisBasisParensAccess().getInputVisBasisParserRuleCall_1_0(), semanticObject.getInput());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (funcs=Function qfuncs+=QFunction*)
	 */
	protected void sequence_VisBasisQualifiers(EObject context, VisBasisQualifiers semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (basis=[OutDataset|TOKEN] filter=VisFilter? quals=VisBasisQualifiers?)
	 */
	protected void sequence_VisBasis(EObject context, VisBasis semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     vals+=Value+
	 */
	protected void sequence_VisFilter(EObject context, VisFilter semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name='MODAL' | name='VISIBLE')
	 */
	protected void sequence_VisibilityOption(EObject context, VisibilityOption semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     name=TOKEN
	 */
	protected void sequence_VisualCustomOption(EObject context, VisualCustomOption semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=TOKEN funcs+=Function funcs+=Function*)
	 */
	protected void sequence_VisualCustomOption_VisualOption(EObject context, VisualCustomOption semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         name='X' | 
	 *         name='Y' | 
	 *         name='COLOR' | 
	 *         name='RANGE' | 
	 *         name='FILTER' | 
	 *         name='LABEL' | 
	 *         name='VALUE' | 
	 *         name='SORT' | 
	 *         name='BRANCHES'
	 *     )
	 */
	protected void sequence_VisualMultival(EObject context, VisualMultival semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         (
	 *             name='X' | 
	 *             name='Y' | 
	 *             name='COLOR' | 
	 *             name='RANGE' | 
	 *             name='FILTER' | 
	 *             name='LABEL' | 
	 *             name='VALUE' | 
	 *             name='SORT' | 
	 *             name='BRANCHES'
	 *         ) 
	 *         funcs+=Function 
	 *         funcs+=Function*
	 *     )
	 */
	protected void sequence_VisualMultival_VisualOption(EObject context, VisualMultival semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         (
	 *             (
	 *                 name='TITLE' | 
	 *                 name='DATE' | 
	 *                 name='DESCRIPTION' | 
	 *                 name='PICTURE' | 
	 *                 name='STATE' | 
	 *                 name='COUNTY' | 
	 *                 name='FIRST' | 
	 *                 name='WEIGHT' | 
	 *                 name='SIZE' | 
	 *                 name='LEVELS' | 
	 *                 name='LEVEL' | 
	 *                 name='UID' | 
	 *                 name='TYPE'
	 *             ) 
	 *             funcs+=Function
	 *         ) | 
	 *         ((name='ICON' | name='FLAG' | name='TYPE') funcs+=Function decl=VizEnumDecl?) | 
	 *         vis_cust=VisualCustomOption | 
	 *         name='COLLAPSE' | 
	 *         (name='VISIBILITY' visibility_op=VisibilityOption) | 
	 *         (name='ENABLE' assigns+=AssignList)
	 *     )
	 */
	protected void sequence_VisualOption(EObject context, VisualOption semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (vis_ops+=VisualOption vis_ops+=VisualOption*)
	 */
	protected void sequence_VisualOptions(EObject context, VisualOptions semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (((name='LABEL' | name='TITLE') vals=Value) | (name='ENABLE' assigns=AssignList) | name='EXPLORE' | name='PRIMARY')
	 */
	protected void sequence_VisualSectionOption(EObject context, VisualSectionOption semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (vis_ops+=VisualSectionOption vis_ops+=VisualSectionOption*)
	 */
	protected void sequence_VisualSectionOptions(EObject context, VisualSectionOptions semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (sec_name='VISUALIZE' vis_ops=VisualSectionOptions? vis_elements+=Visualization+)
	 */
	protected void sequence_VisualSection(EObject context, VisualSection semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     ((name=TOKEN parens=VisBasisParens? vis_op=VisualOptions?) | (name=TOKEN parens=VisBasisParens? vis_op=VisualOptions? input_val+=VisInputValue+))
	 */
	protected void sequence_Visualization(EObject context, Visualization semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (assigns+=VizAssign assigns+=VizAssign*)
	 */
	protected void sequence_VizAssignList(EObject context, VizAssignList semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (val_l=Value val_r=ValueList)
	 */
	protected void sequence_VizAssign(EObject context, VizAssign semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, HIPIEPackage.Literals.VIZ_ASSIGN__VAL_L) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, HIPIEPackage.Literals.VIZ_ASSIGN__VAL_L));
			if(transientValues.isValueTransient(semanticObject, HIPIEPackage.Literals.VIZ_ASSIGN__VAL_R) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, HIPIEPackage.Literals.VIZ_ASSIGN__VAL_R));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getVizAssignAccess().getVal_lValueParserRuleCall_0_0(), semanticObject.getVal_l());
		feeder.accept(grammarAccess.getVizAssignAccess().getVal_rValueListParserRuleCall_2_0(), semanticObject.getVal_r());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (name='ENUM' assigns=VizAssignList)
	 */
	protected void sequence_VizEnumDecl(EObject context, VizEnumDecl semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, HIPIEPackage.Literals.VIZ_ENUM_DECL__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, HIPIEPackage.Literals.VIZ_ENUM_DECL__NAME));
			if(transientValues.isValueTransient(semanticObject, HIPIEPackage.Literals.VIZ_ENUM_DECL__ASSIGNS) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, HIPIEPackage.Literals.VIZ_ENUM_DECL__ASSIGNS));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getVizEnumDeclAccess().getNameENUMKeyword_0_0(), semanticObject.getName());
		feeder.accept(grammarAccess.getVizEnumDeclAccess().getAssignsVizAssignListParserRuleCall_2_0(), semanticObject.getAssigns());
		feeder.finish();
	}
}
