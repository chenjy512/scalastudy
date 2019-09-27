package com.cjy.chapter08.staticdemo

/**
  * 在伴生对象中定义 apply 方法，可以实现： 类名(参数) 方式来创建对象实例.
  */
object ApplyDemo {
  def main(args: Array[String]): Unit = {
    val p1 = Pig()
    println(p1.name)
    val p2 = Pig("猪八戒")
    println(p2.name)
    val p3 = new Pig("new 八戒")
    println(p3.name)
  }
}


class Pig(inName: String) {
  var name: String = inName
}

object Pig {
  def apply(inName: String): Pig = new Pig(inName)

  def apply(): Pig = new Pig("匿名猪")
}