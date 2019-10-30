package com.cjy.chapter10.t5_map

/** map介绍与创建方式
  *
  * Map：散列表，存储的是键值对映射数据
  * 分类：可变、不可变两种map
  * 顺序：不可变map有序、可变map无序
  */
object T1_CreateMap01 {
  def main(args: Array[String]): Unit = {

    //1. 特性
    //1.1 map创建，默认是不可变map,包对象中定义：val Map = immutable.Map
    //1.2 key-value：类型支持Any，也就是说任意类型
    //1.3 每个kv对都是一个，Tuple2元素

    //2. 创建不可变map
    //方式一：单个
    val m1 = Map("A" -> 1)
    val m2 = Map(("a", 1))  //对偶元组方式
    //方式二：多个元素
    val m3 = Map("A" -> 1, "B" -> 2)
    val m4 = Map(("A", 1), ("B" -> 2), ("C", 1))
    println("m1:  " + m1)
    println("m2:  " + m2)
    println("m3:  " + m3)
    println("m4:  " + m4)

    /** 输出结果看出有序性
      * m1:  Map(A -> 1)
      * m2:  Map(a -> 1)
      * m3:  Map(A -> 1, B -> 2)
      * m4:  Map(A -> 1, B -> 2, C -> 1)
      */

    //3. 创建可变Map---无序性
      import scala.collection.mutable  //需要导包
      val a1 = mutable.Map(("a",1),("b",2),("c",3))
      println("a1:  " + a1)
      //a1:  Map(b -> 2, a -> 1, c -> 3)  输出结果看出---无序性

    // 4. 创建空集合
     val a2 = new scala.collection.mutable.HashMap[String,Int]
    println("a2:  " + a2)  //a2:  Map()

    // 5. 对偶元组
    val a3 = mutable.Map(("A", 1), ("B" -> 2), ("C", 1))
  }
}
