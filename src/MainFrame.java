import java.awt.BorderLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
@SuppressWarnings("serial")
public class MainFrame extends JFrame {
    // Начальные размеры окна приложения
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;
// Объект диалогового окна для выбора файлов

    private JFileChooser fileChooser = null;
    // Пункты меню
    private JCheckBoxMenuItem showAxisMenuItem;
    private JCheckBoxMenuItem showMarkersMenuItem;
    // Компонент-отображатель графика

    // Флаг, указывающий на загруженность данных графика
    private boolean fileLoaded = false;
    public MainFrame() {
// Вызов конструктора предка Frame
        super("Построение графиков функций на основе заранее подготовленных файлов");

// Установка размеров окна
        setSize(WIDTH, HEIGHT);
        Toolkit kit = Toolkit.getDefaultToolkit();
// Отцентрировать окно приложения на экране
        setLocation((kit.getScreenSize().width - WIDTH)/2,

                (kit.getScreenSize().height - HEIGHT)/2);
// Развѐртывание окна на весь экран
        setExtendedState(MAXIMIZED_BOTH);
// Создать и установить полосу меню
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
// Добавить пункт меню "Файл"
        JMenu fileMenu = new JMenu("Файл");
        menuBar.add(fileMenu);
// Создать действие по открытию файла

// Добавить соответствующий элемент меню

        // Создать пункт меню "График"
        JMenu graphicsMenu = new JMenu("График");
        menuBar.add(graphicsMenu);
// Создать действие для реакции на активацию элемента "Показывать оси координат"



// Добавить соответствующий элемент в меню
        graphicsMenu.add(showAxisMenuItem);

// Элемент по умолчанию включен (отмечен флажком)
        showAxisMenuItem.setSelected(true);
// Повторить действия для элемента "Показывать маркеры точек"


        graphicsMenu.add(showMarkersMenuItem);
// Элемент по умолчанию включен (отмечен флажком)
        showMarkersMenuItem.setSelected(true);
// Зарегистрировать обработчик событий, связанных с меню "График"
        graphicsMenu.addMenuListener(new GraphicsMenuListener());
// Установить GraphicsDisplay в цент граничной компоновки

    }
    // Считывание данных графика из существующего файла

    public static void main(String[] args) {
// Создать и показать экземпляр главного окна приложения
        MainFrame frame = new MainFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    // Класс-слушатель событий, связанных с отображением меню
    private class GraphicsMenuListener implements MenuListener {
        // Обработчик, вызываемый перед показом меню
        public void menuSelected(MenuEvent e) {
// Доступность или недоступность элементов меню "График" определяется загруженностью данных

            showAxisMenuItem.setEnabled(fileLoaded);
            showMarkersMenuItem.setEnabled(fileLoaded);
        }
        // Обработчик, вызываемый после того, как меню исчезло с экрана
        public void menuDeselected(MenuEvent e) {
        }
// Обработчик, вызываемый в случае отмены выбора пункта меню (очень редкая ситуация)

        public void menuCanceled(MenuEvent e) {
        }
    }
} 