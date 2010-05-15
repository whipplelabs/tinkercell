#include <QVBoxLayout>
#include "GraphicsScene.h"
#include "TextEditor.h"
#include "NetworkHandle.h"
#include "MainWindow.h"
#include "GraphicsView.h"
#include "NetworkWindow.h"

namespace Tinkercell
{
	NetworkWindow::NetworkWindow(NetworkHandle * network, GraphicsScene * scene)
		: QWidget(network->mainWindow), network(network), scene(scene), editor(0)
	{
		if (!network)
			return;
		
		if (scene)
		{
			scene->networkWindow = this;
			scene->network = network;
			
			GraphicsView * view = new GraphicsView(this);		
			setCentralWidget(view);
			setAttribute(Qt::WA_DeleteOnClose);
		}

		if (network->networkWindows.size() == 0 && network->mainWindow)
		{
			connect(this,SIGNAL(windowClosing(NetworkHandle *, bool*)),
					network->mainWindow,SIGNAL(windowClosing(NetworkHandle *, bool*)));
			connect(this,SIGNAL(windowClosed(NetworkHandle *)),
					network->mainWindow,SIGNAL(windowClosed(NetworkHandle *)));
		}
		
		if (!network->networkWindows.contains(this))
			network->networkWindows += this;

		MainWindow * main = network->mainWindow;

		if (main)
		{
			scene->contextItemsMenu = &(main->contextItemsMenu);
			
			scene->contextScreenMenu = &(main->contextScreenMenu);
		
			connect(scene,SIGNAL(itemsSelected(GraphicsScene*,const QList<QGraphicsItem*>&, QPointF, Qt::KeyboardModifiers)),
				main, SIGNAL(itemsSelected(GraphicsScene*,const QList<QGraphicsItem*>&, QPointF, Qt::KeyboardModifiers)));

			connect(scene,SIGNAL(mousePressed(GraphicsScene*,QPointF, Qt::MouseButton, Qt::KeyboardModifiers)),
				main ,SIGNAL(mousePressed(GraphicsScene*,QPointF, Qt::MouseButton, Qt::KeyboardModifiers)));

			connect(scene,SIGNAL(mouseReleased(GraphicsScene*,QPointF, Qt::MouseButton, Qt::KeyboardModifiers)),
				main ,SIGNAL(mouseReleased(GraphicsScene*,QPointF, Qt::MouseButton, Qt::KeyboardModifiers)));

			connect(scene,SIGNAL(mouseDoubleClicked (GraphicsScene*, QPointF, QGraphicsItem *, Qt::MouseButton, Qt::KeyboardModifiers)),
				main ,SIGNAL(mouseDoubleClicked (GraphicsScene*, QPointF, QGraphicsItem *, Qt::MouseButton, Qt::KeyboardModifiers)));

			connect(scene,SIGNAL(mouseDragged(GraphicsScene*,QPointF, QPointF, Qt::MouseButton, Qt::KeyboardModifiers)),
				main ,SIGNAL(mouseDragged(GraphicsScene*,QPointF, QPointF, Qt::MouseButton, Qt::KeyboardModifiers)));

			connect(scene,SIGNAL(itemsMoved(GraphicsScene*,const QList<QGraphicsItem*>&, const QList<QPointF>& , Qt::KeyboardModifiers)),
				main ,SIGNAL(itemsMoved(GraphicsScene*,const QList<QGraphicsItem*>&, const QList<QPointF>& , Qt::KeyboardModifiers)));

			connect(scene,SIGNAL(mouseMoved(GraphicsScene*,QGraphicsItem*, QPointF, Qt::MouseButton, Qt::KeyboardModifiers,QList<QGraphicsItem*>&)),
				main ,SIGNAL(mouseMoved(GraphicsScene*,QGraphicsItem*, QPointF, Qt::MouseButton, Qt::KeyboardModifiers,QList<QGraphicsItem*>&)));

			connect(scene,SIGNAL(sceneRightClick(GraphicsScene*,QGraphicsItem*, QPointF, Qt::KeyboardModifiers)),
				main ,SIGNAL(sceneRightClick(GraphicsScene*,QGraphicsItem*, QPointF, Qt::KeyboardModifiers)));

			connect(scene,SIGNAL(keyPressed(GraphicsScene*,QKeyEvent *)),
				main ,SIGNAL(keyPressed(GraphicsScene*,QKeyEvent *)));

			connect(scene,SIGNAL(keyReleased(GraphicsScene*,QKeyEvent *)),
				main ,SIGNAL(keyReleased(GraphicsScene*,QKeyEvent *)));

			connect(scene,SIGNAL(itemsInserted(GraphicsScene *, const QList<QGraphicsItem*>&, const QList<ItemHandle*>&)),
				main ,SIGNAL(itemsInserted(GraphicsScene *, const QList<QGraphicsItem*>&, const QList<ItemHandle*>&)));

			connect(scene,SIGNAL(itemsAboutToBeInserted(GraphicsScene *, QList<QGraphicsItem*>&, QList<ItemHandle*>&)),
				main ,SIGNAL(itemsAboutToBeInserted(GraphicsScene *, QList<QGraphicsItem*>&, QList<ItemHandle*>&)));

			connect(scene,SIGNAL(itemsAboutToBeRemoved(GraphicsScene *, QList<QGraphicsItem*>&, QList<ItemHandle*>&)),
				main ,SIGNAL(itemsAboutToBeRemoved(GraphicsScene *, QList<QGraphicsItem*>&, QList<ItemHandle*>&)));

			connect(scene,SIGNAL(itemsRemoved(GraphicsScene *, const QList<QGraphicsItem*>&, const QList<ItemHandle*>&)),
				main ,SIGNAL(itemsRemoved(GraphicsScene *, const QList<QGraphicsItem*>&, const QList<ItemHandle*>&)));

			connect(scene,SIGNAL(colorChanged(GraphicsScene*,const QList<QGraphicsItem*>&)),
				main ,SIGNAL(colorChanged(GraphicsScene*,const QList<QGraphicsItem*>&)));

			connect(scene,SIGNAL(parentItemChanged(GraphicsScene*,const QList<QGraphicsItem*>&,const QList<QGraphicsItem*>&)),
				main ,SIGNAL(parentItemChanged(GraphicsScene*,const QList<QGraphicsItem*>&,const QList<QGraphicsItem*>&)));

			connect(network,SIGNAL(handlesChanged(NetworkHandle*, const QList<QGraphicsItem*>&, const QList<ItemHandle*>&)),
				main ,SIGNAL(handlesChanged(NetworkHandle*, const QList<QGraphicsItem*>&, const QList<ItemHandle*>&)));

			connect(scene,SIGNAL(escapeSignal(const QWidget*)),
				main ,SIGNAL(escapeSignal(const QWidget*)));

			connect(scene,SIGNAL(filesDropped(const QList<QFileInfo>&)),
				main,SLOT(dragAndDropFiles(const QList<QFileInfo>&)));

			connect(scene,SIGNAL(copyItems(GraphicsScene*, QList<QGraphicsItem*>& , QList<ItemHandle*>&)),
				main, SIGNAL(copyItems(GraphicsScene*, QList<QGraphicsItem*>& , QList<ItemHandle*>&)));

			setWindowTitle(tr("network ") + QString::number(1 + main->allNetworks.size()));
			
			main->setCurrentWindow(this);
		}
		
		setFocusPolicy(Qt::StrongFocus);
		setWindowIcon(QIcon(tr(":/images/newscene.png")));
	}
	
	NetworkWindow::NetworkWindow(NetworkHandle * network, TextEditor * editor)
		: QWidget(network->mainWindow), network(network), scene(0), editor(editor)
	{
		if (!network) return;
		
		if (editor)
		{
			editor->networkWindow = this;
			editor->network = network;
			setCentralWidget(editor);
			setAttribute(Qt::WA_DeleteOnClose);
		}

		MainWindow * main = network->mainWindow;

		if (network->networkWindows.size() == 0 && network->mainWindow)
		{
			connect(this,SIGNAL(windowClosing(NetworkHandle *, bool*)),
					network->mainWindow,SIGNAL(windowClosing(NetworkHandle *, bool*)));
			connect(this,SIGNAL(windowClosed(NetworkHandle *)),
					network->mainWindow,SIGNAL(windowClosed(NetworkHandle *)));
		}
		
		if (!network->networkWindows.contains(this))
			network->networkWindows += this;
		
		if (main)
		{
			editor->contextEditorMenu = &(main->contextEditorMenu);

			editor->contextSelectionMenu = &(main->contextSelectionMenu);
		
			connect(editor,SIGNAL(itemsInserted(NetworkHandle *, const QList<ItemHandle*>&)),
				main,SIGNAL(itemsInserted(NetworkHandle *, const QList<ItemHandle*>&)));

			connect(editor,SIGNAL(itemsRemoved(NetworkHandle * , const QList<ItemHandle*>& )),
				main,SIGNAL(itemsRemoved(NetworkHandle * , const QList<ItemHandle*>&)));

			connect(editor,SIGNAL(textChanged(TextEditor *, const QString&, const QString&, const QString&)),
				main,SIGNAL(textChanged(TextEditor *, const QString&, const QString&, const QString&)));

			connect(editor,SIGNAL(lineChanged(TextEditor *, int, const QString&)),
				main,SIGNAL(lineChanged(TextEditor *, int, const QString&)));

			setWindowTitle(tr("network ") + QString::number(1 + main->allNetworks.size()));

			main->setCurrentWindow(this);
		}
		
		setFocusPolicy(Qt::StrongFocus);
		setWindowIcon(QIcon(tr(":/images/newtext.png")));
	}
	
	void NetworkWindow::closeEvent(QCloseEvent * event)
	{
		bool b = true;
		
		if (network)
			emit windowClosing(network,&b);
		
		if (b)
		{
			if (network)
			{
				emit windowClosed(network);
				network->networkWindows.removeAll(this);

				if (network->mainWindow && network->mainWindow->currentNetworkWindow == this)
					network->mainWindow->currentNetworkWindow = 0;

				network->close();
			}

			event->accept();
		}
	}
	
	void NetworkWindow::focusInEvent ( QFocusEvent * )
	{
		if (network && network->mainWindow && network->mainWindow->currentNetworkWindow != this)
			network->mainWindow->setCurrentWindow(this);
	}

	void NetworkWindow::resizeEvent (QResizeEvent * event)
	{
		if (network && network->mainWindow && windowState() == Qt::WindowMinimized)
		{
			setWindowState(Qt::WindowNoState);
			popIn();
		}
		else
			QWidget::resizeEvent(event);
	}

	void NetworkWindow::setAsCurrentWindow()
	{
		if (network && network->mainWindow && network->mainWindow->currentNetworkWindow != this)
			network->mainWindow->setCurrentWindow(this);
	}

	void NetworkWindow::popOut()
	{
		if (network && network->mainWindow)
			network->mainWindow->popOut(this);
	}

	void NetworkWindow::popIn()
	{
		if (network && network->mainWindow)
			network->mainWindow->popIn(this);
	}

	void NetworkWindow::changeEvent ( QEvent * event )
	{
		if (network && network->mainWindow && windowState() == Qt::WindowMinimized)
		{
			setWindowState(Qt::WindowNoState);
			popIn();
		}
		else
			QWidget::changeEvent(event);
	}

	/*bool NetworkHandle::winEvent ( MSG * m, long * result )
	{
		if (mainWindow && m->message == WM_SIZE && m->wParam == SIZE_MINIMIZED)
		{
			popIn();
		}
		return QWidget::winEvent(m,result);
	}*/
	
}


