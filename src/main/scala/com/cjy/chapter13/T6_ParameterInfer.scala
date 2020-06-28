package com.cjy.chapter13

//参数类型推断
object T6_ParameterInfer {
  def main(args: Array[String]): Unit = {
    val list = List(1,2,3,4)

    //单参数
    println(list.map(f2(_))) //行数调用 _ 代表入参数据
    println(list.map(f2 _))  //省略括号
    println(list.map(f2))    //省略参数，默认自动填充
    //匿名函数
    println(list.map((x:Int)=>x+1))
    println(list.map((x)=>x+1))   //省略数据类型-自动推导
    println(list.map(x=>x+1))     //一个参数省略括号
    println(list.map(_ + 1))      //参数只在方法体中出现一次，可只写函数体
    println("------------------------")

    //双参数-函数调用
    println(list.reduce(f1(_,_)))
    println(list.reduce(f1))    //省略参数
    //双参数-匿名函数
    println(list.reduce((x:Int,y:Int)=>x+y))
    println(list.reduce((x,y)=>x+y))    //参数类型自动推导
    println(list.reduce(_+_))   //参数在函数体中只出现一次，可只写函数体就可
  }
  def f1(n1:Int,n2:Int)={
    n1+n2
  }
  def f2(x:Int)={
    x+1
  }
}
