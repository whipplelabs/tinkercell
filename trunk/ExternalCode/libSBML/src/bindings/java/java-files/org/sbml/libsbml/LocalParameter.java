/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 1.3.40
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package org.sbml.libsbml;

/** 
 * LibSBML implementation of SBML Level&nbsp;3's LocalParameter construct.
 * <p>
 * {@link LocalParameter} has been introduced in SBML Level&nbsp;3 to serve as the
 * object class for parameter definitions that are intended to be local to
 * a {@link Reaction}.  Objects of class {@link LocalParameter} never appear at the {@link Model}
 * level; they are always contained within {@link ListOfLocalParameters} lists
 * which are in turn contained within {@link KineticLaw} objects.
 * <p>
 * Like its global {@link Parameter} counterpart, the {@link LocalParameter} object class
 * is used to define a symbol associated with a value; this symbol can then
 * be used in a model's mathematical formulas (and specifically, for
 * {@link LocalParameter}, reaction rate formulas).  Unlike {@link Parameter}, the
 * {@link LocalParameter} class does not have a 'constant' attribute: local
 * parameters within reactions are <em>always</em> constant.
 * <p>
 * {@link LocalParameter} has one required attribute, 'id', to give the
 * parameter a unique identifier by which other parts of an SBML model
 * definition can refer to it.  A parameter can also have an optional
 * 'name' attribute of type <code>string</code>.  Identifiers and names must be used
 * according to the guidelines described in the SBML specifications.
 * <p>
 * The optional attribute 'value' determines the value (of type <code>double</code>)
 * assigned to the parameter.  A missing value for 'value' implies that
 * the value either is unknown, or to be obtained from an external source,
 * or determined by an initial assignment.  The unit of measurement
 * associated with the value of the parameter can be specified using the
 * optional attribute 'units'.  Here we only mention briefly some notable
 * points about the possible unit choices, but readers are urged to consult
 * the SBML specification documents for more information:
 * <ul>
 * <p>
 * <li> In SBML Level&nbsp;3, there are no constraints on the units that
 * can be assigned to parameters in a model; there are also no units to
 * inherit from the enclosing {@link Model} object.
 * <p>
 * <li> In SBML Level&nbsp;2, the value assigned to the parameter's 'units'
 * attribute must be chosen from one of the following possibilities: one of
 * the base unit identifiers defined in SBML; one of the built-in unit
 * identifiers <code>'substance'</code>, <code>'time'</code>, <code>'volume'</code>, <code>'area'</code> or 
 * <code>'length'</code>; or the identifier of a new unit defined in the list of unit
 * definitions in the enclosing {@link Model} structure.  There are no constraints
 * on the units that can be chosen from these sets.  There are no default
 * units for local parameters.
 * </ul>
 * <p>
 * As with all other major SBML components, {@link LocalParameter} is derived from
 * {@link SBase}, and the methods defined on {@link SBase} are available on {@link LocalParameter}.
 * <p>
 * @warning LibSBML derives {@link LocalParameter} from {@link Parameter}; however, this
 * does not precisely match the object hierarchy defined by SBML
 * Level&nbsp;3, where LocalParamter is derived directly from {@link SBase} and not
 * {@link Parameter}.  We believe this arrangement makes it easier for libSBML
 * users to program applications that work with both SBML Level&nbsp;2 and
 * SBML Level&nbsp;3, but programmers should also keep in mind this
 * difference exists.  A side-effect of libSBML's scheme is that certain
 * methods on {@link LocalParameter} that are inherited from {@link Parameter} do not
 * actually have relevance to {@link LocalParameter} objects.  An example of this
 * is the methods pertaining to {@link Parameter}'s attribute 'constant'
 * (i.e., isSetConstant(), setConstant(), and getConstant()).
 * <p>
 * @see ListOfLocalParameters
 * @see KineticLaw
 * <p>
 * <!-- leave this next break as-is to work around some doxygen bug -->
 */

public class LocalParameter extends Parameter {
   private long swigCPtr;

   protected LocalParameter(long cPtr, boolean cMemoryOwn)
   {
     super(libsbmlJNI.SWIGLocalParameterUpcast(cPtr), cMemoryOwn);
     swigCPtr = cPtr;
   }

   protected static long getCPtr(LocalParameter obj)
   {
     return (obj == null) ? 0 : obj.swigCPtr;
   }

   protected static long getCPtrAndDisown (LocalParameter obj)
   {
     long ptr = 0;

     if (obj != null)
     {
       ptr             = obj.swigCPtr;
       obj.swigCMemOwn = false;
     }

     return ptr;
   }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        libsbmlJNI.delete_LocalParameter(swigCPtr);
      }
      swigCPtr = 0;
    }
    super.delete();
  }

  
  /**
   * Creates a new {@link LocalParameter} object with the given SBML <code>level</code> and
   * <code>version</code> values.
   * <p>
   * @param level a long integer, the SBML Level to assign to this
   * {@link LocalParameter}.
   * <p>
   * @param version a long integer, the SBML Version to assign to this
   * {@link LocalParameter}.
   * <p>
   * @note Upon the addition of a {@link LocalParameter} object to an {@link SBMLDocument}
   * (e.g., using KineticLaw.addLocalParameter()), the SBML Level, SBML
   * Version and XML namespace of the document <em>override</em> the
   * values used when creating the {@link LocalParameter} object via this
   * constructor.  This is necessary to ensure that an SBML document is a
   * consistent structure.  Nevertheless, the ability to supply the values
   * at the time of creation of a {@link LocalParameter} is an important aid to
   * producing valid SBML.  Knowledge of the intented SBML Level and
   * Version determine whether it is valid to assign a particular value to
   * an attribute, or whether it is valid to add an object to an existing
   * {@link SBMLDocument}.
   */
 public LocalParameter(long level, long version) throws org.sbml.libsbml.SBMLConstructorException {
    this(libsbmlJNI.new_LocalParameter__SWIG_0(level, version), true);
  }

  
  /**
   * Creates a new {@link LocalParameter} object with the given {@link SBMLNamespaces}
   * object <code>sbmlns</code>.
   * <p>
   * The {@link SBMLNamespaces} object encapsulates SBML Level/Version/namespaces
   * information.  It is used to communicate the SBML Level, Version, and
   * (in Level&nbsp;3) packages used in addition to SBML Level&nbsp;3 Core.
   * A common approach to using this class constructor is to create an
   * {@link SBMLNamespaces} object somewhere in a program, once, then pass it to
   * object constructors such as this one when needed.
   * <p>
   * It is worth emphasizing that although this constructor does not take
   * an identifier argument, in SBML Level&nbsp;2 and beyond, the 'id'
   * (identifier) attribute of a {@link LocalParameter} is required to have a value.
   * Thus, callers are cautioned to assign a value after calling this
   * constructor if no identifier is provided as an argument.  Setting the
   * identifier can be accomplished using the method
   * setId(String id).
   * <p>
   * @param sbmlns an {@link SBMLNamespaces} object.
   * <p>
   * @note Upon the addition of a {@link LocalParameter} object to an {@link SBMLDocument}
   * (e.g., using Model.addLocalParameter()), the SBML XML namespace of
   * the document <em>overrides</em> the value used when creating the
   * {@link LocalParameter} object via this constructor.  This is necessary to
   * ensure that an SBML document is a consistent structure.  Nevertheless,
   * the ability to supply the values at the time of creation of a
   * {@link LocalParameter} is an important aid to producing valid SBML.  Knowledge
   * of the intented SBML Level and Version determine whether it is valid
   * to assign a particular value to an attribute, or whether it is valid
   * to add an object to an existing {@link SBMLDocument}.
   */
 public LocalParameter(SBMLNamespaces sbmlns) throws org.sbml.libsbml.SBMLConstructorException {
    this(libsbmlJNI.new_LocalParameter__SWIG_1(SBMLNamespaces.getCPtr(sbmlns), sbmlns), true);
  }

  
  /**
   * Copy constructor; creates a copy of a given {@link LocalParameter} object.
   * <p>
   * @param orig the {@link LocalParameter} instance to copy.
   */
 public LocalParameter(LocalParameter orig) throws org.sbml.libsbml.SBMLConstructorException {
    this(libsbmlJNI.new_LocalParameter__SWIG_2(LocalParameter.getCPtr(orig), orig), true);
  }

  
  /**
   * Copy constructor; creates a {@link LocalParameter} object by copying
   * the attributes of a given {@link Parameter} object.
   * <p>
   * @param orig the {@link Parameter} instance to copy.
   */
 public LocalParameter(Parameter orig) throws org.sbml.libsbml.SBMLConstructorException {
    this(libsbmlJNI.new_LocalParameter__SWIG_3(Parameter.getCPtr(orig), orig), true);
  }

  
  /**
   * Creates and returns a deep copy of this {@link LocalParameter}.
   * <p>
   * @return a (deep) copy of this {@link LocalParameter}.
   */
 public LocalParameter cloneObject() {
    long cPtr = libsbmlJNI.LocalParameter_cloneObject(swigCPtr, this);
    return (cPtr == 0) ? null : new LocalParameter(cPtr, true);
  }

  
  /**
   * Constructs and returns a {@link UnitDefinition} that corresponds to the units
   * of this {@link LocalParameter}'s value.
   * <p>
   * LocalParameters in SBML have an attribute ('units') for declaring the
   * units of measurement intended for the parameter's value.  <b>No
   * defaults are defined</b> by SBML in the absence of a definition for
   * 'units'.  This method returns a {@link UnitDefinition} object based on the
   * units declared for this {@link LocalParameter} using its 'units' attribute, or
   * it returns <code>NULL</code> if no units have been declared.
   * <p>
   * Note that unit declarations for {@link LocalParameter} objects are specified
   * in terms of the <em>identifier</em> of a unit (e.g., using setUnits()), but
   * <em>this</em> method returns a {@link UnitDefinition} object, not a unit
   * identifier.  It does this by constructing an appropriate
   * {@link UnitDefinition}.  For SBML Level&nbsp;2 models, it will do this even
   * when the value of the 'units' attribute is one of the predefined SBML
   * units <code>'substance'</code>, <code>'volume'</code>, <code>'area'</code>, <code>'length'</code> or 
   * <code>'time'</code>.  Callers may find this useful in conjunction with the helper
   * methods provided by the {@link UnitDefinition} class for comparing different
   * {@link UnitDefinition} objects.
   * <p>
   * @return a {@link UnitDefinition} that expresses the units of this 
   * {@link LocalParameter}, or <code>NULL</code> if one cannot be constructed.
   * <p>
   * @note The libSBML system for unit analysis depends on the model as a
   * whole.  In cases where the {@link LocalParameter} object has not yet been
   * added to a model, or the model itself is incomplete, unit analysis is
   * not possible, and consequently this method will return <code>NULL</code>.
   * <p>
   * @see #isSetUnits()
   */
 public UnitDefinition getDerivedUnitDefinition() {
    long cPtr = libsbmlJNI.LocalParameter_getDerivedUnitDefinition__SWIG_0(swigCPtr, this);
    return (cPtr == 0) ? null : new UnitDefinition(cPtr, false);
  }

  
  /**
   * Returns the libSBML type code for this SBML object.
   * <p>
   * LibSBML attaches an
   * identifying code to every kind of SBML object.  These are known as
   * <em>SBML type codes</em>.  In other languages, the set of type codes
   * is stored in an enumeration; in the Java language interface for
   * libSBML, the type codes are defined as static integer constants in
   * interface class {@link libsbmlConstants}.  The names of the type codes
   * all begin with the characters <code>SBML_</code>. 
   * <p>
   * @return the SBML type code for this object, or @link
   * SBMLTypeCode_t#SBML_UNKNOWN SBML_UNKNOWN@endlink (default).
   * <p>
   * @see #getElementName()
   */
 public int getTypeCode() {
    return libsbmlJNI.LocalParameter_getTypeCode(swigCPtr, this);
  }

  
  /**
   * Returns the XML element name of this object, which for {@link LocalParameter},
   * is always <code>'localParameter'</code>.
   * <p>
   * @return the name of this element, i.e., <code>'localParameter'</code>.
   */
 public String getElementName() {
    return libsbmlJNI.LocalParameter_getElementName(swigCPtr, this);
  }

  
  /**
   * Predicate returning <code>true</code> if
   * all the required attributes for this {@link LocalParameter} object
   * have been set.
   * <p>
   * @note The required attributes for a {@link LocalParameter} object are:
   * <li> 'id'
   * <li> 'value'
   * <p>
   * @return a boolean value indicating whether all the required
   * attributes for this object have been defined.
   */
 public boolean hasRequiredAttributes() {
    return libsbmlJNI.LocalParameter_hasRequiredAttributes(swigCPtr, this);
  }

}
