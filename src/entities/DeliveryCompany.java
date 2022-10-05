package entities;

public class DeliveryCompany {
    private String deliveryCompanyName;
    private final double pricePerKilogram = 400;
    private double customer;
    private final double maxCapacityPerCubeSantimeter = 300;

    public DeliveryCompany(String deliveryCompanyName, double customer) {
        this.deliveryCompanyName = deliveryCompanyName;
        this.customer = customer;
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

    public double getCustomer() {
        return customer;
    }

    public void setCustomer(double customer) {
        this.customer = customer;
    }

    public double getMaxCapacityPerCubeSantimeter() {
        return maxCapacityPerCubeSantimeter;
    }
}
