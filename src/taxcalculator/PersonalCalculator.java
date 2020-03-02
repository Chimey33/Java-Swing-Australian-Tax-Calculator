/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taxcalculator;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import static java.awt.image.ImageObserver.HEIGHT;
import java.util.InputMismatchException;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

/**
 *
 * @author matthewbelgre
 */
class PersonalCalculator extends JFrame {

    JButton calculate;
    JLabel label, label1;
    JTextField textfield;
    JRadioButton working, resident, nonResident;

// call super to set title and set layout  
    public PersonalCalculator() {
        super("Personal Tax Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setVisible(true);
        setSize(430, 150);
        setLocation(500, 300);

        //Creates calculate button
        calculate = new JButton("Calculate");
        calculate.setBounds(220, 90, 210, 40);
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

        //Radio Buttons
        nonResident = new JRadioButton("Non-Resident Tax");
        resident = new JRadioButton("Resident Tax");
        working = new JRadioButton("Working-Holiday Tax");

        //Group radio buttons
        ButtonGroup group = new ButtonGroup();
        group.add(nonResident);
        group.add(resident);
        group.add(working);

        //Income label
        label = new JLabel();
        label.setText("Total Income :");
        label.setBounds(10, 10, 100, 10);

        //Income textfield
        textfield = new JTextField();
        textfield.setBounds(220, 0, 210, 40);

        //Panel to case resident and non-resident
        JPanel p1 = new JPanel();
        p1.setLayout(new GridLayout());
        p1.setBounds(0, 45, 420, 45);
        p1.add(resident);
        p1.add(nonResident);

        //Panel to case working
        JPanel p2 = new JPanel();
        p2.setLayout(new GridLayout());
        p2.setBounds(0, 80, 180, 45);
        p2.add(working);

        add(textfield);
        add(label);
        add(p1);
        add(p2);
        add(calculate);

        calculate.addActionListener((ActionEvent arg0) -> {
            String getIncome = textfield.getText();

            //Resident radio tax calculation
            if (resident.isSelected()) {
                //Tries to run the code and catches the NumberFormatException exception
                try {



                    if (Double.parseDouble(getIncome) < 0) {
                        throw new InputMismatchException();

                    } else {
                        dispose();
                        JOptionPane.showMessageDialog(null, "Tax Payable amount is A$" + ResidentTaxPayer.calcTax(Double.parseDouble(getIncome)), "Resident Tax", HEIGHT);
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Please enter a valid number", "Warning!", HEIGHT);
                }
                catch (InputMismatchException e) {
                 JOptionPane.showMessageDialog(null, "Please enter a number greater than zero", "Warning!", HEIGHT);

                }
                


                //Non-resident radio tax calculation
            } else if (nonResident.isSelected()) {
                //Tries to run the code and catches the NumberFormatException exception
                try {
                    getIncome = textfield.getText();



                     if (Double.parseDouble(getIncome) < 0) {
                        throw new InputMismatchException();

                    } else {
                        dispose();
                        JOptionPane.showMessageDialog(null, "Tax Payable amount is A$" + ForeignResidentTaxPayer.calcTax(Double.parseDouble(getIncome)), "Non-Resident Tax", HEIGHT);
                    }
                }  catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Please enter a valid number", "Warning!", HEIGHT);
                }
                catch (InputMismatchException e) {
                 JOptionPane.showMessageDialog(null, "Please enter a number greater than zero", "Warning!", HEIGHT);

                }

                //Working holiday radio tax calculation
            } else if (working.isSelected()) {
                //Tries to run the code and catches the NumberFormatException exception
                try {

                    getIncome = textfield.getText();
                 if (Double.parseDouble(getIncome) < 0) {
                        throw new InputMismatchException();

                    } else {
                        dispose();
                        JOptionPane.showMessageDialog(null, "Tax Payable amount is A$" + WorkingHolidayTaxPayer.calcTax(Double.parseDouble(getIncome)), "Resident Tax", SwingConstants.CENTER);
                    }

                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Please enter a valid number", "Warning!", HEIGHT);
                }
                catch (InputMismatchException e) {
                 JOptionPane.showMessageDialog(null, "Please enter a number greater than zero", "Warning!", HEIGHT);

                }
            }
        });

    }
}
