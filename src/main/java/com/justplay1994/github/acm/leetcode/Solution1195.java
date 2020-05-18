package com.justplay1994.github.acm.leetcode;

import java.util.function.IntConsumer;

/**
 * 2020/05/17 15:07
 * 1195. 交替打印字符串
 */
public class Solution1195 {

    class FizzBuzz {
        private int n;

        int cur = 1;

        public FizzBuzz(int n) {
            this.n = n;
        }

        //四个线程

        // printFizz.run() outputs "fizz".  3的倍数，但不是5的倍数
        public void fizz(Runnable printFizz) throws InterruptedException {

            synchronized (this) {
                while (cur <= n) {
                    while (cur % 3 != 0 || cur % 5 == 0) {
                        if (cur >= n) return;
                        wait();
                    }
                    if (cur > n) return;
                    printFizz.run();
                    cur++;
                    notifyAll();
                }
            }
        }

        // printBuzz.run() outputs "buzz".  5的倍数,但不是3的倍数
        public void buzz(Runnable printBuzz) throws InterruptedException {

            synchronized (this) {
                while (cur <= n) {
                    while (cur % 3 == 0 || cur % 5 != 0) {
                        if (cur >= n) return;
                        wait();
                    }
                    if (cur > n) return;
                    printBuzz.run();
                    cur++;
                    notifyAll();
                }
            }
        }

        // printFizzBuzz.run() outputs "fizzbuzz".  同时3、5的倍数
        public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {

            synchronized (this) {
                while (cur <= n) {
                    while (cur % 3 != 0 || cur % 5 != 0) {
                        if (cur >= n) return;
                        wait();
                    }
                    if (cur > n) return;
                    printFizzBuzz.run();
                    cur++;
                    notifyAll();
                }
            }
        }

        // printNumber.accept(x) outputs "x", where x is an integer.    既不是3的倍数，也不是5的倍数
        public void number(IntConsumer printNumber) throws InterruptedException {
            synchronized (this) {
                while (cur <= n) {
                    while (cur % 3 == 0 || cur % 5 == 0) {
                        if (cur >= n) return;
                        wait();
                    }
                    printNumber.accept(cur);
                    cur++;
                    notifyAll();
                }
            }
        }
    }

}
