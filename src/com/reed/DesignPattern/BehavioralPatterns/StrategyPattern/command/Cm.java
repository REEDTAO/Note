package com.reed.DesignPattern.BehavioralPatterns.StrategyPattern.command;

public class Cm {
    public void cd(String string){
        System.out.println("cd "+string);
    }
    public void rm(String string){
        System.out.println("rm "+string);
    }
    public void cp(String string){
        System.out.println("cp "+string);
    }
}
