package com.reed.DesignPattern.BehavioralPatterns.StrategyPattern.ChainOfResponsibility.chainOfResponsibility;

public class GroupLeaderCheck extends PayRiseFlow {

    @Override
    public void check() {
        System.out.println("组长同意！");
    }
}
