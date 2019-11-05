package com.cjy.chapter11.t1_highorderFun01

/**
  * 将某个集合中的字母元素转为大写，输出到一个新的集合中
  */
object T4_strToUpperCaseTest04 {
  def main(args: Array[String]): Unit = {
    val names = List("Alice", "Bob", "Nick")
    val mylist = MyList(names)
    val list1 = mylist.map(upperCase(_))
    println("names:"+names)
    println("list1:"+list1)
    //转小写并反转
    val mylist2 = MyList(names)
    val list3 = mylist2.map(revers(_))
    println("list3:"+list3)
  }
  /**
    * 字母转大写
    * @param s
    * @return
    */
  def upperCase(s:Any):Any={
    s.toString.toUpperCase
  }
  //转小写并反转字符
  def revers(s:Any):Any={
    s.toString.toLowerCase().reverse
  }
}
