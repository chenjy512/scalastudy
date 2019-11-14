package com.cjy.chapter11.t1_highorderFun01

/**
  * 并行集合
  */
object T13_bxjihe {
  def main(args: Array[String]): Unit = {
    (1 to 5).foreach(print(_)) //12345 有序
    println()
    (1 to 5).par.foreach(print(_)) //13254 无序
    println()
    //查看集合中访问元素的线程
    val result1 = (0 to 100).map{case _ => Thread.currentThread.getName}.distinct
    val result2 = (0 to 100).par.map{case _ => Thread.currentThread.getName}.distinct
    println(result1) //非并行
    println(result2) //并行
  }
}
