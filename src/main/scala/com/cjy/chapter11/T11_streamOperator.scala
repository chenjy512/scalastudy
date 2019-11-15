package com.cjy.chapter11

/**
  * stream：
  */
object T11_streamOperator {
  def main(args: Array[String]): Unit = {
    //创建 Stream
    def numsForm(n: BigInt) : Stream[BigInt] = n #:: numsForm(n + 1)
    val stream1 = numsForm(1)
    println(stream1)      //Stream(1, ?)
    println(stream1.head) //1
    println(stream1.tail) //Stream(2, ?)
    println(stream1)      //Stream(1, 2, ?)

    def streamTest(n:BigInt):Stream[BigInt] = n #:: streamTest(n * 2)
    val stream = streamTest(1)
    println(stream.tail.tail)
  }
}