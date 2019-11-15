package com.cjy.chapter11

import scala.collection.{SeqView, immutable}


/**
  *stream懒加载的特性集合同样可以实现，调用集合view方法产生一个懒加载特性的集合，不使用集合中的元素时不会加载数据，
  * 并且view不会缓存数据，每次重新计算
  */
object T12_viewsOperatorTest {
  def main(args: Array[String]): Unit = {
    //需求：请找到 1-100 中，数字倒序排列 和它本身相同的所有数。(1 2, 11, 22, 33 ...)
    //1.方式一
    val list1: List[Range.Inclusive] = List(1 to 100)
    for (i <- list1(0)) {
      if (eq(i)) {
        println(i)
      }
    }
    //2.方式二
    val res: immutable.IndexedSeq[Int] = (1 to 100).filter(eq(_))
    println(res)

    //3.方式三，使用view 来完成这个问题,程序中，对集合进行 map,filter,reduce,fold...
    //你并不希望立即执行，而是在使用到结果才执行，则可以使用 view 来进行优化
    val view: SeqView[Int, immutable.IndexedSeq[Int]] = (1 to 100).view.filter(eq)
    println(view) //未使用时，不加载
        for (item <- view){
          println("item=" + item) //使用时加载
        }

  }

  //比较本身顺序逆序是否相等
  def eq(i: Int): Boolean = {
    val str = i.toString
    str.equals(str.reverse)
  }
}
