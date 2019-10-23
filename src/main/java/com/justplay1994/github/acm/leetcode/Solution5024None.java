package com.justplay1994.github.acm.leetcode;

/**
 * 5024. 除数博弈
 * https://leetcode-cn.com/contest/weekly-contest-132/problems/divisor-game/
 */
class Solution5024None {

//    public static void main(String[] args){
//        System.out.println(divisorGame(3));
//    }
//
//    public static boolean divisorGame(int n) {
//        return alex(n);
//    }
//
//    public static boolean alex(int n){
//        int two = 2;
//        int one = 1;
//        if(n == two) {
//            return true;
//        }
//        if (n == one){
//            return false;
//        }
//        for(int i = 1; i < n; ++i){
//            if(n % i == 0) {
//                boolean result = bob( n -i);
//
//            }
//        }
//    }
//
//    public static boolean bob(int n){
//        int two = 2;
//        int one = 1;
//        if(n == two) {
//            return true;
//        }
//        if (n == one){
//            return false;
//        }
//        for(int i = 1; i < n; ++i){
//            if(n % i == 0) {
//                alex( n -i);
//            }
//        }
//    }
//
////    public static boolean recursion(int N, int num){
////        ++num;
////
////        int two = 2;
////        int one = 1;
////        if(N == two) {
////            return true;
////        }
////        if (N == one){
////            return false;
////        }
////        for(int i = 2; i < N; ++i){
////            if(N % i == 0){
////                boolean result = recursion(N - i, num);
////                if(result) {
////                    return true;
////                }
////            }
////        }
////
////        //-1操作，放后面也许会快一些
////        if (recursion(N-1, num)){
////            return true;
////        }
////
////        return false;
////    }
}