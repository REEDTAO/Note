package com.reed.myContext.service;

import com.reed.myContext.Anno.AnnoAutowire;
import com.reed.myContext.Anno.AnnoService;

@AnnoService
public class TestServiceOne {
    @AnnoAutowire
    TestService testService;

    public TestService getTestService() {
        return testService;
    }
}
