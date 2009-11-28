/// 
///  @file    TestEvent_newSetters.cs
///  @brief   Event unit tests for new set function API
///  @author  Frank Bergmann (Csharp conversion)
///  @author  Akiya Jouraku (Csharp conversion)
///  @author  Sarah Keating 
/// 
///  $Id$
///  $HeadURL$
/// 
///  This test file was converted from src/sbml/test/TestEvent_newSetters.c
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

  public class TestEvent_newSetters {
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
      else if ( (a == null) || (b == null) )
      {
        throw new AssertionError();
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
      else if ( (a == null) || (b == null) )
      {
        return;
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

    private Event E;

    public void setUp()
    {
      E = new  Event(2,4);
      if (E == null);
      {
      }
    }

    public void tearDown()
    {
      E = null;
    }

    public void test_Event_addEventAssignment1()
    {
      Event e = new  Event(2,2);
      EventAssignment ea = new  EventAssignment(2,2);
      long i = e.addEventAssignment(ea);
      assertTrue( i == libsbml.LIBSBML_INVALID_OBJECT );
      ea.setVariable( "f");
      i = e.addEventAssignment(ea);
      assertTrue( i == libsbml.LIBSBML_INVALID_OBJECT );
      ea.setMath(libsbml.parseFormula("a-n"));
      i = e.addEventAssignment(ea);
      assertTrue( i == libsbml.LIBSBML_OPERATION_SUCCESS );
      assertTrue( e.getNumEventAssignments() == 1 );
      ea = null;
      e = null;
    }

    public void test_Event_addEventAssignment2()
    {
      Event e = new  Event(2,2);
      EventAssignment ea = new  EventAssignment(2,3);
      ea.setVariable( "f");
      ea.setMath(libsbml.parseFormula("a-n"));
      long i = e.addEventAssignment(ea);
      assertTrue( i == libsbml.LIBSBML_VERSION_MISMATCH );
      assertTrue( e.getNumEventAssignments() == 0 );
      ea = null;
      e = null;
    }

    public void test_Event_addEventAssignment3()
    {
      Event e = new  Event(2,2);
      long i = e.addEventAssignment(null);
      assertTrue( i == libsbml.LIBSBML_OPERATION_FAILED );
      assertTrue( e.getNumEventAssignments() == 0 );
      e = null;
    }

    public void test_Event_addEventAssignment4()
    {
      Event e = new  Event(2,2);
      EventAssignment ea = new  EventAssignment(2,2);
      ea.setVariable( "c");
      ea.setMath(libsbml.parseFormula("a-n"));
      EventAssignment ea1 = new  EventAssignment(2,2);
      ea1.setVariable( "c");
      ea1.setMath(libsbml.parseFormula("a-n"));
      long i = e.addEventAssignment(ea);
      assertTrue( i == libsbml.LIBSBML_OPERATION_SUCCESS );
      assertTrue( e.getNumEventAssignments() == 1 );
      i = e.addEventAssignment(ea1);
      assertTrue( i == libsbml.LIBSBML_DUPLICATE_OBJECT_ID );
      assertTrue( e.getNumEventAssignments() == 1 );
      ea = null;
      ea1 = null;
      e = null;
    }

    public void test_Event_createEventAssignment()
    {
      Event e = new  Event(2,2);
      EventAssignment ea = e.createEventAssignment();
      assertTrue( e.getNumEventAssignments() == 1 );
      assertTrue( (ea).getLevel() == 2 );
      assertTrue( (ea).getVersion() == 2 );
      e = null;
    }

    public void test_Event_setDelay1()
    {
      ASTNode math1 = libsbml.parseFormula("0");
      Delay Delay = new  Delay(2,4);
      Delay.setMath(math1);
      long i = E.setDelay(Delay);
      assertTrue( i == libsbml.LIBSBML_OPERATION_SUCCESS );
      assertNotEquals(E.getDelay(),null);
      assertEquals( true, E.isSetDelay() );
      i = E.unsetDelay();
      assertTrue( i == libsbml.LIBSBML_OPERATION_SUCCESS );
      assertEquals( false, E.isSetDelay() );
    }

    public void test_Event_setDelay2()
    {
      Delay Delay = new  Delay(2,1);
      long i = E.setDelay(Delay);
      assertTrue( i == libsbml.LIBSBML_VERSION_MISMATCH );
      assertEquals( false, E.isSetDelay() );
      i = E.unsetDelay();
      assertTrue( i == libsbml.LIBSBML_OPERATION_SUCCESS );
    }

    public void test_Event_setId1()
    {
      string id =  "1e1";;
      long i = E.setId(id);
      assertTrue( i == libsbml.LIBSBML_INVALID_ATTRIBUTE_VALUE );
      assertEquals( false, E.isSetId() );
    }

    public void test_Event_setId2()
    {
      string id =  "e1";;
      long i = E.setId(id);
      assertTrue( i == libsbml.LIBSBML_OPERATION_SUCCESS );
      assertTrue(( id == E.getId() ));
      assertEquals( true, E.isSetId() );
      i = E.unsetId();
      assertTrue( i == libsbml.LIBSBML_OPERATION_SUCCESS );
      assertEquals( false, E.isSetId() );
    }

    public void test_Event_setId3()
    {
      long i = E.setId("");
      assertTrue( i == libsbml.LIBSBML_OPERATION_SUCCESS );
      assertEquals( false, E.isSetId() );
    }

    public void test_Event_setName1()
    {
      string name =  "3Set_k2";;
      long i = E.setName(name);
      assertTrue( i == libsbml.LIBSBML_OPERATION_SUCCESS );
      assertEquals( true, E.isSetName() );
    }

    public void test_Event_setName2()
    {
      string name =  "Set k2";;
      long i = E.setName(name);
      assertTrue( i == libsbml.LIBSBML_OPERATION_SUCCESS );
      assertTrue(( name == E.getName() ));
      assertEquals( true, E.isSetName() );
      i = E.unsetName();
      assertTrue( i == libsbml.LIBSBML_OPERATION_SUCCESS );
      assertEquals( false, E.isSetName() );
    }

    public void test_Event_setName3()
    {
      long i = E.setName("");
      assertTrue( i == libsbml.LIBSBML_OPERATION_SUCCESS );
      assertEquals( false, E.isSetName() );
    }

    public void test_Event_setTimeUnits1()
    {
      string units =  "second";;
      long i = E.setTimeUnits(units);
      assertTrue( i == libsbml.LIBSBML_UNEXPECTED_ATTRIBUTE );
      assertEquals( false, E.isSetTimeUnits() );
    }

    public void test_Event_setTimeUnits2()
    {
      string units =  "second";;
      Event e = new  Event(2,1);
      long i = e.setTimeUnits(units);
      assertTrue( i == libsbml.LIBSBML_OPERATION_SUCCESS );
      assertTrue(( units == e.getTimeUnits() ));
      assertEquals( true, e.isSetTimeUnits() );
      i = e.unsetTimeUnits();
      assertTrue( i == libsbml.LIBSBML_OPERATION_SUCCESS );
      assertEquals( false, e.isSetTimeUnits() );
      e = null;
    }

    public void test_Event_setTimeUnits3()
    {
      string units =  "1second";;
      Event e = new  Event(2,1);
      long i = e.setTimeUnits(units);
      assertTrue( i == libsbml.LIBSBML_INVALID_ATTRIBUTE_VALUE );
      assertEquals( false, e.isSetTimeUnits() );
      i = e.unsetTimeUnits();
      assertTrue( i == libsbml.LIBSBML_OPERATION_SUCCESS );
      assertEquals( false, e.isSetTimeUnits() );
      e = null;
    }

    public void test_Event_setTimeUnits4()
    {
      Event e = new  Event(2,1);
      long i = e.setTimeUnits("");
      assertTrue( i == libsbml.LIBSBML_OPERATION_SUCCESS );
      assertEquals( false, e.isSetTimeUnits() );
      e = null;
    }

    public void test_Event_setTrigger1()
    {
      Trigger trigger = new  Trigger(2,1);
      long i = E.setTrigger(trigger);
      assertTrue( i == libsbml.LIBSBML_VERSION_MISMATCH );
      assertEquals( false, E.isSetTrigger() );
    }

    public void test_Event_setTrigger2()
    {
      ASTNode math1 = libsbml.parseFormula("0");
      Trigger trigger = new  Trigger(2,4);
      trigger.setMath(math1);
      long i = E.setTrigger(trigger);
      assertTrue( i == libsbml.LIBSBML_OPERATION_SUCCESS );
      assertNotEquals(E.getTrigger(),null);
      assertEquals( true, E.isSetTrigger() );
    }

    public void test_Event_setUseValuesFromTriggerTime1()
    {
      Event e = new  Event(2,4);
      long i = e.setUseValuesFromTriggerTime(false);
      assertTrue( i == libsbml.LIBSBML_OPERATION_SUCCESS );
      assertTrue( e.getUseValuesFromTriggerTime() == false );
      i = e.setUseValuesFromTriggerTime(true);
      assertTrue( i == libsbml.LIBSBML_OPERATION_SUCCESS );
      assertTrue( e.getUseValuesFromTriggerTime() == true );
      e = null;
    }

    public void test_Event_setUseValuesFromTriggerTime2()
    {
      Event e = new  Event(2,2);
      long i = e.setUseValuesFromTriggerTime(false);
      assertTrue( i == libsbml.LIBSBML_UNEXPECTED_ATTRIBUTE );
      e = null;
    }

  }
}
