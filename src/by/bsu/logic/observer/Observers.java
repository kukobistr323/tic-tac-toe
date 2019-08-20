package by.bsu.logic.observer;

import by.bsu.logic.Indexes;

import java.util.ArrayList;
import java.util.List;

public class Observers {
    private List<Observer> observers;

    public Observers() {
        observers = new ArrayList<>();
    }

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObservers(Indexes ind) {
        for (Observer observer : observers) {
            observer.observe(ind);
        }
    }

    public void setNewGame() {
        for (Observer observer : observers) {
            observer.newGame();
        }
    }
}
