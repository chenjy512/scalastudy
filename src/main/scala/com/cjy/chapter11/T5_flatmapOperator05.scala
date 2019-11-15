package com.cjy.chapter11

/**
  *flat:压扁、压平，将每个元素的子元素映射到某个函数（参数函数）并返回新的集合
  */
object T5_flatmapOperator05 {
  def main(args: Array[String]): Unit = {
    val list = List("hello", "Worold", "Scala")
    val list1 = list.flatMap(upperCase)
    println("list:" + list)
    println("list1:" + list1)

    /**
      * list:List(hello, Worold, Scala)
      * list1:List(H, E, L, L, O, W, O, R, O, L, D, S, C, A, L, A)
      */
  }

  def upperCase(s: String): String = {
    s.toUpperCase()
  }
}
