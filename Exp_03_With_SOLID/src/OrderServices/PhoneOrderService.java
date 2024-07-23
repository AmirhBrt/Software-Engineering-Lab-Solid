package OrderServices;

import PaymentServices.PaymentService;
import PaymentServices.PhonePaymentService;
import RegisterServices.RegisterService;
import RegisterServices.PhoneRegisterService;

public class PhoneOrderService implements OrderService {
    private final PaymentService paymentService;
    private final RegisterService registerService;

    public PhoneOrderService() {
        this.paymentService = new PhonePaymentService();
        this.registerService = new PhoneRegisterService();
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
