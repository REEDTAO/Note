package com.reed.myContext.service;

import com.reed.myContext.Anno.AnnoAutowire;
import com.reed.myContext.Anno.AnnoService;

@AnnoService
public class TestService {
    @AnnoAutowire
    TestServiceOne one;

    public TestServiceOne getTeServiceOne() {
        return one;
    }
}
