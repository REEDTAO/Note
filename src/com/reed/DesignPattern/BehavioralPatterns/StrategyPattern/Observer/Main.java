package com.reed.DesignPattern.BehavioralPatterns.StrategyPattern.Observer;

import java.util.Observable;
import java.util.Observer;

public class Main {
    public static void main(String[] args) {
        ObserverTest observable = new ObserverTest();
        Observer observer = new Observer() {
            @Override
            public void update(Observable o, Object arg) {
                System.out.println(arg);
            }
        };
        Observer observer1 = new Observer() {
            @Override
            public void update(Observable o, Object arg) {
                System.out.println(arg);
            }
        };
        Observer observer2 = new Observer() {
            @Override
            public void update(Observable o, Object arg) {
                System.out.println(arg);
            }
        };
        Observer observer3 = new Observer() {
            @Override
            public void update(Observable o, Object arg) {
                System.out.println(arg);
            }
        };

        observable.addObserver(observer);
        observable.addObserver(observer1);
        observable.addObserver(observer2);
        observable.addObserver(observer3);

        observable.setData("下雨了");

    }
}
