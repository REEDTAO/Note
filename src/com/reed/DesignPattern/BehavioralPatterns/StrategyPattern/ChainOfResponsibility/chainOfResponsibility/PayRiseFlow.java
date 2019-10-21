package com.reed.DesignPattern.BehavioralPatterns.StrategyPattern.ChainOfResponsibility.chainOfResponsibility;

public abstract class PayRiseFlow {
    protected PayRiseFlow nextFlow;
    protected abstract void check();

    public void doCheck(){
        check();
        if(nextFlow!=null)
        nextFlow.doCheck();
    }

    public void setNextFlow(PayRiseFlow nextFlow) {
        this.nextFlow = nextFlow;
    }
}
