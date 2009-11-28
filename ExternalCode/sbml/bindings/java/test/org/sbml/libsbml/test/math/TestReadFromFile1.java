/*
 *
 * @file    TestReadFromFile1.java
 * @brief   Tests for reading MathML from files into ASTNodes.
 *
 * @author  Akiya Jouraku (Java conversion)
 * @author  Sarah Keating 
 *
 * $Id: TestReadFromFile1.java 10124 2009-08-28 12:04:51Z sarahkeating $
 * $HeadURL: https://sbml.svn.sourceforge.net/svnroot/sbml/trunk/libsbml/src/bindings/java/test/org/sbml/libsbml/test/math/TestReadFromFile1.java $
 *
 * This test file was converted from src/sbml/test/TestReadFromFile1.cpp
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


package org.sbml.libsbml.test.math;

import org.sbml.libsbml.*;

import java.io.File;
import java.lang.AssertionError;

public class TestReadFromFile1 {

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

  public void test_read_MathML_1()
  {
    SBMLReader reader = new SBMLReader();
    SBMLDocument d;
    Model m;
    FunctionDefinition fd;
    InitialAssignment ia;
    Rule r;
    KineticLaw kl;
    String filename = new String( "../../math/test/test-data/" );
    filename += "mathML_1.xml";
    d = reader.readSBML(filename);
    if (d == null);
    {
    }
    m = d.getModel();
    assertTrue( m != null );
    assertTrue( m.getNumFunctionDefinitions() == 2 );
    assertTrue( m.getNumInitialAssignments() == 1 );
    assertTrue( m.getNumRules() == 2 );
    assertTrue( m.getNumReactions() == 1 );
    fd = m.getFunctionDefinition(0);
    ASTNode fd_math = fd.getMath();
    assertTrue( fd_math.getType() == libsbml.AST_LAMBDA );
    assertTrue( fd_math.getNumChildren() == 2 );
    assertTrue(libsbml.formulaToString(fd_math).equals( "lambda(x, )"));
    assertTrue( fd_math.getParentSBMLObject().equals(fd) );
    ASTNode child = fd_math.getRightChild();
    assertTrue( child.getType() == libsbml.AST_UNKNOWN );
    assertTrue( child.getNumChildren() == 0 );
    assertTrue(libsbml.formulaToString(child).equals( ""));
    fd = m.getFunctionDefinition(1);
    ASTNode fd1_math = fd.getMath();
    assertTrue( fd1_math.getType() == libsbml.AST_LAMBDA );
    assertTrue( fd1_math.getNumChildren() == 2 );
    assertTrue(libsbml.formulaToString(fd1_math).equals( "lambda(x, true)"));
    assertTrue( fd1_math.getParentSBMLObject().equals(fd) );
    ASTNode child1 = fd1_math.getRightChild();
    assertTrue( child1.getType() == libsbml.AST_CONSTANT_TRUE );
    assertTrue( child1.getNumChildren() == 0 );
    assertTrue(libsbml.formulaToString(child1).equals( "true"));
    ia = m.getInitialAssignment(0);
    ASTNode ia_math = ia.getMath();
    assertTrue( ia_math.getType() == libsbml.AST_UNKNOWN );
    assertTrue( ia_math.getNumChildren() == 0 );
    assertTrue(libsbml.formulaToString(ia_math).equals( ""));
    assertTrue( ia_math.getParentSBMLObject().equals(ia) );
    r = m.getRule(0);
    ASTNode r_math = r.getMath();
    assertTrue( r_math.getType() == libsbml.AST_CONSTANT_TRUE );
    assertTrue( r_math.getNumChildren() == 0 );
    assertTrue(libsbml.formulaToString(r_math).equals( "true"));
    assertTrue( r_math.getParentSBMLObject().equals(r) );
    r = m.getRule(1);
    ASTNode r1_math = r.getMath();
    assertTrue( r1_math.getType() == libsbml.AST_REAL );
    assertTrue( r1_math.getNumChildren() == 0 );
    assertTrue(libsbml.formulaToString(r1_math).equals( "INF"));
    assertTrue( r1_math.getParentSBMLObject().equals(r) );
    kl = m.getReaction(0).getKineticLaw();
    ASTNode kl_math = kl.getMath();
    assertTrue( kl_math.getType() == libsbml.AST_REAL );
    assertTrue( kl_math.getNumChildren() == 0 );
    assertTrue(libsbml.formulaToString(kl_math).equals( "4.5"));
    assertTrue( kl_math.getParentSBMLObject().equals(kl) );
    d = null;
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
