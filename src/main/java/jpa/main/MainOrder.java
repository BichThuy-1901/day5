package jpa.main;

import jpa.config.SpringConfig;
import jpa.entity.OrderDetailEntity;
import jpa.entity.OrderEntity;
import jpa.repository.OrderRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MainOrder {
    static ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
    static OrderRepository orderRepository = (OrderRepository) context.getBean("orderRepository");

    public static void main(String[] args) {
//        createOrder();
//        showList();
        getOrderById(1);
        listOrdersInCurrentMonth(String.valueOf(8));
        listOrdersWithTotalAmountGreaterThan(1000.0);
        listOrdersByProductName("StringBook");
    }
    public static void createOrder(){
        OrderDetailEntity orderDetailEntity1 = new OrderDetailEntity();

        orderDetailEntity1.setQuantity(5);
        orderDetailEntity1.setUnitPrice(1005.0);
        orderDetailEntity1.setProductName("SpringBook");


        List<OrderDetailEntity> orderDetails = new ArrayList<>();

        orderDetails.add(orderDetailEntity1);


        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setOrderDate(LocalDate.parse("2024-08-17"));
        orderEntity.setCustomerName("Bich Thuy");
        orderEntity.setCustomerAddress("Hoi An");
        orderEntity.setOrdersDetailsEntities(orderDetails);
        orderDetailEntity1.setOrders(orderEntity);

        orderRepository.save(orderEntity);
    }
    public static void showList() {
        List<OrderEntity> orders = orderRepository.findAll();
        for (OrderEntity order : orders) {
            System.out.println("Order Date: " + order.getOrderDate());
            System.out.println("Customer Name: " + order.getCustomerName());
            System.out.println("Customer Address: " + order.getCustomerAddress());

            System.out.println("Order Details:");
            for (OrderDetailEntity detail : order.getOrdersDetailsEntities()) {
                System.out.println(" - Product Name: " + detail.getProductName());
                System.out.println("   Quantity: " + detail.getQuantity());
                System.out.println("   Unit Price: " + detail.getUnitPrice());
            }
            System.out.println("-------------");
        }
    }
    public static void getOrderById(int orderId) {
        OrderEntity order = orderRepository.findById(orderId).orElse(null);

        if (order != null) {
            System.out.println("Order Date: " + order.getOrderDate());
            System.out.println("Customer Name: " + order.getCustomerName());
            System.out.println("Customer Address: " + order.getCustomerAddress());

            System.out.println("Order Details:");
            for (OrderDetailEntity detail : order.getOrdersDetailsEntities()) {
                System.out.println("Product Name: " + detail.getProductName());
                System.out.println("Quantity: " + detail.getQuantity());
                System.out.println("Unit Price: " + detail.getUnitPrice());
            }
            System.out.println("-------------");
        } else {
            System.out.println("Order with ID " + orderId + " not found.");
        }
    }
    public static void listOrdersInCurrentMonth(String number) {
        LocalDate now = LocalDate.now();
        List<OrderEntity> orders = orderRepository.findAll();
        orders.stream()
                .filter(order -> order.getOrderDate().getMonth().equals(now.getMonth()) &&
                        order.getOrderDate().getYear() == now.getYear())
                .forEach(order -> {
                    System.out.println("Order Date: " + order.getOrderDate());
                    System.out.println("Customer Name: " + order.getCustomerName());
                    System.out.println("Customer Address: " + order.getCustomerAddress());
                    System.out.println("-------------");
                });
    }
    public static void listOrdersWithTotalAmountGreaterThan(double amount) {
        List<OrderEntity> orders = orderRepository.findAll();
        orders.stream()
                .filter(order -> order.getOrdersDetailsEntities().stream()
                        .mapToDouble(detail -> detail.getUnitPrice() * detail.getQuantity())
                        .sum() > amount)
                .forEach(order -> {
                    System.out.println("Order Date: " + order.getOrderDate());
                    System.out.println("Customer Name: " + order.getCustomerName());
                    System.out.println("Customer Address: " + order.getCustomerAddress());
                    System.out.println("-------------");
                });
    }
    public static void listOrdersByProductName(String productName) {
        List<OrderEntity> orders = orderRepository.findAll();
        orders.stream()
                .filter(order -> order.getOrdersDetailsEntities().stream()
                        .anyMatch(detail -> detail.getProductName().equalsIgnoreCase(productName)))
                .forEach(order -> {
                    System.out.println("Order Date: " + order.getOrderDate());
                    System.out.println("Customer Name: " + order.getCustomerName());
                    System.out.println("Customer Address: " + order.getCustomerAddress());
                    System.out.println("-------------");
                });
    }

}
