package com.reed.DesignPattern.creationalPatterns.FactoryPattern;

import com.reed.DesignPattern.creationalPatterns.FactoryPattern.CarImpl.BMW;
import com.reed.DesignPattern.creationalPatterns.FactoryPattern.CarImpl.Ferrari;
import com.reed.DesignPattern.creationalPatterns.FactoryPattern.CarImpl.Porsche;

public class CarFactory {
    public Car getCar(String carName) {
        switch (carName){
            case "BMW":
                return new BMW();
            case "Porsche":
                return new Porsche();
            case "Ferrari":
                return new Ferrari();
            default:
                return null;
        }
    }
    public static Car staticGetCar(String carName) {
        switch (carName){
            case "BMW":
                return new BMW();
            case "Porsche":
                return new Porsche();
            case "Ferrari":
                return new Ferrari();
            default:
                return null;
        }
    }
}
