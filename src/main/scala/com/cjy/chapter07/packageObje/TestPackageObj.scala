
package com.cjy{ //定义com.cjy包
  package object scala { //定义包对象
    var name = "king"

    def sayHiv(): Unit = {
      println("package object scala sayHI~")
    }
  }
  package scala{ //定义子包，并使用scala包对象中定义的函数与变量
    object Test100 {
      def main(args: Array[String]): Unit = {
        println(name)
        sayHiv()

        val p = new Person
        p.test
      }
    }
    //包对象对应的包下都可以使用包对象中的定义
    class Person{
      def test: Unit ={
        sayHiv()
      }
    }
  }
}

