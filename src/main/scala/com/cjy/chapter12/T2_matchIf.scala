package com.cjy.chapter12

/**
  * 守卫：if条件范围使用
  */
object T2_matchIf {
  def main(args: Array[String]): Unit = {

    //1. 守卫if条件使用
    for (c <- "+-3!") {
      var sign = 0
      var digit = 0

      c match {
        case '+' => sign = 1
        case '-' => sign = -1
        case _ if c.toString.equals("3") => digit = 3  // 条件判断
        case _ if (c > 110 && c < 120) => println("110<c<120")  //范围值判断
        case _ => sign = 2
      }
      println(c + " " + sign + " " + digit)
      /**
        * + 1 0
        *- -1 0
        * 3 0 3
        * ! 2 0
        */
    }
    //2. 多个默认 _ 分支取值，只取第一个默认分支结果
      println("-------------多个默认 _ 分支执行效果")
      val num=19
      num match {
        case '+' => println("++++++")
        case '-' => println("------")
        case _ => println("默认分支1")
        case _ => println("默认分支2")
      }
    //默认分支1

    //3. 多个匹配条件--多个批评为条件下，默认执行第一个匹配条件
    num match {
      case _ if(num > 0)  => println("正数")
      case _ if num > 9 => println("两位数")
      case _ => println("到底是什么数")
    }

    //正数



  }
}
