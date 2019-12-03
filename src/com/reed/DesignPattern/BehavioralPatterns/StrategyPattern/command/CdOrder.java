package com.reed.DesignPattern.BehavioralPatterns.StrategyPattern.command;

public class CdOrder implements Order {
    private Cm cm;
    public CdOrder(Cm cm){
        this.cm = cm;
    }
    @Override
    public void execute() {
        cm.cd("/root");
    }
}
