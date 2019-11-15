package com.cjy.chapter11.test

import com.sun.media.jfxmedia.events.BufferListener

import scala.collection.immutable.ListMap
import scala.collection.{GenTraversableOnce, mutable}
import scala.collection.mutable.{ArrayBuffer, ListBuffer}

object t1_t9Test {
  def main(args: Array[String]): Unit = {
    /** 需求1：
      * val sentence = "AAAAAAAAAABBBBBBBBCCCCCDDDDDDD"将 sentence 中各个字符，通过
      * foldLeft 存放到 一个 ArrayBuffer 中，目的：理解 flodLeft 的用法. ArrayBufer('A','A','A'..)
      */
    val sentence = "AAAAAAAAAABBBBBBBBCCCCCDDDDDDD"
    val chars = new ArrayBuffer[Char]()
    val chars1: ArrayBuffer[Char] = sentence.foldLeft(chars)(test1)
    println(sentence.isInstanceOf[String])
    println(chars1)

    /** 需求2：
      * val sentence = "AAAAAAAAAABBBBBBBBCCCCCDDDDDDD"
      * 使用映射集合，统计一句话中，各个字母出现的次数
      * 提示：Map[Char, Int]()
      */
    val map = mutable.Map[Char, Int]()
    val mapRes = sentence.foldLeft(map)(test2)
    println(mapRes)
    /** 需求3：
      * val lines = List("atguigu han hello ", "atguigu han aaa aaa aaa ccc ddd uuu")
      * 使用映射集合，list 中，各个单词出现的次数，并按出现次数排序提示：xxx, 课后练习
      */
    val lines = List("atguigu han hello ", "atguigu han aaa aaa aaa ccc ddd uuu")
    //分析1、拆分字符串；2、统计每个单词出现次数；3、排序
    //3.1拆分
    val bf = ListBuffer[String]()
    val bf2 = lines.foldLeft(bf)(test3)
    println("bf2 拆分-"+bf2)
    //3.2 统计
    val map2 = mutable.Map[String, Int]()
    bf2.foldLeft(map2)(test4)
    println("map2 统计-"+map2)
    //3.3 排序
    val listMap: ListMap[String, Int] = ListMap(map2.toSeq.sortWith( _._2 >  _._2) :_ *)
    println("listMap 排序-"+listMap)

//    //简单来就是
//    lines.foldLeft(bf)(test3).foldLeft(map2)(test4) --拆分排序简化
//    val listMap2: ListMap[String, Int] = ListMap(map2.toSeq.sortWith( _._2 >  _._2) :_ *)
//    println("listMap-"+listMap2)
  }

  /**
    * 将第2个参数放入数组中，返回第1个参数
    *
    * @param ar 数组，容器
    * @param c  数据，元素
    * @return 数组
    */
  def test1(ar: ArrayBuffer[Char], c: Char): ArrayBuffer[Char] = {
    ar.append(c)
    ar
  }

  //同test1效果一样，载体不同
  def test2(map: mutable.Map[Char, Int], s: Char): mutable.Map[Char, Int] = {
    if (map.contains(s)) {
      map(s) = map(s) + 1
    } else {
      map(s) = 1
    }
    map
  }
  //--------------------需求3处理
  //字符分割
  def test3(list:ListBuffer[String],s:String):ListBuffer[String]={
    if(s.isEmpty)
      return null

    val res: Array[String] = s.split(" ")
    for (r <- res){
      if(!r.trim.isEmpty){
        list.append(r)
      }
    }
      list
  }
  //统计
  def test4(map: mutable.Map[String, Int], s: String): mutable.Map[String, Int] = {
    if (map.contains(s)) {
      map(s) = map(s) + 1
    } else {
      map(s) = 1
    }
    map
  }
//  //排序
//  def test5(map: mutable.Map[String, Int]): Map[String,Int] ={
//    map
//  }
}
