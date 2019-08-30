package com.cjy.chapter01

/**
  * 方法讲解
  */
object MthodDemo04 {

  /**
    * main主函数，程序的入口与java main一样
    * def：方法修饰符，类比java 的 public、private...
    * main：方法名
    * args：参数名
    * Array[String]：参数类型
    * Unit：返回值，表示无返回值，类比java中void
    */
  def main(args: Array[String]): Unit = {
    //1. 无参数函数调用
//      demo1()
//      demo1//可以省略 ()
    // 简写函数
//      demo2
    demo3(19,22)
    val res = demo4(14,53)
    println("demo4:"+res)
  }

  //1. 方法demo1--无参数，无返回值
  def demo1(): Unit = {
    println("无参数、无返回值函数")
  }

  //简化demo1 的编写方式
  def demo2={
    println("无参数、无返回值函数,编写方式二")
  }

  //2. 有参函数编写
  def demo3(p1:Int,p2:Int)={
    println("计算p1+p2="+(p1+p2))
  }

  //有参函数,有返回值
  def  demo4(p1:Int,p2:Int):Int={
    return p1+p2
  }

}