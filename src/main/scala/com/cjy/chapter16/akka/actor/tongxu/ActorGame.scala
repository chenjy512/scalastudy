package com.cjy.chapter16.akka.actor.tongxu

import akka.actor.{ActorRef, ActorSystem, Props}


object ActorGame extends App {
  private val actorFactory = ActorSystem("actorFactory")
  private val actorRefB: ActorRef = actorFactory.actorOf(Props[BActor], "b-actorref")
  private val actorRefA: ActorRef = actorFactory.actorOf(Props(new AActor(actorRefB)),"a-acotrref")

  actorRefA ! "start"
}
