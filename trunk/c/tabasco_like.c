#include "TC_api.h"
int run(Matrix input)
{
   int i,j,k;
   Array A = tc_selectedItems();
   int numSteps = (int)(tc_getNumber("number of steps:\0"));

   if (numSteps > 0) 
   for (i=0; A[i]!=0; ++i)
   {
        if (tc_isA(A[i],"Connection"))
        {
            Array parts = tc_getConnectedParts(A[i]);
            if (parts && parts[0] && parts[1] && (parts[2] == 0))
            {
                Matrix newN;
                newN.cols = numSteps + 1;
                if (newN.cols > 1)
                {
                      char* rxnname = tc_getName(A[i]);
                      char** partnames = tc_getNames(parts);
                      newN.rows = newN.cols;
                      newN.colnames = malloc ( (1+newN.cols) * sizeof(char*) );
                      newN.colnames[newN.cols] = 0;
                      newN.rownames = malloc( (1+newN.rows) * sizeof(char*) );
                      newN.rownames[newN.rows] = 0;
                      newN.values = malloc( newN.rows * newN.cols * sizeof(double) );

                     newN.rownames[0] = partnames[0];
                     newN.rownames[ newN.rows-1 ] = partnames[1];

                     for (j=0; j < newN.rows; ++j)
                          for (k=0; k < newN.cols; ++k)
                                 valueAt(newN,j,k) = 0.0;
                     for (k=0; k < newN.cols; ++k)
                     {
							if (k+1 < newN.rows)
							{
								valueAt(newN,k,k) = -1.0;														
								valueAt(newN,k+1,k) =  1.0;
							}
							else
							{
								valueAt(newN,k-1,k) = -1.0;
							}
                            if (k > 0 && k+1 < newN.rows)
                            {
                                  newN.rownames[k] = malloc(30 * sizeof(char));
                                  sprintf(newN.rownames[k], "%s.%s.I%i\0",rxnname,partnames[0],k);
                            }
                            newN.colnames[k] = malloc(30 * sizeof(char));
							if (k+1 < newN.rows)
								sprintf(newN.colnames[k], "%s.k0*%s\0",rxnname,newN.rownames[k]);
							else
								sprintf(newN.colnames[k], "%s.leak*%s\0",rxnname,newN.rownames[k-1]);
                     }
					 if (tc_isA(parts[0],"Regulatory\0"))
						valueAt(newN,0,0) = 0.0;
					 if (tc_isA(parts[1],"Terminator\0"))
						valueAt(newN,newN.rows-1,newN.cols-2) = 0.0;
					 tc_setParameter(A[i],"k0",0.1);
					 tc_setParameter(A[i],"leak",0.01);
                     tc_printTable(newN);
                     OBJ j[] = { A[i] , 0 };
                     char ** rates = newN.colnames;
                     newN.colnames = 0;
                     tc_setStoichiometry(j , newN);
                     newN.colnames = rates;
					 tc_setRates(j,newN.colnames);
                     TCFreeMatrix(newN);
                }
            }
            TCFreeArray(parts);
        }
   }

  TCFreeArray(A);

  return 1; 
}
