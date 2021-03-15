package com.butterfly.sword;

import java.util.Stack;

/**
 * 题目描述:用两个栈来实现一个队列，完成队列的 Push 和 Pop 操作。 队列中的
 * 元素为 int 类型。
 */
public class Question7 {
    public final Stack<String> stack1 = new Stack();
    public final Stack<String> stack2 = new Stack();

    public static void main(String[] args) {
        // 大体明白了些，还是要根据一些树的特点来做。加油
        Question7 question7 = new Question7();
        question7.push("1");
        question7.push("2");
        question7.push("3");
        System.out.println(question7.pop());
        System.out.println(question7.pop());
        System.out.println(question7.pop());
        System.out.println(question7.pop());
    }

    public void push(String obj) {
        stack1.push(obj);
    }

    public String pop() {
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        if (stack2.isEmpty()) {
            return null;
        }
        return stack2.pop();
    }
}
