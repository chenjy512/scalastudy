package com.cjy.chapter11

import scala.collection.mutable.ListBuffer

/**高阶函数与普通方式比较
  *
  * 高阶函数：就是能传函数的函数叫做高阶函数。
  */
object T1_highOrder01 {
  def main(args: Array[String]): Unit = {

    //案例需求：做一个案例将list中的元素乘以2放入一个新的list中

    //1. 未使用高阶函数前
    val t1: List[Int] = List(4, 6, 23)
    val bf = ListBuffer[Int]()
    for (x <- t1) {
      bf += x * 2
    }
    println(t1)
    println(bf)

    /**分析：
      * 1. 新建集合与空集合
      * 2. 循环遍历集合元素并乘2，放入空集合中
      */

    println("---------------------使用高阶函数------------------")
    val t2: List[Int] = List(4, 6, 23)
    val list2: List[Int] = t2.map(c2)
    println(list2)

    /**
      * map运行流畅：
      *       1.将 t2 中的元素依次调用遍历
      *       2.遍历的每个元素调用c2函数，返回一个新的int值
      *       3.将每个返回的新的int值放入到一个新的集合中并将集合返回
      *
      * 却别：1.普通实现
      *             1.代码通俗易懂（优点）
      *             2.不够简洁高效（缺点）
      *             3.不利于处理复杂数据处理业务，因为代码量大（缺点）
      *       2.高阶函数实现
      *             两者相反
      *
      */
  }
  def c2(i:Int):Int={
    i*2
  }
}
