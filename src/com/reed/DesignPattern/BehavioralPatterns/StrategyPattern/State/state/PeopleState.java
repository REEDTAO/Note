package com.reed.DesignPattern.BehavioralPatterns.StrategyPattern.State.state;

import com.reed.DesignPattern.BehavioralPatterns.StrategyPattern.State.People;

public interface PeopleState {
    void doAction(People people);
}
