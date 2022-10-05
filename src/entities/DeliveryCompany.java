package entities;

public class DeliveryCompany {
    private String deliveryCompanyName;
    private final double pricePerKiloger=400;
    private double customer;
    private final double maxCapacityPerSguareCentimeter=300;

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

    public double getPricePerKiloger() {
        return pricePerKiloger;
    }

    public double getCustomer() {
        return customer;
    }

    public void setCustomer(double customer) {
        this.customer = customer;
    }

    public double getMaxCapacityPerSguareCentimeter() {
        return maxCapacityPerSguareCentimeter;
    }
}
