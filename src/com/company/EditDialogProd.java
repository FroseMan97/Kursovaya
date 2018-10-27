package com.company;

import javax.swing.*;

public class EditDialogProd extends DialogProd {

    @Override
    public void progress(products parent) {
        setVisible(false);
        int row = parent.dataProducts.getSelectedRow();
        parent.dataProducts.setValueAt(name.getText(), row, 0);
        parent.dataProducts.setValueAt(country.getText(), row, 1);
        parent.dataProducts.setValueAt(weight.getText(), row, 2);
        parent.dataProducts.setValueAt(price.getText(), row, 3);
        parent.makeXml();
        SwingUtilities.invokeLater(() -> JOptionPane.showMessageDialog(null, "2 поток закончил работу, данные сохранены"));
    }

    @Override
    public void init(products parent) {
        int row = parent.dataProducts.getSelectedRow();
        name = new JTextField(parent.dataProducts.getValueAt(row, 0).toString(), 20);
        country = new JTextField(parent.dataProducts.getValueAt(row, 1).toString(), 20);
        weight = new JTextField(parent.dataProducts.getValueAt(row, 2).toString(), 20);
        price = new JTextField(parent.dataProducts.getValueAt(row, 3).toString(), 20);
        checker(0,name);
        checker(1,country);
        checker(2,weight);
        checker(3,price);
    }

    public EditDialogProd(JFrame owner, products parent, String title){
        super(owner,parent, title);
    };
}