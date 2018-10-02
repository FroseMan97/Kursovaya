package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Dialog extends JFrame {

    public Dialog(final employs parent, String nameOfWIndow) {
        super(nameOfWIndow);

        setBounds(250, 150, 250, 100);


        JButton btClick = new JButton("ОК");
        getContentPane().add(btClick);
        setVisible(true);
        btClick.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                //по клику на родительском изменится текст метки
                parent.dataEmploy.setValueAt("Rabotaet",0,0);
                parent.makeXml();
                dispose();

            }
        });
    }
}