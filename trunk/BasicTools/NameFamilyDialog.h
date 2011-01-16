/****************************************************************************

Copyright (c) 2008 Deepak Chandran
Contact: Deepak Chandran (dchandran1@gmail.com)
See COPYRIGHT.TXT

This tool displays a dialog with the name and family information of selected items.
An associated GraphicsTool is also defined.

****************************************************************************/

#ifndef TINKERCELL_NAMEFAMILYINFORMATIONTOOL_H
#define TINKERCELL_NAMEFAMILYINFORMATIONTOOL_H

#include <stdlib.h>
#include <QtGui>
#include <QIcon>
#include <QTableWidget>
#include <QPlainTextEdit>
#include <QTextCursor>
#include <QTextCharFormat>
#include <QDialog>

#include "NodeGraphicsItem.h"
#include "ItemHandle.h"
#include "Tool.h"
#include "NodesTree.h"
#include "NetworkHandle.h"

namespace Tinkercell
{
	class NameFamilyDialog_FtoS : public QObject
	{
		Q_OBJECT;
	signals:
		void getAnnotation(QSemaphore* sem, QStringList* list, ItemHandle* item);
		void setAnnotation(QSemaphore* sem, ItemHandle* item, const QStringList& list);
	public slots:
		tc_strings getAnnotation(long);
		void setAnnotation(long,tc_strings);
	};

	class TINKERCELLEXPORT NameFamilyDialog : public Tool
	{
		Q_OBJECT;

	public:
		NameFamilyDialog();
		bool setMainWindow(MainWindow * main);
	
	signals:
		void itemsAboutToBeInserted(GraphicsScene * scene, QList<QGraphicsItem*>& items, QList<ItemHandle*>& handles, QList<QUndoCommand*>&);
		void itemsInserted(GraphicsScene * scene, const QList<QGraphicsItem*>& items, const QList<ItemHandle*>& handles);
		void nameChanged();

	public slots:
		void select(int i=0);
		void deselect(int i=0);
		void showDialog(ItemHandle*);
		void closeDialog();
		void itemsInsertedSlot(NetworkHandle * , const QList<ItemHandle*>& handles);
		void dialogFinished();
		void setupFunctionPointers( QLibrary * );

	protected:
		QDialog * dialog;
		QPlainTextEdit * textEdit;
		ItemHandle* selectedItem;
		NodeGraphicsItem idcard;
		
		void makeDialog(QWidget*);

	private slots:
		/*!
		* \brief get the annotation for an item. This function is designed to be used with the C API framework
		* \param QSemaphore* semaphore
		* \param QStringList* output
		* \param ItemHandle* item
		* \return void
		*/
		void getAnnotation(QSemaphore* sem, QStringList* list, ItemHandle* item);
		/*!
		* \brief set the annotation for an item. This function is designed to be used with the C API framework
		* \param QSemaphore* semaphore
		* \param ItemHandle* item
		* \param QStringList output
		* \return void
		*/
		void setAnnotation(QSemaphore* sem, ItemHandle* item, const QStringList& list);
	private:
		void connectTCFunctions();
		/*! \brief node of the C API framework*/
		static tc_strings _getAnnotation(long);
		/*! \brief node of the C API framework*/
		static void _setAnnotation(long,tc_strings);
		/*! \brief node of the C API framework*/
		static NameFamilyDialog_FtoS fToS;
	};
}

#endif