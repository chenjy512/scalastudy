package com.cjy.chapter11.t1_highorderFun01

/**
  * filter：将符合要求的元素放置到新的集合中返回；
  * 要求：就是符合参数函数的要求，参数函数返回值为true的元素
  */
object T6_filterOperator06 {
  def main(args: Array[String]): Unit = {
    /**
      * 例：将集合中包含字母c的字符串返回
      */

    val names = List("Alice", "Bob", "Nick")
    //原始操作方式
    val list1 = filter(names)
    println("list1:" + list1) //list1:List(Alice, Nick)
    //高阶函数方式
    val list = names.filter(indexofC)
    println("list:" + list) //list:List(Alice, Nick)

    //区别：原始方式代码量过大、逻辑判断过多，但是可读性较好些
  }

  //字符串包含字母c的返回，不区分大小写
  def indexofC(s: String): Boolean = {
    s.toLowerCase().indexOf("c") != -1
  }

  /**
    * 原始操作方式
    * @param list
    * @return
    */
  def filter(list:List[String]):List[String]={
    var res = List[String]()
    if(list != null && !list.isEmpty){
      for(s <- list){
          if(s.toLowerCase.indexOf("c")!= -1) res = res :+ s
      }
    }
    res
  }
}
