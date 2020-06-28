package com.cjy.chapter13

/**
对匿名函数的说明
1. 不需要写 def 函数名
2. 不需要写返回类型，使用类型推导
3. =	变成	=>
4. 如果有多行，则使用{} 包括
  */
object T3_AnonymouseFunction {
  def main(args: Array[String]): Unit = {

    val fb = (x:Int) => x*3  //单行匿名函数
    println(fb(3)) //9

    val fb2 = (x:Int)=>{  //多行匿名函数写法
      println(x)
      x*3
    }
    println(fb2(4))
  }
}
