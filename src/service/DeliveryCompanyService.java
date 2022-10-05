package service;

import entities.DeliveryCompany;
import entities.Order;

public class DeliveryCompanyService {
    private DeliveryCompany deliveryCompany;

    public DeliveryCompanyService(DeliveryCompany deliveryCompany) {
        this.deliveryCompany = deliveryCompany;
    }

    public boolean acceptOrder(DeliveryCompany deliveryCompany, Order order) {
        double maxCapacity = deliveryCompany.getMaxCapacityPerCubeSantimeter();
        double orderWeight = order.getLoad().getWeight() / 1000000;
        if (orderWeight <= maxCapacity) {
            return true;
        } else {
            return false;
        }
    }
}
