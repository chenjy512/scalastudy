package com.cjy.chapter06.oop

/**
  * 6.1 面向对象的信息封装，解决养猫的抽象问题
  */
object CatDemo {

  def main(args: Array[String]): Unit = {
    /**
      * 例如：养了两只猫,代表具体的事物
      */
    val c1 = new Cat
    c1.name = "白猫"
    c1.age = 3
    c1.color = "white"
    c1.info
    val c2 = new Cat
    c2.name="红猫"
    c2.age=3
    c2.color="red"
    c2.info
  }
}

/**
  * 如何定义类：
  * 创建一个猫类，三个猫的基本信息----抽象基类
  */
 class Cat {
  var name: String = _
  var age: Int = _
  var color: String = _

  def info: Unit ={
    printf("基本信息，名字=%s\t年龄=%d\t颜色=%s\n",name,age,color)
  }



}