package com.cjy.chapter06.oop

/**
  * 测试对象的引用，指向同一地址空间测试---->java相同效果
  * 地址内存分配
 */
object MemState {

  def main(args: Array[String]): Unit = {
    val p1 = new Person2
    p1.name="jack"
    p1.age=18
    //将引用赋值给p2
    val p2 = p1
    printf("p1.name=%s,p1.age=%d\n",p1.name,p1.age)

    printf("p2.name=%s,p2.age=%d",p2.name,p2.age)
  }
}

class Person2 {
  var name = ""
  var age: Int = _
}