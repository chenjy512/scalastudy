package com.cjy.chapter07.extendsdemo

/**
  * 继承的作用：1. 代码服用
  *             2. 父类中修改信息，子类都可以通过继承使用
  *
  * 子类继承了什么？
  *             1. 父类所有属性，当然私有需要通过相应的公共方法才能访问
  *
  *当一个类extends另外一个类的时候，override的规则基本如下：
          子类中的方法要覆盖父类中的方法，必须写override
          子类中的属性val要覆盖父类中的属性，必须写override
          父类中的变量不可以覆盖
  */
object TestExtends {
  def main(args: Array[String]): Unit = {
    println(11)
    val stu: Student = new Student
    stu.name="小明"
    stu.age=19
    stu.sex="男"
    stu.info

    val t:Teacher = new Teacher
    t.name="数学老师"
    t.age=28
    t.sex="女"
    t.info
    t.bhzl

  }
}

//人的基本特征：姓名、年龄、性别
class Persons{
  var name:String=_
  var age:Int=_
  var sex:String=_

  //修饰符测试
  //方法默认是public
  def info(){}

  private def siy(){println("我是person类中私有函数")} //子类无法使用
  protected def bh(){println("我是person中 protected 修饰方法")} //子类可以使用

}
//学生肯定有person中定义的基本要素，那么学生也有自己的特点，如：班级、专业、兴趣、爱好。。。
class Student extends Persons{
//variable name cannot override a mutable variable
//  override var name:String="111"   不能重写父类 var属性

  def play={
    println("学生爱好")
  }

  override def info: Unit = {
    printf("学生信息：\n 姓名=%s 年龄=%d 性别=%s \n",name,age,sex)
  }
}
//老师也有自己特色，如交什么课程、交几年级、是否结婚。。。
class Teacher extends Persons{

  def jiaox={
    println("老师教学")
  }
  override def info: Unit = {
    printf("老师信息：\n 姓名=%s 年龄=%d 性别=%s \n",name,age,sex)
  }
  def bhzl={
    bh()
//    siy 无法访问
  }
}
