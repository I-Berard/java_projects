package creational;

public class Browser {
    private static Browser browser;

    private Browser() {}

    public static Browser getInstance(){
        if(browser == null) return new Browser();
        return browser;
    }

    public void display(){
        System.out.println("info.....");
    }

}
