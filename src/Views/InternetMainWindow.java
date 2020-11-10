package Views;

import InternetOrders.InternetOrder;
import InternetOrders.InternetOrdersManager;
import TableOrders.TableOrdersManager;
import com.company.Order;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InternetMainWindow extends JFrame {

    // Модель списка
    protected DefaultListModel<String> dlm = new DefaultListModel<String>();
    protected InternetOrdersManager manager = new InternetOrdersManager();
    Label label = new Label();
    JList<String> list2;
    JButton add = new JButton("Add order");
    JButton edit = new JButton("Change order");
    JButton delete = new JButton("Finish order");
    JButton info = new JButton("Order info");
    public InternetMainWindow(MainWindow window) throws NullPointerException {
        super("Internet Restaurant");
        InternetMainWindow wind = this;
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        JMenuBar menuBar = new JMenuBar();
        JMenu type = new JMenu("Restaurant type");
        JMenuItem changeType = new JMenuItem("Back to restaurant");
        type.add(changeType);
        menuBar.add(type);
        changeType.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                window.setVisible(true);
                setVisible(false);
                // System.out.println("ДИЧЬ начинается");
            }
        });

        // Создание панели
        list2 = new JList<String>(dlm);
        list2.setFixedCellHeight(55);
        list2.setFixedCellWidth(330);

        label.setText("Count of internet orders: "+manager.ordersQuantity());
        JPanel mainContent = new JPanel();
        JPanel secondMainContent = new JPanel();
        JPanel contents = new JPanel();
        JPanel contents1 = new JPanel();
        JPanel contents2 = new JPanel();
        // Создание кнопки
        edit.setEnabled(false);
        delete.setEnabled(false);
        info.setEnabled(false);


        add.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                add.setEnabled(false);
                CustomerInfoWindow customerInfoWindow = new CustomerInfoWindow(wind,manager);
                customerInfoWindow.setVisible(true);
                setVisible(false);
            }
        });
        delete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String str=list2.getSelectedValue();
                String numberOnly= str.replaceAll("[^0-9]", "");
                int result = JOptionPane.showConfirmDialog(InternetMainWindow.this,"Do you want to finish order № " +
                                numberOnly + " ?\n"+"Total price is "+manager.getOrder(Integer.parseInt(numberOnly)).costTotal(),
                        "End Game",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE);
                if(result == JOptionPane.YES_OPTION){
                    int selectedIndex = list2.getSelectedIndex();
                    if (selectedIndex != -1) {
                        manager.deleteOrder(Integer.parseInt(numberOnly));
                        dlm.remove(selectedIndex);
                        label.setText("Count of internet orders: "+manager.ordersQuantity());
                        validate();
                    }
                    if(dlm.isEmpty()){
                        edit.setEnabled(false);
                        delete.setEnabled(false);
                        info.setEnabled(false);
                    }
                }

            }
        });
        edit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String str=list2.getSelectedValue();
                String numberOnly= str.replaceAll("[^0-9]", "");
                int selectedIndex = list2.getSelectedIndex();
                if (selectedIndex != -1) {
                    if(manager.getOrder(Integer.parseInt(numberOnly)).getCustomer().getAge()<18)
                        JOptionPane.showMessageDialog(InternetMainWindow.this,
                                "Alcohol is not available for this age!");
                    ChangeOrderWindow changeOrderWindow= new ChangeOrderWindow(wind,manager,Integer.parseInt(numberOnly));
                   changeOrderWindow.setVisible(true);
                }
            }
        });
        info.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                String str=list2.getSelectedValue();
                String numberOnly= str.replaceAll("[^0-9]", "");
                int selectedIndex = list2.getSelectedIndex();
                if (selectedIndex != -1) {
                    InfoWindow infoWindow = new InfoWindow(manager,Integer.parseInt(numberOnly));
                }
            }
        });

        contents.add(new JScrollPane(list2));


        contents2.add(label);
        contents2.setLayout(new GridLayout(1, 1));

        contents1.add(add);
        contents1.add(edit);
        contents1.add(delete);
        contents1.add(info);
        contents1.setLayout(new GridLayout(4, 1));

        secondMainContent.add(contents2);
        secondMainContent.add(contents1);
        secondMainContent.setLayout(new GridLayout(2, 1));

        mainContent.add(contents);
        mainContent.add(secondMainContent);
        mainContent.setLayout(new FlowLayout());
        setJMenuBar(menuBar);
        setContentPane(mainContent);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(750, 530);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    protected void refresh(Order order, boolean isRewritable) {
        setVisible(true);
        edit.setEnabled(true);
        delete.setEnabled(true);
        info.setEnabled(true);
        if(isRewritable){
            manager.deleteOrder(order.getOrderNumber());
            manager.addOrder(order);
           // dlm.removeElementAt(dlm.size()-1);
        }else{
            manager.addOrder(order);
            dlm.addElement("ORDER № " + order.getOrderNumber());
        }

        label.setText("Count of internet orders: "+manager.ordersQuantity());
        validate();
    }
}