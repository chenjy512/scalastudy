package com.cjy.chapter19.linktable


/** 问题：1 to 7 个小朋友，从坐标4的位置开始数2个坐标出局一个小朋友，并返回出局节点的下个节点，为下一轮游戏做准备，
  *     依次出局的小朋友顺序为？
  * 答案：7-->3-->6-->4-->2-->5-->1-->
  */

object LoopLink {
  def main(args: Array[String]): Unit = {
    val link = new LoopLink()
    (1 to 7).foreach(link.addLastNode(_))
    link.showData()
    println()
    //坐标4开始，步长2，头结点开始数
    link.game(4, 2, link.head)
    link.showData()
  }
}

/**
  * 单向环形链表
  */
class LoopLink {
  //头结点
  val head = new Node
  head.next = head
  //长度
  private var length = 0

  //添加在首位
  def addFirstNode(value: Int): Unit = {
    add(value, 0, 0, head)
  }

  //末尾添加
  def addLastNode(value: Int): Unit = {
    add(value, length, 0, head)
  }
  /**
    * 插入结点
    *
    * @param value 结点值
    * @param index 坐标
    * @param len   当前所在深度
    * @param cur   当前所在节点
    */
  def add(value: Int, index: Int, len: Int, cur: Node): Unit = {
    if (index > length) {
      println("现有 " + length + "个元素" + "，无法插入坐标" + index)
      return
    }
    if (index == len) {
      val newNode = new Node //创建新节点
      newNode.value = value //赋值
      newNode.next = cur.next //挂载到链表上
      cur.next = newNode
      length += 1
    } else {
      add(value, index, len + 1, cur.next) //递归调用-处理下一个节点
    }
  }

  /**
    * 根据坐标查询数据
    *
    * @param index
    * @return
    */
  def get(index: Int): Int = {
    get(index, 0, head).value
  }

  def getNode(index: Int): Node = {
    get(index, 0, head)
  }

  /**
    * 根据坐标查询数据
    *
    * @param index 坐标
    * @param len   当前深度
    * @param cur   当前节点
    * @return
    */
  def get(index: Int, len: Int, cur: Node): Node = {
    if (index > length - 1) {
      throw new IllegalArgumentException("查询坐标存在")
    }
    if (index == len) {
      //以头结点开始，所以下个节点才是数据节点
      return cur.next
    } else {
      get(index, len + 1, cur.next)
    }
  }

  /**
    * 根据坐标删除节点
    *
    * @param index
    * @return
    */
  def remove(index: Int): Int = {
    remove(index, 0, head)
  }

  /**
    * 根据坐标删除节点
    *
    * @param index 坐标
    * @param len   深度
    * @param cur   当前节点
    * @return 删除值
    */
  def remove(index: Int, len: Int, cur: Node): Int = {
    //坐标大于当前链表长度
    if (index > length - 1) {
      throw new IllegalArgumentException("删除坐标存在")
    }
    //待删除节点位置
    if (index == len) {
      val delNode = cur.next //待删除节点
      cur.next = delNode.next //重新挂载节点
      delNode.next = null //节点删除
      length -= 1
      delNode.value
    } else {
      //寻找下一个节点
      remove(index, len + 1, cur.next)
    }
  }

  def size() = {
    length
  }

  def isEmpty() = {
    length == 0
  }

  def showData(): Unit = {
    var curNode = head.next
    for (i <- 0 to size() - 1) {
      if (curNode.value != 0) {
        print(curNode.value + "-->")
      }
      curNode = curNode.next
    }
  }

  /**
    * 设置游戏规则
    * @param index  开始节点坐标
    * @param len    步长
    * @param cur    当前开始节点
    */
  def game(index: Int, len: Int, cur: Node): Unit = {
    val firstNode = getNode(index) //从哪个节点开始
    gameStart(len - 1, firstNode)
  }

  /**
    * 开始游戏
    * @param len  步长
    * @param cur  开始节点
    */
  def gameStart(len: Int, cur: Node): Unit = {
    //当队列中剩下一个节点是，不在处理
    if (length <= 1) {
      return
    } else {
      //节点出局，返回下个开始节点
      val fist = removeAndGet(len, cur)
      //递归继续处理
      gameStart(len, fist)
    }
  }

  /**
    * 节点出局
    * @param len  步长
    * @param cur  开始节点
    * @return 下个开始节点
    */
  def removeAndGet(len: Int, cur: Node): Node = {

    var node: Node = cur
    //1. 根据步长查找待出局节点的前一个节点
    for (i <- 0 until len) {
      //经过头结点，则需要找下下个节点
      if (node.value == 0) {
        node = node.next.next
      }else{
        node = node.next
      }
    }
    //2. 出局数据时-根据待出局节点的前一个节点来操作
                            // 1、所以下一个节点不能是头节点
                            // 2、待删除节点的前一个节点为头结点，则说明实际步长没有走；
                            //问题分析：假设当前只有head-2-3-4，当前开始节点为4，寻找步长为一的下个节点，则next为head，其实应该是2的所以需要判断当前节点不能是头结点
    if (node.next.value == 0 || node.value == 0) {
        node = node.next
    }
    //根据待出局节点的前一个节点
    val del = node.next
    node.next = del.next
    del.next = null
    //总数减1
    length -= 1
    if (del.value != 0) {
      print(del.value + "-->")
    }
//当前节点下个节点是头结点，则需要将指针指向头结点，因为头结点需要过滤
//    if (node.next.value == 0) {
//      node = node.next
//    }
    //返回出局节点的下个节点，为下一轮游戏的开始节点
    node.next
  }
}

