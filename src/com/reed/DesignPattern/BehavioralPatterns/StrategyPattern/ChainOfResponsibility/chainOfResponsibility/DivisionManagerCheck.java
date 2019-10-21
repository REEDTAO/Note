package com.reed.DesignPattern.BehavioralPatterns.StrategyPattern.ChainOfResponsibility.chainOfResponsibility;

public class DivisionManagerCheck extends PayRiseFlow {
    @Override
    protected void check() {
        System.out.println("部门经理同意");
    }
}
