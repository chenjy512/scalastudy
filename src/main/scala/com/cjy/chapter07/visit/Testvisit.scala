package com.cjy.chapter07.visit

/**
  * Scala 中包的可见性和访问修饰符的使用
  *
  * 1) 当属性访问权限为默认时，从底层看属性是 private 的，但是因为提供了 xxx_$eq()[类似setter]/xxx()[类似 getter] 方法，
  * 因此从使用效果看是任何地方都可以访问)
  * 2) 当方法访问权限为默认时，默认为 public 访问权限
  * 3) private 为私有权限，只在类的内部和伴生对象中可用 【案例演示】
  * 4) protected 为受保护权限， scala 中受保护权限比 Java 中更严格，只能子类访问，同包无法访问
  * 5) 在 scala 中没有 public 关键字,即不能用 public 显式的修饰属性和方法。【案演】
  * 6) 包访问权限（表示属性有了限制。同时包也有了限制），这点和 Java 不一样，体现出 Scala 包
  * 使用的灵活性
  */
object Testvisit {

  def main(args: Array[String]): Unit = {
    val c = new Clerk
    c.showInfo()
//    c.sal  无法访问private
//    c.age
    val c2 = new Clerk2
    c2.info()
  }
}

class Clerk {
  var name: String = "jack"
  private var sal: Double = 9.9
  protected var age = 10
  var job: String = "大数据开发"

  def showInfo(): Unit = {
    println(" name= " + name + " sal= " + sal)
  }
}
//通过继承，可以访问protected
class Clerk2 extends Clerk {
  def info(): Unit ={
//    println("age"+age+"sal"+sal)  无法访问private
    println("age"+age)
  }
}
//当一个文件中出现了 class Clerk 和 object Clerk
//1. class Clerk 称为伴生类
//2. object Clerk 的伴生对象
//3. 因为 scala 设计者将 static 拿掉, 他就是设计了 伴生类和伴生对象的概念
//4. 伴生类 写非静态的内容 伴生对象 就是静态内容
object Clerk{
  def test(c: Clerk): Unit = {
    //伴生对象中，可以访问 c.sal
    println("test() name=" + c.name + " sal= " + c.sal)
  }
}
