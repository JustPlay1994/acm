package com.justplay1994.github.acm.leetcode;

/**
 * 1226. 哲学家进餐
 */
public class Solution1226 {

    class DiningPhilosophers {

        int[] source = new int[]{0, 0, 0, 0, 0};

        public DiningPhilosophers() {

        }

        /**
         * output[i] = [a, b, c] (3个整数)
         * - a 哲学家编号。0~4
         * - b 指定叉子：{1 : 左边, 2 : 右边}.
         * - c 指定行为：{1 : 拿起, 2 : 放下, 3 : 吃面}。
         * 如 [4,2,1] 表示 4 号哲学家拿起了右边的叉子。
         * <p>
         * 主要思路1：所有人先拿左边，再拿右边，如果右边拿不到，则放下左边。0号左边的是0
         * 思路2：每次只让一个人去拿，每次都是直接拿起左右，如果左右无法同时拿起，则不拿【并发度低】,过了35%
         * 死锁必要条件：循环依赖，保持等待，不可剥夺，资源唯一
         */
        // call the run() method of any runnable to execute its code
        public void wantsToEat(int philosopher,
                               Runnable pickLeftFork,
                               Runnable pickRightFork,
                               Runnable eat,
                               Runnable putLeftFork,
                               Runnable putRightFork) throws InterruptedException {
            int left = philosopher % 5;
            int right = philosopher == 4 ? 0 : philosopher + 1;
            synchronized (this) {
                while (source[left] != 0 || source[right] != 0) {
                    //处理提前通知
                    wait(100);
                }
                source[left] = 1;
                source[right] = 1;
            }
            pickLeftFork.run();
            pickRightFork.run();
            eat.run();
            putRightFork.run();
            putLeftFork.run();
            synchronized (this) {
                source[left] = 0;
                source[right] = 0;
                notifyAll();
            }
        }
    }
}
