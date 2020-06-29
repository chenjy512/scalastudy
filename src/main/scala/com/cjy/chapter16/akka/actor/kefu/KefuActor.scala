package com.cjy.chapter16.akka.actor.kefu

import akka.actor.{Actor, ActorRef, ActorSelection, ActorSystem, Props}
import com.typesafe.config.ConfigFactory

import scala.io.StdIn

//class KefuActor(clientHost: String, clientPort: Int) extends Actor {
class KefuActor extends Actor {
  //  var clientActorRef: ActorSelection = _
  //  //  在 Actor 中有一个方法 PreStart 方法，他会在 actor 运行前执行
  //  //在 akka 的开发中，通常将初始化的工作，放在 preStart 方法
  //  override def preStart(): Unit = {
  //    println("preStart() 执行")
  //    clientActorRef = context.actorSelection(s"akka.tcp://Server@${clientHost}:${clientPort}/user/CustomerActor")
  //    println("clientActorRef=" + clientActorRef)
  //  }

  override def receive: Receive = {
    case "start" => println("start... 客服开始工作")
    //接收客户端消息
//    case ClientMessage(msg) => {
//      println(s"用户(Client): $msg")
//    }
    case ClientMessage(mes) => {
      //使用 match --case 匹配(模糊)
      mes match {
        case "大数据学费" => sender() ! ServerMessage("35000RMB")
        case "学校地址" => sender() ! ServerMessage("北京昌平 xx 路 xx 大楼")
        case "学习什么技术" => sender() ! ServerMessage("大数据 前端 python")
        case _ => sender() ! ServerMessage("你说的啥子~")
      }
    }
    //    case msg: String => {
    //      clientActorRef ! ClientMessage(msg)
    //    }
    case _ => sender() ! ServerMessage("你说的啥玩意")
  }
}


object KefuActor extends App {

  //  val (clientHost, clientPort, serverHost, serverPort) = ("127.0.0.1", 9990, "127.0.0.1", 9999)

  val host = "127.0.0.1"
  val port = 9999
  val config = ConfigFactory.parseString(
    s"""
       |akka.actor.provider="akka.remote.RemoteActorRefProvider"
       |akka.remote.netty.tcp.hostname=$host
       |akka.remote.netty.tcp.port=$port """.stripMargin)

  //创建 ActorSystem
  //url (统一资源定位)
  val serverActorSystem = ActorSystem("Server", config)
  //创建 kefuServerRef 的 actor 和返回 actorRef
  //  val kefuServerRef: ActorRef = serverActorSystem.actorOf(Props(new KefuActor(clientHost, clientPort)), "KefuActor")
  val kefuServerRef: ActorRef = serverActorSystem.actorOf(Props(new KefuActor), "KefuActor")

  //启动
  kefuServerRef ! "start"
  //
  //  while (true) {
  ////    println("请输入要咨询的问题")
  //    val mes = StdIn.readLine()
  //    kefuServerRef ! mes
  //  }
}