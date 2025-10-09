package account;
import java.io.Console;
import exceptions.Exceptions.InsufficientBalance;
import exceptions.Exceptions.InvalidAmount;

public class Accounts {
    public static class Person{
        public int id;
        public String name;
        public String dob;

        public Person(int id, String name, String dob){
            this.id = id;
            this.name = name;
            this.dob = dob;
        }
    }

    public static class Account extends Person{
        private String accountNumber;
        private double balance;

        public Account(int id, String name, String dob, String accNumber, double balance){
            super(id, name, accNumber);
            this.accountNumber = accNumber;
            this.balance = balance;
        }

        public String getAccountNumber() {
            return accountNumber;
        }

        public void setAccountNumber(String accountNumber) {
            this.accountNumber = accountNumber;
        }

        public void setBalance(double balance) {
            this.balance = balance;
        }

        public double getBalance() {
            return balance;
        }

        public void withDraw(double amount){          
            if(amount > getBalance()){
                throw new InsufficientBalance("The amount is greater than balance " + getBalance());
                return;
            }

            if(amount <= 0){
                throw new InvalidAmount("Invalid amount");
                return;
            }

            this.balance = this.balance - amount;
            System.out.println("Withdrawal of " + amount + " from " + getAccountNumber() + " is successfull. Left with " + getBalance());
            
        }

        public void deposit(double amount){            
            if(amount <= 0){
                throw new InvalidAmount("Invalid amount");
                return;
            }

            this.balance += amount;
            System.out.println("Deposited " + amount + " to bank account " + getAccountNumber() + " left with " + getBalance());
        }

        @Override
        public String toString(){
            return "You are " + this.name + ", Your bank account number is " + getAccountNumber() + ", and your balance is " + getBalance();
        }
    }    
}
