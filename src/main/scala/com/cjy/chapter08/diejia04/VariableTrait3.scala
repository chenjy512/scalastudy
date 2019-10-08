package com.cjy.chapter08.diejia04

/**
  * 1. 特质中可以定义具体字段，如果初始化了就是具体字段，如果不初始化就是抽象字段。混入该特质
  * 的类就具有了该字段，字段不是继承，而是直接加入类，成为自己的字段
  *
  * 2. 特质中未被初始化的字段在具体的子类中必须被重写
  */
object VariableTrait3 {
  def main(args: Array[String]): Unit = {
//    println(11)
    val demo = new VariableDemo with VariableTrait {
      override var sar: Int = 12 //抽象字段必须重写
    }
    val demo2 = new VariableDemo with VariableTrait {
      override var sar: Int = 18 //抽象字段必须重写
    }
    println(demo.name)

  }
}

trait VariableTrait {

  var sar: Int
  var name: String = "张三"

}

class VariableDemo{}