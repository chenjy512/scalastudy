package com.cjy.chapter08.traitdemo2

/**
  * 特质：1.可以替代java接口
  *       2.可以对单继承机制一种补充
  */
object mytrait03 {

  def main(args: Array[String]): Unit = {
    val d = new D1
    val b = new B1
    d.connect()
    b.connect()
  }
}

//指定规则
trait Trait01{
  def connect()
}

class A1{}
//具体实现
class B1 extends A1 with Trait01{
  override def connect(): Unit = {
    println("获取mysql连接~~~")
  }
}

class C1{}
//具体实现
class D1 extends C1 with Trait01{
  override def connect(): Unit = {
    println("获取oracle连接~~~")
  }
}