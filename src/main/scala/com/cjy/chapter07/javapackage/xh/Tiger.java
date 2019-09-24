package com.cjy.chapter07.javapackage.xh;

/**
 * java中包的作用：
 * 1) 区分相同名字的类
 * 2) 当类很多时,可以很好的管理类
 * 3) 控制访问范围
 */
public class Tiger {
    public static void main(String[] args) {
        com.cjy.chapter07.javapackage.xh.Tiger t1 = new com.cjy.chapter07.javapackage.xh.Tiger();
        com.cjy.chapter07.javapackage.xm.Tiger t2 = new com.cjy.chapter07.javapackage.xm.Tiger();
    }
}
