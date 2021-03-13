package com.butterfly.sword;

import java.util.Arrays;

/**
 * 由前序和中序遍历重建二叉树
 * 题目描述:输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列 {1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 * 哎，好多坑。
 * 看看递归三部曲：
 * 1、第一递归函数功能
 * 2、找出递归结束的条件
 * 3、第三要素：找出函数的等价关系式（递归的分解）
 */
public class Question6 {
    public static void main(String[] args) {
        // 大体明白了些，还是要根据一些树的特点来做。加油
        int[] pre = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] in = {4, 7, 2, 1, 5, 3, 8, 6};
        TreeNode node = rebuildTree2(pre, 0, pre.length - 1, in, 0, in.length - 1);
        prePrintlnTree(node);
    }

    /**
     * 重新构建树
     *
     * @param pre
     * @param in
     * @return
     */
    public static TreeNode rebuildTree(int[] pre, int[] in) {
        if (pre == null || pre.length == 0 || in == null || in.length == 0) {
            return null;
        }
        TreeNode treeNode = new TreeNode(pre[0]);
        for (int i = 0; i < in.length; i++) {
            if (pre[0] == in[i]) {
                treeNode.left = rebuildTree(Arrays.copyOfRange(pre, 1, i + 1), Arrays.copyOfRange(in, 0, i));
                treeNode.right = rebuildTree(Arrays.copyOfRange(pre, i + 1, pre.length), Arrays.copyOfRange(in, i + 1, in.length));
            }
        }
        return treeNode;
    }

    /**
     * 重新构建树
     *
     * @param pre
     * @param startPre
     * @param endPre
     * @param in
     * @param startIn
     * @param endIn
     * @return
     */
    public static TreeNode rebuildTree2(int[] pre, int startPre, int endPre, int[] in, int startIn, int endIn) {
        if (startPre > endPre || startIn > endIn) {
            return null;
        }
        TreeNode treeNode = new TreeNode(pre[startPre]);
        for (int i = startIn; i < in.length; i++) {
            if (pre[startPre] == in[i]) {
                treeNode.left = rebuildTree2(pre, startPre + 1, startPre + i - startIn, in, startIn, i - 1);
                treeNode.right = rebuildTree2(pre, startPre + i - startIn + 1, endPre, in, i + 1, endIn);
            }
        }
        return treeNode;
    }

    /**
     * 前序打印树
     *
     * @param treeNode
     */
    public static void prePrintlnTree(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        System.out.println(treeNode.val);
        prePrintlnTree(treeNode.left);
        prePrintlnTree(treeNode.right);
    }
}
