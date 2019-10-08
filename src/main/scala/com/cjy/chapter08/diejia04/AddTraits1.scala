package com.cjy.chapter08.diejia04

/**
  * 叠加特质：构建对象的同时如果混入多个特质，称之为叠加特质，那么特质声明顺序从左到右，方法执行顺序从右到左
  *
  * 叠加特质分析：1.对象的构建顺序从左到右，
  *               2.和执行叠加特质方法的顺序从右到左，
  *               3.super不一定就是父特质，
  *               4.super调用的方法一定不能是抽象方法
  */
object AddTraits {
  def main(args: Array[String]): Unit = {
//    val mysql = new MySQL4 with DB4 with File4
//      println("----------------------------")
    //研究第 2 个问题，当我们执行一个动态混入对象的方法，其执行顺序是怎样的
    //顺序是， (1)从右到左开始执行 , (2)当执行到 super 时，是指的左边的特质 (3) 如果左边没有特质了，则 super 就是父特质
//    (4)super调用的方法不能是抽象方法。
//    mysql.insert(100)


    //练习，特质构建、方法调用顺序
    val mySQL4 = new MySQL4 with File4 with DB4
    println("----------------------------")
    mySQL4.insert(999)
  }
}

trait Operate4 { //特点
  println("Operate4...")

  def insert(id: Int) //抽象方法
}

trait Data4 extends Operate4 { //特质，继承了 Operate4
  println("Data4")

  override def insert(id: Int): Unit = { //实现/重写 Operate4 的 insert
    println("插入数据 = " + id)
//    super.insert(id)  这里继续调用会报错，因为其父特质中是抽象方法
  }
}

trait DB4 extends Data4 { //特质，继承 Data4
  println("DB4")

  override def insert(id: Int): Unit = { // 重写 Data4 的 insert
    println("向数据库")
    super.insert(id)
  }
}

trait File4 extends Data4 { //特质，继承 Data4
  println("File4")

  override def insert(id: Int): Unit = { // 重写 Data4 的 insert
    println("向文件")
    super.insert(id) //调用了 insert 方法(难点)，这里 super 在动态混入时，不一定是父类，可能是左边的特质
    //    super[Data4].insert(id)//这种调用是调用直接父类中的方法，不是昨天的特质。
    // 左边有特质是也不会执行了。这里直接调用父类终止了昨天特质的关系
  }
}

class MySQL3{
  println("MySQL3")
}
class MySQL4 {
  println("MySQL4")
} //普通类

/**
  * 叠加特质注意事项和细节
  * 1) 特质声明顺序从左到右。
  * 2) Scala 在执行叠加对象的方法时，会首先从后面的特质(从右向左)开始执行
  * 3) Scala 中特质中如果调用 super，并不是表示调用父特质的方法，而是向前面（左边）继续查找特质，如果找不到，才会去父特质查找
  * 4) 如果想要调用具体特质的方法，可以指定： super[特质].xxx(…).其中的泛型必须是该特质的直接超类类型
  * 5) super调用的方法不能是抽象方法。
  */


