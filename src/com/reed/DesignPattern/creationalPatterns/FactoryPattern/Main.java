package com.reed.DesignPattern.creationalPatterns.FactoryPattern;

public class Main {
    public static void main(String[] args) {
        /**
            使用一个carFactory对创建的细节进行屏蔽
         */
        long millis = System.currentTimeMillis();
        Car car = new CarFactory().getCar("BMW");
        car.sayMyName();

        Car car2 = new CarFactory().getCar("Porsche");
        car2.sayMyName();

        Car car3 = new CarFactory().getCar("Ferrari");
        car3.sayMyName();
        System.out.println(System.currentTimeMillis()-millis);


        /**
         * 用静态工厂方法获取
         */
        long milli = System.currentTimeMillis();
        Car car4 = CarFactory.staticGetCar("BMW");
        car4.sayMyName();

        Car car5 = CarFactory.staticGetCar("Porsche");
        car5.sayMyName();

        Car car6 = CarFactory.staticGetCar("Ferrari");
        car6.sayMyName();
        System.out.println(System.currentTimeMillis()-milli);
    }
}
