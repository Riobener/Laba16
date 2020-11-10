package InternetOrders;

import Client_info.Customer;
import Items.MenuItem;
import com.company.Order;

import java.util.HashMap;
import java.util.concurrent.ThreadLocalRandom;

public class InternetOrder implements Order {

    // Заказчик
    private Customer customer;

    // Кол-во заказов
    private int size;

    // Начало списка заказов
    private ListNode head;

    // Конец списка заказов
    private ListNode tail;
    private int orderNumber;

    class ListNode {
        private ListNode next;
        private MenuItem value;


        public ListNode(MenuItem value) {
            this(value, null);
        }

        public ListNode(MenuItem value, ListNode next) {
            this.next = next;
            this.value = value;

        }
    }

    public InternetOrder(Customer customer, int orderNumber) {
        size = 0;
        head = null;
        tail = null;
        this.customer = customer;
        this.orderNumber = orderNumber;
    }
    public int getOrderNumber(){
        return orderNumber;
    }
    @Override
    public Customer getCustomer() {
        return customer;
    }

    @Override
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public boolean add(MenuItem item) {
        size++;
        ListNode new_node = new ListNode(item);
        if (head == null)
            head = new_node;
        else
            tail.next = new_node;
        tail = new_node;
        return true;
    }

    @Override
    public String[] itemsNames() {
        String[] array = new String[size];
        ListNode current = head;
        for (int i = 0; current != null && i < size; i++) {
            array[i] = current.value.getName();
            current = current.next;
        }
        return array;
    }

    @Override
    public int itemsQuantity() {
        return size;
    }

    @Override
    public int itemQuantity(String itemName) {
        ListNode current = head;
        int count = 0;
        while (current != null) {
            if (current.value.getName().equals(itemName))
                count++;
            current = current.next;
        }
        return count;
    }

    @Override
    public int itemQuantity(MenuItem item) {
        ListNode current = head;
        int count = 0;
        while (current != null) {
            if (current.value.equals(item))
                count++;
            current = current.next;
        }
        return count;
    }

    @Override
    public MenuItem[] getItems() {
        MenuItem[] array = new MenuItem[size];
        ListNode current = head;
        for (int i = 0; current != null && i < size; i++) {
            array[i] = current.value;
            current = current.next;
        }
        return array;
    }

    @Override
    public boolean remove(String itemName) {
        ListNode current = head, previous = null;
        while (current != null && !current.value.getName().equals(itemName)) {
            previous = current;
            current = current.next;
        }
        return remove(current, previous);
    }

    private boolean remove(ListNode current, ListNode previous) {
        if (current != null) {
            size--;
            if (previous != null) {
                previous.next = current.next;
                if (current.next == null)
                    tail = previous;
            }
            else head = current.next;
            return true;
        }
        return false;
    }

    @Override
    public boolean remove(MenuItem item) {
        ListNode current = head, previous = null;
        while (current != null && !current.value.equals(item)) {
            previous = current;
            current = current.next;
        }
        return remove(current, previous);
    }

    @Override
    public int removeAll(String itemName) {
        int count = 0;
        while (remove(itemName))
            count++;
        return count;
    }

    @Override
    public int removeAll(MenuItem item) {
        int count = 0;
        while (remove(item))
            count++;
        return count;
    }

    @Override
    public MenuItem[] sortedItemsByCostDesc() {
        MenuItem[] array = getItems();
        boolean is_swapped = false;
        for (int i = 0; i < size; i++) {
            for (int j = i; j < size - 1; j++) {
                if (array[j].getCost() < array[j + 1].getCost()) {
                    is_swapped = true;
                    MenuItem swap = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = swap;
                }
            }
            if (!is_swapped)
                return array;
        }
        return array;
    }

    @Override
    public int costTotal() {
        double sum = 0;
        ListNode current = head;
        while (current != null) {
            sum += current.value.getCost();
            current = current.next;
        }
        return (int) sum;
    }
}