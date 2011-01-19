SET(QT_QTCORE Versions/4/QtCore)
SET(QT_QTGUI Versions/4/QtGui)
SET(QT_QTXML Versions/4/QtXml)
SET(QT_QTOPENGL Versions/4/QtOpenGL)

CONFIGURE_FILE( 
  ${TINKERCELL_SOURCE_DIR}/mac/create_bundled_app.sh.in
  ${TINKERCELL_BINARY_DIR}/mac/create_bundled_app.sh
  @ONLY
)

MESSAGE("run ${TINKERCELL_BINARY_DIR}/mac/create_bundle_app.sh to make the app")