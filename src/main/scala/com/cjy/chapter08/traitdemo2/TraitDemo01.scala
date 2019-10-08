package com.cjy.chapter08.traitdemo2


//trait Serializable extends Any with java.io.Serializable  特质
object TraitDemo extends Serializable {

}

/**
  * 特质：是抽象与接口的结合体，所以特质中可以有抽象方法与完整方法两种。
  *       也采用了 extends 关键字，如果有多个特质或存在父类，那么需要采用 with 关键字连接
  *
  * 特质在继承时：1.有父类的情况下继承特质
  *               2.无父类情况下继承特质
  *               3.继承多个特质
  */

trait A {
  //没有方法体的方法就是抽象方法
  def test1()
  //完整方法
  def test2(): Unit ={

  }
}
/**
  * java中的接口都可以当做特质来使用，如下使用方式
  * trait Cloneable extends java.lang.Cloneable
  */
class Demo1 extends Cloneable {
}

trait B {}
class D {}

//继承单个特质
class F extends A {
  override def test1(): Unit = println(111)
}
//继承多个特质
class C extends A with B {
  override def test1(): Unit = {}
}
//继承父类、多个特质
class E extends D with A with B {
  override def test1(): Unit = println(111)
}

