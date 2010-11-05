/// 
///  @file    TestDelay.cs
///  @brief   SBML Delay unit tests
///  @author  Frank Bergmann (Csharp conversion)
///  @author  Akiya Jouraku (Csharp conversion)
///  @author  Sarah Keating 
/// 
///  $Id: TestDelay.cs 10124 2009-08-28 12:04:51Z sarahkeating $
///  $HeadURL: https://sbml.svn.sourceforge.net/svnroot/sbml/trunk/libsbml/src/bindings/csharp/test/sbml/TestDelay.cs $
/// 
///  This test file was converted from src/sbml/test/TestDelay.c
///  with the help of conversion sciprt (ctest_converter.pl).
/// 
/// <!---------------------------------------------------------------------------
///  This file is part of libSBML.  Please visit http://sbml.org for more
///  information about SBML, and the latest version of libSBML.
/// 
///  Copyright 2005-2009 California Institute of Technology.
///  Copyright 2002-2005 California Institute of Technology and
///                      Japan Science and Technology Corporation.
///  
///  This library is free software; you can redistribute it and/or modify it
///  under the terms of the GNU Lesser General Public License as published by
///  the Free Software Foundation.  A copy of the license agreement is provided
///  in the file named "LICENSE.txt" included with this software distribution
///  and also available online as http://sbml.org/software/libsbml/license.html
/// --------------------------------------------------------------------------->*/


namespace LibSBMLCSTest {

  using libsbml;

  using  System.IO;

  public class TestDelay {
    public class AssertionError : System.Exception 
    {
      public AssertionError() : base()
      {
        
      }
    }


    static void assertTrue(bool condition)
    {
      if (condition == true)
      {
        return;
      }
      throw new AssertionError();
    }

    static void assertEquals(object a, object b)
    {
      if ( (a == null) && (b == null) )
      {
        return;
      }
      else if ( (a == null) || (b == null) )
      {
        throw new AssertionError();
      }
      else if (a.Equals(b))
      {
        return;
      }
  
      throw new AssertionError();
    }

    static void assertNotEquals(object a, object b)
    {
      if ( (a == null) && (b == null) )
      {
        throw new AssertionError();
      }
      else if ( (a == null) || (b == null) )
      {
        return;
      }
      else if (a.Equals(b))
      {
        throw new AssertionError();
      }
    }

    static void assertEquals(bool a, bool b)
    {
      if ( a == b )
      {
        return;
      }
      throw new AssertionError();
    }

    static void assertNotEquals(bool a, bool b)
    {
      if ( a != b )
      {
        return;
      }
      throw new AssertionError();
    }

    static void assertEquals(int a, int b)
    {
      if ( a == b )
      {
        return;
      }
      throw new AssertionError();
    }

    static void assertNotEquals(int a, int b)
    {
      if ( a != b )
      {
        return;
      }
      throw new AssertionError();
    }

    private Delay D;

    public void setUp()
    {
      D = new  Delay(2,4);
      if (D == null);
      {
      }
    }

    public void tearDown()
    {
      D = null;
    }

    public void test_Delay_create()
    {
      assertTrue( D.getTypeCode() == libsbml.SBML_DELAY );
      assertTrue( D.getMetaId() == "" );
      assertTrue( D.getNotes() == null );
      assertTrue( D.getAnnotation() == null );
      assertTrue( D.getMath() == null );
    }

    public void test_Delay_createWithNS()
    {
      XMLNamespaces xmlns = new  XMLNamespaces();
      xmlns.add( "http://www.sbml.org", "testsbml");
      SBMLNamespaces sbmlns = new  SBMLNamespaces(2,1);
      sbmlns.addNamespaces(xmlns);
      Delay object1 = new  Delay(sbmlns);
      assertTrue( object1.getTypeCode() == libsbml.SBML_DELAY );
      assertTrue( object1.getMetaId() == "" );
      assertTrue( object1.getNotes() == null );
      assertTrue( object1.getAnnotation() == null );
      assertTrue( object1.getLevel() == 2 );
      assertTrue( object1.getVersion() == 1 );
      assertTrue( object1.getNamespaces() != null );
      assertTrue( object1.getNamespaces().getLength() == 2 );
      object1 = null;
    }

    public void test_Delay_free_NULL()
    {
    }

    public void test_Delay_setMath()
    {
      ASTNode math = libsbml.parseFormula("lambda(x, x^3)");
      ASTNode math1;
      string formula;
      D.setMath(math);
      math1 = D.getMath();
      assertTrue( math1 != null );
      formula = libsbml.formulaToString(math1);
      assertTrue( formula != null );
      assertTrue((  "lambda(x, x^3)" == formula ));
      assertTrue( D.getMath() != math );
      assertEquals( true, D.isSetMath() );
      D.setMath(D.getMath());
      math1 = D.getMath();
      assertTrue( math1 != null );
      formula = libsbml.formulaToString(math1);
      assertTrue( formula != null );
      assertTrue((  "lambda(x, x^3)" == formula ));
      D.setMath(null);
      assertEquals( false, D.isSetMath() );
      if (D.getMath() != null);
      {
      }
    }

    public void test_Delay_setMath1()
    {
      ASTNode math = libsbml.parseFormula("2 * k");
      long i = D.setMath(math);
      assertTrue( i == libsbml.LIBSBML_OPERATION_SUCCESS );
      assertTrue( D.getMath() != math );
      assertEquals( true, D.isSetMath() );
      i = D.setMath(null);
      assertTrue( i == libsbml.LIBSBML_OPERATION_SUCCESS );
      assertTrue( D.getMath() == null );
      assertEquals( false, D.isSetMath() );
      math = null;
    }

    public void test_Delay_setMath2()
    {
      ASTNode math = new  ASTNode(libsbml.AST_TIMES);
      long i = D.setMath(math);
      assertTrue( i == libsbml.LIBSBML_INVALID_OBJECT );
      assertEquals( false, D.isSetMath() );
      math = null;
    }

  }
}