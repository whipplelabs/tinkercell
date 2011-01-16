/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 1.3.40
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package org.sbml.libsbml;

/** 
 * Methods for writing SBML to files and text strings.
 * <p>
 * <em style='color: #555'>
This class of objects is defined by libSBML only and has no direct
equivalent in terms of SBML components.  This class is not prescribed by
the SBML specifications, although it is used to implement features
defined in SBML.
</em>

 * <p>
 * The {@link SBMLWriter} class is the converse of {@link SBMLReader}, and provides the
 * main interface for serializing SBML models into XML and writing the
 * result to files and text strings.  The methods for writing SBML all take
 * an {@link SBMLDocument} object and a destination.  They return a boolean value
 * to indicate success or failure.
 */

public class SBMLWriter {
   private long swigCPtr;
   protected boolean swigCMemOwn;

   protected SBMLWriter(long cPtr, boolean cMemoryOwn)
   {
     swigCMemOwn = cMemoryOwn;
     swigCPtr    = cPtr;
   }

   protected static long getCPtr(SBMLWriter obj)
   {
     return (obj == null) ? 0 : obj.swigCPtr;
   }

   protected static long getCPtrAndDisown (SBMLWriter obj)
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
        libsbmlJNI.delete_SBMLWriter(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  /**
   * Equality comparison method for SBMLWriter.
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
    return swigCPtr == getCPtr((SBMLWriter)(sb));
  }

  /**
   * Returns a hashcode for this SBMLWriter object.
   *
   * @return a hash code usable by Java methods that need them.
   */
  public int hashCode()
  {
    return (int)(swigCPtr^(swigCPtr>>>32));
  }

  
  /**
   * Creates a new {@link SBMLWriter}.
   */
 public SBMLWriter() {
    this(libsbmlJNI.new_SBMLWriter(), true);
  }

  
  /**
   * Sets the name of this program, i.e., the program that is about to
   * write out the {@link SBMLDocument}.
   * <p>
   * If the program name and version are set (setProgramVersion()), the
   * following XML comment, intended for human consumption, will be written
   * at the beginning of the document:
   * <div class='fragment'><pre>
   &lt;!-- Created by &lt;program name&gt; version &lt;program version&gt;
   on yyyy-MM-dd HH:mm with libsbml version &lt;libsbml version&gt;. --&gt;
</pre></div>
   * <p>
   * @param name the name of this program (where 'this program' refers to
   * program in which libSBML is embedded, not libSBML itself!)
   * <p>
   * @return integer value indicating success/failure of the
   * function.   The possible values
   * returned by this function are:
   * <li> {@link  libsbmlConstants#LIBSBML_OPERATION_SUCCESS LIBSBML_OPERATION_SUCCESS }
   * <p>
   * @see #setProgramVersion(String version)
   */
 public int setProgramName(String name) {
    return libsbmlJNI.SBMLWriter_setProgramName(swigCPtr, this, name);
  }

  
  /**
   * Sets the version of this program, i.e., the program that is about to
   * write out the {@link SBMLDocument}.
   * <p>
   * If the program version and name are set (setProgramName()), the
   * following XML comment, intended for human consumption, will be written
   * at the beginning of the document:
   * <div class='fragment'><pre>
   &lt;!-- Created by &lt;program name&gt; version &lt;program version&gt;
   on yyyy-MM-dd HH:mm with libsbml version &lt;libsbml version&gt;. --&gt;
</pre></div>
   * <p>
   * @param version the version of this program (where 'this program'
   * refers to program in which libSBML is embedded, not libSBML itself!)
   * <p>
   * @return integer value indicating success/failure of the
   * function.   The possible values
   * returned by this function are:
   * <li> {@link  libsbmlConstants#LIBSBML_OPERATION_SUCCESS LIBSBML_OPERATION_SUCCESS }
   * <p>
   * @see #setProgramName(String name)
   */
 public int setProgramVersion(String version) {
    return libsbmlJNI.SBMLWriter_setProgramVersion(swigCPtr, this, version);
  }

  
  /**
   * Writes the given SBML document to filename.
   * <p>
   * If the given filename ends with the suffix <code>'</code>.gz' (for example, 
   * <code>'myfile</code>.xml.gz'), libSBML assumes the caller wants the file to be
   * written compressed in <em>gzip</em>.  Similarly, if the given filename ends
   * with <code>'</code>.zip' or <code>'</code>.bz2', libSBML assumes the caller wants the file
   * to be compressed in <em>zip</em> or <em>bzip2</em> format (respectively).  Files
   * whose names lack these suffixes will be written uncompressed.
   * <em>Special considerations for the zip format</em>: If the given
   * filename ends with <code>'</code>.zip', the file placed in the zip archive will
   * have the suffix <code>'</code>.xml' or <code>'</code>.sbml'.  For example, the file in
   * the zip archive will be named <code>'test</code>.xml' if the given filename is
   * <code>'test</code>.xml.zip' or <code>'test</code>.zip'.  Similarly, the filename in the
   * archive will be <code>'test</code>.sbml' if the given filename is 
   * <code>'test</code>.sbml.zip'.
   * <p>
   * @note To write a gzip/zip file, libSBML needs to be configured and
   * linked with the <a href='http://www.zlib.net/'>zlib</a> library at
   * compile time.  It also needs to be linked with the <a
   * href=''>bzip2</a> library to write files in <em>bzip2</em> format.  (Both
   * of these are the default configurations for libSBML.)  Errors about
   * unreadable files will be logged and this method will return <code>false</code>
   * if a compressed filename is given and libSBML was <em>not</em> linked with
   * the corresponding required library.
   * <p>
   * @note SBMLReader.hasZlib() and SBMLReader.hasBzip2() can be used to
   * check whether libSBML has been linked with each library.
   * <p>
   * @param d the SBML document to be written
   * <p>
   * @param filename the name or full pathname of the file where the SBML
   * is to be written. 
   * <p>
   * @return <code>true</code> on success and <code>false</code> if the filename could not be
   * opened for writing.
   */
 public boolean writeSBML(SBMLDocument d, String filename) {
    return libsbmlJNI.SBMLWriter_writeSBML__SWIG_0(swigCPtr, this, SBMLDocument.getCPtr(d), d, libsbml.getAbsolutePath(filename));
  }

  
  /**
   * Writes the given SBML document to the output stream.
   * <p>
   * @param d the SBML document to be written
   * <p>
   * @param stream the stream object where the SBML is to be written.
   * <p>
   * @return <code>true</code> on success and <code>false</code> if one of the underlying
   * parser components fail (rare).
   */
 public boolean writeSBML(SBMLDocument d, OStream stream) {
    return libsbmlJNI.SBMLWriter_writeSBML__SWIG_1(swigCPtr, this, SBMLDocument.getCPtr(d), d, SWIGTYPE_p_std__ostream.getCPtr(stream.get_ostream()), stream);
  }

  
  /**
   * Writes the given SBML document to an in-memory string and returns a
   * pointer to it.
   * <p>
   * The string is owned by the caller and should be freed (with <code>free</code>())
   * when no longer needed.
   * <p>
   * @param d the SBML document to be written
   * <p>
   * @return the string on success and <code>0</code> if one of the underlying parser
   * components fail.
   <p>
 * @deprecated libSBML internal
 */
 public String writeToString(SBMLDocument d) {
    return libsbmlJNI.SBMLWriter_writeToString(swigCPtr, this, SBMLDocument.getCPtr(d), d);
  }

  
  /**
   * Writes the given SBML document to filename.
   * <p>
   * If the given filename ends with the suffix <code>'</code>.gz' (for example, 
   * <code>'myfile</code>.xml.gz'), libSBML assumes the caller wants the file to be
   * written compressed in <em>gzip</em>.  Similarly, if the given filename ends
   * with <code>'</code>.zip' or <code>'</code>.bz2', libSBML assumes the caller wants the file
   * to be compressed in <em>zip</em> or <em>bzip2</em> format (respectively).  Files
   * whose names lack these suffixes will be written uncompressed.
   * <em>Special considerations for the zip format</em>: If the given
   * filename ends with <code>'</code>.zip', the file placed in the zip archive will
   * have the suffix <code>'</code>.xml' or <code>'</code>.sbml'.  For example, the file in
   * the zip archive will be named <code>'test</code>.xml' if the given filename is
   * <code>'test</code>.xml.zip' or <code>'test</code>.zip'.  Similarly, the filename in the
   * archive will be <code>'test</code>.sbml' if the given filename is 
   * <code>'test</code>.sbml.zip'.
   * <p>
   * @note To write a gzip/zip file, libSBML needs to be configured and
   * linked with the <a href='http://www.zlib.net/'>zlib</a> library at
   * compile time.  It also needs to be linked with the <a
   * href=''>bzip2</a> library to write files in <em>bzip2</em> format.  (Both
   * of these are the default configurations for libSBML.)  Errors about
   * unreadable files will be logged and this method will return <code>false</code>
   * if a compressed filename is given and libSBML was <em>not</em> linked with
   * the corresponding required library.
   * <p>
   * @note SBMLReader.hasZlib() and SBMLReader.hasBzip2() can be used to
   * check whether libSBML has been linked with each library.
   * <p>
   * @param d the SBML document to be written
   * <p>
   * @param filename the name or full pathname of the file where the SBML
   * is to be written. 
   * <p>
   * @return <code>true</code> on success and <code>false</code> if the filename could not be
   * opened for writing.
   */
 public boolean writeSBMLToFile(SBMLDocument d, String filename) {
    return libsbmlJNI.SBMLWriter_writeSBMLToFile(swigCPtr, this, SBMLDocument.getCPtr(d), d, libsbml.getAbsolutePath(filename));
  }

  
  /**
   * Writes the given SBML document to an in-memory string and returns a
   * pointer to it.
   * <p>
   * The string is owned by the caller and should be freed (with <code>free</code>())
   * when no longer needed.
   * <p>
   * @param d the SBML document to be written
   * <p>
   * @return the string on success and <code>0</code> if one of the underlying parser
   * components fail.
   */
 public String writeSBMLToString(SBMLDocument d) {
    return libsbmlJNI.SBMLWriter_writeSBMLToString(swigCPtr, this, SBMLDocument.getCPtr(d), d);
  }

  
  /**
   * Predicate returning <code>true</code> if
   * underlying libSBML is linked with zlib.
   * <p>
   * LibSBML supports reading and writing files compressed with either
   * bzip2 or zip/gzip compression.  The facility depends on libSBML having
   * been compiled with the necessary support libraries.  This method
   * allows a calling program to inquire whether that is the case for the
   * copy of libSBML it is running.
   * <p>
   * @return <code>true</code> if libSBML is linked with zlib, <code>false</code> otherwise.
   */
 public static boolean hasZlib() {
    return libsbmlJNI.SBMLWriter_hasZlib();
  }

  
  /**
   * Predicate returning <code>true</code> if
   * underlying libSBML is linked with bzip2.
   * <p>
   * LibSBML supports reading and writing files compressed with either
   * bzip2 or zip/gzip compression.  The facility depends on libSBML having
   * been compiled with the necessary support libraries.  This method
   * allows a calling program to inquire whether that is the case for the
   * copy of libSBML it is running.
   * <p>
   * @return <code>true</code> if libSBML is linked with bzip2, <code>false</code> otherwise.
   <p>
 * @deprecated libSBML internal
 */
 public static boolean hasBzip2() {
    return libsbmlJNI.SBMLWriter_hasBzip2();
  }

}