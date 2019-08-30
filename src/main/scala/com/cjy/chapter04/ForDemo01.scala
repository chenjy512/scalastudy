package com.cjy.chapter04

/**
  * for循环控制
  */
object ForDemo01 {

  def main(args: Array[String]): Unit = {
    //    demo1()
    //    demo2()
    //    demo3()
    //    demo4()
    //    demo5()
    //    demo6()
    //    demo7()
    //    demo8
    demo9
  }

  //1. to 表达含义：to含义  到...地方，前后闭合
  def demo1() = {
    for (i <- 1 to 3)
      println(i)
  }

  //2.until：在什么之前，前闭后开
  def demo2() = {
    for (i <- 1 until 4) {
      println("until:" + i)
    }
  }

  //3. 循环守卫，实现类似continue 功能
  def demo3() = {
    for (i <- 1 to 4 if i != 2)
      println("循环守卫：" + i)

    /**
      * 循环守卫：1
      * 循环守卫：3
      * 循环守卫：4
      */

    //3.2 相当于这种方式
    for (i <- 1 to 4) {
      if (i != 2)
        println("循环守卫2：" + i)
    }
  }

  //4. 引入变量
  def demo4() = {
    for (i <- 1 to 3; j = 4 - i)
      println(j)
    //类似
    for (i <- 1 to 3) {
      println(4 - i)
    }
  }

  //5. 循环嵌套
  def demo5() = {
    for (i <- 1 to 3) {
      for (j <- 1 to 3) {
        println("i*j=" + (i * j))
      }
    }
  }

  //6. 循环返回值
  //将遍历过程中处理的结果返回到一个新 Vector 集合中，使用 yield 关键字
  def demo6() = {
    //说明 val res = for(i <- 1 to 3) yield i 含义
    //1. 对 1 to 10 进行遍历
    //2. yield i 将每次循环得到 i 放入到集合 Vector 中，并返回给 res
    //3. i 这里是一个代码块，这就意味我们可以对 i 进行处理
    //4. 下面的这个方式，就体现出 scala 一个重要的语法特点，就是将一个集合中个各个数据
    // 进行处理，并返回给新的集合
    var res = for (i <- 1 to 3)
      yield i
    println(res)

    //案例二：
    var res2 = for (i <- 1 to 10) yield {
      if (i % 2 == 0)
        i
      else
        "不是偶数:" + i
    }
    println(res2)
  }

  //7. 使用 { } 代替 ()
  def demo7() = {
    for (i <- 1 to 3; j = i * 2) {
      printf("i =%d , j=%d \n", i, j)
    }
    //进阶一：
    for (i <- 1 to 3) {
      var j = i * 2
      printf("i =%d , j=%d \n", i, j)
    }
    //进阶二：
    for {i <- 1 to 3
         j = i * 2} {
      printf("{} i =%d , j=%d \n", i, j)
    }
  }

  //8. 控制步长
  //def apply(start: Int, end: Int, step: Int): Range = new Range(start, end, step)
  //循环从 start 到 end ，每次加 step
  def demo8(): Unit = {
    for (i <- Range(1, 10, 2))
      println(i)

    //循环守卫方式
    for (i <- 1 to 10 if i % 2 == 1) {
      println(i)
    }
  }

  //9.联系题
  //打印 1~100 之间所有是 9 的倍数的整数的个数及总和
  def demo9() = {
    val start = 1
    val end = 100
    var count = 0
    var sum = 0
    for (i <- start to end) {
      if (i % 9 == 0) {
        count += 1
        sum += i
        println(i+" 是9 的倍数")
      }
    }
    printf("个数=%d ,总和为=%d", count, sum)
  }
}
