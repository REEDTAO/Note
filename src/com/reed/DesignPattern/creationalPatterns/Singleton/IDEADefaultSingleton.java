package com.reed.DesignPattern.creationalPatterns.Singleton;

public class IDEADefaultSingleton {
    private static IDEADefaultSingleton ourInstance = new IDEADefaultSingleton();

    public static IDEADefaultSingleton getInstance() {
        return ourInstance;
    }

    private IDEADefaultSingleton() {
    }
}
