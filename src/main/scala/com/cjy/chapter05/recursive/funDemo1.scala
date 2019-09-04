package com.cjy.chapter05.recursive

/**
  * 函数定义方式
  */
object funDemo1 {

  def main(args: Array[String]): Unit = {
    println("hello world")
    println(test1(1, 1))
    println(test2)
    println(test3) //()  无返回值
    println(test4) //()  无返回值
  }

  //1.完整带参数与指定返回值类型
  //def 方法名（参数名：类型，参数名：类型）：返回值类型={语句，有过没有return 关键字，则默认最后一行结果作为返回值}
  def test1(p1: Int, p2: Int): Int = {
    p1 + p2
  }

  //2. 不带参数，返回值类型不确定，使用类型推导
  def test2() = {
    "使用类型推导，确定返回值类型"
  }

  //3.Unit表示无返回值，相当于java 中的 void
  def test3(): Unit = {
    return "显示指出没有返回值，此return 不生效"
  }

  //4. 无返回值，简化书写方式
  def test4() {
    println("无返回值，简写方式")
    return "return 不生效"
  }
}
