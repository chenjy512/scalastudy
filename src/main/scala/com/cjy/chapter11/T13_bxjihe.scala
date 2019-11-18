package com.cjy.chapter11

/** 版本不同：2.13之前
  * 并行集合
  */
/*
object T13_bxjihe {
  def main(args: Array[String]): Unit = {
    (1 to 5).foreach(print(_)) //12345 有序
    println()
    (1 to 5).par.foreach(print(_)) //13254 无序
    （1 to 10)
    println()
    //查看集合中访问元素的线程
    val result1 = (0 to 100).map{case _ => Thread.currentThread.getName}.distinct
    val result2 = (0 to 100).par.map{case _ => Thread.currentThread.getName}.distinct
    println(result1) //非并行
    println(result2) //并行
  }
}*/

//2.13  版本使用---并行集合待解决
object T13_bxjihe {
  def main(args: Array[String]): Unit = {
    val list = List(1 to 10)

    (1 to 5).foreach(print(_)) //12345 有序
    println()
//    (1 to 5).par.foreach(print(_)) //13254 无序
    list
    println()
    //查看集合中访问元素的线程
    val result1 = (0 to 100).map{case _ => Thread.currentThread.getName}.distinct
//    val result2 = (0 to 100).par.map{case _ => Thread.currentThread.getName}.distinct
    println(result1) //非并行
//    println(result2) //并行
  }
}
