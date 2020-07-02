package com.cjy.test

import scala.collection.mutable.ListBuffer

object Test01 {
  def main(args: Array[String]): Unit = {
    val unit = values((x:Int)=>x*x,-5,5)
    println(unit)
  }

  def values(fun:(Int)=>Int,low:Int,high:Int)={
    var list = ListBuffer[(Int,Int)]()
    (low to high).foreach{
      x => list = (x,fun(x)) +: list
    }
//    for(x <- low to high){
//      list.append((x,fun(x)))
//    }
    list
  }
}
