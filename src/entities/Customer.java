package entities;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String customerName;
   private List <Order> orders = new ArrayList<>();

    public Customer(String customerName, List<Order> orders) {
        this.customerName = customerName;
        this.orders = orders;
    }

    public Customer() {

    }
    public Customer(String customerName) {
        this.customerName = customerName;
    }
    public void addOrder(Order order){
        this.orders.add(order);
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return "Customer\n" +
                "customerName = " + customerName + '\n' +
                "orders = " + orders + '\n';
    }
}
