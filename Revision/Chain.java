// package Revision;

public class Chain {
    record Point(int x, int y) {
        
        public Point moveX(int dx){
            return new Point(x + dx, x);
        }

        public Point moveY(int dy){
            return new Point(x , y + dy);
        }

        // public void printStuff(){
        //     System.out.printf("These are the results %d, %d", x, y);
        // }
    }

    public static void main(String[] args) {
        Point point = new Point(1,2).moveX(4).moveY(7);
        System.out.println(point);   
    }
}
