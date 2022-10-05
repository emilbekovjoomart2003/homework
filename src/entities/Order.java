package entities;

public class Order {

    private double orderFree;
    private Load load;

    public Order(double orderFree, Load load) {
        this.orderFree = orderFree;
        this.load = load;
    }

    public Order() {
    }

    public double getOrderFree() {
        return orderFree;
    }

    public void setOrderFree(double orderFree) {
        this.orderFree = orderFree;
    }

    public Load getLoad() {
        return load;
    }

    public void setLoad(Load load) {
        this.load = load;
    }
}
