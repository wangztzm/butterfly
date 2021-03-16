package com.butterfly.sword;

/**
 * O(1)时间删除链表节点 题目描述:给定单向链表的头指针和一个节点指针，在 O(1)时间复杂度内删除该节点。
 */
public class Question10 {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;
        ListNode node = node1;
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
        deleteNode(node1, node2);

        node = node1;
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }

    public static void deleteNode(ListNode head, ListNode delListNode) {
        if (head == null || delListNode == null) {
            return;
        }
        if (head == delListNode) {
            head = null;
        }
        if (delListNode.next == null) {
            ListNode node = head;
            while (node.next.next != null) {
                node = node.next;
            }
            node.next = null;
        } else {
            delListNode.val = delListNode.next.val;
            delListNode.next = delListNode.next.next;
        }
    }

}
