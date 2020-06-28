package com.cjy.chapter13

object T4_HigherOrderFunction {
  def main(args: Array[String]): Unit = {
    //单个函数入参
    println(test(sum,4))//4+4
    //多函数入参
    println(test2(sum,cj,4))//4*2+4*2


  }

  def test(f:Double=>Double,n1:Double)={
    f(n1)
  }
  def test2(f:Double=>Double,f2:Double=>Double,n:Double)={
    f(f2(n))
  }
  def sum(d:Double)={
    d+d
  }
  def cj(d:Double)={
    d*2
  }
}
