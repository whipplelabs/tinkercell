/**
 * \file    TestEvent.c
 * \brief   SBML Event unit tests
 * \author  Ben Bornstein
 *
 * $Id: TestEvent.c 10129 2009-08-28 12:23:22Z sarahkeating $
 * $HeadURL: https://sbml.svn.sourceforge.net/svnroot/sbml/trunk/libsbml/src/sbml/test/TestEvent.c $
 */
/* Copyright 2003 California Institute of Technology and
 * Japan Science and Technology Corporation.
 *
 * This library is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as published
 * by the Free Software Foundation; either version 2.1 of the License, or
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY, WITHOUT EVEN THE IMPLIED WARRANTY OF
 * MERCHANTABILITY OR FITNESS FOR A PARTICULAR PURPOSE.  The software and
 * documentation provided hereunder is on an "as is" basis, and the
 * California Institute of Technology and Japan Science and Technology
 * Corporation have no obligations to provide maintenance, support,
 * updates, enhancements or modifications.  In no event shall the
 * California Institute of Technology or the Japan Science and Technology
 * Corporation be liable to any party for direct, indirect, special,
 * incidental or consequential damages, including lost profits, arising
 * out of the use of this software and its documentation, even if the
 * California Institute of Technology and/or Japan Science and Technology
 * Corporation have been advised of the possibility of such damage.  See
 * the GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this library; if not, write to the Free Software Foundation,
 * Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA.
 *
 * The original code contained here was initially developed by:
 *
 *     Ben Bornstein
 *     The Systems Biology Markup Language Development Group
 *     ERATO Kitano Symbiotic Systems Project
 *     Control and Dynamical Systems, MC 107-81
 *     California Institute of Technology
 *     Pasadena, CA, 91125, USA
 *
 *     http://www.cds.caltech.edu/erato
 *     mailto:sbml-team@caltech.edu
 *
 * Contributor(s):
 */


#include <sbml/common/common.h>
#include <sbml/math/FormulaParser.h>

#include <sbml/SBase.h>
#include <sbml/Event.h>
#include <sbml/EventAssignment.h>
#include <sbml/Trigger.h>
#include <sbml/Delay.h>
#include <sbml/xml/XMLNamespaces.h>
#include <sbml/SBMLDocument.h>

#include <check.h>



static Event_t *E;


void
EventTest_setup (void)
{
  E = Event_create(2, 4);

  if (E == NULL)
  {
    fail("Event_create() returned a NULL pointer.");
  }
}


void
EventTest_teardown (void)
{
  Event_free(E);
}


START_TEST (test_Event_create)
{
  fail_unless( SBase_getTypeCode  ((SBase_t *) E) == SBML_EVENT );
  fail_unless( SBase_getMetaId    ((SBase_t *) E) == NULL );
  fail_unless( SBase_getNotes     ((SBase_t *) E) == NULL );
  fail_unless( SBase_getAnnotation((SBase_t *) E) == NULL );

  fail_unless( Event_getId        (E) == NULL );
  fail_unless( Event_getName      (E) == NULL );
  fail_unless( Event_getTrigger   (E) == NULL );
  fail_unless( Event_getDelay     (E) == NULL );
  fail_unless( Event_getTimeUnits (E) == NULL );

  fail_unless( Event_getNumEventAssignments(E) == 0 );
}
END_TEST


//START_TEST (test_Event_createWith)
//{
//  Event_t   *e       = Event_createWith("e1", "");
//
//
//  fail_unless( SBase_getTypeCode  ((SBase_t *) e) == SBML_EVENT );
//  fail_unless( SBase_getMetaId    ((SBase_t *) e) == NULL );
//  fail_unless( SBase_getNotes     ((SBase_t *) e) == NULL );
//  fail_unless( SBase_getAnnotation((SBase_t *) e) == NULL );
//
//  fail_unless( Event_getName      (e) == NULL );
//  fail_unless( Event_getDelay     (e) == NULL );
//  fail_unless( Event_getTimeUnits (e) == NULL );
//
//  fail_unless( Event_getNumEventAssignments(e) == 0 );
//
//  fail_unless( !Event_isSetTrigger(e) );
//
//  fail_unless( !strcmp(Event_getId(e), "e1") );
//  fail_unless( Event_isSetId(e) );
//
//  Event_free(e);
//}
//END_TEST


START_TEST (test_Event_free_NULL)
{
  Event_free(NULL);
}
END_TEST


START_TEST (test_Event_setId)
{
  char *id = "e1";


  Event_setId(E, id);

  fail_unless( !strcmp(Event_getId(E), id) );
  fail_unless( Event_isSetId(E) );

  if (Event_getId(E) == id)
  {
    fail("Event_setId(...) did not make a copy of string.");
  }

  /* Reflexive case (pathological) */
  Event_setId(E, Event_getId(E));
  fail_unless( !strcmp(Event_getId(E), id) );

  Event_setId(E, NULL);
  fail_unless( !Event_isSetId(E) );

  if (Event_getId(E) != NULL)
  {
    fail("Event_setId(E, NULL) did not clear string.");
  }
}
END_TEST


START_TEST (test_Event_setName)
{
  char *name = "Set_k2";


  Event_setName(E, name);

  fail_unless( !strcmp(Event_getName(E), name) );
  fail_unless( Event_isSetName(E) );

  if (Event_getName(E) == name)
  {
    fail("Event_setName(...) did not make a copy of string.");
  }

  /* Reflexive case (pathological) */
  Event_setName(E, Event_getName(E));
  fail_unless( !strcmp(Event_getName(E), name) );

  Event_setName(E, NULL);
  fail_unless( !Event_isSetName(E) );

  if (Event_getName(E) != NULL)
  {
    fail("Event_setName(E, NULL) did not clear string.");
  }
}
END_TEST


START_TEST (test_Event_setTrigger)
{
  ASTNode_t         *math1   = SBML_parseFormula("0");
  Trigger_t   *trigger = Trigger_create(2, 4);
  Trigger_setMath(trigger, math1);


  Event_setTrigger(E, trigger);

  fail_unless( Event_getTrigger(E) != NULL );
  fail_unless( Event_isSetTrigger(E) );

  if (Event_getTrigger(E) == trigger)
  {
    fail("Event_setTrigger(...) did not make a copy of trigger.");
  }

  ///* Reflexive case (pathological) */
  Event_setTrigger(E, (Trigger_t *) Event_getTrigger(E));
  fail_unless( Event_getTrigger(E) != trigger );

  Event_setTrigger(E, NULL);
  fail_unless( !Event_isSetTrigger(E) );

  if (Event_getTrigger(E) != NULL)
  {
    fail("Event_setTrigger(E, NULL) did not clear trigger.");
  }
}
END_TEST


START_TEST (test_Event_setDelay)
{
  ASTNode_t         *math1   = SBML_parseFormula("0");
  Delay_t   *Delay = Delay_create(2, 4);
  Delay_setMath(Delay, math1);


  Event_setDelay(E, Delay);

  fail_unless( Event_getDelay(E) != NULL );
  fail_unless( Event_isSetDelay(E) );

  if (Event_getDelay(E) == Delay)
  {
    fail("Event_setDelay(...) did not make a copy of Delay.");
  }

  /* Reflexive case (pathological) */
  Event_setDelay(E, Event_getDelay(E));
  fail_unless( Event_getDelay(E) != Delay );

  Event_setDelay(E, NULL);
  fail_unless( !Event_isSetDelay(E) );

  if (Event_getDelay(E) != NULL)
  {
    fail("Event_setDelay(E, NULL) did not clear Delay.");
  }
}
END_TEST


START_TEST (test_Event_setTimeUnits)
{
  Event_t *E1 = Event_create(2, 1);
  char *units = "second";


  Event_setTimeUnits(E1, units);

  fail_unless( !strcmp(Event_getTimeUnits(E1), units) );
  fail_unless( Event_isSetTimeUnits(E1) );

  if (Event_getTimeUnits(E1) == units)
  {
    fail("Event_setTimeUnits(...) did not make a copy of string.");
  }

  /* Reflexive case (pathological) */
  Event_setTimeUnits(E1, Event_getTimeUnits(E1));
  fail_unless( !strcmp(Event_getTimeUnits(E1), units) );

  Event_setTimeUnits(E1, NULL);
  fail_unless( !Event_isSetTimeUnits(E1) );

  if (Event_getTimeUnits(E1) != NULL)
  {
    fail("Event_setTimeUnits(E, NULL) did not clear string.");
  }

  Event_free(E1);
}
END_TEST


START_TEST (test_Event_full)
{
  ASTNode_t         *math1   = SBML_parseFormula("0");
  Trigger_t   *trigger = Trigger_create(2, 4);
  ASTNode_t         *math    = SBML_parseFormula("0");
  Event_t           *e       = Event_create(2, 4);
  EventAssignment_t *ea      = EventAssignment_create(2, 4);
  EventAssignment_setVariable(ea, "k");
  EventAssignment_setMath(ea, math);
  
  Trigger_setMath(trigger, math1);
  
  Event_setTrigger(e, trigger);

  Event_setId(e, "e1");
  Event_setName(e, "Set k2 to zero when P1 <= t");
  Event_addEventAssignment(e, ea);

  fail_unless( Event_getNumEventAssignments(e) ==  1 );
  fail_unless( Event_getEventAssignment(e, 0)  != ea );

  ASTNode_free(math);
  Event_free(e);
}
END_TEST


START_TEST (test_Event_setUseValuesFromTriggerTime)
{
  Event_t *object = 
    Event_create(2, 4);

  Event_setUseValuesFromTriggerTime(object, 0);

  fail_unless( Event_getUseValuesFromTriggerTime(object) == 0 );

  Event_setUseValuesFromTriggerTime(object, 1);

  fail_unless( Event_getUseValuesFromTriggerTime(object) == 1 );

  Event_free(object);
}
END_TEST


START_TEST (test_Event_createWithNS )
{
  XMLNamespaces_t *xmlns = XMLNamespaces_create();
  XMLNamespaces_add(xmlns, "http://www.sbml.org", "testsbml");
  SBMLNamespaces_t *sbmlns = SBMLNamespaces_create(2,4);
  SBMLNamespaces_addNamespaces(sbmlns,xmlns);

  Event_t *object = 
    Event_createWithNS (sbmlns);


  fail_unless( SBase_getTypeCode  ((SBase_t *) object) == SBML_EVENT );
  fail_unless( SBase_getMetaId    ((SBase_t *) object) == NULL );
  fail_unless( SBase_getNotes     ((SBase_t *) object) == NULL );
  fail_unless( SBase_getAnnotation((SBase_t *) object) == NULL );

  fail_unless( SBase_getLevel       ((SBase_t *) object) == 2 );
  fail_unless( SBase_getVersion     ((SBase_t *) object) == 4 );

  fail_unless( Event_getNamespaces     (object) != NULL );
  fail_unless( XMLNamespaces_getLength(Event_getNamespaces(object)) == 2 );

  Event_free(object);
}
END_TEST


START_TEST (test_Event_removeEventAssignment)
{
  EventAssignment_t *o1, *o2, *o3;

  o1 = Event_createEventAssignment(E);
  o2 = Event_createEventAssignment(E);
  o3 = Event_createEventAssignment(E);
  EventAssignment_setVariable(o3,"test");

  fail_unless( Event_removeEventAssignment(E,0) == o1 );
  fail_unless( Event_getNumEventAssignments(E)  == 2  );
  fail_unless( Event_removeEventAssignment(E,0) == o2 );
  fail_unless( Event_getNumEventAssignments(E)  == 1  );
  fail_unless( Event_removeEventAssignmentByVar(E,"test") == o3 );
  fail_unless( Event_getNumEventAssignments(E)  == 0  );

  EventAssignment_free(o1);
  EventAssignment_free(o2);
  EventAssignment_free(o3);

}
END_TEST

Suite *
create_suite_Event (void)
{
  Suite *suite = suite_create("Event");
  TCase *tcase = tcase_create("Event");


  tcase_add_checked_fixture( tcase,
                             EventTest_setup,
                             EventTest_teardown );

  tcase_add_test( tcase, test_Event_create       );
  //tcase_add_test( tcase, test_Event_createWith   );
  tcase_add_test( tcase, test_Event_free_NULL    );
  tcase_add_test( tcase, test_Event_setId        );
  tcase_add_test( tcase, test_Event_setName      );
  tcase_add_test( tcase, test_Event_setTrigger   );
  tcase_add_test( tcase, test_Event_setDelay     );
  tcase_add_test( tcase, test_Event_setTimeUnits );
  tcase_add_test( tcase, test_Event_full         );
  tcase_add_test( tcase, test_Event_setUseValuesFromTriggerTime );
  tcase_add_test( tcase, test_Event_createWithNS         );
  tcase_add_test( tcase, test_Event_removeEventAssignment  );

  suite_add_tcase(suite, tcase);

  return suite;
}