package ui;

import business.ContactBusiness;
import entity.ContactEntity;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class MainForm extends JFrame {

    private JPanel rootPanel;
    private JButton buttonNewContact;
    private JButton buttonRemoveContact;
    private JTable tableContacts;
    private JLabel labelContactCount;

    private ContactBusiness contactBusiness;

    public MainForm(){
        setContentPane(rootPanel);
        setSize(500, 250);
        setVisible(true);

        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation((dimension.width / 2) - getSize().width, (dimension.height / 2) - getSize().height);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        setListeners();

        contactBusiness = new ContactBusiness();

        loadContacts();


    }

    private void setListeners(){
        buttonNewContact.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ContactForm();
                dispose();
            }
        });

        buttonRemoveContact.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    private void loadContacts(){
        List<ContactEntity> contactList = contactBusiness.getList();

        String[] columnNames = {"name", "phone"};
        DefaultTableModel model = new DefaultTableModel(new Object[0][0], columnNames);

        for(ContactEntity contact : contactList){
            Object[] objects = new Object[2];

            objects[0] = contact.getName();
            objects[1] = contact.getPhone();

            model.addRow(objects);
        }

        tableContacts.clearSelection();
        tableContacts.setModel(model);

        labelContactCount.setText(contactBusiness.getContactCountDescription());
    }
}
