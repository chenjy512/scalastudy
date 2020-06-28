package com.cjy.chapter07.abstractdemo

object BankTest {
  def main(args: Array[String]): Unit = {
    val b = new BankAccount("zhangsan",100)
    b.query("123")
    b.withDraw("123",23)
    b.ck("123",100)
  }
}
abstract class Account(){
  var cid:String  //id
  var banlance:Double //余额

  def query(pwd:String):Double //查询

  def withDraw(pwd:String,money:Double):Double //取款

  def ck(pwd:String,money:Double):Double //存款
}

class BankAccount(inCid:String,inBan:Double) extends Account{
  override var cid = inCid
  override var banlance = inBan

  override def query(pwd: String):Double={
      if("123".equals(pwd)){
        println("当前余额为："+banlance)
        return banlance;
      }else{
        println("密码输入错误！！！")
        return 0.0
      }
  }
  def validate(pwd:String):Boolean={
    if("123".equals(pwd)){
      return true
    }else{
      return false
    }
  }
  override def withDraw(pwd: String, money: Double) : Double= {
    if(validate(pwd)){
      if(money > banlance){
        println("取款失败")
      }else{
        banlance -= money
        println("取款成功，取出金额："+money+"，当前余额:"+banlance)
      }
    }else{
      println("密码验证失败")
      return 0
    }
    return banlance
  }

  override def ck(pwd: String, money: Double) :Double= {
    if(validate(pwd)){
      if(money > 0){
        banlance += money
        println("存款成功，存入金额："+money+"，当前余额:"+banlance)
      }
    }else{
      println("密码验证失败")
    }
    return banlance
  }
}