package services;

import payments.PaymentService;
import payments.PhonePaymentService;
import registers.RegisterService;
import registers.PhoneRegisterService;

public class PhoneOrderService implements OrderService {
    private PaymentService paymentService;
    private RegisterService registerService;

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
