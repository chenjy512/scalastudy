package com.cjy.chapter04

/**
  * if else 分支控制，分支控制有三种情况
  * 1. 单分支
  * 2. 双分支
  * 3. 多分支
  * 注意分支结构有返回值
  **/
object IfelseDemo02 {

  def main(args: Array[String]): Unit = {
    //    dfz()
    //    sfz()
    //    nfz(45)
    //分支可以有返回值
    val res = if(false) "111" else 3.3
    println(res)
  }


  //1. 单分支情况
  def dfz() = {
    val a = 10
    if (a > 6)
      println("单分支判断a > 6 是否成立")
  }

  //2. 双分支判断
  def sfz() = {
    val a = 10
    if (a > 6)
      println("双分支判断操作")
    else
      println("双分支判断结果：不成立")
  }

  //3. 多分支判断
  def nfz(n: Int) = {
    //    val n = 19
    if (n >= 100) {
      println("100 以上")
    } else if (n < 100 && n >= 80) {
      println("80 -- 100 区间")
    } else if (n < 80 && n >= 60) {
      println("60 -- 80 区间")
    } else {
      println("60 以下")
    }

  }

  /**
    * 1) 编写程序，声明 2 个 Int 型变量并赋值。判断两数之和，如果大于等于 50，打印“hello worl
    * 2) 编写程序，声明 2 个 Double 型变量并赋值。判断第一个数大于 10.0，且第 2 个数小于 20.0，打
    * 印两数之和。
    * 3) 【选作】定义两个变量 Int，判断二者的和，是否既能被 3 又能被 5 整除，打印提示信息
    * 4) 判断一个年份是否是闰年，闰年的条件是符合下面二者之一： (1)年份能被 4 整除，但不能被 100
    * 整除； (2)能被 400 整除
    */

  def test4(p: Int) = {
    if (p % 4 == 0 && p % 100 != 0 || p % 400 == 0)
      println("今年是闰年:" + p)
    else
      println("今年不是闰年：" + p)
  }

  def test3() = {
    val a = 10
    val b = 23
    val c = a + b
    if (c % 3 == 0 && c % 5 == 0)
      println("既能被 3 又能被 5 整除")
  }

  def test2() = {
    val a = 4.5
    val b = 15.3
    if (a > 10.0 && b < 20.0)
      println(a + b)
  }

  def test1() = {
    val a = 10
    val b = 20
    if (a + b > 50) {
      println("a+b>50")
    } else {
      println("a+b<50")
    }
  }
}

