package com.cjy.chapter06.oop

object MemState {

  def main(args: Array[String]): Unit = {
    val p1 = new Person2
    p1.name="jack"
    p1.age=18
    val p2 = p1
    printf("p1.name=%s,p1.age=%d\n",p1.name,p1.age)

    printf("p2.name=%s,p2.age=%d",p2.name,p2.age)
  }
}

class Person2 {
  var name = ""
  var age: Int = _
}