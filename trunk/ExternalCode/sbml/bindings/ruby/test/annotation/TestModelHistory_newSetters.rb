#
# @file    TestModelHistory_newSetters.rb
# @brief   ModelHistory unit tests
#
# @author  Akiya Jouraku (Ruby conversion)
# @author  Sarah Keating
#
# $Id$
# $HeadURL$
#
# This test file was converted from src/sbml/test/TestModelHistory_newSetters.c
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

class TestModelHistory_newSetters < Test::Unit::TestCase

  def test_ModelHistory_addCreator1
    mh = LibSBML::ModelHistory.new()
    mc = LibSBML::ModelCreator.new()
    mc.setFamilyName( "Keating")
    mc.setGivenName( "Sarah")
    i = mh.addCreator(mc)
    assert( i == LibSBML::LIBSBML_OPERATION_SUCCESS )
    assert( mh.getNumCreators() == 1 )
    mc = nil
    mh = nil
  end

  def test_ModelHistory_addCreator2
    mh = LibSBML::ModelHistory.new()
    mc = LibSBML::ModelCreator.new()
    mc.setGivenName( "Sarah")
    i = mh.addCreator(mc)
    assert( i == LibSBML::LIBSBML_INVALID_OBJECT )
    assert( mh.getNumCreators() == 0 )
    mc = nil
    mh = nil
  end

  def test_ModelHistory_addCreator3
    mh = LibSBML::ModelHistory.new()
    mc = nil
    i = mh.addCreator(mc)
    assert( i == LibSBML::LIBSBML_OPERATION_FAILED )
    assert( mh.getNumCreators() == 0 )
    mh = nil
  end

  def test_ModelHistory_setCreatedDate1
    mh = LibSBML::ModelHistory.new()
    assert( mh != nil )
    date = LibSBML::Date.new("2005-12-30T12:15:32+02:00")
    i = mh.setCreatedDate(date)
    assert( i == LibSBML::LIBSBML_OPERATION_SUCCESS )
    assert( mh.isSetCreatedDate() == true )
    assert( date != mh.getCreatedDate() )
    dateChar = mh.getCreatedDate().getDateAsString()
    assert ((  "2005-12-30T12:15:32+02:00" == dateChar ))
    i = mh.setCreatedDate(nil)
    assert( i == LibSBML::LIBSBML_OPERATION_SUCCESS )
    assert( mh.isSetCreatedDate() == false )
    date = nil
    mh = nil
  end

  def test_ModelHistory_setCreatedDate2
    mh = LibSBML::ModelHistory.new()
    assert( mh != nil )
    date = LibSBML::Date.new("Jan 12")
    i = mh.setCreatedDate(date)
    assert( i == LibSBML::LIBSBML_INVALID_OBJECT )
    assert( mh.isSetCreatedDate() == false )
    date = nil
    mh = nil
  end

  def test_ModelHistory_setModifiedDate1
    mh = LibSBML::ModelHistory.new()
    assert( mh != nil )
    date = LibSBML::Date.new("2005-12-30T12:15:32+02:00")
    i = mh.setModifiedDate(date)
    assert( i == LibSBML::LIBSBML_OPERATION_SUCCESS )
    assert( mh.isSetModifiedDate() == true )
    assert( date != mh.getModifiedDate() )
    dateChar = mh.getModifiedDate().getDateAsString()
    assert ((  "2005-12-30T12:15:32+02:00" == dateChar ))
    i = mh.setModifiedDate(nil)
    assert( i == LibSBML::LIBSBML_OPERATION_FAILED )
    assert( mh.isSetModifiedDate() == true )
    date = nil
    mh = nil
  end

  def test_ModelHistory_setModifiedDate2
    mh = LibSBML::ModelHistory.new()
    assert( mh != nil )
    date = LibSBML::Date.new(200,13,76,56,89,90,0,0,0)
    i = mh.setModifiedDate(date)
    assert( i == LibSBML::LIBSBML_INVALID_OBJECT )
    assert( mh.isSetModifiedDate() == false )
    date = nil
    mh = nil
  end

end