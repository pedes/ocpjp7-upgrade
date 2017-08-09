package com.andrespedes.ocpjp7.concurrency;

import java.util.concurrent.locks.*;
// This class simulates a situation where only one ATM machine is available and
// and five people are waiting to access the machine. Since only one person can
// access an ATM machine at a given time, others wait for their turn

public class ReentrantLockExample {
    public static void main(String []args) {
        // A person can use a machine again, and hence using a "reentrant lock"
        Lock machine = new ReentrantLock();

        // list of people waiting to access the machine
        new ATMUser(machine, "Mickey");
        new ATMUser(machine, "Donald");
        new ATMUser(machine, "Tom");
        new ATMUser(machine, "Jerry");
        new ATMUser(machine, "Casper");
    }

}

// Each ATMUser is an independent thread; their access to the common resource
// (the ATM machine in this case) needs to be synchronized using a lock
class ATMUser extends Thread {
    private Lock machine;
    public ATMUser(Lock machine, String name) {
        this.machine = machine;
        this.setName(name);
        this.start();
    }
    public void run() {
        try {
            System.out.println(getName() + " waiting to access an ATM machine");
            machine.lock();
            System.out.println(getName() + " is accessing an ATM machine");
            Thread.sleep(1000); // simulate the time required for withdrawing amount
        } catch(InterruptedException ie) {
            System.err.println(ie);
        }
        finally {
            System.out.println(getName() + " is done using the ATM machine");
            machine.unlock();
        }
    }
}

