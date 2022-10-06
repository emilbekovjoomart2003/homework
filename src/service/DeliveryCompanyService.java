package service;

import entities.Customer;
import entities.DeliveryCompany;
import entities.Order;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DeliveryCompanyService {
    private List<DeliveryCompany> deliveryCompanies = new ArrayList<>();

    public DeliveryCompanyService(List<DeliveryCompany> deliveryCompanies) {
        this.deliveryCompanies = deliveryCompanies;
    }
    public DeliveryCompanyService() {

    }

    public boolean acceptOrder(DeliveryCompany deliveryCompany, Order order) {
        double maxCapacity = deliveryCompany.getMaxCapacityPerCubeSantimeter();
        double orderWeight = order.getLoad().getWeight();
        if (orderWeight <= maxCapacity || maxCapacity == orderWeight || ((orderWeight > maxCapacity) && maxCapacity<=400)) {
            return true;
        } else {
            return false;
        }
    }
    public void createDeliveryCompany(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the name of company: ");
        String name = scanner.nextLine();
//        String nameOfVariable = scanner.nextLine();
        getDeliveryCompanies().add(new DeliveryCompany(name));
    }

    public int getTotalFee(Customer customer){
       int sum = customer.getOrders().stream().map(Order::getOrderFee).reduce(0.0,Double::sum).intValue();
        return sum;
    }
    public int getCompanyProfit(DeliveryCompany deliveryCompany){
        int totalProfit = 0;
        for (int i = 0; i < deliveryCompany.getCustomers().size(); i++) {
            totalProfit += getTotalFee(deliveryCompany.getCustomers().get(i));
        }
        return totalProfit;
    }
    public List<DeliveryCompany> getDeliveryCompanies() {
        return deliveryCompanies;
    }

    public void setDeliveryCompanies(List<DeliveryCompany> deliveryCompanies) {
        this.deliveryCompanies = deliveryCompanies;
    }

}
