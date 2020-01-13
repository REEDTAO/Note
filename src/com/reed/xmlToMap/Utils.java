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
        String s = xmlContent.replaceAll("<!--((?!<!--).).*-->", "")//去除注释
                .replaceAll("<((?!<).)+/>","")//去除不标准的标签
                .replaceAll("<\\?((?!<).)+\\?>","")//去除文档声明
                .replaceAll("> *<","><")//去除标签之间的空格
                .replaceAll("[\r\n]","")//去除回车换行
                .replaceAll("</((?!<).)+>","}")//将结束标签换位“}”
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
                i+=temp.length()+2;
                if(chars[i]!='{'){
                    String value = getStringFromIndexToChar(chars, i, '}');
                    map.put(temp,value);
                }else{
                    HashMap<String,Object> next = new HashMap<>();
                    map.put(temp,next);
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
