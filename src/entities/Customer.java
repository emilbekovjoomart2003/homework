package entities;

import java.util.List;

public class Customer {
    private String customerName;
    public List<Order> orders;

    public Customer(String customerName, List<Order> orders) {
        this.customerName = customerName;
        this.orders = orders;
    }

    public Customer() {
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
}
