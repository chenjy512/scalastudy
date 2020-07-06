package com.cjy.chapter19.stack

object ArrayStack01 {
  def main(args: Array[String]): Unit = {
      val stack0 = new ArrayStack01(10)
    (1 to 11).foreach(stack0.push(_))
    stack0.showData
    println()
    for (elem <- (1 to 5)) {
      stack0.pop
    }
    stack0.showData
    println()

    (1 to 3).foreach(stack0.push(_))
    stack0.showData
  }
}

class ArrayStack01(size: Int) {

  val arr = new Array[Int](size)
  var top: Int = -1 //栈顶
  def push(value: Int): Unit = {
    if (isFull) {
      println("栈中数据已满。。。")
      return
    }
    top += 1
    arr(top) = value
  }

  def pop: Int = {
    if (isEmpty()) {
      println("栈中数据已空。。。")
      return -1
    } else {
      val res = arr(top)
      top -= 1
      res
    }
  }

  def isFull() = {
    top == size - 1
  }

  def isEmpty() = {
    top == -1
  }

  //数据遍历--》 栈底->栈顶
  def showData: Unit ={
    if(isEmpty()) return
    for(i <- 0 to top){
      print(arr(i)+"-->")
    }
  }
}
