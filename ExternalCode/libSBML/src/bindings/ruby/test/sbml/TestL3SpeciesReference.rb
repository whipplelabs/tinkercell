# @file    TestL3SpeciesReference.rb
# @brief   L3 SpeciesReference unit tests
#
# @author  Akiya Jouraku (Ruby conversion)
# @author  Sarah Keating 
#
# $Id$
# $HeadURL$
#
# ====== WARNING ===== WARNING ===== WARNING ===== WARNING ===== WARNING ======
#
# DO NOT EDIT THIS FILE.
#
# This file was generated automatically by converting the file located at
# src/sbml/test/TestL3SpeciesReference.c
# using the conversion program dev/utilities/translateTests/translateTests.pl.
# Any changes made here will be lost the next time the file is regenerated.
#
# -----------------------------------------------------------------------------
# This file is part of libSBML.  Please visit http://sbml.org for more
# information about SBML, and the latest version of libSBML.
#
# Copyright 2005-2010 California Institute of Technology.
# Copyright 2002-2005 California Institute of Technology and
#                     Japan Science and Technology Corporation.
# 
# This library is free software; you can redistribute it and/or modify it
# under the terms of the GNU Lesser General Public License as published by
# the Free Software Foundation.  A copy of the license agreement is provided
# in the file named "LICENSE.txt" included with this software distribution
# and also available online as http://sbml.org/software/libsbml/license.html
# -----------------------------------------------------------------------------
require 'test/unit'
require 'libSBML'

class TestL3SpeciesReference < Test::Unit::TestCase

  def isnan(x)
    return (x != x)
  end
  def setup
    @@sr = LibSBML::SpeciesReference.new(3,1)
    if (@@sr == nil)
    end
  end

  def teardown
    @@sr = nil
  end

  def test_L3_SpeciesReference_NS
    assert( @@sr.getNamespaces() != nil )
    assert( @@sr.getNamespaces().getLength() == 1 )
    assert ((     "http://www.sbml.org/sbml/level3/version1/core" == @@sr.getNamespaces().getURI(0) ))
  end

  def test_L3_SpeciesReference_constant
    assert( @@sr.isSetConstant() == false )
    @@sr.setConstant(true)
    assert( @@sr.getConstant() == true )
    assert( @@sr.isSetConstant() == true )
    @@sr.setConstant(false)
    assert( @@sr.getConstant() == false )
    assert( @@sr.isSetConstant() == true )
  end

  def test_L3_SpeciesReference_create
    assert( @@sr.getTypeCode() == LibSBML::SBML_SPECIES_REFERENCE )
    assert( @@sr.getMetaId() == "" )
    assert( @@sr.getNotes() == nil )
    assert( @@sr.getAnnotation() == nil )
    assert( @@sr.getId() == "" )
    assert( @@sr.getName() == "" )
    assert( @@sr.getSpecies() == "" )
    assert_equal true, isnan(@@sr.getStoichiometry())
    assert( @@sr.getConstant() == false )
    assert_equal false, @@sr.isSetId()
    assert_equal false, @@sr.isSetName()
    assert_equal false, @@sr.isSetSpecies()
    assert_equal false, @@sr.isSetStoichiometry()
    assert_equal false, @@sr.isSetConstant()
  end

  def test_L3_SpeciesReference_createWithNS
    xmlns = LibSBML::XMLNamespaces.new()
    xmlns.add( "http://www.sbml.org", "testsbml")
    sbmlns = LibSBML::SBMLNamespaces.new(3,1)
    sbmlns.addNamespaces(xmlns)
    sr = LibSBML::SpeciesReference.new(sbmlns)
    assert( sr.getTypeCode() == LibSBML::SBML_SPECIES_REFERENCE )
    assert( sr.getMetaId() == "" )
    assert( sr.getNotes() == nil )
    assert( sr.getAnnotation() == nil )
    assert( sr.getLevel() == 3 )
    assert( sr.getVersion() == 1 )
    assert( sr.getNamespaces() != nil )
    assert( sr.getNamespaces().getLength() == 2 )
    assert( sr.getId() == "" )
    assert( sr.getName() == "" )
    assert( sr.getSpecies() == "" )
    assert_equal true, isnan(sr.getStoichiometry())
    assert( sr.getConstant() == false )
    assert_equal false, sr.isSetId()
    assert_equal false, sr.isSetName()
    assert_equal false, sr.isSetSpecies()
    assert_equal false, sr.isSetStoichiometry()
    assert_equal false, sr.isSetConstant()
    sr = nil
  end

  def test_L3_SpeciesReference_free_NULL
  end

  def test_L3_SpeciesReference_hasRequiredAttributes
    sr = LibSBML::SpeciesReference.new(3,1)
    assert_equal false, sr.hasRequiredAttributes()
    sr.setSpecies( "id")
    assert_equal false, sr.hasRequiredAttributes()
    sr.setConstant(false)
    assert_equal true, sr.hasRequiredAttributes()
    sr = nil
  end

  def test_L3_SpeciesReference_id
    id =  "mitochondria";
    assert_equal false, @@sr.isSetId()
    @@sr.setId(id)
    assert (( id == @@sr.getId() ))
    assert_equal true, @@sr.isSetId()
    if (@@sr.getId() == id)
    end
  end

  def test_L3_SpeciesReference_name
    name =  "My_Favorite_Factory";
    assert_equal false, @@sr.isSetName()
    @@sr.setName(name)
    assert (( name == @@sr.getName() ))
    assert_equal true, @@sr.isSetName()
    if (@@sr.getName() == name)
    end
    @@sr.unsetName()
    assert_equal false, @@sr.isSetName()
    if (@@sr.getName() != nil)
    end
  end

  def test_L3_SpeciesReference_species
    species =  "cell";
    assert_equal false, @@sr.isSetSpecies()
    @@sr.setSpecies(species)
    assert (( species == @@sr.getSpecies() ))
    assert_equal true, @@sr.isSetSpecies()
    if (@@sr.getSpecies() == species)
    end
  end

  def test_L3_SpeciesReference_stoichiometry
    stoichiometry = 0.2
    assert_equal false, @@sr.isSetStoichiometry()
    assert_equal true, isnan(@@sr.getStoichiometry())
    @@sr.setStoichiometry(stoichiometry)
    assert( @@sr.getStoichiometry() == stoichiometry )
    assert_equal true, @@sr.isSetStoichiometry()
    @@sr.unsetStoichiometry()
    assert_equal false, @@sr.isSetStoichiometry()
    assert_equal true, isnan(@@sr.getStoichiometry())
  end

end
