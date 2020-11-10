package TableOrders;

import Items.MenuItem;
import com.company.Order;

import com.company.OrdersManager;

public class TableOrdersManager implements OrdersManager {

    private Order[] orders;
    private int actualSize;
    public TableOrdersManager(){
        actualSize = 20;
        orders = new Order[actualSize];
    }
    public void add(Order order, int tableNumber){
        orders[tableNumber]= order;

    }

    public int freeTableNumber(){
        int c = 20;
        for(int i = 0; i<orders.length;i++){
            try{
                if(orders[i]!=null){
                    c--;
                }
            }catch(NullPointerException ex){

            }
        }
        return c;
    }

    public Order getOrder(int tableNumber){
        return orders[tableNumber];
    }
    public void remove(int tableNumber){
        orders[tableNumber] = null;
    }

    @Override
    public int itemsQuantity(String itemName) {
        int c = 0;
        for(int i = 0; i<orders.length;i++){
            MenuItem[] items1 = orders[i].getItems();
            for(int j = 0; j<items1.length;j++){
                try{
                    if(items1[j].getName().equals(itemName)){
                        c++;
                    }
                }catch(NullPointerException ex){}
            }
        }
        return c;
    }

    @Override
    public int itemsQuantity(MenuItem item) {
        int c = 0;
        for(int i = 0; i<orders.length;i++){
            MenuItem[] items1 = orders[i].getItems();
            for(int j = 0; j<items1.length;j++){
                try{
                    if(items1[j]==item){
                        c++;
                    }
                }catch(NullPointerException ex){}
            }
        }
        return c;

    }

    @Override
    public Order[] getOrders() {
        return orders;
    }

    @Override
    public int ordersCostSummary() {
        int c = 0;
        for(int i = 0; i<orders.length;i++){
            MenuItem[] items1 = orders[i].getItems();
            for(int j = 0; j<items1.length;j++){
                try{
                    c+=items1[j].getCost()*items1[j].getValue();
                }catch(NullPointerException ex){}
            }
        }
        return c;
    }

    @Override
    public int ordersQuantity() {
        int c= 0;
        for(int i = 0; i<orders.length;i++){
            if(orders[i]!=null){
                c++;
            }
        }
        return c;
    }
}
