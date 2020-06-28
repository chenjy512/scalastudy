package com.cjy.chapter11

/**
  * 高阶函数练习
  */
object T2_highOrderFunOperator02 {
  def main(args: Array[String]): Unit = {

    //1. 将函数赋值给变量
    val f1 = sayHello _ //将函数赋值给变量，不执行
              //    f1   不能执行函数
                    f1()//执行函数
    var f2 = sayHello //将函数赋值给变量立即执行
    //val f3 = sum   sum有参数所以不能这么定义   --->错误

    println("----------------------高阶函数测试-------------------------")

    //2. 高阶函数测试，带有参数输出的函数参数
    //2.1 调用方式一
    var d1: Double = highOrderFun(sum _,3.3)
    println(d1)
    //2.1 调用方式二
    d1 = highOrderFun(sum(_),4.4)
    //2.1 调用方式三
    val f3 = sum _
    d1 = highOrderFun(f3(_),6.6)
    //    highOrderFun(f3 _,5.5)  错误示范，因为f3不能执行函数  --->错误
    println(d1)

    //3.高阶函数测试，无参数与输出的函数为参数的高阶函数
    highOrderFun2(sayHello)
  }

  //普通函数
  def sayHello():Unit={
    println("hello~~~~")
  }
  //普通函数
  def  sum(n:Double):Double={
    n*2
  }

  /**
    * 高阶函数解析
    * @param f  表示一个函数，此函数输入一个double参数，输出double类型
    * @param n  普通参数
    * @return   返回值double
    */
  def highOrderFun(f:Double=>Double,n:Double):Double={
    f(n)
  }

  /**
    * 高阶函数解析
    * @param f :接收一个没有参数且无返回值的函数为参数
    */
  def highOrderFun2(f:()=>Unit):Unit={
          f()
  }
}
