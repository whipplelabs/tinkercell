/// 
///  @file    TestCopyAndClone.cs
///  @brief   Read SBML unit tests
///  @author  Frank Bergmann (Csharp conversion)
///  @author  Akiya Jouraku (Csharp conversion)
///  @author  Ben Bornstein 
/// 
///  $Id: TestCopyAndClone.cs 10124 2009-08-28 12:04:51Z sarahkeating $
///  $HeadURL: https://sbml.svn.sourceforge.net/svnroot/sbml/trunk/libsbml/src/bindings/csharp/test/xml/TestCopyAndClone.cs $
/// 
///  This test file was converted from src/sbml/test/TestCopyAndClone.cpp
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

  public class TestCopyAndClone {
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


    public void test_NS_assignmentOperator()
    {
      XMLNamespaces ns = new XMLNamespaces();
      ns.add("http://test1.org/", "test1");
      assertTrue( ns.getLength() == 1 );
      assertTrue( ns.isEmpty() == false );
      assertTrue( ns.getPrefix(0) ==  "test1" );
      assertTrue( ns.getURI("test1") ==  "http://test1.org/" );
      XMLNamespaces ns2 = new XMLNamespaces();
      ns2 = ns;
      assertTrue( ns2.getLength() == 1 );
      assertTrue( ns2.isEmpty() == false );
      assertTrue( ns2.getPrefix(0) ==  "test1" );
      assertTrue( ns2.getURI("test1") ==  "http://test1.org/" );
      ns2 = null;
      ns = null;
    }

    public void test_NS_clone()
    {
      XMLNamespaces ns = new XMLNamespaces();
      ns.add("http://test1.org/", "test1");
      assertTrue( ns.getLength() == 1 );
      assertTrue( ns.isEmpty() == false );
      assertTrue( ns.getPrefix(0) ==  "test1" );
      assertTrue( ns.getURI("test1") ==  "http://test1.org/" );
      XMLNamespaces ns2 = (XMLNamespaces) ns.clone();
      assertTrue( ns2.getLength() == 1 );
      assertTrue( ns2.isEmpty() == false );
      assertTrue( ns2.getPrefix(0) ==  "test1" );
      assertTrue( ns2.getURI("test1") ==  "http://test1.org/" );
      ns2 = null;
      ns = null;
    }

    public void test_NS_copyConstructor()
    {
      XMLNamespaces ns = new XMLNamespaces();
      ns.add("http://test1.org/", "test1");
      assertTrue( ns.getLength() == 1 );
      assertTrue( ns.isEmpty() == false );
      assertTrue( ns.getPrefix(0) ==  "test1" );
      assertTrue( ns.getURI("test1") ==  "http://test1.org/" );
      XMLNamespaces ns2 = new XMLNamespaces(ns);
      assertTrue( ns2.getLength() == 1 );
      assertTrue( ns2.isEmpty() == false );
      assertTrue( ns2.getPrefix(0) ==  "test1" );
      assertTrue( ns2.getURI("test1") ==  "http://test1.org/" );
      ns2 = null;
      ns = null;
    }

    public void test_Node_assignmentOperator()
    {
      XMLAttributes att = new XMLAttributes();
      XMLTriple t = new XMLTriple("sarah", "http://foo.org/", "bar");
      XMLToken token = new XMLToken(t,att,3,4);
      XMLNode node = new XMLNode(token);
      XMLNode child = new XMLNode();
      node.addChild(child);
      assertTrue( node.getNumChildren() == 1 );
      assertTrue( node.getName() ==  "sarah" );
      assertTrue( node.getURI() ==  "http://foo.org/" );
      assertTrue( node.getPrefix() ==  "bar" );
      assertTrue( node.isEnd() == false );
      assertTrue( node.isEOF() == false );
      assertTrue( node.getLine() == 3 );
      assertTrue( node.getColumn() == 4 );
      XMLNode node2 = new XMLNode();
      node2 = node;
      assertTrue( node2.getNumChildren() == 1 );
      assertTrue( node2.getName() ==  "sarah" );
      assertTrue( node2.getURI() ==  "http://foo.org/" );
      assertTrue( node2.getPrefix() ==  "bar" );
      assertTrue( node2.isEnd() == false );
      assertTrue( node2.isEOF() == false );
      assertTrue( node2.getLine() == 3 );
      assertTrue( node2.getColumn() == 4 );
      t = null;
      token = null;
      node = null;
      node2 = null;
    }

    public void test_Node_clone()
    {
      XMLAttributes att = new XMLAttributes();
      XMLTriple t = new XMLTriple("sarah", "http://foo.org/", "bar");
      XMLToken token = new XMLToken(t,att,3,4);
      XMLNode node = new XMLNode(token);
      XMLNode child = new XMLNode();
      node.addChild(child);
      assertTrue( node.getNumChildren() == 1 );
      assertTrue( node.getName() ==  "sarah" );
      assertTrue( node.getURI() ==  "http://foo.org/" );
      assertTrue( node.getPrefix() ==  "bar" );
      assertTrue( node.isEnd() == false );
      assertTrue( node.isEOF() == false );
      assertTrue( node.getLine() == 3 );
      assertTrue( node.getColumn() == 4 );
      XMLNode node2 = (XMLNode) node.clone();
      assertTrue( node2.getNumChildren() == 1 );
      assertTrue( node2.getName() ==  "sarah" );
      assertTrue( node2.getURI() ==  "http://foo.org/" );
      assertTrue( node2.getPrefix() ==  "bar" );
      assertTrue( node2.isEnd() == false );
      assertTrue( node2.isEOF() == false );
      assertTrue( node2.getLine() == 3 );
      assertTrue( node2.getColumn() == 4 );
      t = null;
      token = null;
      node = null;
      node2 = null;
    }

    public void test_Node_copyConstructor()
    {
      XMLAttributes att = new XMLAttributes();
      XMLTriple t = new XMLTriple("sarah", "http://foo.org/", "bar");
      XMLToken token = new XMLToken(t,att,3,4);
      XMLNode node = new XMLNode(token);
      XMLNode child = new XMLNode();
      node.addChild(child);
      assertTrue( node.getNumChildren() == 1 );
      assertTrue( node.getName() ==  "sarah" );
      assertTrue( node.getURI() ==  "http://foo.org/" );
      assertTrue( node.getPrefix() ==  "bar" );
      assertTrue( node.isEnd() == false );
      assertTrue( node.isEOF() == false );
      assertTrue( node.getLine() == 3 );
      assertTrue( node.getColumn() == 4 );
      XMLNode node2 = new XMLNode(node);
      assertTrue( node2.getNumChildren() == 1 );
      assertTrue( node2.getName() ==  "sarah" );
      assertTrue( node2.getURI() ==  "http://foo.org/" );
      assertTrue( node2.getPrefix() ==  "bar" );
      assertTrue( node2.isEnd() == false );
      assertTrue( node2.isEOF() == false );
      assertTrue( node2.getLine() == 3 );
      assertTrue( node2.getColumn() == 4 );
      t = null;
      token = null;
      node = null;
      node2 = null;
    }

    public void test_Token_assignmentOperator()
    {
      XMLTriple t = new XMLTriple("sarah", "http://foo.org/", "bar");
      XMLToken token = new XMLToken(t,3,4);
      assertTrue( token.getName() ==  "sarah" );
      assertTrue( token.getURI() ==  "http://foo.org/" );
      assertTrue( token.getPrefix() ==  "bar" );
      assertTrue( token.isEnd() == true );
      assertTrue( token.isEOF() == false );
      assertTrue( token.getLine() == 3 );
      assertTrue( token.getColumn() == 4 );
      XMLToken token2 = new XMLToken();
      token2 = token;
      assertTrue( token2.getName() ==  "sarah" );
      assertTrue( token2.getURI() ==  "http://foo.org/" );
      assertTrue( token2.getPrefix() ==  "bar" );
      assertTrue( token2.isEnd() == true );
      assertTrue( token2.isEOF() == false );
      assertTrue( token2.getLine() == 3 );
      assertTrue( token2.getColumn() == 4 );
      t = null;
      token = null;
      token2 = null;
    }

    public void test_Token_clone()
    {
      XMLTriple t = new XMLTriple("sarah", "http://foo.org/", "bar");
      XMLToken token = new XMLToken(t,3,4);
      assertTrue( token.getName() ==  "sarah" );
      assertTrue( token.getURI() ==  "http://foo.org/" );
      assertTrue( token.getPrefix() ==  "bar" );
      assertTrue( token.isEnd() == true );
      assertTrue( token.isEOF() == false );
      assertTrue( token.getLine() == 3 );
      assertTrue( token.getColumn() == 4 );
      XMLToken token2 = (XMLToken) token.clone();
      assertTrue( token2.getName() ==  "sarah" );
      assertTrue( token2.getURI() ==  "http://foo.org/" );
      assertTrue( token2.getPrefix() ==  "bar" );
      assertTrue( token2.isEnd() == true );
      assertTrue( token2.isEOF() == false );
      assertTrue( token2.getLine() == 3 );
      assertTrue( token2.getColumn() == 4 );
      t = null;
      token = null;
      token2 = null;
    }

    public void test_Token_copyConstructor()
    {
      XMLTriple t = new XMLTriple("sarah", "http://foo.org/", "bar");
      XMLToken token = new XMLToken(t,3,4);
      assertTrue( token.getName() ==  "sarah" );
      assertTrue( token.getURI() ==  "http://foo.org/" );
      assertTrue( token.getPrefix() ==  "bar" );
      assertTrue( token.isEnd() == true );
      assertTrue( token.isEOF() == false );
      assertTrue( token.getLine() == 3 );
      assertTrue( token.getColumn() == 4 );
      XMLToken token2 = new XMLToken(token);
      assertTrue( token2.getName() ==  "sarah" );
      assertTrue( token2.getURI() ==  "http://foo.org/" );
      assertTrue( token2.getPrefix() ==  "bar" );
      assertTrue( token2.isEnd() == true );
      assertTrue( token2.isEOF() == false );
      assertTrue( token2.getLine() == 3 );
      assertTrue( token2.getColumn() == 4 );
      t = null;
      token = null;
      token2 = null;
    }

    public void test_Triple_assignmentOperator()
    {
      XMLTriple t = new XMLTriple("sarah", "http://foo.org/", "bar");
      assertTrue( t.getName() ==  "sarah" );
      assertTrue( t.getURI() ==  "http://foo.org/" );
      assertTrue( t.getPrefix() ==  "bar" );
      XMLTriple t2 = new XMLTriple();
      t2 = t;
      assertTrue( t2.getName() ==  "sarah" );
      assertTrue( t2.getURI() ==  "http://foo.org/" );
      assertTrue( t2.getPrefix() ==  "bar" );
      t = null;
      t2 = null;
    }

    public void test_Triple_clone()
    {
      XMLTriple t = new XMLTriple("sarah", "http://foo.org/", "bar");
      assertTrue( t.getName() ==  "sarah" );
      assertTrue( t.getURI() ==  "http://foo.org/" );
      assertTrue( t.getPrefix() ==  "bar" );
      XMLTriple t2 = (XMLTriple) t.clone();
      assertTrue( t2.getName() ==  "sarah" );
      assertTrue( t2.getURI() ==  "http://foo.org/" );
      assertTrue( t2.getPrefix() ==  "bar" );
      t = null;
      t2 = null;
    }

    public void test_Triple_copyConstructor()
    {
      XMLTriple t = new XMLTriple("sarah", "http://foo.org/", "bar");
      assertTrue( t.getName() ==  "sarah" );
      assertTrue( t.getURI() ==  "http://foo.org/" );
      assertTrue( t.getPrefix() ==  "bar" );
      XMLTriple t2 = new XMLTriple(t);
      assertTrue( t2.getName() ==  "sarah" );
      assertTrue( t2.getURI() ==  "http://foo.org/" );
      assertTrue( t2.getPrefix() ==  "bar" );
      t = null;
      t2 = null;
    }

  }
}
