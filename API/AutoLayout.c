#include "TC_autolayout.h"

TCAPIEXPORT 
void Autolayout(tc_matrix positions, double spring, double charge, double damping, double threshold)
{
	int i;
	tc_matrix nodes = tc_createMatrix(positions.rows, 5);
	for (i=0; i < nodes.rows; ++i)
	{
		tc_setMatrixValue(nodes, i, 0, tc_getMatrixValue(positions, i, 0));
		tc_setMatrixValue(nodes, i, 1, tc_getMatrixValue(positions, i, 1));
		tc_setMatrixValue(nodes, i, 2, tc_getMatrixValue(positions, i, 2));
		tc_setMatrixValue(nodes, i, 3, 0.0);
		tc_setMatrixValue(nodes, i, 4, 0.0);
	}
	while (ApplySpringForce(nodes, spring, charge, damping) > threshold)
	{
		//keep going
	}
}

TCAPIEXPORT 
double ApplySpringForce(tc_matrix nodes, double spring, double charge, double damping)
{
	int i,j;
	int X=0, Y=1, Mass=2, DX=3, DY=4;
	double dx, dy, hypotenuse, force, sum_velocity=0.0;
	
	if (nodes.cols < 5) return -1.0;

	for (i=0; i < nodes.rows; ++i)
	{
		for (j=0; j < nodes.rows; ++j)
		{
			if (i != j)
			{
				dx = tc_getMatrixValue(nodes, j, X) - tc_getMatrixValue(nodes, i, X);
				dy = tc_getMatrixValue(nodes, j, Y) - tc_getMatrixValue(nodes, i, Y);
				hypotenuse = sqrt(pow(dx, 2) + pow(dy, 2));
				force = 0;
				
				if (node.IsConnectedTo(otherNode))
				{
					force = (hypotenuse - spring) / 2.0;
				}
				else
				{
					force = -((tc_getMatrixValue(nodes, i, Mass) * tc_getMatrixValue(nodes, j, Mass)) / pow(hypotenuse, 2)) * charge;
				}
				dx /= hypotenuse;
				dy /= hypotenuse;
				dx *= force;
				dy *= force;
				tc_setMatrixValue(nodes, i, DX,  tc_getMatrixValue(nodes, i, DX) + dx);
				tc_setMatrixValue(nodes, i, DY,  tc_getMatrixValue(nodes, i, DY) + dy);
			}
		}
		
		tc_setMatrixValue(nodes, i, X,  tc_getMatrixValue(nodes, i, X) + tc_getMatrixValue(nodes, i, DX));
		tc_setMatrixValue(nodes, i, Y,  tc_getMatrixValue(nodes, i, Y) + tc_getMatrixValue(nodes, i, DY));
		
		tc_setMatrixValue(nodes, i, DX,  tc_getMatrixValue(nodes, i, DX) * damping);
		tc_setMatrixValue(nodes, i, DY,  tc_getMatrixValue(nodes, i, DY) * damping);
		
		sum_velocity += sqrt(
									tc_getMatrixValue(nodes, i, DX)*tc_getMatrixValue(nodes, i, DX) + 
									tc_getMatrixValue(nodes, i, DY)*tc_getMatrixValue(nodes, i, DY));
	}
	return sum_velocity;
}
