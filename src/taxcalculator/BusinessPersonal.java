/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taxcalculator;

import java.awt.Color;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.UIManager;

/**
 *
 * @author matthewbelgre
 */
class BusinessPersonal extends JFrame {

    JButton b1, b2;

    public BusinessPersonal() {
        super("Tax Calculator");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setVisible(true);
        setSize(510, 100);
        setLocation(500, 300);

        //creates buttons
        b1 = new JButton("Business Tax Calculator");
        b2 = new JButton("Personal Tax Calculator");
        b1.setOpaque(true);
        b2.setOpaque(true);

        //Changes colour on mouse hover for Button 1
        b1.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                b1.setBackground(Color.BLUE);
                b1.setBorderPainted(false);
                b1.setForeground(Color.white);
            }
            //Changes colour back on Button 1 when hover exited

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {

                b1.setBackground(UIManager.getColor("control"));
                b1.setBorderPainted(true);
                b1.setForeground(Color.BLACK);
            }
        });

        //Changes colour on mouse hover for Button 2
        b2.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                b2.setBackground(Color.blue);
                b2.setBorderPainted(false);
                b2.setForeground(Color.white);

            }

            //Changes colour back on Button 2 when hover exited
            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {

                b2.setBackground(UIManager.getColor("control"));
                b2.setBorderPainted(true);
                b2.setForeground(Color.BLACK);
            }
        });

        //Button 2 action listener
        b2.addActionListener((ActionEvent e) -> {

            new PersonalCalculator();
            dispose();
        });

        //Button 1 action listener
        b1.addActionListener((ActionEvent e) -> {
            new BusinessCalculator();
            dispose();
        });

        //sets button sizes
        b1.setBounds(0, 0, 250, 80);
        b2.setBounds(260, 0, 250, 80);

        //Add buttons to frame
        add(b1);
        add(b2);
    }
}
