package com.reed.DesignPattern.BehavioralPatterns.StrategyPattern.Observer;

import java.util.Observable;

public class ObserverTest extends Observable {
    public void setData(String something){
        setChanged();
        notifyObservers(something);
    }
}
