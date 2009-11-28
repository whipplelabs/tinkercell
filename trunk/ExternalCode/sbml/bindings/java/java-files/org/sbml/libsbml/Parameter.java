/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 1.3.40
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package org.sbml.libsbml;

/** 
 * LibSBML implementation of SBML's Parameter construct.
 * <p>
 * A {@link Parameter} is used in SBML to define a symbol associated with a value;
 * this symbol can then be used in mathematical formulas in a model.  By
 * default, parameters have constant value for the duration of a
 * simulation, and for this reason are called <em>parameters</em> instead of 
 * <em>variables</em> in SBML, although it is crucial to understand that <em>%SBML
 * parameters represent both concepts</em>.  Whether a given SBML
 * parameter is intended to be constant or variable is indicated by the
 * value of its 'constant' attribute.
 * <p>
 * SBML's {@link Parameter} has one required attribute, 'id', to give the
 * parameter a unique identifier by which other parts of an SBML model
 * definition can refer to it.  A parameter can also have an optional
 * 'name' attribute of type <code>string</code>.  Identifiers and names must be used
 * according to the guidelines described in the SBML specification (e.g.,
 * Section 3.3 in the Level&nbsp;2 Version&nbsp;4 specification).
 * <p>
 * The optional attribute 'value' determines the value (of type <code>double</code>)
 * assigned to the identifier.  A missing value for 'value' implies that
 * the value either is unknown, or to be obtained from an external source,
 * or determined by an initial assignment.  The units associated with the
 * value of the parameter are specified by the attribute named 'units'.
 * The value assigned to the parameter's 'units' attribute must be chosen
 * from one of the following possibilities: one of the base unit
 * identifiers defined in SBML; one of the built-in unit identifiers 
 * <code>'substance'</code>, <code>'time'</code>, <code>'volume'</code>, <code>'area'</code> or <code>'length'</code>; or the
 * identifier of a new unit defined in the list of unit definitions in the
 * enclosing {@link Model} structure.  There are no constraints on the units that
 * can be chosen from these sets.  There are no default units for
 * parameters.  Please consult the SBML specification documents for more
 * details about the meanings and implications of the various unit choices.
 * <p>
 * The {@link Parameter} structure has an optional boolean attribute named
 * 'constant' that indicates whether the parameter's value can vary during
 * a simulation.  The attribute's default value is <code>true</code>.  A value of 
 * <code>false</code> indicates the parameter's value can be changed by {@link Rule} constructs
 * and that the 'value' attribute is actually intended to be the initial
 * value of the parameter. Parameters local to a reaction (that is, those
 * defined within the {@link KineticLaw} structure of a {@link Reaction}) cannot be changed
 * by rules and therefore are implicitly always constant; thus, parameter
 * definitions within {@link Reaction} structures should <em>not</em> have their
 * 'constant' attribute set to <code>false</code>.
 * <p>
 * What if a global parameter has its 'constant' attribute set to <code>false</code>,
 * but the model does not contain any rules, events or other constructs
 * that ever change its value over time?  Although the model may be
 * suspect, this situation is not strictly an error.  A value of <code>false</code>
 * for 'constant' only indicates that a parameter <em>can</em> change value, not
 * that it <em>must</em>.
 * <p>
 * As with all other major SBML components, {@link Parameter} is derived from
 * {@link SBase}, and the methods defined on {@link SBase} are available on {@link Parameter}.
 * <p>
 * @see ListOfParameters
 * @see KineticLaw
 * <p>
 * @note The use of the term <em>parameter</em> in SBML sometimes leads to
 * confusion among readers who have a particular notion of what something
 * called 'parameter' should be.  It has been the source of heated debate,
 * but despite this, no one has yet found an adequate replacement term that
 * does not have different connotations to different people and hence leads
 * to confusion among <em>some</em> subset of users.  Perhaps it would have been
 * better to have two constructs, one called <em>constants</em> and the other
 * called <em>variables</em>.  The current approach in SBML is simply more
 * parsimonious, using a single {@link Parameter} construct with the boolean flag
 * 'constant' indicating which flavor it is.  In any case, readers are
 * implored to look past their particular definition of a <em>parameter</em> and
 * simply view SBML's {@link Parameter} as a single mechanism for defining both
 * constants and (additional) variables in a model.  (We write 
 * <em>additional</em> because the species in a model are usually considered to be
 * the central variables.)  After all, software tools are not required to
 * expose to users the actual names of particular SBML constructs, and
 * thus tools can present to their users whatever terms their designers
 * feel best matches their target audience.
 * <p>
 * <!-- leave this next break as-is to work around some doxygen bug -->
 */

public class Parameter extends SBase {
   private long swigCPtr;

   protected Parameter(long cPtr, boolean cMemoryOwn)
   {
     super(libsbmlJNI.SWIGParameterUpcast(cPtr), cMemoryOwn);
     swigCPtr = cPtr;
   }

   protected static long getCPtr(Parameter obj)
   {
     return (obj == null) ? 0 : obj.swigCPtr;
   }

   protected static long getCPtrAndDisown (Parameter obj)
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
        libsbmlJNI.delete_Parameter(swigCPtr);
      }
      swigCPtr = 0;
    }
    super.delete();
  }

  
  /**
   * Creates a new {@link Parameter} using the given SBML <code>level</code> and <code>version</code>
   * values.
   * <p>
   * @param level a long integer, the SBML Level to assign to this {@link Parameter}
   * <p>
   * @param version a long integer, the SBML Version to assign to this
   * {@link Parameter}
   * <p>
   * @note Once a {@link Parameter} has been added to an {@link SBMLDocument}, the <code>level</code>,
   * <code>version</code> for the document <em>override</em> those used
   * to create the {@link Parameter}.  Despite this, the ability to supply the values
   * at creation time is an important aid to creating valid SBML.  Knowledge of
   * the intented SBML Level and Version determine whether it is valid to
   * assign a particular value to an attribute, or whether it is valid to add
   * an object to an existing {@link SBMLDocument}.
   */
 public Parameter(long level, long version) throws org.sbml.libsbml.SBMLConstructorException {
    this(libsbmlJNI.new_Parameter__SWIG_0(level, version), true);
  }

  
  /**
   * Creates a new {@link Parameter} using the given {@link SBMLNamespaces} object
   * <code>sbmlns</code>.
   * <p>
   * The {@link SBMLNamespaces} object encapsulates SBML Level/Version/namespaces
   * information.  It is used to communicate the SBML Level, Version, and
   * (in Level&nbsp;3) packages used in addition to SBML Level&nbsp; Core.
   * A common approach to using this class constructor is to create an
   * {@link SBMLNamespaces} object somewhere in a program, once, then pass it to
   * object constructors such as this one when needed.
   * <p>
   * It is worth emphasizing that although this constructor does not take
   * an identifier argument, in SBML Level&nbsp;2 and beyond, the 'id'
   * (identifier) attribute of a {@link Parameter} is required to have a value.
   * Thus, callers are cautioned to assign a value after calling this
   * constructor if no identifier is provided as an argument.  Setting the
   * identifier can be accomplished using the method {@link SBase#setId(String id)}.
   * <p>
   * <p>
   * @param sbmlns an {@link SBMLNamespaces} object.
   * <p>
   * @note Once a {@link Parameter} has been added to an {@link SBMLDocument}, the <code>level</code>,
   * <code>version</code> and <code>xmlns</code> namespaces for the document <em>override</em> those used
   * to create the {@link Parameter}.  Despite this, the ability to supply the values
   * at creation time is an important aid to creating valid SBML.  Knowledge of
   * the intented SBML Level and Version determine whether it is valid to
   * assign a particular value to an attribute, or whether it is valid to add
   * an object to an existing {@link SBMLDocument}.
   */
 public Parameter(SBMLNamespaces sbmlns) throws org.sbml.libsbml.SBMLConstructorException {
    this(libsbmlJNI.new_Parameter__SWIG_1(SBMLNamespaces.getCPtr(sbmlns), sbmlns), true);
  }

  
  /**
   * Copy constructor; creates a copy of a {@link Parameter}.
   * <p>
   * @param orig the {@link Parameter} instance to copy.
   */
 public Parameter(Parameter orig) throws org.sbml.libsbml.SBMLConstructorException {
    this(libsbmlJNI.new_Parameter__SWIG_2(Parameter.getCPtr(orig), orig), true);
  }

  
  /**
   * Creates and returns a deep copy of this {@link Parameter}.
   * <p>
   * @return a (deep) copy of this {@link Parameter}.
   */
 public Parameter cloneObject() {
    long cPtr = libsbmlJNI.Parameter_cloneObject(swigCPtr, this);
    return (cPtr == 0) ? null : new Parameter(cPtr, true);
  }

  
  /**
   * Initializes the fields of this {@link Parameter} to the defaults defined in
   * the specification of the relevant Level/Version of SBML.
   * <p>
   * The exact actions of this are as follows:
   * <ul>
   * <li> (%SBML Level&nbsp;2 only) set the 'constant' attribute to <code>true</code>.
   * </ul>
   */
 public void initDefaults() {
    libsbmlJNI.Parameter_initDefaults(swigCPtr, this);
  }

  
  /**
   * Returns the value of the 'id' attribute of this {@link Parameter}.
   * <p>
   * @return the id of this {@link Parameter}.
   */
 public String getId() {
    return libsbmlJNI.Parameter_getId(swigCPtr, this);
  }

  
  /**
   * Returns the value of the 'name' attribute of this {@link Parameter}.
   * <p>
   * @return the name of this {@link Parameter}.
   */
 public String getName() {
    return libsbmlJNI.Parameter_getName(swigCPtr, this);
  }

  
  /**
   * Gets the numerical value of this {@link Parameter}.
   * <p>
   * @return the value of the 'value' attribute of this {@link Parameter}, as a
   * number of type <code>double</code>.
   * <p>
   * @see #isSetValue()
   * <p>
   * @note <b>It is crucial</b> that callers not blindly call
   * Parameter.getValue() without first checking with
   * Parameter.isSetValue() to determine whether a value has been set.
   * Otherwise, the value return by Parameter.getValue() may not actually
   * represent a value assigned to the parameter.
   */
 public double getValue() {
    return libsbmlJNI.Parameter_getValue(swigCPtr, this);
  }

  
  /**
   * Gets the units defined for this {@link Parameter}
   * <p>
   * @return the value of the 'units' attribute of this {@link Parameter}, as a
   * string.
   */
 public String getUnits() {
    return libsbmlJNI.Parameter_getUnits(swigCPtr, this);
  }

  
  /**
   * Gets the value of the 'constant' attribute of this {@link Parameter} instance.
   * <p>
   * Note that in SBML Level&nbsp;2 and beyond, the default value of
   * {@link Parameter}'s 'constant' attribute is <code>true</code>.  Since a boolean value
   * can only be <code>true</code> or <code>false</code>, there is no 'isSetConstant()'
   * method as is available for the other attributes on {@link Parameter}, because
   * 'unset' is not an option.
   * <p>
   * @return <code>true</code> if this {@link Parameter} has been declared as being constant,
   * <code>false</code> otherwise.
   */
 public boolean getConstant() {
    return libsbmlJNI.Parameter_getConstant(swigCPtr, this);
  }

  
  /**
   * Predicate returning <code>true</code> or <code>false</code> depending on whether this
   * {@link Parameter}'s 'id' attribute has been set.
   * <p>
   * <em>Some words of explanation about the</em>
<code>set</code>/<code>unset</code>/<code>isSet</code> <em>methods</em>:
SBML Levels 1 and 2 define certain attributes on some classes of objects as
optional.  This requires an application to be careful about the distinction
between two cases: (1) a given attribute has <em>never</em> been set to a
value, and therefore should be assumed to have the SBML-defined default
value, and (2) a given attribute has been set to a value, but the value
happens to be an empty string.  LibSBML supports these distinctions by
providing methods to set, unset, and query the status of attributes that
are optional.  The methods have names of the form
<code>set</code><i>Attribute</i><code>(...)</code>,
<code>unset</code><i>Attribute</i><code>()</code>, and
<code>isSet</code><i>Attribute</i><code>()</code>, where <i>Attribute</i>
is the the name of the optional attribute in question.

   * <p>
   * @return <code>true</code> if the 'id' attribute of this {@link Parameter} has been
   * set, <code>false</code> otherwise.
   */
 public boolean isSetId() {
    return libsbmlJNI.Parameter_isSetId(swigCPtr, this);
  }

  
  /**
   * Predicate returning <code>true</code> or <code>false</code> depending on whether this
   * {@link Parameter}'s 'name' attribute has been set.
   * <p>
   * <em>Some words of explanation about the</em>
<code>set</code>/<code>unset</code>/<code>isSet</code> <em>methods</em>:
SBML Levels 1 and 2 define certain attributes on some classes of objects as
optional.  This requires an application to be careful about the distinction
between two cases: (1) a given attribute has <em>never</em> been set to a
value, and therefore should be assumed to have the SBML-defined default
value, and (2) a given attribute has been set to a value, but the value
happens to be an empty string.  LibSBML supports these distinctions by
providing methods to set, unset, and query the status of attributes that
are optional.  The methods have names of the form
<code>set</code><i>Attribute</i><code>(...)</code>,
<code>unset</code><i>Attribute</i><code>()</code>, and
<code>isSet</code><i>Attribute</i><code>()</code>, where <i>Attribute</i>
is the the name of the optional attribute in question.

   * <p>
   * @return <code>true</code> if the 'name' attribute of this {@link Parameter} has been
   * set, <code>false</code> otherwise.
   */
 public boolean isSetName() {
    return libsbmlJNI.Parameter_isSetName(swigCPtr, this);
  }

  
  /**
   * Predicate returning <code>true</code> or <code>false</code> depending on whether the
   * 'value' attribute of this {@link Parameter} has been set.
   * <p>
   * <em>Some words of explanation about the</em>
<code>set</code>/<code>unset</code>/<code>isSet</code> <em>methods</em>:
SBML Levels 1 and 2 define certain attributes on some classes of objects as
optional.  This requires an application to be careful about the distinction
between two cases: (1) a given attribute has <em>never</em> been set to a
value, and therefore should be assumed to have the SBML-defined default
value, and (2) a given attribute has been set to a value, but the value
happens to be an empty string.  LibSBML supports these distinctions by
providing methods to set, unset, and query the status of attributes that
are optional.  The methods have names of the form
<code>set</code><i>Attribute</i><code>(...)</code>,
<code>unset</code><i>Attribute</i><code>()</code>, and
<code>isSet</code><i>Attribute</i><code>()</code>, where <i>Attribute</i>
is the the name of the optional attribute in question.

   * <p>
   * In SBML definitions after SBML Level&nbsp;1 Version&nbsp;1,
   * parameter values are optional and have no defaults.  If a model read
   * from a file does not contain a setting for the 'value' attribute of a
   * parameter, its value is considered unset; it does not default to any
   * particular value.  Similarly, when a {@link Parameter} object is created in
   * libSBML, it has no value until given a value.  The
   * Parameter.isSetValue() method allows calling applications to
   * determine whether a given parameter's value has ever been set.
   * <p>
   * In SBML Level&nbsp;1 Version&nbsp;1, parameters are required to have
   * values and therefore, the value of a {@link Parameter} <b>should always be
   * set</b>.  In Level&nbsp;1 Version&nbsp;2 and beyond, the value is
   * optional and as such, the 'value' attribute may or may not be set.
   * <p>
   * @return <code>true</code> if the value of this {@link Parameter} has been set,
   * <code>false</code> otherwise.
   * <p>
   * @see #getValue()
   * <p>
   * @note <b>It is crucial</b> that callers not blindly call
   * Parameter.getValue() without first checking with
   * Parameter.isSetValue() to determine whether a value has been set.
   * Otherwise, the value return by Parameter.getValue() may not actually
   * represent a value assigned to the parameter.
   */
 public boolean isSetValue() {
    return libsbmlJNI.Parameter_isSetValue(swigCPtr, this);
  }

  
  /**
   * Predicate returning <code>true</code> or <code>false</code> depending on whether the
   * 'units' attribute of this {@link Parameter} has been set.
   * <p>
   * <em>Some words of explanation about the</em>
<code>set</code>/<code>unset</code>/<code>isSet</code> <em>methods</em>:
SBML Levels 1 and 2 define certain attributes on some classes of objects as
optional.  This requires an application to be careful about the distinction
between two cases: (1) a given attribute has <em>never</em> been set to a
value, and therefore should be assumed to have the SBML-defined default
value, and (2) a given attribute has been set to a value, but the value
happens to be an empty string.  LibSBML supports these distinctions by
providing methods to set, unset, and query the status of attributes that
are optional.  The methods have names of the form
<code>set</code><i>Attribute</i><code>(...)</code>,
<code>unset</code><i>Attribute</i><code>()</code>, and
<code>isSet</code><i>Attribute</i><code>()</code>, where <i>Attribute</i>
is the the name of the optional attribute in question.

   * <p>
   * @return <code>true</code> if the 'units' attribute of this {@link Parameter} has been
   * set, <code>false</code> otherwise.
   */
 public boolean isSetUnits() {
    return libsbmlJNI.Parameter_isSetUnits(swigCPtr, this);
  }

  
  /**
   * Predicate returning <code>true</code> or <code>false</code> depending on whether the
   * 'constant' attribute of this {@link Parameter} has been set.
   * <p>
   * <em>Some words of explanation about the</em>
<code>set</code>/<code>unset</code>/<code>isSet</code> <em>methods</em>:
SBML Levels 1 and 2 define certain attributes on some classes of objects as
optional.  This requires an application to be careful about the distinction
between two cases: (1) a given attribute has <em>never</em> been set to a
value, and therefore should be assumed to have the SBML-defined default
value, and (2) a given attribute has been set to a value, but the value
happens to be an empty string.  LibSBML supports these distinctions by
providing methods to set, unset, and query the status of attributes that
are optional.  The methods have names of the form
<code>set</code><i>Attribute</i><code>(...)</code>,
<code>unset</code><i>Attribute</i><code>()</code>, and
<code>isSet</code><i>Attribute</i><code>()</code>, where <i>Attribute</i>
is the the name of the optional attribute in question.

   * <p>
   * @return <code>true</code> if the 'constant' attribute of this {@link Parameter} has been
   * set, <code>false</code> otherwise.
   */
 public boolean isSetConstant() {
    return libsbmlJNI.Parameter_isSetConstant(swigCPtr, this);
  }

  
  /**
   * Sets the value of the 'id' attribute of this {@link Parameter}.
   * <p>
   * The string <code>sid</code> is copied.  Note that SBML has strict requirements
   * for the syntax of identifiers.  The following is summary of the
   * definition of the SBML identifier type <code>SId</code> (here expressed in an
   * extended form of BNF notation):
   * <div class='fragment'><pre>
   *   letter .= 'a'..'z','A'..'Z'
   *   digit  .= '0'..'9'
   *   idChar .= letter | digit | '_'
   *   SId    .= ( letter | '_' ) idChar</pre></div>
   * The equality of SBML identifiers is determined by an exact character
   * sequence match; i.e., comparisons must be performed in a
   * case-sensitive manner.  In addition, there are a few conditions for
   * the uniqueness of identifiers in an SBML model.  Please consult the
   * SBML specifications for the exact formulations.
   * <p>
   * <em>Some words of explanation about the</em>
<code>set</code>/<code>unset</code>/<code>isSet</code> <em>methods</em>:
SBML Levels 1 and 2 define certain attributes on some classes of objects as
optional.  This requires an application to be careful about the distinction
between two cases: (1) a given attribute has <em>never</em> been set to a
value, and therefore should be assumed to have the SBML-defined default
value, and (2) a given attribute has been set to a value, but the value
happens to be an empty string.  LibSBML supports these distinctions by
providing methods to set, unset, and query the status of attributes that
are optional.  The methods have names of the form
<code>set</code><i>Attribute</i><code>(...)</code>,
<code>unset</code><i>Attribute</i><code>()</code>, and
<code>isSet</code><i>Attribute</i><code>()</code>, where <i>Attribute</i>
is the the name of the optional attribute in question.

   * <p>
   * @param sid the string to use as the identifier of this {@link Parameter}
   * <p>
   * @return integer value indicating success/failure of the
   * function.   The possible values
   * returned by this function are:
   * <li> LIBSBML_OPERATION_SUCCESS
   * <li> LIBSBML_INVALID_ATTRIBUTE_VALUE
   */
 public int setId(String sid) {
    return libsbmlJNI.Parameter_setId(swigCPtr, this, sid);
  }

  
  /**
   * Sets the value of the 'name' attribute of this {@link Parameter}.
   * <p>
   * The string in <code>name</code> is copied.
   * <p>
   * <em>Some words of explanation about the</em>
<code>set</code>/<code>unset</code>/<code>isSet</code> <em>methods</em>:
SBML Levels 1 and 2 define certain attributes on some classes of objects as
optional.  This requires an application to be careful about the distinction
between two cases: (1) a given attribute has <em>never</em> been set to a
value, and therefore should be assumed to have the SBML-defined default
value, and (2) a given attribute has been set to a value, but the value
happens to be an empty string.  LibSBML supports these distinctions by
providing methods to set, unset, and query the status of attributes that
are optional.  The methods have names of the form
<code>set</code><i>Attribute</i><code>(...)</code>,
<code>unset</code><i>Attribute</i><code>()</code>, and
<code>isSet</code><i>Attribute</i><code>()</code>, where <i>Attribute</i>
is the the name of the optional attribute in question.

   * <p>
   * @param name the new name for the {@link Parameter}
   * <p>
   * @return integer value indicating success/failure of the
   * function.   The possible values
   * returned by this function are:
   * <li> LIBSBML_OPERATION_SUCCESS
   * <li> LIBSBML_INVALID_ATTRIBUTE_VALUE
   */
 public int setName(String name) {
    return libsbmlJNI.Parameter_setName(swigCPtr, this, name);
  }

  
  /**
   * Sets the 'value' attribute of this {@link Parameter} to the given <code>double</code>
   * value and marks the attribute as set.
   * <p>
   * <em>Some words of explanation about the</em>
<code>set</code>/<code>unset</code>/<code>isSet</code> <em>methods</em>:
SBML Levels 1 and 2 define certain attributes on some classes of objects as
optional.  This requires an application to be careful about the distinction
between two cases: (1) a given attribute has <em>never</em> been set to a
value, and therefore should be assumed to have the SBML-defined default
value, and (2) a given attribute has been set to a value, but the value
happens to be an empty string.  LibSBML supports these distinctions by
providing methods to set, unset, and query the status of attributes that
are optional.  The methods have names of the form
<code>set</code><i>Attribute</i><code>(...)</code>,
<code>unset</code><i>Attribute</i><code>()</code>, and
<code>isSet</code><i>Attribute</i><code>()</code>, where <i>Attribute</i>
is the the name of the optional attribute in question.

   * <p>
   * @param value a <code>double</code>, the value to assign
   * <p>
   * @return integer value indicating success/failure of the
   * function.   The possible values
   * returned by this function are:
   * <li> LIBSBML_OPERATION_SUCCESS
   */
 public int setValue(double value) {
    return libsbmlJNI.Parameter_setValue(swigCPtr, this, value);
  }

  
  /**
   * Sets the 'units' attribute of this {@link Parameter} to a copy of the given
   * units identifier <code>units</code>.
   * <p>
   * <em>Some words of explanation about the</em>
<code>set</code>/<code>unset</code>/<code>isSet</code> <em>methods</em>:
SBML Levels 1 and 2 define certain attributes on some classes of objects as
optional.  This requires an application to be careful about the distinction
between two cases: (1) a given attribute has <em>never</em> been set to a
value, and therefore should be assumed to have the SBML-defined default
value, and (2) a given attribute has been set to a value, but the value
happens to be an empty string.  LibSBML supports these distinctions by
providing methods to set, unset, and query the status of attributes that
are optional.  The methods have names of the form
<code>set</code><i>Attribute</i><code>(...)</code>,
<code>unset</code><i>Attribute</i><code>()</code>, and
<code>isSet</code><i>Attribute</i><code>()</code>, where <i>Attribute</i>
is the the name of the optional attribute in question.

   * <p>
   * @param units a string, the identifier of the units to assign to this
   * {@link Parameter} instance
   * <p>
   * @return integer value indicating success/failure of the
   * function.   The possible values
   * returned by this function are:
   * <li> LIBSBML_OPERATION_SUCCESS
   * <li> LIBSBML_INVALID_ATTRIBUTE_VALUE
   */
 public int setUnits(String units) {
    return libsbmlJNI.Parameter_setUnits(swigCPtr, this, units);
  }

  
  /**
   * Sets the 'constant' attribute of this {@link Parameter} to the given boolean
   * <code>flag</code>.
   * <p>
   * @param flag a boolean, the value for the 'constant' attribute of this
   * {@link Parameter} instance
   * <p>
   * @return integer value indicating success/failure of the
   * function.   The possible values
   * returned by this function are:
   * <li> LIBSBML_OPERATION_SUCCESS
   * <li> LIBSBML_UNEXPECTED_ATTRIBUTE
   */
 public int setConstant(boolean flag) {
    return libsbmlJNI.Parameter_setConstant(swigCPtr, this, flag);
  }

  
  /**
   * Unsets the value of the 'name' attribute of this {@link Parameter}.
   * <p>
   * <em>Some words of explanation about the</em>
<code>set</code>/<code>unset</code>/<code>isSet</code> <em>methods</em>:
SBML Levels 1 and 2 define certain attributes on some classes of objects as
optional.  This requires an application to be careful about the distinction
between two cases: (1) a given attribute has <em>never</em> been set to a
value, and therefore should be assumed to have the SBML-defined default
value, and (2) a given attribute has been set to a value, but the value
happens to be an empty string.  LibSBML supports these distinctions by
providing methods to set, unset, and query the status of attributes that
are optional.  The methods have names of the form
<code>set</code><i>Attribute</i><code>(...)</code>,
<code>unset</code><i>Attribute</i><code>()</code>, and
<code>isSet</code><i>Attribute</i><code>()</code>, where <i>Attribute</i>
is the the name of the optional attribute in question.

   * <p>
   * @return integer value indicating success/failure of the
   * function.   The possible values
   * returned by this function are:
   * <li> LIBSBML_OPERATION_SUCCESS
   * <li> LIBSBML_OPERATION_FAILED
   */
 public int unsetName() {
    return libsbmlJNI.Parameter_unsetName(swigCPtr, this);
  }

  
  /**
   * Unsets the 'value' attribute of this {@link Parameter} instance.
   * <p>
   * <em>Some words of explanation about the</em>
<code>set</code>/<code>unset</code>/<code>isSet</code> <em>methods</em>:
SBML Levels 1 and 2 define certain attributes on some classes of objects as
optional.  This requires an application to be careful about the distinction
between two cases: (1) a given attribute has <em>never</em> been set to a
value, and therefore should be assumed to have the SBML-defined default
value, and (2) a given attribute has been set to a value, but the value
happens to be an empty string.  LibSBML supports these distinctions by
providing methods to set, unset, and query the status of attributes that
are optional.  The methods have names of the form
<code>set</code><i>Attribute</i><code>(...)</code>,
<code>unset</code><i>Attribute</i><code>()</code>, and
<code>isSet</code><i>Attribute</i><code>()</code>, where <i>Attribute</i>
is the the name of the optional attribute in question.

   * <p>
   * @return integer value indicating success/failure of the
   * function.   The possible values
   * returned by this function are:
   * <li> LIBSBML_OPERATION_SUCCESS
   * <p>
   * In SBML Level&nbsp;1 Version&nbsp;1, parameters are required to have
   * values and therefore, the value of a {@link Parameter} <b>should always be
   * set</b>.  In SBML Level&nbsp;1 Version&nbsp;2 and beyond, the value
   * is optional and as such, the 'value' attribute may or may not be set.
   */
 public int unsetValue() {
    return libsbmlJNI.Parameter_unsetValue(swigCPtr, this);
  }

  
  /**
   * Unsets the 'units' attribute of this {@link Parameter} instance.
   * <p>
   * <em>Some words of explanation about the</em>
<code>set</code>/<code>unset</code>/<code>isSet</code> <em>methods</em>:
SBML Levels 1 and 2 define certain attributes on some classes of objects as
optional.  This requires an application to be careful about the distinction
between two cases: (1) a given attribute has <em>never</em> been set to a
value, and therefore should be assumed to have the SBML-defined default
value, and (2) a given attribute has been set to a value, but the value
happens to be an empty string.  LibSBML supports these distinctions by
providing methods to set, unset, and query the status of attributes that
are optional.  The methods have names of the form
<code>set</code><i>Attribute</i><code>(...)</code>,
<code>unset</code><i>Attribute</i><code>()</code>, and
<code>isSet</code><i>Attribute</i><code>()</code>, where <i>Attribute</i>
is the the name of the optional attribute in question.

   * <p>
   * @return integer value indicating success/failure of the
   * function.   The possible values
   * returned by this function are:
   * <li> LIBSBML_OPERATION_SUCCESS
   * <li> LIBSBML_OPERATION_FAILED
   */
 public int unsetUnits() {
    return libsbmlJNI.Parameter_unsetUnits(swigCPtr, this);
  }

  
  /**
   * Constructs and returns a {@link UnitDefinition} that corresponds to the units
   * of this {@link Parameter}'s value.
   * <p>
   * Parameters in SBML have an attribute ('units') for declaring the units
   * of measurement intended for the parameter's value.  <b>No defaults are
   * defined</b> by SBML in the absence of a definition for 'units'.  The
   * Parameter.getDerivedUnitDefinition() method returns a {@link UnitDefinition}
   * object based on the units declared for this {@link Parameter} using its
   * 'units' attribute, or it returns NULL if no units have been declared.
   * <p>
   * Note that the functionality that facilitates unit analysis depends 
   * on the model as a whole.  Thus, in cases where the object has not 
   * been added to a model or the model itself is incomplete,
   * unit analysis is not possible and this method will return NULL.
   * <p>
   * Note that unit declarations for {@link Parameter} are in terms of the 
   * <em>identifier</em> of a unit, but this method returns a {@link UnitDefinition} object,
   * not a unit identifier.  It does this by constructing an appropriate
   * {@link UnitDefinition} even when the value of the 'units' attribute is one of
   * the predefined SBML units <code>'substance'</code>, <code>'volume'</code>, <code>'area'</code>, 
   * <code>'length'</code> or <code>'time'</code>.  Callers may find this particularly useful
   * when used in conjunction with the helper methods on {@link UnitDefinition}
   * for comparing different {@link UnitDefinition} objects.
   * <p>
   * @return a {@link UnitDefinition} that expresses the units of this 
   * {@link Parameter}.
   */
 public UnitDefinition getDerivedUnitDefinition() {
    long cPtr = libsbmlJNI.Parameter_getDerivedUnitDefinition__SWIG_0(swigCPtr, this);
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
   * @return the SBML type code for this object, or <code>SBML_UNKNOWN</code> (default).
   * <p>
   * @see #getElementName()
   */
 public int getTypeCode() {
    return libsbmlJNI.Parameter_getTypeCode(swigCPtr, this);
  }

  
  /**
   * Returns the XML element name of this object, which for {@link Parameter}, is
   * always <code>'parameter'</code>.
   * <p>
   * @return the name of this element, i.e., <code>'parameter'</code>.
   */
 public String getElementName() {
    return libsbmlJNI.Parameter_getElementName(swigCPtr, this);
  }

  
  /**
   * Predicate returning <code>true</code> or <code>false</code> depending on whether
   * all the required attributes for this {@link Parameter} object
   * have been set.
   * <p>
   * @note The required attributes for a {@link Parameter} object are:
   * id (name in L1); value (L1V1 only)
   * <p>
   * @return a boolean value indicating whether all the required
   * attributes for this object have been defined.
   */
 public boolean hasRequiredAttributes() {
    return libsbmlJNI.Parameter_hasRequiredAttributes(swigCPtr, this);
  }

}
