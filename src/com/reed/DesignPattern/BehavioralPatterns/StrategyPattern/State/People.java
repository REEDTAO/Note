package com.reed.DesignPattern.BehavioralPatterns.StrategyPattern.State;

import com.reed.DesignPattern.BehavioralPatterns.StrategyPattern.State.state.PeopleState;

public class People {
    private PeopleState peopleState;

    public PeopleState getPeopleState() {
        return peopleState;
    }

    public void setPeopleState(PeopleState peopleState) {
        this.peopleState = peopleState;
    }
}
