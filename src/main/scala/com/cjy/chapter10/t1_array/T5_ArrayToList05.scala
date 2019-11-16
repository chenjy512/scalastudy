package com.cjy.chapter10.t1_array

import java.util

import scala.collection.mutable

object T5_ArrayToList05 {
  def main(args: Array[String]): Unit = {
    //--------------------    scala数组转java集合 2.13 之前版本使用方式
    //1. 导包，创建可变长数组
    import scala.collection.mutable.ArrayBuffer
    val arr = ArrayBuffer("1", "3", "4", "5")
//    //2. 导入buffer数组转javaList的隐式函数
//    import scala.collection.JavaConversions.bufferAsJavaList  //旧版本
//    //3. 创建java中ProcessBuilder对象 ，构造函数已经将arr转为 javaList 类型
//    val builder = new ProcessBuilder(arr)
//    //4. 获取javaList 集合对象
//    val javaList = builder.command()
//    val res = javaList.get(0)
//    javaList.add("转为java集合")
//    println(res)
//    println(javaList)
//
//
//    //------------java集合转scala数组
//    //1. 导入隐式转换函数
//    import scala.collection.JavaConversions.asScalaBuffer //旧版本
//    //导入 scala 数组
//    import scala.collection.mutable
//    val scalaArr: mutable.Buffer[String] = javaList
//    scalaArr.append("转为scala数组")
//
//    for (i <- scalaArr) {
//      print(i + "\t")
//    }
    println(11)

    //2.13 使用方式
    //1、导入此类
    import scala.jdk.CollectionConverters._
    //2、scala转java
    val javaArr: util.List[String] = arr.asJava
    println(javaArr.get(0))
    //3、java转scala
    val c2: mutable.Buffer[String] = javaArr.asScala
    println(c2.size)
  }
}

/** 解析：scala 数组转java 集合
  *     1.创建scala中数组
  *     2.导入隐式转换函数，bufferAsJavaList
  *     3.根据转换后的List，创建ProcessBuilder，其构造器只接受 String类型集合
  * public ProcessBuilder(List<String> command) {
  * if (command == null)
  * throw new NullPointerException();
  *this.command = command;
  * }
  *     4.获取集合数据
  * public List<String> command() {
  * return command;
  * }
  *
  */