package com.justplay1994.github.acm.leetcode;

/**
 * 2020/05/16 16:25
 * 1117. H2O 生成
 */
public class Solution1117 {

    class H2O {

        /**
         * 思路1：H释放两个，O释放一个。因此信号量，H=2，O=1，释放新的信号量的任务就交给H，因为两个H消耗的时间会更长，不容易产生等待。
         * 思路1错误：因为最后那个解释不成立，他是同时建立所有线程，然后排队进行消费。如果完全单线程进行，是会超时的，因此需要考虑哪些阶段是可以并发的。
         *
         * 思路2：所有的H、O线程，首先获取资源（2H 1O），获取成功后，判断是不是最后一个资源，如果是，则进行新资源的释放。这个过程都得唯一才行
         */

        int h = 2;
        int o = 1;

        final Object ooo = new Object();
        final Object hhh = new Object();
        public H2O() {

        }

        public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
            //critical section
            synchronized (this){
                while (h == 0){
                    wait(100);
                }
                h--;
                if (h == 0 && o == 0){
                    h = 2; o = 1;
                    notifyAll(); //有一个问题，如果当前没氧气资源，但是被notify的是o，那么o就wait了，也没有其他H线程执行了。因此应该通知所有
                }
                // releaseHydrogen.run() outputs "H". Do not change or remove this line.
                releaseHydrogen.run();
            }


        }

        public void oxygen(Runnable releaseOxygen) throws InterruptedException {
            synchronized (this){
                while (o == 0){
                    wait(100);
                }
                o--;
                if (h == 0 && o == 0){
                    h = 2; o = 1;
                    notifyAll(); //有一个问题，如果当前没氧气资源，但是被notify的是o，那么o就wait了，也没有其他H线程执行了。因此应该通知所有
                }
                // releaseOxygen.run() outputs "O". Do not change or remove this line.
                releaseOxygen.run();
            }

        }
    }

}
