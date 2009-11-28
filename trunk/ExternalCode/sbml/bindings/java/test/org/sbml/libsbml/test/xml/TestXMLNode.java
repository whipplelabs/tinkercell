/*
 *
 * @file    TestXMLNode.java
 * @brief   XMLNode unit tests
 *
 * @author  Akiya Jouraku (Java conversion)
 * @author  Michael Hucka <mhucka@caltech.edu> 
 *
 * $Id: TestXMLNode.java 10124 2009-08-28 12:04:51Z sarahkeating $
 * $HeadURL: https://sbml.svn.sourceforge.net/svnroot/sbml/trunk/libsbml/src/bindings/java/test/org/sbml/libsbml/test/xml/TestXMLNode.java $
 *
 * This test file was converted from src/sbml/test/TestXMLNode.c
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

public class TestXMLNode {

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

  public void test_XMLNode_attribute_add_remove()
  {
    XMLTriple triple = new  XMLTriple("test","","");
    XMLAttributes attr = new  XMLAttributes();
    XMLNode node = new XMLNode(triple,attr);
    XMLTriple xt1 = new  XMLTriple("name1", "http://name1.org/", "p1");
    XMLTriple xt2 = new  XMLTriple("name2", "http://name2.org/", "p2");
    XMLTriple xt3 = new  XMLTriple("name3", "http://name3.org/", "p3");
    XMLTriple xt1a = new  XMLTriple("name1", "http://name1a.org/", "p1a");
    XMLTriple xt2a = new  XMLTriple("name2", "http://name2a.org/", "p2a");
    node.addAttr( "name1", "val1", "http://name1.org/", "p1");
    node.addAttr(xt2, "val2");
    assertTrue( node.getAttributesLength() == 2 );
    assertTrue( node.isAttributesEmpty() == false );
    assertTrue( !node.getAttrName(0).equals( "name1") == false );
    assertTrue( !node.getAttrValue(0).equals( "val1" ) == false );
    assertTrue( !node.getAttrURI(0).equals( "http://name1.org/") == false );
    assertTrue( !node.getAttrPrefix(0).equals( "p1"   ) == false );
    assertTrue( !node.getAttrName(1).equals( "name2") == false );
    assertTrue( !node.getAttrValue(1).equals( "val2" ) == false );
    assertTrue( !node.getAttrURI(1).equals( "http://name2.org/") == false );
    assertTrue( !node.getAttrPrefix(1).equals( "p2"   ) == false );
    assertTrue( node.getAttrValue( "name1").equals("") == true );
    assertTrue( node.getAttrValue( "name2").equals("") == true );
    assertTrue( !node.getAttrValue( "name1", "http://name1.org/").equals( "val1" ) == false );
    assertTrue( !node.getAttrValue( "name2", "http://name2.org/").equals( "val2" ) == false );
    assertTrue( !node.getAttrValue(xt1).equals( "val1" ) == false );
    assertTrue( !node.getAttrValue(xt2).equals( "val2" ) == false );
    assertTrue( node.hasAttr(-1) == false );
    assertTrue( node.hasAttr(2) == false );
    assertTrue( node.hasAttr(0) == true );
    assertTrue( node.hasAttr( "name1", "http://name1.org/") == true );
    assertTrue( node.hasAttr( "name2", "http://name2.org/") == true );
    assertTrue( node.hasAttr( "name3", "http://name3.org/") == false );
    assertTrue( node.hasAttr(xt1) == true );
    assertTrue( node.hasAttr(xt2) == true );
    assertTrue( node.hasAttr(xt3) == false );
    node.addAttr( "noprefix", "val3");
    assertTrue( node.getAttributesLength() == 3 );
    assertTrue( node.isAttributesEmpty() == false );
    assertTrue( !node.getAttrName(2).equals( "noprefix") == false );
    assertTrue( !node.getAttrValue(2).equals( "val3"    ) == false );
    assertTrue( node.getAttrURI(2).equals("") == true );
    assertTrue( node.getAttrPrefix(2).equals("") == true );
    assertTrue( !node.getAttrValue( "noprefix").equals(     "val3" ) == false );
    assertTrue( !node.getAttrValue( "noprefix", "").equals( "val3" ) == false );
    assertTrue( node.hasAttr( "noprefix"    ) == true );
    assertTrue( node.hasAttr( "noprefix", "") == true );
    node.addAttr(xt1, "mval1");
    node.addAttr( "name2", "mval2", "http://name2.org/", "p2");
    assertTrue( node.getAttributesLength() == 3 );
    assertTrue( node.isAttributesEmpty() == false );
    assertTrue( !node.getAttrName(0).equals( "name1") == false );
    assertTrue( !node.getAttrValue(0).equals( "mval1") == false );
    assertTrue( !node.getAttrURI(0).equals( "http://name1.org/") == false );
    assertTrue( !node.getAttrPrefix(0).equals( "p1"   ) == false );
    assertTrue( !node.getAttrName(1).equals( "name2"   ) == false );
    assertTrue( !node.getAttrValue(1).equals( "mval2"   ) == false );
    assertTrue( !node.getAttrURI(1).equals( "http://name2.org/") == false );
    assertTrue( !node.getAttrPrefix(1).equals( "p2"      ) == false );
    assertTrue( node.hasAttr(xt1) == true );
    assertTrue( node.hasAttr( "name1", "http://name1.org/") == true );
    node.addAttr( "noprefix", "mval3");
    assertTrue( node.getAttributesLength() == 3 );
    assertTrue( node.isAttributesEmpty() == false );
    assertTrue( !node.getAttrName(2).equals( "noprefix") == false );
    assertTrue( !node.getAttrValue(2).equals( "mval3"   ) == false );
    assertTrue( node.getAttrURI(2).equals("") == true );
    assertTrue( node.getAttrPrefix(2).equals("") == true );
    assertTrue( node.hasAttr( "noprefix") == true );
    assertTrue( node.hasAttr( "noprefix", "") == true );
    node.addAttr(xt1a, "val1a");
    node.addAttr(xt2a, "val2a");
    assertTrue( node.getAttributesLength() == 5 );
    assertTrue( !node.getAttrName(3).equals( "name1") == false );
    assertTrue( !node.getAttrValue(3).equals( "val1a") == false );
    assertTrue( !node.getAttrURI(3).equals( "http://name1a.org/") == false );
    assertTrue( !node.getAttrPrefix(3).equals( "p1a") == false );
    assertTrue( !node.getAttrName(4).equals( "name2") == false );
    assertTrue( !node.getAttrValue(4).equals( "val2a") == false );
    assertTrue( !node.getAttrURI(4).equals( "http://name2a.org/") == false );
    assertTrue( !node.getAttrPrefix(4).equals( "p2a") == false );
    assertTrue( !node.getAttrValue( "name1", "http://name1a.org/").equals( "val1a" ) == false );
    assertTrue( !node.getAttrValue( "name2", "http://name2a.org/").equals( "val2a" ) == false );
    assertTrue( !node.getAttrValue(xt1a).equals( "val1a" ) == false );
    assertTrue( !node.getAttrValue(xt2a).equals( "val2a" ) == false );
    node.removeAttr(xt1a);
    node.removeAttr(xt2a);
    assertTrue( node.getAttributesLength() == 3 );
    node.removeAttr( "name1", "http://name1.org/");
    assertTrue( node.getAttributesLength() == 2 );
    assertTrue( node.isAttributesEmpty() == false );
    assertTrue( !node.getAttrName(0).equals( "name2") == false );
    assertTrue( !node.getAttrValue(0).equals( "mval2") == false );
    assertTrue( !node.getAttrURI(0).equals( "http://name2.org/") == false );
    assertTrue( !node.getAttrPrefix(0).equals( "p2") == false );
    assertTrue( !node.getAttrName(1).equals( "noprefix") == false );
    assertTrue( !node.getAttrValue(1).equals( "mval3") == false );
    assertTrue( node.getAttrURI(1).equals("") == true );
    assertTrue( node.getAttrPrefix(1).equals("") == true );
    assertTrue( node.hasAttr( "name1", "http://name1.org/") == false );
    node.removeAttr(xt2);
    assertTrue( node.getAttributesLength() == 1 );
    assertTrue( node.isAttributesEmpty() == false );
    assertTrue( !node.getAttrName(0).equals( "noprefix") == false );
    assertTrue( !node.getAttrValue(0).equals( "mval3") == false );
    assertTrue( node.getAttrURI(0).equals("") == true );
    assertTrue( node.getAttrPrefix(0).equals("") == true );
    assertTrue( node.hasAttr(xt2) == false );
    assertTrue( node.hasAttr( "name2", "http://name2.org/") == false );
    node.removeAttr( "noprefix");
    assertTrue( node.getAttributesLength() == 0 );
    assertTrue( node.isAttributesEmpty() == true );
    assertTrue( node.hasAttr( "noprefix"    ) == false );
    assertTrue( node.hasAttr( "noprefix", "") == false );
    node = null;
    xt1 = null;
    xt2 = null;
    xt3 = null;
    xt1a = null;
    xt2a = null;
    triple = null;
    attr = null;
  }

  public void test_XMLNode_attribute_set_clear()
  {
    XMLTriple triple = new  XMLTriple("test","","");
    XMLAttributes attr = new  XMLAttributes();
    XMLNode node = new XMLNode(triple,attr);
    XMLAttributes nattr = new  XMLAttributes();
    XMLTriple xt1 = new  XMLTriple("name1", "http://name1.org/", "p1");
    XMLTriple xt2 = new  XMLTriple("name2", "http://name2.org/", "p2");
    XMLTriple xt3 = new  XMLTriple("name3", "http://name3.org/", "p3");
    XMLTriple xt4 = new  XMLTriple("name4", "http://name4.org/", "p4");
    XMLTriple xt5 = new  XMLTriple("name5", "http://name5.org/", "p5");
    nattr.add(xt1, "val1");
    nattr.add(xt2, "val2");
    nattr.add(xt3, "val3");
    nattr.add(xt4, "val4");
    nattr.add(xt5, "val5");
    node.setAttributes(nattr);
    assertTrue( node.getAttributesLength() == 5 );
    assertTrue( node.isAttributesEmpty() == false );
    assertTrue( !node.getAttrName(0).equals( "name1") == false );
    assertTrue( !node.getAttrValue(0).equals( "val1" ) == false );
    assertTrue( !node.getAttrURI(0).equals( "http://name1.org/") == false );
    assertTrue( !node.getAttrPrefix(0).equals( "p1"   ) == false );
    assertTrue( !node.getAttrName(1).equals( "name2") == false );
    assertTrue( !node.getAttrValue(1).equals( "val2" ) == false );
    assertTrue( !node.getAttrURI(1).equals( "http://name2.org/") == false );
    assertTrue( !node.getAttrPrefix(1).equals( "p2"   ) == false );
    assertTrue( !node.getAttrName(2).equals( "name3") == false );
    assertTrue( !node.getAttrValue(2).equals( "val3" ) == false );
    assertTrue( !node.getAttrURI(2).equals( "http://name3.org/") == false );
    assertTrue( !node.getAttrPrefix(2).equals( "p3"   ) == false );
    assertTrue( !node.getAttrName(3).equals( "name4") == false );
    assertTrue( !node.getAttrValue(3).equals( "val4" ) == false );
    assertTrue( !node.getAttrURI(3).equals( "http://name4.org/") == false );
    assertTrue( !node.getAttrPrefix(3).equals( "p4"   ) == false );
    assertTrue( !node.getAttrName(4).equals( "name5") == false );
    assertTrue( !node.getAttrValue(4).equals( "val5" ) == false );
    assertTrue( !node.getAttrURI(4).equals( "http://name5.org/") == false );
    assertTrue( !node.getAttrPrefix(4).equals( "p5"   ) == false );
    XMLTriple ntriple = new  XMLTriple("test2","http://test2.org/","p2");
    node.setTriple(ntriple);
    assertTrue( !node.getName().equals(   "test2") == false );
    assertTrue( !node.getURI().equals(    "http://test2.org/") == false );
    assertTrue( !node.getPrefix().equals( "p2") == false );
    node.clearAttributes();
    assertTrue( node.getAttributesLength() == 0 );
    assertTrue( node.isAttributesEmpty() != false );
    triple = null;
    ntriple = null;
    node = null;
    attr = null;
    nattr = null;
    xt1 = null;
    xt2 = null;
    xt3 = null;
    xt4 = null;
    xt5 = null;
  }

  public void test_XMLNode_convert()
  {
    String xmlstr = "<annotation>\n" + "  <test xmlns=\"http://test.org/\" id=\"test\">test</test>\n" + "</annotation>";;
    XMLNode node;
    XMLNode child,gchild;
    XMLAttributes attr;
    XMLNamespaces ns;
    node = XMLNode.convertStringToXMLNode(xmlstr,null);
    child = node.getChild(0);
    gchild = child.getChild(0);
    attr = child.getAttributes();
    ns = child.getNamespaces();
    assertTrue( !node.getName().equals( "annotation") == false );
    assertTrue( !child.getName().equals("test" ) == false );
    assertTrue( !gchild.getCharacters().equals("test" ) == false );
    assertTrue( !attr.getName(0).equals( "id"   ) == false );
    assertTrue( !attr.getValue(0).equals( "test" ) == false );
    assertTrue( !ns.getURI(0).equals( "http://test.org/" ) == false );
    assertTrue( ns.getPrefix(0).equals("") == true );
    String toxmlstring = node.toXMLString();
    assertTrue( !toxmlstring.equals(xmlstr) == false );
    node = null;
  }

  public void test_XMLNode_convert_dummyroot()
  {
    String xmlstr_nodummy1 = "<notes>\n" + "  <p>test</p>\n" + "</notes>";;
    String xmlstr_nodummy2 = "<html>\n" + "  <p>test</p>\n" + "</html>";;
    String xmlstr_nodummy3 = "<body>\n" + "  <p>test</p>\n" + "</body>";;
    String xmlstr_nodummy4 =  "<p>test</p>";;
    String xmlstr_nodummy5 = "<test1>\n" + "  <test2>test</test2>\n" + "</test1>";;
    String xmlstr_dummy1 =  "<p>test1</p><p>test2</p>";;
    String xmlstr_dummy2 =  "<test1>test1</test1><test2>test2</test2>";;
    XMLNode rootnode;
    XMLNode child,gchild;
    XMLAttributes attr;
    XMLNamespaces ns;
    String toxmlstring;
    rootnode = XMLNode.convertStringToXMLNode(xmlstr_nodummy1,null);
    assertTrue( rootnode.getNumChildren() == 1 );
    child = rootnode.getChild(0);
    gchild = child.getChild(0);
    assertTrue( !rootnode.getName().equals( "notes") == false );
    assertTrue( !child.getName().equals("p" ) == false );
    assertTrue( !gchild.getCharacters().equals("test" ) == false );
    toxmlstring = rootnode.toXMLString();
    assertTrue( !toxmlstring.equals(xmlstr_nodummy1) == false );
    rootnode = null;
    rootnode = XMLNode.convertStringToXMLNode(xmlstr_nodummy2,null);
    assertTrue( rootnode.getNumChildren() == 1 );
    child = rootnode.getChild(0);
    gchild = child.getChild(0);
    assertTrue( !rootnode.getName().equals( "html") == false );
    assertTrue( !child.getName().equals("p" ) == false );
    assertTrue( !gchild.getCharacters().equals("test" ) == false );
    toxmlstring = rootnode.toXMLString();
    assertTrue( !toxmlstring.equals(xmlstr_nodummy2) == false );
    rootnode = null;
    rootnode = XMLNode.convertStringToXMLNode(xmlstr_nodummy3,null);
    assertTrue( rootnode.getNumChildren() == 1 );
    child = rootnode.getChild(0);
    gchild = child.getChild(0);
    assertTrue( !rootnode.getName().equals( "body") == false );
    assertTrue( !child.getName().equals("p" ) == false );
    assertTrue( !gchild.getCharacters().equals("test" ) == false );
    toxmlstring = rootnode.toXMLString();
    assertTrue( !toxmlstring.equals(xmlstr_nodummy3) == false );
    rootnode = null;
    rootnode = XMLNode.convertStringToXMLNode(xmlstr_nodummy4,null);
    assertTrue( rootnode.getNumChildren() == 1 );
    child = rootnode.getChild(0);
    assertTrue( !rootnode.getName().equals( "p") == false );
    assertTrue( !child.getCharacters().equals("test" ) == false );
    toxmlstring = rootnode.toXMLString();
    assertTrue( !toxmlstring.equals(xmlstr_nodummy4) == false );
    rootnode = null;
    rootnode = XMLNode.convertStringToXMLNode(xmlstr_nodummy5,null);
    assertTrue( rootnode.getNumChildren() == 1 );
    child = rootnode.getChild(0);
    gchild = child.getChild(0);
    assertTrue( !rootnode.getName().equals( "test1") == false );
    assertTrue( !child.getName().equals("test2" ) == false );
    assertTrue( !gchild.getCharacters().equals("test" ) == false );
    toxmlstring = rootnode.toXMLString();
    assertTrue( !toxmlstring.equals(xmlstr_nodummy5) == false );
    rootnode = null;
    rootnode = XMLNode.convertStringToXMLNode(xmlstr_dummy1,null);
    assertTrue( rootnode.isEOF() == true );
    assertTrue( rootnode.getNumChildren() == 2 );
    child = rootnode.getChild(0);
    gchild = child.getChild(0);
    assertTrue( !child.getName().equals( "p") == false );
    assertTrue( !gchild.getCharacters().equals("test1" ) == false );
    child = rootnode.getChild(1);
    gchild = child.getChild(0);
    assertTrue( !child.getName().equals( "p") == false );
    assertTrue( !gchild.getCharacters().equals("test2" ) == false );
    toxmlstring = rootnode.toXMLString();
    assertTrue( !toxmlstring.equals(xmlstr_dummy1) == false );
    rootnode = null;
    rootnode = XMLNode.convertStringToXMLNode(xmlstr_dummy2,null);
    assertTrue( rootnode.isEOF() == true );
    assertTrue( rootnode.getNumChildren() == 2 );
    child = rootnode.getChild(0);
    gchild = child.getChild(0);
    assertTrue( !child.getName().equals( "test1") == false );
    assertTrue( !gchild.getCharacters().equals("test1" ) == false );
    child = rootnode.getChild(1);
    gchild = child.getChild(0);
    assertTrue( !child.getName().equals( "test2") == false );
    assertTrue( !gchild.getCharacters().equals("test2" ) == false );
    toxmlstring = rootnode.toXMLString();
    assertTrue( !toxmlstring.equals(xmlstr_dummy2) == false );
    rootnode = null;
  }

  public void test_XMLNode_create()
  {
    XMLNode node = new XMLNode();
    assertTrue( node != null );
    assertTrue( node.getNumChildren() == 0 );
    node = null;
    node = new XMLNode();
    assertTrue( node != null );
    XMLNode node2 = new XMLNode();
    assertTrue( node2 != null );
    node.addChild(node2);
    assertTrue( node.getNumChildren() == 1 );
    XMLNode node3 = new XMLNode();
    assertTrue( node3 != null );
    node.addChild(node3);
    assertTrue( node.getNumChildren() == 2 );
    node = null;
    node2 = null;
    node3 = null;
  }

  public void test_XMLNode_createElement()
  {
    XMLTriple triple;
    XMLAttributes attr;
    XMLNamespaces ns;
    XMLNode snode,enode,tnode;
    XMLAttributes cattr;
    String name =  "test";;
    String uri =  "http://test.org/";;
    String prefix =  "p";;
    String text =  "text node";;
    triple = new  XMLTriple(name,uri,prefix);
    ns = new  XMLNamespaces();
    attr = new  XMLAttributes();
    ns.add(uri,prefix);
    attr.add("id", "value",uri,prefix);
    snode = new XMLNode(triple,attr,ns);
    assertTrue( snode != null );
    assertTrue( snode.getNumChildren() == 0 );
    assertTrue( !snode.getName().equals(name) == false );
    assertTrue( !snode.getPrefix().equals(prefix) == false );
    assertTrue( !snode.getURI().equals(uri) == false );
    assertTrue( snode.isElement() == true );
    assertTrue( snode.isStart() == true );
    assertTrue( snode.isEnd() == false );
    assertTrue( snode.isText() == false );
    snode.setEnd();
    assertTrue( snode.isEnd() == true );
    snode.unsetEnd();
    assertTrue( snode.isEnd() == false );
    cattr = snode.getAttributes();
    assertTrue( cattr != null );
    assertTrue( !cattr.getName(0).equals( "id"   ) == false );
    assertTrue( !cattr.getValue(0).equals( "value") == false );
    assertTrue( !cattr.getPrefix(0).equals(prefix) == false );
    assertTrue( !cattr.getURI(0).equals(uri) == false );
    triple = null;
    attr = null;
    ns = null;
    snode = null;
    attr = new  XMLAttributes();
    attr.add("id", "value");
    triple = new  XMLTriple(name, "", "");
    snode = new XMLNode(triple,attr);
    assertTrue( snode != null );
    assertTrue( snode.getNumChildren() == 0 );
    assertTrue( !snode.getName().equals( "test") == false );
    assertTrue( snode.getPrefix().equals("") == true );
    assertTrue( snode.getURI().equals("") == true );
    assertTrue( snode.isElement() == true );
    assertTrue( snode.isStart() == true );
    assertTrue( snode.isEnd() == false );
    assertTrue( snode.isText() == false );
    cattr = snode.getAttributes();
    assertTrue( cattr != null );
    assertTrue( !cattr.getName(0).equals( "id"   ) == false );
    assertTrue( !cattr.getValue(0).equals( "value") == false );
    assertTrue( cattr.getPrefix(0).equals("") == true );
    assertTrue( cattr.getURI(0).equals("") == true );
    enode = new XMLNode(triple);
    assertTrue( enode != null );
    assertTrue( enode.getNumChildren() == 0 );
    assertTrue( !enode.getName().equals( "test") == false );
    assertTrue( enode.getPrefix().equals("") == true );
    assertTrue( enode.getURI().equals("") == true );
    assertTrue( enode.isElement() == true );
    assertTrue( enode.isStart() == false );
    assertTrue( enode.isEnd() == true );
    assertTrue( enode.isText() == false );
    tnode = new XMLNode(text);
    assertTrue( tnode != null );
    assertTrue( !tnode.getCharacters().equals(text) == false );
    assertTrue( tnode.getNumChildren() == 0 );
    assertTrue( tnode.getName().equals("") == true );
    assertTrue( tnode.getPrefix().equals("") == true );
    assertTrue( tnode.getURI().equals("") == true );
    assertTrue( tnode.isElement() == false );
    assertTrue( tnode.isStart() == false );
    assertTrue( tnode.isEnd() == false );
    assertTrue( tnode.isText() == true );
    triple = null;
    attr = null;
    snode = null;
    enode = null;
    tnode = null;
  }

  public void test_XMLNode_createFromToken()
  {
    XMLToken token;
    XMLTriple triple;
    XMLNode node;
    triple = new  XMLTriple("attr", "uri", "prefix");
    token = new  XMLToken(triple);
    node = new XMLNode(token);
    assertTrue( node != null );
    assertTrue( node.getNumChildren() == 0 );
    assertTrue( !node.getName().equals( "attr") == false );
    assertTrue( !node.getPrefix().equals( "prefix") == false );
    assertTrue( !node.getURI().equals( "uri") == false );
    assertTrue( node.getChild(1) != null );
    token = null;
    triple = null;
    node = null;
  }

  public void test_XMLNode_getters()
  {
    XMLToken token;
    XMLNode node;
    XMLTriple triple;
    XMLAttributes attr;
    XMLNamespaces NS;
    NS = new  XMLNamespaces();
    NS.add( "http://test1.org/", "test1");
    token = new  XMLToken("This is a test");
    node = new XMLNode(token);
    assertTrue( node != null );
    assertTrue( node.getNumChildren() == 0 );
    assertTrue( !node.getCharacters().equals( "This is a test") == false );
    assertTrue( node.getChild(1) != null );
    attr = new  XMLAttributes();
    assertTrue( attr != null );
    attr.add( "attr2", "value");
    triple = new  XMLTriple("attr", "uri", "prefix");
    token = new  XMLToken(triple,attr);
    assertTrue( token != null );
    node = new XMLNode(token);
    assertTrue( !node.getName().equals( "attr") == false );
    assertTrue( !node.getURI().equals( "uri") == false );
    assertTrue( !node.getPrefix().equals( "prefix") == false );
    XMLAttributes returnattr = node.getAttributes();
    assertTrue( !returnattr.getName(0).equals( "attr2") == false );
    assertTrue( !returnattr.getValue(0).equals( "value") == false );
    token = new  XMLToken(triple,attr,NS);
    node = new XMLNode(token);
    XMLNamespaces returnNS = node.getNamespaces();
    assertTrue( returnNS.getLength() == 1 );
    assertTrue( returnNS.isEmpty() == false );
    triple = null;
    token = null;
    node = null;
  }

  public void test_XMLNode_insert()
  {
    XMLAttributes attr = new  XMLAttributes();
    XMLTriple trp_p = new  XMLTriple("parent","","");
    XMLTriple trp_c1 = new  XMLTriple("child1","","");
    XMLTriple trp_c2 = new  XMLTriple("child2","","");
    XMLTriple trp_c3 = new  XMLTriple("child3","","");
    XMLTriple trp_c4 = new  XMLTriple("child4","","");
    XMLTriple trp_c5 = new  XMLTriple("child5","","");
    XMLNode p = new XMLNode(trp_p,attr);
    XMLNode c1 = new XMLNode(trp_c1,attr);
    XMLNode c2 = new XMLNode(trp_c2,attr);
    XMLNode c3 = new XMLNode(trp_c3,attr);
    XMLNode c4 = new XMLNode(trp_c4,attr);
    XMLNode c5 = new XMLNode(trp_c5,attr);
    p.addChild(c2);
    p.addChild(c4);
    p.insertChild(0,c1);
    p.insertChild(2,c3);
    p.insertChild(4,c5);
    assertTrue( p.getNumChildren() == 5 );
    assertTrue( !p.getChild(0).getName().equals( "child1") == false );
    assertTrue( !p.getChild(1).getName().equals( "child2") == false );
    assertTrue( !p.getChild(2).getName().equals( "child3") == false );
    assertTrue( !p.getChild(3).getName().equals( "child4") == false );
    assertTrue( !p.getChild(4).getName().equals( "child5") == false );
    p.removeChildren();
    p.insertChild(0,c1);
    p.insertChild(0,c2);
    p.insertChild(0,c3);
    p.insertChild(0,c4);
    p.insertChild(0,c5);
    assertTrue( p.getNumChildren() == 5 );
    assertTrue( !p.getChild(0).getName().equals( "child5") == false );
    assertTrue( !p.getChild(1).getName().equals( "child4") == false );
    assertTrue( !p.getChild(2).getName().equals( "child3") == false );
    assertTrue( !p.getChild(3).getName().equals( "child2") == false );
    assertTrue( !p.getChild(4).getName().equals( "child1") == false );
    p.removeChildren();
    p.insertChild(1,c1);
    p.insertChild(2,c2);
    p.insertChild(3,c3);
    p.insertChild(4,c4);
    p.insertChild(5,c5);
    assertTrue( p.getNumChildren() == 5 );
    assertTrue( !p.getChild(0).getName().equals( "child1") == false );
    assertTrue( !p.getChild(1).getName().equals( "child2") == false );
    assertTrue( !p.getChild(2).getName().equals( "child3") == false );
    assertTrue( !p.getChild(3).getName().equals( "child4") == false );
    assertTrue( !p.getChild(4).getName().equals( "child5") == false );
    p.removeChildren();
    XMLNode tmp;
    tmp = p.insertChild(0,c1);
    assertTrue( !tmp.getName().equals("child1") == false );
    tmp = p.insertChild(0,c2);
    assertTrue( !tmp.getName().equals("child2") == false );
    tmp = p.insertChild(0,c3);
    assertTrue( !tmp.getName().equals("child3") == false );
    tmp = p.insertChild(0,c4);
    assertTrue( !tmp.getName().equals("child4") == false );
    tmp = p.insertChild(0,c5);
    assertTrue( !tmp.getName().equals("child5") == false );
    p.removeChildren();
    tmp = p.insertChild(1,c1);
    assertTrue( !tmp.getName().equals("child1") == false );
    tmp = p.insertChild(2,c2);
    assertTrue( !tmp.getName().equals("child2") == false );
    tmp = p.insertChild(3,c3);
    assertTrue( !tmp.getName().equals("child3") == false );
    tmp = p.insertChild(4,c4);
    assertTrue( !tmp.getName().equals("child4") == false );
    tmp = p.insertChild(5,c5);
    assertTrue( !tmp.getName().equals("child5") == false );
    p = null;
    c1 = null;
    c2 = null;
    c3 = null;
    c4 = null;
    c5 = null;
    attr = null;
    trp_p = null;
    trp_c1 = null;
    trp_c2 = null;
    trp_c3 = null;
    trp_c4 = null;
    trp_c5 = null;
  }

  public void test_XMLNode_namespace_add()
  {
    XMLTriple triple = new  XMLTriple("test","","");
    XMLAttributes attr = new  XMLAttributes();
    XMLNode node = new XMLNode(triple,attr);
    assertTrue( node.getNamespacesLength() == 0 );
    assertTrue( node.isNamespacesEmpty() == true );
    node.addNamespace( "http://test1.org/", "test1");
    assertTrue( node.getNamespacesLength() == 1 );
    assertTrue( node.isNamespacesEmpty() == false );
    node.addNamespace( "http://test2.org/", "test2");
    assertTrue( node.getNamespacesLength() == 2 );
    assertTrue( node.isNamespacesEmpty() == false );
    node.addNamespace( "http://test1.org/", "test1a");
    assertTrue( node.getNamespacesLength() == 3 );
    assertTrue( node.isNamespacesEmpty() == false );
    node.addNamespace( "http://test1.org/", "test1a");
    assertTrue( node.getNamespacesLength() == 3 );
    assertTrue( node.isNamespacesEmpty() == false );
    assertTrue( ! (node.getNamespaceIndex( "http://test1.org/") == -1) );
    node = null;
    triple = null;
    attr = null;
  }

  public void test_XMLNode_namespace_get()
  {
    XMLTriple triple = new  XMLTriple("test","","");
    XMLAttributes attr = new  XMLAttributes();
    XMLNode node = new XMLNode(triple,attr);
    node.addNamespace( "http://test1.org/", "test1");
    node.addNamespace( "http://test2.org/", "test2");
    node.addNamespace( "http://test3.org/", "test3");
    node.addNamespace( "http://test4.org/", "test4");
    node.addNamespace( "http://test5.org/", "test5");
    node.addNamespace( "http://test6.org/", "test6");
    node.addNamespace( "http://test7.org/", "test7");
    node.addNamespace( "http://test8.org/", "test8");
    node.addNamespace( "http://test9.org/", "test9");
    assertTrue( node.getNamespacesLength() == 9 );
    assertTrue( node.getNamespaceIndex( "http://test1.org/") == 0 );
    assertTrue( !node.getNamespacePrefix(1).equals( "test2") == false );
    assertTrue( !node.getNamespacePrefix( "http://test1.org/").equals(		      "test1") == false );
    assertTrue( !node.getNamespaceURI(1).equals( "http://test2.org/") == false );
    assertTrue( !node.getNamespaceURI( "test2").equals(		      "http://test2.org/") == false );
    assertTrue( node.getNamespaceIndex( "http://test1.org/") == 0 );
    assertTrue( node.getNamespaceIndex( "http://test2.org/") == 1 );
    assertTrue( node.getNamespaceIndex( "http://test5.org/") == 4 );
    assertTrue( node.getNamespaceIndex( "http://test9.org/") == 8 );
    assertTrue( node.getNamespaceIndex( "http://testX.org/") == -1 );
    assertTrue( node.hasNamespaceURI( "http://test1.org/") != false );
    assertTrue( node.hasNamespaceURI( "http://test2.org/") != false );
    assertTrue( node.hasNamespaceURI( "http://test5.org/") != false );
    assertTrue( node.hasNamespaceURI( "http://test9.org/") != false );
    assertTrue( node.hasNamespaceURI( "http://testX.org/") == false );
    assertTrue( node.getNamespaceIndexByPrefix( "test1") == 0 );
    assertTrue( node.getNamespaceIndexByPrefix( "test5") == 4 );
    assertTrue( node.getNamespaceIndexByPrefix( "test9") == 8 );
    assertTrue( node.getNamespaceIndexByPrefix( "testX") == -1 );
    assertTrue( node.hasNamespacePrefix( "test1") != false );
    assertTrue( node.hasNamespacePrefix( "test5") != false );
    assertTrue( node.hasNamespacePrefix( "test9") != false );
    assertTrue( node.hasNamespacePrefix( "testX") == false );
    assertTrue( node.hasNamespaceNS( "http://test1.org/", "test1") != false );
    assertTrue( node.hasNamespaceNS( "http://test5.org/", "test5") != false );
    assertTrue( node.hasNamespaceNS( "http://test9.org/", "test9") != false );
    assertTrue( node.hasNamespaceNS( "http://testX.org/", "testX") == false );
    node = null;
    triple = null;
    attr = null;
  }

  public void test_XMLNode_namespace_remove()
  {
    XMLTriple triple = new  XMLTriple("test","","");
    XMLAttributes attr = new  XMLAttributes();
    XMLNode node = new XMLNode(triple,attr);
    node.addNamespace( "http://test1.org/", "test1");
    node.addNamespace( "http://test2.org/", "test2");
    node.addNamespace( "http://test3.org/", "test3");
    node.addNamespace( "http://test4.org/", "test4");
    node.addNamespace( "http://test5.org/", "test5");
    assertTrue( node.getNamespacesLength() == 5 );
    node.removeNamespace(4);
    assertTrue( node.getNamespacesLength() == 4 );
    node.removeNamespace(3);
    assertTrue( node.getNamespacesLength() == 3 );
    node.removeNamespace(2);
    assertTrue( node.getNamespacesLength() == 2 );
    node.removeNamespace(1);
    assertTrue( node.getNamespacesLength() == 1 );
    node.removeNamespace(0);
    assertTrue( node.getNamespacesLength() == 0 );
    node.addNamespace( "http://test1.org/", "test1");
    node.addNamespace( "http://test2.org/", "test2");
    node.addNamespace( "http://test3.org/", "test3");
    node.addNamespace( "http://test4.org/", "test4");
    node.addNamespace( "http://test5.org/", "test5");
    assertTrue( node.getNamespacesLength() == 5 );
    node.removeNamespace(0);
    assertTrue( node.getNamespacesLength() == 4 );
    node.removeNamespace(0);
    assertTrue( node.getNamespacesLength() == 3 );
    node.removeNamespace(0);
    assertTrue( node.getNamespacesLength() == 2 );
    node.removeNamespace(0);
    assertTrue( node.getNamespacesLength() == 1 );
    node.removeNamespace(0);
    assertTrue( node.getNamespacesLength() == 0 );
    node = null;
    triple = null;
    attr = null;
  }

  public void test_XMLNode_namespace_remove_by_prefix()
  {
    XMLTriple triple = new  XMLTriple("test","","");
    XMLAttributes attr = new  XMLAttributes();
    XMLNode node = new XMLNode(triple,attr);
    node.addNamespace( "http://test1.org/", "test1");
    node.addNamespace( "http://test2.org/", "test2");
    node.addNamespace( "http://test3.org/", "test3");
    node.addNamespace( "http://test4.org/", "test4");
    node.addNamespace( "http://test5.org/", "test5");
    assertTrue( node.getNamespacesLength() == 5 );
    node.removeNamespace( "test1");
    assertTrue( node.getNamespacesLength() == 4 );
    node.removeNamespace( "test2");
    assertTrue( node.getNamespacesLength() == 3 );
    node.removeNamespace( "test3");
    assertTrue( node.getNamespacesLength() == 2 );
    node.removeNamespace( "test4");
    assertTrue( node.getNamespacesLength() == 1 );
    node.removeNamespace( "test5");
    assertTrue( node.getNamespacesLength() == 0 );
    node.addNamespace( "http://test1.org/", "test1");
    node.addNamespace( "http://test2.org/", "test2");
    node.addNamespace( "http://test3.org/", "test3");
    node.addNamespace( "http://test4.org/", "test4");
    node.addNamespace( "http://test5.org/", "test5");
    assertTrue( node.getNamespacesLength() == 5 );
    node.removeNamespace( "test5");
    assertTrue( node.getNamespacesLength() == 4 );
    node.removeNamespace( "test4");
    assertTrue( node.getNamespacesLength() == 3 );
    node.removeNamespace( "test3");
    assertTrue( node.getNamespacesLength() == 2 );
    node.removeNamespace( "test2");
    assertTrue( node.getNamespacesLength() == 1 );
    node.removeNamespace( "test1");
    assertTrue( node.getNamespacesLength() == 0 );
    node.addNamespace( "http://test1.org/", "test1");
    node.addNamespace( "http://test2.org/", "test2");
    node.addNamespace( "http://test3.org/", "test3");
    node.addNamespace( "http://test4.org/", "test4");
    node.addNamespace( "http://test5.org/", "test5");
    assertTrue( node.getNamespacesLength() == 5 );
    node.removeNamespace( "test3");
    assertTrue( node.getNamespacesLength() == 4 );
    node.removeNamespace( "test1");
    assertTrue( node.getNamespacesLength() == 3 );
    node.removeNamespace( "test4");
    assertTrue( node.getNamespacesLength() == 2 );
    node.removeNamespace( "test5");
    assertTrue( node.getNamespacesLength() == 1 );
    node.removeNamespace( "test2");
    assertTrue( node.getNamespacesLength() == 0 );
    node = null;
    triple = null;
    attr = null;
  }

  public void test_XMLNode_namespace_set_clear()
  {
    XMLTriple triple = new  XMLTriple("test","","");
    XMLAttributes attr = new  XMLAttributes();
    XMLNode node = new XMLNode(triple,attr);
    XMLNamespaces ns = new  XMLNamespaces();
    assertTrue( node.getNamespacesLength() == 0 );
    assertTrue( node.isNamespacesEmpty() == true );
    ns.add( "http://test1.org/", "test1");
    ns.add( "http://test2.org/", "test2");
    ns.add( "http://test3.org/", "test3");
    ns.add( "http://test4.org/", "test4");
    ns.add( "http://test5.org/", "test5");
    node.setNamespaces(ns);
    assertTrue( node.getNamespacesLength() == 5 );
    assertTrue( node.isNamespacesEmpty() == false );
    assertTrue( !node.getNamespacePrefix(0).equals( "test1") == false );
    assertTrue( !node.getNamespacePrefix(1).equals( "test2") == false );
    assertTrue( !node.getNamespacePrefix(2).equals( "test3") == false );
    assertTrue( !node.getNamespacePrefix(3).equals( "test4") == false );
    assertTrue( !node.getNamespacePrefix(4).equals( "test5") == false );
    assertTrue( !node.getNamespaceURI(0).equals( "http://test1.org/") == false );
    assertTrue( !node.getNamespaceURI(1).equals( "http://test2.org/") == false );
    assertTrue( !node.getNamespaceURI(2).equals( "http://test3.org/") == false );
    assertTrue( !node.getNamespaceURI(3).equals( "http://test4.org/") == false );
    assertTrue( !node.getNamespaceURI(4).equals( "http://test5.org/") == false );
    node.clearNamespaces();
    assertTrue( node.getNamespacesLength() == 0 );
    assertTrue( node.isAttributesEmpty() != false );
    ns = null;
    node = null;
    triple = null;
    attr = null;
  }

  public void test_XMLNode_remove()
  {
    XMLAttributes attr = new  XMLAttributes();
    XMLTriple trp_p = new  XMLTriple("parent","","");
    XMLTriple trp_c1 = new  XMLTriple("child1","","");
    XMLTriple trp_c2 = new  XMLTriple("child2","","");
    XMLTriple trp_c3 = new  XMLTriple("child3","","");
    XMLTriple trp_c4 = new  XMLTriple("child4","","");
    XMLTriple trp_c5 = new  XMLTriple("child5","","");
    XMLNode p = new XMLNode(trp_p,attr);
    XMLNode c1 = new XMLNode(trp_c1,attr);
    XMLNode c2 = new XMLNode(trp_c2,attr);
    XMLNode c3 = new XMLNode(trp_c3,attr);
    XMLNode c4 = new XMLNode(trp_c4,attr);
    XMLNode c5 = new XMLNode(trp_c5,attr);
    XMLNode r;
    p.addChild(c1);
    p.addChild(c2);
    p.addChild(c3);
    p.addChild(c4);
    p.addChild(c5);
    r = p.removeChild(5);
    assertTrue( r == null );
    r = p.removeChild(1);
    assertTrue( p.getNumChildren() == 4 );
    assertTrue( !r.getName().equals("child2") == false );
    r = null;
    r = p.removeChild(3);
    assertTrue( p.getNumChildren() == 3 );
    assertTrue( !r.getName().equals("child5") == false );
    r = null;
    r = p.removeChild(0);
    assertTrue( p.getNumChildren() == 2 );
    assertTrue( !r.getName().equals("child1") == false );
    r = null;
    r = p.removeChild(1);
    assertTrue( p.getNumChildren() == 1 );
    assertTrue( !r.getName().equals("child4") == false );
    r = null;
    r = p.removeChild(0);
    assertTrue( p.getNumChildren() == 0 );
    assertTrue( !r.getName().equals("child3") == false );
    r = null;
    p.addChild(c1);
    p.addChild(c2);
    p.addChild(c3);
    p.addChild(c4);
    p.addChild(c5);
    r = p.removeChild(4);
    assertTrue( p.getNumChildren() == 4 );
    assertTrue( !r.getName().equals("child5") == false );
    r = null;
    r = p.removeChild(3);
    assertTrue( p.getNumChildren() == 3 );
    assertTrue( !r.getName().equals("child4") == false );
    r = null;
    r = p.removeChild(2);
    assertTrue( p.getNumChildren() == 2 );
    assertTrue( !r.getName().equals("child3") == false );
    r = null;
    r = p.removeChild(1);
    assertTrue( p.getNumChildren() == 1 );
    assertTrue( !r.getName().equals("child2") == false );
    r = null;
    r = p.removeChild(0);
    assertTrue( p.getNumChildren() == 0 );
    assertTrue( !r.getName().equals("child1") == false );
    r = null;
    p.addChild(c1);
    p.addChild(c2);
    p.addChild(c3);
    p.addChild(c4);
    p.addChild(c5);
    r = p.removeChild(0);
    assertTrue( p.getNumChildren() == 4 );
    assertTrue( !r.getName().equals("child1") == false );
    r = null;
    r = p.removeChild(0);
    assertTrue( p.getNumChildren() == 3 );
    assertTrue( !r.getName().equals("child2") == false );
    r = null;
    r = p.removeChild(0);
    assertTrue( p.getNumChildren() == 2 );
    assertTrue( !r.getName().equals("child3") == false );
    r = null;
    r = p.removeChild(0);
    assertTrue( p.getNumChildren() == 1 );
    assertTrue( !r.getName().equals("child4") == false );
    r = null;
    r = p.removeChild(0);
    assertTrue( p.getNumChildren() == 0 );
    assertTrue( !r.getName().equals("child5") == false );
    r = null;
    p.addChild(c1);
    p.addChild(c2);
    p.addChild(c3);
    p.addChild(c4);
    p.addChild(c5);
    r = p.removeChild(0);
    assertTrue( !r.getName().equals("child1") == false );
    p.insertChild(0,r);
    assertTrue( p.getNumChildren() == 5 );
    assertTrue( !p.getChild(0).getName().equals("child1") == false );
    r = null;
    r = p.removeChild(1);
    assertTrue( !r.getName().equals("child2") == false );
    p.insertChild(1,r);
    assertTrue( p.getNumChildren() == 5 );
    assertTrue( !p.getChild(1).getName().equals("child2") == false );
    r = null;
    r = p.removeChild(2);
    assertTrue( !r.getName().equals("child3") == false );
    p.insertChild(2,r);
    assertTrue( p.getNumChildren() == 5 );
    assertTrue( !p.getChild(2).getName().equals("child3") == false );
    r = null;
    r = p.removeChild(3);
    assertTrue( !r.getName().equals("child4") == false );
    p.insertChild(3,r);
    assertTrue( p.getNumChildren() == 5 );
    assertTrue( !p.getChild(3).getName().equals("child4") == false );
    r = null;
    r = p.removeChild(4);
    assertTrue( !r.getName().equals("child5") == false );
    p.insertChild(4,r);
    assertTrue( p.getNumChildren() == 5 );
    assertTrue( !p.getChild(4).getName().equals("child5") == false );
    r = null;
    p = null;
    c1 = null;
    c2 = null;
    c3 = null;
    c4 = null;
    c5 = null;
    attr = null;
    trp_p = null;
    trp_c1 = null;
    trp_c2 = null;
    trp_c3 = null;
    trp_c4 = null;
    trp_c5 = null;
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
