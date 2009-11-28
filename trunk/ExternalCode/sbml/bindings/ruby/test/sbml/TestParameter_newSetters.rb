#
# @file    TestParameter_newSetters.rb
# @brief   Parameter unit tests for new set function API
#
# @author  Akiya Jouraku (Ruby conversion)
# @author  Sarah Keating 
#
# $Id$
# $HeadURL$
#
# This test file was converted from src/sbml/test/TestParameter_newSetters.c
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

class TestParameter_newSetters < Test::Unit::TestCase

  def setup
    @@p = LibSBML::Parameter.new(1,2)
    if (@@p == nil)
    end
  end

  def teardown
    @@p = nil
  end

  def test_Parameter_setConstant1
    i = @@p.setConstant(false)
    assert( i == LibSBML::LIBSBML_UNEXPECTED_ATTRIBUTE )
    assert( @@p.getConstant() == false )
  end

  def test_Parameter_setConstant2
    p = LibSBML::Parameter.new(2,2)
    i = p.setConstant(false)
    assert( i == LibSBML::LIBSBML_OPERATION_SUCCESS )
    assert( p.getConstant() == false )
    p = nil
  end

  def test_Parameter_setId1
    i = @@p.setId( "1cell")
    assert( i == LibSBML::LIBSBML_INVALID_ATTRIBUTE_VALUE )
    assert_equal false, @@p.isSetId()
  end

  def test_Parameter_setId2
    i = @@p.setId( "cell")
    assert( i == LibSBML::LIBSBML_OPERATION_SUCCESS )
    assert_equal true, @@p.isSetId()
    assert ((  "cell"  == @@p.getId() ))
    i = @@p.setId("")
    assert( i == LibSBML::LIBSBML_OPERATION_SUCCESS )
    assert_equal false, @@p.isSetId()
  end

  def test_Parameter_setName1
    i = @@p.setName( "cell")
    assert( i == LibSBML::LIBSBML_OPERATION_SUCCESS )
    assert_equal true, @@p.isSetName()
    i = @@p.unsetName()
    assert( i == LibSBML::LIBSBML_OPERATION_SUCCESS )
    assert_equal false, @@p.isSetName()
  end

  def test_Parameter_setName2
    p = LibSBML::Parameter.new(2,2)
    i = p.setName( "1cell")
    assert( i == LibSBML::LIBSBML_OPERATION_SUCCESS )
    assert_equal true, p.isSetName()
    i = p.unsetName()
    assert( i == LibSBML::LIBSBML_OPERATION_SUCCESS )
    assert_equal false, p.isSetName()
    p = nil
  end

  def test_Parameter_setName3
    p = LibSBML::Parameter.new(1,2)
    i = p.setName( "11pp")
    assert( i == LibSBML::LIBSBML_INVALID_ATTRIBUTE_VALUE )
    assert_equal false, p.isSetName()
    i = p.setName("")
    assert( i == LibSBML::LIBSBML_OPERATION_SUCCESS )
    assert_equal false, p.isSetName()
    p = nil
  end

  def test_Parameter_setUnits1
    i = @@p.setUnits( "1cell")
    assert( i == LibSBML::LIBSBML_INVALID_ATTRIBUTE_VALUE )
    assert_equal false, @@p.isSetUnits()
    i = @@p.unsetUnits()
    assert( i == LibSBML::LIBSBML_OPERATION_SUCCESS )
    assert_equal false, @@p.isSetUnits()
  end

  def test_Parameter_setUnits2
    i = @@p.setUnits( "litre")
    assert( i == LibSBML::LIBSBML_OPERATION_SUCCESS )
    assert_equal true, @@p.isSetUnits()
    i = @@p.unsetUnits()
    assert( i == LibSBML::LIBSBML_OPERATION_SUCCESS )
    assert_equal false, @@p.isSetUnits()
  end

  def test_Parameter_setUnits3
    i = @@p.setUnits("")
    assert( i == LibSBML::LIBSBML_OPERATION_SUCCESS )
    assert_equal false, @@p.isSetUnits()
  end

  def test_Parameter_setValue1
    i = @@p.setValue(2.0)
    assert( i == LibSBML::LIBSBML_OPERATION_SUCCESS )
    assert( @@p.getValue() == 2.0 )
    assert_equal true, @@p.isSetValue()
    i = @@p.unsetValue()
    assert( i == LibSBML::LIBSBML_OPERATION_SUCCESS )
    assert_equal false, @@p.isSetValue()
  end

  def test_Parameter_setValue2
    p = LibSBML::Parameter.new(2,2)
    i = p.unsetValue()
    assert( i == LibSBML::LIBSBML_OPERATION_SUCCESS )
    assert_equal false, p.isSetValue()
    p = nil
  end

end
