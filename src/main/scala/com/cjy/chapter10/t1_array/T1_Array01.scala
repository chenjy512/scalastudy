package com.cjy.chapter10.t1_array

/**
  * 数组创建方式：1.new
  *              2. 调用伴生对象的 apply方法
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

    //7. 通过apply函数创建数组
    val arr2: Array[Int] = Array(1, 2, 3)
    println("arr2 length:" + arr2.length)

    /** Array中的源码，有多个类型的apply处理函数
      *
      * def apply(x: Int, xs: Int*): Array[Int] = {
      * val array = new Array[Int](xs.length + 1)
      * array(0) = x
      * var i = 1
      * for (x <- xs.iterator) { array(i) = x; i += 1 }
      * array
      * }
      */
  }
}
