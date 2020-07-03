package com.cjy.chapter19.linktable

object LoopLink {
  def main(args: Array[String]): Unit = {
    val link = new LoopLink()
    //    (0 to 10).foreach(link.addFirstNode(_))
    (1 to 7).foreach(link.addLastNode(_))
    link.showData()
    println()
    link.game(4, 2, link.head)
    //    println(link.size())
    //    println(link.get(3))
    //    println(link.remove(3))
    //    println(link.get(3))
    //    println(link.size())
    //    link.showData()
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

  def game(index: Int, len: Int, cur: Node): Unit = {
    val firstNode = getNode(index) //从哪个节点开始
    gameStart(len - 1, firstNode)
  }

  def gameStart(len: Int, cur: Node): Unit = {
    if (length < 1) {
      println("game over 。。。")
      return
    } else {
      val fist = removeAndGet(len, cur)
      gameStart(len, fist)
    }
  }

  def removeAndGet(len: Int, cur: Node): Node = {
    var node: Node = cur
    var count = len
    for (i <- 0 until count) {
      //经过头结点
      if (node.value == 0) {
        count += 1
      }
      node = node.next
    }
    //移除数据时
    if (node.next.value == 0 || node.value == 0) {
      node = node.next
    }
    val del = node.next
    node.next = del.next
    del.next = null
    length -= 1
    if (del.value != 0) {
      print(del.value + "-->")
    }
    if (node.next.value == 0) {
      node = node.next
    }
    node.next
  }
}

//7-->1-->5-->10-->6-->3-->2-->4-->9-->8-->game over 。。。
