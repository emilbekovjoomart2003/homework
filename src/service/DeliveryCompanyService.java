package service;

import entities.Customer;
import entities.DeliveryCompany;
import entities.Load;
import entities.Order;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class DeliveryCompanyService {
    private List<DeliveryCompany> deliveryCompanies = new ArrayList<>();
    private List<Customer> customersDataBase = new ArrayList<>();

    public DeliveryCompanyService() {}

    public List<DeliveryCompany> getDeliveryCompanies() {
        return deliveryCompanies;
    }

    public List<Customer> getCustomersDataBase() {
        return customersDataBase;
    }

    public void createDeliveryCompany(String delivCompanyName) {
        DeliveryCompany deliveryCompany = new DeliveryCompany(delivCompanyName);
        deliveryCompanies.add(deliveryCompany);
        System.out.println("A new Delivery company " + delivCompanyName + " was created");
    }

    public void createCustomer(String customerName) {
        Customer customer = new Customer(customerName);
        customersDataBase.add(customer);
        System.out.println("A new Customer " + customerName + " was created");
    }

    public Load addLoad(double height, double width, double length, double weight) {
        Load load = new Load(height, width, length, weight);
        return load;
    }

    public void createOrder(String customerName, Load load) {
        Order order = new Order(load);
        Customer customer = getCustomersDataBase().stream().filter(x -> x.getCustomerName().equals(customerName)).findAny().orElse(null);
        if (customer == null) {
            try {
                throw new Exception("The entered client was not found.");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } else {
            customer.setOrder(order);
        }
    }

    public void acceptOrder(String customerName, String delivCompanyName) {
        Customer customer = getCustomersDataBase().stream().filter(x -> x.getCustomerName().equals(customerName)).findAny().orElse(null);
        if (customer == null) {
            try {
                throw new Exception("The entered client was not found.");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } else {
            DeliveryCompany delivComp = getDeliveryCompanies().stream().filter(x -> x.getDeliveryCompanyName().equals(delivCompanyName)).findAny().orElse(null);
            if (delivComp == null) {
                try {
                    throw new Exception("The entered Delivery company was not found.");
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            } else {
                if (customer.getOrder() != null) {
                    Order order = customer.getOrder();
                    Load load = order.getLoad();
                    double maxCapacity = delivComp.getMaxCapacityPerCubeCentimeter();
                    if ((load.getHeight() * load.getWidth() * load.getLength()) <= maxCapacity) {
                        order.setOrderFee(delivComp.getPricePerKilogram() * load.getWeight());
                        delivComp.getCustomers().add(customer);
                    } else {
                        System.out.println("Sorry, but your load is too big");
                    }
                } else {
                    System.out.println("Sorry, but firstly create an order by Customer");
                }
            }
        }
    }

    public double getTotalFee(String nameOfCustomer) {
        double totalFee = 0;
        Customer customer = getCustomersDataBase().stream().filter(x -> x.getCustomerName().equals(nameOfCustomer)).findAny().orElse(null);
        if (customer == null) {
            try {
                throw new Exception("The entered client was not found.");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } else {
            if (customer.getOrder() != null) {
                totalFee = customer.getOrder().getOrderFee();
            }
        }
        return totalFee;
    }

    public double getCompanyProfit(String delivCompName) {
        double profitAmount = 0;
        DeliveryCompany deliveryCompany = getDeliveryCompanies().stream().filter(x -> x.getDeliveryCompanyName().equals(delivCompName)).findAny().orElse(null);
        if (deliveryCompany == null) {
            try {
                throw new Exception("The entered Delivery company was not found.");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } else {
            if (deliveryCompany.getCustomers() != null) {
                profitAmount = deliveryCompany.getCustomers().stream().map(x -> x.getOrder().getOrderFee()).reduce((double) 0, (a1, a2) -> a1 + a2);
            }
        }
        return profitAmount;
    }
}
