package com.cjy.chapter07.abstractdemo

/**
  * 重写字段：
  *         1.var 修饰只能重写var字段
  *         2. val修饰只能重写val字段
  * 抽象：1.未初始化属性，其底层会生成抽象方法，所以类必须标注为抽象类。
  *       2. 通过abstract标注的类不能实例化
  *       3. 方法不用标记abstract，只要省掉方法体即可。
  *       4. 抽象类可以包含非抽象方法，子类可不用重写
  *       5. 子类重写抽象方法不需要 override，写上也不会报错
  *       6. 抽象方法和属性不能使用private与final修饰。
  */
object TestMain {
  def main(args: Array[String]): Unit = {
    println(1111)
  }
}

class A {
  val name: String = "aaa"
  var sex: String = "aaa"
}

class B extends A {
  //val只能重复val类型属性
  override val name: String = "bbb"
  //var属性不能被重写
//  override var sex: String = "bbb"
}

abstract class A2 {
  //未初始化字段，其底层会生成抽象方法，所以类必须是抽象类
  var name: String

  //抽象函数
  def test1

  def test2: Int //返回值

  def test3: Unit = {
    println(333)
  }
}

class B2 extends A2 {
  override var name: String = "重写父类为初始化字段"

  override def test1: Unit = {
    println(11)
  }

  override def test2 = {
    22
  }
}