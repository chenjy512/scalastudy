package com.cjy.chapter05.test

object MainTest {

  def main(args: Array[String]): Unit = {
    test(11)
  }

  /**练习1，输出如下金字塔形状
        *
       ***
      *****
     *******
    *********
    *
    * 分析，每行图案分为两个部分，一个是空白处，一个是*号，找出两个部门的每行规律即可
    */
  def test(h: Int): Unit = {
    //    val h: Int = 6;
    for (i <- 1 to h) {
      for (j <- 1 to h - i) {
        print(" ")
      }
      for (k <- 1 to (2 * i - 1)) {
        print("*")
      }
//      for (m <- 1 to h - i) {
//        print(" ")
//      }
      println()
    }
  }

}
