abstract class Animals {
    abstract protected void m1();
    abstract void m2();
    abstract void m3();
    abstract void m4();
}

interface Anumals{
    static void interesting(){
        System.out.println("This is interesting");
    }
}

public class Hen extends Animals {
    public void m1(){
        System.out.println("This is m1");
    }

    void m2(){
        System.out.println("This is m2");
    }

    void m3(){
        System.out.println("This is m3");
    }

    void m4(){
        System.out.println("This is m4");
    }

    static void interesting(){
        System.out.println("Interesting");
    }

    public static void main(String[] args) {
        Hen hen = new Hen();
        hen.interesting();
        hen.m1(); hen.m2(); hen.m3();
    }
}