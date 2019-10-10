package com.cjy.chapter09

/**  隐式函数使用与注意细节
  *
  * 1.未使用隐式函数前？   需要每个地方处理
  * 2.使用隐式函数后？     相当于将相同处理放置在一起
  * 3.隐式函数怎么处理？   编译器首先生根据隐式函数生成一个私有函数，供匹配上的地方调用
  * 4.隐式函数怎么匹配？   按照参数类型、返回值类型匹配
  * 5.当能匹配上多个隐式函数时，出现什么情况？  报错，相同参数类型、返回值类型的函数只能有一个
  */
object Conversion1 {
  def main(args: Array[String]): Unit = {
    // 1.   var sal: Int = 12.3  double转int错误，高精度向低精度

    //2. 采用隐式转换函数：隐式转换函数是以 implicit 关键字声明的带有单个参数的函数。这种函数将会自动应用，将值从一种类型转换为另一种类型

    implicit def f1(d: Double): Int = {
      d.toInt
    }

    val sal: Int = 12.3 //--> f1$1(12.3D); 底层编译器转换
    val sal2: Int = 12.3 //--> f1$1(12.3D); 底层编译器转换
    println(sal)

    /** 3. 源码查看结果
      * 底层会将隐式函数改为如下形式，供匹配者调用
      * private final int f1$1(double d)
      * {
      * return (int)d;
      * }
      * public void main(String[] args)
      * {
      * int sal = f1$1(12.3D);
      *Predef..MODULE$.println(BoxesRunTime.boxToInteger(sal));
      * }
      */
    //4. 第二隐式函数
    implicit def f2(f: Float): Int = {
      f.toInt
    }

    //5. 当出现相同参数类型、返回值类型隐式函数时？
    //未匹配上，即没调用时无异常
    //匹配时编译报错，即得出结论：必须保证隐式函数的匹配只能是唯一的
    //    implicit def f3(f: Float): Int = {
    //      f.toInt
    //    }
    //此时编译器无法通过，需要注释掉其中一个隐式函数
    val sl2: Int = 18.33f
    println(sl2)

    /**
      * 6.隐式转换的注意事项和细节
      * 1) 隐式转换函数的函数名可以是任意的， 隐式转换与函数名称无关，只与函数签名（函数参数类型和返回值类型）有关。
      * 2) 隐式函数可以有多个(即：隐式函数列表)，但是需要保证在当前环境下， 只有一个隐式函数能被识别，过个识别时编译报错
      */
  }
}
