#
# @file    TestMathReadFromFile1.rb
# @brief   Tests for reading MathML from files into ASTNodes.
#
# @author  Akiya Jouraku (Ruby conversion)
# @author  Sarah Keating 
#
# $Id: TestMathReadFromFile1.rb 10124 2009-08-28 12:04:51Z sarahkeating $
# $HeadURL: https://sbml.svn.sourceforge.net/svnroot/sbml/trunk/libsbml/src/bindings/ruby/test/math/TestMathReadFromFile1.rb $
#
# This test file was converted from src/sbml/test/TestReadFromFile1.cpp
# with the help of conversion sciprt (ctest_converter.pl).
#
#<!---------------------------------------------------------------------------
# This file is part of libSBML.  Please visit http://sbml.org for more
# information about SBML, and the latest version of libSBML.
#
# Copyright 2005-2009 California Institute of Technology.
# Copyright 2002-2005 California Institute of Technology and
#                     Japan Science and Technology Corporation.
# 
# This library is free software; you can redistribute it and/or modify it
# under the terms of the GNU Lesser General Public License as published by
# the Free Software Foundation.  A copy of the license agreement is provided
# in the file named "LICENSE.txt" included with this software distribution
# and also available online as http://sbml.org/software/libsbml/license.html
#--------------------------------------------------------------------------->*/
require 'test/unit'
require 'libSBML'

class TestMathReadFromFile1 < Test::Unit::TestCase

  def test_read_MathML_1
    reader = LibSBML::SBMLReader.new()
    filename = "../../math/test/test-data/"
    filename += "mathML_1.xml"
    d = reader.readSBML(filename)
    if (d == nil)
    end
    m = d.getModel()
    assert( m != nil )
    assert( m.getNumFunctionDefinitions() == 2 )
    assert( m.getNumInitialAssignments() == 1 )
    assert( m.getNumRules() == 2 )
    assert( m.getNumReactions() == 1 )
    fd = m.getFunctionDefinition(0)
    fd_math = fd.getMath()
    assert( fd_math.getType() == LibSBML::AST_LAMBDA )
    assert( fd_math.getNumChildren() == 2 )
    assert ((  "lambda(x, )" == LibSBML::formulaToString(fd_math) ))
    assert( fd_math.getParentSBMLObject() == fd )
    child = fd_math.getRightChild()
    assert( child.getType() == LibSBML::AST_UNKNOWN )
    assert( child.getNumChildren() == 0 )
    assert ((  "" == LibSBML::formulaToString(child) ))
    fd = m.getFunctionDefinition(1)
    fd1_math = fd.getMath()
    assert( fd1_math.getType() == LibSBML::AST_LAMBDA )
    assert( fd1_math.getNumChildren() == 2 )
    assert ((  "lambda(x, true)" == LibSBML::formulaToString(fd1_math) ))
    assert( fd1_math.getParentSBMLObject() == fd )
    child1 = fd1_math.getRightChild()
    assert( child1.getType() == LibSBML::AST_CONSTANT_TRUE )
    assert( child1.getNumChildren() == 0 )
    assert ((  "true" == LibSBML::formulaToString(child1) ))
    ia = m.getInitialAssignment(0)
    ia_math = ia.getMath()
    assert( ia_math.getType() == LibSBML::AST_UNKNOWN )
    assert( ia_math.getNumChildren() == 0 )
    assert ((  "" == LibSBML::formulaToString(ia_math) ))
    assert( ia_math.getParentSBMLObject() == ia )
    r = m.getRule(0)
    r_math = r.getMath()
    assert( r_math.getType() == LibSBML::AST_CONSTANT_TRUE )
    assert( r_math.getNumChildren() == 0 )
    assert ((  "true" == LibSBML::formulaToString(r_math) ))
    assert( r_math.getParentSBMLObject() == r )
    r = m.getRule(1)
    r1_math = r.getMath()
    assert( r1_math.getType() == LibSBML::AST_REAL )
    assert( r1_math.getNumChildren() == 0 )
    assert ((  "INF" == LibSBML::formulaToString(r1_math) ))
    assert( r1_math.getParentSBMLObject() == r )
    kl = m.getReaction(0).getKineticLaw()
    kl_math = kl.getMath()
    assert( kl_math.getType() == LibSBML::AST_REAL )
    assert( kl_math.getNumChildren() == 0 )
    assert ((  "4.5" == LibSBML::formulaToString(kl_math) ))
    assert( kl_math.getParentSBMLObject() == kl )
    d = nil
  end

end
