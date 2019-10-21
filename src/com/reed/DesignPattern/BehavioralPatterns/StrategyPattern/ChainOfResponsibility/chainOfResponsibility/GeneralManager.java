package com.reed.DesignPattern.BehavioralPatterns.StrategyPattern.ChainOfResponsibility.chainOfResponsibility;

public class GeneralManager extends PayRiseFlow {
    @Override
    protected void check() {
        System.out.println("总经理同意");
    }
}
