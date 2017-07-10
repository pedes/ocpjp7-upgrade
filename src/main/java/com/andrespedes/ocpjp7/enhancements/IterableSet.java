package com.andrespedes.ocpjp7.enhancements;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * Created by @pedes on 10/07/2017.
 */
public class IterableSet {

    public static void iterateConcurrentOrderedSet(){
        Set<String> set = new ConcurrentSkipListSet<String>(); // #1 Thread Safe ordered Set
        set.add("2");
        set.add("1");
        Iterator<String> iter = set.iterator();
        set.add("3"); // Elements included on the iterator
        set.add("-1");
        while(iter.hasNext()) {
            System.out.print(iter.next() + " ");
        }
    }

    public static void iterateConcurrentUnorderedSet(){
        Set<String> set = new CopyOnWriteArraySet<>(); // #2 Thread Safe un-ordered Set
        set.add("2");
        set.add("1");
        Iterator<String> iter = set.iterator();
        set.add("3"); // Element not included on the iterator
        set.add("-1");
        while(iter.hasNext()) {
            System.out.print(iter.next() + " ");
        }
    }

    public static void main(String []args) {
        System.out.print("CopyOnWriteArraySet execution: ");
        IterableSet.iterateConcurrentUnorderedSet();
        System.out.println();
        System.out.print("ConcurrentSkipListSet execution: ");
        IterableSet.iterateConcurrentOrderedSet();
    }
}
