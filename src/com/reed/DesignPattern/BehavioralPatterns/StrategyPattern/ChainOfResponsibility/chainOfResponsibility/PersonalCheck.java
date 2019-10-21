package com.reed.DesignPattern.BehavioralPatterns.StrategyPattern.ChainOfResponsibility.chainOfResponsibility;

public class PersonalCheck extends PayRiseFlow{
    @Override
    protected void check() {
        System.out.println("人事部门调整工资！");
    }
}
