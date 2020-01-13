package com.reed.xmlToMap;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class XmlToMapUtils {
    public static BufferedReader getXmlReader(String path){
        try {
            return new BufferedReader(new FileReader(new File(path)));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
    public static Map praser(BufferedReader reader,Map map,int tmp) throws IOException {
        int read;
        if(tmp==-2){
            read = reader.read();
        }else read = tmp;
        char temp;
        while(read!=-1){
            temp = (char)read;
            //跳过标签间隔空白，换行，回车
            if(read=='\r'||read=='\n'||read==' ')
                temp = (char)skipEmpty(reader);
            if(temp=='<'){
                String key = getStringFromIndexToChar(reader,'>');
                //返回上一层
                if(key.startsWith("/"))return map;
                //检查是否为正确的key
                if(checkIsKey(key)) {
                    temp =(char)skipEmpty(reader);
                    if(temp!='<'){
                        String value = getStringFromIndexToChar(reader,'<');
                        map.put(key,temp+value);
                        skipToGivenChar(reader,'>');
                    }else{
                        HashMap<String,Object> next = new HashMap<>();
                        map.put(key,next);
                        praser(reader,next,temp);
                    }
                }
            }
            read = skipEmpty(reader);
        }
        return map;
    }
    //跳到指定的字符
    private static void skipToGivenChar(BufferedReader reader,char c) throws IOException {
        int temp = reader.read();
        while(temp!=-1&&(char)temp!=c){
            temp = reader.read();
        }
    }

    //检查获取的key是否符合标准
    private static boolean checkIsKey(String string) {
        if(string.startsWith("?")&&string.endsWith("?"))return false;
        if(string.endsWith("/"))return false;
        if(string.startsWith("!--")&&string.endsWith("--"))return false;
        return true;
    }
    //获取到下一个给出字符的字符串
    private static String getStringFromIndexToChar(BufferedReader reader, char c) throws IOException {
        int read = reader.read();
        StringBuilder string = new StringBuilder();
        while (read!=-1&&(char)read!=c){
            if((char)read!='\r'&&(char)read!='\n')
            string.append((char)read);
            read = reader.read();
        }
        return string.toString();
    }
    //跳过空白换行回车
    public static int skipEmpty(BufferedReader reader) throws IOException {
        int read = reader.read();
        while((read=='\r'||read=='\n'||read==' ')&&read!=-1) {
            read = (char) reader.read();
        }
        return read;
    }
}
