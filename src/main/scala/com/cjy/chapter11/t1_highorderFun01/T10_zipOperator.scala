package com.cjy.chapter11.t1_highorderFun01

/**
  * 拉链：在开发中，当我们需要将两个集合进行 对偶元组合并，可以使用拉链。
  */
object T10_zipOperator {
  def main(args: Array[String]): Unit = {
    val list1 = List(1, 2, 3)
    val list2 = List("A", "B", "C")
    val list3 = List("A", "B")
    val tuples = list1.zip(list2)
    println(tuples) //List((1,A), (2,B), (3,C))
    val tuples1 = list1.zip(list3)
    println(tuples1) //List((1,A), (2,B))

    /**
      * 1.不局限于list，也可以使用Array
      * 2.注意合并的两个集合长度一致，否则集合长的部分元素丢失
      */
  }
}
