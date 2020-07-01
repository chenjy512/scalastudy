package com.cjy.chapter19.queue


object ArrayQueue01 {
  def main(args: Array[String]): Unit = {
    val queue0 = new ArrayQueue01(10)

    (0 to 9).foreach(queue0.addEle(_))
    queue0.showQueue()
    println()
    for (i <- 0 to 5) {
      println(queue0.getQueue())
    }
    println("队首查看")
    println(queue0.showHead())
  }
}

/**
  * 数组存储队列方式：
  * 1、指定队列大小不重复使用，相当于一次性使用
  * 2、每次出队一个元素，数组整体向前移动一步；入队快，出队慢
  * 3、循环队列，空间多次复用（推荐）
  */

//方式一：一次性队列
class ArrayQueue01(val newmaxSize: Int) {
  val maxSize = newmaxSize //队列最大容量
  val array = new Array[Int](maxSize) //队列实际容器
  var first = -1 //队列头
  var last = -1 //队列尾

  //队列已满
  def isFull() = {
    if (maxSize - 1 == last) {
      true
    } else {
      false
    }
  }

  //队列为空
  def isEmpty() = {
    if (first == last) {
      true
    } else {
      false
    }
  }

  //入队
  def addEle(ele: Int) = {
    if (isFull()) {
      throw new IllegalArgumentException("队列已满。。。。")
    }
    //队尾后移
    last += 1
    //添加元素
    array(last) = ele
    ele
  }

  //出队
  def getQueue() = {
    if (isEmpty()) {
      throw new IllegalArgumentException("队列为空。。。。")
    }
    first += 1
    array(first)
  }

  //头节点查看
  def showHead() = {
    if (isEmpty()) {
      throw new IllegalArgumentException("队列为空。。。。")
    }
    array(first + 1)
  }

  //队列查看
  def showQueue(): Unit = {
    if (isEmpty()) {
      throw new IllegalArgumentException("队列为空。。。。")
    }
    array.foreach(x => {
      print(x + "\t")
    })
  }
  //队列中元素个数
  def size() = {
    if (isEmpty()) {
      0
    }else{
      last - first
    }
  }
}
