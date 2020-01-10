package com.reed.xmlToMap;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
//        Map map = Utils.xmlToMap("C:\\Users\\Elead\\Desktop\\work\\src\\club\\reed\\collection\\xmlToMap\\test.xml");
//        System.out.println(map);
        BufferedReader xmlReader = XmlToMapUtils.getXmlReader("C:\\Users\\Elead\\Desktop\\work\\src\\club\\reed\\collection\\xmlToMap\\test.xml");
        Map praser = XmlToMapUtils.praser(xmlReader, new HashMap());

    }
}
