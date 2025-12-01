class BankAccount {
    public double balance;
    public String name;
    final double MAX_BALANCE = 1200;
    
    public BankAccount(double balance, String name) {
        this.balance = balance;
        this.name = name;
    }

    public synchronized double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }  
    
    public synchronized void withdraw(double amount){
        if(amount <= 0){
            System.err.println("Withdraw an accepted amount");
            return;
        }

        while(this.balance < amount){
            try {
                wait(20);
                System.out.println("Waiting for withdrawal");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.balance -= amount;
        notifyAll();
    }

    public synchronized void deposit(double amount){
        while(balance + amount > MAX_BALANCE){
            try {
                wait(20);
                System.out.println("Waiting for depositing...");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.balance += amount;
        notifyAll();    
    }
}

class Deposit implements Runnable{
    BankAccount b;
    double amount;

    public Deposit(BankAccount b, double amount) {
        this.b = b;
        this.amount = amount;
    }

    public void run(){
        for(int i = 0; i < 10; i++){
            b.deposit(amount);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    
}

class Withdraw implements Runnable{
    BankAccount b;
    double amount;

    public Withdraw(BankAccount b, double amount){
        this.b = b;
        this.amount = amount;
    }

    public void run(){
        for(int i = 0; i < 10; i++){
            b.withdraw(amount);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class BankAccountMain {
    public static void main(String[] args) throws InterruptedException {
        BankAccount b1 = new BankAccount(1000, "Berard");
        Thread t2 = new Thread(new Deposit(b1, 20));
        Thread th2 = new Thread(new Deposit(b1, 20));

        Thread t1 = new Thread(new Withdraw(b1, 10));
        Thread th1 = new Thread(new Withdraw(b1, 10));

        t1.start();
        th1.start();

        t2.start();
        th2.start();
        
        t2.join();
        t1.join();
        th1.join();
        th2.join();
        
        System.out.println("The final balance " + b1.getBalance());
    }
}