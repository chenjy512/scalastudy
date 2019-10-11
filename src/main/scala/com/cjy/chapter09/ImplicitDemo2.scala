package com.cjy.chapter09

/**
  * 隐式转换类库
  */
object ImplicitDemo2 {
  def main(args: Array[String]): Unit = {
    implicit def addDelete(us: UserService): BaseService = {
      new BaseService
    }

    val us = new UserService
    us.addUser()
    us.updateUser()
    us.delete
  }
}

class BaseService {
  def delete: Unit = {
    println("base -> 删除方法")
  }
}

class UserService {
  def addUser(): Unit = {
    println("新增用户")
  }

  def updateUser(): Unit = {
    println("修改用户")
  }
}

/** 源码解析
  *
  * public final class ImplicitDemo2$
  * {
  * public static final  MODULE$;
  * *
  * private final BaseService addDelete$1(UserService us)  隐式函数
  * {
  * return new BaseService();
  * }
  * *
  * public void main(String[] args)
  * {
  * UserService us = new UserService();
  *us.addUser();
  *us.updateUser();
  * addDelete$1(us).delete();    使用隐式函数包装
  * }
  * *
  * private ImplicitDemo2$()
  * {
  * MODULE$ = this;
  * }
  * *
  * static
  * {
  * new ();
  * }
  * }
  *
  * }
  */