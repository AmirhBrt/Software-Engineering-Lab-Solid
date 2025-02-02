import OrderServices.OnSiteOrderService;
import OrderServices.OnlineOrderService;
import OrderServices.OrderService;
import OrderServices.PhoneOrderService;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scanner= new Scanner(System.in);
        OrderService orderService = null;
        String customerName;
        Order order;
        int customerAnswerForOrder=0;
        int customerAnswerForPaymentMethod;

        System.out.println("Enter Customer Name : ");
        customerName = scanner.nextLine();
        order = new Order(customerName);

        //Step 1 : Select Order Items
        while (customerAnswerForOrder!=3){
            System.out.println("For Ordering Sandwich enter 1.");
            System.out.println("For Ordering Pizza enter 2.");
            System.out.println("For submit your order enter 3");
            customerAnswerForOrder = scanner.nextInt();
            order.addItem(Food.getFoodByItemNumber(customerAnswerForOrder));
        }

        //Step2 : Select Payment Method
        System.out.println("Enter Your Payment Method (1 for online, 2 for on-site and 3 for phone):");
        customerAnswerForPaymentMethod = scanner.nextInt();
        if(customerAnswerForPaymentMethod==1){
            orderService = new OnlineOrderService();
        } else if(customerAnswerForPaymentMethod==2){
            orderService = new OnSiteOrderService();
        } else if(customerAnswerForPaymentMethod==3){
            orderService = new PhoneOrderService();
        }
        if (orderService == null)
            throw new Exception("Must choose only from [1, 2, 3]!");
        orderService.register(customerName);

        //Step3 : pay price
        System.out.println("Pay Price:");
        orderService.pay(order.getTotalPrice());

        //Finally Print Bill
        System.out.println(order);
    }
}
