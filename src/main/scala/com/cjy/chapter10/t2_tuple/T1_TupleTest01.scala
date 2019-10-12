package com.cjy.chapter10.t2_tuple

/**
  * tuple：1.元组也是可以理解为一个容器，可以存放各种相同或不同类型的数据。
  *        2.说的简单点，就是将多个无关的数据封装为一个整体，称为元组, 最多的特点灵活,对数据没有过多的约束
  *        3.注意：元组中最大只能有 22 个元素，分别是tuple1、tuple2、。。。、tuple22
  *        4.创建元组时，根据元素个数来创建对应的tuple，例如3个元素那么创建的就是tuple3，
  * 也就是说tuple的类型取决于 tuple 创建时有多少个元素
  */
object T1_TupleTest01 {
  def main(args: Array[String]): Unit = {
    //1. 创建tuple5类型
    var tuple = (1, 2, 3, 4, "wu")
    println(tuple)
    //2. 访问tuple元素
    val t1 = tuple._1
    println(t1)
    println(tuple._5)
    //根据坐标访问元素，坐标从 0 开始
    println(tuple.productElement(3))

    //3. tuple元组遍历，通过迭代器来遍历元素
    for (item <- tuple.productIterator) {
      print(item + "\t")
    }
  }
}
