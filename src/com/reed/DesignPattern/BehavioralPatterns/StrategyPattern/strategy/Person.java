package com.reed.DesignPattern.BehavioralPatterns.StrategyPattern.strategy;

public class Person {
    private Strategy strategy;

    /**
     * 将可变的策略注入，从而修改行为方式
     * @param strategy
     */
    public void changeStraegy(Strategy strategy){
        this.strategy = strategy;
    }


    public void doSomeThingWithMouth(){
        strategy.doSomeThingWithMouth();
    }

}
