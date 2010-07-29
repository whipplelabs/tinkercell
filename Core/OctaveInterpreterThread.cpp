/****************************************************************************

 Copyright (c) 2008 Deepak Chandran
 Contact: Deepak Chandran (dchandran1@gmail.com)
 See COPYRIGHT.TXT
 
The octave interpreter that runs as a separate thread and can accept strings to parse and execute


****************************************************************************/

#include "GraphicsScene.h"
#include "MainWindow.h"
#include "NodeGraphicsItem.h"
#include "ConnectionGraphicsItem.h"
#include "TextGraphicsItem.h"
#include "ConsoleWindow.h"
#include "OctaveInterpreterThread.h"

namespace Tinkercell
{
	
    OctaveInterpreterThread::OctaveInterpreterThread(const QString & dllname, MainWindow* main)
        : InterpreterThread(dllname,main)
    {
    	f = 0;
    }
    
    void OctaveInterpreterThread::finalize()
    {
        if (!lib || !lib->isLoaded()) return;

        finalFunc f = (finalFunc)lib->resolve("finalize");
        if (f)
        {
            QString currentDir = QDir::currentPath();

            QDir::setCurrent(MainWindow::tempDir());

            f();

            QDir::setCurrent(currentDir);
        }
    }
    
    void OctaveInterpreterThread::initialize()
    {
        if (!mainWindow || !lib || !lib->isLoaded())
		{
			//qDebug() << "Octave interpreter: lib not loaded" << mainWindow << " " << lib;
			return;
		}

        QString appDir = QCoreApplication::applicationDirPath();

        initFunc f = (initFunc)lib->resolve("initialize");
        if (f)
        {
            mainWindow->console()->message(tr("Octave initialized"));
            QString currentDir = QDir::currentPath();

            QDir::setCurrent(MainWindow::tempDir());

            setCPointers();
            f();

            QDir::setCurrent(currentDir);
            
            mainWindow->statusBar()->showMessage(tr("Octave initialized"));
        }
    }
    
    void OctaveInterpreterThread::run()
    {
       if (!lib || !lib->isLoaded() || code.isEmpty()) return;
       
       static QString header;

        QString script;
		
        if (!f)
            f = (execFunc)lib->resolve("exec");
           
        //QDir dir(MainWindow::tempDir());
		//QString filename(dir.absoluteFilePath("octave.m"));
		//QFile file(filename);

        if (f)// && file.open(QIODevice::WriteOnly))
        {
        	if (header.isEmpty())
        	{
        		header = QObject::tr("addpath('");
#ifdef Q_WS_WIN
				header += tr("\"") + MainWindow::homeDir() + tr("\"\\\\octave')\n");
#else
				header += MainWindow::homeDir() + tr("/octave')\n");
#endif
	        	header += QObject::tr("tinkercell('global')\n\n");
	        }

        	//file.write(header.toAscii());
			//file.write(script.toAscii());
			//file.close();
			
			//script = header;
			script += code;

            QString currentDir = QDir::currentPath();
            QDir::setCurrent(MainWindow::tempDir());

            f(script.toAscii().data(),"octav.out");
            if (mainWindow && mainWindow->console())
            {
            	QFile file(tr("octav.out"));
            	if (file.open(QFile::ReadOnly | QFile::Text))
            	{
		            QString allText(file.readAll());
					mainWindow->console()->message(allText);
					file.close();
				}
            }

            QDir::setCurrent(currentDir);
        }
		
		if (!codeQueue.isEmpty())
		{
			code = codeQueue.dequeue();
			run();
		}
    }

}
