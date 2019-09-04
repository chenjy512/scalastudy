package com.cjy.chapter05.fundetails

object Details02 {

  def main(args: Array[String]): Unit = {
    //8. Scala 语法中任何的语法结构都可以嵌套其他语法结构(灵活)，即：函数中可以再声明/定义函数，类中可以再声明类 ，方法中可以再声明/定义方法
    sayHello

    //在 main 函数中定义函数
    def sayOk(): Unit = { // private final sayOk$1 ()
      println("main sayOk")

      def sayOk(): Unit = { // private final sayOk$2 ()
        println("sayok sayok")
      }
    }


    //9. Scala 函数的形参，在声明参数时，直接赋初始值(默认值)，这时调用函数时，如果没有指定实参，则会使用默认值。
    // 如果指定了实参，则实参会覆盖默认值。
    demo1() //默认值
    demo1("小红") //修改默认值

    /**
      * 10 .如果函数存在多个参数，每一个参数都可以设定默认值，那么这个时候，传递的参数到底是覆
      * 盖默认值，还是赋值给没有默认值的参数，就不确定了(默认按照声明顺序[从左到右])。在这种情况下，
      * 可以采用带名参数 [案例演示+练习]
      */
    mysqlCon() //全部使用默认值
    println("----------------------")
    mysqlCon("192.168.1", 5548) //默认按照参数从左到右赋值
    println("----------------------")
    mysqlCon(user = "zhangsan", pwd = "zhdingcanshuxiugai") //指定参数修改，不按照顺序
  }

  //函数中定义函数
  def sayHello(): Unit = {
    println("say hello ")

    def sayHello1(): Unit = {
      println("say hello --> 1111")
    }
  }

  //初始化参数默认值
  def demo1(name: String = "xiaoming"): Unit = {
    println("name 值=" + name)
  }

  //多个函数初始化参数值
  def mysqlCon(add: String = "localhost", port: Int = 3306,
               user: String = "root", pwd: String = "root"): Unit = {
    println("add=" + add)
    println("port=" + port)
    println("user=" + user)
    println("pwd=" + pwd)
  }
}
