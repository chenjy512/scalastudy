package com.cjy.chapter15.customercrm.view

import com.cjy.chapter15.customercrm.bean.Customer
import com.cjy.chapter15.customercrm.service.CustomerService

import scala.io.StdIn

class CustomerView {
  //定义一个循环变量，控制是否退出 while
  var loop = true
  //定义一个 key 用于接收用户输入的选项
  var key = ' '

  val service = new CustomerService
  /*
  -----------------客户信息管理软件-----------------


  1添 加 客 户
  2修 改 客 户
  3删 除 客 户
  4客 户 列 表
  5退	出
  请选择(1-5)：_


  */
  def mainMenu(): Unit = {
    do {
    println("-----------------客户信息管理软件	")
    println("	1  添 加 客 户")
    println("	2  修 改 客 户")
    println("	3  删 除 客 户")
    println("	4  客 户 列 表")
    println("	5  退	出")
    println("请选择(1-5)：")
    key = StdIn.readChar()
    key match {
      case '1' => {
        add
        service.list()
      }
      case '2' =>{
        update()
        service.list()
      }
      case '3' => {
        del
        service.list()
      }
      case '4' => service.list()
      case '5' => this.loop = exit
      case _ => println("输入无法识别")
    }
  }while(loop)
    println("你退出了软件系统...")

  }

  def add():Unit={
    println()
    println("---------------------添加客户	")
    println("姓名：")
    val name = StdIn.readLine()
    println("性别：")
    val gender = StdIn.readChar()
    println("年龄：")
    val age = StdIn.readShort()
    println("电话：")
    val tel = StdIn.readLine()
    println("邮箱：")
    val email = StdIn.readLine()
    //构建对象
    val customer = new Customer(name,gender,age,tel,email)
    service.add(customer)
  }

  def update():Unit={
    println()
    println("---------------------修改客户	")
    println("编号：")
    val id = StdIn.readLine().toInt
    val bool = service.exist(id)
   while(!bool){
      println("-------------------输入编号不存在，请重新输入	")
      val id = StdIn.readLine().toInt
      val bool = service.exist(id)
    }
    println("姓名：")
    val name = StdIn.readLine()
    println("性别：")
    val gender = StdIn.readChar()
    println("年龄：")
    val age = StdIn.readShort()
    println("电话：")
    val tel = StdIn.readLine()
    println("邮箱：")
    val email = StdIn.readLine()
    //构建对象
    val customer = new Customer(id,name,gender,age,tel,email)
    service.update(customer)
  }

  def del: Unit ={
    println()
    println("---------------------删除客户	")
    println("编号：")
    val id = StdIn.readLine().toInt
    val index = service.findIndexById(id)
    if (index == -1) {
      println("---------------------编号不存在，删除没有完成	")
      return
    }

    println("确认是否删除(Y/N)：")
    val choice = StdIn.readChar().toLower
    if (choice == 'y') {
      if (service.del(index)) {
        println("---------------------删除完成	")
        return
      }
    }
    println("---------------------删除没有完成	")
  }

  def exit: Boolean ={
    println()
    println("确认是否退出系统(Y/N)：")
    var ex = StdIn.readChar().toLower
    var res = dealExit(ex)
    while(!res){
      println("---------------------输入无法识别请重新输入")
      ex = StdIn.readChar().toLower
      res = dealExit(ex)
    }
    ex == 'n'
  }

  def dealExit(ex:Char):Boolean={
      if(ex == 'y' || ex == 'n')
        true
      else
        false
  }

}
