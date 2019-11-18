package com.cjy.chapter12

/**
  * 元组匹配：只有长度匹配与相同值匹配与默认匹配三种
  */
object T5_matchTuple {
  def main(args: Array[String]): Unit = {
    //如果要匹配 (10, 30) 这样任意两个元素的对偶元组，应该如何写
    for (pair <- Array((0, 1), (1, 0), (10, 30), (1, 1), (1, 0, 2))) {
      val result = pair match { // case (0, _) => "0 ..." // case (y, 0) => y //
        case (10,30) => pair + " -相同值匹配"
        case (x, y) => (y, x) //"匹配到(x,y)" + x + " " + y
        case _ => "other" //.
      }
      println(result)
    }

    /**
      * (1,0)
      * (0,1)
      * (10,30) -相同值匹配
      * (1,1)
      * other
      */

  }
}
