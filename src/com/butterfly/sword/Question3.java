package com.butterfly.sword;

/**
 * 二维数组中查找目标值
 * 题目描述:在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列
 * 都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一
 * 个整数，判断数组中是否含有该整数。
 * 例子：
 * 0  1  2  3
 * 4  5  6  7
 * 8  9  10 11
 * 12 13 14 15
 * 16 17 18 19
 * 4 * 5 9中间 2，1 总长是19。mid / col mid % col。输入6
 * 4     1，0
 */
public class Question3 {
    public static void main(String[] args) {
        int[][] data = new int[4][5];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 5; j++) {
                data[i][j] = i + j;
                System.out.println(data[i][j]);
            }
        }
        System.out.println(find4(data, 7));
    }

    public static String find1(int[][] data, int target) {
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[0].length; j++) {
                if (data[i][j] == target) {
                    System.out.println(i + ":" + j);
                    return i + ":" + j;
                }
            }
        }
        return "";
    }

    public static String find2(int[][] data, int target, int startXIndex, int endXIndex, int yIndex) {
        if (yIndex > data.length - 1) {
            return "";
        }
        int midXIndex = (startXIndex + endXIndex) / 2;
        if (data[yIndex][midXIndex] == target) {
            return yIndex + ":" + midXIndex;
        }
        if (startXIndex == endXIndex) {
            yIndex++;
            return find2(data, target, 0, data[0].length - 1, yIndex);
        }
        if (target < data[yIndex][midXIndex]) {
            return find2(data, target, startXIndex, midXIndex - 1, yIndex);
        } else if (target > data[yIndex][midXIndex]) {
            return find2(data, target, midXIndex + 1, endXIndex, yIndex);
        }
        return "";
    }

    /**
     * 书本里的解决方案，感觉很巧妙啊
     *
     * @param data
     * @param target
     * @return
     */
    public static String find3(int[][] data, int target) {
        if (data == null || data.length == 0) {
            return "";
        }

        int row = 0;
        int column = data[0].length - 1;
        while (row < data.length && column >= 0) {
            if (data[row][column] == target) {
                return row + ":" + column;
            }
            if (data[row][column] > target) {
                column--;
            } else {
                row++;
            }
        }

        return "";
    }

    public static String find4(int[][] data, int target) {
        if (data == null || data.length == 0) {
            return "";
        }
        int startIndex = 0;
        int column = data[0].length;
        int endIndex = data.length * column - 1;
        while (startIndex <= endIndex) {
            int midIndex = (startIndex + endIndex) / 2;
            int val = data[midIndex / column][midIndex % column];
            if (val == target) {
                return midIndex / column + ":" + midIndex % column;
            } else if (val < target) {
                startIndex = startIndex + 1;
            } else if (val > target) {
                endIndex = midIndex - 1;
            }
        }
        return "";
    }
}
