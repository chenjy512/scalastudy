package com.cjy.chapter19.queue


/**
  * 方式三：循环队列
  * 注意事项：
  *       1、需要空出一个位置，因为last是指向最后一个元素下个坐标的，例如当前有9元素，last=9，(9+1)%10=0，所以会空置出来一个元素
  *       2、first==last 时队列空
  *       3、队列中元素个数 size 计算
  *       4、出队、入队坐标计算，加1 取模 maxSize
  *       5、扩容机制，注意扩容因子，缩容因子，数据移动式数据初始化，必须先确定last值再确定first，不然last会受影响
  */
object ArrayQueue02 {
  def main(args: Array[String]): Unit = {
    val queue0 = new ArrayQueue02(10)

//    (0 to 8).foreach(println(_))
    (0 to 15).foreach(queue0.addEle(_))
    queue0.showQueue()
    println("长度："+queue0.size())
    println("frist:"+queue0.first)
    println("last:"+queue0.last)
    for (i <- 0 to 10) {
      println(queue0.getQueue())
    }
    println("出队11个元素")
    queue0.showQueue()
    println("长度："+queue0.size())
    println("frist:"+queue0.first)
    println("last:"+queue0.last)

    //    println("再入队4个")
//    (0 to 3).foreach(queue0.addEle(_))
//    queue0.showQueue()
//    println("队首查看")
//    println(queue0.showHead())

    println("-------------测试数据扩容机制")
  }
}


class ArrayQueue02(val newmaxSize: Int) {
  var maxSize:Int = newmaxSize //队列最大容量
  var array = new Array[Int](maxSize) //队列实际容器
  var first = 0 //队列头
  var last = 0 //队列尾

  //队列是否满了
  //判断队列满的方法
  //队列容量空出一个作为约定 以为：last=9时，（9+1)%10=0,其实此时队列是满的状态
  def isFull() = {
    (last + 1) % maxSize == first
  }

  //队列为空
  def isEmpty() = {
    last == first
  }

  //入队
  def addEle(ele: Int):Int = {
    if (isFull()) {
      println("队列已满。。。。")
      return ele
    }
    //检测数据达到80%，进行2倍扩容
    if(size() >= maxSize*0.8){
        addSize(maxSize*2,array)
    }
    //添加元素
    array(last) = ele
    //队尾后移
    last = (last + 1) % maxSize
    ele
  }

  //出队
  def getQueue() = {
    if (isEmpty()) {
      throw new IllegalArgumentException("队列为空。。。。")
    }
    if(size() <= maxSize/3){
      addSize(maxSize/2,array)
    }
    val i = array(first)
    first = (first + 1) % maxSize
    i
  }

  //头节点查看
  def showHead() = {
    if (isEmpty()) {
      throw new IllegalArgumentException("队列为空。。。。")
    }
    array(first)
  }

  //队列查看
  def showQueue(): Unit = {
    if (isEmpty()) {
      throw new IllegalArgumentException("队列为空。。。。")
    }
    for(i <- 0 until size()){
      println(array((first+i)%maxSize))
    }
  }

  //队列中元素个数
  def size() = {
    (last + maxSize - first) % maxSize
  }
  //数据扩容
  def addSize(nweSize:Int,arr:Array[Int]): Unit ={
    println("扩容机制触发："+nweSize)
    var newArr = new Array[Int](nweSize)
    for(i <- 0 to size() - 1){
      newArr(i) = array((first + i)%maxSize)
    }
    last = size() //队尾是长度，所以先赋值
    first = 0     //新的数组队首是0，后改，不然会影响last计算
    array = newArr  //数组重新指向
    maxSize = nweSize //修改最大容量
  }

//  def subSize(size:Int,arr:Array[Int]): Unit ={
//    val newArr = new Array[Int](size)
//    maxSize = size
//    for(i <- 0 to size()-1){
//      newArr(i) = array((first + i)%maxSize)
//    }
//    array = newArr
//  }


}
