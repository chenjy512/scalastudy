package com.cjy.chapter16.akka.actor.kefu

import akka.actor.{Actor, ActorRef, ActorSelection, ActorSystem, Props}
import com.typesafe.config.ConfigFactory

import scala.io.StdIn

class CustomerActor(serverHost: String, serverPort: Int) extends Actor {

  var serverActorRef: ActorSelection = _

  //  在 Actor 中有一个方法 PreStart 方法，他会在 actor 运行前执行
  //在 akka 的开发中，通常将初始化的工作，放在 preStart 方法
  override def preStart(): Unit = {
    println("preStart() 执行")
    serverActorRef = context.actorSelection(s"akka.tcp://Server@${serverHost}:${serverPort}/user/KefuActor")
    println("serverActorRef=" + serverActorRef)
  }

  override def receive: Receive = {
    case "start" => println("start... 客户端运行")
    //发送消息到客户端
//    case "886" => {
//      println("正在退出中...")
//      serverActorRef ! "886"
//      context.stop(self) // 停 止 actoref ,self 表示自己
//      context.system.terminate()//退出 actorsystem
//    }
    case msg: String => {
      serverActorRef ! ClientMessage(msg)
    }
    //接收客户端消息
    case ServerMessage(msg) => {
      println(s"收到小黄鸡客服(Server): $msg")
    }
  }
}

object CustomerActor extends App {

  val (clientHost, clientPort, serverHost, serverPort) = ("127.0.0.1", 9990, "127.0.0.1", 9999)
  val config = ConfigFactory.parseString(
    s"""

       |akka.actor.provider="akka.remote.RemoteActorRefProvider"
       |akka.remote.netty.tcp.hostname=$clientHost
       |akka.remote.netty.tcp.port=$clientPort """.stripMargin)
  //创建 ActorSystem
  val clientActorSystem = ActorSystem("client", config)
  //创建 CustomerActor 的实例和引用
  val customerActorRef: ActorRef = clientActorSystem.actorOf(Props(new CustomerActor(serverHost, serverPort)), "CustomerActor")
  //启动 customerRef/也可以理解启动 Actor
  customerActorRef ! "start"
  //客户端可以发送消息给服务器
  while (true) {
//    println("请输入要咨询的问题")
    val mes = StdIn.readLine()
    customerActorRef ! mes
  }
}