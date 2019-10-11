package com.cjy.chapter09

/**
  * 隐式的转换时机（什么时候转换）：1.当方法中的参数的类型与目标类型不一致时, 或者是赋值时。
  *                                 2.当对象调用所在类中不存在的方法或成员时，编译器会自动将对象进行隐式转换（根据类型）
  */
object ImplicitDemo5 {
  def main(args: Array[String]): Unit = {
    implicit def f1(d: Double): Int = {
      println("调用隐式函数。。。")
      d.toInt
    }

    def test(p: Int): Unit = {
      println("调用test函数")
      println(p)
    }
    //传入参数类型不匹配，触发隐式函数
    test(12.9)

    /**
      * 调用隐式函数。。。
      * 调用test函数
      * 12
      */


  }
}

/** 源码解析
  * public final class ImplicitDemo5$
  * {
  * public static final  MODULE$;
  * *
  * private final int f1$1(double d)
  * {
  *Predef..MODULE$.println("������������������");
  * return (int)d;
  * }
  * *
  * private final void test$1(int p)
  * {
  *Predef..MODULE$.println("����test����");
  *Predef..MODULE$.println(BoxesRunTime.boxToInteger(p));
  * }
  * *
  * public void main(String[] args)
  * {
  * test$1(f1$1(12.9D));  //当函数传入值与参数类型不一样时，使用类型匹配
  * }
  * *
  * private ImplicitDemo5$()
  * {
  * MODULE$ = this;
  * }
  * *
  * static
  * {
  * new ();
  * }
  * }
  *
  */