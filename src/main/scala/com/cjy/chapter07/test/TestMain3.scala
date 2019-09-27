package com.cjy.chapter07.test

/**
  * 创建一个员工类Employee，类中有姓名、月工资、计算年薪方法
  *         1.子类Work，有work方法，重写计算年薪方法
  *         2.子类Manager，有manager方法、年终奖属性bonus、重写计算年薪方法
  *         3.测试方法showEmpAnnual获取任何员工的年薪
  *         4.测试方法testWork，如果是work调用work方法，如果是manager调用manager方法
  *
  */
object TestMain3 {

  def main(args: Array[String]): Unit = {
    val work = new Work("张三", 3000.00)
    val mg = new Manager("张总", 20000.00, 100000.00)
    val wk = showEmpAnnual(work)
    val mk = showEmpAnnual(mg)
    println(wk)
    println(mk)
    testWork(work)
    testWork(mg)
  }

  /**
    * 获取任何员工年工资
    *
    * @param emp
    * @return
    */
  def showEmpAnnual(emp: Employee): Double = {
    emp.getAnnual
  }

  def testWork(emp: Employee): Unit = {
    if (emp.isInstanceOf[Work]) {
      val work = emp.asInstanceOf[Work]
      work.work()
    } else if (emp.isInstanceOf[Manager]) {
      val mg = emp.asInstanceOf[Manager]
      mg.manager
    }
  }
}

class Employee {
  var name: String = _
  var salary: Double = _

  def getAnnual: Double = {
    0.0
  }
}

class Work(inName: String, inSalary: Double) extends Employee {
  name = inName
  salary = inSalary

  def work(): Unit = {
    println("员工工作方法")
  }

  override def getAnnual: Double = {
    salary * 12
  }
}

class Manager(inName: String, inSalary: Double, inBonus: Double) extends Employee {
  name = inName
  salary = inSalary
  var bonus: Double = inBonus

  def manager: Unit = {
    println("经理管理方法")
  }

  override def getAnnual: Double = {
    salary * 12 + bonus
  }
}