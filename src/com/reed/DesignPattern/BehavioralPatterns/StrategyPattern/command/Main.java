package com.reed.DesignPattern.BehavioralPatterns.StrategyPattern.command;

public class Main {
    public static void main(String[] args) {
        OrderManager orderManager = new OrderManager();
        Cm cm = new Cm();
        Order cd = new CdOrder(cm);
        Order rm = new RmOrder(cm);
        Order cp = new CpOrder(cm);
        orderManager.addOrder(cd);
        orderManager.addOrder(rm);
        orderManager.addOrder(cp);
        orderManager.placeOrders();
    }
}
