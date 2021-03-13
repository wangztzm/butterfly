package com.butterfly.sword;

/**
 * 单例设计模式 题目描述:设计一个类，只能生成该类的一个实例。 思路:非线程安全与线程安全
 */
public class Question2 {
    // 懒汉式
    private String data = "aaa";
    private static Question2 question2 = new Question2();

    private Question2() {
    }

    public static Question2 getInstant() {
        return question2;
    }

    public static void main(String[] args) {
        System.out.println(Question2.getInstant());
    }
}
