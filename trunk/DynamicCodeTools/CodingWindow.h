/****************************************************************************
 Copyright (c) 2008 Deepak Chandran
 Contact: Deepak Chandran (dchandran1@gmail.com)
 see COPYRIGHT.TXT

 Provides a text window where C code can be written and run dynamically

****************************************************************************/

#ifndef TINKERCELL_CSCRIPT_H
#define TINKERCELL_CSCRIPT_H

#include <QMainWindow>
#include <QTextEdit>
#include <QSyntaxHighlighter>
#include <QHash>
#include <QTextCharFormat>
#include <QDialog>
#include <QCompleter>
#include <QListWidget>
#include <QTabWidget>
#include <QTreeWidget>
#include <QThread>
#include <QToolBar>
#include <QTimeLine>
#include <QActionGroup>
#include <QLineEdit>
#include <QHash>
#include "Tool.h"
#include "CThread.h"
#include "SyntaxHighlighter.h"

namespace Tinkercell
{
	//text editor with zoom and ctrl+A
	class CodeEditor : public QTextEdit
	{
		Q_OBJECT
	public:
		QCompleter completer;
		QHash<QString,QString> defaultSavedFilename;
	protected:
		virtual void wheelEvent ( QWheelEvent * wheelEvent );
		virtual void keyPressEvent ( QKeyEvent * keyEvent );
	public slots:
		void open(const QString&);
		void save(const QString&);
		void saveAs(const QString&);
		void insertCompletion(const QString& completion);
	};

	class TCFunctionsListView : public QTreeWidget
	{
		Q_OBJECT
	public:
		TCFunctionsListView(const QString&, const QString&, QTextEdit * textEdit);
	signals:
		void insertText(const QString&);
	protected:
		virtual void readCHeaders(const QString& dirName);
		virtual void readPythonHeader(const QString& fileName);
		virtual void mouseDoubleClickEvent ( QMouseEvent * event );
		virtual void keyPressEvent ( QKeyEvent * event );
	};

	class CodingWindow : public Tool
	{
	    Q_OBJECT

	public:
		CodingWindow();
		bool setMainWindow(MainWindow*);

	signals:
		void runPy(const QString&);
		void stopPy();
		void reloadLibraryList(const QString&, bool);

	public slots:
		void run();
		void about();
		void dialogFinished();
		virtual QSize sizeHint() const;
		void newDoc();
		void open();
		void save();
		void undo();
		void redo();
		void selectAll();
		virtual void setVisible(bool);

	protected slots:
		void convertCodeToButton();

	protected:

		void setupEditor();
		void setupMenu();
		void setupDialog();
		void runC(const QString&);

		QTimeLine timer;
		QMainWindow * window;
		QTabWidget * tabWidget;
		CodeEditor *editorC;
		CodeEditor *editorPy;
		QToolBar * toolBar;

		CodeEditor *editorR;
		QLineEdit *commandCEdit, *commandPyEdit, *fileNameEdit;
		CandPythonSyntaxHighlighter *highlighterC;
		CandPythonSyntaxHighlighter *highlighterPy;

		QString commandC, commandPy, fileName;
		QDialog commandDialog;

	};

}

#endif
