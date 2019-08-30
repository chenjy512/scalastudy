package com.cjy.chapter03

import scala.io._

/**
  * 运算符介绍，与java类似效果
  */
object arithmeticDemo01 {

  def main(args: Array[String]): Unit = {
    //    ssys
    //    gxys
    //    ljys
    //    jhbl
    //    syys
    jssr
  }


  //1. 算术运算符  + - * / % +正 -负 +（字符串相加）
  def ssys() = {
    val n1 = 10
    val n2 = 5
    val n3 = n1 + n2
    println("n1+n2=" + n3)
    val n4 = n1 - n2
    println("n1-n2=" + n4)
    val n5 = n1 * n2
    println("n1*n2=" + n5)
    val n6 = n1 / n2
    println("n1/n2=" + n6)
    //取模运算-公式：a % b = a - a/b * b
    val n7 = n1 % n2
    val n8 = n1 - n1 / n2 * n2
    println("n1%n2=" + n7)
    println("n1%n2=" + n8)

    //scala 中没有 ++ -- 操作
    var b = 8
    b += 1 // b++
    b -= 1 //b--
  }

  //2. 关系运算
  def gxys() = {
    var a = 9
    var b = 8
    println(a > b) // true
    println(a >= b) // true
    println(a <= b) // false
    println(a < b) // false
    println(a == b) // false
    println(a != b) // true
    var flag: Boolean = a > b // true
    println(flag)
  }

  //3. 逻辑运算符  && 逻辑与 || 逻辑或 ! 非
  def ljys() = {
    var a = false;
    var b = true;
    println(a && b)
    println(a || b)
    println(!(a || b))
  }

  //4. 赋值运算
  def fzys() = {
    var num = 2
    num <<= 2 // num = 8
    num >>= 3 // num = 4
    println("num=" + num)
    //在 scala 中支持代码块，返回值
    val res = {
      if (num > 1) "hello,ok" else 100
    }
    println("res=" + res)
  }

  //取消了java 中的 三元运算符
  def syys() = {
    val a = 5
    val b = 6
    //    val c = a==b?true:false 无此操作了
    val c = if (a == b) true else false
    println(c)
  }

  //练习题
  //1. 有两个变量， a 和 b，要求将其进行交换，但是不允许使用中间变量，最终打印结果
  def jhbl() = {
    var a = 10
    var b = 5
    a = a + b
    b = a - b //--a+b-b
    a = a - b //a+b-a+b-b
    println(a)
    println(b)
    //
  }

  //2.接收键盘输入语句练习，在编程中，需要接收用户输入的数据，就可以使用键盘输入语句来获取。 InputDemo.scala
  //要求：可以从控制台接收用户信息，【姓名，年龄，薪水】
  def jssr() = {
    println("请输入姓名")
    val name = StdIn.readLine()
    println("请输入年龄")
    val age = StdIn.readInt()
    println("请输入薪水")
    val sal = StdIn.readDouble()
    printf("用户的信息为 name=%s age=%d sal=%.2f", name, age, sal)
  }
}
