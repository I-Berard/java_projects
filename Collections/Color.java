public class Color {
    private static class Shape{
        String name;

        Shape(){
            this.name = "shape";
        }

        public void getName(){
            System.out.println("THis is a shape");
        }
    }

    public static class Circle extends Shape{
        String name;

        Circle(){
            this.name = "circle";
        }

        public void getName(){
            System.out.println("THis is a circle");
        }
    }

    public static class Triangle extends Shape{
        String name;

        Triangle(){
            this.name = "triangle";
        }
    
        public void getName(){
            System.out.println("THis is a triangle");
        }

        public void print(){
            System.out.println(name);
        }
    }

    public static void main(String[] args) {
        // Triangle tr1 = new Triangle();
        // tr1.getName();

        Triangle tr2 = new Triangle();
        Shape s = (Shape)tr2;
        s.getName();

        Shape shape = new Triangle();
        Triangle triangle = (Triangle)shape;
        triangle.getName();

        // ((Triangle) tr2).print();
    }
}
