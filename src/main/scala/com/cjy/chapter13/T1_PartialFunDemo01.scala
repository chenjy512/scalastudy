package com.cjy.chapter13

object T1_PartialFunDemo01 {
  def main(args: Array[String]): Unit = {
    /*
给你一个集合 val list = List(1, 2, 3, 4, "abc") ，请完成如下要求: 将集合 list 中的所有数字+1，并返回一个新的集合
要求忽略掉 非数字 的元素，即返回的 新的集合 形式为 (2, 3, 4, 5)
*/

    val list = List(1, 2, 3, 4, "abc")
    val fl = list.filter(filter) //过滤
    val fl2 = list.filter(_.isInstanceOf[Int]) //过滤
    println(fl)
    //三种编写方式
    val ints1 = fl.map(deal)
    val ints2 = fl.map(x  => x.toString.toInt+1) //转换，计算
    val ints3 = fl.map(_.toString.toInt+1)
    println(ints1)
    println(ints2)
    println(ints3)

    //---------------偏函数处理
    val p = new PartialFunction[Any,Int] {
      override def isDefinedAt(x: Any) = {
        x.isInstanceOf[Int] //检验
      }
      override def apply(v1: Any) = {
        v1.asInstanceOf[Int]+1 //计算isDefinedAt返回true的数据
      }
    }
    val ints = list.collect(p)
    println("collect:"+ints)

    //偏函数简写方式
    val list2 = List(3,4,5.4,3.4,"fds")
    val ints4 = list2.collect({
      case i: Int => i + 1
      case j: Double => (j*2).toInt
    })
    println("ints4:"+ints4)
  }
  //类型转换-数据计算
  def deal(n:Any):Int={
    n.toString.toInt+1
  }
  //数据过滤
  def filter(n:Any):Boolean={
    n.isInstanceOf[Int]
  }
}
