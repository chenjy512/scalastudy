package com.cjy.chapter11

/**
  * fold：函数将上一步返回的值作为函数的第一个参数继续传递参与运算，直到 list 中的所有元素被遍
  * 历
  */
object T8_foldOperator08 {
  def main(args: Array[String]): Unit = {

    val list = List(3, 4, 5, 7)
    //1. 案例实操
    val res = list.fold(10)(minus)
    println(res)
    //2. 类比效果
    var a = 10;
    list.foreach(x => a=minus(a,x))  //fold 其底层就是这么实现效果
    println(a)
    //3. 额外扩展
    println("---------------------缩写 /:和:\\ --------------------")
    val list4 = List(1, 9)
    var i6 = (1 /: list4) (minus) // =等价=> list4.foldLeft(1)(minus) println("i6=" + i6)
    println("i6=" + i6)// -9
    i6 = (100 /: list4) (minus) //=等价=> list4.foldLeft(100)(minus) println(i6) // 输出?
    println(i6) // 输出 90
    i6 = (list4 :\ 10) (minus) // list4.foldRight(10)(minus) println(i6) // 输出? 2
    println(i6) // 输出  2
  }
  def sum(i:Int,n:Int):Int={
    i+n
  }
  def minus(n1: Int, n2: Int): Int = {
    n1 - n2
  }
}

/** 源码：
  * def fold[A1 >: A](z: A1)(op: (A1, A1) => A1): A1 = foldLeft(z)(op)
  *
  * 实际执行函数
  * def foldLeft[B](z: B)(op: (B, A) => B): B = {
  * var result = z
  * this foreach (x => result = op(result, x)) //这句是最重要的x：集合每个元素
  * result
  * }
  *
  * this   (x => result = op(result, x))
  * 循环遍历集合每一个元素，并将result与当前元素x做计算结果重新赋值给result，集合中有几个元素重复几次
  * 假设op是两个参数相加操作：result = result+n1+n2+n3+n4
  */

/*
object TestFoldLeft {
  def main(args: Array[String]): Unit = {
    val listA = List(1, 2, 3)
    val b = (10/:listA)(_+_)
    val c = listA.foldLeft(10)(_+_)
    println(b)
    println(c)
  }
}*/
