#
# @file    TestEvent_newSetters.rb
# @brief   Event unit tests for new set function API
#
# @author  Akiya Jouraku (Ruby conversion)
# @author  Sarah Keating 
#
# $Id$
# $HeadURL$
#
# This test file was converted from src/sbml/test/TestEvent_newSetters.c
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

class TestEvent_newSetters < Test::Unit::TestCase

  def setup
    @@e = LibSBML::Event.new(2,4)
    if (@@e == nil)
    end
  end

  def teardown
    @@e = nil
  end

  def test_Event_addEventAssignment1
    e = LibSBML::Event.new(2,2)
    ea = LibSBML::EventAssignment.new(2,2)
    i = e.addEventAssignment(ea)
    assert( i == LibSBML::LIBSBML_INVALID_OBJECT )
    ea.setVariable( "f")
    i = e.addEventAssignment(ea)
    assert( i == LibSBML::LIBSBML_INVALID_OBJECT )
    ea.setMath(LibSBML::parseFormula("a-n"))
    i = e.addEventAssignment(ea)
    assert( i == LibSBML::LIBSBML_OPERATION_SUCCESS )
    assert( e.getNumEventAssignments() == 1 )
    ea = nil
    e = nil
  end

  def test_Event_addEventAssignment2
    e = LibSBML::Event.new(2,2)
    ea = LibSBML::EventAssignment.new(2,3)
    ea.setVariable( "f")
    ea.setMath(LibSBML::parseFormula("a-n"))
    i = e.addEventAssignment(ea)
    assert( i == LibSBML::LIBSBML_VERSION_MISMATCH )
    assert( e.getNumEventAssignments() == 0 )
    ea = nil
    e = nil
  end

  def test_Event_addEventAssignment3
    e = LibSBML::Event.new(2,2)
    i = e.addEventAssignment(nil)
    assert( i == LibSBML::LIBSBML_OPERATION_FAILED )
    assert( e.getNumEventAssignments() == 0 )
    e = nil
  end

  def test_Event_addEventAssignment4
    e = LibSBML::Event.new(2,2)
    ea = LibSBML::EventAssignment.new(2,2)
    ea.setVariable( "c")
    ea.setMath(LibSBML::parseFormula("a-n"))
    ea1 = LibSBML::EventAssignment.new(2,2)
    ea1.setVariable( "c")
    ea1.setMath(LibSBML::parseFormula("a-n"))
    i = e.addEventAssignment(ea)
    assert( i == LibSBML::LIBSBML_OPERATION_SUCCESS )
    assert( e.getNumEventAssignments() == 1 )
    i = e.addEventAssignment(ea1)
    assert( i == LibSBML::LIBSBML_DUPLICATE_OBJECT_ID )
    assert( e.getNumEventAssignments() == 1 )
    ea = nil
    ea1 = nil
    e = nil
  end

  def test_Event_createEventAssignment
    e = LibSBML::Event.new(2,2)
    ea = e.createEventAssignment()
    assert( e.getNumEventAssignments() == 1 )
    assert( (ea).getLevel() == 2 )
    assert( (ea).getVersion() == 2 )
    e = nil
  end

  def test_Event_setDelay1
    math1 = LibSBML::parseFormula("0")
    delay = LibSBML::Delay.new(2,4)
    delay.setMath(math1)
    i = @@e.setDelay(delay)
    assert( i == LibSBML::LIBSBML_OPERATION_SUCCESS )
    assert( @@e.getDelay() != nil )
    assert_equal true, @@e.isSetDelay()
    i = @@e.unsetDelay()
    assert( i == LibSBML::LIBSBML_OPERATION_SUCCESS )
    assert_equal false, @@e.isSetDelay()
  end

  def test_Event_setDelay2
    delay = LibSBML::Delay.new(2,1)
    i = @@e.setDelay(delay)
    assert( i == LibSBML::LIBSBML_VERSION_MISMATCH )
    assert_equal false, @@e.isSetDelay()
    i = @@e.unsetDelay()
    assert( i == LibSBML::LIBSBML_OPERATION_SUCCESS )
  end

  def test_Event_setId1
    id =  "1e1";
    i = @@e.setId(id)
    assert( i == LibSBML::LIBSBML_INVALID_ATTRIBUTE_VALUE )
    assert_equal false, @@e.isSetId()
  end

  def test_Event_setId2
    id =  "e1";
    i = @@e.setId(id)
    assert( i == LibSBML::LIBSBML_OPERATION_SUCCESS )
    assert (( id == @@e.getId() ))
    assert_equal true, @@e.isSetId()
    i = @@e.unsetId()
    assert( i == LibSBML::LIBSBML_OPERATION_SUCCESS )
    assert_equal false, @@e.isSetId()
  end

  def test_Event_setId3
    i = @@e.setId("")
    assert( i == LibSBML::LIBSBML_OPERATION_SUCCESS )
    assert_equal false, @@e.isSetId()
  end

  def test_Event_setName1
    name =  "3Set_k2";
    i = @@e.setName(name)
    assert( i == LibSBML::LIBSBML_OPERATION_SUCCESS )
    assert_equal true, @@e.isSetName()
  end

  def test_Event_setName2
    name =  "Set k2";
    i = @@e.setName(name)
    assert( i == LibSBML::LIBSBML_OPERATION_SUCCESS )
    assert (( name == @@e.getName() ))
    assert_equal true, @@e.isSetName()
    i = @@e.unsetName()
    assert( i == LibSBML::LIBSBML_OPERATION_SUCCESS )
    assert_equal false, @@e.isSetName()
  end

  def test_Event_setName3
    i = @@e.setName("")
    assert( i == LibSBML::LIBSBML_OPERATION_SUCCESS )
    assert_equal false, @@e.isSetName()
  end

  def test_Event_setTimeUnits1
    units =  "second";
    i = @@e.setTimeUnits(units)
    assert( i == LibSBML::LIBSBML_UNEXPECTED_ATTRIBUTE )
    assert_equal false, @@e.isSetTimeUnits()
  end

  def test_Event_setTimeUnits2
    units =  "second";
    e = LibSBML::Event.new(2,1)
    i = e.setTimeUnits(units)
    assert( i == LibSBML::LIBSBML_OPERATION_SUCCESS )
    assert (( units == e.getTimeUnits() ))
    assert_equal true, e.isSetTimeUnits()
    i = e.unsetTimeUnits()
    assert( i == LibSBML::LIBSBML_OPERATION_SUCCESS )
    assert_equal false, e.isSetTimeUnits()
    e = nil
  end

  def test_Event_setTimeUnits3
    units =  "1second";
    e = LibSBML::Event.new(2,1)
    i = e.setTimeUnits(units)
    assert( i == LibSBML::LIBSBML_INVALID_ATTRIBUTE_VALUE )
    assert_equal false, e.isSetTimeUnits()
    i = e.unsetTimeUnits()
    assert( i == LibSBML::LIBSBML_OPERATION_SUCCESS )
    assert_equal false, e.isSetTimeUnits()
    e = nil
  end

  def test_Event_setTimeUnits4
    e = LibSBML::Event.new(2,1)
    i = e.setTimeUnits("")
    assert( i == LibSBML::LIBSBML_OPERATION_SUCCESS )
    assert_equal false, e.isSetTimeUnits()
    e = nil
  end

  def test_Event_setTrigger1
    trigger = LibSBML::Trigger.new(2,1)
    i = @@e.setTrigger(trigger)
    assert( i == LibSBML::LIBSBML_VERSION_MISMATCH )
    assert_equal false, @@e.isSetTrigger()
  end

  def test_Event_setTrigger2
    math1 = LibSBML::parseFormula("0")
    trigger = LibSBML::Trigger.new(2,4)
    trigger.setMath(math1)
    i = @@e.setTrigger(trigger)
    assert( i == LibSBML::LIBSBML_OPERATION_SUCCESS )
    assert( @@e.getTrigger() != nil )
    assert_equal true, @@e.isSetTrigger()
  end

  def test_Event_setUseValuesFromTriggerTime1
    e = LibSBML::Event.new(2,4)
    i = e.setUseValuesFromTriggerTime(false)
    assert( i == LibSBML::LIBSBML_OPERATION_SUCCESS )
    assert( e.getUseValuesFromTriggerTime() == false )
    i = e.setUseValuesFromTriggerTime(true)
    assert( i == LibSBML::LIBSBML_OPERATION_SUCCESS )
    assert( e.getUseValuesFromTriggerTime() == true )
    e = nil
  end

  def test_Event_setUseValuesFromTriggerTime2
    e = LibSBML::Event.new(2,2)
    i = e.setUseValuesFromTriggerTime(false)
    assert( i == LibSBML::LIBSBML_UNEXPECTED_ATTRIBUTE )
    e = nil
  end

end
