package com.justplay1994.github.acm.leetcode;

import java.util.function.IntConsumer;

/**
 * 2020/05/16 13:23
 * 1116. 打印零与奇偶数
 */
public class Solution1116 {

    /**
     * 坑点：
     * 1. 由于是多次循环，因此wait/notify有问题，可能导致notify提前通知，而真正到wait的时候，就没有通知了，导致被遗漏永久阻塞。
     * 2. 当n=1时，odd线程永远不会被唤醒
     * 3. 退出线程时，不能再多进行一次循环，否则没人进行唤醒。
     *
     * 综上，线程本次执行完后，需要判断，是否有下一次唤醒，如果没有，则退出
     *
     * 4. 还有坑，如果把wait() 改为wait(100)也有问题，导致，还没有进行通知，就开始执行了，因此在改变锁状态时，就相当于是通知了。
     * 5. 退出时候，判断next值的时候，next不是线程安全的，导致提前退出。看来每使用一个变量都需要考虑是否线程安全。
     *    解决方案，用临时变量存储，不需要共享的变量，尽量用本地临时变量，避免不必要的麻烦。
     */
    static
    class ZeroEvenOdd {
        private int n;

        int lock_0 = 1;
        int lock_1 = 0;
        int lock_2 = 0;

        int next = 1;


        public ZeroEvenOdd(int n) {
            this.n = n;
        }

        // printNumber.accept(x) outputs "x", where x is an integer.
        public void zero(IntConsumer printNumber) throws InterruptedException {
            while (true){
                while (lock_0 == 0){
                    synchronized (this){
                        wait(100);
                    }
                }
                // safe start
                lock_0 = 0;
                if (next <= n) {
                    printNumber.accept(0);
                }

                int temp = next;

                if (next % 2 == 1){
                    lock_1 = 1;
                }else {
                    lock_2 = 1;
                }

                //safe end
                synchronized(this){
                    notifyAll();
                }
                if (temp >= n){
                    break;
                }
            }
        }

        public void odd(IntConsumer printNumber) throws InterruptedException {
            while (true){
                if (n < 1)break;
                //P
                while (lock_1 == 0){
                    synchronized (this){
                        wait(100);
                    }
                }
                lock_1 = 0;//close

                if (next <= n) {
                    printNumber.accept(next);
                }

                //V
                next++;
                int temp = next;
                lock_0 = 1;
                synchronized(this){
                    notifyAll();
                }
                if (temp >= n){
                    break;
                }
            }
        }

        public void even(IntConsumer printNumber) throws InterruptedException {
            while (true){
                if (n < 2)break;
                //P
                while(lock_2 == 0){
                    synchronized (this){
                        wait(10);
                    }
                }
                lock_2 = 0;//close
                if (next <= n) {
                    printNumber.accept(next);
                }

                //V
                next++;
                int temp = next;
                lock_0 = 1;

                synchronized(this){
                    notifyAll();
                }
                if (temp >= n){
                    break;
                }
            }
        }
    }

    public static void main(String[] args){
        IntConsumer c = System.out::print;
        ZeroEvenOdd o = new ZeroEvenOdd(5);
        Thread t1 = new Thread(() ->{
            try {
                o.zero(c);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "t1");
        Thread t2 = new Thread(() ->{
            try {
                o.odd(c);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "t2");
        Thread t3 = new Thread(() ->{
            try {
                o.even(c);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "t3");
        t1.start();
        t2.start();
        t3.start();
    }
}
