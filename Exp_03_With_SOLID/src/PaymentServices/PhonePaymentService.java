package PaymentServices;

public class PhonePaymentService implements PaymentService {
    public void pay(int foodPrice){
        System.out.println("Phone Payment with Price : " + foodPrice + " Tomans!");
    }
}