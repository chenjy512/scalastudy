package com.cjy.chapter05.fundetails

object Details03 {

  def main(args: Array[String]): Unit = {
    //11. 递归函数未执行之前是无法推断出来结果类型，在使用时必须有明确的返回值类型
    println(test(10))

    //12. Scala 函数支持可变参数
    println(sum1()) //0个参数
    println(sum1(1, 2, 3))
    println(sum2(1)) //至少保证一个参数
    println(sum2(1, 2, 3, 4))
  }

  //递归调用必须明确指定返回值类型
  def test(n: Int): Int = {
    if (n <= 1) {
      n
    } else {
      n * test(n - 1) //如果使用类型推导，这里无法明确返回值类型，所以做乘法计算会报错
    }
  }

  //表示有0-n 个参数
  def sum1(args: Int*) = {
    var count = 0
    for (item <- args) {
      count += item
    }
    count
  }

  //表示有1-n 个参数
  def sum2(n: Int, args: Int*) = {
    var count = 0
    for (item <- args) {
      count += item
    }
    n + count
  }

  //可变形参需要写在参数列表最后，也就是最右边
  //  def sum3(args:Int*,n:Int){}
}
