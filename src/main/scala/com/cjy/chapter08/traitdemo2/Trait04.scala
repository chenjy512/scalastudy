package com.cjy.chapter08.traitdemo2

/**
  *
  */
object Trait04 {
  def main(args: Array[String]): Unit = {
    println(11)
  }
}

trait MyTrait04 {
  def test1()

  def test2(): Unit = {
    println("特质中的完成方法")
  }
}

/** 当一个特质包含具体方法与抽象方法时
  *
  * 1. 特质中只有抽象方法，底层就是一个抽象接口
  *
  * public abstract interface MyTrait04
  * {
  * public abstract void test1();
  * }
  * *
  *2. 特质中包含完整方法时，底层会新增一个 MyTrait04$class 抽象类，存放完成方法
  * *
  * public abstract class MyTrait04$class
  * {
  * public static void test2(MyTrait04 $this)
  * {
  *Predef..MODULE$.println("特质中的完成方法");
  * }
  * public static void $init$(MyTrait04 $this) {}
  * }
  *
  */

/**
  * 当类继承特质时： MyClass04.class 实现接口MyTrait04，重写接口中的两个方法，当然其中的完整方法是从MyTrait04$class中存放的完整方法调用
  */
class MyClass04 extends MyTrait04 {
  override def test1(): Unit = {
    println("实现特质抽象方法")
  }
}

/** 继承接口
  * public class MyClass04
  * implements MyTrait04
  * {
  * 完整方法的调用
  * public void test2()
  * {
  * MyTrait04$class.test2(this);
  * }
  * *
  * public MyClass04()
  * {
  * MyTrait04.class.$init$(this);
  * }
  * * 重写接口抽象方法
  * public void test1()
  * {
  *Predef..MODULE$.println("实现特质抽象方法");
  * }
  * }
  **/