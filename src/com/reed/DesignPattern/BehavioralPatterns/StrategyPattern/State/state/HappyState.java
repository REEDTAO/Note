package com.reed.DesignPattern.BehavioralPatterns.StrategyPattern.State.state;

import com.reed.DesignPattern.BehavioralPatterns.StrategyPattern.State.People;

public class HappyState implements PeopleState {
    @Override
    public void doAction(People people) {
        System.out.println("开心");
        people.setPeopleState(this);
    }
}
