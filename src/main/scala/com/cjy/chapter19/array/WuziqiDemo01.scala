package com.cjy.chapter19.array

import scala.util.control.Breaks
import scala.util.control.Breaks.{break, breakable}

/**
  * 输赢规则：按照数组坐标从第一行第一个开始遍历每个棋子的四个方向是否5子相连，
  *           因为是从上到下遍历棋子所以这四个方向分别是 右横-下竖-左下斜-右下斜 这四种情况是否五子相连就能判断出输赢
  *
  * 缺点：1.需要遍历棋盘每个位置
  *       2.没落下一子需要判断所有棋子
  *
  * 优化：可以使用稀疏数组解决缺点1，但是稀疏数组保存的棋子需要有序按照从上到下，从左到右，只需要对排序的落子位置遍历
  *       缺点2无法解决！
  *
  * 缺点2解决方案：每落下一子需要遍历其4个大方向，横-竖-左斜-右斜 判断是否有一个方向五子相连
  *       优点：1.不需要对所有棋子遍历，只需关注落下的棋子
  *       缺点：1.判断条件相对复杂
  */
object WuziqiDemo01 {
  def main(args: Array[String]): Unit = {
    println("------------输赢判断----------")
    //7. 输赢判断
    val rowSize = 11
    val colSize = 11
    val array3 = Array.ofDim[Int](rowSize, colSize)
    array3(0)(0) = 2
    array3(0)(1) = 2
    array3(1)(2) = 1
    array3(1)(3) = 1
    array3(1)(4) = 1
    array3(1)(5) = 1
    array3(1)(6) = 1

    array3(2)(3) = 2
    array3(3)(3) = 2
    array3(4)(3) = 2
    //    array3(5)(3) = 2
    array3(6)(3) = 2
    val res = isSY(array3)
    println("棋手："+res +" 赢了")
  }
  /**
    * 7.判断棋手输赢，遍历数据发现只有四种结果 横-竖-左斜-右斜 这四种情况，如下数据只要是一种情况就是赢
    * 05	06	07	08	09
    * 05	15	25	35	45
    * 05	14	23	32	41
    * 05	16	27	38	49
    *
    * @param arr
    * @return 返回0：胜负未分；1：白子；2：黑子
    */
  def isSY(array: Array[Array[Int]]) = {
    var res = 0
    val outer = new Breaks;
    val inner = new Breaks;
    var bool = false
    //从上到下遍历每个棋子的右-下-左下斜-右下斜 是否五子相连
    outer.breakable {
      for (i <- 0 until array.length) {
        inner.breakable {
          for (j <- 0 until array(i).length) {
            if (array(i)(j) != 0) {
               bool = dealSY(array, new Node(i, j, array(i)(j))) //一种情况相连，则棋手就胜利了
              if (bool) {
                res = array(i)(j) //返回赢得棋手
                inner.break() //终止两层循环
              }
            }
          }
        }
        if(bool){
          outer.break()
        }
      }
    }
    res
  }
  //四种情况判断
  def dealSY(array: Array[Array[Int]], node: Node): Boolean = {
    if (isHeng(array, node) || isShu(array, node) || isZuoxie(array, node) || isYouxie(array, node)) true else false
  }

  /**
    * 判断横
    * @param array  数据
    * @param node   当前棋子
    * @return 结果
    */
  def isHeng(array: Array[Array[Int]], node: Node): Boolean = {
    //1. 初始化数据
    val colSize = array(0).length
    var res = true
    //2. 判断右边是否还有4列
    if(node.col + 4 > colSize -1){
      return false
    }
    breakable {
      //3. 纵向是否五子相连
      for (i <- 0 to 4) {
        //判断余下只要有一列值不相等，则不用进行了
        if (array(node.row)(node.col+i) != node.value) {
          res = false
          break()
        }
      }
    }
    res //4. 返回结果
  }

  //判断竖
  def isShu(array: Array[Array[Int]], node: Node):Boolean = {
    val rowSize = array.length
    var res = true
    //判断下边是否还有4 行
    if(node.row + 4 > rowSize -1){
      return false
    }
    breakable {//纵向是否五子相连
      for (i <- 0 to 4) {
        if (array(node.row+i)(node.col) != node.value) {
          res = false
          break()
        }
      }
    }
    res
  }

  //判断左下斜
  def isZuoxie(array: Array[Array[Int]], node: Node): Boolean = {
    val rowSize = array.length
    //    val colSize = array(0).length
    var res = true
    //判断余下是否还有4行
    if (node.row + 4 > rowSize - 1) {
      return false
    }
    //判断左边是否还有4列
    if (node.col - 4 < 0) {
      return false
    }
    breakable {
      for (i <- 0 to 4) {//从当前子开始，左下斜方形判断五子是否连接
        if (array(node.row + i)(node.col - i) != node.value) {
          res = false
          break()
        }
      }
    }
    res
  }

  //判断右下斜
  def isYouxie(array: Array[Array[Int]], node: Node): Boolean = {
    val rowSize = array.length
    val colSize = array(0).length
    var res = true
    //判断余下是否还有4行
    if (node.row + 4 > rowSize - 1) {
      return false
    }
    //判断右边是否还有4列
    if (node.col + 4 > colSize - 1) {
      return false
    }
    breakable {
      for (i <- 0 to 4) { //从当前子开始，右下斜方形判断五子是否连接
        if (array(node.row + i)(node.col + i) != node.value) {
          res = false
          break()
        }
      }
    }
    res
  }
}
