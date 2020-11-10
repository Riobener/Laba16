package Views;

import Client_info.Address;
import Client_info.Customer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CustomerAddressInfoWindow extends JFrame {
    public CustomerAddressInfoWindow(InternetMainWindow window, Customer customer){
        super("Client Address Info");

        InternetMainWindow window1 = window;

        JPanel buttonPanel = new JPanel(new FlowLayout());
        JButton next = new JButton("Next");
        JButton cancel = new JButton("Cancel");
        JPanel cityPan = new JPanel(new GridLayout(2,1));
        JPanel zipPan = new JPanel(new GridLayout(2,1));
        JPanel streetPan = new JPanel(new GridLayout(2,1));
        JPanel buildingNumPan = new JPanel(new GridLayout(2,1));
        JPanel buildingLetPan = new JPanel(new GridLayout(2,1));
        JPanel apartPan = new JPanel(new GridLayout(2,1));
        JLabel cityL = new JLabel("Enter city:");
        JLabel zipL = new JLabel("Enter zipcode:");
        JLabel streetL = new JLabel("Enter street:");
        JLabel buildingNumL= new JLabel("Enter building number:");
        JLabel buildingLetL = new JLabel("Enter building letter:");
        JLabel apartL = new JLabel("Enter apartment number:");
        JTextField cityName = new JTextField();
        JTextField zipCode = new JTextField();
        JTextField streetName = new JTextField();
        JTextField buildingNumber = new JTextField();
        JTextField buildingLetter = new JTextField();
        JTextField apartmentNumber = new JTextField();
        cityPan.add(cityL);
        cityPan.add(cityName);
        zipPan.add(zipL);
        zipPan.add(zipCode);
        streetPan.add(streetL);
        streetPan.add(streetName);
        buildingNumPan.add(buildingNumL);
        buildingNumPan.add(buildingNumber);
        buildingLetPan.add(buildingLetL);
        buildingLetPan.add(buildingLetter);
        apartPan.add(apartL);
        apartPan.add(apartmentNumber);


        buttonPanel.add(cancel);
        buttonPanel.add(next);

        next.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String city1 = cityName.getText().replaceAll("\\s+","");
                String zip1 = zipCode.getText().replaceAll("\\s+","");
                String street1 = streetName.getText().replaceAll("\\s+","");
                String buildL1 = buildingLetter.getText().replaceAll("\\s+","");
                String buildN1 = buildingNumber.getText().replaceAll("\\s+","");
                String apart1 =  apartmentNumber.getText().replaceAll("\\s+","");
                if ((city1.matches("[a-zA-Z]+"))&&
                        (zip1.matches("\\d+"))&&
                        (street1.matches("[a-zA-Z]+"))&&
                        (buildL1.matches("[a-zA-Z]+")&& buildL1.length()==1)&&
                        (buildN1.matches("\\d+"))&&
                        (apart1.matches("\\d+"))) {
                    Customer cust = new Customer(customer.getFirstName(), customer.getSecondName(),
                            customer.getAge(), new Address(city1, Integer.parseInt(zip1), street1,
                            Integer.parseInt(buildN1), buildL1.charAt(0), Integer.parseInt(apart1)));
                    MakeOrderWindow orderWindow = new MakeOrderWindow(window1,
                            cust);
                    orderWindow.setVisible(true);
                    dispose();
                }else{
                    JOptionPane.showMessageDialog(CustomerAddressInfoWindow.this,
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
        JPanel contents = new JPanel();
        contents.add(cityPan);
        contents.add(zipPan);
        contents.add(streetPan);
        contents.add(buildingNumPan);
        contents.add(buildingLetPan);
        contents.add(apartPan);
        contents.add(buttonPanel);
        setContentPane(contents);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setSize(350, 180);
        setLocationRelativeTo(null);
        setVisible(true);
    }

}
