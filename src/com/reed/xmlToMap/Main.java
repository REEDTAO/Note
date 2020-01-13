package com.reed.xmlToMap;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        long begin = System.currentTimeMillis();
        Map map = Utils.xmlToMap("C:\\Users\\Elead\\IdeaProjects\\Note\\src\\com\\reed\\xmlToMap\\test.xml");
        System.out.println(System.currentTimeMillis()-begin);
        begin = System.currentTimeMillis();


        System.out.println(System.currentTimeMillis()-begin);

    }
}
