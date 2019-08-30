package com.cjy.chapter04

object XunhuanDemo01 {

  def main(args: Array[String]): Unit = {
    //    demo1
    //    demo2
    demo3
  }

  //计算 1—100 的和 【课后】
  def demo1() = {
    var sum = 0
    for (i <- 1 to 100)
      sum += i
    println(sum)
  }

  //统计 1——200 之间能被 5 整除但不能被 3 整除的个数
  def demo2() = {
    var count = 0
    for (i <- 1 to 200) {
      if (i % 5 == 0 && i % 3 != 0)
        count += 1
    }
    println(count)
  }

  // 打印出九九乘法表
  def demo3() = {
    for (i <- 1 to 9) {
      for (j <- 1 to i) {
        printf("%d * %d =%d \t", j, i, i * j)
      }
      println()
    }
  }
}
