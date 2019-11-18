package com.cjy.chapter12

/**
  * 对象匹配：
  */
object T6_matchObject {
  def main(args: Array[String]): Unit = {
//      val number = Square(5.0)
      val number = Square(5.0+"")
    println(number.isInstanceOf[Double])
    number match {
      case Square(d) => println("匹配成功～～" + d)
      case _ => println("匹配失败")
    }

  }
}

object Square {
  def unapply(d: Double): Option[Double] = {
    println("调用提取器2  "+d)
    Some(math.sqrt(d))
//    None
  }

  def unapply(s:String): Option[String] = {
    Some(s+" 我是string匹配")
  }

  def apply(d: Double): Double = {
    println("调用apply 1")
    d * d
  }
  def apply(d: String): String = {
    println("调用apply 1")
    d +""
  }
}