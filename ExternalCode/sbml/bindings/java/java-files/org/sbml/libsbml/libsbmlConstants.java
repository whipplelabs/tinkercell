/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 1.3.40
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package org.sbml.libsbml;

public interface libsbmlConstants {
  public final static String LIBSBML_DOTTED_VERSION = "4.1.0-b1";
  public final static int LIBSBML_VERSION = 40100;
  public final static String LIBSBML_VERSION_STRING = "40100";
  public final static int LIBSBML_OPERATION_RETURN_VALUES_H = 1;
  // OperationReturnValues_t 
  public final static int LIBSBML_OPERATION_SUCCESS = 0;
  public final static int LIBSBML_INDEX_EXCEEDS_SIZE = -1;
  public final static int LIBSBML_UNEXPECTED_ATTRIBUTE = -2;
  public final static int LIBSBML_OPERATION_FAILED = -3;
  public final static int LIBSBML_INVALID_ATTRIBUTE_VALUE = -4;
  public final static int LIBSBML_INVALID_OBJECT = -5;
  public final static int LIBSBML_DUPLICATE_OBJECT_ID = -6;
  public final static int LIBSBML_LEVEL_MISMATCH = -7;
  public final static int LIBSBML_VERSION_MISMATCH = -8;
  public final static int LIBSBML_INVALID_XML_OPERATION = -9;

  // SBMLTypeCode_t 
  public final static int SBML_UNKNOWN = 0;
  public final static int SBML_COMPARTMENT = SBML_UNKNOWN + 1;
  public final static int SBML_COMPARTMENT_TYPE = SBML_COMPARTMENT + 1;
  public final static int SBML_CONSTRAINT = SBML_COMPARTMENT_TYPE + 1;
  public final static int SBML_DOCUMENT = SBML_CONSTRAINT + 1;
  public final static int SBML_EVENT = SBML_DOCUMENT + 1;
  public final static int SBML_EVENT_ASSIGNMENT = SBML_EVENT + 1;
  public final static int SBML_FUNCTION_DEFINITION = SBML_EVENT_ASSIGNMENT + 1;
  public final static int SBML_INITIAL_ASSIGNMENT = SBML_FUNCTION_DEFINITION + 1;
  public final static int SBML_KINETIC_LAW = SBML_INITIAL_ASSIGNMENT + 1;
  public final static int SBML_LIST_OF = SBML_KINETIC_LAW + 1;
  public final static int SBML_MODEL = SBML_LIST_OF + 1;
  public final static int SBML_PARAMETER = SBML_MODEL + 1;
  public final static int SBML_REACTION = SBML_PARAMETER + 1;
  public final static int SBML_RULE = SBML_REACTION + 1;
  public final static int SBML_SPECIES = SBML_RULE + 1;
  public final static int SBML_SPECIES_REFERENCE = SBML_SPECIES + 1;
  public final static int SBML_SPECIES_TYPE = SBML_SPECIES_REFERENCE + 1;
  public final static int SBML_MODIFIER_SPECIES_REFERENCE = SBML_SPECIES_TYPE + 1;
  public final static int SBML_UNIT_DEFINITION = SBML_MODIFIER_SPECIES_REFERENCE + 1;
  public final static int SBML_UNIT = SBML_UNIT_DEFINITION + 1;
  public final static int SBML_ALGEBRAIC_RULE = SBML_UNIT + 1;
  public final static int SBML_ASSIGNMENT_RULE = SBML_ALGEBRAIC_RULE + 1;
  public final static int SBML_RATE_RULE = SBML_ASSIGNMENT_RULE + 1;
  public final static int SBML_SPECIES_CONCENTRATION_RULE = SBML_RATE_RULE + 1;
  public final static int SBML_COMPARTMENT_VOLUME_RULE = SBML_SPECIES_CONCENTRATION_RULE + 1;
  public final static int SBML_PARAMETER_RULE = SBML_COMPARTMENT_VOLUME_RULE + 1;
  public final static int SBML_TRIGGER = SBML_PARAMETER_RULE + 1;
  public final static int SBML_DELAY = SBML_TRIGGER + 1;
  public final static int SBML_STOICHIOMETRY_MATH = SBML_DELAY + 1;
  public final static int SBML_LOCAL_PARAMETER = SBML_STOICHIOMETRY_MATH + 1;
  public final static int SBML_FORMULA_UNITS_DATA = SBML_LOCAL_PARAMETER + 1;
  public final static int SBML_LIST_FORMULA_UNITS_DATA = SBML_FORMULA_UNITS_DATA + 1;
  public final static int SBML_LISTOF_COMPARTMENTS = SBML_LIST_FORMULA_UNITS_DATA + 1;
  public final static int SBML_LISTOF_COMPARTMENT_TYPES = SBML_LISTOF_COMPARTMENTS + 1;
  public final static int SBML_LISTOF_CONSTRAINTS = SBML_LISTOF_COMPARTMENT_TYPES + 1;
  public final static int SBML_LISTOF_EVENTS = SBML_LISTOF_CONSTRAINTS + 1;
  public final static int SBML_LISTOF_EVENT_ASSIGNMENTS = SBML_LISTOF_EVENTS + 1;
  public final static int SBML_LISTOF_FUNCTION_DEFINITIONS = SBML_LISTOF_EVENT_ASSIGNMENTS + 1;
  public final static int SBML_LISTOF_INITIAL_ASSIGNMENTS = SBML_LISTOF_FUNCTION_DEFINITIONS + 1;
  public final static int SBML_LISTOF_PARAMETERS = SBML_LISTOF_INITIAL_ASSIGNMENTS + 1;
  public final static int SBML_LISTOF_REACTIONS = SBML_LISTOF_PARAMETERS + 1;
  public final static int SBML_LISTOF_RULES = SBML_LISTOF_REACTIONS + 1;
  public final static int SBML_LISTOF_SPECIES = SBML_LISTOF_RULES + 1;
  public final static int SBML_LISTOF_SPECIES_REFERENCES = SBML_LISTOF_SPECIES + 1;
  public final static int SBML_LISTOF_SPECIES_TYPES = SBML_LISTOF_SPECIES_REFERENCES + 1;
  public final static int SBML_LISTOF_UNIT_DEFINITIONS = SBML_LISTOF_SPECIES_TYPES + 1;
  public final static int SBML_LISTOF_UNITS = SBML_LISTOF_UNIT_DEFINITIONS + 1;

  public final static int IdCheckON = 0x01;
  public final static int IdCheckOFF = 0xfe;
  public final static int SBMLCheckON = 0x02;
  public final static int SBMLCheckOFF = 0xfd;
  public final static int SBOCheckON = 0x04;
  public final static int SBOCheckOFF = 0xfb;
  public final static int MathCheckON = 0x08;
  public final static int MathCheckOFF = 0xf7;
  public final static int UnitsCheckON = 0x10;
  public final static int UnitsCheckOFF = 0xef;
  public final static int OverdeterCheckON = 0x20;
  public final static int OverdeterCheckOFF = 0xdf;
  public final static int PracticeCheckON = 0x40;
  public final static int PracticeCheckOFF = 0xbf;
  public final static int AllChecksON = 0x7f;
  // UnitKind_t 
  public final static int UNIT_KIND_AMPERE = 0;
  public final static int UNIT_KIND_BECQUEREL = UNIT_KIND_AMPERE + 1;
  public final static int UNIT_KIND_CANDELA = UNIT_KIND_BECQUEREL + 1;
  public final static int UNIT_KIND_CELSIUS = UNIT_KIND_CANDELA + 1;
  public final static int UNIT_KIND_COULOMB = UNIT_KIND_CELSIUS + 1;
  public final static int UNIT_KIND_DIMENSIONLESS = UNIT_KIND_COULOMB + 1;
  public final static int UNIT_KIND_FARAD = UNIT_KIND_DIMENSIONLESS + 1;
  public final static int UNIT_KIND_GRAM = UNIT_KIND_FARAD + 1;
  public final static int UNIT_KIND_GRAY = UNIT_KIND_GRAM + 1;
  public final static int UNIT_KIND_HENRY = UNIT_KIND_GRAY + 1;
  public final static int UNIT_KIND_HERTZ = UNIT_KIND_HENRY + 1;
  public final static int UNIT_KIND_ITEM = UNIT_KIND_HERTZ + 1;
  public final static int UNIT_KIND_JOULE = UNIT_KIND_ITEM + 1;
  public final static int UNIT_KIND_KATAL = UNIT_KIND_JOULE + 1;
  public final static int UNIT_KIND_KELVIN = UNIT_KIND_KATAL + 1;
  public final static int UNIT_KIND_KILOGRAM = UNIT_KIND_KELVIN + 1;
  public final static int UNIT_KIND_LITER = UNIT_KIND_KILOGRAM + 1;
  public final static int UNIT_KIND_LITRE = UNIT_KIND_LITER + 1;
  public final static int UNIT_KIND_LUMEN = UNIT_KIND_LITRE + 1;
  public final static int UNIT_KIND_LUX = UNIT_KIND_LUMEN + 1;
  public final static int UNIT_KIND_METER = UNIT_KIND_LUX + 1;
  public final static int UNIT_KIND_METRE = UNIT_KIND_METER + 1;
  public final static int UNIT_KIND_MOLE = UNIT_KIND_METRE + 1;
  public final static int UNIT_KIND_NEWTON = UNIT_KIND_MOLE + 1;
  public final static int UNIT_KIND_OHM = UNIT_KIND_NEWTON + 1;
  public final static int UNIT_KIND_PASCAL = UNIT_KIND_OHM + 1;
  public final static int UNIT_KIND_RADIAN = UNIT_KIND_PASCAL + 1;
  public final static int UNIT_KIND_SECOND = UNIT_KIND_RADIAN + 1;
  public final static int UNIT_KIND_SIEMENS = UNIT_KIND_SECOND + 1;
  public final static int UNIT_KIND_SIEVERT = UNIT_KIND_SIEMENS + 1;
  public final static int UNIT_KIND_STERADIAN = UNIT_KIND_SIEVERT + 1;
  public final static int UNIT_KIND_TESLA = UNIT_KIND_STERADIAN + 1;
  public final static int UNIT_KIND_VOLT = UNIT_KIND_TESLA + 1;
  public final static int UNIT_KIND_WATT = UNIT_KIND_VOLT + 1;
  public final static int UNIT_KIND_WEBER = UNIT_KIND_WATT + 1;
  public final static int UNIT_KIND_INVALID = UNIT_KIND_WEBER + 1;

  // RuleType_t 
  public final static int RULE_TYPE_RATE = 0;
  public final static int RULE_TYPE_SCALAR = RULE_TYPE_RATE + 1;
  public final static int RULE_TYPE_INVALID = RULE_TYPE_SCALAR + 1;

  public final static int SBML_DEFAULT_LEVEL = 2;
  public final static int SBML_DEFAULT_VERSION = 4;
  public final static String SBML_XMLNS_L1 = "http://www.sbml.org/sbml/level1";
  public final static String SBML_XMLNS_L2V1 = "http://www.sbml.org/sbml/level2";
  public final static String SBML_XMLNS_L2V2 = "http://www.sbml.org/sbml/level2/version2";
  public final static String SBML_XMLNS_L2V3 = "http://www.sbml.org/sbml/level2/version3";
  public final static String SBML_XMLNS_L2V4 = "http://www.sbml.org/sbml/level2/version4";
  public final static String SBML_XMLNS_L3V1 = "http://www.sbml.org/sbml/level3/version1/core";
  // ASTNodeType_t 
  public final static int AST_PLUS = '+';
  public final static int AST_MINUS = '-';
  public final static int AST_TIMES = '*';
  public final static int AST_DIVIDE = '/';
  public final static int AST_POWER = '^';
  public final static int AST_INTEGER = 256;
  public final static int AST_REAL = AST_INTEGER + 1;
  public final static int AST_REAL_E = AST_REAL + 1;
  public final static int AST_RATIONAL = AST_REAL_E + 1;
  public final static int AST_NAME = AST_RATIONAL + 1;
  public final static int AST_NAME_TIME = AST_NAME + 1;
  public final static int AST_CONSTANT_E = AST_NAME_TIME + 1;
  public final static int AST_CONSTANT_FALSE = AST_CONSTANT_E + 1;
  public final static int AST_CONSTANT_PI = AST_CONSTANT_FALSE + 1;
  public final static int AST_CONSTANT_TRUE = AST_CONSTANT_PI + 1;
  public final static int AST_LAMBDA = AST_CONSTANT_TRUE + 1;
  public final static int AST_FUNCTION = AST_LAMBDA + 1;
  public final static int AST_FUNCTION_ABS = AST_FUNCTION + 1;
  public final static int AST_FUNCTION_ARCCOS = AST_FUNCTION_ABS + 1;
  public final static int AST_FUNCTION_ARCCOSH = AST_FUNCTION_ARCCOS + 1;
  public final static int AST_FUNCTION_ARCCOT = AST_FUNCTION_ARCCOSH + 1;
  public final static int AST_FUNCTION_ARCCOTH = AST_FUNCTION_ARCCOT + 1;
  public final static int AST_FUNCTION_ARCCSC = AST_FUNCTION_ARCCOTH + 1;
  public final static int AST_FUNCTION_ARCCSCH = AST_FUNCTION_ARCCSC + 1;
  public final static int AST_FUNCTION_ARCSEC = AST_FUNCTION_ARCCSCH + 1;
  public final static int AST_FUNCTION_ARCSECH = AST_FUNCTION_ARCSEC + 1;
  public final static int AST_FUNCTION_ARCSIN = AST_FUNCTION_ARCSECH + 1;
  public final static int AST_FUNCTION_ARCSINH = AST_FUNCTION_ARCSIN + 1;
  public final static int AST_FUNCTION_ARCTAN = AST_FUNCTION_ARCSINH + 1;
  public final static int AST_FUNCTION_ARCTANH = AST_FUNCTION_ARCTAN + 1;
  public final static int AST_FUNCTION_CEILING = AST_FUNCTION_ARCTANH + 1;
  public final static int AST_FUNCTION_COS = AST_FUNCTION_CEILING + 1;
  public final static int AST_FUNCTION_COSH = AST_FUNCTION_COS + 1;
  public final static int AST_FUNCTION_COT = AST_FUNCTION_COSH + 1;
  public final static int AST_FUNCTION_COTH = AST_FUNCTION_COT + 1;
  public final static int AST_FUNCTION_CSC = AST_FUNCTION_COTH + 1;
  public final static int AST_FUNCTION_CSCH = AST_FUNCTION_CSC + 1;
  public final static int AST_FUNCTION_DELAY = AST_FUNCTION_CSCH + 1;
  public final static int AST_FUNCTION_EXP = AST_FUNCTION_DELAY + 1;
  public final static int AST_FUNCTION_FACTORIAL = AST_FUNCTION_EXP + 1;
  public final static int AST_FUNCTION_FLOOR = AST_FUNCTION_FACTORIAL + 1;
  public final static int AST_FUNCTION_LN = AST_FUNCTION_FLOOR + 1;
  public final static int AST_FUNCTION_LOG = AST_FUNCTION_LN + 1;
  public final static int AST_FUNCTION_PIECEWISE = AST_FUNCTION_LOG + 1;
  public final static int AST_FUNCTION_POWER = AST_FUNCTION_PIECEWISE + 1;
  public final static int AST_FUNCTION_ROOT = AST_FUNCTION_POWER + 1;
  public final static int AST_FUNCTION_SEC = AST_FUNCTION_ROOT + 1;
  public final static int AST_FUNCTION_SECH = AST_FUNCTION_SEC + 1;
  public final static int AST_FUNCTION_SIN = AST_FUNCTION_SECH + 1;
  public final static int AST_FUNCTION_SINH = AST_FUNCTION_SIN + 1;
  public final static int AST_FUNCTION_TAN = AST_FUNCTION_SINH + 1;
  public final static int AST_FUNCTION_TANH = AST_FUNCTION_TAN + 1;
  public final static int AST_LOGICAL_AND = AST_FUNCTION_TANH + 1;
  public final static int AST_LOGICAL_NOT = AST_LOGICAL_AND + 1;
  public final static int AST_LOGICAL_OR = AST_LOGICAL_NOT + 1;
  public final static int AST_LOGICAL_XOR = AST_LOGICAL_OR + 1;
  public final static int AST_RELATIONAL_EQ = AST_LOGICAL_XOR + 1;
  public final static int AST_RELATIONAL_GEQ = AST_RELATIONAL_EQ + 1;
  public final static int AST_RELATIONAL_GT = AST_RELATIONAL_GEQ + 1;
  public final static int AST_RELATIONAL_LEQ = AST_RELATIONAL_GT + 1;
  public final static int AST_RELATIONAL_LT = AST_RELATIONAL_LEQ + 1;
  public final static int AST_RELATIONAL_NEQ = AST_RELATIONAL_LT + 1;
  public final static int AST_UNKNOWN = AST_RELATIONAL_NEQ + 1;

  // XMLErrorCode_t 
  public final static int XMLUnknownError = 0;
  public final static int XMLOutOfMemory = 1;
  public final static int XMLFileUnreadable = 2;
  public final static int XMLFileUnwritable = 3;
  public final static int XMLFileOperationError = 4;
  public final static int XMLNetworkAccessError = 5;
  public final static int InternalXMLParserError = 101;
  public final static int UnrecognizedXMLParserCode = 102;
  public final static int XMLTranscoderError = 103;
  public final static int MissingXMLDecl = 1001;
  public final static int MissingXMLEncoding = 1002;
  public final static int BadXMLDecl = 1003;
  public final static int BadXMLDOCTYPE = 1004;
  public final static int InvalidCharInXML = 1005;
  public final static int BadlyFormedXML = 1006;
  public final static int UnclosedXMLToken = 1007;
  public final static int InvalidXMLConstruct = 1008;
  public final static int XMLTagMismatch = 1009;
  public final static int DuplicateXMLAttribute = 1010;
  public final static int UndefinedXMLEntity = 1011;
  public final static int BadProcessingInstruction = 1012;
  public final static int BadXMLPrefix = 1013;
  public final static int BadXMLPrefixValue = 1014;
  public final static int MissingXMLRequiredAttribute = 1015;
  public final static int XMLAttributeTypeMismatch = 1016;
  public final static int XMLBadUTF8Content = 1017;
  public final static int MissingXMLAttributeValue = 1018;
  public final static int BadXMLAttributeValue = 1019;
  public final static int BadXMLAttribute = 1020;
  public final static int UnrecognizedXMLElement = 1021;
  public final static int BadXMLComment = 1022;
  public final static int BadXMLDeclLocation = 1023;
  public final static int XMLUnexpectedEOF = 1024;
  public final static int BadXMLIDValue = 1025;
  public final static int BadXMLIDRef = 1026;
  public final static int UninterpretableXMLContent = 1027;
  public final static int BadXMLDocumentStructure = 1028;
  public final static int InvalidAfterXMLContent = 1029;
  public final static int XMLExpectedQuotedString = 1030;
  public final static int XMLEmptyValueNotPermitted = 1031;
  public final static int XMLBadNumber = 1032;
  public final static int XMLBadColon = 1033;
  public final static int MissingXMLElements = 1034;
  public final static int XMLContentEmpty = 1035;
  public final static int XMLErrorCodesUpperBound = 9999;

  // XMLErrorCategory_t 
  public final static int LIBSBML_CAT_INTERNAL = 0;
  public final static int LIBSBML_CAT_SYSTEM = LIBSBML_CAT_INTERNAL + 1;
  public final static int LIBSBML_CAT_XML = LIBSBML_CAT_SYSTEM + 1;

  // XMLErrorSeverity_t 
  public final static int LIBSBML_SEV_INFO = 0;
  public final static int LIBSBML_SEV_WARNING = LIBSBML_SEV_INFO + 1;
  public final static int LIBSBML_SEV_ERROR = LIBSBML_SEV_WARNING + 1;
  public final static int LIBSBML_SEV_FATAL = LIBSBML_SEV_ERROR + 1;

  // SBMLErrorCode_t 
  public final static int UnknownError = 10000;
  public final static int NotUTF8 = 10101;
  public final static int UnrecognizedElement = 10102;
  public final static int NotSchemaConformant = 10103;
  public final static int InvalidMathElement = 10201;
  public final static int DisallowedMathMLSymbol = 10202;
  public final static int DisallowedMathMLEncodingUse = 10203;
  public final static int DisallowedDefinitionURLUse = 10204;
  public final static int BadCsymbolDefinitionURLValue = 10205;
  public final static int DisallowedMathTypeAttributeUse = 10206;
  public final static int DisallowedMathTypeAttributeValue = 10207;
  public final static int LambdaOnlyAllowedInFunctionDef = 10208;
  public final static int BooleanOpsNeedBooleanArgs = 10209;
  public final static int NumericOpsNeedNumericArgs = 10210;
  public final static int ArgsToEqNeedSameType = 10211;
  public final static int PiecewiseNeedsConsistentTypes = 10212;
  public final static int PieceNeedsBoolean = 10213;
  public final static int ApplyCiMustBeUserFunction = 10214;
  public final static int ApplyCiMustBeModelComponent = 10215;
  public final static int KineticLawParametersAreLocalOnly = 10216;
  public final static int MathResultMustBeNumeric = 10217;
  public final static int OpsNeedCorrectNumberOfArgs = 10218;
  public final static int InvalidNoArgsPassedToFunctionDef = 10219;
  public final static int DuplicateComponentId = 10301;
  public final static int DuplicateUnitDefinitionId = 10302;
  public final static int DuplicateLocalParameterId = 10303;
  public final static int MultipleAssignmentOrRateRules = 10304;
  public final static int MultipleEventAssignmentsForId = 10305;
  public final static int EventAndAssignmentRuleForId = 10306;
  public final static int DuplicateMetaId = 10307;
  public final static int InvalidSBOTermSyntax = 10308;
  public final static int InvalidMetaidSyntax = 10309;
  public final static int InvalidIdSyntax = 10310;
  public final static int InvalidUnitIdSyntax = 10311;
  public final static int MissingAnnotationNamespace = 10401;
  public final static int DuplicateAnnotationNamespaces = 10402;
  public final static int SBMLNamespaceInAnnotation = 10403;
  public final static int InconsistentArgUnits = 10501;
  public final static int AssignRuleCompartmentMismatch = 10511;
  public final static int AssignRuleSpeciesMismatch = 10512;
  public final static int AssignRuleParameterMismatch = 10513;
  public final static int InitAssignCompartmenMismatch = 10521;
  public final static int InitAssignSpeciesMismatch = 10522;
  public final static int InitAssignParameterMismatch = 10523;
  public final static int RateRuleCompartmentMismatch = 10531;
  public final static int RateRuleSpeciesMismatch = 10532;
  public final static int RateRuleParameterMismatch = 10533;
  public final static int KineticLawNotSubstancePerTime = 10541;
  public final static int DelayUnitsNotTime = 10551;
  public final static int EventAssignCompartmentMismatch = 10561;
  public final static int EventAssignSpeciesMismatch = 10562;
  public final static int EventAssignParameterMismatch = 10563;
  public final static int OverdeterminedSystem = 10601;
  public final static int InvalidModelSBOTerm = 10701;
  public final static int InvalidFunctionDefSBOTerm = 10702;
  public final static int InvalidParameterSBOTerm = 10703;
  public final static int InvalidInitAssignSBOTerm = 10704;
  public final static int InvalidRuleSBOTerm = 10705;
  public final static int InvalidConstraintSBOTerm = 10706;
  public final static int InvalidReactionSBOTerm = 10707;
  public final static int InvalidSpeciesReferenceSBOTerm = 10708;
  public final static int InvalidKineticLawSBOTerm = 10709;
  public final static int InvalidEventSBOTerm = 10710;
  public final static int InvalidEventAssignmentSBOTerm = 10711;
  public final static int InvalidCompartmentSBOTerm = 10712;
  public final static int InvalidSpeciesSBOTerm = 10713;
  public final static int InvalidCompartmentTypeSBOTerm = 10714;
  public final static int InvalidSpeciesTypeSBOTerm = 10715;
  public final static int InvalidTriggerSBOTerm = 10716;
  public final static int InvalidDelaySBOTerm = 10717;
  public final static int NotesNotInXHTMLNamespace = 10801;
  public final static int NotesContainsXMLDecl = 10802;
  public final static int NotesContainsDOCTYPE = 10803;
  public final static int InvalidNotesContent = 10804;
  public final static int InvalidNamespaceOnSBML = 20101;
  public final static int MissingOrInconsistentLevel = 20102;
  public final static int MissingOrInconsistentVersion = 20103;
  public final static int AnnotationNotesNotAllowedLevel1 = 20104;
  public final static int MissingModel = 20201;
  public final static int IncorrectOrderInModel = 20202;
  public final static int EmptyListElement = 20203;
  public final static int NeedCompartmentIfHaveSpecies = 20204;
  public final static int FunctionDefMathNotLambda = 20301;
  public final static int InvalidApplyCiInLambda = 20302;
  public final static int RecursiveFunctionDefinition = 20303;
  public final static int InvalidCiInLambda = 20304;
  public final static int InvalidFunctionDefReturnType = 20305;
  public final static int InvalidUnitDefId = 20401;
  public final static int InvalidSubstanceRedefinition = 20402;
  public final static int InvalidLengthRedefinition = 20403;
  public final static int InvalidAreaRedefinition = 20404;
  public final static int InvalidTimeRedefinition = 20405;
  public final static int InvalidVolumeRedefinition = 20406;
  public final static int VolumeLitreDefExponentNotOne = 20407;
  public final static int VolumeMetreDefExponentNot3 = 20408;
  public final static int EmptyListOfUnits = 20409;
  public final static int InvalidUnitKind = 20410;
  public final static int OffsetNoLongerValid = 20411;
  public final static int CelsiusNoLongerValid = 20412;
  public final static int ZeroDimensionalCompartmentSize = 20501;
  public final static int ZeroDimensionalCompartmentUnits = 20502;
  public final static int ZeroDimensionalCompartmentConst = 20503;
  public final static int UndefinedOutsideCompartment = 20504;
  public final static int RecursiveCompartmentContainment = 20505;
  public final static int ZeroDCompartmentContainment = 20506;
  public final static int Invalid1DCompartmentUnits = 20507;
  public final static int Invalid2DCompartmentUnits = 20508;
  public final static int Invalid3DCompartmentUnits = 20509;
  public final static int InvalidCompartmentTypeRef = 20510;
  public final static int InvalidSpeciesCompartmentRef = 20601;
  public final static int HasOnlySubsNoSpatialUnits = 20602;
  public final static int NoSpatialUnitsInZeroD = 20603;
  public final static int NoConcentrationInZeroD = 20604;
  public final static int SpatialUnitsInOneD = 20605;
  public final static int SpatialUnitsInTwoD = 20606;
  public final static int SpatialUnitsInThreeD = 20607;
  public final static int InvalidSpeciesSusbstanceUnits = 20608;
  public final static int BothAmountAndConcentrationSet = 20609;
  public final static int NonBoundarySpeciesAssignedAndUsed = 20610;
  public final static int NonConstantSpeciesUsed = 20611;
  public final static int InvalidSpeciesTypeRef = 20612;
  public final static int MultSpeciesSameTypeInCompartment = 20613;
  public final static int MissingSpeciesCompartment = 20614;
  public final static int SpatialSizeUnitsRemoved = 20615;
  public final static int InvalidParameterUnits = 20701;
  public final static int InvalidInitAssignSymbol = 20801;
  public final static int MultipleInitAssignments = 20802;
  public final static int InitAssignmentAndRuleForSameId = 20803;
  public final static int InvalidAssignRuleVariable = 20901;
  public final static int InvalidRateRuleVariable = 20902;
  public final static int AssignmentToConstantEntity = 20903;
  public final static int RateRuleForConstantEntity = 20904;
  public final static int RepeatedRule10304 = 20905;
  public final static int CircularRuleDependency = 20906;
  public final static int ConstraintMathNotBoolean = 21001;
  public final static int IncorrectOrderInConstraint = 21002;
  public final static int ConstraintNotInXHTMLNamespace = 21003;
  public final static int ConstraintContainsXMLDecl = 21004;
  public final static int ConstraintContainsDOCTYPE = 21005;
  public final static int InvalidConstraintContent = 21006;
  public final static int NoReactantsOrProducts = 21101;
  public final static int IncorrectOrderInReaction = 21102;
  public final static int EmptyListInReaction = 21103;
  public final static int InvalidReactantsProductsList = 21104;
  public final static int InvalidModifiersList = 21105;
  public final static int InvalidSpeciesReference = 21111;
  public final static int RepeatedRule20611 = 21112;
  public final static int BothStoichiometryAndMath = 21113;
  public final static int UndeclaredSpeciesRef = 21121;
  public final static int IncorrectOrderInKineticLaw = 21122;
  public final static int EmptyListInKineticLaw = 21123;
  public final static int NonConstantLocalParameter = 21124;
  public final static int SubsUnitsNoLongerValid = 21125;
  public final static int TimeUnitsNoLongerValid = 21126;
  public final static int UndeclaredSpeciesInStoichMath = 21131;
  public final static int MissingTriggerInEvent = 21201;
  public final static int TriggerMathNotBoolean = 21202;
  public final static int MissingEventAssignment = 21203;
  public final static int TimeUnitsEvent = 21204;
  public final static int IncorrectOrderInEvent = 21205;
  public final static int ValuesFromTriggerTimeNeedDelay = 21206;
  public final static int InvalidEventAssignmentVariable = 21211;
  public final static int EventAssignmentForConstantEntity = 21212;
  public final static int GeneralWarningNotSpecified = 29999;
  public final static int CompartmentShouldHaveSize = 80501;
  public final static int ParameterShouldHaveUnits = 80701;
  public final static int LocalParameterShadowsId = 81121;
  public final static int LibSBMLAdditionalCodesLowerBound = 90000;
  public final static int CannotConvertToL1V1 = 90001;
  public final static int NoEventsInL1 = 91001;
  public final static int NoFunctionDefinitionsInL1 = 91002;
  public final static int NoConstraintsInL1 = 91003;
  public final static int NoInitialAssignmentsInL1 = 91004;
  public final static int NoSpeciesTypesInL1 = 91005;
  public final static int NoCompartmentTypeInL1 = 91006;
  public final static int NoNon3DComparmentsInL1 = 91007;
  public final static int NoFancyStoichiometryMathInL1 = 91008;
  public final static int NoNonIntegerStoichiometryInL1 = 91009;
  public final static int NoUnitMultipliersOrOffsetsInL1 = 91010;
  public final static int SpeciesCompartmentRequiredInL1 = 91011;
  public final static int NoSpeciesSpatialSizeUnitsInL1 = 91012;
  public final static int NoSBOTermsInL1 = 91013;
  public final static int StrictUnitsRequiredInL1 = 91014;
  public final static int NoConstraintsInL2v1 = 92001;
  public final static int NoInitialAssignmentsInL2v1 = 92002;
  public final static int NoSpeciesTypeInL2v1 = 92003;
  public final static int NoCompartmentTypeInL2v1 = 92004;
  public final static int NoSBOTermsInL2v1 = 92005;
  public final static int NoIdOnSpeciesReferenceInL2v1 = 92006;
  public final static int NoDelayedEventAssignmentInL2v1 = 92007;
  public final static int StrictUnitsRequiredInL2v1 = 92008;
  public final static int SBOTermNotUniversalInL2v2 = 93001;
  public final static int NoUnitOffsetInL2v2 = 93002;
  public final static int NoKineticLawTimeUnitsInL2v2 = 93003;
  public final static int NoKineticLawSubstanceUnitsInL2v2 = 93004;
  public final static int NoDelayedEventAssignmentInL2v2 = 93005;
  public final static int ModelSBOBranchChangedBeyondL2v2 = 93006;
  public final static int StrictUnitsRequiredInL2v2 = 93007;
  public final static int StrictSBORequiredInL2v2 = 93008;
  public final static int DuplicateAnnotationInvalidInL2v2 = 93009;
  public final static int NoUnitOffsetInL2v3 = 94001;
  public final static int NoKineticLawTimeUnitsInL2v3 = 94002;
  public final static int NoKineticLawSubstanceUnitsInL2v3 = 94003;
  public final static int NoSpeciesSpatialSizeUnitsInL2v3 = 94004;
  public final static int NoEventTimeUnitsInL2v3 = 94005;
  public final static int NoDelayedEventAssignmentInL2v3 = 94006;
  public final static int ModelSBOBranchChangedBeyondL2v3 = 94007;
  public final static int StrictUnitsRequiredInL2v3 = 94008;
  public final static int StrictSBORequiredInL2v3 = 94009;
  public final static int DuplicateAnnotationInvalidInL2v3 = 94010;
  public final static int NoUnitOffsetInL2v4 = 95001;
  public final static int NoKineticLawTimeUnitsInL2v4 = 95002;
  public final static int NoKineticLawSubstanceUnitsInL2v4 = 95003;
  public final static int NoSpeciesSpatialSizeUnitsInL2v4 = 95004;
  public final static int NoEventTimeUnitsInL2v4 = 95005;
  public final static int ModelSBOBranchChangedInL2v4 = 95006;
  public final static int DuplicateAnnotationInvalidInL2v4 = 95007;
  public final static int InvalidSBMLLevelVersion = 99101;
  public final static int InvalidRuleOrdering = 99106;
  public final static int SubsUnitsAllowedInKL = 99127;
  public final static int TimeUnitsAllowedInKL = 99128;
  public final static int FormulaInLevel1KL = 99129;
  public final static int TimeUnitsRemoved = 99206;
  public final static int BadMathML = 99219;
  public final static int FailedMathMLReadOfDouble = 99220;
  public final static int FailedMathMLReadOfInteger = 99221;
  public final static int FailedMathMLReadOfExponential = 99222;
  public final static int FailedMathMLReadOfRational = 99223;
  public final static int BadMathMLNodeType = 99224;
  public final static int NoTimeSymbolInFunctionDef = 99301;
  public final static int InconsistentArgUnitsWarnings = 99502;
  public final static int InconsistentPowerUnitsWarnings = 99503;
  public final static int InconsistentExponUnitsWarnings = 99504;
  public final static int UndeclaredUnits = 99505;
  public final static int UnrecognisedSBOTerm = 99701;
  public final static int ObseleteSBOTerm = 99702;
  public final static int IncorrectCompartmentSpatialDimensions = 99901;
  public final static int CompartmentTypeNotValidAttribute = 99902;
  public final static int ConstantNotValidAttribute = 99903;
  public final static int MetaIdNotValidAttribute = 99904;
  public final static int SBOTermNotValidAttributeBeforeL2V3 = 99905;
  public final static int InvalidL1CompartmentUnits = 99906;
  public final static int L1V1CompartmentVolumeReqd = 99907;
  public final static int CompartmentTypeNotValidComponent = 99908;
  public final static int ConstraintNotValidComponent = 99909;
  public final static int EventNotValidComponent = 99910;
  public final static int SBOTermNotValidAttributeBeforeL2V2 = 99911;
  public final static int FuncDefNotValidComponent = 99912;
  public final static int InitialAssignNotValidComponent = 99913;
  public final static int VariableNotValidAttribute = 99914;
  public final static int UnitsNotValidAttribute = 99915;
  public final static int ConstantSpeciesNotValidAttribute = 99916;
  public final static int SpatialSizeUnitsNotValidAttribute = 99917;
  public final static int SpeciesTypeNotValidAttribute = 99918;
  public final static int HasOnlySubsUnitsNotValidAttribute = 99919;
  public final static int IdNotValidAttribute = 99920;
  public final static int NameNotValidAttribute = 99921;
  public final static int SpeciesTypeNotValidComponent = 99922;
  public final static int StoichiometryMathNotValidComponent = 99923;
  public final static int MultiplierNotValidAttribute = 99924;
  public final static int OffsetNotValidAttribute = 99925;
  public final static int L3NotSupported = 99998;
  public final static int SBMLCodesUpperBound = 99999;

  // SBMLErrorCategory_t 
  public final static int LIBSBML_CAT_SBML = (LIBSBML_CAT_XML+1);
  public final static int LIBSBML_CAT_SBML_L1_COMPAT = LIBSBML_CAT_SBML + 1;
  public final static int LIBSBML_CAT_SBML_L2V1_COMPAT = LIBSBML_CAT_SBML_L1_COMPAT + 1;
  public final static int LIBSBML_CAT_SBML_L2V2_COMPAT = LIBSBML_CAT_SBML_L2V1_COMPAT + 1;
  public final static int LIBSBML_CAT_GENERAL_CONSISTENCY = LIBSBML_CAT_SBML_L2V2_COMPAT + 1;
  public final static int LIBSBML_CAT_IDENTIFIER_CONSISTENCY = LIBSBML_CAT_GENERAL_CONSISTENCY + 1;
  public final static int LIBSBML_CAT_UNITS_CONSISTENCY = LIBSBML_CAT_IDENTIFIER_CONSISTENCY + 1;
  public final static int LIBSBML_CAT_MATHML_CONSISTENCY = LIBSBML_CAT_UNITS_CONSISTENCY + 1;
  public final static int LIBSBML_CAT_SBO_CONSISTENCY = LIBSBML_CAT_MATHML_CONSISTENCY + 1;
  public final static int LIBSBML_CAT_OVERDETERMINED_MODEL = LIBSBML_CAT_SBO_CONSISTENCY + 1;
  public final static int LIBSBML_CAT_SBML_L2V3_COMPAT = LIBSBML_CAT_OVERDETERMINED_MODEL + 1;
  public final static int LIBSBML_CAT_MODELING_PRACTICE = LIBSBML_CAT_SBML_L2V3_COMPAT + 1;
  public final static int LIBSBML_CAT_INTERNAL_CONSISTENCY = LIBSBML_CAT_MODELING_PRACTICE + 1;
  public final static int LIBSBML_CAT_SBML_L2V4_COMPAT = LIBSBML_CAT_INTERNAL_CONSISTENCY + 1;

  // SBMLErrorSeverity_t 
  public final static int LIBSBML_SEV_SCHEMA_ERROR = (LIBSBML_SEV_FATAL+1);
  public final static int LIBSBML_SEV_GENERAL_WARNING = LIBSBML_SEV_SCHEMA_ERROR + 1;
  public final static int LIBSBML_SEV_NOT_APPLICABLE = LIBSBML_SEV_GENERAL_WARNING + 1;

  // QualifierType_t 
  public final static int MODEL_QUALIFIER = 0;
  public final static int BIOLOGICAL_QUALIFIER = MODEL_QUALIFIER + 1;
  public final static int UNKNOWN_QUALIFIER = BIOLOGICAL_QUALIFIER + 1;

  // ModelQualifierType_t 
  public final static int BQM_IS = 0;
  public final static int BQM_IS_DESCRIBED_BY = BQM_IS + 1;
  public final static int BQM_UNKNOWN = BQM_IS_DESCRIBED_BY + 1;

  // BiolQualifierType_t 
  public final static int BQB_IS = 0;
  public final static int BQB_HAS_PART = BQB_IS + 1;
  public final static int BQB_IS_PART_OF = BQB_HAS_PART + 1;
  public final static int BQB_IS_VERSION_OF = BQB_IS_PART_OF + 1;
  public final static int BQB_HAS_VERSION = BQB_IS_VERSION_OF + 1;
  public final static int BQB_IS_HOMOLOG_TO = BQB_HAS_VERSION + 1;
  public final static int BQB_IS_DESCRIBED_BY = BQB_IS_HOMOLOG_TO + 1;
  public final static int BQB_IS_ENCODED_BY = BQB_IS_DESCRIBED_BY + 1;
  public final static int BQB_ENCODES = BQB_IS_ENCODED_BY + 1;
  public final static int BQB_OCCURS_IN = BQB_ENCODES + 1;
  public final static int BQB_UNKNOWN = BQB_OCCURS_IN + 1;

}
