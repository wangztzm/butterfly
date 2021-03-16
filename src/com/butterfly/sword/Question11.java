package com.butterfly.sword;

/**
 * 将数组中的奇数放在偶数前
 * 题目描述:输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得
 * 所有的奇数位于数组的前半部分，所有的偶数位于位于数组的后半部分，并保证奇
 * 数和奇数，偶数和偶数之间的相对位置不变
 * 我感觉人家写的更加清晰易懂
 */
public class Question11 {

    public static void main(String[] args) {
        int[] array = {8, 4, 11, 2, 5, 7, 9};
        reOrderArray(array);
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

    public static void group(int[] array) {
        if (array == null || array.length == 0) {
            return;
        }
        int i = 0;
        int j = array.length - 1;
        while (i < j) {
            if (array[i] % 2 == 0) {
                for (; j > i; j--) {
                    if (array[j] % 2 == 1) {
                        int tmp = array[i];
                        array[i] = array[j];
                        array[j] = tmp;
                        break;
                    }
                    continue;
                }
            }
            i++;
        }
    }

    public static void reOrderArray(int[] array) {
        if (array == null || array.length == 0) {
            return;
        }
        int left = 0;
        int right = array.length - 1;
        while (left < right) {
            while (left < right && array[left] % 2 != 0) {
                left++;
            }
            while (left < right && array[right] % 2 == 0) {
                right--;
            }
            if (left < right) {
                int tmp = array[left];
                array[left] = array[right];
                array[right] = tmp;
            }
        }
    }
}
