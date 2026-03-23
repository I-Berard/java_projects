public class Main {
    public static void main(String[] args) {
        PaymentProcessor payment = new StripeAdapter(1000);
        payment.pay(); //payment.makePayment()
    }
}
