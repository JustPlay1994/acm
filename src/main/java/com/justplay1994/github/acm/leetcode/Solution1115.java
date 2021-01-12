package com.justplay1994.github.acm.leetcode;


import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 1115. 交替打印FooBar
 */
public class Solution1115 {
    /**
     * 1. mutex（自己实现的太慢，5%）
     * 2. volatile + cas + 自旋（不行，因为检测锁和上锁是两个步骤，多线程下不安全）
     * 3. volatile + 自旋 （不行，因为多个线程，可能会同时冲破临界区，并且可能会导致永久等待。
     * 4. 使用ReentrantLock.condition
     */
    class FooBar {
        private int n;

        ReentrantLock lock = new ReentrantLock();

        Condition a = lock.newCondition();
        Condition b = lock.newCondition();

        volatile boolean isFirst = true;

        volatile boolean isB = true;

        public FooBar(int n) {
            this.n = n;
        }

        public void foo(Runnable printFoo) throws InterruptedException {
            for (int i = 0; i < n; i++) {
                while(isB){}
                lock.lock();
                if (!isFirst) {
                    a.await();
                }else {
                    isFirst = false;
                }
                // printFoo.run() outputs "foo". Do not change or remove this line.
                printFoo.run();
                b.signal();
                lock.unlock();
            }
        }

        public void bar(Runnable printBar) throws InterruptedException {

            for (int i = 0; i < n; i++) {
                lock.lock();
                isB = false;
                b.await();
                // printBar.run() outputs "bar". Do not change or remove this line.
                printBar.run();
                a.signal();
                lock.unlock();
            }
        }
    }
}
