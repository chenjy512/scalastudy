package com.cjy.chapter08.inner5


/**
  * 内部类：定义 Scala 的成员内部类和静态内部类，并创建相应的对象实例。
  */
object InnerClassDemo {

}

//伴生类
class ScalaOuterClass1 {
  //成员内部类
  myOut => //如上操作一个是外部，一个是内部。当内部age注销时，会自动访问外部，必须放置在属性上方
  var name: String = "zhangsna"
  private var age: Int = 18

  class ScalaInnerClass1 {
    /**
      * 2. 内部类访问外部类属性：
      *   2.1.当内部类与外部类无同名属性时可以直接按照属性名访问
      *   2.2.当内部类与外部类有同名属性是直接访问的是就近原则，内部类中的。此时想访问外部类需要ScalaInnerClass1.this.name
      *   2.3. 外部类别名方式访问 --> 外部类名别名.属性名=myOut.age
      */
    var name: String = "inner"
    var age: Int = 12

    def show: Unit = {
      println("姓名：" + ScalaInnerClass1.this.name + "\t age:" + age)
      //如上操作一个是外部，一个是内部。当内部age注销时，会自动访问外部
      println("别名方式--》姓名：" + myOut.name + "\t age:" + myOut.age)

    }

    /**
      * 姓名：inner	 age:12
      * 别名方式--》姓名：zhangsna	 age:18
      */

    //3. 测试类型投影
    //    def test(ic: ScalaInnerClass1): Unit = {
    def test(ic: ScalaOuterClass1#ScalaInnerClass1): Unit = { //改进
      System.out.println("使用了类型投影" + ic)
    }
  }

}

//伴生对象
object ScalaOuterClass1 {

  def main(args: Array[String]): Unit = {
    //---1. 创建内部类实例
    //1.1 成员内部类
    //    val o1 = new ScalaOuterClass1
    //    println(o1)
    //    val i1 = new o1.ScalaInnerClass1
    //    println(i1)
    //1.2 静态内部类
    //    val s1 = new ScalaOuterClass1.ScalaStaticInnerClass1
    //    println(s1)

    //---2. 内部类访问外部类属性
    //如上：2.1、2.1、2.3

    //---3. 类型投影
    /**
      * 类型投影是指：在方法声明上，如果使用 外部类#内部类 的方式，表示忽略内部类的对象关系，
      * 等同于 Java 中内部类的语法操作，我们将这种方式称之为 类型投影（即：忽略对象的创建方式，
      * 只考虑类型）
      */
    val o1 = new ScalaOuterClass1
    val o2 = new ScalaOuterClass1
    val i1 = new o1.ScalaInnerClass1
    val i2 = new o2.ScalaInnerClass1
    //def test(ic: ScalaInnerClass1)
    //此时参数受限于外部对应影响，无法 i1.test(i2) 使用
    i1.test(i1)
    i2.test(i2)
    //def test(ic: ScalaOuterClass1#ScalaInnerClass1)    -- 类型投影
    //此时参数受限于外部对应影响，无法 i1.test(i2) 使用
    i1.test(i2)
    i2.test(i1)

  }

  //静态内部类
  class ScalaStaticInnerClass1 {

  }

}