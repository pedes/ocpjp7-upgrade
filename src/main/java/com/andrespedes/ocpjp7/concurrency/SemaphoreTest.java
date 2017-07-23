package com.andrespedes.ocpjp7.concurrency;

import java.util.concurrent.Semaphore;

/**
 * Created by andresc on 23/07/2017.
 * This class simulates a situation where an ATM room has only two ATM machines
 * and five people are waiting to access the machine. Since only one person can access
 * an ATM machine at a given time, others wait for their turn
 */
public class SemaphoreTest {

    public static void main(String[] args) {
        // assume that only two ATM machines are available in the ATM room
        Semaphore machines = new Semaphore(2);
        // list of people waiting to access the machine
        new Person(machines, "Andres");
        new Person(machines, "Juan");
        new Person(machines, "Pedro");
        new Person(machines, "Carlos");
        new Person(machines, "Luis");
    }
}

// Each Person is an independent thread; but their access to the common resource
// (two ATM machines in the ATM machine room in this case) needs to be synchronized.
class Person extends Thread {
    private Semaphore machines;

    public Person(Semaphore machines, String name) {
        this.machines = machines;
        this.setName(name);
        this.start();
    }

    public void run() {
        try {
            System.out.println(getName() + " waiting to access an ATM machine");
            machines.acquire();
            System.out.println(getName() + " is accessing an ATM machine");
            Thread.sleep(1000); // simulate the time required for withdrawing amount
            System.out.println(getName() + " is done using the ATM machine");
            machines.release();
        } catch (InterruptedException ie) {
            System.err.println(ie);
        }
    }
}