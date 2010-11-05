#
# @file    TestSpeciesType.rb
# @brief   SpeciesType unit tests
#
# @author  Akiya Jouraku (Ruby conversion)
# @author  Sarah Keating 
#
# $Id: TestSpeciesType.rb 10124 2009-08-28 12:04:51Z sarahkeating $
# $HeadURL: https://sbml.svn.sourceforge.net/svnroot/sbml/trunk/libsbml/src/bindings/ruby/test/sbml/TestSpeciesType.rb $
#
# This test file was converted from src/sbml/test/TestSpeciesType.c
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

class TestSpeciesType < Test::Unit::TestCase

  def setup
    @@ct = LibSBML::SpeciesType.new(2,4)
    if (@@ct == nil)
    end
  end

  def teardown
    @@ct = nil
  end

  def test_SpeciesType_create
    assert( @@ct.getTypeCode() == LibSBML::SBML_SPECIES_TYPE )
    assert( @@ct.getMetaId() == "" )
    assert( @@ct.getNotes() == nil )
    assert( @@ct.getAnnotation() == nil )
    assert( @@ct.getId() == "" )
    assert( @@ct.getName() == "" )
    assert_equal false, @@ct.isSetId()
    assert_equal false, @@ct.isSetName()
  end

  def test_SpeciesType_createWithNS
    xmlns = LibSBML::XMLNamespaces.new()
    xmlns.add( "http://www.sbml.org", "testsbml")
    sbmlns = LibSBML::SBMLNamespaces.new(2,2)
    sbmlns.addNamespaces(xmlns)
    object = LibSBML::SpeciesType.new(sbmlns)
    assert( object.getTypeCode() == LibSBML::SBML_SPECIES_TYPE )
    assert( object.getMetaId() == "" )
    assert( object.getNotes() == nil )
    assert( object.getAnnotation() == nil )
    assert( object.getLevel() == 2 )
    assert( object.getVersion() == 2 )
    assert( object.getNamespaces() != nil )
    assert( object.getNamespaces().getLength() == 2 )
    object = nil
  end

  def test_SpeciesType_free_NULL
  end

  def test_SpeciesType_setId
    id =  "mitochondria";
    @@ct.setId(id)
    assert (( id == @@ct.getId() ))
    assert_equal true, @@ct.isSetId()
    if (@@ct.getId() == id)
    end
    @@ct.setId(@@ct.getId())
    assert (( id == @@ct.getId() ))
    @@ct.setId("")
    assert_equal false, @@ct.isSetId()
    if (@@ct.getId() != nil)
    end
  end

  def test_SpeciesType_setName
    name =  "My_Favorite_Factory";
    @@ct.setName(name)
    assert (( name == @@ct.getName() ))
    assert_equal true, @@ct.isSetName()
    if (@@ct.getName() == name)
    end
    @@ct.setName(@@ct.getName())
    assert (( name == @@ct.getName() ))
    @@ct.setName("")
    assert_equal false, @@ct.isSetName()
    if (@@ct.getName() != nil)
    end
  end

  def test_SpeciesType_unsetName
    @@ct.setName( "name")
    assert ((  "name"      == @@ct.getName() ))
    assert_equal true, @@ct.isSetName()
    @@ct.unsetName()
    assert_equal false, @@ct.isSetName()
  end

end