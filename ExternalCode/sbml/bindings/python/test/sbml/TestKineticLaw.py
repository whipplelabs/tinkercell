#
# @file    TestKineticLaw.py
# @brief   SBML KineticLaw unit tests
#
# @author  Akiya Jouraku (Python conversion)
# @author  Ben Bornstein 
#
# $Id: TestKineticLaw.py 10124 2009-08-28 12:04:51Z sarahkeating $
# $HeadURL: https://sbml.svn.sourceforge.net/svnroot/sbml/trunk/libsbml/src/bindings/python/test/sbml/TestKineticLaw.py $
#
# This test file was converted from src/sbml/test/TestKineticLaw.c
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

class TestKineticLaw(unittest.TestCase):

  kl = None

  def setUp(self):
    self.kl = libsbml.KineticLaw(2,4)
    if (self.kl == None):
      pass    
    pass  

  def tearDown(self):
    self.kl = None
    pass  

  def test_KineticLaw_addParameter(self):
    p = libsbml.Parameter(2,4)
    p.setId( "p")
    self.kl.addParameter(p)
    self.assert_( self.kl.getNumParameters() == 1 )
    p = None
    pass  

  def test_KineticLaw_create(self):
    self.assert_( self.kl.getTypeCode() == libsbml.SBML_KINETIC_LAW )
    self.assert_( self.kl.getMetaId() == "" )
    self.assert_( self.kl.getNotes() == None )
    self.assert_( self.kl.getAnnotation() == None )
    self.assert_( self.kl.getFormula() == "" )
    self.assert_( self.kl.getMath() == None )
    self.assert_( self.kl.getTimeUnits() == "" )
    self.assert_( self.kl.getSubstanceUnits() == "" )
    self.assertEqual( False, self.kl.isSetFormula() )
    self.assertEqual( False, self.kl.isSetMath() )
    self.assertEqual( False, self.kl.isSetTimeUnits() )
    self.assertEqual( False, self.kl.isSetSubstanceUnits() )
    self.assert_( self.kl.getNumParameters() == 0 )
    pass  

  def test_KineticLaw_createWithNS(self):
    xmlns = libsbml.XMLNamespaces()
    xmlns.add( "http://www.sbml.org", "testsbml")
    sbmlns = libsbml.SBMLNamespaces(2,1)
    sbmlns.addNamespaces(xmlns)
    object = libsbml.KineticLaw(sbmlns)
    self.assert_( object.getTypeCode() == libsbml.SBML_KINETIC_LAW )
    self.assert_( object.getMetaId() == "" )
    self.assert_( object.getNotes() == None )
    self.assert_( object.getAnnotation() == None )
    self.assert_( object.getLevel() == 2 )
    self.assert_( object.getVersion() == 1 )
    self.assert_( object.getNamespaces() != None )
    self.assert_( object.getNamespaces().getLength() == 2 )
    object = None
    pass  

  def test_KineticLaw_free_NULL(self):
    pass  

  def test_KineticLaw_getParameter(self):
    k1 = libsbml.Parameter(2,4)
    k2 = libsbml.Parameter(2,4)
    k1.setId( "k1")
    k2.setId( "k2")
    k1.setValue(3.14)
    k2.setValue(2.72)
    self.kl.addParameter(k1)
    self.kl.addParameter(k2)
    k1 = None
    k2 = None
    self.assert_( self.kl.getNumParameters() == 2 )
    k1 = self.kl.getParameter(0)
    k2 = self.kl.getParameter(1)
    self.assert_((  "k1" == k1.getId() ))
    self.assert_((  "k2" == k2.getId() ))
    self.assert_( k1.getValue() == 3.14 )
    self.assert_( k2.getValue() == 2.72 )
    pass  

  def test_KineticLaw_getParameterById(self):
    k1 = libsbml.Parameter(2,4)
    k2 = libsbml.Parameter(2,4)
    k1.setId( "k1")
    k2.setId( "k2")
    k1.setValue(3.14)
    k2.setValue(2.72)
    self.kl.addParameter(k1)
    self.kl.addParameter(k2)
    k1 = None
    k2 = None
    self.assert_( self.kl.getNumParameters() == 2 )
    k1 = self.kl.getParameter( "k1")
    k2 = self.kl.getParameter( "k2")
    self.assert_((  "k1" == k1.getId() ))
    self.assert_((  "k2" == k2.getId() ))
    self.assert_( k1.getValue() == 3.14 )
    self.assert_( k2.getValue() == 2.72 )
    pass  

  def test_KineticLaw_removeParameter(self):
    o1 = self.kl.createParameter()
    o2 = self.kl.createParameter()
    o3 = self.kl.createParameter()
    o3.setId("test")
    self.assert_( self.kl.removeParameter(0) == o1 )
    self.assert_( self.kl.getNumParameters() == 2 )
    self.assert_( self.kl.removeParameter(0) == o2 )
    self.assert_( self.kl.getNumParameters() == 1 )
    self.assert_( self.kl.removeParameter("test") == o3 )
    self.assert_( self.kl.getNumParameters() == 0 )
    o1 = None
    o2 = None
    o3 = None
    pass  

  def test_KineticLaw_setBadFormula(self):
    formula =  "k1 X0";
    self.kl.setFormula(formula)
    self.assertEqual( False, self.kl.isSetFormula() )
    self.assertEqual( False, self.kl.isSetMath() )
    pass  

  def test_KineticLaw_setFormula(self):
    formula =  "k1*X0";
    self.kl.setFormula(formula)
    self.assert_(( formula == self.kl.getFormula() ))
    self.assertEqual( True, self.kl.isSetFormula() )
    if (self.kl.getFormula() == formula):
      pass    
    self.kl.setFormula(self.kl.getFormula())
    self.assert_(( formula == self.kl.getFormula() ))
    self.kl.setFormula("")
    self.assertEqual( False, self.kl.isSetFormula() )
    if (self.kl.getFormula() != None):
      pass    
    pass  

  def test_KineticLaw_setFormulaFromMath(self):
    math = libsbml.parseFormula("k1 * X0")
    self.assertEqual( False, self.kl.isSetMath() )
    self.assertEqual( False, self.kl.isSetFormula() )
    self.kl.setMath(math)
    self.assertEqual( True, self.kl.isSetMath() )
    self.assertEqual( True, self.kl.isSetFormula() )
    self.assert_((  "k1 * X0" == self.kl.getFormula() ))
    math = None
    pass  

  def test_KineticLaw_setMath(self):
    math = libsbml.parseFormula("k3 / k2")
    self.kl.setMath(math)
    math1 = self.kl.getMath()
    self.assert_( math1 != None )
    formula = libsbml.formulaToString(math1)
    self.assert_( formula != None )
    self.assert_((  "k3 / k2" == formula ))
    self.assert_( self.kl.getMath() != math )
    self.assertEqual( True, self.kl.isSetMath() )
    self.kl.setMath(self.kl.getMath())
    math1 = self.kl.getMath()
    self.assert_( math1 != None )
    formula = libsbml.formulaToString(math1)
    self.assert_( formula != None )
    self.assert_((  "k3 / k2" == formula ))
    self.assert_( self.kl.getMath() != math )
    self.kl.setMath(None)
    self.assertEqual( False, self.kl.isSetMath() )
    if (self.kl.getMath() != None):
      pass    
    math = None
    pass  

  def test_KineticLaw_setMathFromFormula(self):
    formula =  "k3 / k2";
    self.assertEqual( False, self.kl.isSetMath() )
    self.assertEqual( False, self.kl.isSetFormula() )
    self.kl.setFormula(formula)
    self.assertEqual( True, self.kl.isSetMath() )
    self.assertEqual( True, self.kl.isSetFormula() )
    formula = libsbml.formulaToString(self.kl.getMath())
    self.assert_((  "k3 / k2" == formula ))
    pass  

def suite():
  suite = unittest.TestSuite()
  suite.addTest(unittest.makeSuite(TestKineticLaw))

  return suite

if __name__ == "__main__":
  if unittest.TextTestRunner(verbosity=1).run(suite()).wasSuccessful() :
    sys.exit(0)
  else:
    sys.exit(1)
