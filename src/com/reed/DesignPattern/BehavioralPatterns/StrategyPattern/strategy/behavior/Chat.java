package com.reed.DesignPattern.BehavioralPatterns.StrategyPattern.strategy.behavior;

import com.reed.DesignPattern.BehavioralPatterns.StrategyPattern.strategy.Strategy;

public class Chat implements Strategy {
    @Override
    public void doSomeThingWithMouth() {
        System.out.println("用嘴巴聊天！！！");
    }
}
