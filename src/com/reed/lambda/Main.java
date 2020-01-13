package com.reed.lambda;


import com.reed.lambda.Interface.TestInterface;

import java.lang.reflect.Array;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        //test();
        //lambda();
        System.out.println(new Date());
    }

    private static void lambda() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(2);
        list.add(1);
        list.add(0);
        list.add(-1);

        new LinkedList<>().stream();
        System.out.println(list);
        Collections.sort(list, Main::upFunction);
        System.out.println(list);
        Collections.sort(list,Main::downFunction);
        Collections.sort(list,(o1,o2)->Main.downFunction(o1,o2));
        System.out.println(list);

    }

    public static int upFunction(Integer i1,Integer i2){
        return i1-i2;
    }
    public static int downFunction(Integer i1,Integer i2){
        return i2-i1;
    }

    private static void test() {
        TestInterface test = o->o;
        String s = test.appendString("a");
        System.out.println(s);
        Thread thread = new Thread(()-> System.out.println("runnable"));
        String str = "Hello.world";
        Function<String,Boolean> func2 = t->str.endsWith(t);
        System.out.println(func2.apply("world"));
    }
}
