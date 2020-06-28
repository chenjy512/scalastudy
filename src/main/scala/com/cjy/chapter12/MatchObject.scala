package com.cjy.chapter12

object MatchObject {
  def main(args: Array[String]): Unit = {
    val number: Double = 36.0 //Square(5.0)


    number match {
      //说明 case Square(n) 的运行的机制
      //1. 当匹配到 case Square(n)
      //2. 调用 Square 的 unapply(z: Double),z 的值就是 number
      //3. 如果对象提取器 unapply(z: Double)  返回的是 Some(6) ,则表示匹配成功，同时
      //	将 6  赋给 Square(n) 的 n
      //4.	果对象提取器 unapply(z: Double)  返回的是 None ,则表示匹配不成功
      case Square(n) => println("匹配成功 n=" + n)
      case _ => println("nothing matched")
    }
  }
}
object Square {
  def unapply(z: Double): Option[Double] = {
    println("unapply 被调用 z 是=" + z)
    Some(math.sqrt(z))
    //None
  }
  def apply(z: Double): Double = z * z

}