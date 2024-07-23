package OrderServices;

public interface OrderService {
    void register(String customerName);
    void pay(int foodPrice);
}