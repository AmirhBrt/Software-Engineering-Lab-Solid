package PaymentServices;

public class OnSitePaymentService implements PaymentService {
    public void pay(int foodPrice){
        System.out.println("on-Site Payment with Price : " + foodPrice + " Tomans!");
    }
}