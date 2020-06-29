package com.cjy.chapter16.akka.actor.kefu

abstract class MessageProtocol

case class ServerMessage(msg:String)
case class ClientMessage(msg:String)

