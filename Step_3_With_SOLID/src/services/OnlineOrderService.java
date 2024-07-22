package services;

public class OnlineOrderService implements OrderService {
    @Override
    public void register(String customerName) {
        System.out.println("online order registered for " + customerName);
    }

    @Override
    public void pay(int foodPrice) {
        System.out.println("online Payment with Price : " + foodPrice + " Tomans!");
    }
}
