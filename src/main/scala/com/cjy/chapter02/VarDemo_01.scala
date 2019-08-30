package com.cjy.chapter02

/**
  * 定义变量的方式
  */
object VarDemo_01 {

  def main(args: Array[String]): Unit = {
    //1. 完整变量定义讲解
    //var 修饰符
    //p 变量名
    // Int 类型
    //12 变量值
    var p: Int = 12

    //2. 变量修饰符： val与var，
    //var：修饰的变量定义后可修改
    //val：修饰的变量只读，不可再更改，类比java中final，由于val没有线程安全问题，所以效率高
    //val 使用方式：一般从数据口查询的数据，定义其变量地址不能变化，但是值可以
    val per = new Person //变量不可变
    per.name = "张三" //其值可以修改
    per.age = 18

    val a = 12
    //    a=19  这行语法编译报错，val修饰不能修改
    p = 20 //var 可修改

    //3. 类型推导---定义变量时不显示指定类型，根据值编译器会推导出其具体类型
    val p2 = 11
    val p3 = 11.3
    println(p2.isInstanceOf[Int]) //true
    println(p3.isInstanceOf[Double]) //    true

    //4. 变量类型确定后不能修改，可以转换
    //    p2 = 11.3 报错

    //5.值类型，有 Byte\Short\Int\Long\Double\Float\Char\Boolean ,同java类似，其值范围一样
    val b: Byte = 1
    val l: Long = 1

    //6. 类型转换：隐士类型转换、强制类型转换
    //强制类型转换，每个值类型都可以调用 toXXX函数转换类型
    val s = "100"
    p = s.toInt
    println(p)
    println(s.toDouble)
    //隐士类型转换--当精度小的类型与精度大的类型做计算时，默认结果转为精度大的类型
    var y1: Short = 12
    var y2: Int = 1
    var y3 = y1+y2 //其结果值为Int类型
    println("隐士类型转换："+y3.isInstanceOf[Int])

    //7. 默认类型
    val m1 = 1 //整型默认值是int，超出其范围默认是long
    val m2 = 1.11 //浮点型默认是double
    println(m1.isInstanceOf[Int])
    println(m2.isInstanceOf[Double])

  }
}

//类定义
class Person {
  var name: String = ""
  var age: Int = 0
}
