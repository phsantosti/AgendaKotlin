package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainForm extends JFrame {

    private JPanel rootPanel;
    private JButton buttonNewContact;
    private JButton buttonRemoveContact;
    private JTable tableContacts;

    public MainForm(){
        this.setContentPane(rootPanel);
        this.setSize(500, 250);
        this.setVisible(true);

        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation((dimension.width / 2) - getSize().width, (dimension.height / 2) - getSize().height);

        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        this.setListeners();
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
}
