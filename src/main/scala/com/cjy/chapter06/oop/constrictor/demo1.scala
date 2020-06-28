package com.cjy.chapter06.oop.constrictor

/**
  * 6.4 scala构造器详解
  * 分为：主构造器与辅助构造器
  *
  * class 类名(形参列表) { // 主构造器
  * // 类体
  * def this(形参列表) { // 辅助构造器
  * }
  * def this(形参列表) { //辅助构造器可以有多个...
  * }
  * }
  */
object demo1 {

  def main(args: Array[String]): Unit = {
    //通过主构造器赋值
    val s1 = new Student("zhangsan", 15)
    s1.info
    //通过辅助构造器
    val s2 = new Student("lisi")
    s2.info
    //辅助构造器
    val s3 = new Student(14)
    s3.info
    //    val d1 = new Dog  //错误的使用方式
    //    println(d1)
    /** 调用私有主构造器报错：
      * Error:(28, 14) constructor Dog in class Dog cannot be accessed in object demo1
      * val d1 = new Dog
      */
    val d2 = new Dog("旺财")
    println(d2)

    // 测试构造器参数
    val b1 = new Bird("黄鹂鸟")
    println(b1.inName)
    println(b1.name)
    b1.name = "白鹤"
    println(b1.name)
//    b1.inName="小燕子" 此时构造器参数是val修饰所以只读，不可改,下面去修改修饰符继续测试
    b1.inName="小燕子"
    println(b1.inName)
  }
}

//1.主构造器，创建对象时可通过主构造器赋值
class Student(inName: String, inAge: Int) {
  var name: String = inName
  var age: Int = inAge


  /**
    *   2. 辅助构造器
    * 首行必须调用（直接或间接）调用主构造器
    */
  def this(name: String) {
    this(name, 0)
    this.name = name
  }

  //2.2 辅助构造器，间接方式调用主构造器
  def this(age: Int) {
    this("间接调用主构造器")
    this.age = age
  }

  //3. 如上多个构造器根据创建对象时的参数来区分调用


  def info: Unit = {
    printf("学生信息：姓名=%s\t年龄=%d\n", name, age)
  }
}

/**
  *  4. 如果想让主构造器变成私有的，可以在()之前加上 private，这样用户只能通过辅助构造器来构造
  * 对象了【反编译验证】
  *
  */
class Dog private() {
  var name: String = _

  def this(name: String) {
    this
    this.name = name
  }
}

/**
  * 5. 构造器参数
  *    5.1 Scala 类的主构造器的形参未用任何修饰符修饰，那么这个参数是局部变量
  *    5.2 如果参数使用 val 关键字声明，那么 Scala 会将参数作为类的私有的只读属性使用 【案例+反编
  * 译】
  *    5.3 如果参数使用 var 关键字声明，那么那么 Scala 会将参数作为类的成员属性使用,并会提供属性
  * 对应的 xxx()[类似 getter]/xxx_$eq()[类似 setter]方法，即这时的成员属性是私有的，但是可读写。【案
  * 例+反编译】
  */
//class Bird(inName:String) {  inName此时是一个局部变量
//class Bird(val inName:String) { inName 此时是一个只读私有变量
class Bird(var inName:String) { //inName 此时是一个可读写私有变量
      var name:String=inName

  override def toString: String ={
    println("name="+name)
    return ""
  }
}