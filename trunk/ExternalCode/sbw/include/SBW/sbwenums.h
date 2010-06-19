/**
 * @file sbwenums.h
 * @brief SBW API enumeration types
 * @author SBW Development Group <sysbio-team@caltech.edu>
 *
 * Organization: Caltech ERATO Kitano Systems Biology Project
 *
 * Created: @date 18th June 2001
 * $Id: sbwenums.h,v 1.1 2005/12/15 01:06:44 fbergmann Exp $
 * $Source: /cvsroot/sbw/core/include/SBW/sbwenums.h,v $
 */

/*
** Copyright 2001 California Institute of Technology and
** Japan Science and Technology Corporation.
** 
** This library is free software; you can redistribute it and/or modify it
** under the terms of the GNU Lesser General Public License as published
** by the Free Software Foundation; either version 2.1 of the License, or
** any later version.
** 
** This library is distributed in the hope that it will be useful, but
** WITHOUT ANY WARRANTY, WITHOUT EVEN THE IMPLIED WARRANTY OF
** MERCHANTABILITY OR FITNESS FOR A PARTICULAR PURPOSE.  The software and
** documentation provided hereunder is on an "as is" basis, and the
** California Institute of Technology and Japan Science and Technology
** Corporation have no obligations to provide maintenance, support,
** updates, enhancements or modifications.  In no event shall the
** California Institute of Technology or the Japan Science and Technology
** Corporation be liable to any party for direct, indirect, special,
** incidental or consequential damages, including lost profits, arising
** out of the use of this software and its documentation, even if the
** California Institute of Technology and/or Japan Science and Technology
** Corporation have been advised of the possibility of such damage.  See
** the GNU Lesser General Public License for more details.
** 
** You should have received a copy of the GNU Lesser General Public License
** along with this library; if not, write to the Free Software Foundation,
** Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA.
**
** The original code contained here was initially developed by:
**
**     Andrew Finney, Herbert Sauro, Michael Hucka, Hamid Bolouri
**     The Systems Biology Workbench Development Group
**     ERATO Kitano Systems Biology Project
**     Control and Dynamical Systems, MC 107-81
**     California Institute of Technology
**     Pasadena, CA, 91125, USA
**
**     http://www.cds.caltech.edu/erato
**     mailto:sysbio-team@caltech.edu
**
** Contributor(s):
**
*/

/// include loop block
#ifndef SBWENUMS
#define SBWENUMS

#ifndef __cplusplus
#error sbwenums.h can only be included in ANSI C++ files
#endif

namespace SystemsBiologyWorkbench
{

/**
 * BrokerMethods enums ... this will save a lot of internal lookups
 */
typedef enum brokerMethods
{
	GetVersion = 0, 
	GetModuleInstance = 1, 
	GetModuleDescriptors = 2, 
	GetModuleDescriptorString = 3, 
	GetModuleDescriptorInt = 4, 
	FindServices = 5, 
	GetServiceCategories = 6, 
	LinkBroker = 7, 
	GetExistingModuleInstanceIds = 8,
	GetServiceDescriptorString = 9, 
	GetServiceDescriptorInt = 10, 
	GetServiceDescriptorsString = 11, 
	GetServiceDescriptorsInt = 12, 
	RegisterModule = 13, 
	ChangeModuleName = 14, 
	RegisterService = 15, 
	UnregisterModule = 16, 
	ShutdownBroker = 17, 
	GetListOfModules = 18, 
	GetMethodIdsInt = 19, 
	GetMethodIdsString = 20, 
	ReadFromFile = 21, 
	FindLocalServices = 22
} BrokerMethods;

/**
 * Exception types used in C++ API.
 * uses standard encoding of exceptions used in both in the API and in exception messages.
 */
typedef enum ExceptionCode
{
	ApplicationExceptionCode = 0, /**< generated by a module ie not raised by the  infastructure */
	RawExceptionCode = 1, /**< generated by a OS or unhandled exception */
	CommunicationExceptionCode = 2, /**< communication between modules has been disrupted */
	ModuleStartExceptionCode = 3, /**< unable to start module when a new module instance was required */
	TypeMismatchExceptionCode = 4, /**< the data contained in a datablock doesn't correspond to the requested type */
	IncompatibleMethodSignatureExceptionCode = 5, /**< two method signatures do not match */
	ModuleIdSyntaxExceptionCode = 6, /**< the syntax of a module instance identifier string is incorrect */
	IncorrectCategorySyntaxExceptionCode = 7, /**< the syntax of a service category string is incorrect */
	ServiceNotFoundExceptionCode = 9, /**< the requested service doesn't exist */ 
	MethodTypeNotBlockTypeExceptionCode = 10, /**< thrown during communications if a supplied class uses types which are not data block types (not raised in C++ library) */
	MethodAmbiguousExceptionCode = 11, /**< the given signature matches more than one method on a service */
	UnsupportedObjectTypeExceptionCode = 12, /**< the given valid type is not supported by a client library */
	MethodNotFoundExceptionCode = 13, /**< the given signature or name doesn't match any method on a service */
	SignatureSyntaxExceptionCode = 14, /**< the syntax of the given signature is incorrect */
	ModuleDefinitionExceptionCode = 15,	 /**< exception thrown when an attempt to define a new module fails */
	ModuleNotFoundExceptionCode = 16, /**< the requested module doesn't exist */
	BrokerStartExceptionCode = 17 /**< unable to start broker */
} ExceptionType ;

/**
 * Datatypes used in C++ API.
 * uses standard encoding of datatypes used in both the API and in datablocks.
 */
typedef enum dataBlockType
{
	ByteType = 0 , /**< C++ API type - unsigned char */
	IntegerType = 1, /**< C++ API type - Integer */ 
	DoubleType = 2, /**< C++ API type - Double */
	BooleanType = 3, /**< C++ API type - bool */
	StringType = 4, /**< C++ API type - char * */
	ArrayType = 5, /**< C++ API type - <T>* or <T>**, std::vector<T>, std::deque<T> or std::list<T> */
	ListType = 6, /**< C++ API type - DataBlockReader * or DataBlockWriter * */
	VoidType = 7, /**< placeholder when no value is returned from a method */
	ComplexType = 8, /**< C++ API type - SBWComplex or complex<double> */
	TerminateType = -1, /**< value of last byte in a datablock or message */
	ErrorType = -2 /**< placeholder when error has occured in an API function */
} DataBlockType;

/**
 * The modes in which a given module/application can operate with respect to SBW
 */
typedef enum moduleMode
{
	NormalMode = 0, /**< either not connected or only consuming services */
	ModuleMode = 1, /**< providing services */
	RegisterMode = 2 /**< registering services */
} ModuleModeType;

/**
 * The ways in which a given module can be managed by the broker.
 * Uses standard encoding used by both by the API and the broker interface.
 */
typedef enum moduleManagementType
{
	UniqueModule = 0, /**< broker only creates one instance of the module and refers all requests to that instance.*/
	SelfManagedModule = 1 /**< broker creates a new instance for each module instance request */
	//SBWManagedModule = 2 /**< not currently used - as for self managed but will shutdown module if other module instances no longer reference the module instance. */
} ModuleManagementType;

} // end SystemsBiologyWorkbench

#endif // SBWENUMS
