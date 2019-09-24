package com.cjy.chapter07.scalapackage

/**
  * scala 使用打包技术来解决上面的问题，不同包下 Tiger 类
  */
object TestTiger {

  def main(args: Array[String]): Unit = {
    //创建不同包下，同名类的对象
    val t1 = new com.cjy.chapter07.scalapackage.xh.Tiger
    val t2 = new com.cjy.chapter07.scalapackage.xm.Tiger
    println(t1)
    println(t2)
  }
}
