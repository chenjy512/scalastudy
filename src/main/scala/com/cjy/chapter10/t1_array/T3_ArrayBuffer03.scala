package com.cjy.chapter10.t1_array

import scala.collection.mutable.ArrayBuffer

/**
  * 可变长数组基本操作：
  */
object T3_ArrayBuffer03 {
  def main(args: Array[String]): Unit = {
    val arr = ArrayBuffer[Int]()
    //1. 数组长度
    println(arr.length)
    //2. 追加数据
    arr.append(1)
    arr.append(2,3,4)
    println(arr.length)
    //3. 根据坐标修改数据
    println(arr(0))
    arr(0)=99     //修改值
    println(arr(0))
  }
}
