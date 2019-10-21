package com.reed.DesignPattern.BehavioralPatterns.StrategyPattern.ChainOfResponsibility;

import com.reed.DesignPattern.BehavioralPatterns.StrategyPattern.ChainOfResponsibility.chainOfResponsibility.*;

public class Main {
    public static PayRiseFlow getPayRiseFlowChain(){
        PayRiseFlow groupLeaderCheck = new GroupLeaderCheck();
        PayRiseFlow managerCheck = new ManagerCheck();
        PayRiseFlow divisionManagerCheck = new DivisionManagerCheck();
        PayRiseFlow generalManager = new GeneralManager();
        PayRiseFlow personalCheck = new PersonalCheck();

        generalManager.setNextFlow(personalCheck);
        divisionManagerCheck.setNextFlow(generalManager);
        managerCheck.setNextFlow(divisionManagerCheck);
        groupLeaderCheck.setNextFlow(managerCheck);

        return groupLeaderCheck;
    }

    public static void main(String[] args) {
        PayRiseFlow payRiseFlow = getPayRiseFlowChain();
        payRiseFlow.doCheck();
    }
}
