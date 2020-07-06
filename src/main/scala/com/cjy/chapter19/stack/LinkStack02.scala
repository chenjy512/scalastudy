package com.cjy.chapter19.stack


object LinkStack02{
  def main(args: Array[String]): Unit = {
    val stack0 = new LinkStack02
    (1 to 10).foreach(stack0.push(_))
    stack0.showData
    println()
    (1 to 3).foreach(x => stack0.pop())
    stack0.showData
    println()
    (1 to 10).foreach(stack0.push(_))
    stack0.showData
  }
}
/**
  * 单向链表栈：任意入栈数据不受初始化大小限制
  */
class LinkStack02 {

  //初始化首尾节点
  val head: Node = new Node(9999)
  var size: Int = _ //栈中数据长度

  //数据入栈
  def push(value: Int): Unit = {
    val node = new Node(value)
    node.next = head.next
    head.next = node
    size += 1
  }

  //数据出栈
  def pop(): Int = {
    if (isEmpty()) {
      throw new IllegalArgumentException("链表栈中数据为空。。。")
    } else {
      val curNode = head.next
      head.next = curNode.next
      size -= 1
      curNode.next = null
      curNode.value
    }
  }
  //是否为空
  def isEmpty(): Boolean = {
    size == 0
  }
  //栈中数据个数
  def getSize:Int={
    size
  }
  def getTop:Int={
    head.next.value
  }
  //数据遍历--》 栈顶->栈底
  def showData: Unit ={
    if(isEmpty()){
      println("链表栈中数据为空。。。")
      return
    }
    var curNode = head
    for(i <- 0 until size){
      curNode = curNode.next
      print(curNode.value+"-->")
    }
  }
}
