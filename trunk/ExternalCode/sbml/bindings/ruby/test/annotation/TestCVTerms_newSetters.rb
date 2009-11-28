#
# @file    TestCVTerms_newSetters.rb
# @brief   CVTerms unit tests
#
# @author  Akiya Jouraku (Ruby conversion)
# @author  Sarah Keating 
#
# $Id$
# $HeadURL$
#
# This test file was converted from src/sbml/test/TestCVTerms_newSetters.c
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

class TestCVTerms_newSetters < Test::Unit::TestCase

  def test_CVTerm_addResource
    term = LibSBML::CVTerm.new(LibSBML::MODEL_QUALIFIER)
    resource =  "GO6666";
    assert( term != nil )
    assert( term.getQualifierType() == LibSBML::MODEL_QUALIFIER )
    i = term.addResource( "")
    assert( i == LibSBML::LIBSBML_OPERATION_FAILED )
    xa = term.getResources()
    assert( xa.getLength() == 0 )
    i = term.addResource(resource)
    assert( i == LibSBML::LIBSBML_OPERATION_SUCCESS )
    xa = term.getResources()
    assert( xa.getLength() == 1 )
    assert ((  "rdf:resource" == xa.getName(0) ))
    assert ((  "GO6666" == xa.getValue(0) ))
    term = nil
  end

  def test_CVTerm_removeResource
    term = LibSBML::CVTerm.new(LibSBML::MODEL_QUALIFIER)
    resource =  "GO6666";
    assert( term != nil )
    assert( term.getQualifierType() == LibSBML::MODEL_QUALIFIER )
    term.addResource(resource)
    xa = term.getResources()
    assert( xa.getLength() == 1 )
    i = term.removeResource( "CCC")
    assert( i == LibSBML::LIBSBML_INVALID_ATTRIBUTE_VALUE )
    xa = term.getResources()
    assert( xa.getLength() == 1 )
    i = term.removeResource(resource)
    assert( i == LibSBML::LIBSBML_OPERATION_SUCCESS )
    xa = term.getResources()
    assert( xa.getLength() == 0 )
    term = nil
  end

  def test_CVTerm_setBiolQualifierType
    term = LibSBML::CVTerm.new(LibSBML::BIOLOGICAL_QUALIFIER)
    assert( term != nil )
    assert( term.getQualifierType() == LibSBML::BIOLOGICAL_QUALIFIER )
    assert( term.getModelQualifierType() == LibSBML::BQM_UNKNOWN )
    assert( term.getBiologicalQualifierType() == LibSBML::BQB_UNKNOWN )
    i = term.setBiologicalQualifierType(LibSBML::BQB_IS)
    assert( i == LibSBML::LIBSBML_OPERATION_SUCCESS )
    assert( term.getQualifierType() == LibSBML::BIOLOGICAL_QUALIFIER )
    assert( term.getBiologicalQualifierType() == LibSBML::BQB_IS )
    assert( term.getModelQualifierType() == LibSBML::BQM_UNKNOWN )
    i = term.setQualifierType(LibSBML::MODEL_QUALIFIER)
    assert( i == LibSBML::LIBSBML_OPERATION_SUCCESS )
    assert( term.getQualifierType() == LibSBML::MODEL_QUALIFIER )
    assert( term.getModelQualifierType() == LibSBML::BQM_UNKNOWN )
    assert( term.getBiologicalQualifierType() == LibSBML::BQB_UNKNOWN )
    i = term.setBiologicalQualifierType(LibSBML::BQB_IS)
    assert( i == LibSBML::LIBSBML_INVALID_ATTRIBUTE_VALUE )
    assert( term.getQualifierType() == LibSBML::MODEL_QUALIFIER )
    assert( term.getModelQualifierType() == LibSBML::BQM_UNKNOWN )
    assert( term.getBiologicalQualifierType() == LibSBML::BQB_UNKNOWN )
    term = nil
  end

  def test_CVTerm_setModelQualifierType
    term = LibSBML::CVTerm.new(LibSBML::MODEL_QUALIFIER)
    assert( term != nil )
    assert( term.getQualifierType() == LibSBML::MODEL_QUALIFIER )
    assert( term.getModelQualifierType() == LibSBML::BQM_UNKNOWN )
    assert( term.getBiologicalQualifierType() == LibSBML::BQB_UNKNOWN )
    i = term.setModelQualifierType(LibSBML::BQM_IS)
    assert( i == LibSBML::LIBSBML_OPERATION_SUCCESS )
    assert( term.getQualifierType() == LibSBML::MODEL_QUALIFIER )
    assert( term.getModelQualifierType() == LibSBML::BQM_IS )
    assert( term.getBiologicalQualifierType() == LibSBML::BQB_UNKNOWN )
    i = term.setQualifierType(LibSBML::BIOLOGICAL_QUALIFIER)
    assert( i == LibSBML::LIBSBML_OPERATION_SUCCESS )
    assert( term.getQualifierType() == LibSBML::BIOLOGICAL_QUALIFIER )
    assert( term.getModelQualifierType() == LibSBML::BQM_UNKNOWN )
    assert( term.getBiologicalQualifierType() == LibSBML::BQB_UNKNOWN )
    i = term.setModelQualifierType(LibSBML::BQM_IS)
    assert( i == LibSBML::LIBSBML_INVALID_ATTRIBUTE_VALUE )
    assert( term.getQualifierType() == LibSBML::BIOLOGICAL_QUALIFIER )
    assert( term.getBiologicalQualifierType() == LibSBML::BQB_UNKNOWN )
    assert( term.getModelQualifierType() == LibSBML::BQM_UNKNOWN )
    term = nil
  end

end
