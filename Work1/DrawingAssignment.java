public class DrawingAssignment {
    public static class Shape {
        public void draw(){
            System.out.println("I'm drawing a shape");
        }
    }

    public static class Circle extends Shape {
        public void draw(){
            System.out.println("I'm drawing a circle");
        }
    }

    public static class Square extends Shape {
        public void draw(){
            System.out.println("I'm drawing a square");
        }
    }

    public static class Triangle extends Shape {
        public void draw(){
            System.out.println("I'm drawing a triangle");
        }
    }

    public static void main(String[] args) {
        Circle c1 = new Circle();
        Square s1 = new Square();
        Triangle t1 = new Triangle();

        Shape array[] = {c1, s1, t1};

        for (Shape i : array){
            i.draw();
        }
    }
}
