package com.reed.DesignPattern.BehavioralPatterns.StrategyPattern.command;

public class RmOrder implements Order {
    private Cm cm;

    public RmOrder(Cm cm){
        this.cm = cm;
    }
    @Override
    public void execute() {
        cm.rm("-rf /");
    }
}
