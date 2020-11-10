package Views;

import TableOrders.TableOrdersManager;
import com.company.Order;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TablesWindow extends JFrame {
    private DefaultListModel<String> dlm = new DefaultListModel<String>();
     TablesWindow(TableOrdersManager manager, MainWindow window){
         MainWindow window1 = window;
         JList<String> list2 = new JList<String>(dlm);
         list2.setFixedCellHeight(30);
         list2.setFixedCellWidth(300);
         Order[] orders = manager.getOrders();
         JPanel buttonPanel = new JPanel(new FlowLayout());
         JPanel mainContent = new JPanel();
         JLabel tableNumberInfo = new JLabel("Please, choose a free table: ");
         JButton next = new JButton("Next");
         JButton cancel = new JButton("Cancel");
         buttonPanel.add(cancel);
         buttonPanel.add(next);
         next.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 int selectedIndex = list2.getSelectedIndex();
                 if (selectedIndex != -1) {
                     try {
                         if (orders[selectedIndex]!=null){
                             JOptionPane.showMessageDialog(TablesWindow.this,
                                     "Table is not free!");
                         }else{
                             CustomerInfoWindow customerInfoWindow = new CustomerInfoWindow(window1, selectedIndex);
                             dispose();
                         }
                     }catch(NullPointerException ex){

                     }
                 }

             }
         });
         cancel.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 dispose();
                window.setVisible(true);
             }
         });

         
         for(int i = 0; i<orders.length;i++){
             try{
                 if(orders[i]==null)
                 dlm.addElement("Table № "+i+"  is free");
                 else {
                     dlm.addElement("Table № "+i+"  is not free");
                 }
             }catch(NullPointerException ex){

             }
         }
         mainContent.add(tableNumberInfo);
         mainContent.add(new JScrollPane(list2));
         mainContent.add(buttonPanel);
         mainContent.setLayout(new FlowLayout());
         setContentPane(mainContent);
         setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
         setSize(450, 500);
         setLocationRelativeTo(null);
         setVisible(true);
     }
}
