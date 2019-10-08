package com.cjy.chapter08.staticdemo1

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
    //静态方式调用
    val p4 = Pig.apply()
    println(p4.name)
  }
}


class Pig(inName: String) {
  var name: String = inName
}

object Pig {
  //伴生对象中的函数相当于静态函数，可通过  类名.方法  来使用
  def apply(inName: String): Pig = new Pig(inName)

  def apply(): Pig = new Pig("匿名猪")
}