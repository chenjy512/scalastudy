package com.cjy.chapter16.akka.actor.tongxu

import akka.actor.Actor

class BActor extends Actor{
  var i = 1
  override def receive = {
    case "我打" =>{
      Thread.sleep(1000)
      println("乔峰：厉害，看我降龙十八掌，第"+i+"掌")
      i += 1
      sender() !"我打" //给发送方回消息

    }
    case "exit" =>{
      println("乔峰：坐下喝兩杯")
      context.stop(self) // 停 止 actoref ,self 表示自己
      context.system.terminate()//退出 actorsystem
    }
  }
}
