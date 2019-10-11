package com.cjy.chapter10.t1_array

import scala.collection.mutable.ArrayBuffer

/**
  * 可变长数组创建方式
  */
object T2_ArrayBuffer02 {
  def main(args: Array[String]): Unit = {
    //1.1 数组声明
    val arr: ArrayBuffer[Int] = ArrayBuffer[Int]()
//    arr.(0)=0
    arr.append(1)
    arr.append(2,3,4)
    for (i <- arr){
      print(i+"\t")
    }
    println()
    //1.2 数组声明
    val arr2: ArrayBuffer[Int] = ArrayBuffer[Int](1,2,3)
    for (i <- arr2){
      print(i+"\t")
    }
    println()
    //注意，如下方式其实是第二种方式的声明，把 1 to 3 当成一个Range.Inclusive值，看下面的size 输出即可知道
    val arr3: ArrayBuffer[Range.Inclusive] = ArrayBuffer(1 to 3)
    println(arr3.size)
    for (i <- arr3){
      print(i+"\t")
    }
    println()
    //1.3 数组声明
    val arr4 = new ArrayBuffer[Int]()
//    arr4(0)=1   //java.lang.IndexOutOfBoundsException: 0  由于可变长数组声明时初始为空数组，只能使用append方式追加数据
    //arr4(0)=1  想当于修改坐标0的值，但是此时是空数组
    println("arr4:"+arr4.length )
  }
}
