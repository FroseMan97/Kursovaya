package com.company;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class products {
    products(){
        show();
    }

    /**
     * Окно приложения
     */
    private JFrame window;
    /**
     * Модель таблицы
     */
    private DefaultTableModel model;
    /**
     * Добавить
     */
    private JButton add;
    /**
     * Удалить
     */
    private JButton delete;
    /**
     * Изменить
     */
    private JButton edit;
    /**
     * Сохранить изменения
     */
    private JButton save;
    /**
     * Открыть файл
     */
    private JButton folder;
    /**
     * Печать
     */
    private JButton print;
    /**
     * Панель инструментов
     */
    private JToolBar toolBar;
    /**
     * Таблица
     */
    protected JTable dataEmploy;
    /**
     * Выпадающий список
     */
    private JComboBox comboBox;
    /**
     * Поле поискового запроса
     */
    private JTextField textSearch;
    /**
     * Поиск
     */
    private JButton search;
    /**
     * Скролл
     */
    private JScrollPane scroll;

    public void show(){
        window = new JFrame("Список продуктов");
        window.setSize(1000,500);
        window.setLocation(310,130);
        window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        // Создание кнопок и прикрепление иконок
        add = new JButton("Добавить", new ImageIcon("./img/add.png"));
        delete = new JButton("Удалить", new ImageIcon("./img/delete.png"));
        edit = new JButton("Редактировать", new ImageIcon("./img/edit.png"));
        save = new JButton("Сохранить", new ImageIcon("./img/save.png"));
        folder = new JButton("Загрузить", new ImageIcon("./img/folder.png"));
        print = new JButton("Печать",new ImageIcon("./img/print.png"));

        // Настройка подсказок
        add.setToolTipText("Добавить информацию о товаре");
        delete.setToolTipText("Удалить информацию о товаре");
        edit.setToolTipText("Изменить информацию о товаре");
        save.setToolTipText("Сохранить информацию о товарах");
        folder.setToolTipText("Загрузить информацию о товарах");
        print.setToolTipText("Распечатать информацию о товарах");
        // Добавление кнопок на панель инструментов
        toolBar = new JToolBar("Панель инструментов");
        toolBar.add(add);
        toolBar.add(delete);
        toolBar.add(edit);
        toolBar.add(save);
        toolBar.add(folder);
        toolBar.add(print);
        // Размещение панели инструментов
        window.setLayout(new BorderLayout());
        window.add(toolBar,BorderLayout.NORTH);
        // Создание таблицы с данными
        String[] columns = {"Название", "Страна производства", "Вес", "Цена"};

        // Настройка таблицы
        model = new DefaultTableModel(columns,0){
            public boolean isCellEditable(int rowIndex, int columnIndex)
            {
                return false;
            }};
        this.dataEmploy = new JTable(model);
        dataEmploy.setFont(new Font(Font.SERIF,Font.BOLD,14));
        dataEmploy.setIntercellSpacing(new Dimension(0,1));
        dataEmploy.setRowHeight(dataEmploy.getRowHeight()+10);
        dataEmploy.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

        dataEmploy.setDefaultRenderer(dataEmploy.getColumnClass(1), new DefaultTableCellRenderer(){
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                super.setHorizontalAlignment(SwingConstants.CENTER);
                super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                return this;
            }

        });

        scroll = new JScrollPane(this.dataEmploy);

        // Размещение таблицы с данными
        window.add(scroll,BorderLayout.CENTER);
        // Подготовка компонентов поиска
        comboBox = new JComboBox(new String[]{"Фамилия", "Имя", "Должность"});
        textSearch = new JTextField();
        textSearch.setColumns(20);
        search = new JButton("Поиск");
        window.getRootPane().setDefaultButton(search);
// remove the binding for pressed
        window.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
                .put(KeyStroke.getKeyStroke("ENTER"), "none");
// retarget the binding for released
        window.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
                .put(KeyStroke.getKeyStroke("released ENTER"), "press");
        // Добавление компонентов на панель
        JPanel searchPanel = new JPanel();
        searchPanel.add(comboBox);
        searchPanel.add(textSearch);
        searchPanel.add(search);

        // Размещение панели поиска внизу окна
        window.add(searchPanel,BorderLayout.SOUTH);
        window.setVisible(true);
    }

}
