package com.justplay1994.github.acm.leetcode;


/**
 * 1115. 交替打印FooBar
 */
public class Solution1115 {
    static
    class FooBar {
        int lock_1 = 1;
        int lock_2 = 0;
        private int n;

        final Object lock = new Object();

        public FooBar(int n) {
            this.n = n;
        }

        public void foo(Runnable printFoo) throws InterruptedException {
            for (int i = 0; i < n; i++) {
                while(lock_1 == 0){
                    synchronized (this){
                        wait();
                    }
                }
                lock_1 = 0;
                // printFoo.run() outputs "foo". Do not change or remove this line.
                printFoo.run();
                lock_2 = 1;

                synchronized (this){
                    notify();
                }

            }
        }

        public void bar(Runnable printBar) throws InterruptedException {
            for (int i = 0; i < n; i++) {
                while (lock_2 == 0){
                    synchronized (this){
                        wait();
                    }
                }
                lock_2 = 0;
                // printBar.run() outputs "bar". Do not change or remove this line.
                printBar.run();
                lock_1 = 1;

                synchronized (this){
                    notify();
                }
            }
        }
    }

    public static void main(String[] args){
        Runnable printFoo = new Runnable() {
            @Override
            public void run() {
                System.out.print("foo");
            }
        };
        Runnable printBar = new Runnable() {
            @Override
            public void run() {
                System.out.print("bar");
            }
        };
        FooBar fooBar = new FooBar(3);
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    fooBar.foo(printFoo);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    fooBar.bar(printBar);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t1.start();
        t2.start();
    }
}
