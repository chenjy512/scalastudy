package com.cjy.chapter11

/**
  * reduceLeft：
  */
object T7_reduceOperator07 {
  def main(args: Array[String]): Unit = {
    //    需求： 求出 list 的和.
    val list = List(1, 20, 30, 4, 5)
    //操作
    println(list.tail)
    println(test(1)(9))
//    val reduce = list.reduce(sum)
    val left = list.reduceLeft(sum)
//    val right = list.reduceRight(sum(_, _))
//    val option = list.reduceOption(sum)
//    val lo = list.reduceLeftOption(sum)
//    val ro = list.reduceRightOption(sum)

//    println("reduce:" + reduce)
    println("left:" + left)
//    println("right:" + right)
//    println("option:" + option)
//    println("lo:" + lo)
//    println("ro:" + ro)

    /**
      * left:60
      * reduce:60
      * right:60
      * option:Some(60)
      * lo:Some(60)
      * ro:Some(60)
      */

    //总结：底层其实就只有reduceLeft、reduceRight，其他都是调用这两个函数
  }

  def sum(i: Int, n: Int): Int = {
    i + n
  }


  def foldLeft[B](z: B)(@deprecatedName('f) op: (Int, Int) => B): B = {
    z
  }
  //多参数
  def test(i:Int)(n:Int):Int={
    i+n
  }
}
