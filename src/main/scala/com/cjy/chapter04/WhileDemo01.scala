package com.cjy.chapter04

/**
  * while 循环控制
  * 基本结构
  * while (循环条件) {
  * 循环体(语句)
  * 循环变量迭代
  * }
  */
object WhileDemo01 {

  def main(args: Array[String]): Unit = {
    demo1
  }

  //1. while 初体验
  def demo1()={
    var i = 10
    while(i > 1){
      i -=1
      println(i)
    }
  }


}
