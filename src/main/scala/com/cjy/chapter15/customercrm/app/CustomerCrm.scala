package com.cjy.chapter15.customercrm.app

import com.cjy.chapter15.customercrm.view.CustomerView

object CustomerCrm {
  def main(args: Array[String]): Unit = {
  new CustomerView().mainMenu()

    // 需要导入这个包
//    import scala.util.control.Breaks._
//    var res = 0
//    breakable {
//      for (i <- 0 until 10) {
//        if (i == 5) {
//          break
//        }
//        res += i
//      }
//    }
//    println("res = " + res)
  }
}
