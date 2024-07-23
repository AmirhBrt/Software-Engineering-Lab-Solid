package RegisterServices;

public class OnlineRegisterService implements RegisterService {
    public void register(String customerName){
        System.out.println("Online order registered for " + customerName);
    }
}