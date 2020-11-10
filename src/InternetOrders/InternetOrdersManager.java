package InternetOrders;

import Items.MenuItem;
import com.company.Order;
import com.company.OrdersManager;

public class InternetOrdersManager implements OrdersManager {

    // Начало списка заказов
    private QueueNode head;

    // Конец списка заказов
    private QueueNode tail;

    // Размер списка
    private int size;

    public InternetOrdersManager() {
        size = 0;
        head = null;
        tail = null;
    }

    public boolean addOrder(Order order) {
        size++;
        if (tail == null) {
            tail = new QueueNode(order);
            head = tail;
            return true;
        }
        tail.next = new QueueNode(order, tail, null);
        tail = tail.next;
        return true;
    }

    public void deleteOrder(int numberOrder) {
        QueueNode current = head;
        while (current != null && current.value.getOrderNumber()!= numberOrder) {
            current = current.next;
        }
        deleteNode(current);
        // Note: We silently do nothing if 'data' not found
    }
    private void deleteNode(QueueNode node) {
        if (node != null) {
            // Here we can rely on 'node' actually being in our list
            if (node.previous != null)
                node.previous.next = node.next;
            else
                head = node.next;
            if (node.next != null)
                node.next.previous = node.previous;
            else
                tail = node.previous;
        }
    }

    public Order getOrder(int value) {
        int i = 1;
        boolean flag = false;
        //Node current will point to head
        QueueNode current = head;

        //Checks whether the list is empty
        if(head == null) {
            System.out.println("List is empty");
            return null;
        }
        while(current != null) {
            //Compare value to be searched with each node in the list
            if(current.value.getOrderNumber() == value) {
                flag = true;
                break;
            }
            current = current.next;
            i++;
        }
        return current.value;
    }

    @Override
    public int itemsQuantity(String itemName) {
        int count = 0;
        QueueNode current = head;
        while (current != null) {
            count += current.value.itemQuantity(itemName);
            current = current.next;
        }
        return count;
    }

    @Override
    public int itemsQuantity(MenuItem item) {
        int count = 0;
        QueueNode current = head;
        while (current != null) {
            count += current.value.itemQuantity(item);
            current = current.next;
        }
        return count;
    }

    @Override
    public Order[] getOrders() {
        Order[] array = new Order[size];
        QueueNode current = head;
        for (int i = 0; current != null && i < size; i++) {
            array[i] = current.value;
            current = current.next;
        }
        return array;
    }

    @Override
    public int ordersCostSummary() {
        int sum = 0;
        QueueNode current = head;
        for (int i = 0; current != null && i < size; i++) {
            sum += current.value.costTotal();
            current = current.next;
        }
        return sum;
    }

    @Override
    public int ordersQuantity() {
        int count = 0;
        QueueNode current = head;
        for (int i = 0; current != null && i < size; i++) {
            count += current.value.itemsQuantity();
            current = current.next;
        }
        return count;
    }

    class QueueNode {
        public QueueNode next;
        public QueueNode previous;
        public Order value;

        public QueueNode(Order value, QueueNode previous, QueueNode next) {
            this.value = value;
            this.next = next;
            this.previous = previous;
        }

        public QueueNode(Order value) {
            this(value, null, null);
        }
    }
}