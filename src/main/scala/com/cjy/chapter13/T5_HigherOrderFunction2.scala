package com.cjy.chapter13

/**
  * 函数返回值是函数
  */
object T5_HigherOrderFunction2 {
  def main(args: Array[String]): Unit = {
      val fun = minussy(100)
      println(fun(80)) //20
      println(fun(30)) //70
  }
  //返回类型：匿名函数
  def minussy(x:Int) ={
    (y:Int)=>x-y  //返回匿名函数
  }

}
