package exceptions;

public class Exceptions {
    public class InvalidAmount extends Exception {
        public InvalidAmount(String string){
            super(string);
        }
    }

    public class InsufficientBalance extends Exception {
        public InsufficientBalance(String string){
            super(string);
        }

    }
}
