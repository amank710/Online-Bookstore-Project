package ui;

import model.Customer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLOutput;

import static model.City.*;

public class BookstoreGUI extends JFrame implements ActionListener {

    public static final int WIDTH = 600;
    public static final int HEIGHT = 500;
    JFrame frame;
    JPanel panel;
    JButton enter;
    JTextField firstName;
    JTextField lastName;
    JTextField email;
    JComboBox cityList;

    BookstoreGUI() {
        frame = new JFrame("Aman's Bookstore");
        frame.setSize(WIDTH, HEIGHT);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLayout(null);

        panel = new JPanel();
        panel.setBackground(Color.gray);
        panel.setBounds(0, 0, WIDTH, HEIGHT);
        panel.setLayout(null);

        showDiscountOffers();
        enterName();
        enterEmailAndCity();

        enter = new JButton("Enter Store");
        enter.setBounds(200,350,125,30);
        enter.addActionListener(this);

        panel.add(enter);

        frame.add(panel);
        frame.setVisible(true);

    }

    private void enterEmailAndCity() {
        JLabel labelMail = new JLabel("E-Mail:");
        labelMail.setFont(new Font("Serif", Font.PLAIN, 20));
        labelMail.setBounds(20,210,200, 50);
        email = new JTextField();
        email.setBounds(175,225,200,25);

        JLabel labelCity = new JLabel("City to deliver to:");
        labelCity.setFont(new Font("Serif", Font.PLAIN, 20));
        labelCity.setBounds(20,240,200, 50);
        cityList = new JComboBox(DELIVERYCITYNAMES);
        cityList.setBounds(175,255,200,25);

        panel.add(labelMail);
        panel.add(email);
        panel.add(labelCity);
        panel.add(cityList);
    }

    private void enterName() {
        JLabel labelFirst = new JLabel("First name:");
        labelFirst.setFont(new Font("Serif", Font.PLAIN, 20));
        labelFirst.setBounds(20,150,200, 50);
        firstName = new JTextField();
        firstName.setBounds(175,165,200,25);

        JLabel labelLast = new JLabel("Last name:");
        labelLast.setFont(new Font("Serif", Font.PLAIN, 20));
        labelLast.setBounds(20,180,200, 50);
        lastName = new JTextField();
        lastName.setBounds(175,195,200,25);

        panel.add(firstName);
        panel.add(labelFirst);
        panel.add(lastName);
        panel.add(labelLast);
    }

    private void showDiscountOffers() {
        JLabel label1 = new JLabel("Welcome to Aman's book store, Vancouver");
        JLabel label2 = new JLabel("EXCLUSIVE OFFERS:");
        JLabel label3 = new JLabel("On total bill price over CAD 5.00 get 5% off!\n");
        JLabel label4 = new JLabel("On total bill price over CAD 13.00 get 10% off!\n");
        JLabel label5 = new JLabel("On total bill price over CAD 16.00 get 15% off!\n");
        JLabel label6 = new JLabel("On total bill price over CAD 30.00 get 20% off!\n");
        label1.setBounds(175,5,500,50);
        label2.setBounds(10,20,500,50);
        label3.setBounds(10,30,500,50);
        label4.setBounds(10,40,500,50);
        label5.setBounds(10,50,500,50);
        label6.setBounds(10,60,500,50);

        panel.add(label1);
        panel.add(label2);
        panel.add(label3);
        panel.add(label4);
        panel.add(label5);
        panel.add(label6);
    }

    public static void main(String[] args) {
        new BookstoreGUI();
    }

    @Override

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == enter) {
            Customer.setFirstName(firstName.getText());
            Customer.setLastName(lastName.getText());
            Customer.setEmail(email.getText());
            //String selectedCity = (String) cityList.getItemAt(cityList.getSelectedIndex());
            switch ((String)cityList.getItemAt(cityList.getSelectedIndex())) {
                case "Toronto":
                    Customer.setDeliveryCity(TORONTO);
                    break;
                case "Ottawa":
                    Customer.setDeliveryCity(OTTAWA);
                    break;
                case "Edmonton":
                    Customer.setDeliveryCity(EDMONTON);
                    break;
                case "Calgary":
                    Customer.setDeliveryCity(CALGARY);
                    break;
                default:
                    Customer.setDeliveryCity(VANCOUVER);
            }
        } else {
            checkOtherButtons(e);
        }
    }

    private void checkOtherButtons(ActionEvent e) {
    }
}
