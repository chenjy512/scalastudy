package com.cjy.chapter05.myexception

object ScalaExceptionDemo {

  def main(args: Array[String]): Unit = {
    try {
      val r = 10 / 0
    } catch {
      //说明
      //1. 在 scala 中只有一个 catch
      //2. 在 catch 中有多个 case, 每个 case 可以匹配一种异常 case ex: ArithmeticException
      //3. => 关键符号，表示后面是对该异常的处理代码块
      //4. finally 最终要执行的
      case ex: ArithmeticException => {
        println("捕获了除数为零的算数异常")
//        println(ex.getMessage)
      }
      case ex: Exception => println("捕获了异常")
    } finally {
      // 最终要执行的代码
      println("scala finally...")
    }
    println("ok,继续执行~~~~~")

    try {
      f11()
    }catch {
      case ex:Exception =>println("捕获了异常")
    }finally {
      println("finall --- 继续执行")
    }
    println(111)
  }

  def test(): Nothing = {
    throw new ArithmeticException("算术异常")//Exception("异常 NO1 出现~")
  }
  @throws(classOf[NumberFormatException])//等同于 NumberFormatException.class
  def f11() = {
    "abc".toInt
  }
}
