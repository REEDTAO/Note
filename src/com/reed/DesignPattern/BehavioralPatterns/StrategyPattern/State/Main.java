package com.reed.DesignPattern.BehavioralPatterns.StrategyPattern.State;

import com.reed.DesignPattern.BehavioralPatterns.StrategyPattern.State.state.HappyState;
import com.reed.DesignPattern.BehavioralPatterns.StrategyPattern.State.state.PeopleState;
import com.reed.DesignPattern.BehavioralPatterns.StrategyPattern.State.state.SadState;

public class Main {
    public static void main(String[] args) {
        People people = new People();

        //开心
        HappyState happyState = new HappyState();
        happyState.doAction(people);

        //伤心
        SadState sadState = new SadState();
        sadState.doAction(people);

        //获得当前对象的状态详细信息
        PeopleState peopleState = people.getPeopleState();

    }
}
