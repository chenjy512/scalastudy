package com.cjy.chapter06.oop

object CreateObj {
  def main(args: Array[String]): Unit = {

    val emp = new Emp // 此时emp就是 Emp类型，默认使用类型推导
    val emp2:Person = new Emp //将子类对象，交给父类引用，这时必须写上类型
    println(emp)
    println(emp2)
  }
}

class Person{}

class Emp extends Person{

}