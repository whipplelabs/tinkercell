/*
 *
 * @file    TestXMLToken_newSetters.java
 * @brief   XMLToken_newSetters unit tests
 *
 * @author  Akiya Jouraku (Java conversion)
 * @author  Sarah Keating 
 *
 * $Id$
 * $HeadURL$
 *
 * This test file was converted from src/sbml/test/TestXMLToken_newSetters.c
 * with the help of conversion sciprt (ctest_converter.pl).
 *
 *<!---------------------------------------------------------------------------
 * This file is part of libSBML.  Please visit http://sbml.org for more
 * information about SBML, and the latest version of libSBML.
 *
 * Copyright 2005-2009 California Institute of Technology.
 * Copyright 2002-2005 California Institute of Technology and
 *                     Japan Science and Technology Corporation.
 * 
 * This library is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation.  A copy of the license agreement is provided
 * in the file named "LICENSE.txt" included with this software distribution
 * and also available online as http://sbml.org/software/libsbml/license.html
 *--------------------------------------------------------------------------->*/


package org.sbml.libsbml.test.xml;

import org.sbml.libsbml.*;

import java.io.File;
import java.lang.AssertionError;

public class TestXMLToken_newSetters {

  static void assertTrue(boolean condition) throws AssertionError
  {
    if (condition == true)
    {
      return;
    }
    throw new AssertionError();
  }

  static void assertEquals(Object a, Object b) throws AssertionError
  {
    if ( (a == null) && (b == null) )
    {
      return;
    }
    else if (a.equals(b))
    {
      return;
    }

    throw new AssertionError();
  }

  static void assertNotEquals(Object a, Object b) throws AssertionError
  {
    if ( (a == null) && (b == null) )
    {
      throw new AssertionError();
    }
    else if (a.equals(b))
    {
      throw new AssertionError();
    }
  }

  static void assertEquals(boolean a, boolean b) throws AssertionError
  {
    if ( a == b )
    {
      return;
    }
    throw new AssertionError();
  }

  static void assertNotEquals(boolean a, boolean b) throws AssertionError
  {
    if ( a != b )
    {
      return;
    }
    throw new AssertionError();
  }

  static void assertEquals(int a, int b) throws AssertionError
  {
    if ( a == b )
    {
      return;
    }
    throw new AssertionError();
  }

  static void assertNotEquals(int a, int b) throws AssertionError
  {
    if ( a != b )
    {
      return;
    }
    throw new AssertionError();
  }

  public void test_XMLToken_newSetters_addAttributes1()
  {
    XMLTriple triple = new  XMLTriple("test","","");
    XMLAttributes attr = new  XMLAttributes();
    XMLToken token = new  XMLToken(triple,attr);
    XMLTriple xt2 = new  XMLTriple("name3", "http://name3.org/", "p3");
    long i = token.addAttr( "name1", "val1");
    assertTrue( i == libsbml.LIBSBML_OPERATION_SUCCESS );
    assertTrue( token.getAttributesLength() == 1 );
    assertTrue( token.isAttributesEmpty() == false );
    assertTrue( !token.getAttrName(0).equals( "name1") == false );
    assertTrue( !token.getAttrValue(0).equals( "val1" ) == false );
    i = token.addAttr( "name2", "val2", "http://name1.org/", "p1");
    assertTrue( i == libsbml.LIBSBML_OPERATION_SUCCESS );
    assertTrue( token.getAttributesLength() == 2 );
    assertTrue( token.isAttributesEmpty() == false );
    assertTrue( !token.getAttrName(1).equals( "name2") == false );
    assertTrue( !token.getAttrValue(1).equals( "val2" ) == false );
    assertTrue( !token.getAttrURI(1).equals( "http://name1.org/") == false );
    assertTrue( !token.getAttrPrefix(1).equals( "p1"   ) == false );
    i = token.addAttr(xt2, "val2");
    assertTrue( i == libsbml.LIBSBML_OPERATION_SUCCESS );
    assertTrue( token.getAttributesLength() == 3 );
    assertTrue( token.isAttributesEmpty() == false );
    assertTrue( !token.getAttrName(2).equals( "name3") == false );
    assertTrue( !token.getAttrValue(2).equals( "val2" ) == false );
    assertTrue( !token.getAttrURI(2).equals( "http://name3.org/") == false );
    assertTrue( !token.getAttrPrefix(2).equals( "p3"   ) == false );
    xt2 = null;
    triple = null;
    attr = null;
    token = null;
  }

  public void test_XMLToken_newSetters_addAttributes2()
  {
    XMLTriple triple = new  XMLTriple("test","","");
    XMLToken token = new  XMLToken(triple);
    XMLTriple xt2 = new  XMLTriple("name3", "http://name3.org/", "p3");
    long i = token.addAttr( "name1", "val1");
    assertTrue( i == libsbml.LIBSBML_INVALID_XML_OPERATION );
    assertTrue( token.getAttributesLength() == 0 );
    assertTrue( token.isAttributesEmpty() == true );
    i = token.addAttr( "name2", "val2", "http://name1.org/", "p1");
    assertTrue( i == libsbml.LIBSBML_INVALID_XML_OPERATION );
    assertTrue( token.getAttributesLength() == 0 );
    assertTrue( token.isAttributesEmpty() == true );
    i = token.addAttr(xt2, "val2");
    assertTrue( i == libsbml.LIBSBML_INVALID_XML_OPERATION );
    assertTrue( token.getAttributesLength() == 0 );
    assertTrue( token.isAttributesEmpty() == true );
    xt2 = null;
    triple = null;
    token = null;
  }

  public void test_XMLToken_newSetters_addNamespaces1()
  {
    XMLTriple triple = new  XMLTriple("test","","");
    XMLAttributes attr = new  XMLAttributes();
    XMLToken token = new  XMLToken(triple,attr);
    assertTrue( token.getNamespacesLength() == 0 );
    assertTrue( token.isNamespacesEmpty() == true );
    long i = token.addNamespace( "http://test1.org/", "test1");
    assertTrue( i == libsbml.LIBSBML_OPERATION_SUCCESS );
    assertTrue( token.getNamespacesLength() == 1 );
    assertTrue( token.isNamespacesEmpty() == false );
    attr = null;
    triple = null;
    token = null;
  }

  public void test_XMLToken_newSetters_addNamespaces2()
  {
    XMLTriple triple = new  XMLTriple("test","","");
    XMLToken token = new  XMLToken(triple);
    assertTrue( token.getNamespacesLength() == 0 );
    assertTrue( token.isNamespacesEmpty() == true );
    long i = token.addNamespace( "http://test1.org/", "test1");
    assertTrue( i == libsbml.LIBSBML_INVALID_XML_OPERATION );
    assertTrue( token.getNamespacesLength() == 0 );
    assertTrue( token.isNamespacesEmpty() == true );
    triple = null;
    token = null;
  }

  public void test_XMLToken_newSetters_clearAttributes1()
  {
    XMLTriple triple = new  XMLTriple("test","","");
    XMLAttributes attr = new  XMLAttributes();
    XMLToken token = new  XMLToken(triple,attr);
    XMLAttributes nattr = new  XMLAttributes();
    XMLTriple xt1 = new  XMLTriple("name1", "http://name1.org/", "p1");
    nattr.add(xt1, "val1");
    long i = token.setAttributes(nattr);
    assertTrue( i == libsbml.LIBSBML_OPERATION_SUCCESS );
    assertTrue( token.isAttributesEmpty() == false );
    i = token.clearAttributes();
    assertTrue( i == libsbml.LIBSBML_OPERATION_SUCCESS );
    assertTrue( token.isAttributesEmpty() == true );
    nattr = null;
    attr = null;
    triple = null;
    token = null;
    xt1 = null;
  }

  public void test_XMLToken_newSetters_clearNamespaces1()
  {
    XMLTriple triple = new  XMLTriple("test","","");
    XMLAttributes attr = new  XMLAttributes();
    XMLToken token = new  XMLToken(triple,attr);
    XMLNamespaces ns = new  XMLNamespaces();
    assertTrue( token.getNamespacesLength() == 0 );
    assertTrue( token.isNamespacesEmpty() == true );
    ns.add( "http://test1.org/", "test1");
    long i = token.setNamespaces(ns);
    assertTrue( i == libsbml.LIBSBML_OPERATION_SUCCESS );
    assertTrue( token.getNamespacesLength() == 1 );
    assertTrue( token.isNamespacesEmpty() == false );
    i = token.clearNamespaces();
    assertTrue( i == libsbml.LIBSBML_OPERATION_SUCCESS );
    assertTrue( token.getNamespacesLength() == 0 );
    assertTrue( token.isNamespacesEmpty() == true );
    attr = null;
    triple = null;
    token = null;
    ns = null;
  }

  public void test_XMLToken_newSetters_removeAttributes1()
  {
    XMLTriple triple = new  XMLTriple("test","","");
    XMLAttributes attr = new  XMLAttributes();
    XMLToken token = new  XMLToken(triple,attr);
    XMLTriple xt2 = new  XMLTriple("name3", "http://name3.org/", "p3");
    XMLTriple xt1 = new  XMLTriple("name5", "http://name5.org/", "p5");
    long i = token.addAttr( "name1", "val1");
    i = token.addAttr( "name2", "val2", "http://name1.org/", "p1");
    i = token.addAttr(xt2, "val2");
    i = token.addAttr( "name4", "val4");
    assertTrue( token.getAttributes().getLength() == 4 );
    i = token.removeAttr(7);
    assertTrue( i == libsbml.LIBSBML_INDEX_EXCEEDS_SIZE );
    i = token.removeAttr( "name7");
    assertTrue( i == libsbml.LIBSBML_INDEX_EXCEEDS_SIZE );
    i = token.removeAttr( "name7", "namespaces7");
    assertTrue( i == libsbml.LIBSBML_INDEX_EXCEEDS_SIZE );
    i = token.removeAttr(xt1);
    assertTrue( i == libsbml.LIBSBML_INDEX_EXCEEDS_SIZE );
    assertTrue( token.getAttributes().getLength() == 4 );
    i = token.removeAttr(3);
    assertTrue( i == libsbml.LIBSBML_OPERATION_SUCCESS );
    assertTrue( token.getAttributes().getLength() == 3 );
    i = token.removeAttr( "name1");
    assertTrue( i == libsbml.LIBSBML_OPERATION_SUCCESS );
    assertTrue( token.getAttributes().getLength() == 2 );
    i = token.removeAttr( "name2", "http://name1.org/");
    assertTrue( i == libsbml.LIBSBML_OPERATION_SUCCESS );
    assertTrue( token.getAttributes().getLength() == 1 );
    i = token.removeAttr(xt2);
    assertTrue( i == libsbml.LIBSBML_OPERATION_SUCCESS );
    assertTrue( token.getAttributes().getLength() == 0 );
    xt1 = null;
    xt2 = null;
    triple = null;
    attr = null;
    token = null;
  }

  public void test_XMLToken_newSetters_removeNamespaces()
  {
    XMLTriple triple = new  XMLTriple("test","","");
    XMLAttributes attr = new  XMLAttributes();
    XMLToken token = new  XMLToken(triple,attr);
    token.addNamespace( "http://test1.org/", "test1");
    assertTrue( token.getNamespacesLength() == 1 );
    long i = token.removeNamespace(4);
    assertTrue( i == libsbml.LIBSBML_INDEX_EXCEEDS_SIZE );
    assertTrue( token.getNamespacesLength() == 1 );
    i = token.removeNamespace(0);
    assertTrue( i == libsbml.LIBSBML_OPERATION_SUCCESS );
    assertTrue( token.getNamespacesLength() == 0 );
    token = null;
    triple = null;
    attr = null;
  }

  public void test_XMLToken_newSetters_removeNamespaces1()
  {
    XMLTriple triple = new  XMLTriple("test","","");
    XMLAttributes attr = new  XMLAttributes();
    XMLToken token = new  XMLToken(triple,attr);
    token.addNamespace( "http://test1.org/", "test1");
    assertTrue( token.getNamespacesLength() == 1 );
    long i = token.removeNamespace( "test2");
    assertTrue( i == libsbml.LIBSBML_INDEX_EXCEEDS_SIZE );
    assertTrue( token.getNamespacesLength() == 1 );
    i = token.removeNamespace( "test1");
    assertTrue( i == libsbml.LIBSBML_OPERATION_SUCCESS );
    assertTrue( token.getNamespacesLength() == 0 );
    token = null;
    triple = null;
    attr = null;
  }

  public void test_XMLToken_newSetters_setAttributes1()
  {
    XMLTriple triple = new  XMLTriple("test","","");
    XMLAttributes attr = new  XMLAttributes();
    XMLToken token = new  XMLToken(triple,attr);
    XMLAttributes nattr = new  XMLAttributes();
    XMLTriple xt1 = new  XMLTriple("name1", "http://name1.org/", "p1");
    nattr.add(xt1, "val1");
    long i = token.setAttributes(nattr);
    assertTrue( i == libsbml.LIBSBML_OPERATION_SUCCESS );
    assertTrue( token.isAttributesEmpty() == false );
    nattr = null;
    attr = null;
    triple = null;
    token = null;
    xt1 = null;
  }

  public void test_XMLToken_newSetters_setAttributes2()
  {
    XMLTriple triple = new  XMLTriple("test","","");
    XMLToken token = new  XMLToken(triple);
    XMLAttributes nattr = new  XMLAttributes();
    XMLTriple xt1 = new  XMLTriple("name1", "http://name1.org/", "p1");
    nattr.add(xt1, "val1");
    long i = token.setAttributes(nattr);
    assertTrue( i == libsbml.LIBSBML_INVALID_XML_OPERATION );
    assertTrue( token.isAttributesEmpty() == true );
    nattr = null;
    triple = null;
    token = null;
    xt1 = null;
  }

  public void test_XMLToken_newSetters_setEOF()
  {
    XMLToken token = new  XMLToken();
    assertTrue( token.isEnd() == false );
    long i = token.setEOF();
    assertTrue( i == libsbml.LIBSBML_OPERATION_SUCCESS );
    assertTrue( token.isEnd() == false );
    assertTrue( token.isStart() == false );
    assertTrue( token.isText() == false );
    token = null;
  }

  public void test_XMLToken_newSetters_setEnd()
  {
    XMLToken token = new  XMLToken();
    assertTrue( token.isEnd() == false );
    long i = token.setEnd();
    assertTrue( i == libsbml.LIBSBML_OPERATION_SUCCESS );
    assertTrue( token.isEnd() == true );
    i = token.unsetEnd();
    assertTrue( i == libsbml.LIBSBML_OPERATION_SUCCESS );
    assertTrue( token.isEnd() == false );
    token = null;
  }

  public void test_XMLToken_newSetters_setNamespaces1()
  {
    XMLTriple triple = new  XMLTriple("test","","");
    XMLAttributes attr = new  XMLAttributes();
    XMLToken token = new  XMLToken(triple,attr);
    XMLNamespaces ns = new  XMLNamespaces();
    assertTrue( token.getNamespacesLength() == 0 );
    assertTrue( token.isNamespacesEmpty() == true );
    ns.add( "http://test1.org/", "test1");
    long i = token.setNamespaces(ns);
    assertTrue( i == libsbml.LIBSBML_OPERATION_SUCCESS );
    assertTrue( token.getNamespacesLength() == 1 );
    assertTrue( token.isNamespacesEmpty() == false );
    attr = null;
    triple = null;
    token = null;
    ns = null;
  }

  public void test_XMLToken_newSetters_setNamespaces2()
  {
    XMLTriple triple = new  XMLTriple("test","","");
    XMLToken token = new  XMLToken(triple);
    XMLNamespaces ns = new  XMLNamespaces();
    assertTrue( token.getNamespacesLength() == 0 );
    assertTrue( token.isNamespacesEmpty() == true );
    ns.add( "http://test1.org/", "test1");
    long i = token.setNamespaces(ns);
    assertTrue( i == libsbml.LIBSBML_INVALID_XML_OPERATION );
    assertTrue( token.getNamespacesLength() == 0 );
    assertTrue( token.isNamespacesEmpty() == true );
    triple = null;
    token = null;
    ns = null;
  }

  public void test_XMLToken_newSetters_setTriple1()
  {
    XMLTriple triple = new  XMLTriple("test","","");
    XMLToken token = new  XMLToken();
    long i = token.setTriple(triple);
    assertTrue( i == libsbml.LIBSBML_OPERATION_SUCCESS );
    assertTrue(token.getName().equals( "test"));
    triple = null;
    token = null;
  }

  public void test_XMLToken_newSetters_setTriple2()
  {
    XMLTriple triple = new  XMLTriple("test","","");
    XMLToken token = new  XMLToken("This is text");
    long i = token.setTriple(triple);
    assertTrue( i == libsbml.LIBSBML_INVALID_XML_OPERATION );
    triple = null;
    token = null;
  }

  /**
   * Loads the SWIG-generated libSBML Java module when this class is
   * loaded, or reports a sensible diagnostic message about why it failed.
   */
  static
  {
    String varname;
    String shlibname;

    if (System.getProperty("mrj.version") != null)
    {
      varname = "DYLD_LIBRARY_PATH";    // We're on a Mac.
      shlibname = "libsbmlj.jnilib and/or libsbml.dylib";
    }
    else
    {
      varname = "LD_LIBRARY_PATH";      // We're not on a Mac.
      shlibname = "libsbmlj.so and/or libsbml.so";
    }

    try
    {
      System.loadLibrary("sbmlj");
      // For extra safety, check that the jar file is in the classpath.
      Class.forName("org.sbml.libsbml.libsbml");
    }
    catch (SecurityException e)
    {
      e.printStackTrace();
      System.err.println("Could not load the libSBML library files due to a"+
                         " security exception.\n");
      System.exit(1);
    }
    catch (UnsatisfiedLinkError e)
    {
      e.printStackTrace();
      System.err.println("Error: could not link with the libSBML library files."+
                         " It is likely\nyour " + varname +
                         " environment variable does not include the directories\n"+
                         "containing the " + shlibname + " library files.\n");
      System.exit(1);
    }
    catch (ClassNotFoundException e)
    {
      e.printStackTrace();
      System.err.println("Error: unable to load the file libsbmlj.jar."+
                         " It is likely\nyour -classpath option and CLASSPATH" +
                         " environment variable\n"+
                         "do not include the path to libsbmlj.jar.\n");
      System.exit(1);
    }
  }
}
