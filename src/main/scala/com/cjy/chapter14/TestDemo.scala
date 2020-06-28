package com.cjy.chapter14

import java.util.Date

object TestDemo {

  def main(args: Array[String]): Unit = {
    println("1234".head+" "+"1234".tail)
    val list = List(1,2,3,4,5);
    println(list.head)
    println(list.tail)
    println(mx(0,0))
    println(max(List(4,6,3)))
    println("-----------------------")
    val s = "12456789"
    println(revers2(s))
    println(revers(s))

  }

  //1、求1-10000 的和
  def mx(num:BigInt,sum:BigInt):BigInt={
    if(num < 10000)
      return mx(num+1,sum+num)
    else
      return sum
  }
  //2. 求list中最大值
  def max(list:List[Int]):Int={
    if(list.isEmpty)
      throw new java.util.NoSuchElementException

    if(list.size == 1){ //集合只有一个元素
      list.head
    }else if(list.head > max(list.tail)){ //头大于尾
      list.head
    }else{
      max(list.tail)  //尾>头
    }
  }

  /**思路分析：建设集合中数据 4,6,3
    * 第一步：进入else if 集合分为：4-(6,3)  比较最大值
    * 第二步：(6,3)再次调用函数6-(3)    比较最大值
    * 第三步：(3)只有一个元素，返回3
    * 第四步：得到返回结果3,此时开始出栈，到第二步 6>3，所以返回list.head
    * 第五步：得到结果6，回到第一步 4<6,走else max((6,3))，开始新一轮的比较
    *
    * 总结：有些值能可会重复比较，如上6-3比较后4-6比较，然后得到集合(6,3)，此时6-3会再次比较
    */

  //3.字符串反转
  def revers(s:String):String={
    if(s.length == 1)
      s
    else
      revers(s.tail)+s.head
  }

  /**递归调用过程：假设字符串 s=1234
    * 1、234+1   递归入栈
    * 2、34+2
    * 3、4+3     此次tail字符为4，长度为1，开始出栈计算结果
    * 4、43      出栈计算
    * 5、43+2     出栈计算-这里其实就是第二步
    * 6、432+1    出栈计算-第一次入栈时计算
    */
  //字符串反转方式二：头中尾拆分递归
  def revers2(s:String):String={
    if(s.length <= 1)
      s
    else if(s.length == 2)
      s.charAt(1).toString+s.charAt(0)
    else
      s.charAt(s.length-1)+revers(headTail(s))+s.head
  }
  def headTail(s:String):String={
    if(s.length>3){
      s.substring(1,s.length-1)
    }else{
      s
    }
  }
}
