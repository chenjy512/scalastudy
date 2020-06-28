package com.cjy.chapter07.classcast

object ClassCaseTest {
  def main(args: Array[String]): Unit = {
    val s = "king"
    //ClassOf 的使用,可以得到类名
    println(classOf[String]) // 输出
    println(s.getClass.getName) //使用反射机制

    //isInstanceOf asInstanceOf
    var p1 = new Person200
    var emp = new Emp200
    //将子类引用给父类(向上转型,自动)
//     var p1 = emp
    var p2:Person200 = emp
    //将父类的引用重新转成子类引用(多态),即向下转型
    var	emp2 = p2.asInstanceOf[Emp200]
     emp2.sayHello()
    println(p2.isInstanceOf[Emp200])
    println(p2.isInstanceOf[Person200])
  }
}
class Person200 {
  var name: String = "tom"
  def printName() { //输出名字println("Person printName() " + name)
  }
  def sayHi(): Unit = { println("sayHi...")
  }
}
class Emp200 extends Person200 {
  //这里需要显式的使用 override
  override def printName() {
  println("Emp printName() " + name)
  //在子类中需要去调用父类的方法,使用 super super.printName()
  sayHi()
    }
    def sayHello(): Unit = {
      println("sayHello()")
        }
}