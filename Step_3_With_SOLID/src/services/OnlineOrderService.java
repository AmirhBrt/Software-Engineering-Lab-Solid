package services;

import payments.PaymentService;
import payments.OnlinePaymentService;
import registers.RegisterService;
import registers.OnlineRegisterService;

public class OnlineOrderService implements OrderService {
    private PaymentService paymentService;
    private RegisterService registerService;

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
