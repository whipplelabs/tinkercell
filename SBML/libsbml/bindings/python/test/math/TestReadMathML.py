#
# @file    TestReadMathML.py
# @brief   Read MathML unit tests
#
# @author  Akiya Jouraku (Python conversion)
# @author  Ben Bornstein 
#
# $Id: TestReadMathML.py 10124 2009-08-28 12:04:51Z sarahkeating $
# $HeadURL: https://sbml.svn.sourceforge.net/svnroot/sbml/trunk/libsbml/src/bindings/python/test/math/TestReadMathML.py $
#
# This test file was converted from src/sbml/test/TestReadMathML.cpp
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

def util_isInf(*x):
  return ( (x[0] == util_PosInf()) or  (x[0] == util_NegInf()) )

def util_NaN():
  z = 1e300
  z = z * z

  return z - z

def util_PosInf():
  z = 1e300
  z = z * z

  return z

def util_NegInf():
  z = 1e300
  z = z * z

  return -z 

def wrapString(s):
  return s
  pass

def MATHML_FOOTER():
  return "</math>"
  pass

def MATHML_HEADER():
  return "<math xmlns='http://www.w3.org/1998/Math/MathML'>\n"
  pass

def XML_HEADER():
  return "<?xml version='1.0' encoding='UTF-8'?>\n"
  pass

def isnan(x):
  return (x != x)
  pass

def wrapMathML(s):
  r = XML_HEADER()
  r += MATHML_HEADER()
  r += s
  r += MATHML_FOOTER()
  return r
  pass

def wrapXML(s):
  r = XML_HEADER()
  r += s
  return r
  pass

class TestReadMathML(unittest.TestCase):

  F = None
  N = None

  def setUp(self):
    self.N = 0
    self.F = 0
    pass  

  def tearDown(self):
    self.N = None
    self.F = None
    pass  

  def test_element_abs(self):
    s = wrapMathML("<apply><abs/><ci> x </ci></apply>")
    self.N = libsbml.readMathMLFromString(s)
    self.assert_( self.N != 0 )
    self.F = libsbml.formulaToString(self.N)
    self.assert_((  "abs(x)" == self.F ))
    pass  

  def test_element_and(self):
    s = wrapMathML("<apply> <and/> <ci>a</ci> <ci>b</ci> <ci>c</ci> </apply>"  
    )
    self.N = libsbml.readMathMLFromString(s)
    self.assert_( self.N != 0 )
    self.F = libsbml.formulaToString(self.N)
    self.assert_((  "and(a, b, c)" == self.F ))
    pass  

  def test_element_arccos(self):
    s = wrapMathML("<apply><arccos/><ci> x </ci></apply>")
    self.N = libsbml.readMathMLFromString(s)
    self.assert_( self.N != 0 )
    self.F = libsbml.formulaToString(self.N)
    self.assert_((  "acos(x)" == self.F ))
    pass  

  def test_element_arccosh(self):
    s = wrapMathML("<apply><arccosh/><ci> x </ci></apply>")
    self.N = libsbml.readMathMLFromString(s)
    self.assert_( self.N != 0 )
    self.F = libsbml.formulaToString(self.N)
    self.assert_((  "arccosh(x)" == self.F ))
    pass  

  def test_element_arccot(self):
    s = wrapMathML("<apply><arccot/><ci> x </ci></apply>")
    self.N = libsbml.readMathMLFromString(s)
    self.assert_( self.N != 0 )
    self.F = libsbml.formulaToString(self.N)
    self.assert_((  "arccot(x)" == self.F ))
    pass  

  def test_element_arccoth(self):
    s = wrapMathML("<apply><arccoth/><ci> x </ci></apply>")
    self.N = libsbml.readMathMLFromString(s)
    self.assert_( self.N != 0 )
    self.F = libsbml.formulaToString(self.N)
    self.assert_((  "arccoth(x)" == self.F ))
    pass  

  def test_element_arccsc(self):
    s = wrapMathML("<apply><arccsc/><ci> x </ci></apply>")
    self.N = libsbml.readMathMLFromString(s)
    self.assert_( self.N != 0 )
    self.F = libsbml.formulaToString(self.N)
    self.assert_((  "arccsc(x)" == self.F ))
    pass  

  def test_element_arccsch(self):
    s = wrapMathML("<apply><arccsch/><ci> x </ci></apply>")
    self.N = libsbml.readMathMLFromString(s)
    self.assert_( self.N != 0 )
    self.F = libsbml.formulaToString(self.N)
    self.assert_((  "arccsch(x)" == self.F ))
    pass  

  def test_element_arcsec(self):
    s = wrapMathML("<apply><arcsec/><ci> x </ci></apply>")
    self.N = libsbml.readMathMLFromString(s)
    self.assert_( self.N != 0 )
    self.F = libsbml.formulaToString(self.N)
    self.assert_((  "arcsec(x)" == self.F ))
    pass  

  def test_element_arcsech(self):
    s = wrapMathML("<apply><arcsech/><ci> x </ci></apply>")
    self.N = libsbml.readMathMLFromString(s)
    self.assert_( self.N != 0 )
    self.F = libsbml.formulaToString(self.N)
    self.assert_((  "arcsech(x)" == self.F ))
    pass  

  def test_element_arcsin(self):
    s = wrapMathML("<apply><arcsin/><ci> x </ci></apply>")
    self.N = libsbml.readMathMLFromString(s)
    self.assert_( self.N != 0 )
    self.F = libsbml.formulaToString(self.N)
    self.assert_((  "asin(x)" == self.F ))
    pass  

  def test_element_arcsinh(self):
    s = wrapMathML("<apply><arcsinh/><ci> x </ci></apply>")
    self.N = libsbml.readMathMLFromString(s)
    self.assert_( self.N != 0 )
    self.F = libsbml.formulaToString(self.N)
    self.assert_((  "arcsinh(x)" == self.F ))
    pass  

  def test_element_arctan(self):
    s = wrapMathML("<apply><arctan/><ci> x </ci></apply>")
    self.N = libsbml.readMathMLFromString(s)
    self.assert_( self.N != 0 )
    self.F = libsbml.formulaToString(self.N)
    self.assert_((  "atan(x)" == self.F ))
    pass  

  def test_element_arctanh(self):
    s = wrapMathML("<apply><arctanh/><ci> x </ci></apply>")
    self.N = libsbml.readMathMLFromString(s)
    self.assert_( self.N != 0 )
    self.F = libsbml.formulaToString(self.N)
    self.assert_((  "arctanh(x)" == self.F ))
    pass  

  def test_element_bug_apply_ci_1(self):
    s = wrapMathML("<apply>" + 
    "  <ci> Y </ci>" + 
    "  <cn> 1 </cn>" + 
    "</apply>")
    self.N = libsbml.readMathMLFromString(s)
    self.assert_( self.N != 0 )
    self.assert_( self.N.getType() == libsbml.AST_FUNCTION )
    self.assert_((  "Y" == self.N.getName() ))
    self.assert_( self.N.getNumChildren() == 1 )
    c = self.N.getLeftChild()
    self.assert_( c != 0 )
    self.assert_( c.getType() == libsbml.AST_REAL )
    self.assert_( c.getReal() == 1 )
    self.assert_( c.getNumChildren() == 0 )
    pass  

  def test_element_bug_apply_ci_2(self):
    s = wrapMathML("<apply>" + 
    "  <ci> Y </ci>" + 
    "  <csymbol encoding='text' " + 
    "   definitionURL='http://www.sbml.org/sbml/symbols/time'> t </csymbol>" + 
    "</apply>")
    self.N = libsbml.readMathMLFromString(s)
    self.assert_( self.N != 0 )
    self.assert_( self.N.getType() == libsbml.AST_FUNCTION )
    self.assert_((  "Y" == self.N.getName() ))
    self.assert_( self.N.getNumChildren() == 1 )
    c = self.N.getLeftChild()
    self.assert_( c != None )
    self.assert_( c.getType() == libsbml.AST_NAME_TIME )
    self.assert_((  "t" == c.getName() ))
    self.assert_( c.getNumChildren() == 0 )
    pass  

  def test_element_bug_cn_e_notation_1(self):
    s = wrapMathML("<cn type='e-notation'> 2 <sep/> -8 </cn>")
    self.N = libsbml.readMathMLFromString(s)
    self.assert_( self.N != 0 )
    self.assert_( self.N.getType() == libsbml.AST_REAL_E )
    self.assert_( self.N.getMantissa() == 2.0 )
    self.assert_( self.N.getExponent() == -8.0 )
    self.assert_( self.N.getNumChildren() == 0 )
    pass  

  def test_element_bug_cn_e_notation_2(self):
    s = wrapMathML("<cn type='e-notation'> -3 <sep/> 4 </cn>")
    self.N = libsbml.readMathMLFromString(s)
    self.assert_( self.N != 0 )
    self.assert_( self.N.getType() == libsbml.AST_REAL_E )
    self.assert_( self.N.getMantissa() == -3.0 )
    self.assert_( self.N.getExponent() == 4.0 )
    self.assert_( self.N.getNumChildren() == 0 )
    pass  

  def test_element_bug_cn_e_notation_3(self):
    s = wrapMathML("<cn type='e-notation'> -6 <sep/> -1 </cn>")
    self.N = libsbml.readMathMLFromString(s)
    self.assert_( self.N != 0 )
    self.assert_( self.N.getType() == libsbml.AST_REAL_E )
    self.assert_( self.N.getMantissa() == -6.0 )
    self.assert_( self.N.getExponent() == -1.0 )
    self.assert_( self.N.getNumChildren() == 0 )
    pass  

  def test_element_bug_cn_integer_negative(self):
    s = wrapMathML("<cn type='integer'> -7 </cn>")
    self.N = libsbml.readMathMLFromString(s)
    self.assert_( self.N != 0 )
    self.assert_( self.N.getType() == libsbml.AST_INTEGER )
    self.assert_( self.N.getInteger() == -7 )
    self.assert_( self.N.getNumChildren() == 0 )
    pass  

  def test_element_bug_csymbol_1(self):
    s = wrapMathML("<apply>" + 
    "  <gt/>" + 
    "  <csymbol encoding='text' " + 
    "    definitionURL='http://www.sbml.org/sbml/symbols/time'>time</csymbol>" + 
    "  <cn>5000</cn>" + 
    "</apply>")
    self.N = libsbml.readMathMLFromString(s)
    self.assert_( self.N != 0 )
    self.assert_( self.N.getType() == libsbml.AST_RELATIONAL_GT )
    self.assert_( self.N.getNumChildren() == 2 )
    c = self.N.getLeftChild()
    self.assert_( c != 0 )
    self.assert_( c.getType() == libsbml.AST_NAME_TIME )
    self.assert_((  "time" == c.getName() ))
    self.assert_( c.getNumChildren() == 0 )
    c = self.N.getRightChild()
    self.assert_( c != 0 )
    self.assert_( c.getType() == libsbml.AST_REAL )
    self.assert_( c.getReal() == 5000 )
    self.assert_( c.getNumChildren() == 0 )
    pass  

  def test_element_bug_csymbol_delay_1(self):
    s = wrapMathML("<apply>" + 
    "  <csymbol encoding='text' definitionURL='http://www.sbml.org/sbml/" + 
    "symbols/delay'> my_delay </csymbol>" + 
    "  <ci> x </ci>" + 
    "  <cn> 0.1 </cn>" + 
    "</apply>\n")
    self.N = libsbml.readMathMLFromString(s)
    self.assert_( self.N != 0 )
    self.assert_( self.N.getType() == libsbml.AST_FUNCTION_DELAY )
    self.assert_((  "my_delay" == self.N.getName() ))
    self.assert_( self.N.getNumChildren() == 2 )
    c = self.N.getLeftChild()
    self.assert_( c != 0 )
    self.assert_( c.getType() == libsbml.AST_NAME )
    self.assert_((  "x" == c.getName() ))
    self.assert_( c.getNumChildren() == 0 )
    c = self.N.getRightChild()
    self.assert_( c != 0 )
    self.assert_( c.getType() == libsbml.AST_REAL )
    self.assert_( c.getReal() == 0.1 )
    self.assert_( c.getNumChildren() == 0 )
    pass  

  def test_element_bug_math_xmlns(self):
    s = wrapXML("<foo:math xmlns:foo='http://www.w3.org/1998/Math/MathML'>" + 
    "  <foo:apply>" + 
    "    <foo:plus/> <foo:cn>1</foo:cn> <foo:cn>2</foo:cn>" + 
    "  </foo:apply>" + 
    "</foo:math>")
    self.N = libsbml.readMathMLFromString(s)
    self.assert_( self.N != 0 )
    self.F = libsbml.formulaToString(self.N)
    self.assert_((  "1 + 2" == self.F ))
    pass  

  def test_element_ceiling(self):
    s = wrapMathML("<apply><ceiling/><cn> 1.6 </cn></apply>")
    self.N = libsbml.readMathMLFromString(s)
    self.assert_( self.N != 0 )
    self.F = libsbml.formulaToString(self.N)
    self.assert_((  "ceil(1.6)" == self.F ))
    pass  

  def test_element_ci(self):
    s = wrapMathML("<ci> x </ci>")
    self.N = libsbml.readMathMLFromString(s)
    self.assert_( self.N != 0 )
    self.assert_( self.N.getType() == libsbml.AST_NAME )
    self.assert_((  "x" == self.N.getName() ))
    self.assert_( self.N.getNumChildren() == 0 )
    pass  

  def test_element_ci_surrounding_spaces_bug(self):
    s = wrapMathML("  <ci> s </ci>  ")
    self.N = libsbml.readMathMLFromString(s)
    self.assert_( self.N != 0 )
    self.assert_( self.N.getType() == libsbml.AST_NAME )
    self.assert_((  "s" == self.N.getName() ))
    self.assert_( self.N.getNumChildren() == 0 )
    pass  

  def test_element_cn_default(self):
    s = wrapMathML("<cn> 12345.7 </cn>")
    self.N = libsbml.readMathMLFromString(s)
    self.assert_( self.N != 0 )
    self.assert_( self.N.getType() == libsbml.AST_REAL )
    self.assert_( self.N.getReal() == 12345.7 )
    self.assert_( self.N.getNumChildren() == 0 )
    pass  

  def test_element_cn_e_notation(self):
    s = wrapMathML("<cn type='e-notation'> 12.3 <sep/> 5 </cn>")
    self.N = libsbml.readMathMLFromString(s)
    self.assert_( self.N != 0 )
    self.assert_( self.N.getType() == libsbml.AST_REAL_E )
    self.assert_( self.N.getMantissa() == 12.3 )
    self.assert_( self.N.getExponent() == 5 )
    self.assert_( self.N.getNumChildren() == 0 )
    pass  

  def test_element_cn_integer(self):
    s = wrapMathML("<cn type='integer'> 12345 </cn>")
    self.N = libsbml.readMathMLFromString(s)
    self.assert_( self.N != 0 )
    self.assert_( self.N.getType() == libsbml.AST_INTEGER )
    self.assert_( self.N.getInteger() == 12345 )
    self.assert_( self.N.getNumChildren() == 0 )
    pass  

  def test_element_cn_rational(self):
    s = wrapMathML("<cn type='rational'> 12342 <sep/> 2342342 </cn>"  
    )
    self.N = libsbml.readMathMLFromString(s)
    self.assert_( self.N != 0 )
    self.assert_( self.N.getType() == libsbml.AST_RATIONAL )
    self.assert_( self.N.getNumerator() == 12342 )
    self.assert_( self.N.getDenominator() == 2342342 )
    self.assert_( self.N.getNumChildren() == 0 )
    pass  

  def test_element_cn_real(self):
    s = wrapMathML("<cn type='real'> 12345.7 </cn>")
    self.N = libsbml.readMathMLFromString(s)
    self.assert_( self.N != 0 )
    self.assert_( self.N.getType() == libsbml.AST_REAL )
    self.assert_( self.N.getReal() == 12345.7 )
    self.assert_( self.N.getNumChildren() == 0 )
    pass  

  def test_element_constants_exponentiale(self):
    s = wrapMathML("<exponentiale/>")
    self.N = libsbml.readMathMLFromString(s)
    self.assert_( self.N != 0 )
    self.assert_( self.N.getType() == libsbml.AST_CONSTANT_E )
    self.assert_( self.N.getNumChildren() == 0 )
    pass  

  def test_element_constants_false(self):
    s = wrapMathML("<false/>")
    self.N = libsbml.readMathMLFromString(s)
    self.assert_( self.N != 0 )
    self.assert_( self.N.getType() == libsbml.AST_CONSTANT_FALSE )
    self.assert_( self.N.getNumChildren() == 0 )
    pass  

  def test_element_constants_infinity(self):
    s = wrapMathML("<infinity/>")
    self.N = libsbml.readMathMLFromString(s)
    self.assert_( self.N != 0 )
    self.assert_( self.N.getType() == libsbml.AST_REAL )
    self.assert_( util_isInf(self.N.getReal()) == True )
    self.assert_( self.N.getNumChildren() == 0 )
    pass  

  def test_element_constants_notanumber(self):
    s = wrapMathML("<notanumber/>")
    self.N = libsbml.readMathMLFromString(s)
    self.assert_( self.N != 0 )
    self.assert_( self.N.getType() == libsbml.AST_REAL )
    self.assertEqual( True, isnan(self.N.getReal()) )
    self.assert_( self.N.getNumChildren() == 0 )
    pass  

  def test_element_constants_pi(self):
    s = wrapMathML("<pi/>")
    self.N = libsbml.readMathMLFromString(s)
    self.assert_( self.N != 0 )
    self.assert_( self.N.getType() == libsbml.AST_CONSTANT_PI )
    self.assert_( self.N.getNumChildren() == 0 )
    pass  

  def test_element_constants_true(self):
    s = wrapMathML("<true/>")
    self.N = libsbml.readMathMLFromString(s)
    self.assert_( self.N != 0 )
    self.assert_( self.N.getType() == libsbml.AST_CONSTANT_TRUE )
    self.assert_( self.N.getNumChildren() == 0 )
    pass  

  def test_element_cos(self):
    s = wrapMathML("<apply><cos/><ci> x </ci></apply>")
    self.N = libsbml.readMathMLFromString(s)
    self.assert_( self.N != 0 )
    self.F = libsbml.formulaToString(self.N)
    self.assert_((  "cos(x)" == self.F ))
    pass  

  def test_element_cosh(self):
    s = wrapMathML("<apply><cosh/><ci> x </ci></apply>")
    self.N = libsbml.readMathMLFromString(s)
    self.assert_( self.N != 0 )
    self.F = libsbml.formulaToString(self.N)
    self.assert_((  "cosh(x)" == self.F ))
    pass  

  def test_element_cot(self):
    s = wrapMathML("<apply><cot/><ci> x </ci></apply>")
    self.N = libsbml.readMathMLFromString(s)
    self.assert_( self.N != 0 )
    self.F = libsbml.formulaToString(self.N)
    self.assert_((  "cot(x)" == self.F ))
    pass  

  def test_element_coth(self):
    s = wrapMathML("<apply><coth/><ci> x </ci></apply>")
    self.N = libsbml.readMathMLFromString(s)
    self.assert_( self.N != 0 )
    self.F = libsbml.formulaToString(self.N)
    self.assert_((  "coth(x)" == self.F ))
    pass  

  def test_element_csc(self):
    s = wrapMathML("<apply><csc/><ci> x </ci></apply>")
    self.N = libsbml.readMathMLFromString(s)
    self.assert_( self.N != 0 )
    self.F = libsbml.formulaToString(self.N)
    self.assert_((  "csc(x)" == self.F ))
    pass  

  def test_element_csch(self):
    s = wrapMathML("<apply><csch/><ci> x </ci></apply>")
    self.N = libsbml.readMathMLFromString(s)
    self.assert_( self.N != 0 )
    self.F = libsbml.formulaToString(self.N)
    self.assert_((  "csch(x)" == self.F ))
    pass  

  def test_element_csymbol_delay_1(self):
    s = wrapMathML("<csymbol encoding='text' " + "definitionURL='http://www.sbml.org/sbml/symbols/delay'> delay </csymbol>")
    self.N = libsbml.readMathMLFromString(s)
    self.assert_( self.N != 0 )
    self.assert_( self.N.getType() == libsbml.AST_FUNCTION_DELAY )
    self.assert_((  "delay" == self.N.getName() ))
    self.assert_( self.N.getNumChildren() == 0 )
    pass  

  def test_element_csymbol_delay_2(self):
    s = wrapMathML("<apply>" + 
    "  <csymbol encoding='text' definitionURL='http://www.sbml.org/sbml/" + 
    "symbols/delay'> my_delay </csymbol>" + 
    "  <ci> x </ci>" + 
    "  <cn> 0.1 </cn>" + 
    "</apply>\n")
    self.N = libsbml.readMathMLFromString(s)
    self.assert_( self.N != 0 )
    self.F = libsbml.formulaToString(self.N)
    self.assert_((  "my_delay(x, 0.1)" == self.F ))
    pass  

  def test_element_csymbol_delay_3(self):
    s = wrapMathML("<apply>" + 
    "  <power/>" + 
    "  <apply>" + 
    "    <csymbol encoding='text' definitionURL='http://www.sbml.org/sbml/" + 
    "symbols/delay'> delay </csymbol>" + 
    "    <ci> P </ci>" + 
    "    <ci> delta_t </ci>" + 
    "  </apply>\n" + 
    "  <ci> q </ci>" + 
    "</apply>\n")
    self.N = libsbml.readMathMLFromString(s)
    self.assert_( self.N != 0 )
    self.F = libsbml.formulaToString(self.N)
    self.assert_((  "pow(delay(P, delta_t), q)" == self.F ))
    pass  

  def test_element_csymbol_time(self):
    s = wrapMathML("<csymbol encoding='text' " + "definitionURL='http://www.sbml.org/sbml/symbols/time'> t </csymbol>")
    self.N = libsbml.readMathMLFromString(s)
    self.assert_( self.N != 0 )
    self.assert_( self.N.getType() == libsbml.AST_NAME_TIME )
    self.assert_((  "t" == self.N.getName() ))
    self.assert_( self.N.getNumChildren() == 0 )
    pass  

  def test_element_eq(self):
    s = wrapMathML("<apply> <eq/> <ci>a</ci> <ci>b</ci> <ci>c</ci> </apply>"  
    )
    self.N = libsbml.readMathMLFromString(s)
    self.assert_( self.N != 0 )
    self.F = libsbml.formulaToString(self.N)
    self.assert_((  "eq(a, b, c)" == self.F ))
    pass  

  def test_element_exp(self):
    s = wrapMathML("<apply><exp/><ci> x </ci></apply>")
    self.N = libsbml.readMathMLFromString(s)
    self.assert_( self.N != 0 )
    self.F = libsbml.formulaToString(self.N)
    self.assert_((  "exp(x)" == self.F ))
    pass  

  def test_element_factorial(self):
    s = wrapMathML("<apply><factorial/><cn> 5 </cn></apply>")
    self.N = libsbml.readMathMLFromString(s)
    self.assert_( self.N != 0 )
    self.F = libsbml.formulaToString(self.N)
    self.assert_((  "factorial(5)" == self.F ))
    pass  

  def test_element_floor(self):
    s = wrapMathML("<apply><floor/><cn> 1.2 </cn></apply>")
    self.N = libsbml.readMathMLFromString(s)
    self.assert_( self.N != 0 )
    self.F = libsbml.formulaToString(self.N)
    self.assert_((  "floor(1.2)" == self.F ))
    pass  

  def test_element_function_call_1(self):
    s = wrapMathML("<apply> <ci> foo </ci> <ci> x </ci> </apply>")
    self.N = libsbml.readMathMLFromString(s)
    self.assert_( self.N != 0 )
    self.F = libsbml.formulaToString(self.N)
    self.assert_((  "foo(x)" == self.F ))
    pass  

  def test_element_function_call_2(self):
    s = wrapMathML("<apply> <plus/> <cn> 1 </cn>" + 
    "                <apply> <ci> f </ci> <ci> x </ci> </apply>" + 
    "</apply>")
    self.N = libsbml.readMathMLFromString(s)
    self.assert_( self.N != 0 )
    self.F = libsbml.formulaToString(self.N)
    self.assert_((  "1 + f(x)" == self.F ))
    pass  

  def test_element_geq(self):
    s = wrapMathML("<apply> <geq/> <cn>1</cn> <ci>x</ci> <cn>0</cn> </apply>"  
    )
    self.N = libsbml.readMathMLFromString(s)
    self.assert_( self.N != 0 )
    self.F = libsbml.formulaToString(self.N)
    self.assert_((  "geq(1, x, 0)" == self.F ))
    pass  

  def test_element_gt(self):
    s = wrapMathML("<apply> <gt/> <infinity/>" + 
    "              <apply> <minus/> <infinity/> <cn>1</cn> </apply>" + 
    "</apply>")
    self.N = libsbml.readMathMLFromString(s)
    self.assert_( self.N != 0 )
    self.F = libsbml.formulaToString(self.N)
    self.assert_((  "gt(INF, INF - 1)" == self.F ))
    pass  

  def test_element_invalid_mathml(self):
    invalid = wrapMathML("<lambda>" + 
    "<bvar>" + 
    "<ci definitionURL=\"http://biomodels.net/SBO/#SBO:0000065\">c</ci>" + 
    "</bvar>" + 
    "<apply>" + 
    "  <ci>c</ci>" + 
    "</apply>" + 
    "</lambda>\n")
    self.N = libsbml.readMathMLFromString(None)
    self.assert_( self.N == None )
    self.N = libsbml.readMathMLFromString(invalid)
    self.assert_( self.N == None )
    pass  

  def test_element_lambda(self):
    s = wrapMathML("<lambda>" + 
    "  <bvar> <ci>x</ci> </bvar>" + 
    "  <apply> <sin/>" + 
    "          <apply> <plus/> <ci>x</ci> <cn>1</cn> </apply>" + 
    "  </apply>" + 
    "</lambda>")
    self.N = libsbml.readMathMLFromString(s)
    self.assert_( self.N != 0 )
    self.F = libsbml.formulaToString(self.N)
    self.assert_((  "lambda(x, sin(x + 1))" == self.F ))
    pass  

  def test_element_leq(self):
    s = wrapMathML("<apply> <leq/> <cn>0</cn> <ci>x</ci> <cn>1</cn> </apply>"  
    )
    self.N = libsbml.readMathMLFromString(s)
    self.assert_( self.N != 0 )
    self.F = libsbml.formulaToString(self.N)
    self.assert_((  "leq(0, x, 1)" == self.F ))
    pass  

  def test_element_ln(self):
    s = wrapMathML("<apply><ln/><ci> a </ci></apply>")
    self.N = libsbml.readMathMLFromString(s)
    self.assert_( self.N != 0 )
    self.F = libsbml.formulaToString(self.N)
    self.assert_((  "log(a)" == self.F ))
    pass  

  def test_element_log_1(self):
    s = wrapMathML("<apply> <log/> <logbase> <cn type='integer'> 3 </cn> </logbase>" + 
    "               <ci> x </ci>" + 
    "</apply>")
    self.N = libsbml.readMathMLFromString(s)
    self.assert_( self.N != 0 )
    self.F = libsbml.formulaToString(self.N)
    self.assert_((  "log(3, x)" == self.F ))
    pass  

  def test_element_log_2(self):
    s = wrapMathML("<apply> <log/> <ci> x </ci> </apply>")
    self.N = libsbml.readMathMLFromString(s)
    self.assert_( self.N != 0 )
    self.F = libsbml.formulaToString(self.N)
    self.assert_((  "log10(x)" == self.F ))
    pass  

  def test_element_lt(self):
    s = wrapMathML("<apply> <lt/> <apply> <minus/> <infinity/> <infinity/> </apply>" + 
    "              <cn>1</cn>" + 
    "</apply>")
    self.N = libsbml.readMathMLFromString(s)
    self.assert_( self.N != 0 )
    self.F = libsbml.formulaToString(self.N)
    self.assert_((  "lt(INF - INF, 1)" == self.F ))
    pass  

  def test_element_math(self):
    s = wrapXML("<math xmlns='http://www.w3.org/1998/Math/MathML'/>"  
    )
    self.N = libsbml.readMathMLFromString(s)
    self.assert_( self.N != 0 )
    self.assert_( self.N.getType() == libsbml.AST_UNKNOWN )
    pass  

  def test_element_neq(self):
    s = wrapMathML("<apply> <neq/> <notanumber/> <notanumber/> </apply>"  
    )
    self.N = libsbml.readMathMLFromString(s)
    self.assert_( self.N != 0 )
    self.F = libsbml.formulaToString(self.N)
    self.assert_((  "neq(NaN, NaN)" == self.F ))
    pass  

  def test_element_not(self):
    s = wrapMathML("<apply> <not/> <ci> TooShabby </ci> </apply>")
    self.N = libsbml.readMathMLFromString(s)
    self.assert_( self.N != 0 )
    self.F = libsbml.formulaToString(self.N)
    self.assert_((  "not(TooShabby)" == self.F ))
    pass  

  def test_element_operator_plus(self):
    s = wrapMathML("<apply> <plus/> <cn> 1 </cn> <cn> 2 </cn> <cn> 3 </cn> </apply>"  
    )
    self.N = libsbml.readMathMLFromString(s)
    self.assert_( self.N != 0 )
    self.F = libsbml.formulaToString(self.N)
    self.assert_((  "1 + 2 + 3" == self.F ))
    pass  

  def test_element_operator_times(self):
    s = wrapMathML("<apply> <times/> <ci> x </ci> <ci> y </ci> <ci> z </ci> </apply>"  
    )
    self.N = libsbml.readMathMLFromString(s)
    self.assert_( self.N != 0 )
    self.F = libsbml.formulaToString(self.N)
    self.assert_((  "x * y * z" == self.F ))
    pass  

  def test_element_or(self):
    s = wrapMathML("<apply> <or/> <ci>a</ci> <ci>b</ci> <ci>c</ci> <ci>d</ci> </apply>"  
    )
    self.N = libsbml.readMathMLFromString(s)
    self.assert_( self.N != 0 )
    self.F = libsbml.formulaToString(self.N)
    self.assert_((  "or(a, b, c, d)" == self.F ))
    pass  

  def test_element_piecewise(self):
    s = wrapMathML("<piecewise>" + 
    "  <piece>" + 
    "    <apply> <minus/> <ci>x</ci> </apply>" + 
    "    <apply> <lt/> <ci>x</ci> <cn>0</cn> </apply>" + 
    "  </piece>" + 
    "  <piece>" + 
    "    <cn>0</cn>" + 
    "    <apply> <eq/> <ci>x</ci> <cn>0</cn> </apply>" + 
    "  </piece>" + 
    "  <piece>" + 
    "    <ci>x</ci>" + 
    "    <apply> <gt/> <ci>x</ci> <cn>0</cn> </apply>" + 
    "  </piece>" + 
    "</piecewise>")
    self.N = libsbml.readMathMLFromString(s)
    self.assert_( self.N != 0 )
    self.F = libsbml.formulaToString(self.N)
    self.assert_((  "piecewise(-x, lt(x, 0), 0, eq(x, 0), x, gt(x, 0))" == self.F ))
    pass  

  def test_element_piecewise_otherwise(self):
    s = wrapMathML("<piecewise>" + 
    "  <piece>" + 
    "    <cn>0</cn>" + 
    "    <apply> <lt/> <ci>x</ci> <cn>0</cn> </apply>" + 
    "  </piece>" + 
    "  <otherwise>" + 
    "    <ci>x</ci>" + 
    "  </otherwise>" + 
    "</piecewise>")
    self.N = libsbml.readMathMLFromString(s)
    self.assert_( self.N != 0 )
    self.F = libsbml.formulaToString(self.N)
    self.assert_((  "piecewise(0, lt(x, 0), x)" == self.F ))
    pass  

  def test_element_power(self):
    s = wrapMathML("<apply><power/> <ci>x</ci> <cn>3</cn> </apply>")
    self.N = libsbml.readMathMLFromString(s)
    self.assert_( self.N != 0 )
    self.F = libsbml.formulaToString(self.N)
    self.assert_((  "pow(x, 3)" == self.F ))
    pass  

  def test_element_root_1(self):
    s = wrapMathML("<apply> <root/> <degree> <cn type='integer'> 3 </cn> </degree>" + 
    "               <ci> a </ci>" + 
    "</apply>")
    self.N = libsbml.readMathMLFromString(s)
    self.assert_( self.N != 0 )
    self.F = libsbml.formulaToString(self.N)
    self.assert_((  "root(3, a)" == self.F ))
    pass  

  def test_element_root_2(self):
    s = wrapMathML("<apply> <root/> <ci> a </ci> </apply>")
    self.N = libsbml.readMathMLFromString(s)
    self.assert_( self.N != 0 )
    self.F = libsbml.formulaToString(self.N)
    self.assert_((  "sqrt(a)" == self.F ))
    pass  

  def test_element_sec(self):
    s = wrapMathML("<apply><sec/><ci> x </ci></apply>")
    self.N = libsbml.readMathMLFromString(s)
    self.assert_( self.N != 0 )
    self.F = libsbml.formulaToString(self.N)
    self.assert_((  "sec(x)" == self.F ))
    pass  

  def test_element_sech(self):
    s = wrapMathML("<apply><sech/><ci> x </ci></apply>")
    self.N = libsbml.readMathMLFromString(s)
    self.assert_( self.N != 0 )
    self.F = libsbml.formulaToString(self.N)
    self.assert_((  "sech(x)" == self.F ))
    pass  

  def test_element_sin(self):
    s = wrapMathML("<apply><sin/><ci> x </ci></apply>")
    self.N = libsbml.readMathMLFromString(s)
    self.assert_( self.N != 0 )
    self.F = libsbml.formulaToString(self.N)
    self.assert_((  "sin(x)" == self.F ))
    pass  

  def test_element_sinh(self):
    s = wrapMathML("<apply><sinh/><ci> x </ci></apply>")
    self.N = libsbml.readMathMLFromString(s)
    self.assert_( self.N != 0 )
    self.F = libsbml.formulaToString(self.N)
    self.assert_((  "sinh(x)" == self.F ))
    pass  

  def test_element_tan(self):
    s = wrapMathML("<apply><tan/><ci> x </ci></apply>")
    self.N = libsbml.readMathMLFromString(s)
    self.assert_( self.N != 0 )
    self.F = libsbml.formulaToString(self.N)
    self.assert_((  "tan(x)" == self.F ))
    pass  

  def test_element_tanh(self):
    s = wrapMathML("<apply><tanh/><ci> x </ci></apply>")
    self.N = libsbml.readMathMLFromString(s)
    self.assert_( self.N != 0 )
    self.F = libsbml.formulaToString(self.N)
    self.assert_((  "tanh(x)" == self.F ))
    pass  

  def test_element_xor(self):
    s = wrapMathML("<apply> <xor/> <ci>a</ci> <ci>b</ci> <ci>b</ci> <ci>a</ci> </apply>"  
    )
    self.N = libsbml.readMathMLFromString(s)
    self.assert_( self.N != 0 )
    self.F = libsbml.formulaToString(self.N)
    self.assert_((  "xor(a, b, b, a)" == self.F ))
    pass  

def suite():
  suite = unittest.TestSuite()
  suite.addTest(unittest.makeSuite(TestReadMathML))

  return suite

if __name__ == "__main__":
  if unittest.TextTestRunner(verbosity=1).run(suite()).wasSuccessful() :
    sys.exit(0)
  else:
    sys.exit(1)
