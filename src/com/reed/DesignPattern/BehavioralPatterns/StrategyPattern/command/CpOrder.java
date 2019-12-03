package com.reed.DesignPattern.BehavioralPatterns.StrategyPattern.command;

public class CpOrder implements Order {
    private Cm cm;

    public CpOrder(Cm cm){
        this.cm = cm;
    }
    @Override
    public void execute() {
        cm.cp("/readme.md /temp/read.md");
    }
}
