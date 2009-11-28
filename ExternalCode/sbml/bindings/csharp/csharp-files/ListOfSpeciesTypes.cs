/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 1.3.40
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

namespace libsbml {

using System;
using System.Runtime.InteropServices;

public class ListOfSpeciesTypes : ListOf {
	private HandleRef swigCPtr;
	
	internal ListOfSpeciesTypes(IntPtr cPtr, bool cMemoryOwn) : base(libsbmlPINVOKE.ListOfSpeciesTypesUpcast(cPtr), cMemoryOwn)
	{
		//super(libsbmlPINVOKE.ListOfSpeciesTypesUpcast(cPtr), cMemoryOwn);
		swigCPtr = new HandleRef(this, cPtr);
	}
	
	internal static HandleRef getCPtr(ListOfSpeciesTypes obj)
	{
		return (obj == null) ? new HandleRef(null, IntPtr.Zero) : obj.swigCPtr;
	}
	
	internal static HandleRef getCPtrAndDisown (ListOfSpeciesTypes obj)
	{
		HandleRef ptr = new HandleRef(null, IntPtr.Zero);
		
		if (obj != null)
		{
			ptr             = obj.swigCPtr;
			obj.swigCMemOwn = false;
		}
		
		return ptr;
	}

  ~ListOfSpeciesTypes() {
    Dispose();
  }

  public override void Dispose() {
    lock(this) {
      if (swigCPtr.Handle != IntPtr.Zero) {
        if (swigCMemOwn) {
          swigCMemOwn = false;
          libsbmlPINVOKE.delete_ListOfSpeciesTypes(swigCPtr);
        }
        swigCPtr = new HandleRef(null, IntPtr.Zero);
      }
      GC.SuppressFinalize(this);
      base.Dispose();
    }
  }

  public new ListOfSpeciesTypes clone() {
    IntPtr cPtr = libsbmlPINVOKE.ListOfSpeciesTypes_clone(swigCPtr);
    ListOfSpeciesTypes ret = (cPtr == IntPtr.Zero) ? null : new ListOfSpeciesTypes(cPtr, true);
    return ret;
  }

  public override int getTypeCode() {
    int ret = libsbmlPINVOKE.ListOfSpeciesTypes_getTypeCode(swigCPtr);
    return ret;
  }

  public override int getItemTypeCode() {
    int ret = libsbmlPINVOKE.ListOfSpeciesTypes_getItemTypeCode(swigCPtr);
    return ret;
  }

  public override string getElementName() {
    string ret = libsbmlPINVOKE.ListOfSpeciesTypes_getElementName(swigCPtr);
    return ret;
  }

  public new SpeciesType get(long n) {
    IntPtr cPtr = libsbmlPINVOKE.ListOfSpeciesTypes_get__SWIG_0(swigCPtr, n);
    SpeciesType ret = (cPtr == IntPtr.Zero) ? null : new SpeciesType(cPtr, false);
    return ret;
  }

  public new SpeciesType get(string sid) {
    IntPtr cPtr = libsbmlPINVOKE.ListOfSpeciesTypes_get__SWIG_2(swigCPtr, sid);
    SpeciesType ret = (cPtr == IntPtr.Zero) ? null : new SpeciesType(cPtr, false);
    if (libsbmlPINVOKE.SWIGPendingException.Pending) throw libsbmlPINVOKE.SWIGPendingException.Retrieve();
    return ret;
  }

  public new SpeciesType remove(long n) {
    IntPtr cPtr = libsbmlPINVOKE.ListOfSpeciesTypes_remove__SWIG_0(swigCPtr, n);
    SpeciesType ret = (cPtr == IntPtr.Zero) ? null : new SpeciesType(cPtr, true);
    return ret;
  }

  public new SpeciesType remove(string sid) {
    IntPtr cPtr = libsbmlPINVOKE.ListOfSpeciesTypes_remove__SWIG_1(swigCPtr, sid);
    SpeciesType ret = (cPtr == IntPtr.Zero) ? null : new SpeciesType(cPtr, true);
    if (libsbmlPINVOKE.SWIGPendingException.Pending) throw libsbmlPINVOKE.SWIGPendingException.Retrieve();
    return ret;
  }

  public ListOfSpeciesTypes() : this(libsbmlPINVOKE.new_ListOfSpeciesTypes(), true) {
  }

}

}
