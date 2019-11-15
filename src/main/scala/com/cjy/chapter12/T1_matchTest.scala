package com.cjy.chapter12
/**
  * 简单使用示例
  */
object T1_matchTest {
  def main(args: Array[String]): Unit = {
    val sw = "*"
    val n1 = 20
    val n2 = 6
    var res = 0
    //说明
    //1. match (类似 java switch) 和  case 是关键字
    //2. 如果匹配成功， 则 执行 => 后面的代码块.
    //3. 匹配的顺序是从上到下，匹配到一个就执行对应的 代码
    //4. =>  后面的代码块 不要写 break ,会自动的退出 match
    //5. 如果一个都没有匹配到，则执行 case _ 后面的代码块
    sw match {
      case "+" => res = n1 + n2
      case "-" => res = n1 - n2
      case "*" => res = n1 * n2
      case "/" => res = n1 / n2
      case _ => println("未匹配到")
    }
    println(res)
    val i = matchTest("/")
    println(i)
  }

  /**
    * 放入函数中
    * @param s
    * @return
    */
  def matchTest(s:String): Int ={
    val n1 = 20
    val n2 = 6
    var res = 0
    s match {
      case "+" => res = n1 + n2
      case "-" => res = n1 - n2
      case "*" => res = n1 * n2
      case "/" => res = n1 / n2
      case _ => println("未匹配到")
    }
     res
  }
}
