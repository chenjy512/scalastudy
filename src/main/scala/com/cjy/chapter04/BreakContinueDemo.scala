package com.cjy.chapter04

import util.control.Breaks._

/**
  * Scala 内置控制结构特地去掉了 break 和 continue，是为了更好的适应函数化编程，推荐使用函数
  * 式的风格解决 break 和 contine 的功能，而不是一个关键字。
  */
object BreakContinueDemo {

  def main(args: Array[String]): Unit = {
    demo2()
  }

  // break() : 中断循环操作
  def demo1() = {
    var n = 1
    //breakable()函数
    //说明
    //1. breakable 是一个高阶函数：可以接收函数的函数就是高阶函数
    //2. def breakable(op: => Unit) {
    // try {
    // op
    // } catch {
    // case ex: BreakControl =>
    // if (ex ne breakException) throw ex
    // }
    // }
    // (1) op: => Unit 表示接收的参数是一个没有输入，也没有返回值的函数
    // (2) 即可以简单理解可以接收一段代码块
    // 3. breakable 对 break()抛出的异常做了处理,代码就继续执行
    // 4. 当我们传入的是代码块， scala 程序员会将() 改成{}
    breakable {
      while (n <= 20) {
        n += 1
        println("n=" + n)
        if (n == 18) {
          //中断 while
          //说明
          //1. 在 scala 中使用函数式的 break 函数中断循环
          //2. def break(): Nothing = { throw breakException }
          break()
        }
      }
    }
    println("ok~~")
  }

  //2. 通过循环守卫完成continue 效果
  def demo2() = {
    for (i <- 1 to 10 if i % 2 == 0)
      println("1-10 中 2 的倍数" + i)
    //效果等同
    for (i <- 1 to 10) {
      if (i % 2 == 0) {
        println("1-10 中 2 的倍数" + i)
      }
    }
  }
}
