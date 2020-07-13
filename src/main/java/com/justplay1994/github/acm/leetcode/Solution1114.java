package com.justplay1994.github.acm.leetcode;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 20200713
 * 9:45
 */
public class Solution1114 {

    /**
     * 1. mutext
     * 2. volatile + cas
     * 3. volatile
     */
    class Foo {

        volatile int a = 0;
        volatile int b = 0;

        public Foo() {

        }

        public void first(Runnable printFirst) throws InterruptedException {
            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
            a++;
        }

        public void second(Runnable printSecond) throws InterruptedException {
            while (a != 1){
                //自旋等待
            }
            // printSecond.run() outputs "second". Do not change or remove this line.
            printSecond.run();
            b++;
        }

        public void third(Runnable printThird) throws InterruptedException {
            while (b != 1){

            }
            // printThird.run() outputs "third". Do not change or remove this line.
            printThird.run();
        }
    }

}
