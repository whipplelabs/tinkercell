#ifndef TINKERCELL_TC_CONNECTIONSELECTION_API_H
#define TINKERCELL_TC_CONNECTIONSELECTION_API_H

#include "../TCstructs.h"

/*! 
 \brief get x position of a control point
 \ingroup Control points
*/
double tc_getControlPointX(Item connection,Item part,int whichPoint);
/*! 
 \brief get y position of a control point
 \ingroup Control points
*/
double tc_getControlPointY(Item connection,Item part,int whichPoint);
/*! 
 \brief set x and y position of a control point
 \param Item the connection
 \param Item the node that is associated with the particular curve of interest
 \param int the index of the point on that curve of interest
 \param double x value
 \param double y value
 \ingroup Control points
*/
void tc_setControlPoint(Item connection,Item part,int whichPoint, double x,double y);
/*! 
 \brief set x and y position of the central control point
 \ingroup Control points
*/
void tc_setCenterPoint(Item connection,double y,double x);
/*! 
 \brief get x position of the central control point
 \ingroup Control points
*/
double tc_getCenterPointX(Item connection);
/*! 
 \brief get y position of the central control point
 \ingroup Control points
*/
double tc_getCenterPointY(Item connection);
/*! 
 \brief switch between beziers and lines for drawing the connector, where 1 = line, 0 = bezier
 \ingroup Control points
*/
void tc_setStraight(Item item,int straight);
/*! 
 \brief switch between beziers and lines for drawing the connector, where 1 = line, 0 = bezier
 \ingroup Control points
*/
void tc_setAllStraight(int straight);
/*! 
 \brief set the line width. Indicate whether the change should be temporary or permanent.
 \ingroup Control points
*/
void tc_setLineWidth(Item item,double width, int permanent);

/*! 
 \brief initialize control point functions
 \ingroup init
*/
void tc_ConnectionSelection_api(
		double (*getControlPointX)(Item,Item,int),
		double (*getControlPointY)(Item,Item,int),
		void (*setControlPoint)(Item,Item,int,double,double),
		void (*setCenterPoint)(Item,double,double),
		double (*getCenterPointX)(Item),
		double (*getCenterPointY)(Item),
		void (*setStraight)(Item,int),
		void (*setAllStraight)(int),
		void (*setLineWidth)(Item,double,int)
	);

#endif
