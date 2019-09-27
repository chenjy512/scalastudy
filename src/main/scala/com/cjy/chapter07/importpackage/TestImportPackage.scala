package com.cjy.chapter07.importpackage

import scala.collection.mutable


/**
  * 1.包引入：Scala 引入包也是使用 import, 基本的原理和机制和 Java 一样，但是 Scala 中的 import 功能更加强大，也更灵活
  * 2.默认导入的包：因为 Scala 语言源自于 Java，所以 java.lang 包中的类会自动引入到当前环境中，
  *                 而 Scala 中的 scala包和 Predef 包的类也会自动引入到当前环境中，即起其下面的类可以直接使用。
  * 3.主动导入：如果想要把其他包中的类引入到当前环境中，需要使用 import 语言
  *             1. 包的导入不在局限于文件顶部，import作用一直延伸到包含该语句的块末尾。只在需要时引入，缩小import范围，提高效率
  *             2. java中导入包中所有类使用.*  在sacla中是 ._
  *             3. 导入同一包下的多个类，不再像java中使用多个import，可以使用 import xx.xx.{A,B,C} 这种方式导入xx.xx下的三个类
  *             4. 如果引入多个包中的类名相同，那么为了区分类可以对其进行重命名操作；
  *             如下将java中的HashMap重命名为javaMap导入:
  *                       import java.util.{HashMap => javaMap}
  *             5. 导入某个包下排除某一个类的其他所有类，如导入java.util包下不包含HashMap类的其它所有类。如： import java.util.{ HashMap=>_, _}
  */
object TestImportPackage {

  def main(args: Array[String]): Unit = {
       //2. 默认导入List
       List(1 to 10)
      //3.5 导入某个包下不含某个类的其它所有类
      import java.util.{HashMap =>_,_} //排除java.util包下的HashMap类
      import scala.collection.mutable.HashMap
      new HashMap() //这里导入的就是scala中的，如果不排除java中的HashMap这里会报错，不知道该指向那个
      new ArrayList(); //这里导入的就是java.util.ArrayList;
  }
}

class User {

  import scala.beans.BeanProperty //3.1 指定位置导入包
  @BeanProperty
  var name: String = _
  //3.3 导入同一包下的多个类
  import scala.collection.mutable.{HashMap,HashSet}


  var map = new HashMap()
  var set = new HashSet()

  def test(): Unit ={
    //3.4. 导包并对其类重命名
    import java.util.{HashMap => JavaHashMap}
    val scalaMap = new HashMap() //创建scala中的hashmap
    val javaMap = new JavaHashMap();//创建java中的hashmap
  }
}
//使用 ._ 通配符
class User2{
//  @BeanProperty   这里如果需要，则User类中导入的包在这里是不可用的。
  var name: String = _
  //3.2 导入mutable 包下的所有类
  import scala.collection.mutable._
  var map = new HashMap()
  var set = new HashSet()

}