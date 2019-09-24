package com.cjy.chapter06.oop.constrictor

import scala.beans.BeanProperty

/**
  * 6.5 Bean 属性
  * JavaBeans 规范定义了 Java 的属性是像 getXxx（）和 setXxx（）的方法。许多 Java 工具（框架）
  * 都依赖这个命名习惯。为了 Java 的互操作性。将 Scala 字段加@BeanProperty 时，这样会自动生成规范
  * 的 setXxx/getXxx 方法。这时可以使用 对象.setXxx() 和 对象.getXxx() 来调用属性
  */
object BeanPropertDemo {
  def main(args: Array[String]): Unit = {
    val c = new Car
    //测试set、get函数使用，其实编译器在生成字节码文件时创建了这两个函数
    c.setName("法拉利")
    println(c.getName)
  }
}

/**
  * scala的get、set辅助函数
  */
class Car {
  @BeanProperty //只需要在变量上添加此注解，默认会生成get、set方法
  var name: String = null
}

//6.6.2流程分析(面试题-写出)
class Person {
  var age: Short = 90
  var name: String = _
  def this(n: String, a: Short) {
    this()
    this.name = n
    this.age = a
  }
}
//var p : Person = new Person("小倩",20)
//1) 加载类的信息(属性信息，方法信息)
//2) 在内存中(堆)开辟空间
//3) 使用父类的构造器(主和辅助)进行初始
//4) 使用主构造器对属性进行初始化 【age:90, naem nul】
//5) 使用辅助构造器对属性进行初始化 【 age:20, naem 小倩 】
//6) 将开辟的对象的地址赋给 p 这个引用