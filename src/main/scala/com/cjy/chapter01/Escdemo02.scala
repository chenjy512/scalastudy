package com.cjy.chapter01

/**
  * 转义字符介绍：\t \n \r \\ \
  */
object Escdemo02 {

  def main(args: Array[String]): Unit = {
      test2()
  }

  /**
    * 练习转义字符
    * 姓名  年龄  籍贯  住址
    * 张三  15    中国  北京
    */
  def test2(): Unit = {
    println("姓名\t年龄\t籍贯\t住址")
    println("张三\t15\t\t中国\t北京")
    //注意数字的占位，所以后面需要两个\t
  }

}
