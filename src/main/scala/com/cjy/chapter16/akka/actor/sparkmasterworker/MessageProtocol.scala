package com.cjy.chapter16.akka.actor.sparkmasterworker

abstract class MessageProtocol


// worker 注册信息 //MessageProtocol.scala
case class RegisterWorkerInfo(id:String,cpu:Int,ram:Int)

// 这个是 WorkerInfo, 这个信息将来是保存到 master 的 hm(该 hashmap 是用于管理 worker)
// 将来这个 WorkerInfo 会扩展（比如增加 worker 上一次的心跳时间）
class WorkerInfo(val id: String, val cpu: Int, val ram: Int){
  var lastHeartBeat : Long = System.currentTimeMillis()
}

// 当 worker 注册成功，服务器返回一个 RegisteredWorkerInfo 对象
case object RegisteredWorkerInfo

//worker 每隔一定时间由定时器发给自己的一个消息
case object SendHeartBeat
//worker 每隔一定时间由定时器触发，而向 master 发现的协议消息
case class HeartBeat(id: String)


//master 给自己发送一个触发检查超时 worker 的信息
case object StartTimeOutWorker
// master 给自己发消息，检测 worker,对于心跳超时的.
case object RemoveTimeOutWorker