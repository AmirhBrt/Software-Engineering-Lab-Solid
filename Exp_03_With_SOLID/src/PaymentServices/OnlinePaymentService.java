package PaymentServices;

public class OnlinePaymentService implements PaymentService {
    public void pay(int foodPrice){
        System.out.println("online Payment with Price : " + foodPrice + " Tomans!");
    }
}