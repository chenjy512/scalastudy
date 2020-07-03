package com.cjy.chapter19.linktable

object DanxLink {

  def main(args: Array[String]): Unit = {
    val link = new DanxLink()
    //    (0 to 10).foreach(link.addFirstNode(_))
    (0 to 10).foreach(link.addLastNode(_))
    link.showData()
    println()
    println(link.size())
    println(link.get(3))
    println(link.remove(3))
    println(link.get(3))
    println(link.size())
    link.showData()

  }
}

/**
  * 单向链表只能从前头结点向后查找
  * head-->1-->2-->3-->4-->null
  */
class DanxLink {
  //头结点
  val head = new Node
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
  def get(index: Int, len: Int, cur: Node): Int = {
    if (index > length - 1) {
      throw new IllegalArgumentException("查询坐标存在")
    }
    if (index == len) {
      //以头结点开始，所以下个节点才是数据节点
      return cur.next.value
    } else {
      get(index, len + 1, cur.next)
    }
  }

  /**
    * 根据坐标删除节点
    * @param index
    * @return
    */
  def remove(index: Int): Int = {
     remove(index,0,head)
  }

  /**
    * 根据坐标删除节点
    * @param index  坐标
    * @param len    深度
    * @param cur    当前节点
    * @return       删除值
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
    for (i <- 0 to length - 1) {
      print(curNode.value + "-->")
      curNode = curNode.next
    }
  }
}

//class Node {
//  var value: Int = _
//  var next: Node = null
//}