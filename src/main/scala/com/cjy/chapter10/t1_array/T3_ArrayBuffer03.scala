package com.cjy.chapter10.t1_array

import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer

/**
  * 可变长数组基本操作：crud、遍历
  */
object T3_ArrayBuffer03 {
  def main(args: Array[String]): Unit = {
    val arr = ArrayBuffer[Int]()
    //1. 数组长度
    println(arr.length)
    //2. 追加数据
    arr.append(1)
    arr.append(2, 3, 4)
    println(arr.length)
    //3.根据坐标取值
    val res = arr(2)
    println("res:" + res)
    //4. 根据坐标修改数据
    println(arr(0))
    arr(0) = 99 //修改值
    println(arr(0))

    //5. 根据坐标移除元素
    arr.remove(0)
    for (i <- arr) {
      print(i + "\t")
    }
    //----------------------------数组其他操作
    //计算数组中的所有值和
    val sum = arr.sum
    println("\n" + sum)

    //清空数组中的元素，length=0，则看出并不是把数据赋值为null，而是清空
    arr.clear()
    println(arr.length)

    //可变长数组与不可变长数组间转换
    //toArray：转为不可变长数组
    //toBuffer：转为可变长数组
    val arr2: Array[Int] = arr.toArray    //可变长数组转不可变长数组
    val arr3: mutable.Buffer[Int] = arr2.toBuffer   //不可变长数组转变长数组
  }
}
