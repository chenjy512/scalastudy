package com.cjy.chapter05.mylazy

/**
  * 惰性函数：只有在实际使用时才会被调用
  */
object mylazy {

  def main(args: Array[String]): Unit = {
    lazy val res = sum(10, 20)
    println("-----------")
    println("res:" + res)

    /** 有打印日志可以的出，只有在使用res时才会去调用函数进行计算
      * -----------
      * sum 函数被执行了
      * res:30
      */

    //2. lazy 不能修饰var变量
    //    lazy var res2 = sum(11, 23)
    lazy val n = 10;
//    println(n)
  }

  def sum(p1: Int, p2: Int) = {
    println("sum 函数被执行了")
    p1 + p2
  }
}
