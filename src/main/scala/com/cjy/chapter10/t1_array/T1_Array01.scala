package com.cjy.chapter10.t1_array

/**
  *通过 new 的方式创建数组，简单实用示范
  */
object T1_Array01 {
  def main(args: Array[String]): Unit = {
    //1. 数组创建
    //[Int]：表示泛型
    //(3)：数组长度
    val arr = new Array[Int](3)

    //2. 数组长度
    println(arr.length)

    //3. 数组根据坐标赋值
    arr(0) = 0
    arr(1) = 1
    arr(2) = 2

    //4. 数组遍历
    for (i <- arr) {
      print(i + ",")
    }

    //5. 根据坐标取值
    val index = arr(1)
    println("\n 根据坐标取值" + index)

    //6. 根据坐标赋值，也能修改值
    arr(0) = 99
    println(arr(0))

//    Array(1 to 10).foreach(println(_))
  }
}
