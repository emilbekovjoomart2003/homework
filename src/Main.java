import entities.Customer;
import entities.DeliveryCompany;
import entities.Load;
import entities.Order;
import service.DeliveryCompanyService;

public class Main {
    public static void main(String[] args) {
        DeliveryCompanyService deliveryCompanyService = new DeliveryCompanyService();
        DeliveryCompany deliveryCompany = new DeliveryCompany("Taigan");
//        deliveryCompanyService.createDeliveryCompany();
        Load load = new Load();
        load.setWidth(10);
        load.setHeight(10);
        load.setLength(10);
        load.setWeight(10);
        Order order = new Order();
        order.setLoad(load);
        System.out.println(deliveryCompanyService.acceptOrder(deliveryCompany, order));


    }
}