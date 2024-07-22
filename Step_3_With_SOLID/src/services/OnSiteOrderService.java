package services;

public class OnSiteOrderService implements OrderService {
    @Override
    public void register(String customerName) {
        System.out.println("on-Site order registered for " + customerName);
    }

    @Override
    public void pay(int foodPrice) {
        System.out.println("on-Site Payment with Price : " + foodPrice + " Tomans!");
    }
}
