package com.cjy.chapter10.t3_list.test

/**
  * 针对t2操作符练习
  */
object Test1_T2 {
  def main(args: Array[String]): Unit = {
    //1.√
    val list1 = List(1, 2, 3, "hello")
    val list2 = 4 :: 5 :: list1
    println("list2:" + list2) //ist2:List(4, 5, 1, 2, 3, hello)

    //2. 错误，最右边只能是集合
    //    val list3 = 4::5::list1::9

    //3.√
    val list4 = 4 :: 5 :: list1 :: Nil
    println("list4:" + list4) //list4:List(4, 5, List(1, 2, 3, hello))

    //4.√
    val list5 = 4 :: 5 :: list1 ::: list1 ::: Nil
    println("list5:" + list5) //list5:List(4, 5, 1, 2, 3, hello, 1, 2, 3, hello)
  }
}
