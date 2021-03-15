package com.butterfly.sword;

/**
 * 二进制中 1 的个数
 * 题目描述:输入一个整数，输出该数二进制表示中 1 的个数。其中负数用补码表示。
 */
public class Question9 {

    public static void main(String[] args) {
        System.out.println(count1(15));
    }

    public static int count1(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n = n & (n - 1);
        }
        return count;
    }
}
