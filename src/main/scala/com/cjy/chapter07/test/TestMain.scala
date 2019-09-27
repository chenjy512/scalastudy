package com.cjy.chapter07.test

object TestMain {
  def main(args: Array[String]): Unit = {
    val c = new Account("bac1342341", 100000.0, "123321")
    c.queryBalance("bac1342341", "123321")
    c.qukuan("bac1342341", "123321",888.98)
    c.cunkuan("bac1342341", "123321",1888.98)
  }
}

class Account(inAcc: String, inBalance: Double, inPassword: String) {
  private val acc: String = inAcc
  private var balance: Double = inBalance
  private var password: String = inPassword

  /**
    * 账号密码校验
    * @param acc
    * @param password
    * @return
    */
  def isAccAndPasswd(acc: String, password: String): Boolean ={
    if (acc.isEmpty) {
      println("账号不能为空")
      return false
    }
    if (password.isEmpty) {
      println("密码不能为空")
      return false
    }
    if (!acc.equals(this.acc)) {
      println("账号错误")
      return false
    }
    if (!password.equals(this.password)) {
      println("密码错误")
      return false
    }
    return true
  }

  /**
    * 查询账户余额
    * @param acc
    * @param password
    */
  def queryBalance(acc: String, password: String): Unit = {

    if(!isAccAndPasswd(acc,password)){
      println("查询余额失败！！！")
    }else{
      println("查询余额成功")
      printf("当前 %s 账号余额为：%.2f\n", this.acc, this.balance)
    }
  }

  /**
    * 取款业务
    * @param acc
    * @param password
    * @param balance
    */
  def qukuan(acc: String, password: String, balance: Double): Unit = {
    val res = isAccAndPasswd(acc, password)
    if(!res){
      return
    }
    if(this.balance < balance){
      println("取款余额大于存款余额")
    }else{
      this.balance = this.balance-balance
    }
    printf("取款成功，取款 %.2f \n",balance)
    printf("当前余额 %.2f\n",this.balance)
  }

  def cunkuan(acc: String, password: String, balance: Double): Unit = {
    val res = isAccAndPasswd(acc, password)
    if(!res){
      return
    }
    if(balance <= 0){
      println("存款金额必须大于 0.0")
    }else{
      this.balance = this.balance + balance
    }
    printf("存款成功，存款 %.2f \n",balance)
    printf("当前余额 %.2f\n",this.balance)
  }
}