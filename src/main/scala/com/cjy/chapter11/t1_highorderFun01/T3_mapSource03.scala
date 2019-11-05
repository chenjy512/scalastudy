package com.cjy.chapter11.t1_highorderFun01

/**
  * map函数分析实现
  */
object T3_mapSource03 {
  def main(args: Array[String]): Unit = {
        //1. map调用
        val t1 = List(2,4,6)
        val t2 = t1.map(c2 _)
        println("t1:"+t1)
        println("t2:"+t2)

        //2. 自定义map实现
        val t3 = MyList(List(1,2,3,4))
        println("t3:"+t3.t1)
        val t4 = t3.map(c2 _)
        println("t4:"+t4)
  }
  def c2(i:Any):Any={
    i.toString.toInt*2
  }
}

/**
  * 自定义实现类
  * @param t
  */
class MyList(t:List[Any]){
      var t1:List[Any] = t  //初始化集合
      var t2 = List[Any]()  //处理后的集合
  /**
    * 自定义map
    * @param f
    * @return
    */
  def map(f:Any=>Any): List[Any] ={
    for (t <- t1){
      val i = f(t)
      t2 = t2 :+ i  //数据追加，形成新的元素
    }
    t2
  }

  def clear(): Unit ={
    t1=Nil
    t2=Nil
  }
}
//apply函数定义
object MyList{
  def apply(t:List[Any]): MyList = new MyList(t)
}

