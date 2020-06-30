package test.demo

/**
  * 编写函数largest(fun:(Int)=>Int,inputs:Seq[Int]),输出在给定输入序列中给定函数的最大值。举例来说，
  * largest(x=>10x-xx,1 to 10)应该返回25.不得使用循环或递归
  */
object Test03 {
  def main(args: Array[String]): Unit = {
    println(largest(x => 10 * x - x * x, 1 to 10))
    println((1 to 10).map(x => 10 * x - x * x).max)
  }

  def largest(fun: (Int) => Int, inputs: Seq[Int]): Int = {
    inputs.map(fun).max //序列中的每个数据经过计算返回到一个新的序列中，求此序列最大值
  }
}
