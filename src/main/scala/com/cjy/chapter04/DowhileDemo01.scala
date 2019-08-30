package com.cjy.chapter04

/**
  * do while : 最少保证执行一次
  */
object DowhileDemo01 {

  def main(args: Array[String]): Unit = {
    var i = 10
    do{
      println(i)
      i -=1
    }while(i>1)
  }
}
