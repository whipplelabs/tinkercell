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

public class SBMLErrorLog : XMLErrorLog {
	private HandleRef swigCPtr;
	
	internal SBMLErrorLog(IntPtr cPtr, bool cMemoryOwn) : base(libsbmlPINVOKE.SBMLErrorLogUpcast(cPtr), cMemoryOwn)
	{
		//super(libsbmlPINVOKE.SBMLErrorLogUpcast(cPtr), cMemoryOwn);
		swigCPtr = new HandleRef(this, cPtr);
	}
	
	internal static HandleRef getCPtr(SBMLErrorLog obj)
	{
		return (obj == null) ? new HandleRef(null, IntPtr.Zero) : obj.swigCPtr;
	}
	
	internal static HandleRef getCPtrAndDisown (SBMLErrorLog obj)
	{
		HandleRef ptr = new HandleRef(null, IntPtr.Zero);
		
		if (obj != null)
		{
			ptr             = obj.swigCPtr;
			obj.swigCMemOwn = false;
		}
		
		return ptr;
	}

  ~SBMLErrorLog() {
    Dispose();
  }

  public override void Dispose() {
    lock(this) {
      if (swigCPtr.Handle != IntPtr.Zero) {
        if (swigCMemOwn) {
          swigCMemOwn = false;
          libsbmlPINVOKE.delete_SBMLErrorLog(swigCPtr);
        }
        swigCPtr = new HandleRef(null, IntPtr.Zero);
      }
      GC.SuppressFinalize(this);
      base.Dispose();
    }
  }

  public new SBMLError getError(long n) {
    IntPtr cPtr = libsbmlPINVOKE.SBMLErrorLog_getError(swigCPtr, n);
    SBMLError ret = (cPtr == IntPtr.Zero) ? null : new SBMLError(cPtr, false);
    return ret;
  }

  public long getNumFailsWithSeverity(long severity) { return (long)libsbmlPINVOKE.SBMLErrorLog_getNumFailsWithSeverity(swigCPtr, severity); }

}

}
