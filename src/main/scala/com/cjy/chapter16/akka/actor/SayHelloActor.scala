package com.cjy.chapter16.akka.actor

import akka.actor.{Actor, ActorRef, ActorSystem, Props}

//1. 当我们继承 Actor 后，就是一个 Actor,核心方法 receive 方法重写
class SayHelloActor extends Actor{
  //1. receive 方法，会被该 Actor 的 MailBox(实现了 Runnable 接口)调用
  //2. 当该 Actor 的 MailBox 接收到消息,就会调用 receive
  //3. type Receive = PartialFunction[Any, Unit]
  override def receive:Receive = {
    case "hello" => println("收到hello，回应hello too")
    case "ok" => println("收到ok，回应ok too")
    case "exit" =>{
      println("收到退出指令，退出系统")
      context.stop(self) // 停 止 actoref ,self 表示自己
      context.system.terminate()//退出 actorsystem
    }
    case "send" =>{
      println("send 回调 ok")
      sender() ! "ok" //没法返回给发送方
    }
    case _ => println("未匹配到。。。")
  }
}

object SayHelloActor{
  //1. 先创建一个 ActorSystem, 专门用于创建 Actor
  private val actorSystemSystem = ActorSystem("actorSystem")
  //2. 创建一个 Actor 的同时，返回 Actor 的 ActorRef
  //	说明
  //(1) Props[SayHelloActor] 创建了一个 SayHelloActor 实例，使用反射
  //(2) "sayHelloActor" 给 actor 取名
  //(3) sayHelloActorRef: ActorRef 就是 Props[SayHelloActor] 的 ActorRef
  //(4) 创建的 SayHelloActor 实例被 ActorSystme 接管

  private val sayHelloActorRef: ActorRef = actorSystemSystem.actorOf(Props[SayHelloActor],"sayHelloActor")

  def main(args: Array[String]): Unit = {
    //给 SayHelloActor 发消息(邮箱)
    sayHelloActorRef ! "hello"
    sayHelloActorRef ! "hello ~"
    sayHelloActorRef ! "send"
    sayHelloActorRef ! "exit"
  }
}