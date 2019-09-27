package com.cjy.chapter07.extendsdemo

/**
  * 类型转换：
  *     1. classOf[Student] ：获取类实例
  *     2. s.isInstanceOf[Persons]：判断是否是Persons类型
  *     3. s.asInstanceOf[Persons]：转成Persons类型
  */
object ClassCastDemo {
  def main(args: Array[String]): Unit = {
    val s = new Student
    val c: Class[Student] = classOf[Student] // classOf：得到class实例
    println(c) //class com.cjy.chapter07.extendsdemo.Student
    val r = s.isInstanceOf[Persons]
    println(r)
    val p: Persons = s.asInstanceOf[Persons]
    p.info()
  }
}

