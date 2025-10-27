public class Color {
    public static class Shape{
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
            System.out.println("THis is a triable");
        }
    }

    public static void main(String[] args) {
        Triangle tr1 = new Triangle();
        tr1.getName();

        Shape tr2 = new Triangle();
        tr2.getName();
    }
}
