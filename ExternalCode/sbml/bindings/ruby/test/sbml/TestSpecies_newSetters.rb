#
# @file    TestSpecies_newSetters.rb
# @brief   Species unit tests for new set function API
#
# @author  Akiya Jouraku (Ruby conversion)
# @author  Sarah Keating 
#
# $Id$
# $HeadURL$
#
# This test file was converted from src/sbml/test/TestSpecies_newSetters.c
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

class TestSpecies_newSetters < Test::Unit::TestCase

  def setup
    @@c = LibSBML::Species.new(1,2)
    if (@@c == nil)
    end
  end

  def teardown
    @@c = nil
  end

  def test_Species_setBoundaryCondition1
    i = @@c.setBoundaryCondition(false)
    assert( i == LibSBML::LIBSBML_OPERATION_SUCCESS )
    assert( @@c.getBoundaryCondition() == false )
    i = @@c.setBoundaryCondition(true)
    assert( i == LibSBML::LIBSBML_OPERATION_SUCCESS )
    assert( @@c.getBoundaryCondition() == true )
  end

  def test_Species_setCharge1
    i = @@c.setCharge(2)
    assert( i == LibSBML::LIBSBML_OPERATION_SUCCESS )
    assert_equal true, @@c.isSetCharge()
    assert( @@c.getCharge() == 2 )
    i = @@c.unsetCharge()
    assert( i == LibSBML::LIBSBML_OPERATION_SUCCESS )
    assert_equal false, @@c.isSetCharge()
  end

  def test_Species_setCharge2
    c = LibSBML::Species.new(2,2)
    i = c.setCharge(4)
    assert( i == LibSBML::LIBSBML_UNEXPECTED_ATTRIBUTE )
    assert_equal false, c.isSetCharge()
    c = nil
  end

  def test_Species_setCharge3
    c = LibSBML::Species.new(2,1)
    i = c.unsetCharge()
    assert( i == LibSBML::LIBSBML_OPERATION_SUCCESS )
    assert_equal false, c.isSetCharge()
    c = nil
  end

  def test_Species_setCompartment1
    i = @@c.setCompartment( "1cell")
    assert( i == LibSBML::LIBSBML_INVALID_ATTRIBUTE_VALUE )
    assert_equal false, @@c.isSetCompartment()
    i = @@c.setCompartment( "")
    assert( i == LibSBML::LIBSBML_OPERATION_SUCCESS )
    assert_equal false, @@c.isSetCompartment()
  end

  def test_Species_setCompartment2
    i = @@c.setCompartment( "cell")
    assert( i == LibSBML::LIBSBML_OPERATION_SUCCESS )
    assert_equal true, @@c.isSetCompartment()
    i = @@c.setCompartment( "")
    assert( i == LibSBML::LIBSBML_OPERATION_SUCCESS )
    assert_equal false, @@c.isSetCompartment()
  end

  def test_Species_setConstant1
    i = @@c.setConstant(false)
    assert( i == LibSBML::LIBSBML_UNEXPECTED_ATTRIBUTE )
    assert( @@c.getConstant() == false )
  end

  def test_Species_setConstant2
    c = LibSBML::Species.new(2,2)
    i = c.setConstant(true)
    assert( i == LibSBML::LIBSBML_OPERATION_SUCCESS )
    assert( c.getConstant() == true )
    c = nil
  end

  def test_Species_setHasOnlySubstanceUnits1
    i = @@c.setHasOnlySubstanceUnits(false)
    assert( @@c.getHasOnlySubstanceUnits() == false )
    assert( i == LibSBML::LIBSBML_UNEXPECTED_ATTRIBUTE )
  end

  def test_Species_setHasOnlySubstanceUnits2
    c = LibSBML::Species.new(2,2)
    i = c.setHasOnlySubstanceUnits(false)
    assert( i == LibSBML::LIBSBML_OPERATION_SUCCESS )
    assert( c.getHasOnlySubstanceUnits() == false )
    i = c.setHasOnlySubstanceUnits(true)
    assert( i == LibSBML::LIBSBML_OPERATION_SUCCESS )
    assert( c.getHasOnlySubstanceUnits() == true )
    c = nil
  end

  def test_Species_setId2
    c = LibSBML::Species.new(2,2)
    i = c.setId( "1cell")
    assert( i == LibSBML::LIBSBML_INVALID_ATTRIBUTE_VALUE )
    assert_equal false, c.isSetId()
    c = nil
  end

  def test_Species_setId3
    c = LibSBML::Species.new(2,2)
    i = c.setId( "cell")
    assert( i == LibSBML::LIBSBML_OPERATION_SUCCESS )
    assert_equal true, c.isSetId()
    assert ((  "cell"  == c.getId() ))
    c = nil
  end

  def test_Species_setId4
    c = LibSBML::Species.new(2,2)
    i = c.setId( "cell")
    assert( i == LibSBML::LIBSBML_OPERATION_SUCCESS )
    assert_equal true, c.isSetId()
    assert ((  "cell"  == c.getId() ))
    i = c.setId("")
    assert( i == LibSBML::LIBSBML_OPERATION_SUCCESS )
    assert_equal false, c.isSetId()
    c = nil
  end

  def test_Species_setInitialAmount1
    i = @@c.setInitialAmount(2.0)
    assert( i == LibSBML::LIBSBML_OPERATION_SUCCESS )
    assert( @@c.getInitialAmount() == 2.0 )
    assert_equal true, @@c.isSetInitialAmount()
    i = @@c.unsetInitialAmount()
    assert( i == LibSBML::LIBSBML_OPERATION_SUCCESS )
    assert_equal false, @@c.isSetInitialAmount()
  end

  def test_Species_setInitialAmount2
    c = LibSBML::Species.new(2,2)
    i = c.setInitialAmount(4)
    assert( i == LibSBML::LIBSBML_OPERATION_SUCCESS )
    assert( c.getInitialAmount() == 4.0 )
    assert_equal true, c.isSetInitialAmount()
    i = c.unsetInitialAmount()
    assert( i == LibSBML::LIBSBML_OPERATION_SUCCESS )
    assert_equal false, c.isSetInitialAmount()
    c = nil
  end

  def test_Species_setInitialConcentration1
    i = @@c.setInitialConcentration(2.0)
    assert( i == LibSBML::LIBSBML_UNEXPECTED_ATTRIBUTE )
    assert_equal false, @@c.isSetInitialConcentration()
  end

  def test_Species_setInitialConcentration2
    c = LibSBML::Species.new(2,2)
    i = c.setInitialConcentration(4)
    assert( i == LibSBML::LIBSBML_OPERATION_SUCCESS )
    assert( c.getInitialConcentration() == 4 )
    assert_equal true, c.isSetInitialConcentration()
    i = c.unsetInitialConcentration()
    assert( i == LibSBML::LIBSBML_OPERATION_SUCCESS )
    assert_equal false, c.isSetInitialConcentration()
    c = nil
  end

  def test_Species_setName1
    i = @@c.setName( "cell")
    assert( i == LibSBML::LIBSBML_OPERATION_SUCCESS )
    assert_equal true, @@c.isSetName()
    i = @@c.unsetName()
    assert( i == LibSBML::LIBSBML_OPERATION_SUCCESS )
    assert_equal false, @@c.isSetName()
  end

  def test_Species_setName2
    c = LibSBML::Species.new(2,2)
    i = c.setName( "1cell")
    assert( i == LibSBML::LIBSBML_OPERATION_SUCCESS )
    assert_equal true, c.isSetName()
    i = c.unsetName()
    assert( i == LibSBML::LIBSBML_OPERATION_SUCCESS )
    assert_equal false, c.isSetName()
    c = nil
  end

  def test_Species_setName3
    i = @@c.setName( "cell")
    assert( i == LibSBML::LIBSBML_OPERATION_SUCCESS )
    assert_equal true, @@c.isSetName()
    i = @@c.setName("")
    assert( i == LibSBML::LIBSBML_OPERATION_SUCCESS )
    assert_equal false, @@c.isSetName()
  end

  def test_Species_setSpatialSizeUnits1
    i = @@c.setSpatialSizeUnits( "mm")
    assert( i == LibSBML::LIBSBML_UNEXPECTED_ATTRIBUTE )
    assert_equal false, @@c.isSetSpatialSizeUnits()
  end

  def test_Species_setSpatialSizeUnits2
    c = LibSBML::Species.new(2,2)
    i = c.setSpatialSizeUnits( "1cell")
    assert( i == LibSBML::LIBSBML_INVALID_ATTRIBUTE_VALUE )
    assert_equal false, c.isSetSpatialSizeUnits()
    c = nil
  end

  def test_Species_setSpatialSizeUnits3
    c = LibSBML::Species.new(2,2)
    i = c.setSpatialSizeUnits( "mole")
    assert( i == LibSBML::LIBSBML_OPERATION_SUCCESS )
    assert ((  "mole" == c.getSpatialSizeUnits() ))
    assert_equal true, c.isSetSpatialSizeUnits()
    c = nil
  end

  def test_Species_setSpatialSizeUnits4
    c = LibSBML::Species.new(2,2)
    i = c.setSpatialSizeUnits("")
    assert( i == LibSBML::LIBSBML_OPERATION_SUCCESS )
    assert_equal false, c.isSetSpatialSizeUnits()
    c = nil
  end

  def test_Species_setSpeciesType1
    i = @@c.setSpeciesType( "cell")
    assert( i == LibSBML::LIBSBML_UNEXPECTED_ATTRIBUTE )
    assert_equal false, @@c.isSetSpeciesType()
    i = @@c.unsetSpeciesType()
    assert( i == LibSBML::LIBSBML_OPERATION_SUCCESS )
    assert_equal false, @@c.isSetSpeciesType()
  end

  def test_Species_setSpeciesType2
    c = LibSBML::Species.new(2,2)
    i = c.setSpeciesType( "1cell")
    assert( i == LibSBML::LIBSBML_INVALID_ATTRIBUTE_VALUE )
    assert_equal false, c.isSetSpeciesType()
    i = c.unsetSpeciesType()
    assert( i == LibSBML::LIBSBML_OPERATION_SUCCESS )
    assert_equal false, c.isSetSpeciesType()
    c = nil
  end

  def test_Species_setSpeciesType3
    c = LibSBML::Species.new(2,2)
    i = c.setSpeciesType( "cell")
    assert( i == LibSBML::LIBSBML_OPERATION_SUCCESS )
    assert_equal true, c.isSetSpeciesType()
    assert ((  "cell"  == c.getSpeciesType() ))
    i = c.unsetSpeciesType()
    assert( i == LibSBML::LIBSBML_OPERATION_SUCCESS )
    assert_equal false, c.isSetSpeciesType()
    c = nil
  end

  def test_Species_setSpeciesType4
    c = LibSBML::Species.new(2,2)
    i = c.setSpeciesType( "cell")
    assert( i == LibSBML::LIBSBML_OPERATION_SUCCESS )
    assert_equal true, c.isSetSpeciesType()
    assert ((  "cell"  == c.getSpeciesType() ))
    i = c.setSpeciesType("")
    assert( i == LibSBML::LIBSBML_OPERATION_SUCCESS )
    assert_equal false, c.isSetSpeciesType()
    c = nil
  end

  def test_Species_setSubstanceUnits1
    i = @@c.setSubstanceUnits( "mm")
    assert( i == LibSBML::LIBSBML_OPERATION_SUCCESS )
    assert_equal true, @@c.isSetSubstanceUnits()
  end

  def test_Species_setSubstanceUnits2
    c = LibSBML::Species.new(2,2)
    i = c.setSubstanceUnits( "1cell")
    assert( i == LibSBML::LIBSBML_INVALID_ATTRIBUTE_VALUE )
    assert_equal false, c.isSetSubstanceUnits()
    c = nil
  end

  def test_Species_setSubstanceUnits3
    c = LibSBML::Species.new(2,2)
    i = c.setSubstanceUnits( "mole")
    assert( i == LibSBML::LIBSBML_OPERATION_SUCCESS )
    assert ((  "mole" == c.getSubstanceUnits() ))
    assert_equal true, c.isSetSubstanceUnits()
    c = nil
  end

  def test_Species_setSubstanceUnits4
    c = LibSBML::Species.new(2,2)
    i = c.setSubstanceUnits( "mole")
    assert( i == LibSBML::LIBSBML_OPERATION_SUCCESS )
    assert ((  "mole" == c.getSubstanceUnits() ))
    assert_equal true, c.isSetSubstanceUnits()
    i = c.setSubstanceUnits("")
    assert( i == LibSBML::LIBSBML_OPERATION_SUCCESS )
    assert_equal false, c.isSetSubstanceUnits()
    c = nil
  end

  def test_Species_setUnits1
    i = @@c.setUnits( "1cell")
    assert( i == LibSBML::LIBSBML_INVALID_ATTRIBUTE_VALUE )
    assert_equal false, @@c.isSetUnits()
    i = @@c.unsetUnits()
    assert( i == LibSBML::LIBSBML_OPERATION_SUCCESS )
    assert_equal false, @@c.isSetUnits()
  end

  def test_Species_setUnits2
    i = @@c.setUnits( "litre")
    assert( i == LibSBML::LIBSBML_OPERATION_SUCCESS )
    assert_equal true, @@c.isSetUnits()
    i = @@c.unsetUnits()
    assert( i == LibSBML::LIBSBML_OPERATION_SUCCESS )
    assert_equal false, @@c.isSetUnits()
  end

  def test_Species_setUnits3
    i = @@c.setUnits( "litre")
    assert( i == LibSBML::LIBSBML_OPERATION_SUCCESS )
    assert_equal true, @@c.isSetUnits()
    i = @@c.setUnits("")
    assert( i == LibSBML::LIBSBML_OPERATION_SUCCESS )
    assert_equal false, @@c.isSetUnits()
  end

end
