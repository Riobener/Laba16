package TableOrders;

import Client_info.Customer;
import Items.MenuItem;
import com.company.Order;

public class TableOrder implements Order {
    private int size;
    private int index;
    private MenuItem[] items;
    private Customer customer;
    private int orderNumber;
    public TableOrder(Customer customer, int orderNumber){
        this.orderNumber = orderNumber;
        this.customer = customer;
        index = 0;
        size = 23;
        items = new MenuItem[size];
    }
    public int getOrderNumber(){
        return orderNumber;
    }
    @Override
    public boolean add(MenuItem item) {
        if(index!=23){
            items[index] = item;
            index++;
            return true;
        }

        return false;
    }

    @Override
    public String[] itemsNames() {
        return new String[0];
    }

    @Override
    public int itemsQuantity() {
        int c = 0;
        for(int i = 0; i<items.length;i++){
                try{
                    if(items[i].getName()!=null){
                        c++;
                    }
                    System.out.println(items[i].getName()+" "+items[i].getDescription()+" "+items[i].getCost());
                }catch(NullPointerException ex){

                }
        }
        return c;
    }

    @Override
    public int itemQuantity(String itemName) {
        for(int i = 0; i<items.length;i++){
            try{
                if(items[i].getName().equals(itemName)){
                    //2424242
                }
                System.out.println(items[i].getName()+" "+items[i].getDescription()+" "+items[i].getCost());
            }catch(NullPointerException ex){

            }
        }
        return 0;
    }

    @Override
    public int itemQuantity(MenuItem itemName) {
        return 0;
    }

    @Override
    public MenuItem[] getItems() {
        return items;
    }

    @Override
    public boolean remove(String itemName) {
        return false;
    }

    @Override
    public boolean remove(MenuItem item) {
        return false;
    }

    @Override
    public int removeAll(String itemName) {
        return 0;
    }

    @Override
    public int removeAll(MenuItem item) {
        return 0;
    }

    @Override
    public MenuItem[] sortedItemsByCostDesc() {
        return new MenuItem[0];
    }

    @Override
    public int costTotal() {
        int cost = 0;
        for(int i = 0; i<items.length;i++){
            try{
                cost+=items[i].getCost()*items[i].getValue();
            }catch(NullPointerException ex){

            }
        }
        return cost;
    }

    @Override
    public Customer getCustomer() {
        return customer;
    }

    @Override
    public void setCustomer(Customer customer) {

    }
}
