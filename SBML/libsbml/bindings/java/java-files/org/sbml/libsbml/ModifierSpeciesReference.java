/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 1.3.40
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package org.sbml.libsbml;

/** 
 * LibSBML implementation of SBML's ModifierSpeciesReference construct.
 * <p>
 * Sometimes a species appears in the kinetic rate formula of a reaction
 * but is itself neither created nor destroyed in that reaction (for
 * example, because it acts as a catalyst or inhibitor).  In SBML, all such
 * species are simply called <em>modifiers</em> without regard to the detailed
 * role of those species in the model.  The {@link Reaction} structure provides a
 * way to express which species act as modifiers in a given reaction.  This
 * is the purpose of the list of modifiers available in {@link Reaction}.  The list
 * contains instances of {@link ModifierSpeciesReference} structures.
 * <p>
 * The {@link ModifierSpeciesReference} structure inherits the mandatory attribute
 * 'species' and optional attributes 'id' and 'name' from the parent class
 * {@link SimpleSpeciesReference}.  See the description of {@link SimpleSpeciesReference}
 * for more information about these.
 * <p>
 * The value of the 'species' attribute must be the identifier of a species
 * defined in the enclosing {@link Model}; this species is designated as a modifier
 * for the current reaction.  A reaction may have any number of modifiers.
 * It is permissible for a modifier species to appear simultaneously in the
 * list of reactants and products of the same reaction where it is
 * designated as a modifier, as well as to appear in the list of reactants,
 * products and modifiers of other reactions in the model.
 * <p>
 * <p>
 * <!---------------------------------------------------------------------- -->
 * <p>
 */

public class ModifierSpeciesReference extends SimpleSpeciesReference {
   private long swigCPtr;

   protected ModifierSpeciesReference(long cPtr, boolean cMemoryOwn)
   {
     super(libsbmlJNI.SWIGModifierSpeciesReferenceUpcast(cPtr), cMemoryOwn);
     swigCPtr = cPtr;
   }

   protected static long getCPtr(ModifierSpeciesReference obj)
   {
     return (obj == null) ? 0 : obj.swigCPtr;
   }

   protected static long getCPtrAndDisown (ModifierSpeciesReference obj)
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
        libsbmlJNI.delete_ModifierSpeciesReference(swigCPtr);
      }
      swigCPtr = 0;
    }
    super.delete();
  }

  
  /**
   * Creates a new {@link ModifierSpeciesReference} using the given SBML <code>level</code> and <code>version</code>
   * values.
   * <p>
   * @param level a long integer, the SBML Level to assign to this {@link ModifierSpeciesReference}
   * <p>
   * @param version a long integer, the SBML Version to assign to this
   * {@link ModifierSpeciesReference}
   * <p>
   * @note Once a {@link ModifierSpeciesReference} has been added to an {@link SBMLDocument}, the <code>level</code>,
   * <code>version</code> for the document <em>override</em> those used
   * to create the {@link ModifierSpeciesReference}.  Despite this, the ability to supply the values
   * at creation time is an important aid to creating valid SBML.  Knowledge of
   * the intented SBML Level and Version determine whether it is valid to
   * assign a particular value to an attribute, or whether it is valid to add
   * an object to an existing {@link SBMLDocument}.
   */
 public ModifierSpeciesReference(long level, long version) throws org.sbml.libsbml.SBMLConstructorException {
    this(libsbmlJNI.new_ModifierSpeciesReference__SWIG_0(level, version), true);
  }

  
  /**
   * Creates a new {@link ModifierSpeciesReference} using the given {@link SBMLNamespaces} object
   * <code>sbmlns</code>.
   * <p>
   * @param sbmlns an {@link SBMLNamespaces} object.
   * <p>
   * @note Once a {@link ModifierSpeciesReference} has been added to an {@link SBMLDocument}, the <code>level</code>,
   * <code>version</code> and <code>xmlns</code> namespaces for the document <em>override</em> those used
   * to create the {@link ModifierSpeciesReference}.  Despite this, the ability to supply the values
   * at creation time is an important aid to creating valid SBML.  Knowledge of
   * the intented SBML Level and Version determine whether it is valid to
   * assign a particular value to an attribute, or whether it is valid to add
   * an object to an existing {@link SBMLDocument}.
   */
 public ModifierSpeciesReference(SBMLNamespaces sbmlns) throws org.sbml.libsbml.SBMLConstructorException {
    this(libsbmlJNI.new_ModifierSpeciesReference__SWIG_1(SBMLNamespaces.getCPtr(sbmlns), sbmlns), true);
  }

  
  /**
   * Creates and returns a deep copy of this {@link ModifierSpeciesReference}
   * instance.
   * <p>
   * @return a (deep) copy of this {@link ModifierSpeciesReference}.
   */
 public SBase cloneObject() {
    long cPtr = libsbmlJNI.ModifierSpeciesReference_cloneObject(swigCPtr, this);
    return (cPtr == 0) ? null : new ModifierSpeciesReference(cPtr, true);
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
    return libsbmlJNI.ModifierSpeciesReference_getTypeCode(swigCPtr, this);
  }

  
  /**
   * Returns the XML element name of this object, which for {@link Species}, is
   * always <code>'modifierSpeciesReference'</code>.
   * <p>
   * @return the name of this element, i.e., <code>'modifierSpeciesReference'</code>.
   */
 public String getElementName() {
    return libsbmlJNI.ModifierSpeciesReference_getElementName(swigCPtr, this);
  }

  
  /**
   * Predicate returning <code>true</code> or <code>false</code> depending on whether
   * all the required attributes for this {@link ModifierSpeciesReference} object
   * have been set.
   * <p>
   * @note The required attributes for a {@link ModifierSpeciesReference} object are:
   * species
   */
 public boolean hasRequiredAttributes() {
    return libsbmlJNI.ModifierSpeciesReference_hasRequiredAttributes(swigCPtr, this);
  }

}
