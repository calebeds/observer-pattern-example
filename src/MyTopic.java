import java.util.ArrayList;
import java.util.List;

public class MyTopic implements Subject {
    private List<Observer> observers;
    private String message;
    private boolean changed;

    public MyTopic() {
        this.observers = new ArrayList<>();
    }

    @Override
    public void register(Observer obj) {
        if(obj == null) throw new NullPointerException("Null Observer");
        if (!observers.contains(obj)) this.observers.add(obj);
    }

    @Override
    public void unregister(Observer obj) {
        this.observers.remove(obj);
    }

    @Override
    public void notifyObservers() {
        List<Observer> observersLocal = null;

        if(!changed) return;

        observersLocal = new ArrayList<>(this.observers);
        this.changed = false;

        for(Observer obj: observersLocal) {
            obj.update();
        }
    }

    @Override
    public Object getUpdate(Observer obj) {
        return this.message;
    }

    // method to post message to the topic, change state (trigger notifications)
    public void postMessage(String msg) {
        System.out.println("Message posted to topic: " + msg);
        this.message = msg;
        this.changed = true;
        this.notifyObservers();
    }
}
