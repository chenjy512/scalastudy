package com.cjy.chapter07.extend

object ExtendTest1 {
  def main(args: Array[String]): Unit = {
    val zs = new Zhangsan
    zs.info
  }
}
class Person{
  var name:String=_
  var age:Int=_
}

class Zhangsan extends Person {
  name="zss"
  age=18
  def info: Unit ={
    println("name:"+name+",age:"+age)
  }
}