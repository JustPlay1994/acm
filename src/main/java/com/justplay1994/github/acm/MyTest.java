package com.justplay1994.github.acm;

import java.io.*;
import java.util.Scanner;

/**
 * @author huangzezhou
 * @date 2019/11/4
 * acm 输入输出方式
 */

public class MyTest {

//    public static void main(String[] args) throws Exception{
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        System.out.println(br.readLine());
//
//        File file = new File("F:\\SVN\\output\\intellij\\acm\\src\\main\\resources\\211.txt");
//        BufferedReader br1 = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
//        System.out.println(br1.readLine());
//
//        File file1 = new File("F:\\SVN\\output\\intellij\\acm\\src\\main\\resources\\test.txt");
//        StringBuilder builder = new StringBuilder();
//        builder.append("1231231231\n 123123\n 123 123\n");
//        new FileOutputStream(file1).write(builder.toString().getBytes("UTF-8"));
//    }


//    public static void main(String[] args) throws Exception{
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        br.readLine();
//
//        Scanner s = new Scanner(System.in);
//
//        File file = new File("");
//        new BufferedReader(new InputStreamReader(new FileInputStream(file)));
//
//        OutputStream outputStream =  new FileOutputStream(file);
//        outputStream.write("".getBytes("UTF-8"));
//        outputStream.close();
//    }

    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        reader.readLine();
        Scanner scanner = new Scanner(System.in);
        scanner.nextInt();
        scanner.nextLong();
    }
}
