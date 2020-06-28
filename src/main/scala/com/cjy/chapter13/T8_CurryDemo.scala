package com.cjy.chapter13

object T8_CurryDemo {

  def main(args: Array[String]): Unit = {
    /**
编写一个函数，接收两个整数，可以返回两个数的乘积，要求:
使用常规的方式完成
使用闭包的方式完成
使用函数柯里化完成
      */

    def mul(d:Int,m:Int)={d*m}    //普通多参函数
    def mulCurry(d:Int) = (m:Int)=>m*d  //闭包
    def mulCurry2(d:Int)(m:Int) = d*m   //柯里化

    println(mul(10,8))
    println(mulCurry(3)(6))
    println(mulCurry2(10)(2))
  }
}
