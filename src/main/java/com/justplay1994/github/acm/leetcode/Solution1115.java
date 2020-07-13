package com.justplay1994.github.acm.leetcode;


/**
 * 1115. 交替打印FooBar
 */
public class Solution1115 {
    /**
     * 1. mutex（自己实现的太慢，5%）
     * 2. volatile + cas + 自旋（不行，因为检测锁和上锁是两个步骤，多线程下不安全）
     * 3. volatile + 自旋 （不行，因为多个线程，可能会同时冲破临界区，并且可能会导致永久等待。
     */
    class FooBar {
        private int n;

        class Mutex{
            volatile private boolean isLocked = false;

            public synchronized void lock() throws InterruptedException{
                while( isLocked ){
                    this.wait();
                }
                isLocked = true;
            }

            public synchronized void unlock(){
                isLocked = false;
                this.notifyAll();
            }
        }

        Mutex a = new Mutex();
        Mutex b = new Mutex();

        public FooBar(int n) {
            this.n = n;
            try {
                b.lock();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        public void foo(Runnable printFoo) throws InterruptedException {
            for (int i = 0; i < n; i++) {
                a.lock();
                // printFoo.run() outputs "foo". Do not change or remove this line.
                printFoo.run();
                b.unlock();
            }
        }

        public void bar(Runnable printBar) throws InterruptedException {
            for (int i = 0; i < n; i++) {
                b.lock();
                // printBar.run() outputs "bar". Do not change or remove this line.
                printBar.run();
                a.unlock();
            }
        }
    }
}
