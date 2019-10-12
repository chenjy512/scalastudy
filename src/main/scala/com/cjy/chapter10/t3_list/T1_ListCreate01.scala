package com.cjy.chapter10.t3_list

/**
  * 前言：scala中的List与java中的list不一样，在java 中list是一个接口真正存放数据的是ArrayList
  * 在scala中list是一个object可直接存放数据，默认情况下scala中list是不可变，list属于序列seq。
  * val List = scala.collection.immutable.List
  * object List extends SeqFactory[List]
  */
object T1_ListCreate01 {
  def main(args: Array[String]): Unit = {
    //1.创建list对象

    val list1 = List(1, 2, 3, 4)
    //2. 遍历集合
    for (i <- list1)
      print(i + "\t")
    println()
    //3. 空集合使用
    var list2 = Nil
    print(list2.size)

    /**总结
      * 1. List默认情况下集合不可变
      * 2 List 在 package object scala 做了 val List = scala.collection.immutable.List，所以可直接使用不用导包
      * 3 val Nil = scala.collection.immutable.Nil // List() Nil:空集合，并不是null
      * 4 List可以使用任何类型 List[Any]
      */
  }
}
