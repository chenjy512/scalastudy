package com.cjy.chapter10.t1_array
/**
  * 多维数组：使用dim方法创建二维数组
  */
object T4_ArrayDuowei04 {
  def main(args: Array[String]): Unit = {
    //创建二维数组
    val arr: Array[Array[Int]] = Array.ofDim[Int](3, 3)

    //二维数组赋值或修改值
    arr(1)(1) = 5
    //二维数组遍历
    for (i <- arr) {
      for (j <- i) {
        print(j + "\t")
      }
      println()
    }
    /** 泛型是int类型，默认值是0，这点跟java一样
      * 0	0	0
      * 0	5	0
      * 0	0	0
      */
    //取值
    val res = arr(1)(1)
    println("res:" + res)

    arr(2)(2) = 9
  println("-----------------------")
    for (i <- 0 to arr.length - 1) {
      for (j <- 0 to arr(i).length - 1) {
        print(arr(i)(j) + "\t")
      }
      println()
    }
  }
}
