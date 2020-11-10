package Views;

import Client_info.Address;
import Client_info.Customer;
import InternetOrders.InternetOrdersManager;
import TableOrders.TableOrdersManager;
import com.company.Order;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CustomerInfoWindow extends JFrame {
    CustomerInfoWindow(MainWindow window,int selectedIndex) {
        super("Client Info");
        MainWindow window1 = window;
        JPanel namePan = new JPanel(new GridLayout(1,2));
        JPanel surnamePan = new JPanel(new GridLayout(1,2));
        JPanel agePan = new JPanel(new GridLayout(1,2));
        JLabel forName = new JLabel("Enter name:");
        JLabel forSurName = new JLabel("Enter surname:");
        JLabel forAge = new JLabel("Enter age:");
        JPanel contents = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JPanel buttonPanel = new JPanel(new FlowLayout());
        JButton next = new JButton("Next");
        JButton cancel = new JButton("Cancel");
        JTextField name = new JTextField();
        JTextField surname = new JTextField();
        JTextField age = new JTextField();
        namePan.add(forName);
        namePan.add(name);
        surnamePan.add(forSurName);
        surnamePan.add(surname);
        agePan.add(forAge);
        agePan.add(age);
        buttonPanel.add(cancel);
        buttonPanel.add(next);
        contents.add(namePan);
        contents.add(surnamePan);
        contents.add(agePan);
        contents.add(buttonPanel);
        next.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name1 = name.getText().replaceAll("\\s+","");
                String surname1 = surname.getText().replaceAll("\\s+","");
                String age1 = age.getText().replaceAll("\\s+","");
                if ((name1.matches("[a-zA-Z]+"))&&
                        (surname1.matches("[a-zA-Z]+"))&&
                        (age1.matches("\\d+")&&Integer.parseInt(age1)<100&&Integer.parseInt(age1)>10)) {

                    MakeOrderWindow orderWindow = new MakeOrderWindow(window1,selectedIndex,
                            new Customer(name1,surname1,Integer.parseInt(age1)));
                    orderWindow.setVisible(true);
                    dispose();
                }else{
                    JOptionPane.showMessageDialog(CustomerInfoWindow.this,
                            "You entered smth wrong!");
                }
        }});
        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        setContentPane(contents);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setSize(350, 115);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    CustomerInfoWindow(InternetMainWindow window, InternetOrdersManager manager){
        super("Client Info");
        InternetMainWindow window2 = window;
        JPanel namePan = new JPanel(new GridLayout(1,2));
        JPanel surnamePan = new JPanel(new GridLayout(1,2));
        JPanel agePan = new JPanel(new GridLayout(1,2));
        JLabel forName = new JLabel("Enter name:");
        JLabel forSurName = new JLabel("Enter surname:");
        JLabel forAge = new JLabel("Enter age:");
        JPanel contents = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JPanel buttonPanel = new JPanel(new FlowLayout());
        JButton next = new JButton("Next");
        JButton cancel = new JButton("Cancel");
        JTextField name = new JTextField();
        JTextField surname = new JTextField();
        JTextField age = new JTextField();
        namePan.add(forName);
        namePan.add(name);
        surnamePan.add(forSurName);
        surnamePan.add(surname);
        agePan.add(forAge);
        agePan.add(age);
        buttonPanel.add(cancel);
        buttonPanel.add(next);
        contents.add(namePan);
        contents.add(surnamePan);
        contents.add(agePan);
        contents.add(buttonPanel);
        next.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name1 = name.getText().replaceAll("\\s+","");
                String surname1 = surname.getText().replaceAll("\\s+","");
                String age1 = age.getText().replaceAll("\\s+","");

                if ((name1.matches("[a-zA-Z]+"))&&
                        (surname1.matches("[a-zA-Z]+"))&&
                        (age1.matches("\\d+")&&Integer.parseInt(age1)<100&&Integer.parseInt(age1)>10)) {
                    CustomerAddressInfoWindow wind = new CustomerAddressInfoWindow(window2, new Customer(
                            name1, surname1, Integer.parseInt(age1)),manager);
                    wind.setVisible(true);
                    dispose();
                }else{
                    JOptionPane.showMessageDialog(CustomerInfoWindow.this,
                            "You entered smth wrong!");
                }
            }
        });
        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        setContentPane(contents);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setSize(350, 115);
        setLocationRelativeTo(null);
        setVisible(true);


    }
}
