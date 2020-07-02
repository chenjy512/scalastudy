package com.cjy.test

import scala.math.sqrt

object Test02 {


  def main(args: Array[String]): Unit = {
    val ar = Array(1, 333, 4, 6, 4, 4, 9, 32, 6, 9, 0, 2)
    val i = ar.reduceLeft((x, y) => if (x > y) x else y)
    println(i)

    val h = compose(f,g)
    println(h(2))
    println(h(1))
    println(h(0))
  }

  /**
    * 1、编写一个compose函数，将两个类型为Double=>Option[Double]的函数组合在一起，产生另一个同样类型的函数。
    * 如果其中一个函数返回None，则组合函数也应返回None。例如：
    * def f(x : Double) = if ( x > 0) Some(sqrt(x)) else None
    * def g(x : Double) = if ( x != 1) Some( 1 / ( x - 1)) else None
    * val h = compose(f,g)
    * h(2)将得到Some(1)，而h(1)和h(0)将得到None
    */


  def f(x : Double) = if ( x > 0) Some(sqrt(x)) else None
  def g(x : Double) = if ( x != 1) Some( 1 / ( x - 1)) else None

  def compose(f:Double=> Option[Double],g:Double =>  Option[Double]) ={
        x:Double => {
          if(f(x) == None || g(x) == None ) None else g(x)
        }
  }
}
