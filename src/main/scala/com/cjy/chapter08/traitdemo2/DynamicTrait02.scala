package com.cjy.chapter08.traitdemo2

/**
  * 特质：1.特质除了在类声明是继承，还可以在new对象时动态混入。耦合性低
  */
object DynamicTrait {
  def main(args: Array[String]): Unit = {
    //创建对象
    val c1 = new TraitClass
    c1.sayHi
    val c2 = new TraitClass with Dynamic {
      override def update: Unit = {println("实现特质的抽象方法")}
    }
    c2.sayHi
    c2.insert() //创建对象时，动态混入特质，使用其特质的函数
    c2.update

    //抽象类实现特质
    val t1 = new TraitAbstract {
      override def sayHello: Unit = {}
    }
    t1.sayHello
    val t2 = new TraitAbstract with Dynamic {
      override def sayHello: Unit = {
          println("抽象类中的抽象方法")
      }

      override def update: Unit = {
        println("特质中的抽象方法")
      }
    }
    t2.insert()
    t2.sayHello
    t2.update
  }
}

trait Dynamic {
  def insert(): Unit = {
    println("特质中的完整方法")
  }
  def update
}

class TraitClass {
  def sayHi: Unit = {
    println("完整类中方法")
  }
}

abstract class TraitAbstract {
  def sayHello
}