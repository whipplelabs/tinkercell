/*
 *
 * @file    TestReaction_newSetters.java
 * @brief   Reaction unit tests for new set function API
 *
 * @author  Akiya Jouraku (Java conversion)
 * @author  Sarah Keating 
 *
 * $Id$
 * $HeadURL$
 *
 * This test file was converted from src/sbml/test/TestReaction_newSetters.c
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


package org.sbml.libsbml.test.sbml;

import org.sbml.libsbml.*;

import java.io.File;
import java.lang.AssertionError;

public class TestReaction_newSetters {

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
    else if ( (a == null) || (b == null) )
    {
      throw new AssertionError();
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
    else if ( (a == null) || (b == null) )
    {
      return;
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
  private Reaction R;

  protected void setUp() throws Exception
  {
    R = new  Reaction(1,2);
    if (R == null);
    {
    }
  }

  protected void tearDown() throws Exception
  {
    R = null;
  }

  public void test_Reaction_addModifier1()
  {
    Reaction m = new  Reaction(2,2);
    ModifierSpeciesReference p = new  ModifierSpeciesReference(2,2);
    ModifierSpeciesReference p1 = new  ModifierSpeciesReference(2,2);
    p1.setSpecies( "k");
    p1.setId( "k1");
    long i = m.addModifier(p);
    assertTrue( i == libsbml.LIBSBML_INVALID_OBJECT );
    p.setSpecies( "k");
    p.setId( "k1");
    i = m.addModifier(p);
    assertTrue( i == libsbml.LIBSBML_OPERATION_SUCCESS );
    assertTrue( m.getNumModifiers() == 1 );
    i = m.addModifier(p1);
    assertTrue( i == libsbml.LIBSBML_DUPLICATE_OBJECT_ID );
    assertTrue( m.getNumModifiers() == 1 );
    p = null;
    p1 = null;
    m = null;
  }

  public void test_Reaction_addModifier2()
  {
    Reaction m = new  Reaction(2,2);
    ModifierSpeciesReference p = new  ModifierSpeciesReference(2,1);
    p.setSpecies( "k");
    long i = m.addModifier(p);
    assertTrue( i == libsbml.LIBSBML_VERSION_MISMATCH );
    assertTrue( m.getNumModifiers() == 0 );
    p = null;
    m = null;
  }

  public void test_Reaction_addModifier3()
  {
    Reaction m = new  Reaction(2,2);
    ModifierSpeciesReference p = null;
    long i = m.addModifier(p);
    assertTrue( i == libsbml.LIBSBML_OPERATION_FAILED );
    assertTrue( m.getNumModifiers() == 0 );
    m = null;
  }

  public void test_Reaction_addProduct1()
  {
    Reaction m = new  Reaction(2,2);
    SpeciesReference p = new  SpeciesReference(2,2);
    SpeciesReference p1 = new  SpeciesReference(2,2);
    p1.setSpecies( "k");
    p1.setId( "k1");
    long i = m.addProduct(p);
    assertTrue( i == libsbml.LIBSBML_INVALID_OBJECT );
    p.setSpecies( "k");
    p.setId( "k1");
    i = m.addProduct(p);
    assertTrue( i == libsbml.LIBSBML_OPERATION_SUCCESS );
    assertTrue( m.getNumProducts() == 1 );
    i = m.addProduct(p1);
    assertTrue( i == libsbml.LIBSBML_DUPLICATE_OBJECT_ID );
    assertTrue( m.getNumProducts() == 1 );
    p = null;
    p1 = null;
    m = null;
  }

  public void test_Reaction_addProduct2()
  {
    Reaction m = new  Reaction(2,2);
    SpeciesReference p = new  SpeciesReference(2,1);
    p.setSpecies( "k");
    long i = m.addProduct(p);
    assertTrue( i == libsbml.LIBSBML_VERSION_MISMATCH );
    assertTrue( m.getNumProducts() == 0 );
    p = null;
    m = null;
  }

  public void test_Reaction_addProduct3()
  {
    Reaction m = new  Reaction(2,2);
    SpeciesReference p = new  SpeciesReference(1,2);
    p.setSpecies( "k");
    long i = m.addProduct(p);
    assertTrue( i == libsbml.LIBSBML_LEVEL_MISMATCH );
    assertTrue( m.getNumProducts() == 0 );
    p = null;
    m = null;
  }

  public void test_Reaction_addProduct4()
  {
    Reaction m = new  Reaction(2,2);
    SpeciesReference p = null;
    long i = m.addProduct(p);
    assertTrue( i == libsbml.LIBSBML_OPERATION_FAILED );
    assertTrue( m.getNumProducts() == 0 );
    m = null;
  }

  public void test_Reaction_addReactant1()
  {
    Reaction m = new  Reaction(2,2);
    SpeciesReference p = new  SpeciesReference(2,2);
    SpeciesReference p1 = new  SpeciesReference(2,2);
    p1.setSpecies( "k");
    p1.setId( "k1");
    long i = m.addReactant(p);
    assertTrue( i == libsbml.LIBSBML_INVALID_OBJECT );
    p.setSpecies( "k");
    p.setId( "k1");
    i = m.addReactant(p);
    assertTrue( i == libsbml.LIBSBML_OPERATION_SUCCESS );
    assertTrue( m.getNumReactants() == 1 );
    i = m.addReactant(p1);
    assertTrue( i == libsbml.LIBSBML_DUPLICATE_OBJECT_ID );
    assertTrue( m.getNumReactants() == 1 );
    p1 = null;
    p = null;
    m = null;
  }

  public void test_Reaction_addReactant2()
  {
    Reaction m = new  Reaction(2,2);
    SpeciesReference p = new  SpeciesReference(2,1);
    p.setSpecies( "k");
    long i = m.addReactant(p);
    assertTrue( i == libsbml.LIBSBML_VERSION_MISMATCH );
    assertTrue( m.getNumReactants() == 0 );
    p = null;
    m = null;
  }

  public void test_Reaction_addReactant3()
  {
    Reaction m = new  Reaction(2,2);
    SpeciesReference p = new  SpeciesReference(1,2);
    p.setSpecies( "k");
    long i = m.addReactant(p);
    assertTrue( i == libsbml.LIBSBML_LEVEL_MISMATCH );
    assertTrue( m.getNumReactants() == 0 );
    p = null;
    m = null;
  }

  public void test_Reaction_addReactant4()
  {
    Reaction m = new  Reaction(2,2);
    SpeciesReference p = null;
    long i = m.addReactant(p);
    assertTrue( i == libsbml.LIBSBML_OPERATION_FAILED );
    assertTrue( m.getNumReactants() == 0 );
    m = null;
  }

  public void test_Reaction_createKineticLaw()
  {
    Reaction r = new  Reaction(2,2);
    KineticLaw kl = r.createKineticLaw();
    assertTrue( r.isSetKineticLaw() == true );
    assertTrue( (kl).getLevel() == 2 );
    assertTrue( (kl).getVersion() == 2 );
    r = null;
  }

  public void test_Reaction_createModifier()
  {
    Reaction m = new  Reaction(2,2);
    ModifierSpeciesReference p = m.createModifier();
    assertTrue( m.getNumModifiers() == 1 );
    assertTrue( (p).getLevel() == 2 );
    assertTrue( (p).getVersion() == 2 );
    m = null;
  }

  public void test_Reaction_createProduct()
  {
    Reaction m = new  Reaction(2,2);
    SpeciesReference p = m.createProduct();
    assertTrue( m.getNumProducts() == 1 );
    assertTrue( (p).getLevel() == 2 );
    assertTrue( (p).getVersion() == 2 );
    m = null;
  }

  public void test_Reaction_createReactant()
  {
    Reaction m = new  Reaction(2,2);
    SpeciesReference p = m.createReactant();
    assertTrue( m.getNumReactants() == 1 );
    assertTrue( (p).getLevel() == 2 );
    assertTrue( (p).getVersion() == 2 );
    m = null;
  }

  public void test_Reaction_setFast1()
  {
    long i = R.setFast(true);
    assertTrue( i == libsbml.LIBSBML_OPERATION_SUCCESS );
    assertTrue( R.getFast() == true );
    assertEquals( true, R.isSetFast() );
    i = R.setFast(false);
    assertTrue( i == libsbml.LIBSBML_OPERATION_SUCCESS );
    assertTrue( R.getFast() == false );
    assertEquals( true, R.isSetFast() );
    i = R.unsetFast();
    assertTrue( i == libsbml.LIBSBML_OPERATION_SUCCESS );
    assertTrue( R.getFast() == false );
    assertEquals( false, R.isSetFast() );
  }

  public void test_Reaction_setFast2()
  {
    Reaction R1 = new  Reaction(2,4);
    long i = R1.unsetFast();
    assertTrue( i == libsbml.LIBSBML_OPERATION_SUCCESS );
    assertTrue( R1.getFast() == false );
    assertEquals( false, R1.isSetFast() );
  }

  public void test_Reaction_setId1()
  {
    long i = R.setId( "1cell");
    assertTrue( i == libsbml.LIBSBML_INVALID_ATTRIBUTE_VALUE );
    assertEquals( false, R.isSetId() );
  }

  public void test_Reaction_setId2()
  {
    long i = R.setId( "cell");
    assertTrue( i == libsbml.LIBSBML_OPERATION_SUCCESS );
    assertEquals( true, R.isSetId() );
    assertTrue(R.getId().equals( "cell" ));
    i = R.setId("");
    assertTrue( i == libsbml.LIBSBML_OPERATION_SUCCESS );
    assertEquals( false, R.isSetId() );
  }

  public void test_Reaction_setKineticLaw1()
  {
    KineticLaw kl = new  KineticLaw(2,1);
    long i = R.setKineticLaw(kl);
    assertTrue( i == libsbml.LIBSBML_LEVEL_MISMATCH );
    assertEquals( false, R.isSetKineticLaw() );
    kl = null;
  }

  public void test_Reaction_setKineticLaw2()
  {
    KineticLaw kl = new  KineticLaw(1,1);
    long i = R.setKineticLaw(kl);
    assertTrue( i == libsbml.LIBSBML_VERSION_MISMATCH );
    assertEquals( false, R.isSetKineticLaw() );
    kl = null;
  }

  public void test_Reaction_setKineticLaw3()
  {
    KineticLaw kl = new  KineticLaw(1,2);
    long i = R.setKineticLaw(kl);
    assertTrue( i == libsbml.LIBSBML_OPERATION_SUCCESS );
    assertEquals( true, R.isSetKineticLaw() );
    kl = null;
  }

  public void test_Reaction_setKineticLaw4()
  {
    long i = R.setKineticLaw(null);
    assertTrue( i == libsbml.LIBSBML_OPERATION_SUCCESS );
    assertEquals( false, R.isSetKineticLaw() );
    i = R.unsetKineticLaw();
    assertTrue( i == libsbml.LIBSBML_OPERATION_SUCCESS );
    assertEquals( false, R.isSetKineticLaw() );
  }

  public void test_Reaction_setName1()
  {
    long i = R.setName( "cell");
    assertTrue( i == libsbml.LIBSBML_OPERATION_SUCCESS );
    assertEquals( true, R.isSetName() );
    i = R.unsetName();
    assertTrue( i == libsbml.LIBSBML_OPERATION_SUCCESS );
    assertEquals( false, R.isSetName() );
  }

  public void test_Reaction_setName2()
  {
    Reaction p = new  Reaction(2,2);
    long i = p.setName( "1cell");
    assertTrue( i == libsbml.LIBSBML_OPERATION_SUCCESS );
    assertEquals( true, p.isSetName() );
    i = p.unsetName();
    assertTrue( i == libsbml.LIBSBML_OPERATION_SUCCESS );
    assertEquals( false, p.isSetName() );
    p = null;
  }

  public void test_Reaction_setName3()
  {
    Reaction p = new  Reaction(2,2);
    long i = p.setName("");
    assertTrue( i == libsbml.LIBSBML_OPERATION_SUCCESS );
    assertEquals( false, p.isSetName() );
    p = null;
  }

  public void test_Reaction_setReversible1()
  {
    long i = R.setReversible(true);
    assertTrue( i == libsbml.LIBSBML_OPERATION_SUCCESS );
    assertTrue( R.getReversible() == true );
    i = R.setReversible(false);
    assertTrue( i == libsbml.LIBSBML_OPERATION_SUCCESS );
    assertTrue( R.getReversible() == false );
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
