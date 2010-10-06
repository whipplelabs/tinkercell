#include <QApplication>
#include "MultiCell.h"
#include "CellTypeSelector.h"

int main(int argc, char *argv[])
{
	QApplication app(argc, argv);
    
    Tinkercell::MainWindow::PROJECTWEBSITE = QObject::tr("www.tinkercell.com");
    Tinkercell::MainWindow::ORGANIZATIONNAME = QObject::tr("MultiCell Simulator");
    Tinkercell::MainWindow::PROJECTNAME = QObject::tr("MultiCell Simulator");

	QString appDir = QCoreApplication::applicationDirPath();
	
	Tinkercell::GraphicsScene::USE_DEFAULT_BEHAVIOR = false;
	Tinkercell::GraphicsScene::GRID = 100; //grid mode	
	Tinkercell::GraphicsScene::SelectionRectangleBrush = QBrush(QColor(5,250,5,80));
    
    Tinkercell::MainWindow mainWindow(true,false);//,false,false);
	
	mainWindow.setWindowTitle(QString("MultiCell Simulator"));
    mainWindow.statusBar()->showMessage(QString("Welcome to MultiCell Simulator"));

	Tool * tool = new Multicell::MulticellInterface;
	mainWindow.addTool(tool);
	
	mainWindow.newScene();
	
    mainWindow.show();

    int output = app.exec();

    return output;
}
