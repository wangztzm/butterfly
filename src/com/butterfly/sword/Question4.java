package com.butterfly.sword;

/**
 * 替换字符串中的空格 题目描述:将一个字符串中的空格替换成“%20”。例如:当字符串为 We Are
 * Happy.则经过替换之后的字符串为 We%20Are%20Happy。
 */
public class Question4 {
    public static void main(String[] args) {
        String s = "We Are Happy.";
        System.out.println(s.replace(" ", "%20"));
        System.out.println(replaceSpace(s));
    }

    public static String replaceSpace(String s) {
        if (s == null || s.equals("")) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                sb.append("%20");
            } else {
                sb.append(s.charAt(i));
            }
        }

        return sb.toString();
    }
}
