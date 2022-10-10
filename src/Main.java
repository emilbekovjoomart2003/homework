import entities.Customer;
import entities.DeliveryCompany;
import entities.Load;
import entities.Order;
import service.DeliveryCompanyService;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {
    public static Scanner scannerS = new Scanner(System.in);
    public static Scanner scannerN = new Scanner(System.in);

    public static void main(String[] args) {
        DeliveryCompanyService deliveryCompanyService = new DeliveryCompanyService();
        options();
        while (true) {
            System.out.print("Choose the button: ");
            String word = scannerS.nextLine();
            switch (word) {
                case "1": {
                    System.out.print("Enter the name of Delivery company: ");
                    String delivCompanyName = scannerS.nextLine();
                    deliveryCompanyService.createDeliveryCompany(delivCompanyName);
                    break;
                }
                case "2": {
                    System.out.print("Enter the name of customer: ");
                    String customerName = scannerS.nextLine();
                    deliveryCompanyService.createCustomer(customerName);
                    break;
                }
                case "3": {
                    System.out.print("Enter the name of Customer: ");
                    String nameOfCustomer = scannerS.nextLine();
                        System.out.print("Enter the height of load: ");
                        double height = scannerN.nextDouble();
                        System.out.print("Enter the width of load: ");
                        double width = scannerN.nextDouble();
                        System.out.print("Enter the length of load: ");
                        double length = scannerN.nextDouble();
                        System.out.print("Enter the weight of load in kg: ");
                        double weight = scannerN.nextDouble();
                    Load load = deliveryCompanyService.addLoad(height, width, length, weight);
                    deliveryCompanyService.createOrder(nameOfCustomer, load);
                    break;
                }
                case "4": {
                    System.out.print("Enter the name of Customer: ");
                    String nameOfCustomer = scannerS.nextLine();
                    System.out.print("Enter the name of delivery company: ");
                    String nameOfDelivCompany = scannerS.nextLine();
                    deliveryCompanyService.acceptOrder(nameOfCustomer, nameOfDelivCompany);
                    break;
                }
                case "5": {
                    System.out.print("Enter the name of Customer: ");
                    String nameOfCustomer = scannerS.nextLine();
                    System.out.println("The total fee is: " + deliveryCompanyService.getTotalFee(nameOfCustomer));
                    break;
                }
                case "6": {
                    System.out.print("Enter the name of delivery company: ");
                    String nameOfDelivCompany = scannerS.nextLine();
                    System.out.println("The total profit of Delivery Company: " + deliveryCompanyService.getCompanyProfit(nameOfDelivCompany));
                    break;
                }
                case "7": {
                    System.out.println(" CompanyName| PricePerKg | MaxPerCubSm| Customers              ");
                    deliveryCompanyService.getDeliveryCompanies().stream().forEach(System.out::println);
                    break;
                }
                case "8": {
                    System.out.println(" CustomName | Orders              ");
                    deliveryCompanyService.getCustomersDataBase().stream().forEach(System.out::println);
                    break;
                }
            }
            if (word.equals("x")) {
                break;
            }
        }
    }

    static void options() {
        System.out.println("----------Commands------------");
        System.out.println("Press 1 to create Delivery Company");
        System.out.println("Press 2 to create Customer");
        System.out.println("Press 3 to create order by Customer");
        System.out.println("Press 4 to place an order to Delivery company");
        System.out.println("Press 5 to get sum of total fees of exact customer");
        System.out.println("Press 6 to get company's profit");
        System.out.println("Press 7 to show all companies");
        System.out.println("Press 8 to show all customers");
        System.out.println("Press x to finish program");
        System.out.println("-------------------------------");
    }
}