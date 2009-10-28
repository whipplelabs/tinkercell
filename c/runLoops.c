#include "TC_api.h"

void run();
void setup();

int functionMissing()
{
	if (!tc_addFunction || 
		!tc_createInputWindow ||
		!tc_addInputWindowOptions ||
		!tc_selectedItems ||
		!tc_allItems ||
		!tc_errorReport ||
		!tc_getModelParameters ||
		!tc_getNames || 
		!tc_itemsOfFamilyFrom ||
		!tc_getFromList ||
		!tc_writeModel ||
		!tc_print ||
		!tc_getFromList ||
		!tc_compileBuildLoad ||
		!tc_plot ||
		!tc_isWindows)
		
		return 1;
		
		
	return 0;
}

void tc_main()
{
	if (functionMissing()) return;
	//add function to menu. args : function, name, description, category, icon file, target part/connection family, in functions list?, in context menu?  
	tc_addFunction(&run, "Find loops", "loops in the Jacobian can sometimes indicate bistability or oscillations", "Network structure", "Plugins/c/nodedges.PNG", "", 1, 0, 0);
}


void run()
{
	int k;
	Array A;
	FILE * out;
	
	A = tc_selectedItems();
	
	if (A[0] == 0)
		A = tc_allItems();
    
	if (A[0] != 0)
	{
	   k = tc_writeModel( "runloops", A );
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
   
   out = fopen("runloops.c","a");

   fprintf( out , "\
#include \"TC_api.h\"\n\
#include \"cvodesim.h\"\n\
#include \"loops.h\"\n\
int run(Matrix M)\n\
{\n\
   int i,j;\n\
   TCinitialize();\n\
   double * J = jacobian2(TCvars,TCreactions,TCstoic,&(TCpropensity),TCinit,0);\n\
   LoopsInformation info = getLoops(J,TCvars);\n\
    for (i=0; i < info.numLoops; ++i)\n\
	{\n\
		if (info.loopTypes[i] > 0)\n\
			tc_print(\"negative loop:\");\n\
		else\n\
			tc_print(\"positive loop:\");\n\
		for (j=0; j < info.loopLengths[i]; ++j)\n\
		{\n\
			tc_print(TCvarnames[ info.nodes[i][j] ]);\n\
			if (info.loopTypes[i] > 0) \n\
				tc_highlight( tc_find(TCvarnames[ info.nodes[i][j] ]), 255, 0, 0 );\n\
			else\n\
				tc_highlight( tc_find(TCvarnames[ info.nodes[i][j] ]), 0, 0, 255 );\n\
		}\n\
		tc_print(\"\\n\");\n\
	}\n\
   freeLoopsInfo(info);\n\
   free(J);\n\
   return;\n\
}");


   fclose(out);
   return;
}