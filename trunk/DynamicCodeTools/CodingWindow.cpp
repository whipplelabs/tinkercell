/****************************************************************************
 Copyright (c) 2008 Deepak Chandran
 Contact: Deepak Chandran (dchandran1@gmail.com)
 see COPYRIGHT.TXT

 Provides a text window where C code can be written and run dynamically

****************************************************************************/
#include <QProcess>
#include "GraphicsScene.h"
#include "MainWindow.h"
#include "NodeGraphicsItem.h"
#include "ConnectionGraphicsItem.h"
#include "TextGraphicsItem.h"
#include "ConsoleWindow.h"
#include "CodingWindow.h"
#include "PythonTool.h"
#include "OctaveTool.h"
#include "LoadCLibraries.h"
#include <QRegExp>
#include <QVBoxLayout>
#include <QDockWidget>
#include <QProcess>
#include <QLibrary>
#include <QProgressBar>
#include <QDir>
#include <QtDebug>
#include <QDesktopServices>

namespace Tinkercell
{
	 /********************************
	      Coding window
	 *********************************/

	bool CodingWindow::DO_SVN_UPDATE = true;
	
	CodingWindow::CodingWindow()
		 : Tool(tr("Coding Window"),tr("Coding"))
	{
		 QString appDir = QCoreApplication::applicationDirPath();
		 QString homeDir = MainWindow::tempDir();
		 fileName = homeDir + tr("/code.c");
		 
		 toolBar = 0;
		 progressBar = 0;
		 window = new QMainWindow(this);

		 setupEditor();
		 setupMenu();
		 
 		QSettings settings(MainWindow::ORGANIZATIONNAME, MainWindow::ORGANIZATIONNAME);
		settings.beginGroup("Subversion");
		DO_SVN_UPDATE = settings.value(tr("auto-update"),true).toBool();
		settings.endGroup();
	}
	
	void CodingWindow::convertCodeToButton()
	{
		if (selectedLanguage == Python)
			convertCodeToButtonPy();
		else
		if (selectedLanguage == Octave)
			convertCodeToButtonOctave();
		else
		if (selectedLanguage == C)
			convertCodeToButtonC();
	}

	void CodingWindow::convertCodeToButtonC()
	{
		QString code = editor->toPlainText();
		if (!code.contains("tc_addFunction"))
		{
			code += 
			tr("\n\nTCAPIEXPORT void tc_main()\n{\n\
    /*the last three arguments are: specific family (string), show in menu (1 or 0), context menu (1 or 0), set as default function (1 or 0)*/ \n\n\
    tc_addFunction(&run, \n\
\"Function name\", \n\
\"Short description\", \n\
\"Category\", \n\
\"plugins/c/function.png\", \n\
\"\", 1, 0, 0); \n}\n\n");
			editor->setPlainText(code);
			QMessageBox::information(this,tr("Program description missing"),tr("tc_main and tc_addFunction are required for adding a new C function to the programs menu. Take a look at the code."));
			return;
		}
		
		QString tempDir = MainWindow::tempDir();
		QString homeDir = MainWindow::homeDir();
		
		QString filename = tempDir + tr("/code.c");
		QFile qfile(filename);
		if (!qfile.open(QIODevice::WriteOnly | QIODevice::Text))
		{
			QMessageBox::about(this, tr("Error"),
					 tr("Cannot write file: ") + tempDir + tr("/code.c"));
			return;
		}
		
		QString dllName = QInputDialog::getText(this,tr("Program name"),tr("Name your program (one words):"));
		dllName.replace(QRegExp("[^A-Za-z0-9]"),tr("_"));

		QTextStream out(&qfile);
		out << code;
		qfile.close();

		QDir userHomeDir(homeDir);

		if (!userHomeDir.cd(tr("plugins")))
		{
			userHomeDir.mkdir(tr("plugins"));
			userHomeDir.cd(tr("plugins"));
		}
		
		if (!userHomeDir.cd(tr("c")))
		{
			userHomeDir.mkdir(tr("c"));
			userHomeDir.cd(tr("c"));
		}

		dllName = homeDir + tr("/plugins/c/") + dllName;
		emit compile(tr("code.c"),dllName);
		
		QMessageBox::information(this,tr("Saved"),tr("Your program has been saved as ") + dllName);		
		mainWindow->loadDynamicLibrary(dllName);
	}
		
	
	void CodingWindow::convertCodeToButtonPy()
	{
		if (!editor) return;
		
		QString text = editor->toPlainText();
		if (!text.startsWith("\"\"\""))
		{
			text = tr("\"\"\"\n\
category: Miscellaneous\n\
name: name of program\n\
description: what does this program do?\n\
icon: plugins/c/function.png\n\
menu: yes\n\
tool: yes\n\
specific for:\n\"\"\"\n\n") + text;
			editor->setPlainText(text);
			QMessageBox::information(this,tr("Program description missing"),tr("Please enter the program description in comments"));
			return;
		}		
		
		QString homeDir = MainWindow::homeDir();
		QDir userHomeDir(homeDir);
		
		if (!userHomeDir.cd(tr("python")))
		{
			userHomeDir.mkdir(tr("python"));
			if (!userHomeDir.cd(tr("python")))
			{
				QMessageBox::information(this,tr("Error"),tr("TinkerCell is not able to write to the Documents folder"));
				return;
			}
		}
		
		QString filename = QFileDialog::getSaveFileName(this,tr("Save your program"),userHomeDir.absolutePath(),tr("*.py"));
		
		QFile pyfile(filename);
		
		if (!pyfile.open(QIODevice::WriteOnly | QIODevice::Text))
			return;
		else
			QMessageBox::information(this,tr("Saved"),tr("Your program has been saved as ") + filename);

		QTextStream outpy(&pyfile);
		outpy << (editor->toPlainText());
		pyfile.close();
		
		loadPyFromDir(userHomeDir);
	}
	
	void CodingWindow::convertCodeToButtonOctave()
	{
		QString text = editor->toPlainText();
		if (!text.contains("#category") || !text.contains("#name"))
		{
			text = tr("\
#category: Miscellaneous\n\
#name: My function\n\
#description: This program does something\n\
#icon: plugins/c/function.png\n\
#menu: yes\n\
#tool: yes\n\
#specific for:\n\n") + text;
			editor->setPlainText(text);
			QMessageBox::information(this,tr("Program description missing"),tr("Please enter the program description in comments"));
			return;
		}		
		
		QString homeDir = MainWindow::homeDir();
		QDir userHomeDir(homeDir);
		
		if (!userHomeDir.cd(tr("octave")))
		{
			userHomeDir.mkdir(tr("octave"));
			if (!userHomeDir.cd(tr("octave")))
			{
				QMessageBox::information(this,tr("Error"),tr("TinkerCell is not able to write to the Documents folder"));
				return;
			}
		}
		
		QString filename = QFileDialog::getSaveFileName(this,tr("Save your program"),userHomeDir.absolutePath(),tr("*.py"));
		
		QFile octfile(filename);
		
		if (!octfile.open(QIODevice::WriteOnly | QIODevice::Text))
			return;
		else
			QMessageBox::information(this,tr("Saved"),tr("Your program has been saved as ") + filename);

		QTextStream outoct(&octfile);
		outoct << (editor->toPlainText());
		octfile.close();
		
		loadPyFromDir(userHomeDir);
	}
	
	void CodingWindow::enableC(bool b)
	{
	    if (!b || selectedLanguage == C) return;
	    
	    selectedLanguage = C;
	    
	    if (cButton)
	        cButton->setChecked(true);
	    
	    if (cAction)
	        cAction->setChecked(true);
	    
	    if (editor)
	 		editor->setPlainText(tr("#include \"TC_api.h\"\nTCAPIEXPORT void run()\n{\n\n\n\n   return; \n}\n"));
	}
	
	void CodingWindow::enableOctave(bool b)
	{  
	    if (!b || selectedLanguage == Octave) return;
	    
	    selectedLanguage = Octave;
	    disablePython();
	    
  	    if (octaveButton)
	        octaveButton->setChecked(true);
	    
	    if (octaveAction)
	        octaveAction->setChecked(true);

	    QWidget * widget = mainWindow->tool(tr("Octave Interpreter"));
		if (widget)
		{
			OctaveTool * ocTool = static_cast<OctaveTool*>(widget);
    	    ConsoleWindow * outWin = console();
			if (outWin && ocTool->octaveInterpreter)
			{
				outWin->setInterpreter(ocTool->octaveInterpreter);
				connect(ocTool->octaveInterpreter,SIGNAL(progress(int)),progressBar,SLOT(setValue(int)));
			}
		}
	}
	
	void CodingWindow::disableOctave()
	{
	    QWidget * widget = mainWindow->tool(tr("Octave Interpreter"));
		if (widget)
		{
			OctaveTool * ocTool = static_cast<OctaveTool*>(widget);
    	    ConsoleWindow * outWin = console();
			if (outWin && ocTool->octaveInterpreter)
			{
				outWin->setInterpreter(0);
				disconnect(ocTool->octaveInterpreter,SIGNAL(progress(int)),progressBar,SLOT(setValue(int)));
			}
		}
	}
	
	void CodingWindow::enablePython(bool b)
	{
	    if (!b || selectedLanguage == Python) return;
	    
	    selectedLanguage = Python;
	    
   	    if (pythonButton)
	        pythonButton->setChecked(true);
	    
	    if (pythonAction)
	        pythonAction->setChecked(true);
	    
	    disableOctave();

	    QWidget * widget = mainWindow->tool(tr("Python Interpreter"));
		if (widget)
		{
			PythonTool * pyTool = static_cast<PythonTool*>(widget);
    	    ConsoleWindow * outWin = console();
			if (outWin && pyTool->pythonInterpreter)
			{
				outWin->setInterpreter(pyTool->pythonInterpreter);
				connect(pyTool->pythonInterpreter,SIGNAL(progress(int)),progressBar,SLOT(setValue(int)));
			}
		}
	}
	
	void CodingWindow::disablePython()
	{
	    QWidget * widget = mainWindow->tool(tr("Python Interpreter"));
		if (widget)
		{
			PythonTool * pyTool = static_cast<PythonTool*>(widget);
    	    ConsoleWindow * outWin = console();
			if (outWin && pyTool->pythonInterpreter)
			{
				outWin->setInterpreter(0);
				disconnect(pyTool->pythonInterpreter,SIGNAL(progress(int)),progressBar,SLOT(setValue(int)));
			}
		}
	}
	
	void CodingWindow::toggleSVNupdate(bool b)
	{
		QSettings settings(MainWindow::ORGANIZATIONNAME,MainWindow::ORGANIZATIONNAME);
		settings.beginGroup("Subversion");
		DO_SVN_UPDATE = b;
		settings.setValue(tr("auto-update"),b);
		settings.endGroup();
	}

	bool CodingWindow::setMainWindow(MainWindow* main)
	{
		Tool::setMainWindow(main);

		QString appDir = QCoreApplication::applicationDirPath();

		QSplitter * splitter = new QSplitter(Qt::Horizontal);
	        splitter->addWidget(editorWidget);
        	splitter->addWidget(new TCFunctionsListView(mainWindow, appDir + tr("/c"), editor));
	        splitter->setStretchFactor(0,2);

	        window->setCentralWidget(splitter);
	        window->setWindowTitle(name);

		if (mainWindow)
		{
			QDockWidget * dock = 0;
			setWindowTitle(name);
			setWindowIcon(QIcon(tr(":/images/cmd.png")));
			dock = mainWindow->addToolWindow(window, MainWindow::DockWidget, Qt::BottomDockWidgetArea, Qt::BottomDockWidgetArea);
			dock->move(mainWindow->geometry().bottomRight() - QPoint(sizeHint().width()*2,sizeHint().height()));
			dock->hide();
			dock->setFloating(true);

			QToolBar * toolBar = mainWindow->toolBarForTools;
			QAction * action = new QAction(tr("Coding Window"),toolBar);
			action->setIcon(QIcon(tr(":/images/tool.png")));

			if (dock)
				connect(action,SIGNAL(triggered()),dock,SLOT(show()));
			else
			{
				if (mainWindow->viewMenu)
				{
					QAction * toggle = mainWindow->viewMenu->addAction(tr("Coding Window"));
					toggle->setCheckable(true);
					connect(toggle,SIGNAL(toggled(bool)),this,SLOT(setVisible(bool)));
				}
				connect(action,SIGNAL(triggered()),this,SLOT(show()));
			}
			
			if (mainWindow->optionsMenu)
			{
				mainWindow->optionsMenu->addSeparator();
				QAction * svnupdate = mainWindow->optionsMenu->addAction(tr("SVN updates"));
				svnupdate->setToolTip(tr("TinkerCell home folder will be updated with new models and plug-ins during startup"));					
				svnupdate->setCheckable(true);
				svnupdate->setChecked(true);
				connect(svnupdate,SIGNAL(toggled(bool)),this,SLOT(toggleSVNupdate(bool)));
			}
			
			toolBar->addAction(action);
			if (this->toolBar)
			{
			    progressBar = new QProgressBar(this->toolBar);
				progressBar->setRange(0,100);
				this->toolBar->addWidget(progressBar);
				progressBar->setToolTip("Progress meter for running code");
			}

			if (mainWindow->tool(tr("Python Interpreter")))
			{
				QWidget * widget = mainWindow->tool(tr("Python Interpreter"));
				if (widget)
				{
					PythonTool * pyTool = static_cast<PythonTool*>(widget);
					
					connect(this,SIGNAL(runPython(const QString&)),pyTool,SLOT(runPythonCode(const QString&)));
					connect(this,SIGNAL(loadPyFromDir( QDir& )),pyTool,SLOT(loadFromDir( QDir& )));
				}
			}
			
			if (mainWindow->tool(tr("Octave Interpreter")))
			{
				QWidget * widget = mainWindow->tool(tr("Octave Interpreter"));
				if (widget)
				{
					OctaveTool * ocTool = static_cast<OctaveTool*>(widget);
					
					connect(this,SIGNAL(runOctave(const QString&)),ocTool,SLOT(runOctaveCode(const QString&)));
					connect(this,SIGNAL(loadOctFromDir( QDir& )),ocTool,SLOT(loadFromDir( QDir& )));
				}
			}

			if (mainWindow->tool(tr("Load C Libraries")))
			{
				QWidget * widget = mainWindow->tool(tr("Load C Libraries"));
				if (widget)
				{
					LoadCLibrariesTool * loadCTool = static_cast<LoadCLibrariesTool*>(widget);
					connect(this,SIGNAL(compileBuildLoadC(const QString&,const QString&,const QString&)),
							loadCTool,SLOT(compileBuildLoadC(const QString&,const QString&,const QString&)));
					connect(this,SIGNAL(compile(const QString&, QString&)),
							loadCTool,SLOT(compile(const QString&, QString&)));
				}
			}

			if (mainWindow->helpMenu)
			{
				QList<QAction*> actions = mainWindow->helpMenu->actions();
				QAction * pyscesHelp = mainWindow->helpMenu->addAction(tr("PySCeS user manual"),this,SLOT(pyscesHelp()));
				QAction * aboutAction = 0;
	
				for (int i=0; i < actions.size(); ++i)
					if (actions[i] && actions[i]->text() == tr("About"))
					{
						aboutAction = actions[i];
						break;	
					}
				if (aboutAction)
				{	
					mainWindow->helpMenu->removeAction(aboutAction);
					mainWindow->helpMenu->addSeparator();
					mainWindow->helpMenu->addAction(aboutAction);
				}
			}

			if (mainWindow->optionsMenu && cButton && pythonButton && octaveButton)
			{
				QMenu * langMenu = mainWindow->optionsMenu->addMenu(tr("Console language"));
				QActionGroup * actionGroup = new QActionGroup(this);
				
				cAction = langMenu->addAction(tr("C"));
				pythonAction = langMenu->addAction(tr("Python"));
				octaveAction = langMenu->addAction(tr("Octave"));
				
				connect(cAction,SIGNAL(toggled(bool)),this,SLOT(enableC(bool)));
				connect(pythonAction,SIGNAL(toggled(bool)),this,SLOT(enablePython(bool)));
				connect(octaveAction,SIGNAL(toggled(bool)),this,SLOT(enableOctave(bool)));
                
				cAction->setCheckable(true);
				pythonAction->setCheckable(true);
				octaveAction->setCheckable(true);

				actionGroup->addAction(cAction);
				actionGroup->addAction(pythonAction);
				actionGroup->addAction(octaveAction);
				actionGroup->setExclusive(true);
			}
			
			enablePython();
			
			//if (console())
			//	connect(this,SIGNAL(stop()),console(),SIGNAL(commandInterrupted()));

			return true;
		}
		return false;
	}

	 void CodingWindow::pyscesHelp()
	 {
		QString appDir = QCoreApplication::applicationDirPath();
		//QProcess::execute(appDir + tr("/Documentation/pysces_userguide.pdf"));
		QDesktopServices::openUrl(QUrl(appDir + tr("/Documentation/pysces_userguide.pdf")));
	 }

	 void CodingWindow::about()
	 {
		 QMessageBox::about(this, tr("About Coding Window"),
					 tr("This tool allows run-time execution of C, Python, and Octave code. The code can also be added permanently to TinkerCell."));
	 }

	 void CodingWindow::setupEditor()
	 {
		QFont font;
		font.setFamily("Courier");
		font.setFixedPitch(true);
		font.setPointSize(10);

		editor = new RuntimeCodeEditor;
		editor->setFont(font);

		highlighter = new CandPythonSyntaxHighlighter(editor->document());
		
		cAction = octaveAction = pythonAction = 0;
		 
		cButton = new QRadioButton("C"),
        octaveButton = new QRadioButton("Octave"),
        pythonButton = new QRadioButton("Python");
		
		connect(cButton,SIGNAL(toggled(bool)),this,SLOT(enableC(bool)));
		connect(pythonButton,SIGNAL(toggled(bool)),this,SLOT(enablePython(bool)));
		connect(octaveButton,SIGNAL(toggled(bool)),this,SLOT(enableOctave(bool)));
		 
 		QHBoxLayout * layout1 = new QHBoxLayout;
 		layout1->addWidget(cButton,0);
 		layout1->addWidget(pythonButton,0);
 		layout1->addWidget(octaveButton,0);
 		layout1->addStretch(1);
 		
 		QVBoxLayout * layout2 = new QVBoxLayout;
 		layout2->addLayout(layout1);
		layout2->addWidget(editor);
		//layout2->setContentsMargins(0,0,0,0);
		
		editorWidget = new QWidget(this);
		editorWidget->setLayout(layout2);
	 }

	 void CodingWindow::setupMenu()
	 {
		 toolBar = new QToolBar(window);
		 QAction * action;

		 action = toolBar->addAction(QIcon(":/images/new.png"),tr("New"),this,SLOT(newDoc()));
		 action->setShortcut(QKeySequence(QKeySequence::New));
		 action->setToolTip(tr("New"));

		 //action = toolBar->addAction(QIcon(":/images/open.png"),tr("Open"),this,SLOT(open()));
		 //action->setShortcut(QKeySequence(QKeySequence::Open));
		 //action->setToolTip(tr("Open"));

		 action = toolBar->addAction(QIcon(":/images/save.png"),tr("Save"),this,SLOT(convertCodeToButton()));
		 action->setShortcut(QKeySequence(QKeySequence::Save));
		 action->setToolTip(tr("Incorporate in TinkerCell"));

		 action = toolBar->addAction(QIcon(":/images/undo.png"),tr("Undo"),this,SLOT(undo()));
		 action->setToolTip(tr("Undo"));

		 action = toolBar->addAction(QIcon(":/images/redo.png"),tr("Redo"),this,SLOT(redo()));
		 action->setToolTip(tr("Redo"));

		 //action = toolBar->addAction(QIcon(":/images/cmd.png"),tr("Command"),&commandDialog,SLOT(exec()));
		 //action->setToolTip(tr("Edit command"));

		 action = toolBar->addAction(QIcon(":/images/play.png"),tr("Run"),this,SLOT(run()));
		 action->setToolTip(tr("Run code"));

		 //action = toolBar->addAction(QIcon(":/images/function.png"),tr("Buttonize"),this,SLOT(convertCodeToButton()));
		 //action->setToolTip(tr("Add code to the functions list"));

		 action = toolBar->addAction(QIcon(":/images/about.png"),tr("About"),this,SLOT(about()));
		 action->setToolTip(tr("About"));

		 //new QShortcut(tr("Ctrl+S"),this,SLOT(save()),SLOT(save()),Qt::WidgetShortcut);
		 //new QShortcut(tr("Ctrl+N"),this,SLOT(newDoc()),SLOT(newDoc()),Qt::WidgetShortcut);
		 //new QShortcut(tr("Ctrl+A"),this,SLOT(selectAll()),SLOT(selectAll()),Qt::WidgetShortcut);

		 window->addToolBar(toolBar);

		 //editorC->grabShortcut(tr("Ctrl+S"));
		 //editorC->grabShortcut(tr("Ctrl+N"));
		 //editorC->grabShortcut(tr("Ctrl+A"));
	 }

	void CodingWindow::newDoc()
	{
		if (editor)
		{
		    editor->clear();
			editor->defaultSavedFilename.clear();

			if (selectedLanguage == C)
			{
                enableC();
			}
			else
			if (selectedLanguage == Python)
			{
                enablePython();
			}
			else
			if (selectedLanguage == Octave)
			{
                enableOctave();
			}
		}
	}

	void CodingWindow::selectAll()
	{
		if (editor)
		{
			editor->selectAll();
		}
	}

	void CodingWindow::open()
	{
		if (editor)
		{
			if (selectedLanguage == C)
				editor->open("C Files (*.c)");
			else
			if (selectedLanguage == Python)
				editor->open("Python Files (*.py)");
			else
			if (selectedLanguage == Octave)
				editor->open("Octave Files (*.m)");
		}
	}

	void CodingWindow::save()
	{
		if (editor)
		{
			if (selectedLanguage == C)
				editor->save("C Files (*.c)");
			else
			if (selectedLanguage == Python)
				editor->save("Python Files (*.py)");
			else
			if (selectedLanguage == Octave)
				editor->save("Octave Files (*.m)");
		}
	}

	void CodingWindow::undo()
	{
		if (editor)
		{
			editor->undo();
		}
	}

	void CodingWindow::redo()
	{
		if (editor)
		{
			editor->redo();
		}
	}

	 void CodingWindow::run()
	 {
		if (editor)
		{
			if (selectedLanguage == C)
				runC(editor->toPlainText());
            else
			if (selectedLanguage == Python)
				emit runPython(editor->toPlainText());
            else
			if (selectedLanguage == Octave)
				emit runOctave(editor->toPlainText());
		}
	 }

	 void CodingWindow::runC(const QString& code)
	 {
		if (mainWindow == 0) return;

 		QFile qfile(fileName);
		if (!qfile.open(QIODevice::WriteOnly | QIODevice::Text))
			 return;

		QTextStream out(&qfile);
        if (code.contains( QRegExp(tr("TCAPIEXPORT void\\s+run\\s*\\(\\s*\\)")) ))

		{
			out << code;
		}
		else
		{
            QMessageBox::information(mainWindow,tr("Error"),tr("code must define: TCAPIEXPORT void run()"));
			return;
		}

		qfile.close();

		emit compileBuildLoadC(tr("code.c -lode -lssa"),tr("run"),tr("C code"));
	 }

	 QSize CodingWindow::sizeHint() const
	 {
		 return QSize(500,300);
	 }


	 /********************************
	      TEXT EDITOR
	 *********************************/

	 void RuntimeCodeEditor::open(const QString& ext)
	 {
		 QString fileName;

		 if (fileName.isNull())
			 fileName = QFileDialog::getOpenFileName(this,
				 tr("Open File"), MainWindow::previousFileName, ext);

		 if (!fileName.isEmpty()) {
			 QFile file(fileName);
			 if (file.open(QFile::ReadOnly | QFile::Text))
				 setPlainText(file.readAll());
		 }
	 }

	 void RuntimeCodeEditor::save(const QString& ext)
	 {
		 QString fileName;

		 if (defaultSavedFilename.contains(ext))
			fileName = defaultSavedFilename[ext];

		 if (fileName.isNull() || fileName.isEmpty())
		 {
			 fileName = QFileDialog::getSaveFileName(this, tr("Save File"),MainWindow::previousFileName, ext);
		 }

		 if (!fileName.isNull() && !fileName.isEmpty())
		 {
			 MainWindow::previousFileName = fileName.remove(QRegExp(tr("\\.*")));
			 QFile file(fileName);
			 if (file.open(QFile::WriteOnly | QFile::Text))
			 {
				 file.write(toPlainText().toAscii());
				 defaultSavedFilename[ext] = fileName;
			 }
		 }
	 }

	 void RuntimeCodeEditor::saveAs(const QString& ext)
	 {
		 QString fileName;

		 if (fileName.isNull())
			 fileName = QFileDialog::getSaveFileName(this,
				 tr("Save File"), MainWindow::previousFileName, ext);

		 if (!fileName.isNull() && !fileName.isEmpty())
		 {
			 MainWindow::previousFileName = fileName.remove(QRegExp(tr("\\.*")));
			 QFile file(fileName);
			 if (file.open(QFile::WriteOnly | QFile::Text))
			 {
				 file.write(toPlainText().toAscii());
			 }
		 }
	 }
/*
	 void RuntimeCodeEditor::keyPressEvent ( QKeyEvent * keyEvent )
	 {
		 if (keyEvent == 0) return;
		 if (completer.widget() != this) completer.setWidget(this);
		 int key = keyEvent->key();
		 if (keyEvent->modifiers() == Qt::ControlModifier)
		 {
			 if (key == Qt::Key_Equal)
			 {
				 zoomIn();
			 }
			 else
			 if (key == Qt::Key_Minus)
			 {
				 zoomOut();
			 }
			 else
			 if (key == Qt::Key_A)
			 {
				 selectAll();
			 }
			 else
			 {
				 CodeEditor::keyPressEvent(keyEvent);
			 }
			 return;
		 }

		 if (completer.popup()->isVisible())
		 {
			 // The following keys are forwarded by the completer to the widget
			switch (keyEvent->key())
			{
				case Qt::Key_Enter:
				case Qt::Key_Return:
				case Qt::Key_Escape:
				case Qt::Key_Tab:
					keyEvent->ignore();
					 return;
				case Qt::Key_Backtab:
 					 CodeEditor::keyPressEvent(keyEvent);
					 return; // let the completer do default behavior
				default:
					break;
			}
		}

		 if (keyEvent->text().isEmpty())
		 {
			 CodeEditor::keyPressEvent(keyEvent);
			 return;
		 }
		QTextCursor tc = textCursor();
		tc.movePosition(QTextCursor::Left);
		tc.select(QTextCursor::WordUnderCursor);
		QString completionPrefix = tc.selectedText().trimmed();
		tc.movePosition(QTextCursor::Right);

		if (completionPrefix.length() < 1)
		{
			completer.popup()->hide();
			CodeEditor::keyPressEvent(keyEvent);
			return;
		}

		//auto complete
		if (completionPrefix != completer.completionPrefix())
		{
			completer.setCompletionPrefix(completionPrefix);
			completer.popup()->setCurrentIndex(completer.completionModel()->index(0, 0));
		}
		QRect cr = cursorRect();
		cr.setWidth(completer.popup()->sizeHintForColumn(0)
                    + completer.popup()->verticalScrollBar()->sizeHint().width());

		CodeEditor::keyPressEvent(keyEvent);

		completer.complete(cr); // show functions
	 }
*/
	 void RuntimeCodeEditor::insertCompletion(const QString& completion)
	 {
		 if (completer.widget() != this)
			 return;
		 QTextCursor tc = textCursor();
		 int extra = completion.length() - completer.completionPrefix().length();
		 tc.movePosition(QTextCursor::Left);
		 tc.movePosition(QTextCursor::EndOfWord);
		 tc.insertText(completion.right(extra));
		 setTextCursor(tc);
	 }

	 /********************************
	      FUNCTIONS LIST
	 *********************************/

	 TCFunctionsListView::TCFunctionsListView(MainWindow* mainWindow, const QString& cDir, CodeEditor * textEdit)
	 {
		 console = mainWindow->console();
		 if (!cDir.isEmpty()) readCHeaders(cDir);
		 sortItems(0,Qt::AscendingOrder);
		 setSelectionMode(QAbstractItemView::SingleSelection);
		 setEditTriggers(QAbstractItemView::NoEditTriggers);
		 setAlternatingRowColors ( true );
		 setHeaderHidden ( true );
		 if (textEdit)
			 connect(this,SIGNAL(insertText(const QString&)),textEdit,SLOT(insertPlainText(const QString&)));
	 }

	 void TCFunctionsListView::readCHeaders(const QString& dirname)
	 {
		 QDir dir(dirname);
		 dir.setFilter(QDir::Files);
		 dir.setSorting(QDir::Name);

		 QFileInfoList list = dir.entryInfoList();
		 //QApplication::setOverrideCursor(QCursor(Qt::WaitCursor));

		 QHash<QString,QTreeWidgetItem*> tree;
		 
		 QStringList visitedFunctions;

		 for (int i = 0; i < list.size(); ++i)
		 {
			QFileInfo fileInfo = list.at(i);
			QFile file(fileInfo.absoluteFilePath());
			if (!fileInfo.baseName().startsWith(tr("TC_")) || fileInfo.completeSuffix().toLower() != tr("h") || !file.open(QFile::ReadOnly)) continue;
			
			QRegExp regexComments(tr("brief\\s*([^\\n\\r]+)"));
			QRegExp regexGroup(tr("ingroup\\s*([^\\n\\r]+)"));
			QRegExp regexFunction(tr("\\s*(\\S+)\\s*(tc_[A-Za-z0-9]+)\\s*(\\([^\\)]*\\))"));
			QRegExp charstar(tr("char\\s*\\*"));
			QRegExp voidstar(tr("void\\s*\\*"));
			QTreeWidgetItem * currentItem = 0;
			QString currentComment;

			 while (!file.atEnd())
			 {
				 QString line(file.readLine());
				 line.replace(charstar,tr("string"));
				 line.replace(voidstar,tr("item"));
				 
				 regexGroup.indexIn(line);
				 regexComments.indexIn(line);
				 regexFunction.indexIn(line);
				 if (regexGroup.numCaptures() > 0 && regexGroup.capturedTexts().at(1).length() > 1)
				 {
					QString s = regexGroup.capturedTexts().at(1); //category
					if (s.contains(QRegExp("\\s*init\\s*")))
					{
						currentItem = 0;
						continue;
					}
					if (tree.contains(s))
					{
						currentItem = tree[s];
					}
					else
					{
						currentItem = new QTreeWidgetItem(QStringList() << s);
						tree[s] = currentItem;
						addTopLevelItem(currentItem);
					}
				 }

				 if (regexComments.numCaptures() > 0 && regexComments.capturedTexts().at(1).length() > 1)
				 {
					QString s = regexComments.capturedTexts().at(1); //comment
					currentComment = s;
				 }

				 if (currentItem && regexFunction.numCaptures() > 0 && regexFunction.capturedTexts().at(1).length() > 0)
				 {
					QString name, str;
					name = regexFunction.capturedTexts().at(2);
					if (visitedFunctions.contains(name)) continue;
					visitedFunctions << name.trimmed();
					if (regexFunction.capturedTexts().at(1) == tr("void"))
						str = regexFunction.capturedTexts().at(2) + regexFunction.capturedTexts().at(3);
					else
						str = regexFunction.capturedTexts().at(1)
								+ tr(" var = ")
								+ regexFunction.capturedTexts().at(2)
								+ regexFunction.capturedTexts().at(3);

					QTreeWidgetItem * childItem = new QTreeWidgetItem(QStringList() << name << str);
					currentItem->addChild(childItem);
					childItem->setToolTip(1,currentComment);
					childItem->setWhatsThis(1,currentComment);
				 }
			 }
			file.close();
		 }
		 
		 if (console && console->editor() && !console->editor()->completer())
		 {
			QCompleter * completer = new QCompleter(visitedFunctions,this);			
			//completer->setModel(new QStringListModel(visitedFunctions, completer));
			//completer->setModelSorting(QCompleter::CaseInsensitivelySortedModel);
			//completer->setWrapAround(false);
			completer->setCaseSensitivity(Qt::CaseSensitive);
			
			console->editor()->setCompleter(completer);
		 }
	 }

	 void TCFunctionsListView::mouseDoubleClickEvent ( QMouseEvent *  )
	 {
		 QTreeWidgetItem * item = this->currentItem();
		 if (item && indexOfTopLevelItem(item) == -1)
		 {
			emit insertText(item->text(1));
		 }
	 }

	 void TCFunctionsListView::keyPressEvent ( QKeyEvent * event )
	 {
		 if (event &&
			 (event->key() == Qt::Key_Enter ||
			 event->key() == Qt::Key_Return ||
			  event->key() == Qt::Key_Space ||
			  event->key() == Qt::Key_Tab))
		 {
			QTreeWidgetItem * item = this->currentItem();
			 if (item && indexOfTopLevelItem(item) == -1)
			 {
				emit insertText(item->text(1));
			 }
		 }
	 }

	 void CodingWindow::setVisible ( bool visible )
	 {
		activateWindow();
		if (isMinimized())
			showNormal();
		Tool::setVisible(visible);
	 }
}