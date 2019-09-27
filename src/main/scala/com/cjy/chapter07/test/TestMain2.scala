package com.cjy.chapter07.test

/**
  * 创建父类Computer 包含cpu、硬盘、内存三个属性，getDetails详细信息
  *     子类1：新增属性品牌
  *     子类2：新增属性颜色
  */
object TestMain2 {

  def main(args: Array[String]): Unit = {
    println(11)
    val pc = new Pc("i7八核", "32g", "2t", "联想")
    pc.getDetails
    val nt = new Notepd("安卓10.8", "8g", "64g", "red")
    nt.getDetails
  }
}

class Computer() {

  var cpu: String = _
  var mem: String = _
  var yp: String = _

  def this(inCpu: String, inMem: String, inYp: String) {
    this
    cpu = inCpu
    mem = inMem
    yp = inYp
  }

  def getDetails: Unit = {
    printf("加载详细信息：cpu %s\t 内存 %s\t 硬盘%s")
  }
}

class Pc(inCpu: String, inMem: String, inYp: String, inP: String) extends Computer(inCpu, inMem, inYp) {
  var pp: String = inP
  override def getDetails: Unit = {
    printf("加载详细信息：cpu %s\t 内存 %s\t 硬盘%s\t 品牌 %s \n", cpu, mem, yp, pp)
  }
}

class Notepd(inCpu: String, inMem: String, inYp: String, inColor: String) extends Computer(inCpu, inMem, inYp) {
  var color: String = inColor
  override def getDetails: Unit = {
    printf("加载详细信息：cpu %s\t 内存 %s\t 硬盘%s\t 颜色 %s \n", cpu, mem, yp, color)
  }
}