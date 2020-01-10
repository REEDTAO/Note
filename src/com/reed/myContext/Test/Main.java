package com.reed.myContext.Test;

import com.reed.myContext.core.Context;
import com.reed.myContext.service.TestService;
import com.reed.myContext.service.TestServiceOne;

public class Main {
    public static void main(String[] args) throws IllegalAccessException, ClassNotFoundException, InstantiationException {
        Context context = new Context();
        context.initContext("com.reed.myContext.service");
        TestService testService = (TestService) context.getBean("TestService");
        TestServiceOne testServiceOne = (TestServiceOne) context.getBean("TestServiceOne");
        System.out.println(testService+"  "+testServiceOne);
        System.out.println(testService.getTeServiceOne()+" "+testServiceOne.getTestService());
    }
}
