package com.cjy.chapter15.customercrm.service

import com.cjy.chapter15.customercrm.bean.Customer

import scala.collection.mutable.ListBuffer
import scala.io.StdIn

class CustomerService {

   val customers = ListBuffer(new Customer(1,"tom",'男',10,"110","tom@sohu.com"))

  def list():Unit={
    println("---------------------------客户列表	")
    println("编号\t\t姓名\t\t性别\t\t年龄\t\t电话\t\t邮箱")
    //for 遍历
    //1.获取到 CustomerSerivce 的 customers ArrayBuffer val customers = customerService.list()
    for (cutomer <- customers) {
      //重写 Customer 的 toString 方法，返回信息(并且格式化)
      println(cutomer)
    }
    println("-------------------------客户列表完成	")
  }
  var customerNum =1
  //添加客户
  def add(customer:Customer): Boolean = {
    // 设 置 id
    customerNum += 1
    customer.id = customerNum
    // 加 入 到 customers
    customers.append(customer)
    true
  }

  def update(customer:Customer): Boolean = {
    val i = findIndexById(customer.id)
    customers(i)=customer
    true
  }

  import scala.util.control.Breaks._
  //判断id是否存在
  def exist(id:Int): Boolean={
    var res = false
    breakable {
      for (cutomer <- customers) {
        if(cutomer.id == id){
          res = true
          break
        }else{
        res = false
        }
      }
    }
    res
  }

  def findIndexById(id: Int) :Int= {
    var index = -1 //默认-1,如果找到就改成对应,如果没有找到，就返回-1
    var i=0
    //遍历 customers
    breakable{
    for (cutomer <- customers) {
      if (cutomer.id == id) {//找到
      index = i
        break()
      }else{
        i+=1
      }
     }
    }
    return index
  }

  def del(index:Int)={
    customers.remove(index)
    true
  }

}
