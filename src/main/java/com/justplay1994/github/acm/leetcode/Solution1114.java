package com.justplay1994.github.acm.leetcode;

public class Solution1114 {

    //思路一：三把自旋锁
    //思路二：
    class Foo {

        int lock_1 = 1;
        int lock_2 = 0;
        int lock_3 = 0;

        public Foo() {

        }

        public void first(Runnable printFirst) throws InterruptedException {
            //critical section
            //P
            while(lock_1 == 0){
                //休眠
//                Thread.sleep(100);
            }
            lock_1 = 0;
            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();

            lock_2 = 1;
            //唤醒其他线程
        }

        public void second(Runnable printSecond) throws InterruptedException {

            while(lock_2 == 0){
                //休眠
//                Thread.sleep(100);
            }
            lock_2 = 0;
            // printSecond.run() outputs "second". Do not change or remove this line.
            printSecond.run();

            lock_3 = 1;
        }

        public void third(Runnable printThird) throws InterruptedException {
            while (lock_3 == 0){
                //休眠
//                Thread.sleep(100);
            }

            lock_3 = 0;
            // printThird.run() outputs "third". Do not change or remove this line.
            printThird.run();

            lock_1 = 1;
        }
    }

}
