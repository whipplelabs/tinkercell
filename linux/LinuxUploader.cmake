OPTION( TINKERCELL_64BIT "Is this a 64-bit machine?" OFF )
OPTION( TINKERCELL_UPLOAD_SOURCE "upload source tarball in upload.sh?" OFF )

#the following is used to generate two different files with 32 or 64 in its name
#see upload.sh
IF (TINKERCELL_64BIT)
     SET(TINKERCELL_BIT 64)
ELSE(TINKERCELL_64BIT)
     SET(TINKERCELL_BIT 32)
ENDIF(TINKERCELL_64BIT)

IF (DEFINED TINKERCELL_SOURCEFORGE_PASSWORD AND DEFINED TINKERCELL_SOURCEFORGE_USERNAME)

	CONFIGURE_FILE( 
			${TINKERCELL_SOURCE_DIR}/linux/run_tinkercell.sh
			${TINKERCELL_BINARY_DIR}/run_tinkercell.sh
			@ONLY
		)

	CONFIGURE_FILE( 
			${TINKERCELL_SOURCE_DIR}/linux/upload.sh
			${TINKERCELL_BINARY_DIR}/upload.sh
			@ONLY
		)

	MESSAGE("To upload TinkerCell, source ${TINKERCELL_BINARY_DIR}/upload.sh")
ELSE (DEFINED TINKERCELL_SOURCEFORGE_PASSWORD AND DEFINED TINKERCELL_SOURCEFORGE_USERNAME)
	
	MESSAGE( "Please create two New Entries of type STRING called TINKERCELL_SOURCEFORGE_USERNAME and TINKERCELL_SOURCEFORGE_PASSWORD, and populate then with your Sourceforge username and password")
	
ENDIF (DEFINED TINKERCELL_SOURCEFORGE_PASSWORD AND DEFINED TINKERCELL_SOURCEFORGE_USERNAME)

MESSAGE("To run TinkerCell, source ${TINKERCELL_BINARY_DIR}/run_tinkercell.sh")	
INSTALL(FILES ${TINKERCELL_BINARY_DIR}/linux/run_tinkercell.sh DESTINATION bin/../ COMPONENT "TinkerCell")
