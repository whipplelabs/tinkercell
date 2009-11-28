#
# @file    TestEvent_newSetters.py
# @brief   Event unit tests for new set function API
#
# @author  Akiya Jouraku (Python conversion)
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
import sys
import unittest
import libsbml

class TestEvent_newSetters(unittest.TestCase):

  E = None

  def setUp(self):
    self.E = libsbml.Event(2,4)
    if (self.E == None):
      pass    
    pass  

  def tearDown(self):
    self.E = None
    pass  

  def test_Event_addEventAssignment1(self):
    e = libsbml.Event(2,2)
    ea = libsbml.EventAssignment(2,2)
    i = e.addEventAssignment(ea)
    self.assert_( i == libsbml.LIBSBML_INVALID_OBJECT )
    ea.setVariable( "f")
    i = e.addEventAssignment(ea)
    self.assert_( i == libsbml.LIBSBML_INVALID_OBJECT )
    ea.setMath(libsbml.parseFormula("a-n"))
    i = e.addEventAssignment(ea)
    self.assert_( i == libsbml.LIBSBML_OPERATION_SUCCESS )
    self.assert_( e.getNumEventAssignments() == 1 )
    ea = None
    e = None
    pass  

  def test_Event_addEventAssignment2(self):
    e = libsbml.Event(2,2)
    ea = libsbml.EventAssignment(2,3)
    ea.setVariable( "f")
    ea.setMath(libsbml.parseFormula("a-n"))
    i = e.addEventAssignment(ea)
    self.assert_( i == libsbml.LIBSBML_VERSION_MISMATCH )
    self.assert_( e.getNumEventAssignments() == 0 )
    ea = None
    e = None
    pass  

  def test_Event_addEventAssignment3(self):
    e = libsbml.Event(2,2)
    i = e.addEventAssignment(None)
    self.assert_( i == libsbml.LIBSBML_OPERATION_FAILED )
    self.assert_( e.getNumEventAssignments() == 0 )
    e = None
    pass  

  def test_Event_addEventAssignment4(self):
    e = libsbml.Event(2,2)
    ea = libsbml.EventAssignment(2,2)
    ea.setVariable( "c")
    ea.setMath(libsbml.parseFormula("a-n"))
    ea1 = libsbml.EventAssignment(2,2)
    ea1.setVariable( "c")
    ea1.setMath(libsbml.parseFormula("a-n"))
    i = e.addEventAssignment(ea)
    self.assert_( i == libsbml.LIBSBML_OPERATION_SUCCESS )
    self.assert_( e.getNumEventAssignments() == 1 )
    i = e.addEventAssignment(ea1)
    self.assert_( i == libsbml.LIBSBML_DUPLICATE_OBJECT_ID )
    self.assert_( e.getNumEventAssignments() == 1 )
    ea = None
    ea1 = None
    e = None
    pass  

  def test_Event_createEventAssignment(self):
    e = libsbml.Event(2,2)
    ea = e.createEventAssignment()
    self.assert_( e.getNumEventAssignments() == 1 )
    self.assert_( (ea).getLevel() == 2 )
    self.assert_( (ea).getVersion() == 2 )
    e = None
    pass  

  def test_Event_setDelay1(self):
    math1 = libsbml.parseFormula("0")
    Delay = libsbml.Delay(2,4)
    Delay.setMath(math1)
    i = self.E.setDelay(Delay)
    self.assert_( i == libsbml.LIBSBML_OPERATION_SUCCESS )
    self.assert_( self.E.getDelay() != None )
    self.assertEqual( True, self.E.isSetDelay() )
    i = self.E.unsetDelay()
    self.assert_( i == libsbml.LIBSBML_OPERATION_SUCCESS )
    self.assertEqual( False, self.E.isSetDelay() )
    pass  

  def test_Event_setDelay2(self):
    Delay = libsbml.Delay(2,1)
    i = self.E.setDelay(Delay)
    self.assert_( i == libsbml.LIBSBML_VERSION_MISMATCH )
    self.assertEqual( False, self.E.isSetDelay() )
    i = self.E.unsetDelay()
    self.assert_( i == libsbml.LIBSBML_OPERATION_SUCCESS )
    pass  

  def test_Event_setId1(self):
    id =  "1e1";
    i = self.E.setId(id)
    self.assert_( i == libsbml.LIBSBML_INVALID_ATTRIBUTE_VALUE )
    self.assertEqual( False, self.E.isSetId() )
    pass  

  def test_Event_setId2(self):
    id =  "e1";
    i = self.E.setId(id)
    self.assert_( i == libsbml.LIBSBML_OPERATION_SUCCESS )
    self.assert_(( id == self.E.getId() ))
    self.assertEqual( True, self.E.isSetId() )
    i = self.E.unsetId()
    self.assert_( i == libsbml.LIBSBML_OPERATION_SUCCESS )
    self.assertEqual( False, self.E.isSetId() )
    pass  

  def test_Event_setId3(self):
    i = self.E.setId("")
    self.assert_( i == libsbml.LIBSBML_OPERATION_SUCCESS )
    self.assertEqual( False, self.E.isSetId() )
    pass  

  def test_Event_setName1(self):
    name =  "3Set_k2";
    i = self.E.setName(name)
    self.assert_( i == libsbml.LIBSBML_OPERATION_SUCCESS )
    self.assertEqual( True, self.E.isSetName() )
    pass  

  def test_Event_setName2(self):
    name =  "Set k2";
    i = self.E.setName(name)
    self.assert_( i == libsbml.LIBSBML_OPERATION_SUCCESS )
    self.assert_(( name == self.E.getName() ))
    self.assertEqual( True, self.E.isSetName() )
    i = self.E.unsetName()
    self.assert_( i == libsbml.LIBSBML_OPERATION_SUCCESS )
    self.assertEqual( False, self.E.isSetName() )
    pass  

  def test_Event_setName3(self):
    i = self.E.setName("")
    self.assert_( i == libsbml.LIBSBML_OPERATION_SUCCESS )
    self.assertEqual( False, self.E.isSetName() )
    pass  

  def test_Event_setTimeUnits1(self):
    units =  "second";
    i = self.E.setTimeUnits(units)
    self.assert_( i == libsbml.LIBSBML_UNEXPECTED_ATTRIBUTE )
    self.assertEqual( False, self.E.isSetTimeUnits() )
    pass  

  def test_Event_setTimeUnits2(self):
    units =  "second";
    e = libsbml.Event(2,1)
    i = e.setTimeUnits(units)
    self.assert_( i == libsbml.LIBSBML_OPERATION_SUCCESS )
    self.assert_(( units == e.getTimeUnits() ))
    self.assertEqual( True, e.isSetTimeUnits() )
    i = e.unsetTimeUnits()
    self.assert_( i == libsbml.LIBSBML_OPERATION_SUCCESS )
    self.assertEqual( False, e.isSetTimeUnits() )
    e = None
    pass  

  def test_Event_setTimeUnits3(self):
    units =  "1second";
    e = libsbml.Event(2,1)
    i = e.setTimeUnits(units)
    self.assert_( i == libsbml.LIBSBML_INVALID_ATTRIBUTE_VALUE )
    self.assertEqual( False, e.isSetTimeUnits() )
    i = e.unsetTimeUnits()
    self.assert_( i == libsbml.LIBSBML_OPERATION_SUCCESS )
    self.assertEqual( False, e.isSetTimeUnits() )
    e = None
    pass  

  def test_Event_setTimeUnits4(self):
    e = libsbml.Event(2,1)
    i = e.setTimeUnits("")
    self.assert_( i == libsbml.LIBSBML_OPERATION_SUCCESS )
    self.assertEqual( False, e.isSetTimeUnits() )
    e = None
    pass  

  def test_Event_setTrigger1(self):
    trigger = libsbml.Trigger(2,1)
    i = self.E.setTrigger(trigger)
    self.assert_( i == libsbml.LIBSBML_VERSION_MISMATCH )
    self.assertEqual( False, self.E.isSetTrigger() )
    pass  

  def test_Event_setTrigger2(self):
    math1 = libsbml.parseFormula("0")
    trigger = libsbml.Trigger(2,4)
    trigger.setMath(math1)
    i = self.E.setTrigger(trigger)
    self.assert_( i == libsbml.LIBSBML_OPERATION_SUCCESS )
    self.assert_( self.E.getTrigger() != None )
    self.assertEqual( True, self.E.isSetTrigger() )
    pass  

  def test_Event_setUseValuesFromTriggerTime1(self):
    e = libsbml.Event(2,4)
    i = e.setUseValuesFromTriggerTime(False)
    self.assert_( i == libsbml.LIBSBML_OPERATION_SUCCESS )
    self.assert_( e.getUseValuesFromTriggerTime() == False )
    i = e.setUseValuesFromTriggerTime(True)
    self.assert_( i == libsbml.LIBSBML_OPERATION_SUCCESS )
    self.assert_( e.getUseValuesFromTriggerTime() == True )
    e = None
    pass  

  def test_Event_setUseValuesFromTriggerTime2(self):
    e = libsbml.Event(2,2)
    i = e.setUseValuesFromTriggerTime(False)
    self.assert_( i == libsbml.LIBSBML_UNEXPECTED_ATTRIBUTE )
    e = None
    pass  

def suite():
  suite = unittest.TestSuite()
  suite.addTest(unittest.makeSuite(TestEvent_newSetters))

  return suite

if __name__ == "__main__":
  if unittest.TextTestRunner(verbosity=1).run(suite()).wasSuccessful() :
    sys.exit(0)
  else:
    sys.exit(1)
