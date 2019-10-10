package com.cjy.chapter08.diejia04

/**
  * 8.4.10 扩展类： 特质可以继承类，用来扩展该特质的一些功能
  *
  */
object Kuozhan5 {
  def main(args: Array[String]): Unit = {
    val d = new KuozhanDemo1
    d.log
//错误示范
//    val d3 = new KuozhanDemo3
//    d3.log
    //正确示范
    val d4 = new KuozhanDemo4
    d4.log
  }
}

//1. 该特质继承了Exception，并且继承该特质的类会自动变成Exception类的子类
trait LoggedException extends Exception {
  def log: Unit = {
    //    getMessage：是Exception中的方法
    println(getMessage)
  }
}

//2. 继承该特质后，可反编译其源码看结果，如下
class KuozhanDemo1 extends LoggedException {

}

/** 编译后的源码，继承了Exception，实现了LoggedException
  * public class KuozhanDemo1
  * extends Exception
  * implements LoggedException
  * {
  * public KuozhanDemo1()
  * {
  *LoggedException.class.$init$(this);
  * }
  * *
  * public void log()
  * {
  *LoggedException.class.log(this);
  * }
  * }
  */

//3. 假设由于 类A 继承了该特质（B） 的类会自动变成特质父类（C）的子类，所以继承特质的类 A 已经继承的另一个类（D），
// 要求 D 必须是特质父类 C 的子类，不然会出现多继承状况： A extends C extends D --> 由于 D 不是 C 的子类，错误
class KuozhanDemo2 {}

//3.1 错误示范，继承类KuozhanDemo2 不是 Exception子类
//class KuozhanDemo3 extends KuozhanDemo2 with LoggedException {}
/**继承了不是Exception的其他类--异常信息
Error:(51, 46) illegal inheritance; superclass KuozhanDemo2
 is not a subclass of the superclass Exception
 of the mixin trait LoggedException
class KuozhanDemo3 extends KuozhanDemo2 with LoggedException {}
  */

//3.2 正确示范，继承类RuntimeException为Exception子类
class KuozhanDemo4 extends RuntimeException with LoggedException{}