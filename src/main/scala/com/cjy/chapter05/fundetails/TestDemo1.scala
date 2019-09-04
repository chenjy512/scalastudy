package com.cjy.chapter05.fundetails

object TestDemo1 {

  def main(args: Array[String]): Unit = {
    def f1 = "venassa" //
    println(f1)
  }

  //def f1 = "venassa" ,等价于如下写法，没有参数去掉(),方法体只有一行省略{大括号}
  def f1() = {
    "venassa"
  }
}
