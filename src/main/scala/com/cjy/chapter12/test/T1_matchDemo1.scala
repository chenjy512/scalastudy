package com.cjy.chapter12.test

/**
  * case 简单练习
  */
object T1_matchDemo1 {
  def main(args: Array[String]): Unit = {
    val s: String = "3"
    s match {
      case "1" => println("情况1")
      case "2" => println("情况2")
      case "3" => println("情况3")
      case _ => println("默认执行分支")
    }
    test("1")
  }

  def test(s:String):Unit={
    s match {
      case "1" => {
        println("情况1---start")
        println("case中可以编写{}内容信息")
        println("情况1---end")
      }
      case "2" => println("情况2")
      case "3" => println("情况3")
      case _ => println("默认执行分支")
    }
  }
}


