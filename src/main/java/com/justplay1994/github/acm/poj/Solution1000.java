package com.justplay1994.github.acm.poj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author huangzezhou
 * @date 2019/11/3
 * 1000:翻转卡片
 */

public class Solution1000 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)) ;
        String str = br.readLine() ;
        str = str.replace("\n", "");
        int n = Integer.parseInt(str.split(" ")[0]);
        int m = Integer.parseInt(str.split(" ")[1]);

        int[][] a = new int[n][n];
        for (int i = 0; i < n; i++){
            str = br.readLine();
            String[] s = str.replace("\n","").split(" ");
            for (int j = 0; j < n; j++){
                a[i][j] = Integer.parseInt(s[j]);
            }

        }
        int result = 0;
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                if (a[i][j] == 0){
                    if (i + m -1 >= n || j + m - 1 >= n){
                        System.out.println("-1");
                    }else {
                        result++;
                        for (int k = i; k < i + m; k++){
                            for (int p = j; p < j + m; p++){
                                a[k][p] = a[k][p] == 0 ? 1 : 0;
                            }
                        }
                    }
                }
            }
        }
        System.out.println(result);
    }

}
