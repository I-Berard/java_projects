package creational;

public class OperatingSystemFactory {
    public OS getInstance(String message){
        if(message.contains("closed")){
            return new IOS();
        } else {
            return new Android();
        }
    }
}
