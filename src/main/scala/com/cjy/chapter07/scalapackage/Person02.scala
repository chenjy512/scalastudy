/**
  *1. package com.cjy{} 表示我们创建了包 com.cjy ,在{}中我们可以继续写它的子包 scala //com.atguigu.scala,
  * 还可以写类,特质 trait,还可以写 object
  */
package com.cjy {

  //1. 创建类
  class Person02(inName:String) {
    var name: String = inName
  }

  //2. 创建包--在包里创建包
  package scala {

    //3. 包下的包里面创建类
    class Student {

    }

    //4. 在com.cjy.scala 下面创建object TestObj
    object TestObj {
      def main(args: Array[String]): Unit = {
        println("ok~~~")
      }
    }

  }

  /**
    * 5. 如上，程序员可以在同一个文件中，将类(class / object)、 trait 创建在不同的包中，这样就非常灵活了
    * scala源文件会在同一个位置，但是字节码文件则会按照不同的包位置来创建
    */

  //6. 即 sacla 支持，在一个文件中，可以同时创建多个包，以及给各个包创建类,trait 和 object
  object TestObj2 {
    def main(args: Array[String]): Unit = {
      println("obj2 -----")
    }
  }

  /**
    * 7.作用域原则：可以直接向上访问。即: Scala 中子包中直接访问父包中的内容, 大括号体现作用域。
    * (提示： Java 中子包使用父包的类，需要 import)。在子包和父包 类重名时，默认采用就近原则，如果
    * 希望指定使用某个类，则带上包名即可。【案例演示+反编译】
    */
  package scala2{
      class Student2{
        var stuName="学生名字"
        //如果有相同的类，则默认采用就近原则，如果非要使用父包的类，则需要指定路径
        def getPerson2():Person02={
        return new Person02("就近原则")
        }
        def getPerson3():com.cjy.Person02={
          return new com.cjy.Person02("指定路径调用父包下的类")
        }
      }
      class Person02( val inName:String){
        val name=inName
      }
        object TestObj3 {
          def main(args: Array[String]): Unit = {
           val s1 = new Student2
            println(s1.getPerson2().name)
            println(s1.getPerson3().name)
            println(s1.getPerson2().inName)
          }
        }
  }
}

