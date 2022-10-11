package entities;

import java.util.ArrayList;
import java.util.List;

public class DeliveryCompany {
    private String deliveryCompanyName;
    private final double pricePerKilogram = 400;
    private List<Customer> customers = new ArrayList<>();
    private final double maxCapacityPerCubeCentimeter = 300;

    public DeliveryCompany(String deliveryCompanyName) {
        this.deliveryCompanyName = deliveryCompanyName;
    }

    public String getDeliveryCompanyName() {
        return deliveryCompanyName;
    }

    public void setDeliveryCompanyName(String deliveryCompanyName) {
        this.deliveryCompanyName = deliveryCompanyName;
    }

    public double getPricePerKilogram() {
        return pricePerKilogram;
    }

    public double getMaxCapacityPerCubeCentimeter() {
        return maxCapacityPerCubeCentimeter;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    @Override
    public String toString() {
        String s1 = String.format("%-12s|", deliveryCompanyName);
        String s2 = String.format("%-12s|", pricePerKilogram);
        String s3 = String.format("%-12s|", maxCapacityPerCubeCentimeter);
        String s4 = String.format("%-20s", customers.stream().map(x -> x.getCustomerName()).toList());
        return s1 + s2 + s3 + s4;
    }
}


