import java.util.ArrayList;
import java.util.Observer;

public class concreSubject implements Subject {
   private List<Observer> observers;
   private int state;

 public ConcreteSubject()
 {
    observers = new ArrayList<Observer>();
 }

 public void attach(observer 0)
 {
    if(!observers.contains(0))
    {
        observers.remove(o);

    }
 }

   public void notifyObserver() {
      for (Observer o : observers) {
         o.update(null, this.state);
      }
   }public void
}
