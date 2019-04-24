package com.reed.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;


public class Main {
    public static void main(String[] args) throws Exception{
        /**
         * Class.forName("com.reed.reflect.DemoPoJo");
         * 可以获取Class对象，class对象可以获取该类的详细信息
         * 如果该类没被加载就会被加载
         */
        Class<?> demoPoJo = Class.forName("com.reed.reflect.DemoPoJo");
        //获取类加载器
        System.out.println(demoPoJo.getClassLoader());
        //获取类的全限定名
        System.out.println(demoPoJo.getName());


        /**
         * reflect反射
         * Field、Method和Constructor
         *反射可以通过class获取类的所有信息，并且进行重新设置属性值或者方法的调用
         * 私有方法或者属性需要使用setAccessible(true);跳过检查
         */

        Constructor<?> constructor = demoPoJo.getConstructor(String.class);

        DemoPoJo d = (DemoPoJo) constructor.newInstance("dfsfd");
        System.out.println(d.getName());
        Field[] fields = d.getClass().getDeclaredFields();
        Method method = DemoPoJo.class.getMethod("getName");
        String invoke = (String) method.invoke(d);
        System.out.println(invoke);
        fields[0].setAccessible(true);
        fields[0].set(d,"13");
        System.out.println(fields[0].get(d));



    }
}
