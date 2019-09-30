package com.cjy.chapter08.traitdemo

//trait Serializable extends Any with java.io.Serializable  特质
object TraitDemo extends Serializable {

}

//java中的接口都可以当做特质来使用，如下使用方式
//trait Cloneable extends java.lang.Cloneable
class Demo1 extends Cloneable {

}

/**
  * 特质是抽象与接口的结合体，所以特质中可以有抽象方法与完整方法两种。
  */
trait A {
  //没有方法体的方法就是抽象方法
  def test1()
  //完整方法
  def test2(): Unit ={

  }
}

trait B {}

//继承多个特质
class C extends A with B {
  override def test1(): Unit = {}
}

class D {}

//继承父类、多个特质
class E extends D with A with B {
  override def test1(): Unit = ???
}

//继承单个特质
class F extends A {
  override def test1(): Unit = ???
}