package com.cjy.chapter10.t4_queue

import scala.collection.immutable.Queue


/**
  * 队列：是一个有序列表，底层可由列表或数组实现。
  * 原则：先进先出
  * scala中提供队列：scala.collection.mutable.Queue与scala.collection.immutable两种，一般开发中使用mutable可变队列
  */
object T1_QueueCreate01 {
  def main(args: Array[String]): Unit = {
    //1. 创建空的可变集合
    import scala.collection.mutable
    val q1 = new mutable.Queue[Int]

    //2. 入队元素

    //2.1入队单个
    q1 += 0
    println(q1) //Queue(0)
    //2.2 入队多个
    q1 += (1, 2)
    println(q1) //Queue(0, 1, 2, 3)

    //2.3 将集合中的元素入队
    q1 ++= List(3, 4)
    println(q1) //Queue(0, 1, 2, 3, 4)
    q1 ++= (4 to 6)
    println(q1) //Queue(0, 1, 2, 3, 4, 4, 5, 6)

    //3. 出队与入队
    val i = q1.dequeue() //出队
    println("i:" + i) //i:0
    println(q1) //Queue(1, 2, 3, 4, 4, 5, 6)

    q1.enqueue(7) //入队单个元素
    println(q1) //Queue(1, 2, 3, 4, 4, 5, 6, 7)

    println("============Queue-获取队列的元素=================")
    //4. 获取队列中的元素
    //4.1 返回队列第一个元素值，不出队
    println(q1.head)
    println(q1)
    //4.2 获取队列最后一个元素值，不出队
    println(q1.last)
    println(q1)

    //4.3 取出队列指定元素形成一个新的队列-->tail 可级联使用

    //返回不包含头元素后的其他元素，形成新的队列
    val t1: mutable.Queue[Int] = q1.tail
    println(t1) //Queue(2, 3, 4, 4, 5, 6, 7)

    //不包含前两个元素-->级联使用
    val t2: mutable.Queue[Int] = q1.tail.tail
    print(t2) //Queue(3, 4, 4, 5, 6, 7)
  }
}
