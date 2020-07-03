package com.cjy.chapter19.sort

import scala.util.control.Breaks._

object QuickSort02 {

  def main(args: Array[String]): Unit = {
    val arr = Array(3, 5, 1, 3, -567, 3, 3)
    quickSort(0, arr.length - 1, arr) // 调用快排
    println(arr.mkString(" "))
  }

  def quickSort(left: Int, right: Int, arr: Array[Int]): Unit = {
    //参数是否符合条件不在做检验了。
    //左右边界坐标相等，说明只有一个元素，不做比较
    if (left == right) {
      return
    }

    var lt = left
    var rg = right
    var temp = 0
    var pivot = arr((left + right) / 2)
    //比较所有数据
    breakable {
      while (lt < rg) {
        //左边比其大于等于的值，则停止向后查找较大值
        while (arr(lt) < pivot) {
          lt += 1
        }
        //右边比其小的值，则停止向前查找较小值
        while (arr(rg) > pivot) {
          rg -= 1
        }

        if (lt >= rg) { // 说明相遇，都在中间数位置上，本次交换结束,退出本次 while
          break()
        }

        //交换数据：左边是比中间数小的值，右边是大于等于中间数的值
        temp = arr(lt)
        arr(lt) = arr(rg)
        arr(rg) = temp
        //交过后的值等于中间数，rg 向前移动一步
//        if (arr(lt) == pivot) {
//          rg -= 1
//        }
        //此时lt-rg 坐标值是交换后的所以可不用再比较
                lt += 1
                rg -= 1
      }
    }

    if (lt == rg) { //说明在同一位置上
      rg -= 1
      lt += 1
    }

    if (left < rg) {
      quickSort(left, rg, arr)
    }
    if (lt < right) {
      quickSort(lt, right, arr)
    }
  }
}
