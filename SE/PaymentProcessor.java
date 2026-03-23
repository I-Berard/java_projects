public class PaymentProcessor{
    private double amount;
    public PaymentProcessor(double amount){
        this.amount = amount;
    }

    public void pay(){
        System.out.println("Paying " + amount);
    }
}

class StripeAPI {
    private double amount;
    public StripeAPI(double amount){
        this.amount = amount;
    }

    public void makePayment(){
        System.out.println("Paying " + amount + " using Stripe");
    }
}

