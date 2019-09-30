package com.cjy.chapter08.test

import com.cjy.chapter08.traitdemo.{TraitAbstract, TraitClass}

/**
  * 创建对象的方式：1. 完整类直接new
  *                 2. 伴生类中 apply方法
  *                 3. 抽象或特质的匿名子类对象
  *                 4. 特质动态混入创建方式
  */
object TestMain02 {
  def main(args: Array[String]): Unit = {
    //1.
    val c1 = new TraitClass
    //2.
    val list = List(1 to 10)
    //3.
    val t1 = new TraitAbstract {
      override def sayHello: Unit = {}
    }
    //4.
    val c2= new TraitClass with Dynamic

    //以上就是4中创建对象的方式。
  }
}
