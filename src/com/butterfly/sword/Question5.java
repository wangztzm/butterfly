package com.butterfly.sword;

import java.util.Stack;

/**
 * 从尾到头打印链表 题目描述:输入一个链表，从尾到头打印链表每个节点的值。
 */
public class Question5 {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;
        stackWay(node1);
        recursionMethod(node1);
    }

    public static void stackWay(ListNode node1) {
        Stack<ListNode> stack = new Stack<>();
        ListNode node = node1;
        while (node != null) {
            stack.push(node);
            node = node.next;
        }

        while (!stack.empty()) {
            System.out.println(stack.pop().val);
        }
    }

    /**
     * 虽然我也能写出来，但是我还是觉得人家写的比较好啊
     *
     * @param node
     */
    public static void recursionMethod(ListNode node) {
        if (node != null) {
            if (node.next != null) {
                recursionMethod(node.next);
            }
            System.out.println(node.val);
        }
    }
}
