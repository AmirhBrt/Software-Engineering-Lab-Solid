package OrderServices;

import PaymentServices.PaymentService;
import PaymentServices.OnSitePaymentService;
import RegisterServices.RegisterService;
import RegisterServices.OnSiteRegisterService;

public class OnSiteOrderService implements OrderService {
    private final PaymentService paymentService;
    private final RegisterService registerService;

    public OnSiteOrderService() {
        this.paymentService = new OnSitePaymentService();
        this.registerService = new OnSiteRegisterService();
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
