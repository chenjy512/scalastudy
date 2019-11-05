package com.cjy.chapter10.t5_map

import scala.collection.mutable

/**
  * map集合常用操作函数
  */
object T2_MapOperatorMethod02 {
  def main(args: Array[String]): Unit = {
    val a1 = mutable.Map(("A", 1), ("B" -> 2), ("C", 1))

    //1. 直接取值，存在取出，不存在报错
    val v1 = a1("A")
    println(v1) //1
    //当可以不存在时：key not found: a
    //    val v2 = a1("a")

    //2. contains 检查key是否存在
    println("A:" + a1.contains("A")) //A:true
    println("A2:" + a1.contains("A2")) //A2:false

    //适用场景
    if(a1.contains("A")){
      println("key:A存在")
    }else{
      println("key:A 不存在")
    }

    //3. 使用 map.get(key).get 取值，map.get(key)返回一个Option对象，key存在是Some(x)，不存在None
    //3.1 获取Option
    val o1: Option[Int] = a1.get("A")
    println("o1:"+o1) //o1:Some(1)
    val o2: Option[Int] = a1.get("A1")
    println("o2:"+o2) //o1:o2:None
    //3.2 调用Some(x).get获取v值
    println("o1.get:"+o1.get) //o1.get:1
    //3.3 None.get 报错：java.util.NoSuchElementException: None.get
    //  o2.get

    //4. getOrElse(key,default)取值,def getOrElse[V1 >: V](key: K, default: => V1)
    //key存在取值，不存在返回默认值
    println(a1.getOrElse("A","默认值"))
    println(a1.getOrElse("a","默认值"))

/**
  *使用方式：1.明确知道key存在使用 map(key),速度快
  *          2.不明确使用contains判断
  *          3.key存在取值，不存在取其他值，getOrElse
  */


    println("--------------map 修改、添加、删除操作--------------")
    //1.修改--存在则修改值
    a1("A")=999
    println("a1: "+a1)
    //key不存在新增
    a1("D")=3
    println("a1: "+a1)

    //2. 添加操作
    //2.1 添加单个元素
    a1 += (("F",1))
    a1 += ("G" -> 1)
    a1 += ("G" -> 22) // key存在则修改
    //2.2 添加多个元素
    a1 += (("H",1),("J",1))
    a1 += ("G" -> 1,"K"->1)
    println("a1: "+a1)

    //3. 删除操作
    //3.1 删除单个元素
    a1 -=("A")
    println("a1: "+a1)
    //3.2 key不存在，不操作，不报错
    a1 -=("A22dd")
    println("a1: "+a1)
    //3.3 删除多个元素
    a1 -=("D","G")
    println("a1: "+a1)
    println("--------------map 4 种 遍历方式--------------")
    //4. map遍历操作
    println("---------k-v-----------")
    //4.1 取出kv对
    for((k,v) <- a1){
      println("k="+k + " v="+v)
    }
    println("---------keys-----------")
    //4.2 只取key
    for(k <- a1.keys){
      println("k="+k)
    }
    println("---------values-----------")
    //4.3 只取value
    for(v <- a1.values){
      println("v="+v)
    }
    println("--------tuple------------")
    //4.4 取出Tuple方式
    for(t <- a1){
      println(t._1 +"<==>"+ t._2)
    }
  }
}
