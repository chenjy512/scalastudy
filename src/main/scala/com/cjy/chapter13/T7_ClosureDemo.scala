package com.cjy.chapter13

//闭包就是一个函数和与其相关的引用环境组合的一个整体(实体)
object T7_ClosureDemo {
  def main(args: Array[String]): Unit = {
    val f1 = makeSuffix(".jpg")
    println(f1("dog.jpg"))
    println(f1("cat"))
  }

  def makeSuffix(suf:String)={
    (name:String)=>{
      if(name.endsWith(suf)){
        name
      }else{
        name+suf
      }
    }
  }
}
