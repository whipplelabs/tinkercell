# -----------------------------------------------------------------------------
# File name         : doxyfile-cpp.txt
# Description       : Doxygen config for C libSBML API manual 
# Original author(s): Michael Hucka <mhucka@caltech.edu>
# Organization      : California Institute of Technology
# $Id: doxygen-config-c.txt.in 11938 2010-09-20 02:04:23Z mhucka $
# $HeadURL: http://sbml.svn.sourceforge.net/svnroot/sbml/branches/libsbml-5/docs/src/doxygen-config-c.txt.in $
# -----------------------------------------------------------------------------

# Include libSBML's common Doxygen settings:

@INCLUDE               = doxygen-config-common.txt

# -----------------------------------------------------------------------------
# Beginning of C++ specific configuration settings
# -----------------------------------------------------------------------------

# The PROJECT_NAME tag is a single word (or a sequence of words surrounded 
# by quotes) that should identify the project.

PROJECT_NAME           = "@PACKAGE_NAME@ C Public API"

# The PROJECT_NUMBER tag can be used to enter a project or revision number. 
# This could be handy for archiving the generated documentation or 
# if some version control system is used.

PROJECT_NUMBER         = "@PACKAGE_NAME@ @PACKAGE_VERSION@ C Public API"

# The HTML_OUTPUT tag is used to specify where the HTML docs will be put. 
# If a relative path is entered the value of OUTPUT_DIRECTORY will be 
# put in front of it. If left blank `html' will be used as the default path.

HTML_OUTPUT            = ../formatted/c-api

# Set the OPTIMIZE_OUTPUT_FOR_C tag to YES if your project consists of C sources 
# only. Doxygen will then generate output that is more tailored for C. 
# For instance, some of the names that are used will be different. The list 
# of all members will be omitted, etc.

OPTIMIZE_OUTPUT_FOR_C  = YES

# The ENABLED_SECTIONS tag can be used to enable conditional 
# documentation sections, marked by \if sectionname ... \endif.

ENABLED_SECTIONS       = doxygen-c-only doxygen-clike-only notcpp

# When TYPEDEF_HIDES_STRUCT is enabled, a typedef of a struct, union, or enum
# is documented as struct, union, or enum with the name of the typedef. So
# typedef struct TypeS {} TypeT, will appear in the documentation as a struct
# with name TypeT. When disabled the typedef will appear as a member of a
# file, namespace, or class. And the struct will be named TypeS. This can
# typically be useful for C code in case the coding convention dictates that
# all compound types are typedef'ed and only the typedef is referenced, never
# the tag name.

TYPEDEF_HIDES_STRUCT   = YES

# The PREDEFINED tag can be used to specify one or more macro names that 
# are defined before the preprocessor is started (similar to the -D option of 
# gcc). The argument of the tag is a list of macros of the form: name 
# or name=definition (no spaces). If the definition and the = are 
# omitted =1 is assumed.

PREDEFINED             = LIBSBML_EXTERN:="" \
			 BEGIN_C_DECLS:="" \
			 END_C_DECLS:="" \
			 LIBSBML_CPP_NAMESPACE_BEGIN:="" \
			 LIBSBML_CPP_NAMESPACE_END:="" 

#			 __cplusplus 
