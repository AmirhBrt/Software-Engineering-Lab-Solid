package services;

import payments.PaymentService;
import payments.OnSitePaymentService;
import registers.RegisterService;
import registers.OnSiteRegisterService;

public class OnSiteOrderService implements OrderService {
    private PaymentService paymentService;
    private RegisterService registerService;

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
