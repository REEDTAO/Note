package com.reed.DesignPattern.creationalPatterns.FactoryPattern.CarImpl;

import com.reed.DesignPattern.creationalPatterns.FactoryPattern.Car;

public class BMW implements Car {
    @Override
    public void sayMyName() {
        System.out.println("my name is bmw!");
    }
}
