package com.justplay1994.github.acm.leetcode;

import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.HashSet;

/**
 * 1226. 哲学家进餐
 * 22:30
 */
public class Solution1226 {

    class DiningPhilosophers {
        //先试着锁住一个，成功了再试另一个，失败了就全放了。
        //方法一：cas + 自旋
        //方法二：锁
        volatile int[] a= new int[]{1,1,1,1,1};
        Unsafe unsafe;


        public DiningPhilosophers() {
            Field field = null;
            try {
                field = Unsafe.class.getDeclaredField("theUnsafe");
                field.setAccessible(true);
                unsafe = (Unsafe) field.get(null);
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }

        }

        // call the run() method of any runnable to execute its code
        public void wantsToEat(int philosopher,
                               Runnable pickLeftFork,
                               Runnable pickRightFork,
                               Runnable eat,
                               Runnable putLeftFork,
                               Runnable putRightFork) throws InterruptedException {
            HashSet<Integer> set = new HashSet<>();
            set.clone();
        }
    }
}
