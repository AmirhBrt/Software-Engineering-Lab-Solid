package RegisterServices;

public class PhoneRegisterService implements RegisterService {
    public void register(String customerName){
        System.out.println("Phone order registered for " + customerName);
    }
}