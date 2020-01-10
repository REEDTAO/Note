package com.reed.xmlToMap;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Utils {
    public static Map xmlToMap(String path) throws IOException {
        String xmlContent = getXmlContent(path);

        return xmlPraser(xmlContent);
    }

    private static String getXmlContent(String s) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(new File(s)));
        StringBuilder stringBuilder = new StringBuilder();
        int read = reader.read();
        while (read!=-1){
            stringBuilder.append((char)read+reader.readLine());
            read = reader.read();
        }
        return stringBuilder.toString();
    }

    public static Map  xmlPraser(String xmlContent){
        //去除注释,换格式
        String s = xmlContent.replaceAll("<!--((?!<!--).).*-->", "")
                .replaceAll("<((?!<).)+/>","")
                .replaceAll("<\\?((?!<).)+\\?>","")
                .replaceAll("> *<","><")
                .replaceAll("[\r\n]","")
                .replaceAll("</((?!<).)+>","}")
                .replaceAll(">","=")
                .replaceAll("<","{");
        System.out.println(s);
        HashMap<String,Object> map = new HashMap<>();
        praser(s.toCharArray(),0,map);
        return map;
    }

    public static int praser(char[] chars,int i,Map map){
        for(;i<chars.length;i++){
            if(i==chars.length-1)return i;
            if(chars[i]=='}'){
                if(chars[++i]=='{'){
                    i--;
                    continue;
                }else if(chars[i]=='}')return i;
            }
            if(chars[i]=='{'){
                String temp = getStringFromIndexToChar(chars, i+1, '=');
                //System.out.println(temp);
                i+=temp.length()+2;
                if(chars[i]!='{'){
                    String value = getStringFromIndexToChar(chars, i, '}');
                    //System.out.println(temp+"     "+value);
                    map.put(temp,value);
                }else{
                    HashMap<String,Object> next = new HashMap<>();
                    map.put(temp,next);
                    //System.out.println(temp);
                    i=praser(chars,i,next);
                }
            }
        }
        return i;
    }

    public static String getStringFromIndexToChar(char[] chars,int i,char c){
        StringBuilder string = new StringBuilder();
        while(chars[i]!=c){
            string.append(chars[i]);
            i++;
        }
        return string.toString();
    }
}
