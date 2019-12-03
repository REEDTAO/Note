package com.reed.DesignPattern.BehavioralPatterns.StrategyPattern.command;

import java.util.ArrayList;

public class OrderManager {
    private ArrayList<Order> orders = new ArrayList<>();

    public void addOrder(Order order){
        orders.add(order);
    }
    public void placeOrders(){
        for (Order order:orders){
            order.execute();
        }
        orders.clear();
    }
}
