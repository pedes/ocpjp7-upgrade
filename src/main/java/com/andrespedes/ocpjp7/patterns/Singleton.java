package com.andrespedes.ocpjp7.patterns;

/**
 * Created by @pedes on 10/07/2017.
 * Thread-safe Singleton
 */
public class Singleton {

    private static Singleton instance;

    // Private constructor prevents instantiation from other classes
    private Singleton() {
    }

    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
