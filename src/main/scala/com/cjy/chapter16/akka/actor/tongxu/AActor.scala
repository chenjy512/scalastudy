package com.cjy.chapter16.akka.actor.tongxu

import akka.actor.{Actor, ActorRef}

class AActor(actor:ActorRef) extends Actor{
  val actorRefB = actor
  var i = 1;
  override def receive = {
    case "start" =>{
      println("A acotr start ok 。。。")

      self ! "我打"
    }
    case "我打" =>{
      Thread.sleep(1000)
      println("黄飞鸿：我要出招了，佛山无影脚，第"+i+"脚")
      i+=1
      actorRefB ! "我打"
      if(i == 11){
        actorRefB ! "exit"
        Thread.sleep(1000)
        self ! "exit"
      }

    }
    case "exit" =>{
      println("黄飞鸿：十招已過，到此為止")
      context.stop(self) // 停 止 actoref ,self 表示自己
      context.system.terminate()//退出 actorsystem
    }
  }
}
