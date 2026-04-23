import java.util.ArrayList;
import java.util.Stack;

public class Arrays {
    public static void main(String[] args) {
        ArrayList<Integer> array = new ArrayList<>(4);
        array.add(2);
        array.add(4);
        array.add(5);
        array.add(6);
        array.add(4);

        for(Integer number : array){
            System.out.println(number);
        }
    }
}

class UseGenerics<T extends Node, G extends Number>{
    public <G> T printAnything(T interesting, G another){
        System.out.println(interesting + " " + another);
        return interesting;
    }

    public static void main(String[] args) {
        UseGenerics<Node, Integer> gen = new UseGenerics<>();
        gen.printAnything(new Node(6), 4);
    }
}

class StackExample {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.add(4);
        stack.add(5);
        stack.add(9);
        stack.add(2);
        System.out.println(stack.search(1));
    }
}