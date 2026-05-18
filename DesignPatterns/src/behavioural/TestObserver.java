package behavioural;

public class TestObserver {
    public static void main(String[] args) {
        YoutubeChannel channel = new YoutubeChannel();
        Subscriber sub1 = new Subscriber("Larissa");
        Subscriber sub2 = new Subscriber("Florence");
        channel.addObserver(sub1);
        channel.addObserver(sub2);
        channel.upload("How to kill a mockingbird!!");
    }
}
