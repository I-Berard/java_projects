package behavioural;

import java.util.ArrayList;
import java.util.List;

public class YoutubeChannel implements Subject{
    private List<Observer> observers = new ArrayList<>();
    private String video;

    @Override
    public void notifyObservers() {
        observers.forEach((x) -> x.update(video));
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void upload(String title){
        this.video = title;
        notifyObservers();
    }
}
