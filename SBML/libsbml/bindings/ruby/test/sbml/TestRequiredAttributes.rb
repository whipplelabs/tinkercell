#
# @file    TestRequiredAttributes.rb
# @brief   Test hasRequiredAttributes unit tests
#
# @author  Akiya Jouraku (Ruby conversion)
# @author  Ben Bornstein 
#
# $Id$
# $HeadURL$
#
# This test file was converted from src/sbml/test/TestRequiredAttributes.cpp
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

class TestRequiredAttributes < Test::Unit::TestCase

  def test_AlgebraicRule
    ar = LibSBML::AlgebraicRule.new(2,4)
    assert_equal true, ar.hasRequiredAttributes()
    ar = nil
  end

  def test_AlgebraicRule_L1
    ar = LibSBML::AlgebraicRule.new(1,2)
    assert_equal false, (ar.hasRequiredAttributes())
    ar.setFormula("ar")
    assert_equal true, ar.hasRequiredAttributes()
    ar = nil
  end

  def test_AssignmentRule
    r = LibSBML::AssignmentRule.new(2,4)
    assert_equal false, (r.hasRequiredAttributes())
    r.setVariable("r")
    assert_equal true, r.hasRequiredAttributes()
    r = nil
  end

  def test_AssignmentRule_L1
    r = LibSBML::AssignmentRule.new(1,2)
    assert_equal false, (r.hasRequiredAttributes())
    r.setVariable("r")
    assert_equal false, (r.hasRequiredAttributes())
    r.setFormula("r")
    assert_equal true, r.hasRequiredAttributes()
    r = nil
  end

  def test_Compartment
    c = LibSBML::Compartment.new(2,4)
    assert_equal false, (c.hasRequiredAttributes())
    c.setId("c")
    assert_equal true, c.hasRequiredAttributes()
    c = nil
  end

  def test_CompartmentType
    ct = LibSBML::CompartmentType.new(2,4)
    assert_equal false, (ct.hasRequiredAttributes())
    ct.setId("c")
    assert_equal true, ct.hasRequiredAttributes()
    ct = nil
  end

  def test_Constraint
    c = LibSBML::Constraint.new(2,4)
    assert_equal true, c.hasRequiredAttributes()
    c = nil
  end

  def test_Delay
    d = LibSBML::Delay.new(2,4)
    assert_equal true, d.hasRequiredAttributes()
    d = nil
  end

  def test_Event
    e = LibSBML::Event.new(2,4)
    assert_equal true, e.hasRequiredAttributes()
    e = nil
  end

  def test_EventAssignment
    ea = LibSBML::EventAssignment.new(2,4)
    assert_equal false, (ea.hasRequiredAttributes())
    ea.setVariable("ea")
    assert_equal true, ea.hasRequiredAttributes()
    ea = nil
  end

  def test_FunctionDefinition
    fd = LibSBML::FunctionDefinition.new(2,4)
    assert_equal false, (fd.hasRequiredAttributes())
    fd.setId("fd")
    assert_equal true, fd.hasRequiredAttributes()
    fd = nil
  end

  def test_InitialAssignment
    ia = LibSBML::InitialAssignment.new(2,4)
    assert_equal false, (ia.hasRequiredAttributes())
    ia.setSymbol("ia")
    assert_equal true, ia.hasRequiredAttributes()
    ia = nil
  end

  def test_KineticLaw
    kl = LibSBML::KineticLaw.new(2,4)
    assert_equal true, kl.hasRequiredAttributes()
    kl = nil
  end

  def test_KineticLaw_L1
    kl = LibSBML::KineticLaw.new(1,2)
    assert_equal false, (kl.hasRequiredAttributes())
    kl.setFormula("kl")
    assert_equal true, kl.hasRequiredAttributes()
    kl = nil
  end

  def test_Model
    m = LibSBML::Model.new(2,4)
    assert_equal true, m.hasRequiredAttributes()
    m = nil
  end

  def test_ModifierSpeciesReference
    msr = LibSBML::ModifierSpeciesReference.new(2,4)
    assert_equal false, (msr.hasRequiredAttributes())
    msr.setSpecies("msr")
    assert_equal true, msr.hasRequiredAttributes()
    msr = nil
  end

  def test_Parameter
    p = LibSBML::Parameter.new(2,4)
    assert_equal false, (p.hasRequiredAttributes())
    p.setId("p")
    assert_equal true, p.hasRequiredAttributes()
    p = nil
  end

  def test_Parameter_L1V1
    p = LibSBML::Parameter.new(1,1)
    assert_equal false, (p.hasRequiredAttributes())
    p.setId("p")
    assert_equal false, (p.hasRequiredAttributes())
    p.setValue(12)
    assert_equal true, p.hasRequiredAttributes()
    p = nil
  end

  def test_RateRule
    r = LibSBML::RateRule.new(2,4)
    assert_equal false, (r.hasRequiredAttributes())
    r.setVariable("r")
    assert_equal true, r.hasRequiredAttributes()
    r = nil
  end

  def test_RateRule_L1
    r = LibSBML::RateRule.new(1,2)
    assert_equal false, (r.hasRequiredAttributes())
    r.setVariable("r")
    assert_equal false, (r.hasRequiredAttributes())
    r.setFormula("r")
    assert_equal true, r.hasRequiredAttributes()
    r = nil
  end

  def test_Reaction
    r = LibSBML::Reaction.new(2,4)
    assert_equal false, (r.hasRequiredAttributes())
    r.setId("r")
    assert_equal true, r.hasRequiredAttributes()
    r = nil
  end

  def test_Species
    s = LibSBML::Species.new(2,4)
    assert_equal false, (s.hasRequiredAttributes())
    s.setId("s")
    assert_equal false, (s.hasRequiredAttributes())
    s.setCompartment("c")
    assert_equal true, s.hasRequiredAttributes()
    s = nil
  end

  def test_SpeciesReference
    sr = LibSBML::SpeciesReference.new(2,4)
    assert_equal false, (sr.hasRequiredAttributes())
    sr.setSpecies("sr")
    assert_equal true, sr.hasRequiredAttributes()
    sr = nil
  end

  def test_SpeciesType
    st = LibSBML::SpeciesType.new(2,4)
    assert_equal false, (st.hasRequiredAttributes())
    st.setId("st")
    assert_equal true, st.hasRequiredAttributes()
    st = nil
  end

  def test_Species_L1
    s = LibSBML::Species.new(1,2)
    assert_equal false, (s.hasRequiredAttributes())
    s.setId("s")
    assert_equal false, (s.hasRequiredAttributes())
    s.setCompartment("c")
    assert_equal false, (s.hasRequiredAttributes())
    s.setInitialAmount(2)
    assert_equal true, s.hasRequiredAttributes()
    s = nil
  end

  def test_StoichiometryMath
    sm = LibSBML::StoichiometryMath.new(2,4)
    assert_equal true, sm.hasRequiredAttributes()
    sm = nil
  end

  def test_Trigger
    t = LibSBML::Trigger.new(2,4)
    assert_equal true, t.hasRequiredAttributes()
    t = nil
  end

  def test_Unit
    u = LibSBML::Unit.new(2,4)
    assert_equal false, (u.hasRequiredAttributes())
    u.setKind(LibSBML::UNIT_KIND_MOLE)
    assert_equal true, u.hasRequiredAttributes()
    u = nil
  end

  def test_UnitDefinition
    ud = LibSBML::UnitDefinition.new(2,4)
    assert_equal false, (ud.hasRequiredAttributes())
    ud.setId("ud")
    assert_equal true, ud.hasRequiredAttributes()
    ud = nil
  end

end
