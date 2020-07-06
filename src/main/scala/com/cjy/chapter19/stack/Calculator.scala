package com.cjy.chapter19.stack

/**
  * 使用栈来实现综合计算器-自定义优先级[priority]
  */
object Calculator {
  def main(args: Array[String]): Unit = {
    val valStack3 = new LinkStack02
    valStack3.push('+')
    valStack3.push('-')
    valStack3.push('*')
    println(valStack3.pop().toChar)
    println(calculator(4, 3, '*'))
    println("-------------")
    compute("3+2*4+1-1")
    valStack.showData
    println()
    operStack.showData
  }

  private val valStack = new LinkStack02 //数值栈
  private val operStack = new LinkStack02 //操作符栈

  // 3+2*2-4+4*(5-2)/3
  /**
    * 字符串计算函数
    *
    * @param str
    * @return
    */
  def compute(str: String): Int = {
    var s = 0
    for (i <- 0 until str.length) {
      val str1 = str.substring(i, i + 1)
      if (isVal(str1)) {

      } else {
        //再次判断截取字符是否为数字
        if (isVal(str.substring(s, i))) {
          val value = str.substring(s, i)
          valStack.push(value.toInt)
        }
        //操作符入栈
        val oper = str.substring(i, i + 1).charAt(0)
        //判断操作符栈是否为空
        if (operStack.isEmpty()) {
          operStack.push(oper)
        } else {
          //比较操作符大小，如果当前操作符小于等于符号栈，栈顶符号优先级，则取出栈顶操作符计算
          if (priority(oper) <= priority(operStack.getTop.toChar)) {
            val p1 = operStack.pop.toChar //操作符
            val num1 = valStack.pop //后
            val num2 = valStack.pop //前
            val res = calculator(num2, num1, p1)
            valStack.push(res) //计算结果入栈
            //操作符入栈
            operStack.push(oper)

          } else {
            operStack.push(oper)
          }
        }
        s = i + 1
      }

    }
    //最后一部分是数字
    if (isVal(str.substring(s, str.length))) {
      valStack.push(str.substring(s, str.length).toInt)
    }
    0
  }

  /**
    * 计算
    *
    * @param n1   数1
    * @param n2   数2
    * @param oper 操作符
    * @return
    */
  def calculator(n1: Int, n2: Int, oper: Char): Int = {
    var res = 0
    oper match {
      case '+' => res = n1 + n2
      case '-' => res = n1 - n2
      case '*' => res = n1 * n2
      case '/' => res = n1 / n2
    }
    res
  }

  /**
    * 判断是否是数值
    *
    * @param s
    * @return
    */
  def isVal(s: String): Boolean = {
    var res = true
    try {
      val int = s.toInt
    } catch {
      case ex: NumberFormatException => {
        //        println(ex.getMessage)
        res = false
      }
    } finally {
    }
    res
  }

  /**
    * 自定义操作符优先级
    *
    * @param c
    * @return
    */
  def priority(c: Char): Int = {
    if ('+'.equals(c) || '-'.equals(c)) {
      1
    } else if ('*'.equals(c) || '/'.equals(c)) {
      2
    } else if ('('.equals(c)) {
      0
    } else if (')'.equals(c)) {
      3
    } else {
      -1
    }
  }
}
