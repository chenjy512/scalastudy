package com.cjy.chapter06.oop



object TestOOP {
  def main(args: Array[String]): Unit = {
    val dog = new Dog
    dog.name="旺财"
    dog.age=19
    dog.weight=14.5
    dog.say()

    val b = new Box(2,2,2)
    b.volumn()
  }
}

class Dog{
  var name:String=_
  var age:Int=_
  var weight:Double=_

  def say(): Unit ={
    println("name:"+name+",age:"+age+",weight:"+weight)
  }
}

class Box(ci:Int,ki:Int,gi:Int){
  var c:Int=ci
  var k:Int=ki
  var g:Int=gi

  def volumn(): Unit ={
    println("体积："+(c*k*g))
  }
}