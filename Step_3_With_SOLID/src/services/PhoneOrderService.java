package services;

import payments.PaymentService;
import registers.RegisterService;

public class PhoneOrderService implements OrderService {
    private PaymentService paymentService;
    private RegisterService registerService;

    public PhoneOrderService() {
        this.paymentService = null;
        this.registerService = null;
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
