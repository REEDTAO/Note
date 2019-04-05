package com.reed.DesignPattern.BehavioralPatterns.StrategyPattern.strategy;

import com.reed.DesignPattern.BehavioralPatterns.StrategyPattern.strategy.behavior.Chat;
import com.reed.DesignPattern.BehavioralPatterns.StrategyPattern.strategy.behavior.Eat;

public class Main {
    public static void main(String[] args) {
        Person person = new Person();

        /**
         * 修改策略，改变行为
         */
        person.changeStraegy(new Eat());
        person.doSomeThingWithMouth();

        person.changeStraegy(new Chat());
        person.doSomeThingWithMouth();
    }
}
