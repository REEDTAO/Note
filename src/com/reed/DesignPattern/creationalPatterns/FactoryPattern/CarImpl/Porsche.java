package com.reed.DesignPattern.creationalPatterns.FactoryPattern.CarImpl;

import com.reed.DesignPattern.creationalPatterns.FactoryPattern.Car;

public class Porsche implements Car {

    @Override
    public void sayMyName() {
        System.out.println("my name is Porsche!");
    }
}
