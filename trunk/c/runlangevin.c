/****************************************************************************
**
**	This file creates an input window which allows users to run the runcvode.c code
**	with specific inputs for start time, end time, step size, and x-axis
** And...
** gets information from TinkerCell, generates a stochastic differential equation model, runs
** the simulation, and outputs the data to TinkerCell
**
****************************************************************************/

#include "TC_api.h"

void run();
void setup();


void tc_main()
{
	//add function to menu. args : function, name, description, category, icon file, target part/connection family, in functions list?, in context menu?
	tc_addFunction(&setup, "Continuous stochastic simulation", "uses Langevin method (compiles to C program)", "Simulate", "Plugins/c/stochastic.PNG", "", 1, 0, 0);
}

void setup(Matrix input)
{
	Matrix m;
	char * cols[] = { "value",0 };
	char * rows[] = { "model", "time", "step size",0 };
	double values[] = { 0.0, 100, 0.1 };
	char * options[] = { "Full model", "Selected only", 0 }; //null terminated -- very very important

	m.rows = 3;
	m.cols = 1;
	m.colnames = cols;
	m.rownames = rows;
	m.values = values;

	tc_createInputWindow(m,"Langevin simulation",&run);
	//tc_createInputWindow(m,"dlls/runlangevin","run","Langevin Simulation");
	tc_addInputWindowOptions("Langevin Simulation",0, 0,  options);

	return;
}

void run(Matrix input)
{
	double start = 0.0, end = 50.0;
	double dt = 0.1;
	int xaxis = 0, sz, k;
	int selection = 0;
	Array A;
	FILE * out;

	if (input.cols > 0)
	{
		if (input.rows > 0)
			selection = (int)valueAt(input,0,0);
		if (input.rows > 1)
			end = valueAt(input,1,0);
		if (input.rows > 2)
			dt = valueAt(input,2,0);
		if (input.rows > 3)
			xaxis = (int)valueAt(input,3,0);
	}

	sz = (int)((end - start) / dt);

	A;
	if (selection > 0)
	{
		A = tc_selectedItems();
		if (A[0] == 0)
		{
			TCFreeArray(A);
			//A = tc_allItems();
			tc_errorReport("No Model Selected\0");
			return;

		}
	}
	else
	{
		A = tc_allItems();
	}

	if (A[0] != 0)
	{
		k = tc_writeModel( "langevin", A );
		TCFreeArray(A);
		if (!k)
		{
			tc_errorReport("No Model\0");
			return;
		}
	}
	else
	{
		TCFreeArray(A);
		tc_errorReport("No Model\0");
		return;
	}

	out = fopen("langevin.c","a");

	fprintf( out , "\
#include \"TC_api.h\"\n#include \"langevin.h\"\n\n\
static double _time0_ = 0.0;\n\
void ssaFunc(double time, double * u, double * rates, void * data)\n\
{\n\
	TCpropensity(time, u, rates, data);\n\
	if (time > _time0_)\n\
	{\n\
		tc_showProgress(\"Langevin Simulation\",(int)(100 * time/%lf));\n\
		_time0_ += %lf;\n\
	}\n\
}\n\
\n\
\n\
void run() \n\
{\n\
	int i,j;\n\
	Matrix data;\n\
	TCmodel * model = (TCmodel*)malloc(sizeof(TCmodel));\n\
	initMTrand();\n\
	(*model) = TC_initial_model;\n\
	TCinitialize(model);\n\
	double * y = Langevin(TCvars, TCreactions, TCstoic, &(ssaFunc), TCinit, %lf, %lf, (void*)model);\n\
	if (!y) \
	{\n\
		tc_errorReport(\"CVode failed! Possible cause of failure: some values are reaching infinity. Double check your model.\");\n\
		return;\n\
	}\n\
	free(model);\n\
	data.rows = %i;\n\
	data.cols = 1+TCvars;\n\
	data.values = y;\n\
	data.rownames = 0;\n\
	data.colnames = malloc( (1+TCvars) * sizeof(char*) );\n\
	data.colnames[0] = \"time\\0\";\n\
	for (i=0; i<TCvars; ++i) data.colnames[1+i] = TCvarnames[i];\n\
	tc_plot(data,%i,\"Time Course Simulation\",0);\n\
	free(data.colnames);  free(y);\n\
	return;\n}\n", (end-start), (end-start)/20.0, end, dt, sz, xaxis);
	fclose(out);

	tc_compileBuildLoad("langevin.c -lodesim -lssa\0","run\0","Langevin Simulation\0");

	return;

}




