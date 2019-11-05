package com.cjy.chapter10.t6_set

import scala.collection.mutable

/*************  set集合介绍与操作
  *
  * set：不重复元素集，无顺序，默认以哈希实现；
  * 分类：可变与不可变，默认使用不可变，使用可变需要导包（scala.collection.mutable.Set）
  */
object T1_CreateSet01 {
  def main(args: Array[String]): Unit = {
    //1. 创建集合
    //1.1 不可变集合
    val s1: Set[Range.Inclusive] = Set(1 to 3)
    println(s1)
    //1.2 可变集合
    val s2: mutable.Set[Int] = mutable.Set(1,2,3,4)
    println(s2)

    //2. 可变集合添加、删除、获取、遍历
    //2.1 添加元素
    s2.add(5)
    s2 += 6
    s2. +=(7,8)
    s2 +=(7,8)
    println(s2)  //Set(1, 5, 2, 6, 3, 7, 4, 8)  无序性、不重复

    //2.2 删除元素
    s2.remove(7)
    s2 -= 1
    s2.-=(2,3)
    s2 -=(1)    //移除不存在元素，不抛异常
    println(s2) //Set(5, 6, 4, 8) //

    //2.3 获取元素：head、tail
    //获取头部元素
    val head = s2.head
    println(head)//5
    //获取头部元素外其他所有元素组成一个新的set集，可级联使用
    val tail = s2.tail
    println("tail："+tail) //tail：Set(6, 4, 8)
    println("s2.tail.tail :"+s2.tail.tail) //s2.tail.tail :Set(4, 8)

    //2.4 遍历操作
    for(e <- s2) println(e)

    //2.5 集合中元素和
    val sum: Int = s2.sum
    println("sum:"+sum) //sum:23

    //2.5 清空集合
    s2.clear()
    println("clear："+s2)//clear：Set()
  }
}
