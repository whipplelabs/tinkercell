/// 
///  @file    TestSyntaxChecker.cs
///  @brief   SyntaxChecker unit tests
///  @author  Frank Bergmann (Csharp conversion)
///  @author  Akiya Jouraku (Csharp conversion)
///  @author  Sarah Keating 
/// 
///  $Id$
///  $HeadURL$
/// 
///  This test file was converted from src/sbml/test/TestSyntaxChecker.c
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

  public class TestSyntaxChecker {
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


    public void test_SyntaxChecker_validID()
    {
      assertTrue( SyntaxChecker.isValidXMLID("cell") == true );
      assertTrue( SyntaxChecker.isValidXMLID("1cell") == false );
      assertTrue( SyntaxChecker.isValidXMLID("_cell") == true );
    }

    public void test_SyntaxChecker_validId()
    {
      assertTrue( SyntaxChecker.isValidSBMLSId("cell") == true );
      assertTrue( SyntaxChecker.isValidSBMLSId("1cell") == false );
    }

    public void test_SyntaxChecker_validUnitId()
    {
      assertTrue( SyntaxChecker.isValidUnitSId("cell") == true );
      assertTrue( SyntaxChecker.isValidUnitSId("1cell") == false );
    }

    public void test_SyntaxChecker_validXHTML()
    {
      XMLToken token;
      XMLNode node;
      XMLTriple triple = new  XMLTriple("p", "", "");
      XMLAttributes att = new  XMLAttributes();
      XMLNamespaces ns = new  XMLNamespaces();
      ns.add( "http://www.w3.org/1999/xhtml", "");
      XMLToken tt = new  XMLToken("This is my text");
      XMLNode n1 = new XMLNode(tt);
      token = new  XMLToken(triple,att,ns);
      node = new XMLNode(token);
      node.addChild(n1);
      assertTrue( SyntaxChecker.hasExpectedXHTMLSyntax(node,null) == false );
      triple = new  XMLTriple("html", "", "");
      ns.clear();
      token = new  XMLToken(triple,att,ns);
      node = new XMLNode(token);
      node.addChild(n1);
      assertTrue( SyntaxChecker.hasExpectedXHTMLSyntax(node,null) == false );
    }

  }
}
