package com.butterfly.sword;

/**
 * 青蛙跳台阶(1 或 2 级)
 * 题目描述:一只青蛙一次可以跳上 1 级台阶，也可以跳上 2 级。求该青蛙跳上一
 * 个 n 级的台阶总共有多少种跳法。 思路:斐波那契数列思想
 */
public class Question8 {

    public static void main(String[] args) {

        System.out.println(jumpMethod(1));
        System.out.println(jumpMethod(2));
        System.out.println(jumpMethod(3));
        System.out.println(jumpMethod(4));
        System.out.println(jumpMethod(5));

        System.out.println(jumpFloor(1));
        System.out.println(jumpFloor(2));
        System.out.println(jumpFloor(3));
        System.out.println(jumpFloor(4));
        System.out.println(jumpFloor(5));
    }

    public static int jumpMethod(int steps) {
        if (steps < 3) {
            return steps;
        }
        return jumpMethod(steps - 1) + jumpMethod(steps - 2);
    }

    public static int jumpFloor(int n) {
        if (n < 3) {
            return n;
        }
        int result = 0;
        int preOne = 2;
        int preTwo = 1;
        for (int i = 3; i <= n; i++) {
            result = preOne + preTwo;
            preTwo = preOne;
            preOne = result;
        }
        return result;
    }
}
