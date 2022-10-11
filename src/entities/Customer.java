package entities;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String customerName;
    private Order order;

    public Customer() {
    }

    public Customer(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    @Override
    public String toString() {
        String s1 = String.format("%-12s|", customerName);
        String s2 = String.format("%-20s", order);
        return s1 + s2;
    }
}
