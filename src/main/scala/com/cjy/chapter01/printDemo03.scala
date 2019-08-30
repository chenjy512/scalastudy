package com.cjy.chapter01

/**
  * print：打印的三种方式
  */
object printDemo03 {

  def main(args: Array[String]): Unit = {

    val str = "hello"
    val num = 12
    val num2 = 15.65
    //第一种：可以用 + 连接
    println(str+num)
    //hello12

    //第二种：格式化打印，使用 %跟特定字母,不会换行，如：
    // %s 表示string类型
    // %d 表示整型
    // %f 表示浮点型
    printf("第二种方式：%s  %d",str,num)
    //第二种方式：hello  12
    printf("第二种方式：%s  %d %f",str,num,num2)
    //第二种方式：hello  12 15.650000
    printf("第二种方式：%s  %d %.2f",str,num,num2)
    //第二种方式：hello  12 15.65

    //第三种方式：
    println(s"第三种方式：str=$str  -- num=${num+10}")
    //第三种方式：str=hello  -- num=22
  }
}


