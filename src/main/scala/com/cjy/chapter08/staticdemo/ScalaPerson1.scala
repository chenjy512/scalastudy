package com.cjy.chapter08.staticdemo

/**
  * 有一群小孩在玩堆雪人,不时有新的小孩加入,请问如何知道现在共有多少人在玩?
  */
//伴生对象
object ScalaPerson1 {
  //记录小孩的个数
  var count: Int = 0

  //加入游戏的小孩
  def joinGame(sp: ScalaPerson1): Unit = {
    count = count + 1
  }

  def showNum: Unit = {
    printf("现在共有 %d 个小孩在玩游戏", count)
  }
}

//伴生类
class ScalaPerson1 {
  var name: String = _
}

object TestMain {
  def main(args: Array[String]): Unit = {
    //
    val p1 = new ScalaPerson1
    val p2 = new ScalaPerson1
    val p3 = new ScalaPerson1
    val p4 = new ScalaPerson1
    //加入游戏
    ScalaPerson1.joinGame(p1)
    ScalaPerson1.joinGame(p2)
    ScalaPerson1.joinGame(p3)
    ScalaPerson1.joinGame(p4)
    //查看小孩个数
    ScalaPerson1.showNum
  }
}