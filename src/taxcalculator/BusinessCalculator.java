/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taxcalculator;

import java.awt.Color;
import java.awt.event.ActionEvent;
import static java.awt.image.ImageObserver.HEIGHT;
import java.util.InputMismatchException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;

/**
 *
 * @author matthewbelgre
 */
class BusinessCalculator extends JFrame {

    JButton calculate;
    JLabel label, label1;
    JTextField textfield, textfield2;

    public BusinessCalculator() {
        super("Business Tax Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setVisible(true);
        setSize(430, 150);
        setLocation(500, 300);

        //Creates calculate button
        calculate = new JButton("Calculate");
        calculate.setBounds(0, 90, 140, 40);
        calculate.setOpaque(true);

        calculate.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                calculate.setBackground(Color.blue);
                calculate.setForeground(Color.blue);

            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {

                calculate.setBackground(UIManager.getColor("control"));
                calculate.setForeground(Color.BLACK);
            }
        });

        //Total Income label
        label = new JLabel();
        label.setText("Total Income :");
        label.setBounds(10, 10, 100, 10);

        //Income textfield
        textfield = new JTextField();
        textfield.setBounds(220, 0, 210, 40);

        //Expense Label
        label1 = new JLabel();
        label1.setText("Total Expense :");
        label1.setBounds(10, 50, 100, 30);

        //Expense Textfield
        textfield2 = new JTextField();
        textfield2.setBounds(220, 40, 210, 40);

        //Add components to frame
        add(label1);
        add(textfield);
        add(label);
        add(textfield2);
        add(calculate);

        //action listener for calculate button
        calculate.addActionListener((ActionEvent arg0) -> {
            //Will test input to check that input is didgit and catch NumberFormatException
            try {
                String income = textfield.getText();
                String expense = textfield2.getText();
                double incomeDouble;
                double expenseDouble;


                incomeDouble = Double.parseDouble(income);
                expenseDouble = Double.parseDouble(expense);
                double taxable = incomeDouble - expenseDouble;
                if(incomeDouble < 0 || expenseDouble <0 || taxable < 0){
                    throw new InputMismatchException();

                } else {
                    dispose();
                    JOptionPane.showMessageDialog(null, "Tax Payable amount is A$" + BusinessTax.calcTax(taxable), "Business Tax", HEIGHT);
                }

            }  catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Please enter a valid number", "Warning!", HEIGHT);
                }
                catch (InputMismatchException e) {
                 JOptionPane.showMessageDialog(null, "Please enter a number greater than zero", "Warning!", HEIGHT);

                }
        });

    }
}
