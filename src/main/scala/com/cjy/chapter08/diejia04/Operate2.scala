package com.cjy.chapter08.diejia04

/**
  * 富接口：即该特质中既有抽象方法，又有非抽象方法。
  */
trait Operate2 {

  //抽象方法
  def get(id: Int)

  //完整方法
  def pageQuery(pageno: Int, pagesize: Int): Unit = {
    println("特质中的完整方法")
  }
}
