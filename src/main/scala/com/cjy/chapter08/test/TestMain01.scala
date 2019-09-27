package com.cjy.chapter08.test

/**
  * 静态练习 8.1.7
  */
object TestMain01 {

  def main(args: Array[String]): Unit = {
//    println(Frock.getNextNum())
//    println(Frock.getNextNum())
    //创建三个对象，按照编号自增100
    val f1 = new Frock
    val f2 = new Frock
    val f3 = new Frock
    println(f1.serialNumber)
    println(f2.serialNumber)
    println(f3.serialNumber)
  }
}

class Frock{
  //相当于默认构造器初始化赋值
  var serialNumber:Int=Frock.getNextNum()
}
object Frock{
  //静态私有变量
  private var currentNum:Int=1000000
  //每次调用增加100
  def getNextNum():Int={
    currentNum = currentNum+100
    currentNum
  }
}