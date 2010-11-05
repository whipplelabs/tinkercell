/// 
///  @file    TestRule_newSetters.cs
///  @brief   Rule unit tests for new set function API
///  @author  Frank Bergmann (Csharp conversion)
///  @author  Akiya Jouraku (Csharp conversion)
///  @author  Sarah Keating
/// 
///  $Id$
///  $HeadURL$
/// 
///  This test file was converted from src/sbml/test/TestRule_newSetters.c
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

  public class TestRule_newSetters {
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

    private Rule R;

    public void setUp()
    {
      R = new  AssignmentRule(2,4);
      if (R == null);
      {
      }
    }

    public void tearDown()
    {
      R = null;
    }

    public void test_Rule_setFormula1()
    {
      string formula =  "k1*X0";
      long i = R.setFormula(formula);
      assertTrue( i == libsbml.LIBSBML_OPERATION_SUCCESS );
      assertTrue(( formula == R.getFormula() ));
      assertEquals( true, R.isSetFormula() );
    }

    public void test_Rule_setFormula2()
    {
      long i = R.setFormula("");
      assertTrue( i == libsbml.LIBSBML_OPERATION_SUCCESS );
      assertEquals( false, R.isSetFormula() );
    }

    public void test_Rule_setFormula3()
    {
      string formula =  "k1 X0";
      long i = R.setFormula(formula);
      assertTrue( i == libsbml.LIBSBML_INVALID_OBJECT );
      assertEquals( false, R.isSetFormula() );
    }

    public void test_Rule_setMath1()
    {
      ASTNode math = new  ASTNode(libsbml.AST_TIMES);
      ASTNode a = new  ASTNode();
      ASTNode b = new  ASTNode();
      a.setName( "a");
      b.setName( "b");
      math.addChild(a);
      math.addChild(b);
      string formula;
      ASTNode math1;
      long i = R.setMath(math);
      assertTrue( i == libsbml.LIBSBML_OPERATION_SUCCESS );
      assertEquals( true, R.isSetMath() );
      math1 = R.getMath();
      assertTrue( math1 != null );
      formula = libsbml.formulaToString(math1);
      assertTrue( formula != null );
      assertTrue((  "a * b" == formula ));
      math = null;
    }

    public void test_Rule_setMath2()
    {
      ASTNode math = new  ASTNode(libsbml.AST_TIMES);
      ASTNode a = new  ASTNode();
      a.setName( "a");
      math.addChild(a);
      long i = R.setMath(math);
      assertTrue( i == libsbml.LIBSBML_INVALID_OBJECT );
      assertEquals( false, R.isSetMath() );
      math = null;
    }

    public void test_Rule_setMath3()
    {
      long i = R.setMath(null);
      assertTrue( i == libsbml.LIBSBML_OPERATION_SUCCESS );
      assertEquals( false, R.isSetMath() );
    }

    public void test_Rule_setUnits1()
    {
      long i = R.setUnits( "second");
      assertTrue( i == libsbml.LIBSBML_UNEXPECTED_ATTRIBUTE );
      assertEquals( false, R.isSetUnits() );
    }

    public void test_Rule_setUnits2()
    {
      Rule R1 = new  AssignmentRule(1,2);
      R1.setL1TypeCode(libsbml.SBML_PARAMETER_RULE);
      long i = R1.setUnits( "second");
      assertTrue( i == libsbml.LIBSBML_OPERATION_SUCCESS );
      assertEquals( true, R1.isSetUnits() );
      i = R1.unsetUnits();
      assertTrue( i == libsbml.LIBSBML_OPERATION_SUCCESS );
      assertEquals( false, R1.isSetUnits() );
      R1 = null;
    }

    public void test_Rule_setUnits3()
    {
      Rule R1 = new  AssignmentRule(1,2);
      R1.setL1TypeCode(libsbml.SBML_PARAMETER_RULE);
      long i = R1.setUnits( "1second");
      assertTrue( i == libsbml.LIBSBML_INVALID_ATTRIBUTE_VALUE );
      assertEquals( false, R1.isSetUnits() );
      i = R1.unsetUnits();
      assertTrue( i == libsbml.LIBSBML_OPERATION_SUCCESS );
      assertEquals( false, R1.isSetUnits() );
      R1 = null;
    }

    public void test_Rule_setUnits4()
    {
      Rule R1 = new  AssignmentRule(1,2);
      R1.setL1TypeCode(libsbml.SBML_PARAMETER_RULE);
      long i = R1.setUnits( "second");
      assertTrue( i == libsbml.LIBSBML_OPERATION_SUCCESS );
      assertEquals( true, R1.isSetUnits() );
      i = R1.setUnits("");
      assertTrue( i == libsbml.LIBSBML_OPERATION_SUCCESS );
      assertEquals( false, R1.isSetUnits() );
      R1 = null;
    }

    public void test_Rule_setVariable1()
    {
      long i = R.setVariable( "1mole");
      assertTrue( i == libsbml.LIBSBML_INVALID_ATTRIBUTE_VALUE );
      assertEquals( false, R.isSetVariable() );
    }

    public void test_Rule_setVariable2()
    {
      long i = R.setVariable( "mole");
      assertTrue( i == libsbml.LIBSBML_OPERATION_SUCCESS );
      assertEquals( true, R.isSetVariable() );
      i = R.setVariable( "");
      assertTrue( i == libsbml.LIBSBML_OPERATION_SUCCESS );
      assertEquals( false, R.isSetVariable() );
    }

    public void test_Rule_setVariable3()
    {
      Rule R1 = new  AlgebraicRule(1,2);
      long i = R1.setVariable( "r");
      assertTrue( i == libsbml.LIBSBML_UNEXPECTED_ATTRIBUTE );
      assertEquals( false, R1.isSetVariable() );
      R1 = null;
    }

  }
}