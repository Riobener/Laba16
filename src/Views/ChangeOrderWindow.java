package Views;

import InternetOrders.InternetOrder;
import InternetOrders.InternetOrdersManager;
import Items.*;
import Items.MenuItem;
import TableOrders.TableOrder;
import TableOrders.TableOrdersManager;
import Views.MainWindow;
import com.company.Order;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import static java.lang.Integer.valueOf;

public class ChangeOrderWindow extends JFrame {
    ChangeOrderWindow(InternetMainWindow window1, InternetOrdersManager manager, int orderNumber) {
        super("Changing the internet order № "+orderNumber);
        JTabbedPane jtp = new JTabbedPane();

        int value = 0;
        int maximum = 10;
        JLabel[] labelsDish = new JLabel[]{new JLabel("STEAK"),new JLabel("PIE"),new JLabel("FISH"),
                new JLabel("CHIPS"),new JLabel("POTATO")};
        JSpinner[] spinDish = new JSpinner[]{new JSpinner(new SpinnerNumberModel(value, 0, maximum, 1)),
                new JSpinner(new SpinnerNumberModel(value, 0, maximum, 1)),
                new JSpinner(new SpinnerNumberModel(value, 0, maximum, 1)),
                new JSpinner(new SpinnerNumberModel(value, 0, maximum, 1)),
                new JSpinner(new SpinnerNumberModel(value, 0, maximum, 1))};

        JLabel[] labels = new JLabel[]{new JLabel("BEER"), new JLabel("WINE"), new JLabel("VODKA"),
                new JLabel("BRANDY"), new JLabel("CHAMPAGNE"), new JLabel("WHISKEY")
                , new JLabel("TEQUILA"), new JLabel("RUM"), new JLabel("VERMUTH")
                , new JLabel("LIQUOR"), new JLabel("JAGERMEISTER"), new JLabel("JUICE")
                , new JLabel("COFFE"), new JLabel("GREEN_TEA"), new JLabel("BLACK_TEA")
                , new JLabel("MILK"), new JLabel("WATER"), new JLabel("SODA")};

        JSpinner[] spinInt = new JSpinner[]{new JSpinner(new SpinnerNumberModel(value, 0, maximum, 1)),
                new JSpinner(new SpinnerNumberModel(value, 0, maximum, 1)),
                new JSpinner(new SpinnerNumberModel(value, 0, maximum, 1)),
                new JSpinner(new SpinnerNumberModel(value, 0, maximum, 1)),
                new JSpinner(new SpinnerNumberModel(value, 0, maximum, 1)),
                new JSpinner(new SpinnerNumberModel(value, 0, maximum, 1)),
                new JSpinner(new SpinnerNumberModel(value, 0, maximum, 1)),
                new JSpinner(new SpinnerNumberModel(value, 0, maximum, 1)),
                new JSpinner(new SpinnerNumberModel(value, 0, maximum, 1)),
                new JSpinner(new SpinnerNumberModel(value, 0, maximum, 1)),
                new JSpinner(new SpinnerNumberModel(value, 0, maximum, 1)),
                new JSpinner(new SpinnerNumberModel(value, 0, maximum, 1)),
                new JSpinner(new SpinnerNumberModel(value, 0, maximum, 1)),
                new JSpinner(new SpinnerNumberModel(value, 0, maximum, 1)),
                new JSpinner(new SpinnerNumberModel(value, 0, maximum, 1)),
                new JSpinner(new SpinnerNumberModel(value, 0, maximum, 1)),
                new JSpinner(new SpinnerNumberModel(value, 0, maximum, 1)),
                new JSpinner(new SpinnerNumberModel(value, 0, maximum, 1))};

        Order[] orders = manager.getOrders();
        Items.MenuItem[]items = manager.getOrder(orderNumber).getItems();
        JPanel contents1 = new JPanel();
        for (int i = 0; i < labels.length; i++) {
            try{
                for(int j = 0; j<items.length;j++){
                    if(items[j].getName().equals(labels[i].getText())){
                        spinInt[i].setValue(items[j].getValue());
                    }
                }

            }catch (NullPointerException ex){

            }
            labels[i].setToolTipText("I'm too lazy to print here smth");
            spinInt[i].setToolTipText("I'm too lazy to print here smth");
            contents1.add(labels[i]);
            contents1.add(spinInt[i]);
        }


        JPanel contents2 = new JPanel();
        for (int i = 0; i < labelsDish.length; i++) {
            try{
                for(int j = 0; j<items.length;j++){
                    if(items[j].getName().equals(labelsDish[i].getText())){
                        spinDish[i].setValue(items[j].getValue());
                    }
                }

            }catch (NullPointerException ex){

            }
            labelsDish[i].setToolTipText("I'm too lazy to print here smth");
            spinDish[i].setToolTipText("I'm too lazy to print here smth");
            contents2.add(labelsDish[i]);
            contents2.add(spinDish[i]);
        }
        JButton cancel = new JButton("Отмена");
        JButton ready = new JButton("Готово");
        cancel.setSize(100, 100);
        ready.setSize(100, 100);
        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        ready.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int flag = 0;
                InternetOrder order = new InternetOrder(manager.getOrder(orderNumber).getCustomer(), orderNumber);
                for (int i = 0; i < 18; i++) {
                    //System.out.println((Integer) spinInt[i].getValue());
                    switch (i) {
                        case 0:
                            if ((Integer) spinInt[i].getValue() != 0) {
                                order.add(new Drink(DrinkTypeEnum.BEER,(Integer) spinInt[i].getValue()));
                                flag++;
                            }

                            if ((Integer) spinDish[i].getValue() != 0) {
                                order.add(new Dish(DishTypeEnum.STEAK,(Integer) spinDish[i].getValue()));
                                flag++;
                            }

                            break;
                        case 1:
                            if ((Integer) spinInt[i].getValue() != 0) {
                                order.add(new Drink(DrinkTypeEnum.WINE,(Integer) spinInt[i].getValue()));
                                flag++;
                            }

                            if ((Integer) spinDish[i].getValue() != 0) {
                                order.add(new Dish(DishTypeEnum.PIE,(Integer) spinDish[i].getValue()));
                                flag++;
                            }

                            break;
                        case 2:
                            if ((Integer) spinInt[i].getValue() != 0) {
                                order.add(new Drink(DrinkTypeEnum.VODKA,(Integer) spinInt[i].getValue()));
                                flag++;
                            }

                            if ((Integer) spinDish[i].getValue() != 0) {
                                order.add(new Dish(DishTypeEnum.FISH,(Integer) spinDish[i].getValue()));
                                flag++;
                            }

                            break;
                        case 3:
                            if ((Integer) spinInt[i].getValue() != 0) {
                                order.add(new Drink(DrinkTypeEnum.BRANDY,(Integer) spinInt[i].getValue()));
                                flag++;
                            }
                            if ((Integer) spinDish[i].getValue() != 0) {
                                order.add(new Dish(DishTypeEnum.CHIPS,(Integer) spinDish[i].getValue()));
                                flag++;
                            }

                            break;
                        case 4:
                            if ((Integer) spinInt[i].getValue() != 0) {
                                order.add(new Drink(DrinkTypeEnum.CHAMPAGNE,(Integer) spinInt[i].getValue()));
                                flag++;
                            }
                            if ((Integer) spinDish[i].getValue() != 0) {
                                order.add(new Dish(DishTypeEnum.POTATO,(Integer) spinDish[i].getValue()));
                                flag++;
                            }

                            break;
                        case 5:
                            if ((Integer) spinInt[i].getValue() != 0) {
                                order.add(new Drink(DrinkTypeEnum.WHISKEY,(Integer) spinInt[i].getValue()));
                                flag++;
                            }
                            break;
                        case 6:
                            if ((Integer) spinInt[i].getValue() != 0) {
                                order.add(new Drink(DrinkTypeEnum.TEQUILA,(Integer) spinInt[i].getValue()));
                                flag++;
                            }
                            break;
                        case 7:
                            if ((Integer) spinInt[i].getValue() != 0) {
                                order.add(new Drink(DrinkTypeEnum.RUM,(Integer) spinInt[i].getValue()));
                                flag++;
                            }
                            break;
                        case 8:
                            if ((Integer) spinInt[i].getValue() != 0) {
                                order.add(new Drink(DrinkTypeEnum.VERMUTH,(Integer) spinInt[i].getValue()));
                                flag++;
                            }
                            break;
                        case 9:
                            if ((Integer) spinInt[i].getValue() != 0) {
                                order.add(new Drink(DrinkTypeEnum.LIQUOR,(Integer) spinInt[i].getValue()));
                                flag++;
                            }
                            break;
                        case 10:
                            if ((Integer) spinInt[i].getValue() != 0) {
                                order.add(new Drink(DrinkTypeEnum.JAGERMEISTER,(Integer) spinInt[i].getValue()));
                                flag++;
                            }
                            break;
                        case 11:
                            if ((Integer) spinInt[i].getValue() != 0) {
                                order.add(new Drink(DrinkTypeEnum.JUICE,(Integer) spinInt[i].getValue()));
                                flag++;
                            }
                            break;
                        case 12:
                            if ((Integer) spinInt[i].getValue() != 0) {
                                order.add(new Drink(DrinkTypeEnum.COFFE,(Integer) spinInt[i].getValue()));
                                flag++;
                            }
                            break;
                        case 13:
                            if ((Integer) spinInt[i].getValue() != 0) {
                                order.add(new Drink(DrinkTypeEnum.GREEN_TEA,(Integer) spinInt[i].getValue()));
                                flag++;
                            }
                            break;
                        case 14:
                            if ((Integer) spinInt[i].getValue() != 0) {
                                order.add(new Drink(DrinkTypeEnum.BLACK_TEA,(Integer) spinInt[i].getValue()));
                                flag++;
                            }
                            break;
                        case 15:
                            if ((Integer) spinInt[i].getValue() != 0) {
                                order.add(new Drink(DrinkTypeEnum.MILK,(Integer) spinInt[i].getValue()));
                                flag++;
                            }
                            break;
                        case 16:
                            if ((Integer) spinInt[i].getValue() != 0) {
                                order.add(new Drink(DrinkTypeEnum.WATER,(Integer) spinInt[i].getValue()));
                                flag++;
                            }
                            break;
                        case 17:
                            if ((Integer) spinInt[i].getValue() != 0) {
                                order.add(new Drink(DrinkTypeEnum.SODA,(Integer) spinInt[i].getValue()));
                                flag++;
                            }
                            break;

                    }
                }
                if(flag!=0) {
                    window1.refresh(order, true);
                    dispose();
                }else{
                    JOptionPane.showMessageDialog(ChangeOrderWindow.this,
                            "You entered smth wrong!");
                }

            }
        });
        JPanel grid = new JPanel(new GridLayout(9, 9));
        for(int i = 0; i<18;i++){
            if(i == 16){
                grid.add(cancel);
            }else if(i == 17){
                grid.add(ready);
            }else{
                grid.add(new JLabel(""));
            }
        }

        JPanel theMostMainCont = new JPanel(new GridLayout(1, 2));
        //theMostMainCont.setLayout(new BoxLayout(theMostMainCont,BoxLayout.Y_AXIS));
        JPanel mainContDrink = new JPanel(new GridLayout(1, 1));
        JPanel mainContDish = new JPanel(new GridLayout(1,1));
        contents1.setLayout(new GridLayout(18, 2));
        contents2.setLayout(new GridLayout(5,2));
        mainContDrink.add(contents1);
        mainContDish.add(contents2);
        for (int i = 1; i <= 2; i++) {
            // Размещение метки во вкладке
            // Добавление вкладки
            if(i == 1){
                jtp.addTab("Drinks", mainContDrink);
            }else{
                jtp.addTab("Dishes",mainContDish);
            }

            // Подключение мнемоники
            jtp.setMnemonicAt(i-1, String.valueOf(i).charAt(0));
        }
        // Подключение слушателя событий
        jtp.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                // Получение выделенной вкладки
                JPanel panel = (JPanel) ((JTabbedPane)e.getSource()).getSelectedComponent();
                // Количество компонентов в панели
                int count = panel.getComponentCount();
                System.out.println(count);
                // Добавление на вкладку новой метки
            }
        });
        // Подключение слушателя мыши
        jtp.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                // Определяем индекс выделенной мышкой вкладки
                int idx = ((JTabbedPane)e.getSource()).indexAtLocation(e.getX(), e.getY());
                System.out.println("Выбрана вкладка " + idx);
            }
        });

        theMostMainCont.add(jtp);
        theMostMainCont.add(grid);

        //theMostMainCont.add(mainCont);


        setContentPane(theMostMainCont);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setSize(500, 430);
        setLocationRelativeTo(null);

    }
    ChangeOrderWindow(MainWindow window,  TableOrdersManager manager,int chosenTable) {
        super("Changing the order under the table № "+chosenTable);
        JTabbedPane jtp = new JTabbedPane();

        int value = 0;
        int maximum = 10;
        JLabel[] labelsDish = new JLabel[]{new JLabel("STEAK"),new JLabel("PIE"),new JLabel("FISH"),
                new JLabel("CHIPS"),new JLabel("POTATO")};
        JSpinner[] spinDish = new JSpinner[]{new JSpinner(new SpinnerNumberModel(value, 0, maximum, 1)),
                new JSpinner(new SpinnerNumberModel(value, 0, maximum, 1)),
                new JSpinner(new SpinnerNumberModel(value, 0, maximum, 1)),
                new JSpinner(new SpinnerNumberModel(value, 0, maximum, 1)),
                new JSpinner(new SpinnerNumberModel(value, 0, maximum, 1))};

        JLabel[] labels = new JLabel[]{new JLabel("BEER"), new JLabel("WINE"), new JLabel("VODKA"),
                new JLabel("BRANDY"), new JLabel("CHAMPAGNE"), new JLabel("WHISKEY")
                , new JLabel("TEQUILA"), new JLabel("RUM"), new JLabel("VERMUTH")
                , new JLabel("LIQUOR"), new JLabel("JAGERMEISTER"), new JLabel("JUICE")
                , new JLabel("COFFE"), new JLabel("GREEN_TEA"), new JLabel("BLACK_TEA")
                , new JLabel("MILK"), new JLabel("WATER"), new JLabel("SODA")};

        JSpinner[] spinInt = new JSpinner[]{new JSpinner(new SpinnerNumberModel(value, 0, maximum, 1)),
                new JSpinner(new SpinnerNumberModel(value, 0, maximum, 1)),
                new JSpinner(new SpinnerNumberModel(value, 0, maximum, 1)),
                new JSpinner(new SpinnerNumberModel(value, 0, maximum, 1)),
                new JSpinner(new SpinnerNumberModel(value, 0, maximum, 1)),
                new JSpinner(new SpinnerNumberModel(value, 0, maximum, 1)),
                new JSpinner(new SpinnerNumberModel(value, 0, maximum, 1)),
                new JSpinner(new SpinnerNumberModel(value, 0, maximum, 1)),
                new JSpinner(new SpinnerNumberModel(value, 0, maximum, 1)),
                new JSpinner(new SpinnerNumberModel(value, 0, maximum, 1)),
                new JSpinner(new SpinnerNumberModel(value, 0, maximum, 1)),
                new JSpinner(new SpinnerNumberModel(value, 0, maximum, 1)),
                new JSpinner(new SpinnerNumberModel(value, 0, maximum, 1)),
                new JSpinner(new SpinnerNumberModel(value, 0, maximum, 1)),
                new JSpinner(new SpinnerNumberModel(value, 0, maximum, 1)),
                new JSpinner(new SpinnerNumberModel(value, 0, maximum, 1)),
                new JSpinner(new SpinnerNumberModel(value, 0, maximum, 1)),
                new JSpinner(new SpinnerNumberModel(value, 0, maximum, 1))};

        Order[] orders = manager.getOrders();
        MenuItem[] items = orders[chosenTable].getItems();
        JPanel contents1 = new JPanel();
        for (int i = 0; i < labels.length; i++) {
            try{
                for(int j = 0; j<items.length;j++){
                    if(items[j].getName().equals(labels[i].getText())){
                        spinInt[i].setValue(items[j].getValue());
                    }
                }

            }catch (NullPointerException ex){

            }
            contents1.add(labels[i]);
            contents1.add(spinInt[i]);
        }


        JPanel contents2 = new JPanel();
        for (int i = 0; i < labelsDish.length; i++) {
            try{
                for(int j = 0; j<items.length;j++){
                    if(items[j].getName().equals(labelsDish[i].getText())){
                        spinDish[i].setValue(items[j].getValue());
                    }
                }

            }catch (NullPointerException ex){

            }
            contents2.add(labelsDish[i]);
            contents2.add(spinDish[i]);
        }
        JButton cancel = new JButton("Cancel");
        JButton ready = new JButton("Done");
        cancel.setSize(100, 100);
        ready.setSize(100, 100);
        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        ready.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int flag = 0;
                TableOrder order = new TableOrder(manager.getOrder(chosenTable).getCustomer(),manager.getOrder(chosenTable).getOrderNumber());
                for (int i = 0; i < 18; i++) {
                    //System.out.println((Integer) spinInt[i].getValue());
                    switch (i) {
                        case 0:
                            if ((Integer) spinInt[i].getValue() != 0) {
                                order.add(new Drink(DrinkTypeEnum.BEER,(Integer) spinInt[i].getValue()));
                                flag++;
                            }

                            if ((Integer) spinDish[i].getValue() != 0) {
                                order.add(new Dish(DishTypeEnum.STEAK,(Integer) spinDish[i].getValue()));
                                flag++;
                            }

                            break;
                        case 1:
                            if ((Integer) spinInt[i].getValue() != 0) {
                                order.add(new Drink(DrinkTypeEnum.WINE,(Integer) spinInt[i].getValue()));
                                flag++;
                            }

                            if ((Integer) spinDish[i].getValue() != 0) {
                                order.add(new Dish(DishTypeEnum.PIE,(Integer) spinDish[i].getValue()));
                                flag++;
                            }

                            break;
                        case 2:
                            if ((Integer) spinInt[i].getValue() != 0) {
                                order.add(new Drink(DrinkTypeEnum.VODKA,(Integer) spinInt[i].getValue()));
                                flag++;
                            }

                            if ((Integer) spinDish[i].getValue() != 0) {
                                order.add(new Dish(DishTypeEnum.FISH,(Integer) spinDish[i].getValue()));
                                flag++;
                            }

                            break;
                        case 3:
                            if ((Integer) spinInt[i].getValue() != 0) {
                                order.add(new Drink(DrinkTypeEnum.BRANDY,(Integer) spinInt[i].getValue()));
                                flag++;
                            }
                            if ((Integer) spinDish[i].getValue() != 0) {
                                order.add(new Dish(DishTypeEnum.CHIPS,(Integer) spinDish[i].getValue()));
                                flag++;
                            }

                            break;
                        case 4:
                            if ((Integer) spinInt[i].getValue() != 0) {
                                order.add(new Drink(DrinkTypeEnum.CHAMPAGNE,(Integer) spinInt[i].getValue()));
                                flag++;
                            }
                            if ((Integer) spinDish[i].getValue() != 0) {
                                order.add(new Dish(DishTypeEnum.POTATO,(Integer) spinDish[i].getValue()));
                                flag++;
                            }

                            break;
                        case 5:
                            if ((Integer) spinInt[i].getValue() != 0) {
                                order.add(new Drink(DrinkTypeEnum.WHISKEY,(Integer) spinInt[i].getValue()));
                                flag++;
                            }
                            break;
                        case 6:
                            if ((Integer) spinInt[i].getValue() != 0) {
                                order.add(new Drink(DrinkTypeEnum.TEQUILA,(Integer) spinInt[i].getValue()));
                                flag++;
                            }
                            break;
                        case 7:
                            if ((Integer) spinInt[i].getValue() != 0) {
                                order.add(new Drink(DrinkTypeEnum.RUM,(Integer) spinInt[i].getValue()));
                                flag++;
                            }
                            break;
                        case 8:
                            if ((Integer) spinInt[i].getValue() != 0) {
                                order.add(new Drink(DrinkTypeEnum.VERMUTH,(Integer) spinInt[i].getValue()));
                                flag++;
                            }
                            break;
                        case 9:
                            if ((Integer) spinInt[i].getValue() != 0) {
                                order.add(new Drink(DrinkTypeEnum.LIQUOR,(Integer) spinInt[i].getValue()));
                                flag++;
                            }
                            break;
                        case 10:
                            if ((Integer) spinInt[i].getValue() != 0) {
                                order.add(new Drink(DrinkTypeEnum.JAGERMEISTER,(Integer) spinInt[i].getValue()));
                                flag++;
                            }
                            break;
                        case 11:
                            if ((Integer) spinInt[i].getValue() != 0) {
                                order.add(new Drink(DrinkTypeEnum.JUICE,(Integer) spinInt[i].getValue()));
                                flag++;
                            }
                            break;
                        case 12:
                            if ((Integer) spinInt[i].getValue() != 0) {
                                order.add(new Drink(DrinkTypeEnum.COFFE,(Integer) spinInt[i].getValue()));
                                flag++;
                            }
                            break;
                        case 13:
                            if ((Integer) spinInt[i].getValue() != 0) {
                                order.add(new Drink(DrinkTypeEnum.GREEN_TEA,(Integer) spinInt[i].getValue()));
                                flag++;
                            }
                            break;
                        case 14:
                            if ((Integer) spinInt[i].getValue() != 0) {
                                order.add(new Drink(DrinkTypeEnum.BLACK_TEA,(Integer) spinInt[i].getValue()));
                                flag++;
                            }
                            break;
                        case 15:
                            if ((Integer) spinInt[i].getValue() != 0) {
                                order.add(new Drink(DrinkTypeEnum.MILK,(Integer) spinInt[i].getValue()));
                                flag++;
                            }
                            break;
                        case 16:
                            if ((Integer) spinInt[i].getValue() != 0) {
                                order.add(new Drink(DrinkTypeEnum.WATER,(Integer) spinInt[i].getValue()));
                                flag++;
                            }
                            break;
                        case 17:
                            if ((Integer) spinInt[i].getValue() != 0) {
                                order.add(new Drink(DrinkTypeEnum.SODA,(Integer) spinInt[i].getValue()));
                                flag++;
                            }
                            break;

                    }
                }
                if(flag!=0) {
                    window.refresh(order, chosenTable, true);
                    dispose();
                }else{
                    JOptionPane.showMessageDialog(ChangeOrderWindow.this,
                            "You entered smth wrong!");
                }

            }
        });
        JPanel grid = new JPanel(new GridLayout(9, 9));
        for(int i = 0; i<18;i++){
            if(i == 16){
                grid.add(cancel);
            }else if(i == 17){
                grid.add(ready);
            }else{
                grid.add(new JLabel(""));
            }
        }

        JPanel theMostMainCont = new JPanel(new GridLayout(1, 2));
        //theMostMainCont.setLayout(new BoxLayout(theMostMainCont,BoxLayout.Y_AXIS));
        JPanel mainContDrink = new JPanel(new GridLayout(1, 1));
        JPanel mainContDish = new JPanel(new GridLayout(1,1));
        contents1.setLayout(new GridLayout(18, 2));
        contents2.setLayout(new GridLayout(5,2));
        mainContDrink.add(contents1);
        mainContDish.add(contents2);
        for (int i = 1; i <= 2; i++) {
            // Размещение метки во вкладке
            // Добавление вкладки
            if(i == 1){
                jtp.addTab("Drinks", mainContDrink);
            }else{
                jtp.addTab("Dishes",mainContDish);
            }

            // Подключение мнемоники
            jtp.setMnemonicAt(i-1, String.valueOf(i).charAt(0));
        }
        // Подключение слушателя событий
        jtp.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                // Получение выделенной вкладки
                JPanel panel = (JPanel) ((JTabbedPane)e.getSource()).getSelectedComponent();
                // Количество компонентов в панели
                int count = panel.getComponentCount();
                System.out.println(count);
                // Добавление на вкладку новой метки
            }
        });
        // Подключение слушателя мыши
        jtp.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                // Определяем индекс выделенной мышкой вкладки
                int idx = ((JTabbedPane)e.getSource()).indexAtLocation(e.getX(), e.getY());
                System.out.println("Выбрана вкладка " + idx);
            }
        });

        theMostMainCont.add(jtp);
        theMostMainCont.add(grid);

        //theMostMainCont.add(mainCont);


        setContentPane(theMostMainCont);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setSize(500, 430);
        setLocationRelativeTo(null);

    }
}