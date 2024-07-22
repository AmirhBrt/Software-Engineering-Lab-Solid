package registers;

public class OnSiteRegisterService implements RegisterService {
    public void register(String customerName){
        System.out.println("on-Site order registered for " + customerName);
    }
}