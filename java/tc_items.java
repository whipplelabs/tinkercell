/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 1.3.40
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */


public class tc_items {
  private long swigCPtr;
  protected boolean swigCMemOwn;

  protected tc_items(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(tc_items obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        tinkercellJNI.delete_tc_items(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public void setLength(int value) {
    tinkercellJNI.tc_items_length_set(swigCPtr, this, value);
  }

  public int getLength() {
    return tinkercellJNI.tc_items_length_get(swigCPtr, this);
  }

  public void setItems(SWIGTYPE_p_long value) {
    tinkercellJNI.tc_items_items_set(swigCPtr, this, SWIGTYPE_p_long.getCPtr(value));
  }

  public SWIGTYPE_p_long getItems() {
    long cPtr = tinkercellJNI.tc_items_items_get(swigCPtr, this);
    return (cPtr == 0) ? null : new SWIGTYPE_p_long(cPtr, false);
  }

  public tc_items() {
    this(tinkercellJNI.new_tc_items(), true);
  }

}
