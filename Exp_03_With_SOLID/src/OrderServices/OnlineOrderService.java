package OrderServices;

import PaymentServices.PaymentService;
import PaymentServices.OnlinePaymentService;
import RegisterServices.RegisterService;
import RegisterServices.OnlineRegisterService;

public class OnlineOrderService implements OrderService {
    private final PaymentService paymentService;
    private final RegisterService registerService;

    public OnlineOrderService() {
        this.paymentService = new OnlinePaymentService();
        this.registerService = new OnlineRegisterService();
    }

    @Override
    public void register(String customerName) {
        this.registerService.register(customerName);
    }

    @Override
    public void pay(int foodPrice) {
        this.paymentService.pay(foodPrice);
    }
}
