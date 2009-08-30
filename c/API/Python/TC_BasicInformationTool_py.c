#include <stdlib.h>
#include <stdio.h>
#include <Python.h>
#include "../../TC_api.h"

static PyObject * pytc_modelParameters(PyObject *self, PyObject *args)
{
	int i;
	PyObject * pylist = 0, *item;
	PyObject * params, *values, *twoTuples;
	Matrix M;
	void ** array;
	int n, isList;

	if(!PyArg_ParseTuple(args, "|O", &pylist) ||
		(tc_getModelParameters == 0) ||
		(tc_allItems == 0)
		)
		return NULL;

	isList = 1;
	n = 1;
	if (pylist)
	{
		isList = PyList_Check(pylist);
		n = isList ? PyList_Size(pylist) : PyTuple_Size (pylist);
	}
	


	if (n > 0)
	{
		if (pylist)
		{
			array = malloc( (1+n) * sizeof(void*) );
			array[n] = 0;

			for(i=0; i<n; ++i) 
			{ 
				array[i] = isList ? (void*)((int)PyInt_AsLong( PyList_GetItem( pylist, i ) )) : (void*)((int)PyInt_AsLong( PyTuple_GetItem( pylist, i ) ));
			}
		}
		else
		{
			array = tc_allItems();
		}
		M = tc_getModelParameters(array);
		free(array);

		if (M.rows > 0 && M.values && M.rownames)
		{
			params = PyTuple_New(M.rows);
			values = PyTuple_New(M.rows);

			for (i=0; i < M.rows; i++) 
			{
				item = Py_BuildValue("s",M.rownames[i]);
				PyTuple_SetItem(params, i, item);

				item = Py_BuildValue("d",valueAt(M,i,0));
				PyTuple_SetItem(values, i, item);
			}
			TCFreeMatrix(M);
		}
		else
		{
			params = PyTuple_New(0);
			values = PyTuple_New(0);
		}

	}

	twoTuples = PyTuple_New(2);
	PyTuple_SetItem(twoTuples,0,params);
	PyTuple_SetItem(twoTuples,1,values);

	return Py_BuildValue("O",twoTuples);
}


static PyObject * pytc_allParameters(PyObject *self, PyObject *args)
{
	int i;
	PyObject * pylist = 0, *item;
	PyObject * params, *values, *twoTuples;
	Matrix M;
	void ** array;
	int n, isList;

	if(!PyArg_ParseTuple(args, "|O", &pylist) ||
		(tc_getParameters == 0) ||
		(tc_allItems == 0))
		return NULL;

	isList = 1;
	n = 1;
	if (pylist)
	{
		isList = PyList_Check(pylist);
		n = isList ? PyList_Size(pylist) : PyTuple_Size (pylist);
	}
	
	if (n > 0)
	{
		if (pylist)
		{
			array = malloc( (1+n) * sizeof(void*) );
			array[n] = 0;

			for(i=0; i<n; ++i) 
			{ 
				array[i] = isList ? (void*)((int)PyInt_AsLong( PyList_GetItem( pylist, i ) )) : (void*)((int)PyInt_AsLong( PyTuple_GetItem( pylist, i ) ));
			}
		}
		else
		{
			array = tc_allItems();
		}

		M = tc_getParameters(array);
		free(array);

		if (M.rows > 0 && M.values && M.rownames)
		{
			params = PyTuple_New(M.rows);
			values = PyTuple_New(M.rows);

			for (i=0; i < M.rows; i++) 
			{
				item = Py_BuildValue("s",M.rownames[i]);
				PyTuple_SetItem(params, i, item);

				item = Py_BuildValue("d",valueAt(M,i,0));
				PyTuple_SetItem(values, i, item);
			}
			TCFreeMatrix(M);
		}
		else
		{
			params = PyTuple_New(0);
			values = PyTuple_New(0);
		}

	}

	twoTuples = PyTuple_New(2);
	PyTuple_SetItem(twoTuples,0,params);
	PyTuple_SetItem(twoTuples,1,values);

	return Py_BuildValue("O",twoTuples);
}

static PyObject * pytc_allInitialValues(PyObject *self, PyObject *args)
{
	int i;
	PyObject * pylist = 0, *item;
	PyObject * params, *values, *twoTuples;
	Matrix M;
	void ** array;
	int n, isList;

	if(!PyArg_ParseTuple(args, "|O", &pylist) ||
		(tc_getInitialValues == 0) ||
		(tc_allItems == 0))
		return NULL;

	isList = 1;
	n = 1;
	if (pylist)
	{
		isList = PyList_Check(pylist);
		n = isList ? PyList_Size(pylist) : PyTuple_Size (pylist);
	}
	
	if (n > 0)
	{
		if (pylist)
		{
			array = malloc( (1+n) * sizeof(void*) );
			array[n] = 0;

			for(i=0; i<n; ++i) 
			{ 
				array[i] = isList ? (void*)((int)PyInt_AsLong( PyList_GetItem( pylist, i ) )) : (void*)((int)PyInt_AsLong( PyTuple_GetItem( pylist, i ) ));
			}
		}
		else
		{
			array = tc_allItems();
		}

		M = tc_getInitialValues(array);
		free(array);

		if (M.rows > 0 && M.values && M.rownames)
		{
			params = PyTuple_New(M.rows);
			values = PyTuple_New(M.rows);

			for (i=0; i < M.rows; i++) 
			{
				item = Py_BuildValue("s",M.rownames[i]);
				PyTuple_SetItem(params, i, item);

				item = Py_BuildValue("d",valueAt(M,i,0));
				PyTuple_SetItem(values, i, item);
			}
			TCFreeMatrix(M);
		}
		else
		{
			params = PyTuple_New(0);
			values = PyTuple_New(0);
		}

	}

	twoTuples = PyTuple_New(2);
	PyTuple_SetItem(twoTuples,0,params);
	PyTuple_SetItem(twoTuples,1,values);

	return Py_BuildValue("O",twoTuples);
}

static PyObject * pytc_allFixedVars(PyObject *self, PyObject *args)
{
	int i;
	PyObject * pylist = 0, *item;
	int isList = 1;
	int n = 1;
	PyObject * params, *values, *twoTuples;
	Matrix M;
	void ** array;

	if(!PyArg_ParseTuple(args, "|O", &pylist) ||
		(tc_getFixedVariables == 0) ||
		(tc_allItems == 0))
		return NULL;

	if (pylist)
	{
		isList = PyList_Check(pylist);
		n = isList ? PyList_Size(pylist) : PyTuple_Size (pylist);
	}
	if (n > 0)
	{
		if (pylist)
		{
			array = malloc( (1+n) * sizeof(void*) );
			array[n] = 0;

			for(i=0; i<n; ++i) 
			{ 
				array[i] = isList ? (void*)((int)PyInt_AsLong( PyList_GetItem( pylist, i ) )) : (void*)((int)PyInt_AsLong( PyTuple_GetItem( pylist, i ) ));
			}
		}
		else
		{
			array = tc_allItems();
		}

		M = tc_getFixedVariables(array);
		free(array);

		if (M.rows > 0 && M.values && M.rownames)
		{
			params = PyTuple_New(M.rows);
			values = PyTuple_New(M.rows);

			for (i=0; i < M.rows; i++) 
			{
				item = Py_BuildValue("s",M.rownames[i]);
				PyTuple_SetItem(params, i, item);

				item = Py_BuildValue("d",valueAt(M,i,0));
				PyTuple_SetItem(values, i, item);
			}
			TCFreeMatrix(M);
		}
		else
		{
			params = PyTuple_New(0);
			values = PyTuple_New(0);
		}

	}

	twoTuples = PyTuple_New(2);
	PyTuple_SetItem(twoTuples,0,params);
	PyTuple_SetItem(twoTuples,1,values);

	return Py_BuildValue("O",twoTuples);
}

static PyObject * pytc_allParamsAndFixedVars(PyObject *self, PyObject *args)
{
	int i;
	PyObject * pylist = 0, *item;
	int isList = 1;
	int n = 1;
	Matrix M;
	PyObject * params, *values, *twoTuples;
	void ** array;

	if(!PyArg_ParseTuple(args, "|O", &pylist) ||
		(tc_getParametersAndFixedVariables == 0) ||
		(tc_allItems == 0))
		return NULL;

	if (pylist)
	{
		isList = PyList_Check(pylist);
		n = isList ? PyList_Size(pylist) : PyTuple_Size (pylist);
	}
	if (n > 0)
	{
		if (pylist)
		{
			array = malloc( (1+n) * sizeof(void*) );
			array[n] = 0;

			for(i=0; i<n; ++i) 
			{ 
				array[i] = isList ? (void*)((int)PyInt_AsLong( PyList_GetItem( pylist, i ) )) : (void*)((int)PyInt_AsLong( PyTuple_GetItem( pylist, i ) ));
			}
		}
		else
		{
			array = tc_allItems();
		}

		M = tc_getParametersAndFixedVariables(array);
		free(array);

		if (M.rows > 0 && M.values && M.rownames)
		{
			params = PyTuple_New(M.rows);
			values = PyTuple_New(M.rows);

			for (i=0; i < M.rows; i++) 
			{
				item = Py_BuildValue("s",M.rownames[i]);
				PyTuple_SetItem(params, i, item);

				item = Py_BuildValue("d",valueAt(M,i,0));
				PyTuple_SetItem(values, i, item);
			}
			TCFreeMatrix(M);
		}
		else
		{
			params = PyTuple_New(0);
			values = PyTuple_New(0);
		}

	}

	twoTuples = PyTuple_New(2);
	PyTuple_SetItem(twoTuples,0,params);
	PyTuple_SetItem(twoTuples,1,values);

	return Py_BuildValue("O",twoTuples);
}

static PyObject * pytc_getTextAttribute(PyObject *self, PyObject *args)
{
	int i;
	char * s;
	char * c;

	if(!PyArg_ParseTuple(args, "is", &i, &s) ||
		(tc_getTextAttribute == 0))
		return NULL;

	c = tc_getTextAttribute((void*)i,s);

	return Py_BuildValue("s",c);
}

static PyObject * pytc_getParameter(PyObject *self, PyObject *args)
{
	int i;
	char * s;
	double d;

	if(!PyArg_ParseTuple(args, "is", &i, &s) ||
		(tc_getParameter == 0))
		return NULL;

	d = tc_getParameter((void*)i,s);

	return Py_BuildValue("d",d);
}


static PyObject * pytc_getParametersNamed(PyObject *self, PyObject *args)
{
	PyObject * params, *values, *twoTuples;
	Matrix M;
	void ** array1;
	char ** array2;
	int i, n1, n2, isList1, isList2;
	PyObject * pylist1, * pylist2, *item;
	
	if(!PyArg_ParseTuple(args, "OO", &pylist1, &pylist2) ||
		(tc_getParametersNamed == 0))
		return NULL;

	isList1 = PyList_Check(pylist1);
	n1 = isList1 ? PyList_Size(pylist1) : PyTuple_Size (pylist1);

	isList2 = PyList_Check(pylist2);
	n2 = isList2 ? PyList_Size(pylist2) : PyTuple_Size (pylist2);

	if (n1 > 0 && n2 > 0)
	{
		array1 = malloc( (1+n1) * sizeof(void*) );
		array1[n1] = 0;

		array2 = malloc( (1+n2) * sizeof(char*) );
		array2[n2] = 0;

		for(i=0; i<n1; ++i) 
		{ 
			array1[i] = isList1 ? (void*)((int)PyInt_AsLong( PyList_GetItem( pylist1, i ) )) : (void*)((int)PyInt_AsLong( PyTuple_GetItem( pylist1, i ) ));
		}

		for(i=0; i<n2; ++i) 
		{ 
			array2[i] = isList2 ? PyString_AsString( PyList_GetItem( pylist2, i ) ) : PyString_AsString( PyTuple_GetItem( pylist2, i ));
		}

		M = tc_getParametersNamed(array1,array2);
		free(array1);
		free(array2);

		if (M.rows > 0 && M.values && M.rownames)
		{
			params = PyTuple_New(M.rows);
			values = PyTuple_New(M.rows);

			for (i=0; i < M.rows; i++) 
			{
				item = Py_BuildValue("s",M.rownames[i]);
				PyTuple_SetItem(params, i, item);

				item = Py_BuildValue("d",valueAt(M,i,0));
				PyTuple_SetItem(values, i, item);
			}
			TCFreeMatrix(M);
		}
		else
		{
			params = PyTuple_New(0);
			values = PyTuple_New(0);
		}

	}

	twoTuples = PyTuple_New(2);
	PyTuple_SetItem(twoTuples,0,params);
	PyTuple_SetItem(twoTuples,1,values);

	return Py_BuildValue("O",twoTuples);
}

static PyObject * pytc_getParametersExcept(PyObject *self, PyObject *args)
{
	PyObject * params, *values, *twoTuples;
	Matrix M;
	void ** array1;
	char ** array2;
	int isList1, isList2, n1, n2,i;
	PyObject * pylist1, * pylist2, *item;

	if(!PyArg_ParseTuple(args, "OO", &pylist1, &pylist2) ||
		(tc_getParametersExcept == 0))
		return NULL;

	isList1 = PyList_Check(pylist1);
	n1 = isList1 ? PyList_Size(pylist1) : PyTuple_Size (pylist1);

	isList2 = PyList_Check(pylist2);
	n2 = isList2 ? PyList_Size(pylist2) : PyTuple_Size (pylist2);

	if (n1 > 0 && n2 > 0)
	{
		array1 = malloc( (1+n1) * sizeof(void*) );
		array1[n1] = 0;

		array2 = malloc( (1+n2) * sizeof(char*) );
		array2[n2] = 0;

		for(i=0; i<n1; ++i) 
		{ 
			array1[i] = isList1 ? (void*)((int)PyInt_AsLong( PyList_GetItem( pylist1, i ) )) : (void*)((int)PyInt_AsLong( PyTuple_GetItem( pylist1, i ) ));
		}

		for(i=0; i<n2; ++i) 
		{ 
			array2[i] = isList2 ? PyString_AsString( PyList_GetItem( pylist2, i ) ) : PyString_AsString( PyTuple_GetItem( pylist2, i ));
		}

		M = tc_getParametersExcept(array1,array2);
		free(array1);
		TCFreeChars(array2);

		if (M.rows > 0 && M.values && M.rownames)
		{
			params = PyTuple_New(M.rows);
			values = PyTuple_New(M.rows);

			for (i=0; i < M.rows; i++) 
			{
				item = Py_BuildValue("s",M.rownames[i]);
				PyTuple_SetItem(params, i, item);

				item = Py_BuildValue("d",valueAt(M,i,0));
				PyTuple_SetItem(values, i, item);
			}
			TCFreeMatrix(M);
		}
		else
		{
			params = PyTuple_New(0);
			values = PyTuple_New(0);
		}

	}

	twoTuples = PyTuple_New(2);
	PyTuple_SetItem(twoTuples,0,params);
	PyTuple_SetItem(twoTuples,1,values);

	return Py_BuildValue("O",twoTuples);
}

static PyObject * pytc_getAllTextNamed(PyObject *self, PyObject *args)
{
	int i, isList1, isList2, n1, n2;
	int len;
	char ** M, **array2;
	void **array1;
	PyObject * params;
	PyObject * pylist1, * pylist2, *item;
	
	if(!PyArg_ParseTuple(args, "OO", &pylist1, &pylist2) ||
		(tc_getAllTextNamed == 0))
		return NULL;

	isList1 = PyList_Check(pylist1);
	n1 = isList1 ? PyList_Size(pylist1) : PyTuple_Size (pylist1);

	isList2 = PyList_Check(pylist2);
	n2 = isList2 ? PyList_Size(pylist2) : PyTuple_Size (pylist2);
	
	if (n1 > 0 && n2 > 0)
	{
		array1 = malloc( (1+n1) * sizeof(void*) );
		array1[n1] = 0;

		array2 = malloc( (1+n2) * sizeof(char*) );
		array2[n2] = 0;

		for(i=0; i<n1; ++i) 
		{ 
			array1[i] = isList1 ? (void*)((int)PyInt_AsLong( PyList_GetItem( pylist1, i ) )) : (void*)((int)PyInt_AsLong( PyTuple_GetItem( pylist1, i ) ));
		}

		for(i=0; i<n2; ++i) 
		{ 
			array2[i] = isList2 ? PyString_AsString( PyList_GetItem( pylist2, i ) ) : PyString_AsString( PyTuple_GetItem( pylist2, i ));
		}

		M = tc_getAllTextNamed(array1,array2);
		free(array1);
		TCFreeChars(array2);

		if (M)
		{		
			len = 0;

			while (M[len] != 0) ++len;

			params = PyTuple_New(len);

			for (i=0; i < len; i++)
			{
				item = Py_BuildValue("s",M[i]);
				PyTuple_SetItem(params, i, item);
			}
			TCFreeChars(M);
		}
		else
		{
			params = PyTuple_New(0);
		}

	}
	else
	{
		params = PyTuple_New(0);
	}

	return Py_BuildValue("O",params);
}


static PyObject * pytc_setTextAttribute(PyObject *self, PyObject *args)
{
	int i;
	char * s, * c;
	if(!PyArg_ParseTuple(args, "iss", &i, &s, &c) ||
		(tc_setTextAttribute == 0))
		return NULL;

	tc_setTextAttribute((void*)i,s,c);

	Py_INCREF(Py_None);
	return Py_None;
}

static PyObject * pytc_setParameter(PyObject *self, PyObject *args)
{
	int i;
	char * s;
	double d;

	if(!PyArg_ParseTuple(args, "isd", &i, &s, &d) ||
		(tc_setParameter == 0))
		return NULL;

	tc_setParameter((void*)i,s,d);

	Py_INCREF(Py_None);
	return Py_None;
}
