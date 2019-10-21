package com.reed.DesignPattern.BehavioralPatterns.StrategyPattern.ChainOfResponsibility.chainOfResponsibility;

public class ManagerCheck extends PayRiseFlow {
    @Override
    protected void check() {
        System.out.println("项目经理同意");
    }
}
