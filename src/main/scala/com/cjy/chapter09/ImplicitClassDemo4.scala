package com.cjy.chapter09

/**
  * 隐式类：
  */
object ImplicitClassDemo4 {

  //3. 隐式类范围测试，此处可以
  //  implicit class OrderBase(val o:OrderService){
  //    def addDelete(): Unit ={
  //      println("删除。。。")
  //    }
  //  }
  def main(args: Array[String]): Unit = {

    //1. 隐式类声明
    implicit class OrderBase(val o: OrderService) {
      def addDelete(): Unit = {
        println("删除。。。")
      }
    }
    //2. 隐式类使用
    val d = new OrderService
    d.save()
    d.addDelete()
  }
}

class OrderService {
  def save(): Unit = {
    println("save....")
  }
}

//3. 隐式类范围测试，此处不可以
//implicit class OrderBase(val o:OrderService){
//  def addDelete(): Unit ={
//    println("删除。。。")
//  }
//}

/**
  * 4. 隐式类使用源码分析：
  *
  * 4.1 main方法所在伴生对象类
  * public final class ImplicitClassDemo4$
  * {
  * public static final  MODULE$;
  * *4.2 根据隐式类生成处理函数，返回隐式类，调用隐式类函数
  * private final ImplicitClassDemo4.OrderBase.2 OrderBase$1(OrderService o)
  * {
  * return new ImplicitClassDemo4.OrderBase.2(o);
  * }
  * *
  * public void main(String[] args)
  * {
  * OrderService d = new OrderService();
  *d.save();
  * //4.3 使用隐式类中的方法时，调用处理函数
  * OrderBase$1(d).addDelete();
  * }
  * *
  * private ImplicitClassDemo4$()
  * {
  * MODULE$ = this;
  * }
  * *
  * static
  * {
  * new ();
  * }
  * }
  *
  * 4.4 隐式类源码
  * public class ImplicitClassDemo4$OrderBase$2
  * {
  * private final OrderService o;
  * *
  * public OrderService o()
  * {
  * return this.o;
  * }
  * *
  * public void addDelete()
  * {
  *Predef..MODULE$.println("删除。。。");
  * }
  * *
  * public ImplicitClassDemo4$OrderBase$2(OrderService o) {}
  * }
  *
  *
  * 调用过程解析：调用隐式类函数时：1.调用隐式类创建函数；2.调用隐式类函数
  */