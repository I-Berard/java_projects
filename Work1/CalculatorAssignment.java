public class CalculatorAssignment {
    public static class Calculator {
        public void add(int a, int b){
            System.out.println(a + b);
        }

        public void add(double a, double b){
            System.out.println(a + b);
        }

        public void add(int a, int b, int c){
            System.out.println(a + b + c);
        }
    }

    public static void main(String[] args) {
        Calculator c1 = new Calculator();

        c1.add(2, 3);
        c1.add(2.1, 4.1);
        c1.add(3, 5, 6);
    }
}
