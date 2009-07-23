/****************************************************************************

 Copyright (c) 2008 Deepak Chandran
 Contact: Deepak Chandran (dchandran1@gmail.com)
 See COPYRIGHT.TXT
 
 Class for drawing text on a GraphicsScene. The text can be associated with 
 a handle
 
****************************************************************************/

#include <QPainter>
#include "TextGraphicsItem.h"

namespace Tinkercell
{
	/*! Constructor: sets text edit interaction */
	TextGraphicsItem::TextGraphicsItem(const QString& text, QGraphicsItem* parent) : 
		QGraphicsTextItem(text,parent), relativePosition(QPair<QGraphicsItem*,QPointF>(0,QPointF()))
	{
		setTextInteractionFlags(Qt::TextEditorInteraction);
		setFlag(QGraphicsItem::ItemIsMovable);
		//setFlag(QGraphicsItem::ItemIsSelectable);
		itemHandle = 0;
		boundingRectItem = new QGraphicsRectItem(this);
		boundingRectItem->setPen(QPen(QColor(100,100,100),2));
		boundingRectItem->setBrush(Qt::NoBrush);
		boundingRectItem->setVisible(false);
	}
	/*! Constructor: sets text edit interaction */
	TextGraphicsItem::TextGraphicsItem(QGraphicsItem* parent) : 
		QGraphicsTextItem(parent), relativePosition(QPair<QGraphicsItem*,QPointF>(0,QPointF()))
	{
		setTextInteractionFlags(Qt::TextEditorInteraction);
		setFlag(QGraphicsItem::ItemIsMovable);
		//setFlag(QGraphicsItem::ItemIsSelectable);
		itemHandle = 0;
		boundingRectItem = new QGraphicsRectItem(this);
		boundingRectItem->setPen(QPen(QColor(100,100,100),2));
		boundingRectItem->setBrush(Qt::NoBrush);
		boundingRectItem->setVisible(false);
	}
	/*! Constructor: sets text edit interaction and name of handle */
	TextGraphicsItem::TextGraphicsItem(ItemHandle * handle, QGraphicsItem* parent) : 
		QGraphicsTextItem(parent), relativePosition(QPair<QGraphicsItem*,QPointF>(0,QPointF()))
	{
		if (handle) setPlainText(handle->name);
		itemHandle = 0;
		setHandle(this,handle);
		setTextInteractionFlags(Qt::TextEditorInteraction);
		setFlag(QGraphicsItem::ItemIsMovable);
		//setFlag(QGraphicsItem::ItemIsSelectable);
		boundingRectItem = new QGraphicsRectItem(this);
		boundingRectItem->setPen(QPen(QColor(100,100,100),2));
		boundingRectItem->setBrush(Qt::NoBrush);
		boundingRectItem->setVisible(false);
	}
	/*! Copy Constructor */
	TextGraphicsItem::TextGraphicsItem(const TextGraphicsItem& copy) : 
		QGraphicsTextItem(), relativePosition(QPair<QGraphicsItem*,QPointF>(0,QPointF()))
	{
		setPos(copy.scenePos());
		setTransform(copy.transform());
		setDefaultTextColor(copy.defaultTextColor());
		//setDocument(copy.document());
		setFont(copy.font());
		setHtml (copy.toHtml());
		setTextWidth(copy.textWidth());
		setTextCursor(copy.textCursor());
		setTextInteractionFlags ( copy.textInteractionFlags() );
		setFlag(QGraphicsItem::ItemIsMovable);
		//setFlag(QGraphicsItem::ItemIsSelectable);
		setPlainText(copy.toPlainText());
		itemHandle = copy.itemHandle;

		if (itemHandle)
			setHandle(this,itemHandle);
			
		boundingRectItem = new QGraphicsRectItem(this);
		boundingRectItem->setPen(QPen(QColor(100,100,100),2));
		boundingRectItem->setBrush(Qt::NoBrush);
		boundingRectItem->setVisible(false);
	}
	TextGraphicsItem* TextGraphicsItem::clone()
	{
		return new TextGraphicsItem(*this);
	}
	TextGraphicsItem::~TextGraphicsItem()
	{
		if (!itemHandle) return;

		if (itemHandle->graphicsItems.isEmpty())
			delete itemHandle;
		else
			itemHandle->graphicsItems.removeAll(this);
		itemHandle = 0;
	}

	void TextGraphicsItem::paint(QPainter * painter, const QStyleOptionGraphicsItem * option, QWidget * widget)
	{
		if (option->levelOfDetail < 0.15) return;
		QGraphicsTextItem::paint(painter,option,widget);
	}
	
	void TextGraphicsItem::showBorder(bool showBorder)
	{
		boundingRectItem->setRect(this->boundingRect());
		boundingRectItem->setVisible(showBorder);
		update();
	}
/*
	QVariant TextGraphicsItem::itemChange(GraphicsItemChange change,
						  const QVariant &value)
	 {
		 //if (change == QGraphicsItem::ItemSelectedHasChanged)
			//emit selectedChange(this);
		 return value;
	 }

	 void TextGraphicsItem::focusOutEvent(QFocusEvent *event)
	 {
		 setTextInteractionFlags(Qt::NoTextInteraction);
//		 emit lostFocus(this);
		 QGraphicsTextItem::focusOutEvent(event);
	 }

	 void TextGraphicsItem::mouseDoubleClickEvent(QGraphicsSceneMouseEvent *event)
	 {
		if (textInteractionFlags() == Qt::NoTextInteraction)
			setTextInteractionFlags(Qt::TextEditorInteraction);
		QGraphicsTextItem::mouseDoubleClickEvent(event);
	 }*/
}

