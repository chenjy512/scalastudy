package com.cjy.chapter16.akka.actor.sparkmasterworker

import akka.actor.{Actor, ActorSelection, ActorSystem, Props}
import com.typesafe.config.ConfigFactory

import scala.collection.mutable
import scala.concurrent.duration.{FiniteDuration, MILLISECONDS}

class SparkMaster extends Actor {
  //定义个 hm,管理 workers
  val workers = mutable.Map[String, WorkerInfo]()

  override def receive: Receive = {
    case "start" => {
      println("master 服务器启动了...")
      //开启定时检测注册的work
      self ! StartTimeOutWorker
    }
    case RegisterWorkerInfo(id, cpu, ram) => {
      //接收到 worker 注册信息
      if (!workers.contains(id)) {
        //创建 WorkerInfo  对象
        val workerInfo = new WorkerInfo(id, cpu, ram)
        //加入到 workers
        workers += ((id, workerInfo))
        println("服务器的 workers=" + workers)
        //回复一个消息，说注册成功
        sender() ! RegisteredWorkerInfo
      }
    }
    //更新对应的 worker 的心跳时间
    case HeartBeat(id) => {
      //1.从 workers 取出 WorkerInfo
      val workerInfo = workers(id)
      workerInfo.lastHeartBeat = System.currentTimeMillis()
      println("master 更新了 " + id + " 心跳时间..." + workerInfo.lastHeartBeat)
    }
    //设置定时规则
    case StartTimeOutWorker => {
      println("开始了定时检测 worker 心跳的任务")
      import context.dispatcher
      //说明
      //1. 0 millis 不延时，立即执行定时器
      //2. 9000 millis 表示每隔 3 秒执行一次
      //3. self:表示发给自己
      //4. RemoveTimeOutWorker 发送的内容
      context.system.scheduler.schedule(FiniteDuration(0, MILLISECONDS), FiniteDuration(9000, MILLISECONDS), self, RemoveTimeOutWorker)
    }
    //对 RemoveTimeOutWorker 消息处理
    //这里需求检测哪些 worker 心跳超时（now - lastHeartBeat > 6000），并从 map 中删除
    case RemoveTimeOutWorker => {
      //首先将所有的 workers 的 所有 WorkerInfo
      val workerInfos = workers.values
      val nowTime = System.currentTimeMillis()
      //先把超时的所有 workerInfo,删除即可
      workerInfos.filter(workerInfo => (nowTime - workerInfo.lastHeartBeat) > 6000)
        .foreach(workerInfo => workers.remove(workerInfo.id))
      println ("当前有 " + workers.size + " 个 worker 存活的")
    }
  }
}

object SparkMaster extends App {
  val config = ConfigFactory.parseString(
    s"""
       |akka.actor.provider="akka.remote.RemoteActorRefProvider"
       |akka.remote.netty.tcp.hostname=127.0.0.1
       |akka.remote.netty.tcp.port=10005 """.stripMargin)
  val sparkMasterSystem = ActorSystem("SparkMaster", config)
  //创建 SparkMaster -actor
  val sparkMasterRef = sparkMasterSystem.actorOf(Props[SparkMaster], "SparkMaster-01")
  // 启 动 SparkMaster
  sparkMasterRef ! "start"
}