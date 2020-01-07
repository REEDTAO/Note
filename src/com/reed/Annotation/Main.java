package com.reed.Annotation;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        User user = new User();
        user.setTel("15018381520");
        user.setAddr("广东");
        user.setAge(10);
        user.setSex("girl");
        user.setName("");
        HashMap<Object, Object> map = Utils.checkSelfAnno(user);
        System.out.println(map);
    }

}
