package com.cjy.chapter11.t1_highorderFun01

/**
  * scan：扫描，即对某个集合的所有元素做 fold 操作，但是会把产生的所有中间结果放置于一个集合中保存
  */
object T9_scanOperator {
  def main(args: Array[String]): Unit = {
    val list = List(1,2,3,4,5)
    val res = list.scanLeft(5)(minus)
    println(list)//List(1, 2, 3, 4, 5)
    println(res) //List(5, 4, 2, -1, -5, -10) //将每次的fold结果保存下来，所以是 list.size+1个元素
  }

  def minus( num1 : Int, num2 : Int ) : Int = {
    num1 - num2
  }

}
