package com.reed.xmlToMap;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
//        Map map = Utils.xmlToMap("C:\\Users\\luwei\\IdeaProjects\\Note\\src\\com\\reed\\xmlToMap\\test.xml");
//        System.out.println(map);
        BufferedReader xmlReader = XmlToMapUtils.getXmlReader("C:\\Users\\Elead\\IdeaProjects\\Note\\src\\com\\reed\\xmlToMap\\test.xml");
        Map praser = XmlToMapUtils.praser(xmlReader, new HashMap(),-2);
        xmlReader.close();
        System.out.println(praser);

    }
}
