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
                temp = skipEmpty(reader);
            if(temp=='<'){
                String key = getStringFromIndexToChar(reader,'>');
                if(checkIsKey(key)) {
                    temp =skipEmpty(reader);
                    if(temp!='<'){
                        String value = getStringFromIndexToChar(reader,'<');
                        map.put(key,value);

                    }else{
                        HashMap<String,Object> next = new HashMap<>();
                        map.put(key,next);
                        praser(reader,next,temp);
                    }
                }
            }
            read = reader.read();
        }
        return map;
    }

    private static boolean checkIsKey(String string) {
        return true;
    }



    //获取到下一个给出字符的字符串
    private static String getStringFromIndexToChar(BufferedReader reader, char c) throws IOException {
        int read = reader.read();
        StringBuilder string = new StringBuilder();
        while (read!=-1&&(char)read!=c){
            string.append((char)read);
            read = reader.read();
        }
        return string.toString();
    }

    public static char skipEmpty(BufferedReader reader) throws IOException {
        char read = (char)reader.read();
        while(read=='\t'||read=='\n'||read==' ') {
            read = (char) reader.read();
        }
        return read;
    }


}
