package com.reed.Annotation;



import com.reed.Annotation.Anno.*;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Pattern;

public class Utils {
    public static String PATTERN_TEL = "^1[3|4|5|7|8][0-9]\\d{4,8}$";

    public static boolean checkNotNull(Object obj) {
        return obj != null;
    }

    public static boolean checkEmue(List list, Object obj) {
        return checkNotNull(obj) && checkNotNull(list) && list.contains(obj);
    }

    public static boolean checkTel(String tel) {
        return Pattern.matches(PATTERN_TEL, tel);
    }

    public static boolean checkNotEmpty(Object obj) {
        return obj != null && obj.toString().length() > 0;
    }

    public static boolean checkMin(Integer min, Integer number) {
        return number > min;
    }

    public static HashMap<Object, Object> checkSelfAnno(Object obj) {
        Class clazz = obj.getClass();
        Field[] declaredFields = clazz.getDeclaredFields();
        StringBuilder em = new StringBuilder();
        String ec = "";
        HashMap<Object, Object> map = new HashMap<>();
        for (Field field : declaredFields) {
            try {
                field.setAccessible(true);
                if (field.isAnnotationPresent(AnnoNotNull.class)) {
                    em.append(checkNotNull(field.get(obj)) ? "" : field.getName() + "参数为空！");
                    ec += checkNotNull(field.get(obj)) ? 1 : 0;
                }
                if (field.isAnnotationPresent(AnnoEmue.class)) {
                    AnnoEmue annotation = field.getAnnotation(AnnoEmue.class);
                    String[] option = annotation.option();
                    em.append(checkEmue(Arrays.asList(option), field.get(obj)) ? "" : field.getName() + "参数输入不规范！");
                    ec += checkEmue(Arrays.asList(option), field.get(obj)) ? 1 : 0;
                }
                if (field.isAnnotationPresent(AnnoNotEmpty.class)) {
                    em.append(checkNotEmpty(field.get(obj)) ? "" : field.getName() + "参数为空！");
                    ec += checkNotEmpty(field.get(obj)) ? 1 : 0;
                }
                if (field.isAnnotationPresent(AnnoTel.class)) {
                    String o = (String) field.get(obj);
                    em.append(checkTel(o) ? "" : field.getName() + "参数不规范！");
                    ec += checkTel(o) ? 1 : 0;
                }
                if (field.isAnnotationPresent(AnnoMin.class)) {
                    AnnoMin annotation = field.getAnnotation(AnnoMin.class);
                    int value = annotation.value();
                    System.out.println(value);
                    em.append(checkMin(value, (Integer) field.get(obj)) ? "" : field.getName() + "参数不规范！");
                    ec += checkMin(value, (Integer) field.get(obj)) ? 1 : 0;
                }
            } catch (Exception e) {
                System.out.println(e);
                map.put("ec","1");
                map.put("em",e.getMessage());
                return map;
            }
        }
        if (em.toString().length() == 0) {
            em.append("参数正确");
        }
        map.put("ec", ec);
        map.put("em", em);
        map.put("data", "");
        return map;
    }
}
