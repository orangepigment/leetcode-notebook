package ru.orangepigment.concurrency;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

/**
 * <a href="https://leetcode.com/problems/print-zero-even-odd">https://leetcode.com/problems/print-zero-even-odd</a>
 */
public class ZeroEvenOdd {
    private final int n;
    private final Semaphore zeroSem, evenSem, oddSem;

    public ZeroEvenOdd(int n) {
        this.n = n;
        zeroSem = new Semaphore(1);
        evenSem = new Semaphore(0);
        oddSem = new Semaphore(0);
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            zeroSem.acquire();
            printNumber.accept(0);
            if (i % 2 == 0) {
                evenSem.release();
            } else {
                oddSem.release();
            }
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int i = 2; i <= n; i += 2) {
            evenSem.acquire();
            printNumber.accept(i);
            zeroSem.release();
        }

    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i += 2) {
            oddSem.acquire();
            printNumber.accept(i);
            zeroSem.release();
        }
    }
}
