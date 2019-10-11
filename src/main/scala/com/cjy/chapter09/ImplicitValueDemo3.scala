package com.cjy.chapter09

/**
  * 隐式值：也叫隐式变量，将某个形参变量标记为 implicit，所以编译器会在方法省略隐式参数的情况下去搜索作用域内的隐式值作为缺省参数
  */
object ImplicitValueDemo3 {
  def main(args: Array[String]): Unit = {

    //1. 隐式值声明
    implicit val str1: String = "隐式值"

    def hello(implicit name: String = "默认值"): Unit = {
      println("hello: " + name)
    }
    //2. 隐式值使用
    hello //当没有传参时，默认使用隐式值

    def hello1(implicit name: Int = 222): Unit = {
      println("hello1: " + name)
    }
    //3. 默认值使用
    hello1 //没有传参、隐式值时使用默认值
    //4. 传入值使用
    hello("传入值") //传入值时，则使用传入值

    def hello2(sal:Double): Unit ={
      println(sal)
    }
    //5. 传入值、隐式值、默认值均不存在则报错
//    hello2

    //6. 当能匹配上两个隐式值时运行报错，即隐式值匹配时，不能存在二义性
//    implicit val str2:String="隐式值2222"
    hello
  }
}
/**
  *由上示例得出证明：1.传入值、隐式值、默认值三者同时存在的取值优先级，传入值>隐式值>默认值
  *                  2.三者均未使用则函数使用报错
  *                  3.隐式值匹配不能存在二义性，即能同时匹配上超过一个隐式值
  */