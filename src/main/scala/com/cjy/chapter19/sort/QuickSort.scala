package com.cjy.chapter19.sort

import util.control.Breaks._

object QuickSort {
  def main(args: Array[String]): Unit = {

    val arr = Array(3, 5, 1, 3, -567, 3, 3)
    quickSort(0, arr.length - 1, arr) // 调用快排
    println(arr.mkString(" "))
  }

  def quickSort(left: Int, right: Int, arr: Array[Int]): Unit = {

    var lt = left // 左下标
    var rt = right // 右下标
    var pivot = arr((left + right) / 2) // 以中间的值为基准进行分割
    var temp = 0
    breakable {
      // while 语句的作用就是把比 pivot 小的数放到左边, 比 pivot 大的数放到右边
      while (lt < rt) {
        while (arr(lt) < pivot) { //从左边找一个比 pivot 大的值对应下标
          lt += 1
        }
        while (arr(rt) > pivot) { //从右边找一个比 pivot 小的值对应下标
          rt -= 1
        }
        if (lt >= rt) { // 说明本次交换结束,退出本次 while
          break()
        }
         temp = arr(lt) //交换
        arr(lt) = arr(rt)
        arr(rt) = temp
        //处理后，如果发现 arr(l) == pivot 就 r - =1 , 提高效率
        if (arr(lt) == pivot) {
          rt -= 1
        }
        //
        if ((arr(rt)) == pivot) {
          lt += 1
        }
      }
    }
    if (lt == rt) { // 提高效率
      lt += 1
      rt -= 1
    }
    if (left < rt) { //向左递归排序
      quickSort(left, rt, arr)
    }
    if (right > lt) {
      //向右递归排序
      quickSort(lt, right, arr)
    }
  }
}
