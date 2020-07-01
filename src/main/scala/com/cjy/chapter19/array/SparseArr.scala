package com.cjy.chapter19.array

import com.cjy.chapter19.array.io.FileUtil

import scala.collection.mutable.ArrayBuffer
import scala.util.control.Breaks
import scala.util.control.Breaks.{break, breakable}

/**
  * 二维数组模拟五子棋棋盘
  * 1：白子；2：黑子
  * 棋盘效果模拟图如下：
  * 0	0	0	0	0	0	0	0	0	0	0
  * 0	0	1	0	0	0	0	0	0	0	0
  * 0	0	0	2	0	0	0	0	0	0	0
  * 0	0	0	0	0	0	0	0	0	0	0
  * 0	0	0	0	0	0	0	0	0	0	0
  * 0	0	0	0	0	0	0	0	0	0	0
  * 0	0	0	0	0	0	0	0	0	0	0
  * 0	0	0	0	0	0	0	0	0	0	0
  * 0	0	0	0	0	0	0	0	0	0	0
  * 0	0	0	0	0	0	0	0	0	0	0
  * 0	0	0	0	0	0	0	0	0	0	0
  */
object SparseArr {

  def main(args: Array[String]): Unit = {
    //1.定义行列的长度
    val rowSize = 11
    val colSize = 11

    //2.定义二维数组
    val array = Array.ofDim[Int](rowSize, colSize)
    array(1)(2) = 1
    array(2)(3) = 2

    var count: Int = 2 //记录棋子个数
    //3.查看棋盘
    showQipan(array)

    //4. 稀疏数组解决存储过大问题
    //问题：由棋盘显示可以看出默认无子为0，则在棋子较少时保存棋盘情况入磁盘时0也会占用存储空间，怎么来进行存储空间优化？
    //解决：在棋子较少时，使用稀疏数组来保存已经落下的棋子位置，因为无子默认为0则不用保存，这样会减少实际存储空间
    //其实在定义这个数组时可以根据已经落下多少颗棋子来定义
    val sparseArr = new ArrayBuffer[Node](count + 1) //多出一个记录棋盘大小
    val node = new Node(rowSize, colSize, 0) //棋盘大小
    sparseArr.append(node)

    //保存棋子
    for (i <- 0 until array.length) {
      for (j <- 0 until array(i).length) {
        //棋子不为0保存
        if (array(i)(j) != 0) {
          sparseArr.append(new Node(i, j, array(i)(j)))
        }
      }
    }

    //5. 文件io操作
    val datas = showSparseArr(sparseArr)
    //显示稀疏数组结果
    //落地为磁盘文件
    val fileName = "d:/1.txt"
    FileUtil.write(fileName)(datas)

    println("------------文件读取----------")
    //文件数据加载
    val nodes = FileUtil.read(fileName)
    nodes.foreach(println(_))
    println("------------稀疏数组还原棋盘----------")
    //6.根据文件读取数据，还原完整棋盘
    val ar2 = Array.ofDim[Int](rowSize, colSize)
    for (i <- 1 until nodes.length) {
      val node = nodes(i)
      ar2(node.row)(node.col) = node.value
    }

    for (items <- ar2) {
      for (i <- items) {
        print(i + "\t")
      }
      println()
    }
    println("------------输赢判断----------")
    //7. 输赢判断
    val array3 = Array.ofDim[Int](rowSize, colSize)
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

  //棋盘显示函数
  def showQipan(array: Array[Array[Int]]): Unit = {
    for (items <- array) {
      for (i <- items) {
        print(i + "\t")
      }
      println()
    }
  }

  def showSparseArr(arr: ArrayBuffer[Node]) = {
    val strs = new ArrayBuffer[String]()
    for (node <- arr) {
      //     println(node)
      strs.append(node.toString)
    }
    strs.toArray
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
    outer.breakable {
      for (i <- 0 until array.length) {
        inner.breakable {
          for (j <- 0 until array(i).length) {
            if (array(i)(j) != 0) {
               bool = dealSY(array, new Node(i, j, array(i)(j)))
              if (bool) {
                res = array(i)(j)
                inner.break()
              }
            }
          }
        }
        if (bool) {
          inner.break()
          outer.break()
        }
      }
    }
    res
  }

  def dealSY(array: Array[Array[Int]], node: Node): Boolean = {
    if (isHeng(array, node) || isShu(array, node) || isZuoxie(array, node) || isYouxie(array, node)) true else false
  }

  //判断横
  def isHeng(array: Array[Array[Int]], node: Node): Boolean = {
    //    val rowSize = array.length
    val colSize = array(0).length
    var res = true
    //判断右边是否还有4列
    if(node.col + 4 > colSize -1){
      return false
    }
    breakable {//纵向是否五子相连
      for (i <- 0 to 4) {
        //判断余下只要有一列值不相等，则不用进行了
        if (array(node.row)(node.col+i) != node.value) {
          res = false
          break()
        }
      }
    }
    res
  }

  //判断竖
  def isShu(array: Array[Array[Int]], node: Node):Boolean = {
    val rowSize = array.length
    var count = 0
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
    var count = 0
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
    var count = 0
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

//记录一个棋子数据，行-列-值
class Node(val row: Int, val col: Int, val value: Int) {
  override def toString: String = row + "\t" + col + "\t" + value
}