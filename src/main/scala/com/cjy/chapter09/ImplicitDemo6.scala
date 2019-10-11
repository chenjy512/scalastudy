package com.cjy.chapter09

/**
  * 隐式转换基本前提：1. 隐式转换不能有二义性
  *                   2. 隐式转换不能嵌套使用
  */
object ImplicitDemo6 {
  def main(args: Array[String]): Unit = {
    implicit def f2(d:Double):Int={
            d.toInt
//      var num:Int=123.3  //由于scala版本无法测试出此问题， 2.11.12 无此问题
     }
    val i:Int=12.3
    println(i)
  }
}
