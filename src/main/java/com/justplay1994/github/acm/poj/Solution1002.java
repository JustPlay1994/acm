package com.justplay1994.github.acm.poj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author huangzezhou
 * @date 2019/11/3
 * 1002:罪犯问题
 * start 13:35
 *
 */

public class Solution1002 {

    public static void main(String[] args){
//        BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
//        b.readLine();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int k = scanner.nextInt();
        int[] isBad = new int[n];
        Arrays.fill(isBad, 0);
        for (int i = 0; i < m; i++){
            isBad[scanner.nextInt()] = 1;
        }
        List<List<Integer>> a = new ArrayList<>();
        for (int i = 0; i < n; i++){
            int temp = scanner.nextInt();
            if (temp > 0){
                a.get(temp);
            }else {

            }
        }
    }
}
