
public class Interesting {
    public static void main(String[] args) {
        Node head = new Node();
        Node temp = head;
        for(int i = 1; i < 10; i++){
            Node node = new Node(i);
            temp.setNext(node);
            temp = node;
        }   

        temp = head;
        while (temp != null) { 
            System.out.print(temp.getData() + " -> ");
            temp = temp.getNext();
        }
    }   
}

class Node {
    int data;
    Node next;
    static int stuff = 2;
    
    public Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }

    public Node() {
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + data;
        result = prime * result + ((next == null) ? 0 : next.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Node other = (Node) obj;
        if (data != other.data)
            return false;
        if (next == null) {
            if (other.next != null)
                return false;
        } else if (!next.equals(other.next))
            return false;
        return true;
    }

    public Node(int data){
        this.data = data;
    }
    
    public int getData() {
        return data;
    }
    public void setData(int data) {
        this.data = data;
    }
    public Node getNext() {
        return next;
    }
    public void setNext(Node next) {
        this.next = next;
    }
}