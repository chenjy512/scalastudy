package com.cjy.chapter10.t3_list

import scala.collection.mutable.ListBuffer

/**
  * ListBuffer 是可变的 list 集合，可以添加，删除元素,ListBuffer 属于序列
  */
object T3_ListBuffer03 {
  def main(args: Array[String]): Unit = {
    val list0 = ListBuffer(1, 2, 3)
    //集合访问
    println("lst0(2)=" + list0(2)) // 输出 lst0(2)= 3
    for (item <- list0) { // 遍历，是有序
//      println("item=" + item)
    }

    //1. 动态的增加单个或多个元素
    val list1 = ListBuffer[Int]()
    list1 += 4
    list1.append(5)
    list1.append(6,7)
    println("list1:" + list1) //list1:ListBuffer(4, 5, 6, 7)

    //1.2 动态增加集合数据
    list0 ++= list1
    println("list0:" + list0) //list0:ListBuffer(1, 2, 3, 4, 5, 6, 7)
    //1.3 合并两个集合中数据到新集合中
    val list2 = list0 ++ list1
    println("list2:"+list2)  //list2:ListBuffer(1, 2, 3, 4, 5, 6, 7, 4, 5, 6, 7)
    //1.4 :+ 向新集合中添加元素，原集合不变
    val list3 = list0 :+ 0
    println("list0:"+list0)
    println("list3:"+list3)
//    list0:ListBuffer(1, 2, 3, 4, 5, 6, 7)
//    list3:ListBuffer(1, 2, 3, 4, 5, 6, 7, 0)

    /**
      * 总结：
      * +=、++=、++、:+  :从以上四个符号中可以看出不带 = 符号的不是作用在集合本身
      */

    //1.5 移除元素
    list0.remove(0)
    println("list0:"+list0)//list0:ListBuffer(2, 3, 4, 5, 6, 7)
    //1.6 替换元素
    list0(0)=99
    println("list0:"+list0)//list0:ListBuffer(99, 3, 4, 5, 6, 7)
  }
}
