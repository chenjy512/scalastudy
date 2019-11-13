package com.cjy.chapter11.t1_highorderFun01

/**
  * stream：
  */
object T11_streamOperator {
  def main(args: Array[String]): Unit = {
    //创建 Stream
    def numsForm(n: BigInt) : Stream[BigInt] = n #:: numsForm(n + 1)
    val stream1 = numsForm(11)
    println(stream1) //
//    println(numsForm(2))
    println(stream1.head)
    println(stream1.tail.tail)
    println(stream1) //
  }
}