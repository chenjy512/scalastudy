package com.cjy.chapter05.fundetails

/**
  * 函数注意事项
  */
object Details01 {

  def main(args: Array[String]): Unit = {

    //1   函数形参列表可以有多个，如果函数有参数，调用时可以不用加()
    test1
    //2   形参列表和返回值列表的数据类型可以是值类型和引用类型
    val p = new A
    test2("张三", p)
    println(p.name)
    // 3.  Scala 中的函数可以根据函数体最后一行代码自行推断函数返回值类型。那么在这种情况下，return 关键字可以省略
    test3(1, 2)
    // 4.  因为 Scala 可以自行推断，所以在省略 return 关键字的场合，返回值类型也可以省略
    tese4(1, 4)

    //5. 如果函数明确使用 return 关键字，那么函数返回就不能使用自行推断了,这时要明确写成 : 返
    //    回类型 = ，当然如果你什么都不写，即使有 return 返回值为() .
    tese5(1, 4)
    tese6(1, 4)
    //6. 如果函数明确声明无返回值（声明 Unit），那么函数体中即使使用 return 关键字也不会有返回值
    test7(1, 4)
    //7. 如果明确函数无返回值或不确定返回值类型，那么返回值类型可以省略(或声明为 Any
    test8(11)
    test9(5)
  }

  def test9(n1: Int): Any = {
    if (n1 > 10)
      "0"
    else
      "1"
  }

  def test8(n1: Int): Unit = {
    if (n1 > 10)
      "0"
    else
      "1"
  }

  //如果函数明确声明无返回值（声明 Unit），那么函数体中即使使用 return 关键字也不会有返回值
  def test7(n1: Int, n2: Int): Unit = {
    return n1 + n2
  }

  //如果返回值这里什么什么都没有写，即表示该函数没有返回值这时, return 无效,返回值为()
  def tese6(n1: Int, n2: Int) {
    return n1 + n2
  }

  //如果写了 return ,返回值类型就不能省略
  def tese5(n1: Int, n2: Int): Int = {
    return n1 + n2
  }

  def tese4(n1: Int, n2: Int) {
    n1 + n2
  }

  def test3(n1: Int, n2: Int): Int = {
    n1 + n2
  }

  def test1(): Unit = {
    println("测试函数")
  }

  def test2(p1: String, p2: A): Unit = {
    p2.name = p1
  }

  class A {
    var name = ""
  }

}
