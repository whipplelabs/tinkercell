# This file was automatically generated by SWIG (http://www.swig.org).
# Version 1.3.40
#
# Do not make changes to this file unless you know what you are doing--modify
# the SWIG interface file instead.
# This file is compatible with both classic and new-style classes.

from sys import version_info
if version_info >= (2,6,0):
    def swig_import_helper():
        from os.path import dirname
        import imp
        fp = None
        try:
            fp, pathname, description = imp.find_module('_tinkercell', [dirname(__file__)])
        except ImportError:
            import _tinkercell
            return _tinkercell
        if fp is not None:
            try:
                _mod = imp.load_module('_tinkercell', fp, pathname, description)
            finally:
                fp.close()
            return _mod
    _tinkercell = swig_import_helper()
    del swig_import_helper
else:
    import _tinkercell
del version_info
try:
    _swig_property = property
except NameError:
    pass # Python < 2.2 doesn't have 'property'.
def _swig_setattr_nondynamic(self,class_type,name,value,static=1):
    if (name == "thisown"): return self.this.own(value)
    if (name == "this"):
        if type(value).__name__ == 'SwigPyObject':
            self.__dict__[name] = value
            return
    method = class_type.__swig_setmethods__.get(name,None)
    if method: return method(self,value)
    if (not static) or hasattr(self,name):
        self.__dict__[name] = value
    else:
        raise AttributeError("You cannot add attributes to %s" % self)

def _swig_setattr(self,class_type,name,value):
    return _swig_setattr_nondynamic(self,class_type,name,value,0)

def _swig_getattr(self,class_type,name):
    if (name == "thisown"): return self.this.own()
    method = class_type.__swig_getmethods__.get(name,None)
    if method: return method(self)
    raise AttributeError(name)

def _swig_repr(self):
    try: strthis = "proxy of " + self.this.__repr__()
    except: strthis = ""
    return "<%s.%s; %s >" % (self.__class__.__module__, self.__class__.__name__, strthis,)

try:
    _object = object
    _newclass = 1
except AttributeError:
    class _object : pass
    _newclass = 0


class tc_strings(_object):
    __swig_setmethods__ = {}
    __setattr__ = lambda self, name, value: _swig_setattr(self, tc_strings, name, value)
    __swig_getmethods__ = {}
    __getattr__ = lambda self, name: _swig_getattr(self, tc_strings, name)
    __repr__ = _swig_repr
    __swig_setmethods__["length"] = _tinkercell.tc_strings_length_set
    __swig_getmethods__["length"] = _tinkercell.tc_strings_length_get
    if _newclass:length = _swig_property(_tinkercell.tc_strings_length_get, _tinkercell.tc_strings_length_set)
    __swig_setmethods__["strings"] = _tinkercell.tc_strings_strings_set
    __swig_getmethods__["strings"] = _tinkercell.tc_strings_strings_get
    if _newclass:strings = _swig_property(_tinkercell.tc_strings_strings_get, _tinkercell.tc_strings_strings_set)
    def __init__(self): 
        this = _tinkercell.new_tc_strings()
        try: self.this.append(this)
        except: self.this = this
    __swig_destroy__ = _tinkercell.delete_tc_strings
    __del__ = lambda self : None;
tc_strings_swigregister = _tinkercell.tc_strings_swigregister
tc_strings_swigregister(tc_strings)

class tc_items(_object):
    __swig_setmethods__ = {}
    __setattr__ = lambda self, name, value: _swig_setattr(self, tc_items, name, value)
    __swig_getmethods__ = {}
    __getattr__ = lambda self, name: _swig_getattr(self, tc_items, name)
    __repr__ = _swig_repr
    __swig_setmethods__["length"] = _tinkercell.tc_items_length_set
    __swig_getmethods__["length"] = _tinkercell.tc_items_length_get
    if _newclass:length = _swig_property(_tinkercell.tc_items_length_get, _tinkercell.tc_items_length_set)
    __swig_setmethods__["items"] = _tinkercell.tc_items_items_set
    __swig_getmethods__["items"] = _tinkercell.tc_items_items_get
    if _newclass:items = _swig_property(_tinkercell.tc_items_items_get, _tinkercell.tc_items_items_set)
    def __init__(self): 
        this = _tinkercell.new_tc_items()
        try: self.this.append(this)
        except: self.this = this
    __swig_destroy__ = _tinkercell.delete_tc_items
    __del__ = lambda self : None;
tc_items_swigregister = _tinkercell.tc_items_swigregister
tc_items_swigregister(tc_items)

class tc_matrix(_object):
    __swig_setmethods__ = {}
    __setattr__ = lambda self, name, value: _swig_setattr(self, tc_matrix, name, value)
    __swig_getmethods__ = {}
    __getattr__ = lambda self, name: _swig_getattr(self, tc_matrix, name)
    __repr__ = _swig_repr
    __swig_setmethods__["rows"] = _tinkercell.tc_matrix_rows_set
    __swig_getmethods__["rows"] = _tinkercell.tc_matrix_rows_get
    if _newclass:rows = _swig_property(_tinkercell.tc_matrix_rows_get, _tinkercell.tc_matrix_rows_set)
    __swig_setmethods__["cols"] = _tinkercell.tc_matrix_cols_set
    __swig_getmethods__["cols"] = _tinkercell.tc_matrix_cols_get
    if _newclass:cols = _swig_property(_tinkercell.tc_matrix_cols_get, _tinkercell.tc_matrix_cols_set)
    __swig_setmethods__["values"] = _tinkercell.tc_matrix_values_set
    __swig_getmethods__["values"] = _tinkercell.tc_matrix_values_get
    if _newclass:values = _swig_property(_tinkercell.tc_matrix_values_get, _tinkercell.tc_matrix_values_set)
    __swig_setmethods__["rownames"] = _tinkercell.tc_matrix_rownames_set
    __swig_getmethods__["rownames"] = _tinkercell.tc_matrix_rownames_get
    if _newclass:rownames = _swig_property(_tinkercell.tc_matrix_rownames_get, _tinkercell.tc_matrix_rownames_set)
    __swig_setmethods__["colnames"] = _tinkercell.tc_matrix_colnames_set
    __swig_getmethods__["colnames"] = _tinkercell.tc_matrix_colnames_get
    if _newclass:colnames = _swig_property(_tinkercell.tc_matrix_colnames_get, _tinkercell.tc_matrix_colnames_set)
    def __init__(self): 
        this = _tinkercell.new_tc_matrix()
        try: self.this.append(this)
        except: self.this = this
    __swig_destroy__ = _tinkercell.delete_tc_matrix
    __del__ = lambda self : None;
tc_matrix_swigregister = _tinkercell.tc_matrix_swigregister
tc_matrix_swigregister(tc_matrix)

class tc_table(_object):
    __swig_setmethods__ = {}
    __setattr__ = lambda self, name, value: _swig_setattr(self, tc_table, name, value)
    __swig_getmethods__ = {}
    __getattr__ = lambda self, name: _swig_getattr(self, tc_table, name)
    __repr__ = _swig_repr
    __swig_setmethods__["rows"] = _tinkercell.tc_table_rows_set
    __swig_getmethods__["rows"] = _tinkercell.tc_table_rows_get
    if _newclass:rows = _swig_property(_tinkercell.tc_table_rows_get, _tinkercell.tc_table_rows_set)
    __swig_setmethods__["cols"] = _tinkercell.tc_table_cols_set
    __swig_getmethods__["cols"] = _tinkercell.tc_table_cols_get
    if _newclass:cols = _swig_property(_tinkercell.tc_table_cols_get, _tinkercell.tc_table_cols_set)
    __swig_setmethods__["strings"] = _tinkercell.tc_table_strings_set
    __swig_getmethods__["strings"] = _tinkercell.tc_table_strings_get
    if _newclass:strings = _swig_property(_tinkercell.tc_table_strings_get, _tinkercell.tc_table_strings_set)
    __swig_setmethods__["rownames"] = _tinkercell.tc_table_rownames_set
    __swig_getmethods__["rownames"] = _tinkercell.tc_table_rownames_get
    if _newclass:rownames = _swig_property(_tinkercell.tc_table_rownames_get, _tinkercell.tc_table_rownames_set)
    __swig_setmethods__["colnames"] = _tinkercell.tc_table_colnames_set
    __swig_getmethods__["colnames"] = _tinkercell.tc_table_colnames_get
    if _newclass:colnames = _swig_property(_tinkercell.tc_table_colnames_get, _tinkercell.tc_table_colnames_set)
    def __init__(self): 
        this = _tinkercell.new_tc_table()
        try: self.this.append(this)
        except: self.this = this
    __swig_destroy__ = _tinkercell.delete_tc_table
    __del__ = lambda self : None;
tc_table_swigregister = _tinkercell.tc_table_swigregister
tc_table_swigregister(tc_table)


def tc_createMatrix(*args):
  return _tinkercell.tc_createMatrix(*args)
tc_createMatrix = _tinkercell.tc_createMatrix

def tc_createTable(*args):
  return _tinkercell.tc_createTable(*args)
tc_createTable = _tinkercell.tc_createTable

def tc_createStringsArray(*args):
  return _tinkercell.tc_createStringsArray(*args)
tc_createStringsArray = _tinkercell.tc_createStringsArray

def tc_createItemsArray(*args):
  return _tinkercell.tc_createItemsArray(*args)
tc_createItemsArray = _tinkercell.tc_createItemsArray

def tc_getMatrixValue(*args):
  return _tinkercell.tc_getMatrixValue(*args)
tc_getMatrixValue = _tinkercell.tc_getMatrixValue

def tc_setMatrixValue(*args):
  return _tinkercell.tc_setMatrixValue(*args)
tc_setMatrixValue = _tinkercell.tc_setMatrixValue

def tc_getRowName(*args):
  return _tinkercell.tc_getRowName(*args)
tc_getRowName = _tinkercell.tc_getRowName

def tc_setRowName(*args):
  return _tinkercell.tc_setRowName(*args)
tc_setRowName = _tinkercell.tc_setRowName

def tc_getColumnName(*args):
  return _tinkercell.tc_getColumnName(*args)
tc_getColumnName = _tinkercell.tc_getColumnName

def tc_setColumnName(*args):
  return _tinkercell.tc_setColumnName(*args)
tc_setColumnName = _tinkercell.tc_setColumnName

def tc_getTableValue(*args):
  return _tinkercell.tc_getTableValue(*args)
tc_getTableValue = _tinkercell.tc_getTableValue

def tc_setTableValue(*args):
  return _tinkercell.tc_setTableValue(*args)
tc_setTableValue = _tinkercell.tc_setTableValue

def tc_getString(*args):
  return _tinkercell.tc_getString(*args)
tc_getString = _tinkercell.tc_getString

def tc_setString(*args):
  return _tinkercell.tc_setString(*args)
tc_setString = _tinkercell.tc_setString

def tc_getItem(*args):
  return _tinkercell.tc_getItem(*args)
tc_getItem = _tinkercell.tc_getItem

def tc_setItem(*args):
  return _tinkercell.tc_setItem(*args)
tc_setItem = _tinkercell.tc_setItem

def tc_deleteMatrix(*args):
  return _tinkercell.tc_deleteMatrix(*args)
tc_deleteMatrix = _tinkercell.tc_deleteMatrix

def tc_deleteTable(*args):
  return _tinkercell.tc_deleteTable(*args)
tc_deleteTable = _tinkercell.tc_deleteTable

def tc_deleteItemsArray(*args):
  return _tinkercell.tc_deleteItemsArray(*args)
tc_deleteItemsArray = _tinkercell.tc_deleteItemsArray

def tc_deleteStringsArray(*args):
  return _tinkercell.tc_deleteStringsArray(*args)
tc_deleteStringsArray = _tinkercell.tc_deleteStringsArray

def tc_appendColumns(*args):
  return _tinkercell.tc_appendColumns(*args)
tc_appendColumns = _tinkercell.tc_appendColumns

def tc_appendRows(*args):
  return _tinkercell.tc_appendRows(*args)
tc_appendRows = _tinkercell.tc_appendRows

def tc_printMatrixToFile(*args):
  return _tinkercell.tc_printMatrixToFile(*args)
tc_printMatrixToFile = _tinkercell.tc_printMatrixToFile

def tc_printOutMatrix(*args):
  return _tinkercell.tc_printOutMatrix(*args)
tc_printOutMatrix = _tinkercell.tc_printOutMatrix

def tc_printTableToFile(*args):
  return _tinkercell.tc_printTableToFile(*args)
tc_printTableToFile = _tinkercell.tc_printTableToFile

def tc_printOutTable(*args):
  return _tinkercell.tc_printOutTable(*args)
tc_printOutTable = _tinkercell.tc_printOutTable

def tc_allItems():
  return _tinkercell.tc_allItems()
tc_allItems = _tinkercell.tc_allItems

def tc_selectedItems():
  return _tinkercell.tc_selectedItems()
tc_selectedItems = _tinkercell.tc_selectedItems

def tc_itemsOfFamily(*args):
  return _tinkercell.tc_itemsOfFamily(*args)
tc_itemsOfFamily = _tinkercell.tc_itemsOfFamily

def tc_itemsOfFamilyFrom(*args):
  return _tinkercell.tc_itemsOfFamilyFrom(*args)
tc_itemsOfFamilyFrom = _tinkercell.tc_itemsOfFamilyFrom

def tc_find(*args):
  return _tinkercell.tc_find(*args)
tc_find = _tinkercell.tc_find

def tc_findItems(*args):
  return _tinkercell.tc_findItems(*args)
tc_findItems = _tinkercell.tc_findItems

def tc_select(*args):
  return _tinkercell.tc_select(*args)
tc_select = _tinkercell.tc_select

def tc_deselect():
  return _tinkercell.tc_deselect()
tc_deselect = _tinkercell.tc_deselect

def tc_getName(*args):
  return _tinkercell.tc_getName(*args)
tc_getName = _tinkercell.tc_getName

def tc_getUniqueName(*args):
  return _tinkercell.tc_getUniqueName(*args)
tc_getUniqueName = _tinkercell.tc_getUniqueName

def tc_rename(*args):
  return _tinkercell.tc_rename(*args)
tc_rename = _tinkercell.tc_rename

def tc_getNames(*args):
  return _tinkercell.tc_getNames(*args)
tc_getNames = _tinkercell.tc_getNames

def tc_getUniqueNames(*args):
  return _tinkercell.tc_getUniqueNames(*args)
tc_getUniqueNames = _tinkercell.tc_getUniqueNames

def tc_getFamily(*args):
  return _tinkercell.tc_getFamily(*args)
tc_getFamily = _tinkercell.tc_getFamily

def tc_isA(*args):
  return _tinkercell.tc_isA(*args)
tc_isA = _tinkercell.tc_isA

def tc_print(*args):
  return _tinkercell.tc_print(*args)
tc_print = _tinkercell.tc_print

def tc_errorReport(*args):
  return _tinkercell.tc_errorReport(*args)
tc_errorReport = _tinkercell.tc_errorReport

def tc_printMatrix(*args):
  return _tinkercell.tc_printMatrix(*args)
tc_printMatrix = _tinkercell.tc_printMatrix

def tc_printFile(*args):
  return _tinkercell.tc_printFile(*args)
tc_printFile = _tinkercell.tc_printFile

def tc_clear():
  return _tinkercell.tc_clear()
tc_clear = _tinkercell.tc_clear

def tc_remove(*args):
  return _tinkercell.tc_remove(*args)
tc_remove = _tinkercell.tc_remove

def tc_getY(*args):
  return _tinkercell.tc_getY(*args)
tc_getY = _tinkercell.tc_getY

def tc_getX(*args):
  return _tinkercell.tc_getX(*args)
tc_getX = _tinkercell.tc_getX

def tc_getPos(*args):
  return _tinkercell.tc_getPos(*args)
tc_getPos = _tinkercell.tc_getPos

def tc_setPos(*args):
  return _tinkercell.tc_setPos(*args)
tc_setPos = _tinkercell.tc_setPos

def tc_setPosMulti(*args):
  return _tinkercell.tc_setPosMulti(*args)
tc_setPosMulti = _tinkercell.tc_setPosMulti

def tc_moveSelected(*args):
  return _tinkercell.tc_moveSelected(*args)
tc_moveSelected = _tinkercell.tc_moveSelected

def tc_isWindows():
  return _tinkercell.tc_isWindows()
tc_isWindows = _tinkercell.tc_isWindows

def tc_isMac():
  return _tinkercell.tc_isMac()
tc_isMac = _tinkercell.tc_isMac

def tc_isLinux():
  return _tinkercell.tc_isLinux()
tc_isLinux = _tinkercell.tc_isLinux

def tc_appDir():
  return _tinkercell.tc_appDir()
tc_appDir = _tinkercell.tc_appDir

def tc_homeDir():
  return _tinkercell.tc_homeDir()
tc_homeDir = _tinkercell.tc_homeDir

def tc_createInputWindowForScript(*args):
  return _tinkercell.tc_createInputWindowForScript(*args)
tc_createInputWindowForScript = _tinkercell.tc_createInputWindowForScript

def tc_createInputWindow(*args):
  return _tinkercell.tc_createInputWindow(*args)
tc_createInputWindow = _tinkercell.tc_createInputWindow

def tc_addInputWindowOptions(*args):
  return _tinkercell.tc_addInputWindowOptions(*args)
tc_addInputWindowOptions = _tinkercell.tc_addInputWindowOptions

def tc_addInputWindowCheckbox(*args):
  return _tinkercell.tc_addInputWindowCheckbox(*args)
tc_addInputWindowCheckbox = _tinkercell.tc_addInputWindowCheckbox

def tc_openNewWindow(*args):
  return _tinkercell.tc_openNewWindow(*args)
tc_openNewWindow = _tinkercell.tc_openNewWindow

def tc_getChildren(*args):
  return _tinkercell.tc_getChildren(*args)
tc_getChildren = _tinkercell.tc_getChildren

def tc_getParent(*args):
  return _tinkercell.tc_getParent(*args)
tc_getParent = _tinkercell.tc_getParent

def tc_getNumericalData(*args):
  return _tinkercell.tc_getNumericalData(*args)
tc_getNumericalData = _tinkercell.tc_getNumericalData

def tc_setNumericalData(*args):
  return _tinkercell.tc_setNumericalData(*args)
tc_setNumericalData = _tinkercell.tc_setNumericalData

def tc_getTextData(*args):
  return _tinkercell.tc_getTextData(*args)
tc_getTextData = _tinkercell.tc_getTextData

def tc_setTextData(*args):
  return _tinkercell.tc_setTextData(*args)
tc_setTextData = _tinkercell.tc_setTextData

def tc_getNumericalDataNames(*args):
  return _tinkercell.tc_getNumericalDataNames(*args)
tc_getNumericalDataNames = _tinkercell.tc_getNumericalDataNames

def tc_getTextDataNames(*args):
  return _tinkercell.tc_getTextDataNames(*args)
tc_getTextDataNames = _tinkercell.tc_getTextDataNames

def tc_zoom(*args):
  return _tinkercell.tc_zoom(*args)
tc_zoom = _tinkercell.tc_zoom

def tc_getStringDialog(*args):
  return _tinkercell.tc_getStringDialog(*args)
tc_getStringDialog = _tinkercell.tc_getStringDialog

def tc_getFilename():
  return _tinkercell.tc_getFilename()
tc_getFilename = _tinkercell.tc_getFilename

def tc_getStringFromList(*args):
  return _tinkercell.tc_getStringFromList(*args)
tc_getStringFromList = _tinkercell.tc_getStringFromList

def tc_getNumber(*args):
  return _tinkercell.tc_getNumber(*args)
tc_getNumber = _tinkercell.tc_getNumber

def tc_getNumbers(*args):
  return _tinkercell.tc_getNumbers(*args)
tc_getNumbers = _tinkercell.tc_getNumbers

def tc_askQuestion(*args):
  return _tinkercell.tc_askQuestion(*args)
tc_askQuestion = _tinkercell.tc_askQuestion

def tc_messageDialog(*args):
  return _tinkercell.tc_messageDialog(*args)
tc_messageDialog = _tinkercell.tc_messageDialog

def tc_openFile(*args):
  return _tinkercell.tc_openFile(*args)
tc_openFile = _tinkercell.tc_openFile

def tc_saveToFile(*args):
  return _tinkercell.tc_saveToFile(*args)
tc_saveToFile = _tinkercell.tc_saveToFile

def tc_thisThread():
  return _tinkercell.tc_thisThread()
tc_thisThread = _tinkercell.tc_thisThread

def tc_createSliders(*args):
  return _tinkercell.tc_createSliders(*args)
tc_createSliders = _tinkercell.tc_createSliders

def tc_getColor(*args):
  return _tinkercell.tc_getColor(*args)
tc_getColor = _tinkercell.tc_getColor

def tc_setColor(*args):
  return _tinkercell.tc_setColor(*args)
tc_setColor = _tinkercell.tc_setColor

def tc_changeNodeImage(*args):
  return _tinkercell.tc_changeNodeImage(*args)
tc_changeNodeImage = _tinkercell.tc_changeNodeImage

def tc_changeArrowHead(*args):
  return _tinkercell.tc_changeArrowHead(*args)
tc_changeArrowHead = _tinkercell.tc_changeArrowHead

def tc_setSize(*args):
  return _tinkercell.tc_setSize(*args)
tc_setSize = _tinkercell.tc_setSize

def tc_getWidth(*args):
  return _tinkercell.tc_getWidth(*args)
tc_getWidth = _tinkercell.tc_getWidth

def tc_getHeight(*args):
  return _tinkercell.tc_getHeight(*args)
tc_getHeight = _tinkercell.tc_getHeight

def tc_rotate(*args):
  return _tinkercell.tc_rotate(*args)
tc_rotate = _tinkercell.tc_rotate

def tc_screenshot(*args):
  return _tinkercell.tc_screenshot(*args)
tc_screenshot = _tinkercell.tc_screenshot

def tc_screenWidth():
  return _tinkercell.tc_screenWidth()
tc_screenWidth = _tinkercell.tc_screenWidth

def tc_screenHeight():
  return _tinkercell.tc_screenHeight()
tc_screenHeight = _tinkercell.tc_screenHeight

def tc_screenX():
  return _tinkercell.tc_screenX()
tc_screenX = _tinkercell.tc_screenX

def tc_screenY():
  return _tinkercell.tc_screenY()
tc_screenY = _tinkercell.tc_screenY

def tc_annotations():
  return _tinkercell.tc_annotations()
tc_annotations = _tinkercell.tc_annotations

def tc_insertAnnotations(*args):
  return _tinkercell.tc_insertAnnotations(*args)
tc_insertAnnotations = _tinkercell.tc_insertAnnotations

def tc_Main_api_initialize(*args):
  return _tinkercell.tc_Main_api_initialize(*args)
tc_Main_api_initialize = _tinkercell.tc_Main_api_initialize

def tc_showProgress(*args):
  return _tinkercell.tc_showProgress(*args)
tc_showProgress = _tinkercell.tc_showProgress

def tc_callback(*args):
  return _tinkercell.tc_callback(*args)
tc_callback = _tinkercell.tc_callback

def tc_callWhenExiting(*args):
  return _tinkercell.tc_callWhenExiting(*args)
tc_callWhenExiting = _tinkercell.tc_callWhenExiting

def tc_CThread_api_initialize(*args):
  return _tinkercell.tc_CThread_api_initialize(*args)
tc_CThread_api_initialize = _tinkercell.tc_CThread_api_initialize

def tc_getParameters(*args):
  return _tinkercell.tc_getParameters(*args)
tc_getParameters = _tinkercell.tc_getParameters

def tc_getInitialValues(*args):
  return _tinkercell.tc_getInitialValues(*args)
tc_getInitialValues = _tinkercell.tc_getInitialValues

def tc_setInitialValues(*args):
  return _tinkercell.tc_setInitialValues(*args)
tc_setInitialValues = _tinkercell.tc_setInitialValues

def tc_getFixedVariables(*args):
  return _tinkercell.tc_getFixedVariables(*args)
tc_getFixedVariables = _tinkercell.tc_getFixedVariables

def tc_getParametersAndFixedVariables(*args):
  return _tinkercell.tc_getParametersAndFixedVariables(*args)
tc_getParametersAndFixedVariables = _tinkercell.tc_getParametersAndFixedVariables

def tc_getTextAttribute(*args):
  return _tinkercell.tc_getTextAttribute(*args)
tc_getTextAttribute = _tinkercell.tc_getTextAttribute

def tc_getParameter(*args):
  return _tinkercell.tc_getParameter(*args)
tc_getParameter = _tinkercell.tc_getParameter

def tc_getParametersNamed(*args):
  return _tinkercell.tc_getParametersNamed(*args)
tc_getParametersNamed = _tinkercell.tc_getParametersNamed

def tc_getParametersExcept(*args):
  return _tinkercell.tc_getParametersExcept(*args)
tc_getParametersExcept = _tinkercell.tc_getParametersExcept

def tc_getAllTextNamed(*args):
  return _tinkercell.tc_getAllTextNamed(*args)
tc_getAllTextNamed = _tinkercell.tc_getAllTextNamed

def tc_setTextAttribute(*args):
  return _tinkercell.tc_setTextAttribute(*args)
tc_setTextAttribute = _tinkercell.tc_setTextAttribute

def tc_setParameter(*args):
  return _tinkercell.tc_setParameter(*args)
tc_setParameter = _tinkercell.tc_setParameter

def tc_BasicInformationTool_Text_api(*args):
  return _tinkercell.tc_BasicInformationTool_Text_api(*args)
tc_BasicInformationTool_Text_api = _tinkercell.tc_BasicInformationTool_Text_api

def tc_BasicInformationTool_Numeric_api(*args):
  return _tinkercell.tc_BasicInformationTool_Numeric_api(*args)
tc_BasicInformationTool_Numeric_api = _tinkercell.tc_BasicInformationTool_Numeric_api

def tc_insertConnection(*args):
  return _tinkercell.tc_insertConnection(*args)
tc_insertConnection = _tinkercell.tc_insertConnection

def tc_getConnectedNodes(*args):
  return _tinkercell.tc_getConnectedNodes(*args)
tc_getConnectedNodes = _tinkercell.tc_getConnectedNodes

def tc_getConnectedNodesWithRole(*args):
  return _tinkercell.tc_getConnectedNodesWithRole(*args)
tc_getConnectedNodesWithRole = _tinkercell.tc_getConnectedNodesWithRole

def tc_getConnections(*args):
  return _tinkercell.tc_getConnections(*args)
tc_getConnections = _tinkercell.tc_getConnections

def tc_getConnectionsWithRole(*args):
  return _tinkercell.tc_getConnectionsWithRole(*args)
tc_getConnectionsWithRole = _tinkercell.tc_getConnectionsWithRole

def tc_ConnectionInsertion_api(*args):
  return _tinkercell.tc_ConnectionInsertion_api(*args)
tc_ConnectionInsertion_api = _tinkercell.tc_ConnectionInsertion_api

def tc_getControlPointX(*args):
  return _tinkercell.tc_getControlPointX(*args)
tc_getControlPointX = _tinkercell.tc_getControlPointX

def tc_getControlPointY(*args):
  return _tinkercell.tc_getControlPointY(*args)
tc_getControlPointY = _tinkercell.tc_getControlPointY

def tc_setControlPoint(*args):
  return _tinkercell.tc_setControlPoint(*args)
tc_setControlPoint = _tinkercell.tc_setControlPoint

def tc_setCenterPoint(*args):
  return _tinkercell.tc_setCenterPoint(*args)
tc_setCenterPoint = _tinkercell.tc_setCenterPoint

def tc_getCenterPointX(*args):
  return _tinkercell.tc_getCenterPointX(*args)
tc_getCenterPointX = _tinkercell.tc_getCenterPointX

def tc_getCenterPointY(*args):
  return _tinkercell.tc_getCenterPointY(*args)
tc_getCenterPointY = _tinkercell.tc_getCenterPointY

def tc_setStraight(*args):
  return _tinkercell.tc_setStraight(*args)
tc_setStraight = _tinkercell.tc_setStraight

def tc_setAllStraight(*args):
  return _tinkercell.tc_setAllStraight(*args)
tc_setAllStraight = _tinkercell.tc_setAllStraight

def tc_setLineWidth(*args):
  return _tinkercell.tc_setLineWidth(*args)
tc_setLineWidth = _tinkercell.tc_setLineWidth

def tc_ConnectionSelection_api(*args):
  return _tinkercell.tc_ConnectionSelection_api(*args)
tc_ConnectionSelection_api = _tinkercell.tc_ConnectionSelection_api

def tc_merge(*args):
  return _tinkercell.tc_merge(*args)
tc_merge = _tinkercell.tc_merge

def tc_separate(*args):
  return _tinkercell.tc_separate(*args)
tc_separate = _tinkercell.tc_separate

def tc_GroupHandlerTool_api(*args):
  return _tinkercell.tc_GroupHandlerTool_api(*args)
tc_GroupHandlerTool_api = _tinkercell.tc_GroupHandlerTool_api

def tc_insert(*args):
  return _tinkercell.tc_insert(*args)
tc_insert = _tinkercell.tc_insert

def tc_NodeInsertion_api(*args):
  return _tinkercell.tc_NodeInsertion_api(*args)
tc_NodeInsertion_api = _tinkercell.tc_NodeInsertion_api

def tc_getStoichiometry(*args):
  return _tinkercell.tc_getStoichiometry(*args)
tc_getStoichiometry = _tinkercell.tc_getStoichiometry

def tc_setStoichiometry(*args):
  return _tinkercell.tc_setStoichiometry(*args)
tc_setStoichiometry = _tinkercell.tc_setStoichiometry

def tc_getRates(*args):
  return _tinkercell.tc_getRates(*args)
tc_getRates = _tinkercell.tc_getRates

def tc_setRates(*args):
  return _tinkercell.tc_setRates(*args)
tc_setRates = _tinkercell.tc_setRates

def tc_getStoichiometryFor(*args):
  return _tinkercell.tc_getStoichiometryFor(*args)
tc_getStoichiometryFor = _tinkercell.tc_getStoichiometryFor

def tc_getRate(*args):
  return _tinkercell.tc_getRate(*args)
tc_getRate = _tinkercell.tc_getRate

def tc_setRate(*args):
  return _tinkercell.tc_setRate(*args)
tc_setRate = _tinkercell.tc_setRate

def tc_setStoichiometryFor(*args):
  return _tinkercell.tc_setStoichiometryFor(*args)
tc_setStoichiometryFor = _tinkercell.tc_setStoichiometryFor

def tc_StoichiometryTool_api(*args):
  return _tinkercell.tc_StoichiometryTool_api(*args)
tc_StoichiometryTool_api = _tinkercell.tc_StoichiometryTool_api

def tc_compileAndRun(*args):
  return _tinkercell.tc_compileAndRun(*args)
tc_compileAndRun = _tinkercell.tc_compileAndRun

def tc_compileBuildLoad(*args):
  return _tinkercell.tc_compileBuildLoad(*args)
tc_compileBuildLoad = _tinkercell.tc_compileBuildLoad

def tc_compileBuildLoadSliders(*args):
  return _tinkercell.tc_compileBuildLoadSliders(*args)
tc_compileBuildLoadSliders = _tinkercell.tc_compileBuildLoadSliders

def tc_runPythonCode(*args):
  return _tinkercell.tc_runPythonCode(*args)
tc_runPythonCode = _tinkercell.tc_runPythonCode

def tc_runPythonFile(*args):
  return _tinkercell.tc_runPythonFile(*args)
tc_runPythonFile = _tinkercell.tc_runPythonFile

def tc_addPythonPlugin(*args):
  return _tinkercell.tc_addPythonPlugin(*args)
tc_addPythonPlugin = _tinkercell.tc_addPythonPlugin

def tc_callFunction(*args):
  return _tinkercell.tc_callFunction(*args)
tc_callFunction = _tinkercell.tc_callFunction

def tc_loadLibrary(*args):
  return _tinkercell.tc_loadLibrary(*args)
tc_loadLibrary = _tinkercell.tc_loadLibrary

def tc_OctaveTool_api(*args):
  return _tinkercell.tc_OctaveTool_api(*args)
tc_OctaveTool_api = _tinkercell.tc_OctaveTool_api

def tc_addFunction(*args):
  return _tinkercell.tc_addFunction(*args)
tc_addFunction = _tinkercell.tc_addFunction

def tc_runOctaveCode(*args):
  return _tinkercell.tc_runOctaveCode(*args)
tc_runOctaveCode = _tinkercell.tc_runOctaveCode

def tc_runOctaveFile(*args):
  return _tinkercell.tc_runOctaveFile(*args)
tc_runOctaveFile = _tinkercell.tc_runOctaveFile

def tc_addOctavePlugin(*args):
  return _tinkercell.tc_addOctavePlugin(*args)
tc_addOctavePlugin = _tinkercell.tc_addOctavePlugin

def tc_runJavaCode(*args):
  return _tinkercell.tc_runJavaCode(*args)
tc_runJavaCode = _tinkercell.tc_runJavaCode

def tc_addJavaPlugin(*args):
  return _tinkercell.tc_addJavaPlugin(*args)
tc_addJavaPlugin = _tinkercell.tc_addJavaPlugin

def tc_DynamicLibraryMenu_api(*args):
  return _tinkercell.tc_DynamicLibraryMenu_api(*args)
tc_DynamicLibraryMenu_api = _tinkercell.tc_DynamicLibraryMenu_api

def tc_LoadCLibraries_api(*args):
  return _tinkercell.tc_LoadCLibraries_api(*args)
tc_LoadCLibraries_api = _tinkercell.tc_LoadCLibraries_api

def tc_PythonTool_api(*args):
  return _tinkercell.tc_PythonTool_api(*args)
tc_PythonTool_api = _tinkercell.tc_PythonTool_api

def tc_JavaTool_api(*args):
  return _tinkercell.tc_JavaTool_api(*args)
tc_JavaTool_api = _tinkercell.tc_JavaTool_api

def tc_surface(*args):
  return _tinkercell.tc_surface(*args)
tc_surface = _tinkercell.tc_surface

def tc_plot(*args):
  return _tinkercell.tc_plot(*args)
tc_plot = _tinkercell.tc_plot

def tc_scatterplot(*args):
  return _tinkercell.tc_scatterplot(*args)
tc_scatterplot = _tinkercell.tc_scatterplot

def tc_errorBars(*args):
  return _tinkercell.tc_errorBars(*args)
tc_errorBars = _tinkercell.tc_errorBars

def tc_hist(*args):
  return _tinkercell.tc_hist(*args)
tc_hist = _tinkercell.tc_hist

def tc_multiplot(*args):
  return _tinkercell.tc_multiplot(*args)
tc_multiplot = _tinkercell.tc_multiplot

def tc_holdPlot(*args):
  return _tinkercell.tc_holdPlot(*args)
tc_holdPlot = _tinkercell.tc_holdPlot

def tc_clusterPlots(*args):
  return _tinkercell.tc_clusterPlots(*args)
tc_clusterPlots = _tinkercell.tc_clusterPlots

def tc_getPlotData(*args):
  return _tinkercell.tc_getPlotData(*args)
tc_getPlotData = _tinkercell.tc_getPlotData

def tc_gnuplot(*args):
  return _tinkercell.tc_gnuplot(*args)
tc_gnuplot = _tinkercell.tc_gnuplot

def tc_savePlot(*args):
  return _tinkercell.tc_savePlot(*args)
tc_savePlot = _tinkercell.tc_savePlot

def tc_setLogScale(*args):
  return _tinkercell.tc_setLogScale(*args)
tc_setLogScale = _tinkercell.tc_setLogScale

def tc_PlotTool_api(*args):
  return _tinkercell.tc_PlotTool_api(*args)
tc_PlotTool_api = _tinkercell.tc_PlotTool_api

def tc_writeModel(*args):
  return _tinkercell.tc_writeModel(*args)
tc_writeModel = _tinkercell.tc_writeModel

def tc_ModelFileGenerator_api(*args):
  return _tinkercell.tc_ModelFileGenerator_api(*args)
tc_ModelFileGenerator_api = _tinkercell.tc_ModelFileGenerator_api

def tc_getEventTriggers():
  return _tinkercell.tc_getEventTriggers()
tc_getEventTriggers = _tinkercell.tc_getEventTriggers

def tc_getEventResponses():
  return _tinkercell.tc_getEventResponses()
tc_getEventResponses = _tinkercell.tc_getEventResponses

def tc_addEvent(*args):
  return _tinkercell.tc_addEvent(*args)
tc_addEvent = _tinkercell.tc_addEvent

def tc_SimulationEventsTool_api(*args):
  return _tinkercell.tc_SimulationEventsTool_api(*args)
tc_SimulationEventsTool_api = _tinkercell.tc_SimulationEventsTool_api

def tc_getForcingFunctionNames(*args):
  return _tinkercell.tc_getForcingFunctionNames(*args)
tc_getForcingFunctionNames = _tinkercell.tc_getForcingFunctionNames

def tc_getForcingFunctionAssignments(*args):
  return _tinkercell.tc_getForcingFunctionAssignments(*args)
tc_getForcingFunctionAssignments = _tinkercell.tc_getForcingFunctionAssignments

def tc_addForcingFunction(*args):
  return _tinkercell.tc_addForcingFunction(*args)
tc_addForcingFunction = _tinkercell.tc_addForcingFunction

def tc_AssignmentFunctionsTool_api(*args):
  return _tinkercell.tc_AssignmentFunctionsTool_api(*args)
tc_AssignmentFunctionsTool_api = _tinkercell.tc_AssignmentFunctionsTool_api

def tc_displayText(*args):
  return _tinkercell.tc_displayText(*args)
tc_displayText = _tinkercell.tc_displayText

def tc_displayNumber(*args):
  return _tinkercell.tc_displayNumber(*args)
tc_displayNumber = _tinkercell.tc_displayNumber

def tc_setDisplayLabelColor(*args):
  return _tinkercell.tc_setDisplayLabelColor(*args)
tc_setDisplayLabelColor = _tinkercell.tc_setDisplayLabelColor

def tc_highlight(*args):
  return _tinkercell.tc_highlight(*args)
tc_highlight = _tinkercell.tc_highlight

def tc_CLabelsTool_api(*args):
  return _tinkercell.tc_CLabelsTool_api(*args)
tc_CLabelsTool_api = _tinkercell.tc_CLabelsTool_api

def tc_getAnnotation(*args):
  return _tinkercell.tc_getAnnotation(*args)
tc_getAnnotation = _tinkercell.tc_getAnnotation

def tc_setAnnotation(*args):
  return _tinkercell.tc_setAnnotation(*args)
tc_setAnnotation = _tinkercell.tc_setAnnotation

def tc_NameFamily_api_initialize(*args):
  return _tinkercell.tc_NameFamily_api_initialize(*args)
tc_NameFamily_api_initialize = _tinkercell.tc_NameFamily_api_initialize

def tc_partsIn(*args):
  return _tinkercell.tc_partsIn(*args)
tc_partsIn = _tinkercell.tc_partsIn

def tc_partsUpstream(*args):
  return _tinkercell.tc_partsUpstream(*args)
tc_partsUpstream = _tinkercell.tc_partsUpstream

def tc_partsDownstream(*args):
  return _tinkercell.tc_partsDownstream(*args)
tc_partsDownstream = _tinkercell.tc_partsDownstream

def tc_alignParts(*args):
  return _tinkercell.tc_alignParts(*args)
tc_alignParts = _tinkercell.tc_alignParts

def tc_alignPartsOnPlasmid(*args):
  return _tinkercell.tc_alignPartsOnPlasmid(*args)
tc_alignPartsOnPlasmid = _tinkercell.tc_alignPartsOnPlasmid

def tc_setSequence(*args):
  return _tinkercell.tc_setSequence(*args)
tc_setSequence = _tinkercell.tc_setSequence

def tc_AutoGeneRegulatoryTool_api(*args):
  return _tinkercell.tc_AutoGeneRegulatoryTool_api(*args)
tc_AutoGeneRegulatoryTool_api = _tinkercell.tc_AutoGeneRegulatoryTool_api

def tc_exportSBML(*args):
  return _tinkercell.tc_exportSBML(*args)
tc_exportSBML = _tinkercell.tc_exportSBML

def tc_importSBML(*args):
  return _tinkercell.tc_importSBML(*args)
tc_importSBML = _tinkercell.tc_importSBML

def tc_SBML_api(*args):
  return _tinkercell.tc_SBML_api(*args)
tc_SBML_api = _tinkercell.tc_SBML_api

def tc_simulateDeterministic(*args):
  return _tinkercell.tc_simulateDeterministic(*args)
tc_simulateDeterministic = _tinkercell.tc_simulateDeterministic

def tc_simulateStochastic(*args):
  return _tinkercell.tc_simulateStochastic(*args)
tc_simulateStochastic = _tinkercell.tc_simulateStochastic

def tc_simulateHybrid(*args):
  return _tinkercell.tc_simulateHybrid(*args)
tc_simulateHybrid = _tinkercell.tc_simulateHybrid

def tc_simulateTauLeap(*args):
  return _tinkercell.tc_simulateTauLeap(*args)
tc_simulateTauLeap = _tinkercell.tc_simulateTauLeap

def tc_getSteadyState():
  return _tinkercell.tc_getSteadyState()
tc_getSteadyState = _tinkercell.tc_getSteadyState

def tc_steadyStateScan(*args):
  return _tinkercell.tc_steadyStateScan(*args)
tc_steadyStateScan = _tinkercell.tc_steadyStateScan

def tc_steadyStateScan2D(*args):
  return _tinkercell.tc_steadyStateScan2D(*args)
tc_steadyStateScan2D = _tinkercell.tc_steadyStateScan2D

def tc_getJacobian():
  return _tinkercell.tc_getJacobian()
tc_getJacobian = _tinkercell.tc_getJacobian

def tc_getEigenvalues():
  return _tinkercell.tc_getEigenvalues()
tc_getEigenvalues = _tinkercell.tc_getEigenvalues

def tc_getUnscaledElasticities():
  return _tinkercell.tc_getUnscaledElasticities()
tc_getUnscaledElasticities = _tinkercell.tc_getUnscaledElasticities

def tc_getUnscaledConcentrationCC():
  return _tinkercell.tc_getUnscaledConcentrationCC()
tc_getUnscaledConcentrationCC = _tinkercell.tc_getUnscaledConcentrationCC

def tc_getUnscaledFluxCC():
  return _tinkercell.tc_getUnscaledFluxCC()
tc_getUnscaledFluxCC = _tinkercell.tc_getUnscaledFluxCC

def tc_getScaledElasticities():
  return _tinkercell.tc_getScaledElasticities()
tc_getScaledElasticities = _tinkercell.tc_getScaledElasticities

def tc_getScaledConcentrationCC():
  return _tinkercell.tc_getScaledConcentrationCC()
tc_getScaledConcentrationCC = _tinkercell.tc_getScaledConcentrationCC

def tc_getScaledFluxCC():
  return _tinkercell.tc_getScaledFluxCC()
tc_getScaledFluxCC = _tinkercell.tc_getScaledFluxCC

def tc_reducedStoichiometry():
  return _tinkercell.tc_reducedStoichiometry()
tc_reducedStoichiometry = _tinkercell.tc_reducedStoichiometry

def tc_elementaryFluxModes():
  return _tinkercell.tc_elementaryFluxModes()
tc_elementaryFluxModes = _tinkercell.tc_elementaryFluxModes

def tc_LMatrix():
  return _tinkercell.tc_LMatrix()
tc_LMatrix = _tinkercell.tc_LMatrix

def tc_KMatrix():
  return _tinkercell.tc_KMatrix()
tc_KMatrix = _tinkercell.tc_KMatrix

def tc_optimize(*args):
  return _tinkercell.tc_optimize(*args)
tc_optimize = _tinkercell.tc_optimize

def tc_COPASI_api(*args):
  return _tinkercell.tc_COPASI_api(*args)
tc_COPASI_api = _tinkercell.tc_COPASI_api

def tc_substituteModel(*args):
  return _tinkercell.tc_substituteModel(*args)
tc_substituteModel = _tinkercell.tc_substituteModel

def tc_substituteEmptyModel(*args):
  return _tinkercell.tc_substituteEmptyModel(*args)
tc_substituteEmptyModel = _tinkercell.tc_substituteEmptyModel

def tc_substituteOriginalModel(*args):
  return _tinkercell.tc_substituteOriginalModel(*args)
tc_substituteOriginalModel = _tinkercell.tc_substituteOriginalModel

def tc_listOfPossibleModels(*args):
  return _tinkercell.tc_listOfPossibleModels(*args)
tc_listOfPossibleModels = _tinkercell.tc_listOfPossibleModels

def tc_ModuleTool_api(*args):
  return _tinkercell.tc_ModuleTool_api(*args)
tc_ModuleTool_api = _tinkercell.tc_ModuleTool_api


