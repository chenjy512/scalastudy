package com.cjy.chapter19.array

import scala.collection.mutable.ArrayBuffer
import scala.io.StdIn
import scala.util.control.Breaks.{break, breakable}

/**
  * 五子棋方案二：每落下一子，判断其 横-竖-左斜-右斜 是否有一个方向五子相连
  * 优点：1.不需要对所有棋子遍历，只需关注落下的棋子
  * 缺点：1.判断条件相对复杂
  */
object WuziqiDemo02 {
  //棋盘大小
  val rowSize = 11
  val colSize = 11
  //定义一个循环变量，控制是否退出 while
  var loop = true
  var lp2 = true
  //定义一个 key 用于接收用户输入的选项
  var key = ' '
  var index = ""
  var indexType = 1 //

  def main(args: Array[String]): Unit = {
    val array = Array.ofDim[Int](rowSize, colSize)
    do {
      println("-----------------欢迎进入五子棋界面-----------------	")
      println("	1  双人对战")
      println("	5  退	出")
      println("请选择(1-5)：")
      key = StdIn.readChar()
      key match {
        case '1' => {
            println("----------欢迎进入棋盘页面----------")
          println("")
          showQipan(array)
          println("")

          while(lp2){
            if(indexType == 1){
              println("请黑子输入棋子, 如输入格式是坐标：3-1")
            }else{
              println("请白子输入棋子, 如输入格式是坐标：3-1")
            }
            index =StdIn.readLine()//接收棋子坐标

            val ints = index.split("-").map(_.toInt)
            //判断棋子坐标格式
            if(ints.size == 2){
              val row = ints(0)
              val col = ints(1)
              //判断坐标位置
              if(row > rowSize -1 || col > colSize -1){
                println("棋子坐标超出棋盘，输入无效！！！")
              }else{
              array(row)(col) = indexType
              if(luoziSY(array,new Node(row,col,indexType))){
                lp2 = false
                println("恭喜棋手："+indexType +" 赢了")
              }
              if(indexType == 1){
                indexType = 2
              }else{
                indexType=1
                }
              showQipan(array)
              }
            }else{
              println("输入坐标有误！！！")
            }
          }
        }
        case '5' => this.loop = false
        case _ => println("输入无法识别")
      }
    }while(loop)
    println("你退出了五子棋系统...")
  }

  //落子判断输赢
  def luoziSY(array: Array[Array[Int]], node: Node): Boolean = {
    //判断棋子四个方向
    if(dealHeng(array,node) || dealShu(array,node) || dealZuoxie(array,node) || dealYouxie(array,node))
      true
    else
    false
  }

  def dealHeng(array: Array[Array[Int]], node: Node): Boolean = {
    var count: Int = 0;
    //1. 当前棋子向左，最多遍历4个位子即可
    breakable {
      for (i <- 1 to 4) {
        //到左列边界了
        if (node.col - i < 0) {
          break()
        }
        //横向向左发现不同棋子则结束
        if (array(node.row)(node.col - i) != node.value) {
          break()
        }
        count += 1 //左横移动，同子则加
      }
    }
    //2.向右判断
    breakable {
      for (i <- 0 to 4) { //0 表示当前子
        //到右列边界了
        if (node.col + i > colSize - 1) {
          break()
        }
        //横向向右发现不同棋子则结束
        if (array(node.row)(node.col + i) != node.value) {
          break()
        }
        count += 1 //右横移动，同子则加
      }
    }
    if (count >= 5) true else false
  }

  def dealShu(array: Array[Array[Int]], node: Node): Boolean = {
    var count: Int = 0;
    //1. 当前棋子纵向 向上寻找相同棋子
    breakable {
      for (i <- 1 to 4) {
        //小于0 则超出起始行边界
        if (node.row - i < 0) {
          break()
        }
        //纵向向上发现不同棋子则结束
        if (array(node.row - i)(node.col) != node.value) {
          break()
        }
        count += 1 //纵上移动，同子则加
      }
    }
    //2. 当前棋子纵向 向下寻找相同棋子
    breakable {
      for (i <- 0 to 4) { //0 表示当前棋子所在行
        //大于rowSize - 1 则超出最后一行边界
        if (node.row + i > rowSize - 1) {
          break()
        }
        //当前行纵向向下发现不同棋子则结束
        if (array(node.row - i)(node.col) != node.value) {
          break()
        }
        count += 1 //纵上移动，同子则加
      }
    }
    if (count >= 5) true else false
  }

  //下端在左，上端在右的斜线
  def dealZuoxie(array: Array[Array[Int]], node: Node): Boolean = {
    var count: Int = 0;
    //1. 当前棋子左斜-棋子下部分 向下寻找相同棋子
    breakable {
      for (i <- 1 to 4) {
        //超出最高行或者小于最小列则判断下个棋子超出界限，则终止循环
        if (node.row + i > rowSize - 1 || node.col - i < 0) {
          break()
        }
        //左斜向下，发现不同棋子则结束
        if (array(node.row + i)(node.col - i) != node.value) {
          break()
        }
        count += 1 //纵上移动，同子则加
      }
    }
    //2. 左斜上半部分判断
    breakable {
      for (i <- 0 to 4) {
        //超出最低行或者大于最大列则判断下个棋子超出界限，则终止循环
        if (node.row - i < 0 || node.col + i > colSize - 1) {
          break()
        }
        //左斜向上，发现不同棋子则结束
        if (array(node.row - i)(node.col + i) != node.value) {
          break()
        }
        count += 1 //纵上移动，同子则加
      }
    }
    if (count >= 5) true else false
  }

  //下端在右，上端在左的斜线
  def dealYouxie(array: Array[Array[Int]], node: Node): Boolean = {
    var count: Int = 0;
    //1. 当前棋子右斜-棋子下部分 向下寻找相同棋子
    breakable {
      for (i <- 1 to 4) {
        //超出最高行或者超出最大列，则判断下个棋子超出界限，则终止循环
        if (node.row + i > rowSize - 1 || node.col + i > colSize - 1) {
          break()
        }
        //左斜向下，发现不同棋子则结束
        if (array(node.row + i)(node.col + i) != node.value) {
          break()
        }
        count += 1 //纵上移动，同子则加
      }
    }
    //2. 右斜上半部分判断
    breakable {
      for (i <- 0 to 4) {
        //超出最低行或者大于最大列则判断下个棋子超出界限，则终止循环
        if (node.row - i < 0 || node.col - i < 0) {
          break()
        }
        //右斜向上，发现不同棋子则结束
        if (array(node.row - i)(node.col - i) != node.value) {
          break()
        }
        count += 1 //纵上移动，同子则加
      }
    }
    if (count >= 5) true else false
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
}
