public class Payment {
    abstract static class PaymentGateway {
        abstract void pay();
    }   

    public static class MasterCard extends PaymentGateway {
        public void pay(){
            System.out.println("I'm using mastercard");
        }
    }

    public static class PayPal extends PaymentGateway {
        public void pay(){
            System.out.println("I'm using PayPal");
        }
    }

    public static class MoMo extends PaymentGateway {
        public void pay(){
            System.out.println("I'm using MoMo");
        }
    }

    public static class Gateway {
        private PaymentGateway pay;
        public void Pay(PaymentGateway p){
            this.pay = p;
        }

        public void pay(){
            this.pay.pay();
        }
    }
    public static void main(String[] args) {
        MasterCard m1 = new MasterCard();
        PayPal p1 = new PayPal();
        MoMo mo = new MoMo();

        Gateway g1 = new Gateway();
        g1.Pay(m1);
    }
}
