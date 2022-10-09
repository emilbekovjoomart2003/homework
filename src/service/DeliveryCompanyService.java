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
    private List<Load> loadDataBase = new ArrayList<>();

    public DeliveryCompanyService(List<DeliveryCompany> deliveryCompanies) {
        this.deliveryCompanies = deliveryCompanies;
    }

    static Scanner scannerS = new Scanner(System.in);
    static Scanner scannerN = new Scanner(System.in);

    public DeliveryCompanyService() {

    }

    public void acceptOrder() {
        System.out.println("Enter the name of delivery company:");
        String nameOfDeliveryCompany = scannerS.nextLine();
        DeliveryCompany deliveryCompany = getDeliveryCompanies().stream().filter(x -> x.getDeliveryCompanyName().equals(nameOfDeliveryCompany)).findFirst().get();
        Order order = new Order(addLoad());
        order.setOrderFee(deliveryCompany.getPricePerKilogram() * order.getLoad().getWeight());
        double maxCapacity = deliveryCompany.getMaxCapacityPerCubeCentimeter();
        System.out.println("Enter the name of customer:");
        String nameOfCustomer = scannerS.nextLine();
        if ((order.getLoad().getHeight()) * (order.getLoad().getWidth()) * (order.getLoad().getLength()) <= maxCapacity) {
            Customer customer = getCustomersDataBase().stream().filter(x -> x.getCustomerName().equals(nameOfCustomer)).findFirst().get();
            customer.addOrder(order);
            deliveryCompany.getCustomers().add(customer);
        } else {
            System.out.println("Sorry, but your load is too big");
        }
    }

    public Load addLoad() {
        System.out.println("Enter the height of load");
        double height = scannerN.nextDouble();
        System.out.println("Enter the width of load");
        double width = scannerN.nextDouble();
        System.out.println("Enter the length of load");
        double length = scannerN.nextDouble();
        System.out.println("Enter the weight of load in kg");
        double weight = scannerN.nextDouble();
        getLoadDataBase().add(new Load(height, width, length, weight));
        return getLoadDataBase().stream().filter(x -> x.getHeight() == height && x.getWidth() == width && x.getLength() == length && x.getWeight() == weight)
                .findFirst().get();
    }
    public void createDeliveryCompany() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the name of company: ");
        String name = scanner.nextLine();
        getDeliveryCompanies().add(new DeliveryCompany(name));
    }

    public void createCustomer() {
        System.out.println("Enter the name of customer:");
        String name = scannerS.nextLine();
        getCustomersDataBase().add(new Customer(name));
    }

    public double getTotalFee(String nameOfCustomer) {
        Customer customer = getCustomersDataBase().stream().filter(x -> x.getCustomerName().equals(nameOfCustomer)).findFirst().get();
        double sum = customer.getOrders().stream().mapToDouble(x -> x.getOrderFee()).reduce(0.0, Double::sum);
        return sum;
    }

    public double getCompanyProfit(String deliveryCompanyName) {
        DeliveryCompany deliveryCompany = getDeliveryCompanies().stream().filter(x -> x.getDeliveryCompanyName().equals(deliveryCompanyName)).findFirst().get();
        double numberOfCustomerWhichPaid = deliveryCompany.getCustomers().stream().map(x -> x.getOrders().stream().mapToDouble(a -> a.getOrderFee()).reduce(0.0, Double::sum)).count();
        int sum = 0;
        for (int i = 0; i < numberOfCustomerWhichPaid; i++) {
            sum += deliveryCompany.getCustomers().get(i).getOrders().stream().mapToDouble(x -> x.getOrderFee()).reduce(0.0, Double::sum);
        }
        return sum;
    }

    public List<DeliveryCompany> getDeliveryCompanies() {
        return deliveryCompanies;
    }

    public void setDeliveryCompanies(List<DeliveryCompany> deliveryCompanies) {
        this.deliveryCompanies = deliveryCompanies;
    }

    public List<Customer> getCustomersDataBase() {
        return customersDataBase;
    }

    public void setCustomers(List<Customer> customersDataBase) {
        this.customersDataBase = customersDataBase;
    }

    public void setCustomersDataBase(List<Customer> customersDataBase) {
        this.customersDataBase = customersDataBase;
    }

    public List<Load> getLoadDataBase() {
        return loadDataBase;
    }

    public void setLoadDataBase(List<Load> loadDataBase) {
        this.loadDataBase = loadDataBase;
    }

    @Override
    public String toString() {
        return "DeliveryCompanyService{" +
                "deliveryCompanies=" + deliveryCompanies +
                ", customersDataBase=" + customersDataBase +
                ", loadDataBase=" + loadDataBase +
                '}';
    }
}
