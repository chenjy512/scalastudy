package com.cjy.chapter13

//函数作为一个变量传入到了另一个函数中，那么该作为参数的函数的类型是：function1，即：(参数类型) => 返回类型
object T2_FunParameter {
  def main(args: Array[String]): Unit = {
    def plus(x:Int):Int = x+3
    //将plus函数传给map
    val result1 = Array(1, 2, 3, 4).map(plus(_))
    println(result1.mkString(",")) //(4,5,6,7)
    println("puls 的函数类型 function1" + (plus _))
  }
}
