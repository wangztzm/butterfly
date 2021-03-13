package com.butterfly.sword;

/**
 * 赋值运算函数
 * 1.对于传入的参数，不应该被修改，使用final修饰；
 * 2.如果两个对象相同或值相等，不进行操作，直接返回；
 * 3.返回值最好为this，这样可以使赋值链接起来。
 * 一个缺点：此赋值从左到右进行，a=b=c等价于a=c，b不会被赋值；
 * 而如果是String的=运算，a,b都会被赋成c的值。
 */
public class Question1 {
    public static class MyString {
        String data;

        MyString(String inData) {
            data = inData;
        }

        public MyString assign(final MyString myStr) {
            if (this == myStr || this.equals(myStr)) {
                return this;
            }
            this.data = myStr.data;
            return this;
        }

        @Override
        public String toString() {
            return this.data;
        }
    }

    public static void main(String[] args) {
        MyString myString1 = new MyString("a");
        MyString myString2 = new MyString("b");
        MyString myString3 = new MyString("c");
        System.out.println(myString1.assign(myString2).assign(myString3));
        System.out.println(myString1);
        System.out.println(myString2);
        System.out.println(myString3);

    }
}
