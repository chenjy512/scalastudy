package com.cjy.chapter19.array.io

import java.io.{File, PrintWriter}

import com.cjy.chapter19.array.Node

import scala.collection.mutable.ArrayBuffer
import scala.io.Source

object FileUtil {

  /**
    * 文件落地
    *
    * @param fileName 文件
    * @param datas    数据
    */
  def write(fileName: String)(datas: Array[String]): Unit = {
    val writer = new PrintWriter(new File(fileName))
    println("--------数据写入--------")
    for (s <- datas) {
      println(s)
      writer.write(s + "\n")
    }
    writer.close()
  }

  /**
    * 数据读取
    *
    * @param fileName 文件
    * @return
    */
  def read(fileName: String) = {
    val txt_data = Source.fromFile(fileName)
    val nodes = new ArrayBuffer[Node]()

    val array = txt_data.getLines().filter(x => x.isInstanceOf[String]).toArray
    array.foreach(
      x => {
        val strs = x.split("\t")
        nodes.append(new Node(strs(0).toInt, strs(1).toInt, strs(2).toInt))
      }
    )
    nodes
  }
}
