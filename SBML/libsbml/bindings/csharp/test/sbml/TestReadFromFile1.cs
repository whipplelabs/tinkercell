/// 
///  @file    TestReadFromFile1.cs
///  @brief   Reads tests/l1v1-branch.xml into memory and tests it.
///  @author  Frank Bergmann (Csharp conversion)
///  @author  Akiya Jouraku (Csharp conversion)
///  @author  Ben Bornstein 
/// 
///  $Id: TestReadFromFile1.cs 10124 2009-08-28 12:04:51Z sarahkeating $
///  $HeadURL: https://sbml.svn.sourceforge.net/svnroot/sbml/trunk/libsbml/src/bindings/csharp/test/sbml/TestReadFromFile1.cs $
/// 
///  This test file was converted from src/sbml/test/TestReadFromFile1.c
///  with the help of conversion sciprt (ctest_converter.pl).
/// 
/// <!---------------------------------------------------------------------------
///  This file is part of libSBML.  Please visit http://sbml.org for more
///  information about SBML, and the latest version of libSBML.
/// 
///  Copyright 2005-2009 California Institute of Technology.
///  Copyright 2002-2005 California Institute of Technology and
///                      Japan Science and Technology Corporation.
///  
///  This library is free software; you can redistribute it and/or modify it
///  under the terms of the GNU Lesser General Public License as published by
///  the Free Software Foundation.  A copy of the license agreement is provided
///  in the file named "LICENSE.txt" included with this software distribution
///  and also available online as http://sbml.org/software/libsbml/license.html
/// --------------------------------------------------------------------------->*/


namespace LibSBMLCSTest {

  using libsbml;

  using  System.IO;

  public class TestReadFromFile1 {
    public class AssertionError : System.Exception 
    {
      public AssertionError() : base()
      {
        
      }
    }


    static void assertTrue(bool condition)
    {
      if (condition == true)
      {
        return;
      }
      throw new AssertionError();
    }

    static void assertEquals(object a, object b)
    {
      if ( (a == null) && (b == null) )
      {
        return;
      }
      else if (a.Equals(b))
      {
        return;
      }
  
      throw new AssertionError();
    }

    static void assertNotEquals(object a, object b)
    {
      if ( (a == null) && (b == null) )
      {
        throw new AssertionError();
      }
      else if (a.Equals(b))
      {
        throw new AssertionError();
      }
    }

    static void assertEquals(bool a, bool b)
    {
      if ( a == b )
      {
        return;
      }
      throw new AssertionError();
    }

    static void assertNotEquals(bool a, bool b)
    {
      if ( a != b )
      {
        return;
      }
      throw new AssertionError();
    }

    static void assertEquals(int a, int b)
    {
      if ( a == b )
      {
        return;
      }
      throw new AssertionError();
    }

    static void assertNotEquals(int a, int b)
    {
      if ( a != b )
      {
        return;
      }
      throw new AssertionError();
    }


    public void test_read_l1v1_branch()
    {
      SBMLDocument d;
      Model m;
      Compartment c;
      KineticLaw kl;
      Parameter p;
      Reaction r;
      Species s;
      SpeciesReference sr;
      UnitDefinition ud;
      string filename = "../../sbml/test/test-data/l1v1-branch.xml";
      d = libsbml.readSBML(filename);
      if (d == null);
      {
      }
      assertTrue( d.getLevel() == 1 );
      assertTrue( d.getVersion() == 1 );
      m = d.getModel();
      assertTrue((  "Branch" == m.getName() ));
      assertTrue( m.getNumCompartments() == 1 );
      c = m.getCompartment(0);
      assertTrue((  "compartmentOne" == c.getName() ));
      assertTrue( c.getVolume() == 1 );
      ud = c.getDerivedUnitDefinition();
      assertTrue( ud.getNumUnits() == 1 );
      assertTrue( ud.getUnit(0).getKind() == libsbml.UNIT_KIND_LITRE );
      assertTrue( m.getNumSpecies() == 4 );
      s = m.getSpecies(0);
      assertTrue((  "S1"              == s.getName() ));
      assertTrue((  "compartmentOne"  == s.getCompartment() ));
      assertTrue( s.getInitialAmount() == 0 );
      assertTrue( s.getBoundaryCondition() == false );
      ud = s.getDerivedUnitDefinition();
      assertTrue( ud.getNumUnits() == 2 );
      assertTrue( ud.getUnit(0).getKind() == libsbml.UNIT_KIND_MOLE );
      assertTrue( ud.getUnit(0).getExponent() == 1 );
      assertTrue( ud.getUnit(1).getKind() == libsbml.UNIT_KIND_LITRE );
      assertTrue( ud.getUnit(1).getExponent() == -1 );
      s = m.getSpecies(1);
      assertTrue((  "X0"              == s.getName() ));
      assertTrue((  "compartmentOne"  == s.getCompartment() ));
      assertTrue( s.getInitialAmount() == 0 );
      assertTrue( s.getBoundaryCondition() == true );
      s = m.getSpecies(2);
      assertTrue((  "X1"              == s.getName() ));
      assertTrue((  "compartmentOne"  == s.getCompartment() ));
      assertTrue( s.getInitialAmount() == 0 );
      assertTrue( s.getBoundaryCondition() == true );
      s = m.getSpecies(3);
      assertTrue((  "X2"              == s.getName() ));
      assertTrue((  "compartmentOne"  == s.getCompartment() ));
      assertTrue( s.getInitialAmount() == 0 );
      assertTrue( s.getBoundaryCondition() == true );
      assertTrue( m.getNumReactions() == 3 );
      r = m.getReaction(0);
      assertTrue((  "reaction_1" == r.getName() ));
      assertTrue( r.getReversible() == false );
      assertTrue( r.getFast() == false );
      ud = r.getKineticLaw().getDerivedUnitDefinition();
      assertTrue( ud.getNumUnits() == 2 );
      assertTrue( ud.getUnit(0).getKind() == libsbml.UNIT_KIND_MOLE );
      assertTrue( ud.getUnit(0).getExponent() == 1 );
      assertTrue( ud.getUnit(1).getKind() == libsbml.UNIT_KIND_LITRE );
      assertTrue( ud.getUnit(1).getExponent() == -1 );
      assertTrue( r.getKineticLaw().containsUndeclaredUnits() == true );
      r = m.getReaction(1);
      assertTrue((  "reaction_2" == r.getName() ));
      assertTrue( r.getReversible() == false );
      assertTrue( r.getFast() == false );
      r = m.getReaction(2);
      assertTrue((  "reaction_3" == r.getName() ));
      assertTrue( r.getReversible() == false );
      assertTrue( r.getFast() == false );
      r = m.getReaction(0);
      assertTrue( r.getNumReactants() == 1 );
      assertTrue( r.getNumProducts() == 1 );
      sr = r.getReactant(0);
      assertTrue((  "X0" == sr.getSpecies() ));
      assertTrue( sr.getStoichiometry() == 1 );
      assertTrue( sr.getDenominator() == 1 );
      sr = r.getProduct(0);
      assertTrue((  "S1" == sr.getSpecies() ));
      assertTrue( sr.getStoichiometry() == 1 );
      assertTrue( sr.getDenominator() == 1 );
      kl = r.getKineticLaw();
      assertTrue((  "k1 * X0" == kl.getFormula() ));
      assertTrue( kl.getNumParameters() == 1 );
      p = kl.getParameter(0);
      assertTrue((  "k1" == p.getName() ));
      assertTrue( p.getValue() == 0 );
      r = m.getReaction(1);
      assertTrue( r.getNumReactants() == 1 );
      assertTrue( r.getNumProducts() == 1 );
      sr = r.getReactant(0);
      assertTrue((  "S1" == sr.getSpecies() ));
      assertTrue( sr.getStoichiometry() == 1 );
      assertTrue( sr.getDenominator() == 1 );
      sr = r.getProduct(0);
      assertTrue((  "X1" == sr.getSpecies() ));
      assertTrue( sr.getStoichiometry() == 1 );
      assertTrue( sr.getDenominator() == 1 );
      kl = r.getKineticLaw();
      assertTrue((  "k2 * S1" == kl.getFormula() ));
      assertTrue( kl.getNumParameters() == 1 );
      p = kl.getParameter(0);
      assertTrue((  "k2" == p.getName() ));
      assertTrue( p.getValue() == 0 );
      r = m.getReaction(2);
      assertTrue( r.getNumReactants() == 1 );
      assertTrue( r.getNumProducts() == 1 );
      sr = r.getReactant(0);
      assertTrue((  "S1" == sr.getSpecies() ));
      assertTrue( sr.getStoichiometry() == 1 );
      assertTrue( sr.getDenominator() == 1 );
      sr = r.getProduct(0);
      assertTrue((  "X2" == sr.getSpecies() ));
      assertTrue( sr.getStoichiometry() == 1 );
      assertTrue( sr.getDenominator() == 1 );
      kl = r.getKineticLaw();
      assertTrue((  "k3 * S1" == kl.getFormula() ));
      assertTrue( kl.getNumParameters() == 1 );
      p = kl.getParameter(0);
      assertTrue((  "k3" == p.getName() ));
      assertTrue( p.getValue() == 0 );
      d = null;
    }

  }
}
