public class BankAssignment {
    public static class BankAccount {
        public static int interestRate = 23;

        public void calculate(){
            int interest = (2000 * interestRate * 2) / 12;
            System.out.println(interest); 
        }
    }

    public static void main(String[] args) {
        BankAccount b1 = new BankAccount();
        b1.calculate();

        BankAccount.interestRate = 25; 

        BankAccount b2 = new BankAccount();
        b2.calculate();

        BankAccount b3 = new BankAccount();
        b3.calculate();
    }
}
