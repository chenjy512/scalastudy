package com.cjy.chapter15.customercrm.bean

class Customer {
  var id: Int = _
  var name: String = _
  var gender: Char = _
  var age:Short = _
  var tel:String = _
  var email:String = _

  //设计一个辅助构造器
  def this(id:Int,name:String,gender: Char,age:Short,tel:String,email:String) {
    this  //表示调用主构造器
    this.id = id
    this.name = name
    this.gender = gender
    this.age = age
    this.tel = tel
    this.email = email
  }
  def this(name: String, gender: Char, age: Short, tel: String, email: String) {
    this
    this.name = name
    this.gender = gender
    this.age = age
    this.tel = tel
    this.email = email
}

  override def toString: String = id+"\t\t"+name+"\t\t"+gender+"\t\t"+age+"\t\t"+tel+"\t\t"+email
}
