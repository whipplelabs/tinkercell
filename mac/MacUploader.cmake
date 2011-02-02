SET(QT_QTCORE Versions/4/QtCore)
SET(QT_QTGUI Versions/4/QtGui)
SET(QT_QTXML Versions/4/QtXml)
SET(QT_QTOPENGL Versions/4/QtOpenGL)

CONFIGURE_FILE( 
  ${TINKERCELL_SOURCE_DIR}/mac/CreateApp.sh.in
  ${TINKERCELL_BINARY_DIR}/mac/CreateApp.sh
  @ONLY
)

MESSAGE(STATUS "To create and upload the app, source ${TINKERCELL_BINARY_DIR}/mac/CreateApp.sh (only uploads if you provided the Sourceforge account)")