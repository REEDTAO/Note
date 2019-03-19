package com.reed.Annotation.Cars;

import com.reed.Annotation.CarType;

@CarType("bmw")
public class BMW implements BaseCar {
    public void getMyName(){
        System.out.println("BMW");
    }
}
