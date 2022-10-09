import entities.Customer;
import entities.DeliveryCompany;
import entities.Load;
import entities.Order;
import service.DeliveryCompanyService;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        DeliveryCompanyService deliveryCompanyService = new DeliveryCompanyService();
        while (true) {
            options();
            System.out.println("Choose the button:");
            String word = scanner.nextLine();
            switch (word) {
                case "1" -> {
                    deliveryCompanyService.createDeliveryCompany();
                }
                case "2" -> {
                    deliveryCompanyService.createCustomer();
                }
                case "3" -> {

                    deliveryCompanyService.acceptOrder();
                }
                case "4" -> {
                    try {
                        System.out.println("Enter the name of customer:");
                        System.out.println(deliveryCompanyService.getTotalFee(scanner.nextLine()));
                    } catch (NoSuchElementException e) {
                        System.out.println("There is no customer with this name");
                    }
                }
                case "5" -> {
                    try {
                        System.out.println("Enter the company's name:");
                        System.out.println(deliveryCompanyService.getCompanyProfit(scanner.nextLine()));
                    } catch (NoSuchElementException e) {
                        System.out.println("No such company");
                    }

                }
                case "6" -> {
                    System.out.println(deliveryCompanyService.getDeliveryCompanies().toString());
                }
                case "7" -> {
                    System.out.println(deliveryCompanyService.getCustomersDataBase().toString());
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
        System.out.println("Press 2 to create customer");
        System.out.println("Press 3 to accept order");
        System.out.println("Press 4 to get sum of total fees of exact customer");
        System.out.println("Press 5 to get company's profit");
        System.out.println("Press 6 to show all companies");
        System.out.println("Press 7 to show all customers");
        System.out.println("Press x to finish program");
        System.out.println("-------------------------------");
    }
}