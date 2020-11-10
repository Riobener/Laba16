package Views;

import InternetOrders.InternetOrdersManager;
import Items.Drink;
import TableOrders.TableOrdersManager;
import com.company.Order;

import javax.swing.*;
import java.awt.*;

public class InfoWindow extends JFrame {

    private DefaultListModel<String> dlm = new DefaultListModel<String>();

    InfoWindow(TableOrdersManager manager, int orderNumb){
        super("Info about table № "+orderNumb);
        Items.MenuItem[]items = manager.getOrder(orderNumb).getItems();
        JPanel mainContent = new JPanel();
        JLabel tableNumberInfo = new JLabel("Orders history:");
        JPanel clientInfo = new JPanel(new GridLayout(4,1));
        JLabel nameInfo = new JLabel("Client name : "+manager.getOrder(orderNumb).getCustomer().getFirstName());
        JLabel surnameInfo = new JLabel("Client surname : "+manager.getOrder(orderNumb).getCustomer().getSecondName());
        JLabel ageInfo = new JLabel("Client age : "+manager.getOrder(orderNumb).getCustomer().getAge());
        JLabel totalCost = new JLabel("Total order cost : "+manager.getOrder(orderNumb).costTotal());
        clientInfo.add(nameInfo);
        clientInfo.add(surnameInfo);
        clientInfo.add(ageInfo);
        clientInfo.add(totalCost);
        JList<String> list2 = new JList<String>(dlm);
        list2.setFixedCellHeight(45);
        list2.setFixedCellWidth(350);

        for(int i = 0; i<items.length;i++){
                try{
                    dlm.addElement(items[i].getName()+" - "+items[i].getValue());

                }catch(NullPointerException ex){

                }

        }
        mainContent.add(tableNumberInfo);
        mainContent.add(new JScrollPane(list2));
        mainContent.add(clientInfo);
        mainContent.setLayout(new FlowLayout());
        setContentPane(mainContent);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setSize(450, 500);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    InfoWindow(InternetOrdersManager manager, int orderNumb){
        super("Info about order № "+orderNumb);
        /*
        this.cityName = cityName;
        this.zipCode = zipCode;
        this.streetName = streetName;
        this.buildingNumber = buildingNumber;
        this.buildingLetter = buildingLetter;
        this.apartmentNumber = apartmentNumber;
         */
        Items.MenuItem[]items = manager.getOrder(orderNumb).getItems();
        JPanel mainContent = new JPanel();
        JLabel tableNumberInfo = new JLabel("Orders history:");
        JPanel clientInfo = new JPanel(new GridLayout(10,1));
        JLabel cityName = new JLabel("City name: "+manager.getOrder(orderNumb).getCustomer().getAddress().getCityName());
        JLabel zipCode = new JLabel("Zip code: "+manager.getOrder(orderNumb).getCustomer().getAddress().getZipCode());
        JLabel streetName = new JLabel("Street name: "+manager.getOrder(orderNumb).getCustomer().getAddress().getStreetName());
        JLabel buildingNumber = new JLabel("Building number: "+manager.getOrder(orderNumb).getCustomer().getAddress().getBuildingNumber());
        JLabel buildingLetter = new JLabel("Building letter: "+manager.getOrder(orderNumb).getCustomer().getAddress().getBuildingLetter());
        JLabel apartmentNumber = new JLabel("Apartment number: "+manager.getOrder(orderNumb).getCustomer().getAddress().getApartmentNumber());
        JLabel nameInfo = new JLabel("Client name : "+manager.getOrder(orderNumb).getCustomer().getFirstName());
        JLabel surnameInfo = new JLabel("Client surname : "+manager.getOrder(orderNumb).getCustomer().getSecondName());
        JLabel ageInfo = new JLabel("Client age : "+manager.getOrder(orderNumb).getCustomer().getAge());
        JLabel totalCost = new JLabel("Total order cost : "+manager.getOrder(orderNumb).costTotal());
        clientInfo.add(cityName);
        clientInfo.add(zipCode);
        clientInfo.add(streetName);
        clientInfo.add(buildingNumber);
        clientInfo.add(buildingLetter);
        clientInfo.add(apartmentNumber);
        clientInfo.add(nameInfo);
        clientInfo.add(surnameInfo);
        clientInfo.add(ageInfo);
        clientInfo.add(totalCost);
        JList<String> list2 = new JList<String>(dlm);
        list2.setFixedCellHeight(32);
        list2.setFixedCellWidth(350);

        for(int i = 0; i<items.length;i++){
            try{
                dlm.addElement(items[i].getName()+" - "+items[i].getValue());

            }catch(NullPointerException ex){

            }

        }
        mainContent.add(tableNumberInfo);
        mainContent.add(new JScrollPane(list2));
        mainContent.add(clientInfo);
        mainContent.setLayout(new FlowLayout());
        setContentPane(mainContent);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setSize(450, 500);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
