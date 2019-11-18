package com.cjy.chapter12

/**
  * 匹配数组：
  */
object T3_matchArray {
  def main(args: Array[String]): Unit = {
    val arr = Array(Array(0), Array(1, 0), Array(0, 1, 0), Array(0, 3, 9, 9))
    for (r <- arr) {
      val res = r match {
        //        case Array(x) =>"一个元素"
        //        case Array(2) => 0
        case Array(0) => 0
        case Array(x, y) => "按照长度匹配"
        case Array(0, x, y) => "以0开头的数组"
        case Array(0,_*) => "* 号模糊匹配"
        case _ => "没有匹配上"
      }
      println(res)

      /**
        * 0
        * 按照长度匹配
        * 以0开头的数组
        * 没有匹配上
        */
    }

    /**
      * 总结：1.按照数组长度匹配，可以是长度对应的x,y,z...替代码，或者是数组值本身，或者是数组前几个元素一只后面使用替代码的模糊匹配
      *      2.按照数组值匹配时，值一定相同，不同则无法匹配
      *      3.模糊匹配，前几个确定值一定相同，不确定长度时可以使用 * 代替
      */
  }
}
