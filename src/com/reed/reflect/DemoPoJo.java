package com.reed.reflect;

public class DemoPoJo {
    private String name;
    String id;

    static{
        System.out.println("hello, iam pojo!");
    }
    public DemoPoJo(String name){this.name=name;}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
