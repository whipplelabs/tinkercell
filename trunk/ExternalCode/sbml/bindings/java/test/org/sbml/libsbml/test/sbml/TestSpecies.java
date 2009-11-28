/*
 *
 * @file    TestSpecies.java
 * @brief   Species unit tests
 *
 * @author  Akiya Jouraku (Java conversion)
 * @author  Ben Bornstein 
 *
 * $Id: TestSpecies.java 10124 2009-08-28 12:04:51Z sarahkeating $
 * $HeadURL: https://sbml.svn.sourceforge.net/svnroot/sbml/trunk/libsbml/src/bindings/java/test/org/sbml/libsbml/test/sbml/TestSpecies.java $
 *
 * This test file was converted from src/sbml/test/TestSpecies.c
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

public class TestSpecies {

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
  private Species S;

  protected void setUp() throws Exception
  {
    S = new  Species(2,4);
    if (S == null);
    {
    }
  }

  protected void tearDown() throws Exception
  {
    S = null;
  }

  public void test_Species_create()
  {
    assertTrue( S.getTypeCode() == libsbml.SBML_SPECIES );
    assertTrue( S.getMetaId().equals("") == true );
    assertTrue( S.getNotes() == null );
    assertTrue( S.getAnnotation() == null );
    assertTrue( S.getId().equals("") == true );
    assertTrue( S.getName().equals("") == true );
    assertTrue( S.getCompartment().equals("") == true );
    assertTrue( S.getInitialAmount() == 0.0 );
    assertTrue( S.getInitialConcentration() == 0.0 );
    assertTrue( S.getSubstanceUnits().equals("") == true );
    assertTrue( S.getSpatialSizeUnits().equals("") == true );
    assertTrue( S.getHasOnlySubstanceUnits() == false );
    assertTrue( S.getBoundaryCondition() == false );
    assertTrue( S.getCharge() == 0 );
    assertTrue( S.getConstant() == false );
    assertEquals( false, S.isSetId() );
    assertEquals( false, S.isSetName() );
    assertEquals( false, S.isSetCompartment() );
    assertEquals( false, S.isSetInitialAmount() );
    assertEquals( false, S.isSetInitialConcentration() );
    assertEquals( false, S.isSetSubstanceUnits() );
    assertEquals( false, S.isSetSpatialSizeUnits() );
    assertEquals( false, S.isSetUnits() );
    assertEquals( false, S.isSetCharge() );
  }

  public void test_Species_createWithNS()
  {
    XMLNamespaces xmlns = new  XMLNamespaces();
    xmlns.add( "http://www.sbml.org", "testsbml");
    SBMLNamespaces sbmlns = new  SBMLNamespaces(2,1);
    sbmlns.addNamespaces(xmlns);
    Species object = new  Species(sbmlns);
    assertTrue( object.getTypeCode() == libsbml.SBML_SPECIES );
    assertTrue( object.getMetaId().equals("") == true );
    assertTrue( object.getNotes() == null );
    assertTrue( object.getAnnotation() == null );
    assertTrue( object.getLevel() == 2 );
    assertTrue( object.getVersion() == 1 );
    assertTrue( object.getNamespaces() != null );
    assertTrue( object.getNamespaces().getLength() == 2 );
    object = null;
  }

  public void test_Species_free_NULL()
  {
  }

  public void test_Species_setCompartment()
  {
    String compartment =  "cell";;
    S.setCompartment(compartment);
    assertTrue(S.getCompartment().equals(compartment));
    assertEquals( true, S.isSetCompartment() );
    if (S.getCompartment() == compartment);
    {
    }
    S.setCompartment(S.getCompartment());
    assertTrue(S.getCompartment().equals(compartment));
    S.setCompartment("");
    assertEquals( false, S.isSetCompartment() );
    if (S.getCompartment() != null);
    {
    }
  }

  public void test_Species_setId()
  {
    String id =  "Glucose";;
    S.setId(id);
    assertTrue(S.getId().equals(id));
    assertEquals( true, S.isSetId() );
    if (S.getId() == id);
    {
    }
    S.setId(S.getId());
    assertTrue(S.getId().equals(id));
    S.setId("");
    assertEquals( false, S.isSetId() );
    if (S.getId() != null);
    {
    }
  }

  public void test_Species_setInitialAmount()
  {
    assertEquals( false, S.isSetInitialAmount() );
    assertEquals( false, S.isSetInitialConcentration() );
    S.setInitialAmount(1.2);
    assertEquals( true, S.isSetInitialAmount() );
    assertEquals( false, S.isSetInitialConcentration() );
    assertTrue( S.getInitialAmount() == 1.2 );
  }

  public void test_Species_setInitialConcentration()
  {
    assertEquals( false, S.isSetInitialAmount() );
    assertEquals( false, S.isSetInitialConcentration() );
    S.setInitialConcentration(3.4);
    assertEquals( false, S.isSetInitialAmount() );
    assertEquals( true, S.isSetInitialConcentration() );
    assertTrue( S.getInitialConcentration() == 3.4 );
  }

  public void test_Species_setName()
  {
    String name =  "So_Sweet";;
    S.setName(name);
    assertTrue(S.getName().equals(name));
    assertEquals( true, S.isSetName() );
    if (S.getName() == name);
    {
    }
    S.setName(S.getName());
    assertTrue(S.getName().equals(name));
    S.setName("");
    assertEquals( false, S.isSetName() );
    if (S.getName() != null);
    {
    }
  }

  public void test_Species_setSpatialSizeUnits()
  {
    Species s = new  Species(2,1);
    String units =  "volume";;
    s.setSpatialSizeUnits(units);
    assertTrue(s.getSpatialSizeUnits().equals(units));
    assertEquals( true, s.isSetSpatialSizeUnits() );
    if (s.getSpatialSizeUnits() == units);
    {
    }
    s.setSpatialSizeUnits(s.getSpatialSizeUnits());
    assertTrue(s.getSpatialSizeUnits().equals(units));
    s.setSpatialSizeUnits("");
    assertEquals( false, s.isSetSpatialSizeUnits() );
    if (s.getSpatialSizeUnits() != null);
    {
    }
    s = null;
  }

  public void test_Species_setSubstanceUnits()
  {
    String units =  "item";;
    S.setSubstanceUnits(units);
    assertTrue(S.getSubstanceUnits().equals(units));
    assertEquals( true, S.isSetSubstanceUnits() );
    if (S.getSubstanceUnits() == units);
    {
    }
    S.setSubstanceUnits(S.getSubstanceUnits());
    assertTrue(S.getSubstanceUnits().equals(units));
    S.setSubstanceUnits("");
    assertEquals( false, S.isSetSubstanceUnits() );
    if (S.getSubstanceUnits() != null);
    {
    }
  }

  public void test_Species_setUnits()
  {
    String units =  "mole";;
    S.setUnits(units);
    assertTrue(S.getUnits().equals(units));
    assertEquals( true, S.isSetUnits() );
    if (S.getSubstanceUnits() == units);
    {
    }
    S.setUnits(S.getSubstanceUnits());
    assertTrue(S.getUnits().equals(units));
    S.setUnits("");
    assertEquals( false, S.isSetUnits() );
    if (S.getSubstanceUnits() != null);
    {
    }
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
