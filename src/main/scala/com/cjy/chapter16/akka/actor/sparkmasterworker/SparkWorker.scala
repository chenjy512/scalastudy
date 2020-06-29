package com.cjy.chapter16.akka.actor.sparkmasterworker

import akka.actor.{Actor, ActorSelection, ActorSystem, Props}
import com.typesafe.config.ConfigFactory

import scala.concurrent.duration.{FiniteDuration, MILLISECONDS}

class SparkWorker(masterHost: String, masterPort: Int) extends Actor {
  //masterProxy 是 Master 的代理/引用 ref
  var masterPorxy: ActorSelection = _
  val id = java.util.UUID.randomUUID().toString

  //初始化master的ref
  override def preStart(): Unit = {
    println("preStart()调用")
    //初始化 masterPorxy，master-ref
    masterPorxy =
      context.actorSelection(s"akka.tcp://SparkMaster@${masterHost}:${masterPort}/user/SparkMaster-01")
    println("masterProxy=" + masterPorxy)
  }

  override def receive: Receive = {
    case "start" => {
      println("worker 启动了")
      //启动后，发出注册消息
      masterPorxy ! RegisterWorkerInfo(id, 16, 16 * 1024)
    }
    // 发送work注册信息-设置定时心跳检测
    case RegisteredWorkerInfo => {
      println("workerid= " + id + "  注册成功~")

      import context.dispatcher
      //说明
      //1. 0,MILLISECONDS 不延时，立即执行定时器
      //2. 3000,MILLISECONDS 表示每隔 3 秒执行一次
      //3. self:表示发给自己
      //4. SendHeartBeat 发送的内容
      context.system.scheduler.schedule(FiniteDuration(0, MILLISECONDS), FiniteDuration(3000, MILLISECONDS), self, SendHeartBeat)
    }
    //发送心跳检测
    case SendHeartBeat => {
      println("worker = " + id + "给 master 发送心跳")
      masterPorxy ! HeartBeat(id)
    }
  }
}

object SparkWorker {
  def main(args: Array[String]): Unit = {
    val workerHost = "127.0.0.1"
    val workerPort = 10001
    val masterHost = "127.0.0.1"
    val masterPort = 10005
    val config = ConfigFactory.parseString(
      s"""
         |akka.actor.provider="akka.remote.RemoteActorRefProvider"
         |akka.remote.netty.tcp.hostname=127.0.0.1
         |akka.remote.netty.tcp.port=10002 """.stripMargin)

    //创建 ActorSystem
    val sparkWorkerSystem = ActorSystem("SparkWorker", config)


    //创建 SparkWorker 的引用/代理
    val sparkWorkerRef = sparkWorkerSystem.actorOf(Props(new SparkWorker(masterHost, masterPort)), "SparkWorker-01")

    // 启 动 actor
    sparkWorkerRef ! "start"
  }
}