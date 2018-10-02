package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Абстрактный класс Диалогового окна Добавления/Редактирования данных сотрудников
 */
public abstract class AboutDialog extends JDialog {
    protected JTextField familia;
    protected JTextField name;
    protected JTextField rang;
    private JButton ok = new JButton("Принять");
    private JButton cancel = new JButton("Закрыть");
    private JLabel famLab = new JLabel("Фамилия");
    private JLabel namLab = new JLabel("Имя");
    private JLabel ranLab = new JLabel("Должность");

    /**
     * Выполнение манипуляций с данными
     * @param parent Объект класса приложения
     */
    public abstract void  progress(employs parent);

    /**
     * Инициализация
     * @param parent Объект класса приложения
     */
    public abstract void init(employs parent);

    /**
     * Основной конструктор
     * @param owner JFrame приложения
     * @param parent Объект класса приложения
     * @param title Title окна
     */
    public AboutDialog(JFrame owner, employs parent, String title) {
        super(owner, title, true);
        init(parent);
        ok.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                progress(parent);
            }
        });
        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        JPanel mainp = new JPanel();

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2, 2, 2));

        panel.setSize(300, 100);

        // adds to the GridLayout
        panel.add(famLab);
        panel.add(familia);
        panel.add(namLab);
        panel.add(name);
        panel.add(ranLab);
        panel.add(rang);
        mainp.add(panel);
        add(BorderLayout.CENTER, mainp);
        JPanel but = new JPanel();
        but.add(ok);
        but.add(cancel);
        add(BorderLayout.SOUTH, but);
        setLocation(500, 250);
        setSize(500, 155);
        this.getRootPane().setDefaultButton(ok);
// remove the binding for pressed
        this.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
                .put(KeyStroke.getKeyStroke("ENTER"), "none");
// retarget the binding for released
        this.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
                .put(KeyStroke.getKeyStroke("released ENTER"), "press");
    }
}