package com.cjy.chapter12

/**
  * 匹配列表：list匹配时长度确定，后面要跟上 ::Nil，任意长度类似 * 号效果使用 ==> ::tail
  */
object T4_matchList {
  def main(args: Array[String]): Unit = {
    for (list <- Array(List(0), List(1, 0), List(88), List(0, 0, 0), List(1, 0, 0), List(1, 9, 0, 12, 2))) {
      val result = list match {
        case 0 :: Nil => list //相同值匹配
        case x :: y :: Nil => x + " " + y //长度匹配
        case 0 :: tail => list + "  0::tail" //模糊匹配
        case x :: tail => list + "  x::tail" //任意值，任意长度
        case x :: Nil => list + "  x::Nil" //单个长度，任意值匹配
        case _ => "something else" //因为有 x::tail所以这里无法匹配到值
      }
      println(result)

      /**
        * List(0)
        * 1 0
        * List(88)  x::tail
        * List(0, 0, 0)  0::tail
        * List(1, 0, 0)  x::tail
        * List(1, 9, 0, 12, 2)  x::tail
        */
      /**
        * 总结：1. 相同值匹配              0 :: Nil =>
        *      2. 任意值长度匹配           x :: y :: Nil =>
        *      3. 某个值开头的模糊匹配      x :: tail =>
        *      4. 某个值开头的长度确认匹配  0 :: y :: x :: Nil =>
        *      5. 任意值，任意长度的所有匹配，有点类似默认值了 x :: tail =>
        *      6. 默认匹配                _ =>
        */
    }
  }
}
