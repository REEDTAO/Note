package com.reed.Annotation.Cars;

import com.reed.Annotation.CarType;

@CarType("qq")
public class QQ implements BaseCar {
    public void getMyName(){
        System.out.println("QQ");
    }
}
