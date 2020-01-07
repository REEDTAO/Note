package com.reed.Annotation;


import com.reed.Annotation.Anno.*;

public class User {
    @AnnoNotNull
    String name;

    @AnnoEmue(option = {"上海","北京","广东","广西"})
    String addr;

    @AnnoTel
    String tel;

    @AnnoNotEmpty
    @AnnoEmue(option={"boy","girl"})
    String sex;

    @AnnoMin(0)
    Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
