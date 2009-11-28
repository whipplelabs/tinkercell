/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 1.3.40
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package org.sbml.libsbml;

/** 
 * Representation of MIRIAM-compliant dates used in {@link ModelHistory}.
 * <p>
 * <em style='color: #555'>
This class of objects is defined by libSBML only and has no direct
equivalent in terms of SBML components.  This class is not prescribed by
the SBML specifications, although it is used to implement features
defined in SBML.
</em>

 * <p>
 * A {@link Date} object stores a reasonably complete date representation,
 * consisting of the following fields:
 * <ul>
 * <li> <em>year</em>: a long integer representing the year.
 * <li> <em>month</em>: a long integer representing the month.
 * <li> <em>day</em>: a long integer representing the day.
 * <li> <em>hour</em>: a long integer representing the hour.
 * <li> <em>minute</em>: a long integer representing the minute.
 * <li> <em>second</em>: a long integer representing the second.
 * <li> <em>sign</em>: a long integer representing the sign of the offset (0/1 equivalent to +/-). 
 * <li> <em>hours</em> offset: a long integer representing the hoursOffset.
 * <li> <em>minute</em> offset: a long integer representing the minutesOffset.
 * </ul>
 */

public class Date {
   private long swigCPtr;
   protected boolean swigCMemOwn;

   protected Date(long cPtr, boolean cMemoryOwn)
   {
     swigCMemOwn = cMemoryOwn;
     swigCPtr    = cPtr;
   }

   protected static long getCPtr(Date obj)
   {
     return (obj == null) ? 0 : obj.swigCPtr;
   }

   protected static long getCPtrAndDisown (Date obj)
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
        libsbmlJNI.delete_Date(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  /**
   * Equality comparison method for Date.
   * <p>
   * Because the Java methods for libSBML are actually wrappers around code
   * implemented in C++ and C, certain operations will not behave as
   * expected.  Equality comparison is one such case.  An instance of a
   * libSBML object class is actually a <em>proxy object</em>
   * wrapping the real underlying C/C++ object.  The normal <code>==</code>
   * equality operator in Java will <em>only compare the Java proxy objects</em>,
   * not the underlying native object.  The result is almost never what you
   * want in practical situations.  Unfortunately, Java does not provide a
   * way to override <code>==</code>.
   *  <p>
   * The alternative that must be followed is to use the
   * <code>equals()</code> method.  The <code>equals</code> method on this
   * class overrides the default java.lang.Object one, and performs an
   * intelligent comparison of instances of objects of this class.  The
   * result is an assessment of whether two libSBML Java objects are truly 
   * the same underlying native-code objects.
   *  <p>
   * The use of this method in practice is the same as the use of any other
   * Java <code>equals</code> method.  For example,
   * <em>a</em><code>.equals(</code><em>b</em><code>)</code> returns
   * <code>true</code> if <em>a</em> and <em>b</em> are references to the
   * same underlying object.
   *
   * @param sb a reference to an object to which the current object
   * instance will be compared
   *
   * @return <code>true</code> if <code>sb</code> refers to the same underlying 
   * native object as this one, <code>false</code> otherwise
   */
  public boolean equals(Object sb)
  {
    if ( this == sb ) 
    {
      return true;
    }
    return swigCPtr == getCPtr((Date)(sb));
  }

  /**
   * Returns a hashcode for this Date object.
   *
   * @return a hash code usable by Java methods that need them.
   */
  public int hashCode()
  {
    return (int)(swigCPtr^(swigCPtr>>>32));
  }

  
  /**
   * Creates a date optionally from the individual fields entered as numbers.
   * <p>
   * @param year a long integer representing the year.
   * @param month a long integer representing the month.
   * @param day a long integer representing the day.
   * @param hour a long integer representing the hour.
   * @param minute a long integer representing the minute.
   * @param second a long integer representing the second.
   * @param sign a long integer representing the sign of the offset 
   * (0/1 equivalent to +/-). 
   * @param hoursOffset a long integer representing the hoursOffset.
   * @param minutesOffset a long integer representing the minutesOffset.
   * <p>
   * @docnote The native C++ implementation of this method defines a
   * default argument value.  In the documentation generated for different
   * libSBML language bindings, you may or may not see corresponding
   * arguments in the method declarations.  For example, in Java, a default
   * argument is handled by declaring two separate methods, with one of
   * them having the argument and the other one lacking the argument.
   * However, the libSBML documentation will be <em>identical</em> for both
   * methods.  Consequently, if you are reading this and do not see an
   * argument even though one is described, please look for descriptions of
   * other variants of this method near where this one appears in the
   * documentation.
   */
 public Date(long year, long month, long day, long hour, long minute, long second, long sign, long hoursOffset, long minutesOffset) {
    this(libsbmlJNI.new_Date__SWIG_0(year, month, day, hour, minute, second, sign, hoursOffset, minutesOffset), true);
  }

  
  /**
   * Creates a date optionally from the individual fields entered as numbers.
   * <p>
   * @param year a long integer representing the year.
   * @param month a long integer representing the month.
   * @param day a long integer representing the day.
   * @param hour a long integer representing the hour.
   * @param minute a long integer representing the minute.
   * @param second a long integer representing the second.
   * @param sign a long integer representing the sign of the offset 
   * (0/1 equivalent to +/-). 
   * @param hoursOffset a long integer representing the hoursOffset.
   * @param minutesOffset a long integer representing the minutesOffset.
   * <p>
   * @docnote The native C++ implementation of this method defines a
   * default argument value.  In the documentation generated for different
   * libSBML language bindings, you may or may not see corresponding
   * arguments in the method declarations.  For example, in Java, a default
   * argument is handled by declaring two separate methods, with one of
   * them having the argument and the other one lacking the argument.
   * However, the libSBML documentation will be <em>identical</em> for both
   * methods.  Consequently, if you are reading this and do not see an
   * argument even though one is described, please look for descriptions of
   * other variants of this method near where this one appears in the
   * documentation.
   */
 public Date(long year, long month, long day, long hour, long minute, long second, long sign, long hoursOffset) {
    this(libsbmlJNI.new_Date__SWIG_1(year, month, day, hour, minute, second, sign, hoursOffset), true);
  }

  
  /**
   * Creates a date optionally from the individual fields entered as numbers.
   * <p>
   * @param year a long integer representing the year.
   * @param month a long integer representing the month.
   * @param day a long integer representing the day.
   * @param hour a long integer representing the hour.
   * @param minute a long integer representing the minute.
   * @param second a long integer representing the second.
   * @param sign a long integer representing the sign of the offset 
   * (0/1 equivalent to +/-). 
   * @param hoursOffset a long integer representing the hoursOffset.
   * @param minutesOffset a long integer representing the minutesOffset.
   * <p>
   * @docnote The native C++ implementation of this method defines a
   * default argument value.  In the documentation generated for different
   * libSBML language bindings, you may or may not see corresponding
   * arguments in the method declarations.  For example, in Java, a default
   * argument is handled by declaring two separate methods, with one of
   * them having the argument and the other one lacking the argument.
   * However, the libSBML documentation will be <em>identical</em> for both
   * methods.  Consequently, if you are reading this and do not see an
   * argument even though one is described, please look for descriptions of
   * other variants of this method near where this one appears in the
   * documentation.
   */
 public Date(long year, long month, long day, long hour, long minute, long second, long sign) {
    this(libsbmlJNI.new_Date__SWIG_2(year, month, day, hour, minute, second, sign), true);
  }

  
  /**
   * Creates a date optionally from the individual fields entered as numbers.
   * <p>
   * @param year a long integer representing the year.
   * @param month a long integer representing the month.
   * @param day a long integer representing the day.
   * @param hour a long integer representing the hour.
   * @param minute a long integer representing the minute.
   * @param second a long integer representing the second.
   * @param sign a long integer representing the sign of the offset 
   * (0/1 equivalent to +/-). 
   * @param hoursOffset a long integer representing the hoursOffset.
   * @param minutesOffset a long integer representing the minutesOffset.
   * <p>
   * @docnote The native C++ implementation of this method defines a
   * default argument value.  In the documentation generated for different
   * libSBML language bindings, you may or may not see corresponding
   * arguments in the method declarations.  For example, in Java, a default
   * argument is handled by declaring two separate methods, with one of
   * them having the argument and the other one lacking the argument.
   * However, the libSBML documentation will be <em>identical</em> for both
   * methods.  Consequently, if you are reading this and do not see an
   * argument even though one is described, please look for descriptions of
   * other variants of this method near where this one appears in the
   * documentation.
   */
 public Date(long year, long month, long day, long hour, long minute, long second) {
    this(libsbmlJNI.new_Date__SWIG_3(year, month, day, hour, minute, second), true);
  }

  
  /**
   * Creates a date optionally from the individual fields entered as numbers.
   * <p>
   * @param year a long integer representing the year.
   * @param month a long integer representing the month.
   * @param day a long integer representing the day.
   * @param hour a long integer representing the hour.
   * @param minute a long integer representing the minute.
   * @param second a long integer representing the second.
   * @param sign a long integer representing the sign of the offset 
   * (0/1 equivalent to +/-). 
   * @param hoursOffset a long integer representing the hoursOffset.
   * @param minutesOffset a long integer representing the minutesOffset.
   * <p>
   * @docnote The native C++ implementation of this method defines a
   * default argument value.  In the documentation generated for different
   * libSBML language bindings, you may or may not see corresponding
   * arguments in the method declarations.  For example, in Java, a default
   * argument is handled by declaring two separate methods, with one of
   * them having the argument and the other one lacking the argument.
   * However, the libSBML documentation will be <em>identical</em> for both
   * methods.  Consequently, if you are reading this and do not see an
   * argument even though one is described, please look for descriptions of
   * other variants of this method near where this one appears in the
   * documentation.
   */
 public Date(long year, long month, long day, long hour, long minute) {
    this(libsbmlJNI.new_Date__SWIG_4(year, month, day, hour, minute), true);
  }

  
  /**
   * Creates a date optionally from the individual fields entered as numbers.
   * <p>
   * @param year a long integer representing the year.
   * @param month a long integer representing the month.
   * @param day a long integer representing the day.
   * @param hour a long integer representing the hour.
   * @param minute a long integer representing the minute.
   * @param second a long integer representing the second.
   * @param sign a long integer representing the sign of the offset 
   * (0/1 equivalent to +/-). 
   * @param hoursOffset a long integer representing the hoursOffset.
   * @param minutesOffset a long integer representing the minutesOffset.
   * <p>
   * @docnote The native C++ implementation of this method defines a
   * default argument value.  In the documentation generated for different
   * libSBML language bindings, you may or may not see corresponding
   * arguments in the method declarations.  For example, in Java, a default
   * argument is handled by declaring two separate methods, with one of
   * them having the argument and the other one lacking the argument.
   * However, the libSBML documentation will be <em>identical</em> for both
   * methods.  Consequently, if you are reading this and do not see an
   * argument even though one is described, please look for descriptions of
   * other variants of this method near where this one appears in the
   * documentation.
   */
 public Date(long year, long month, long day, long hour) {
    this(libsbmlJNI.new_Date__SWIG_5(year, month, day, hour), true);
  }

  
  /**
   * Creates a date optionally from the individual fields entered as numbers.
   * <p>
   * @param year a long integer representing the year.
   * @param month a long integer representing the month.
   * @param day a long integer representing the day.
   * @param hour a long integer representing the hour.
   * @param minute a long integer representing the minute.
   * @param second a long integer representing the second.
   * @param sign a long integer representing the sign of the offset 
   * (0/1 equivalent to +/-). 
   * @param hoursOffset a long integer representing the hoursOffset.
   * @param minutesOffset a long integer representing the minutesOffset.
   * <p>
   * @docnote The native C++ implementation of this method defines a
   * default argument value.  In the documentation generated for different
   * libSBML language bindings, you may or may not see corresponding
   * arguments in the method declarations.  For example, in Java, a default
   * argument is handled by declaring two separate methods, with one of
   * them having the argument and the other one lacking the argument.
   * However, the libSBML documentation will be <em>identical</em> for both
   * methods.  Consequently, if you are reading this and do not see an
   * argument even though one is described, please look for descriptions of
   * other variants of this method near where this one appears in the
   * documentation.
   */
 public Date(long year, long month, long day) {
    this(libsbmlJNI.new_Date__SWIG_6(year, month, day), true);
  }

  
  /**
   * Creates a date optionally from the individual fields entered as numbers.
   * <p>
   * @param year a long integer representing the year.
   * @param month a long integer representing the month.
   * @param day a long integer representing the day.
   * @param hour a long integer representing the hour.
   * @param minute a long integer representing the minute.
   * @param second a long integer representing the second.
   * @param sign a long integer representing the sign of the offset 
   * (0/1 equivalent to +/-). 
   * @param hoursOffset a long integer representing the hoursOffset.
   * @param minutesOffset a long integer representing the minutesOffset.
   * <p>
   * @docnote The native C++ implementation of this method defines a
   * default argument value.  In the documentation generated for different
   * libSBML language bindings, you may or may not see corresponding
   * arguments in the method declarations.  For example, in Java, a default
   * argument is handled by declaring two separate methods, with one of
   * them having the argument and the other one lacking the argument.
   * However, the libSBML documentation will be <em>identical</em> for both
   * methods.  Consequently, if you are reading this and do not see an
   * argument even though one is described, please look for descriptions of
   * other variants of this method near where this one appears in the
   * documentation.
   */
 public Date(long year, long month) {
    this(libsbmlJNI.new_Date__SWIG_7(year, month), true);
  }

  
  /**
   * Creates a date optionally from the individual fields entered as numbers.
   * <p>
   * @param year a long integer representing the year.
   * @param month a long integer representing the month.
   * @param day a long integer representing the day.
   * @param hour a long integer representing the hour.
   * @param minute a long integer representing the minute.
   * @param second a long integer representing the second.
   * @param sign a long integer representing the sign of the offset 
   * (0/1 equivalent to +/-). 
   * @param hoursOffset a long integer representing the hoursOffset.
   * @param minutesOffset a long integer representing the minutesOffset.
   * <p>
   * @docnote The native C++ implementation of this method defines a
   * default argument value.  In the documentation generated for different
   * libSBML language bindings, you may or may not see corresponding
   * arguments in the method declarations.  For example, in Java, a default
   * argument is handled by declaring two separate methods, with one of
   * them having the argument and the other one lacking the argument.
   * However, the libSBML documentation will be <em>identical</em> for both
   * methods.  Consequently, if you are reading this and do not see an
   * argument even though one is described, please look for descriptions of
   * other variants of this method near where this one appears in the
   * documentation.
   */
 public Date(long year) {
    this(libsbmlJNI.new_Date__SWIG_8(year), true);
  }

  
  /**
   * Creates a date optionally from the individual fields entered as numbers.
   * <p>
   * @param year a long integer representing the year.
   * @param month a long integer representing the month.
   * @param day a long integer representing the day.
   * @param hour a long integer representing the hour.
   * @param minute a long integer representing the minute.
   * @param second a long integer representing the second.
   * @param sign a long integer representing the sign of the offset 
   * (0/1 equivalent to +/-). 
   * @param hoursOffset a long integer representing the hoursOffset.
   * @param minutesOffset a long integer representing the minutesOffset.
   * <p>
   * @docnote The native C++ implementation of this method defines a
   * default argument value.  In the documentation generated for different
   * libSBML language bindings, you may or may not see corresponding
   * arguments in the method declarations.  For example, in Java, a default
   * argument is handled by declaring two separate methods, with one of
   * them having the argument and the other one lacking the argument.
   * However, the libSBML documentation will be <em>identical</em> for both
   * methods.  Consequently, if you are reading this and do not see an
   * argument even though one is described, please look for descriptions of
   * other variants of this method near where this one appears in the
   * documentation.
   */
 public Date() {
    this(libsbmlJNI.new_Date__SWIG_9(), true);
  }

  
  /**
   * Creates a date from a string.
   * <p>
   * @param date a string representing the date.
   * <p>
   * @note the string should be in W3CDTF format 
   * YYYY-MM-DDThh:mm:ssTZD (eg 1997-07-16T19:20:30+01:00)
   * where TZD is the time zone designator.
   */
 public Date(String date) {
    this(libsbmlJNI.new_Date__SWIG_10(date), true);
  }

  
  /**
   * Copy constructor; creates a copy of this {@link Date}.
   */
 public Date(Date orig) {
    this(libsbmlJNI.new_Date__SWIG_11(Date.getCPtr(orig), orig), true);
  }

  
  /**
   * Returns a copy of this {@link Date}.
   * <p>
   * @return a (deep) copy of this {@link Date}.
   */
 public Date cloneObject() {
    long cPtr = libsbmlJNI.Date_cloneObject(swigCPtr, this);
    return (cPtr == 0) ? null : new Date(cPtr, true);
  }

  
  /**
   * Returns the year from this {@link Date}.
   * <p>
   * @return the year from this {@link Date}.
   */
 public long getYear() {
    return libsbmlJNI.Date_getYear(swigCPtr, this);
  }

  
  /**
   * Returns the month from this {@link Date}.
   * <p>
   * @return the month from this {@link Date}.
   */
 public long getMonth() {
    return libsbmlJNI.Date_getMonth(swigCPtr, this);
  }

  
  /**
   * Returns the day from this {@link Date}.
   * <p>
   * @return the day from this {@link Date}.
   */
 public long getDay() {
    return libsbmlJNI.Date_getDay(swigCPtr, this);
  }

  
  /**
   * Returns the hour from this {@link Date}.
   * <p>
   * @return the hour from this {@link Date}.
   */
 public long getHour() {
    return libsbmlJNI.Date_getHour(swigCPtr, this);
  }

  
  /**
   * Returns the minute from this {@link Date}.
   * <p>
   * @return the minute from this {@link Date}.
   */
 public long getMinute() {
    return libsbmlJNI.Date_getMinute(swigCPtr, this);
  }

  
  /**
   * Returns the seconds from this {@link Date}.
   * <p>
   * @return the seconds from this {@link Date}.
   */
 public long getSecond() {
    return libsbmlJNI.Date_getSecond(swigCPtr, this);
  }

  
  /**
   * Returns the sign of the offset from this {@link Date}.
   * <p>
   * @return the sign of the offset from this {@link Date}.
   */
 public long getSignOffset() {
    return libsbmlJNI.Date_getSignOffset(swigCPtr, this);
  }

  
  /**
   * Returns the hours of the offset from this {@link Date}.
   * <p>
   * @return the hours of the offset from this {@link Date}.
   */
 public long getHoursOffset() {
    return libsbmlJNI.Date_getHoursOffset(swigCPtr, this);
  }

  
  /**
   * Returns the minutes of the offset from this {@link Date}.
   * <p>
   * @return the minutes of the offset from this {@link Date}.
   */
 public long getMinutesOffset() {
    return libsbmlJNI.Date_getMinutesOffset(swigCPtr, this);
  }

  
  /**
   * Returns the {@link Date} as a string.
   * <p>
   * @return the date as a string.
   */
 public String getDateAsString() {
    return libsbmlJNI.Date_getDateAsString(swigCPtr, this);
  }

  
  /**
   * Sets the value of the year checking appropriateness.
   * <p>
   * @param year a long integer representing the year to set.  
   * <p>
   * @return integer value indicating success/failure of the
   * function.   The possible values
   * returned by this function are:
   * <li> LIBSBML_OPERATION_SUCCESS
   * <li> LIBSBML_INVALID_ATTRIBUTE_VALUE
   */
 public int setYear(long year) {
    return libsbmlJNI.Date_setYear(swigCPtr, this, year);
  }

  
  /**
   * Sets the value of the month checking appropriateness.
   * <p>
   * @param month a long integer representing the month to set  
   * <p>
   * @return integer value indicating success/failure of the
   * function.   The possible values
   * returned by this function are:
   * <li> LIBSBML_OPERATION_SUCCESS
   * <li> LIBSBML_INVALID_ATTRIBUTE_VALUE
   */
 public int setMonth(long month) {
    return libsbmlJNI.Date_setMonth(swigCPtr, this, month);
  }

  
  /**
   * Sets the value of the day checking appropriateness.
   * <p>
   * @param day a long integer representing the day to set.  
   * <p>
   * @return integer value indicating success/failure of the
   * function.   The possible values
   * returned by this function are:
   * <li> LIBSBML_OPERATION_SUCCESS
   * <li> LIBSBML_INVALID_ATTRIBUTE_VALUE
   */
 public int setDay(long day) {
    return libsbmlJNI.Date_setDay(swigCPtr, this, day);
  }

  
  /**
   * Sets the value of the hour checking appropriateness.
   * <p>
   * @param hour a long integer representing the hour to set.  
   * <p>
   * @return integer value indicating success/failure of the
   * function.   The possible values
   * returned by this function are:
   * <li> LIBSBML_OPERATION_SUCCESS
   * <li> LIBSBML_INVALID_ATTRIBUTE_VALUE
   */
 public int setHour(long hour) {
    return libsbmlJNI.Date_setHour(swigCPtr, this, hour);
  }

  
  /**
   * Sets the value of the minute checking appropriateness.
   * <p>
   * @param minute a long integer representing the minute to set.  
   * <p>
   * @return integer value indicating success/failure of the
   * function.   The possible values
   * returned by this function are:
   * <li> LIBSBML_OPERATION_SUCCESS
   * <li> LIBSBML_INVALID_ATTRIBUTE_VALUE
   */
 public int setMinute(long minute) {
    return libsbmlJNI.Date_setMinute(swigCPtr, this, minute);
  }

  
  /**
   * Sets the value of the second checking appropriateness.
   * <p>
   * @param second a long integer representing the second to set.  
   * <p>
   * @return integer value indicating success/failure of the
   * function.   The possible values
   * returned by this function are:
   * <li> LIBSBML_OPERATION_SUCCESS
   * <li> LIBSBML_INVALID_ATTRIBUTE_VALUE
   */
 public int setSecond(long second) {
    return libsbmlJNI.Date_setSecond(swigCPtr, this, second);
  }

  
  /**
   * Sets the value of the offset sign checking appropriateness.
   * <p>
   * @param sign a long integer representing 
   * the sign of the offset to set.  
   * <p>
   * @return integer value indicating success/failure of the
   * function.   The possible values
   * returned by this function are:
   * <li> LIBSBML_OPERATION_SUCCESS
   * <li> LIBSBML_INVALID_ATTRIBUTE_VALUE
   */
 public int setSignOffset(long sign) {
    return libsbmlJNI.Date_setSignOffset(swigCPtr, this, sign);
  }

  
  /**
   * Sets the value of the offset hour checking appropriateness.
   * <p>
   * @param hoursOffset a long integer representing the hours of the 
   * offset to set.  
   * <p>
   * @return integer value indicating success/failure of the
   * function.   The possible values
   * returned by this function are:
   * <li> LIBSBML_OPERATION_SUCCESS
   * <li> LIBSBML_INVALID_ATTRIBUTE_VALUE
   */
 public int setHoursOffset(long hoursOffset) {
    return libsbmlJNI.Date_setHoursOffset(swigCPtr, this, hoursOffset);
  }

  
  /**
   * Sets the value of the offset minutes checking appropriateness.
   * <p>
   * @param minutesOffset a long integer representing the minutes of the 
   * offset to set.  
   * <p>
   * @return integer value indicating success/failure of the
   * function.   The possible values
   * returned by this function are:
   * <li> LIBSBML_OPERATION_SUCCESS
   * <li> LIBSBML_INVALID_ATTRIBUTE_VALUE
   */
 public int setMinutesOffset(long minutesOffset) {
    return libsbmlJNI.Date_setMinutesOffset(swigCPtr, this, minutesOffset);
  }

  
  /**
   * Sets the value of the date string checking appropriateness.
   * <p>
   * @param date a string representing the date.
   * <p>
   * <p>
   * @return integer value indicating success/failure of the
   * function.   The possible values
   * returned by this function are:
   * <li> LIBSBML_OPERATION_SUCCESS
   * <li> LIBSBML_INVALID_ATTRIBUTE_VALUE
   * <p>
   * @note the string should be in W3CDTF format 
   * YYYY-MM-DDThh:mm:ssTZD (eg 1997-07-16T19:20:30+01:00)
   * where TZD is the time zone designator.
   */
 public int setDateAsString(String date) {
    return libsbmlJNI.Date_setDateAsString(swigCPtr, this, date);
  }

  
  /**
   * Sets the value of the date string checking appropriateness.
   * <p>
   * @param date a string representing the date.
   * <p>
   * <p>
   * @return integer value indicating success/failure of the
   * function.   The possible values
   * returned by this function are:
   * <li> LIBSBML_OPERATION_SUCCESS
   * <li> LIBSBML_INVALID_ATTRIBUTE_VALUE
   * <p>
   * @note the string should be in W3CDTF format 
   * YYYY-MM-DDThh:mm:ssTZD (eg 1997-07-16T19:20:30+01:00)
   * where TZD is the time zone designator.
   */
 public boolean representsValidDate() {
    return libsbmlJNI.Date_representsValidDate(swigCPtr, this);
  }

}
