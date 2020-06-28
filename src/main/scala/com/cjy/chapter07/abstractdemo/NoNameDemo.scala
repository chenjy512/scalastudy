package com.cjy.chapter07.abstractdemo

object NoNameDemo {
  def main(args: Array[String]): Unit = {
    val demo = new NoNameDemo1 {
      override def cry(): Unit = {
        println("我是匿名实现类")
      }
      override var bl = 12
    }
    demo.cry()
  }
}

//抽象类
abstract class NoNameDemo1{
  def cry()
  var bl:Int
  var name:String="zhangsan "

  def show: Unit ={
    println("show~~~")
  }
}