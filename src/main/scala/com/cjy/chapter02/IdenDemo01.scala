package com.cjy.chapter02

/**
  * 表示符命名规范
  * Scala 中的标识符声明，基本和 Java 是一致的，但是细节上会有所变化。
  */
object IdenDemo01 {

  def main(args: Array[String]): Unit = {
    //Scala 中的标识符声明，基本和 Java 是一致的，但是细节上会有所变化。
    //首字符为操作符(比如+ - * / )，后续字符也需跟操作符 ,至少一个
    val -- = 1
    val ++ = 1
    println(++)
    //看看编译器怎么处理这个问题
    // ++ => $plus$plus

    //用反引号`....`包括的任意字符串，即使是关键字(39 个)也可以
    var `true` = "hello,scala!"
    println("内容=" + `true`)
  }

}
