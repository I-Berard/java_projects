public class ShapeAssignment {
    public static class Shape {
        public void area(){
            System.out.println("I can't calculate area");
        }
    }

    public static class Circle extends Shape {
        public Circle(float input){
            radius = input;
        }

        public static float radius;

        public void area(){
            final double pi = 3.1416;
            double answer = radius * 2 * pi;
            System.out.println(answer);
        }
    }

    public static class Rectangle extends Shape {
        public Rectangle(float input1, float input2){
            width = input1;
            length = input2;
        }
        public static double width;
        public static double length;

        public void area(){
            double answer = width * length;
            System.out.println(answer);
        }
    }

    public static void main(String[] args) {
        Rectangle r1 = new Rectangle(4, 6);
        Circle c1 = new Circle(4);

        r1.area();
        c1.area();
    }
}
