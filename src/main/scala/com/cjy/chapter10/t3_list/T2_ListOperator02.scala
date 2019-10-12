package com.cjy.chapter10.t3_list

/**
  * 集合操作：
  */
object T2_ListOperator02 {
  def main(args: Array[String]): Unit = {
    val list1 = List(1, 2, 3)
    //1.根据坐标取出数据
    val res = list1(0)
    println("res:" + res)

    //2. 数据追加，由于List是不可变集合，所以追加元素其实是新生成一个集合将之前集合中数据与追加数据放入其中，原始集合不变
    //2.1 集合最后追加元素
    val list2: List[Int] = list1 :+ 4
    println("list1:" + list1)
    println("list2:" + list2)

    //2.2 集合最前面追加元素
    val list3 = 0 +: list1
    println("list3:" + list3)
    //    list1:List(1, 2, 3)
    //    list2:List(1, 2, 3, 4)
    //    list3:List(0, 1, 2, 3)

    //2.3 :: 符号使用，
    // 1.向集合中新建集合添加元素、
    // 2.运算时集合一定要放置在最右边、
    // 3.运算规则从右向左
    // 4.从右向左，依次将最后一个集合前的数据放入集合中
    val list4 = 5 :: 6 :: list2 :: Nil
    println("list4:" + list4) //list4:List(5, 6, List(1, 2, 3, 4))
    // 1) List()
    // 2) List(List(1, 2, 3, 4))
    // 3) List(6,List(1, 2, 3, 4))
    // 4) List(5,6,List(1, 2, 3, 4))

    val list5 = 6 :: 7 :: list1 :: List(4, 5)
    println("list5:" + list5) //list5:List(6, 7, List(1, 2, 3), 4, 5)
    // 1) List(4,5)
    // 2) List(List(1, 2, 3),4,5)
    // 3) List(7, List(1, 2, 3),4,5)
    // 4) List(6, 7, List(1, 2, 3), 4, 5)

    // ::: 符号使用规则，将最后一个集合前的所有集合扁平化放入新集合中
    val list6 = 6 :: 7 :: list1 ::: Nil
    println("list6:" + list6) //list6:List(6, 7, 1, 2, 3)
    // 1) List()
    // 2) List(1, 2, 3)
    // 3) List(6, 7, 1, 2, 3)
    val list7 = 0 :: list1 ::: List(4, 5) ::: List(6, 7)
    println("list7:" + list7) //list7:List(0, 1, 2, 3, 4, 5, 6, 7)
  }
}
