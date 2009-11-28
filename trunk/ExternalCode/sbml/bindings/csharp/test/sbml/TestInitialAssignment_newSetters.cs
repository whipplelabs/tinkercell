/// 
///  @file    TestInitialAssignment_newSetters.cs
///  @brief   InitialAssignment unit tests for new set function API
///  @author  Frank Bergmann (Csharp conversion)
///  @author  Akiya Jouraku (Csharp conversion)
///  @author  Sarah Keating 
/// 
///  $Id$
///  $HeadURL$
/// 
///  This test file was converted from src/sbml/test/TestInitialAssignment_newSetters.c
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

  public class TestInitialAssignment_newSetters {
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

    private InitialAssignment E;

    public void setUp()
    {
      E = new  InitialAssignment(2,4);
      if (E == null);
      {
      }
    }

    public void tearDown()
    {
      E = null;
    }

    public void test_InitialAssignment_setMath1()
    {
      ASTNode math = libsbml.parseFormula("2 * k");
      long i = E.setMath(math);
      assertTrue( i == libsbml.LIBSBML_OPERATION_SUCCESS );
      assertTrue( E.getMath() != math );
      assertEquals( true, E.isSetMath() );
      i = E.setMath(null);
      assertTrue( i == libsbml.LIBSBML_OPERATION_SUCCESS );
      assertTrue( E.getMath() == null );
      assertEquals( false, E.isSetMath() );
      math = null;
    }

    public void test_InitialAssignment_setMath2()
    {
      ASTNode math = new  ASTNode(libsbml.AST_TIMES);
      long i = E.setMath(math);
      assertTrue( i == libsbml.LIBSBML_INVALID_OBJECT );
      assertEquals( false, E.isSetMath() );
      math = null;
    }

    public void test_InitialAssignment_setSymbol1()
    {
      string id =  "1e1";;
      long i = E.setSymbol(id);
      assertTrue( i == libsbml.LIBSBML_INVALID_ATTRIBUTE_VALUE );
      assertEquals( false, E.isSetSymbol() );
    }

    public void test_InitialAssignment_setSymbol2()
    {
      string id =  "e1";;
      long i = E.setSymbol(id);
      assertTrue( i == libsbml.LIBSBML_OPERATION_SUCCESS );
      assertTrue(( id == E.getSymbol() ));
      assertEquals( true, E.isSetSymbol() );
      i = E.setSymbol("");
      assertTrue( i == libsbml.LIBSBML_OPERATION_SUCCESS );
      assertEquals( false, E.isSetSymbol() );
    }

  }
}
