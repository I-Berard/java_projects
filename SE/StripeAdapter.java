public class StripeAdapter extends PaymentProcessor{
    private StripeAPI stripe;

    public StripeAdapter(double amount){
        super(amount);
        stripe = new StripeAPI(amount);
    }

    @Override
    public void pay(){
        stripe.makePayment();
    }
}