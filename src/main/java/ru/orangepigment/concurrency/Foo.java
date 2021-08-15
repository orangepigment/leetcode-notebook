package ru.orangepigment.concurrency;

import java.util.concurrent.Semaphore;

/**
 * <a href="https://leetcode.com/problems/print-in-order">https://leetcode.com/problems/print-in-order</a>
 */
public class Foo {

    private final Semaphore first = new Semaphore(0);
    private final Semaphore second = new Semaphore(0);
    public Foo() {

    }

    public void first(Runnable printFirst) throws InterruptedException {
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        first.release();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        // printSecond.run() outputs "second". Do not change or remove this line.
        first.acquire();
        printSecond.run();
        second.release();
    }

    public void third(Runnable printThird) throws InterruptedException {
        // printThird.run() outputs "third". Do not change or remove this line.
        second.acquire();
        printThird.run();
    }
}
