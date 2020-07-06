package com.cjy.chapter19.linktable

/**
  * 问题：1 to 7 个小朋友，从坐标4的位置开始数2个坐标出局一个小朋友，并返回出局节点的下个节点，为下一轮游戏做准备，
  * 依次出局的小朋友顺序为？
  * 答案：7-->3-->6-->4-->2-->5-->1-->
  */
object BoyGame {
  def main(args: Array[String]): Unit = {
    //1. 初始化游戏对象
    val game = new BoyGame(7)
    game.showData()
    println()
    //初始化游戏，并开始
    game.initGame(4,3)

  }
}

class BoyGame {
  var size: Int = _
  var first: Node = _
  var cur: Node = _ //表示队列指针，辅助队列初始化

  /**
    * 辅助构造器
    *
    * @param newSize 数据个数
    * @param start   开始坐标
    * @param len     步长
    */
  def this(newSize: Int) {
    this
    size = newSize
    createLoopLink //初始化队列
  }

  /**
    * 初始化队列
    */
  def createLoopLink(): Unit = {
    for (i <- 1 to size) {
      if (i == 1) {
        first = new Node
        first.value = i
        first.next = first
        cur = first
      } else {
        val node = new Node
        node.value = i
        node.next = cur.next
        cur.next = node
        cur = node
      }
    }
  }

  /**
    * 根据坐标取节点
    * @param index
    * @return
    */
  def getNode(index:Int):Node={
     var cur = first
     for(i <- 0 until  index){
        cur = cur.next
     }
    cur
  }

  def initGame(index:Int, len: Int): Unit ={
    //1、开始节点
    val startNode = getNode(index)
    //2、开始游戏，注意这里的步长
        //因为单向链表需要待移除节点前一个节点操作，所以步长 -1
        //并且这里是由开始节点在内往后数，所以需要-1
        //综合这里减2
    startGame(startNode,len)
  }
  /**
    * 游戏开始
    * @param node 开始节点
    * @param len  步长
    */
  def startGame(node: Node, len: Int): Unit = {
    if (size < 1) {
      return
    } else {
      //移除节点
      val nextNode = remove(node, len)
      //递归处理
      startGame(nextNode, len)
    }
  }

  /**
    * 移除节点
    * @param node 开始节点
    * @param len  步长
    * @return     下个开始节点
    */
  def remove(node: Node, len: Int): Node = {
    var cur = node
    //1、查到待删除节点前一个节点，所以-1，同理从开始节点算步长，所以又需要-1
    for (i <- 0 until len-2) {
      cur = cur.next
    }
    //2、移除节点
    val delNode = cur.next
    cur.next = delNode.next
    delNode.next = null
    size -= 1
    print(delNode.value +"-->")
    //3、返回下个开始节点
    cur.next
  }


  def showData(): Unit = {
    var tmp = first
    for (i <- 0 until size) {
      print(tmp.value + "-->")
      tmp = tmp.next
    }
  }
}