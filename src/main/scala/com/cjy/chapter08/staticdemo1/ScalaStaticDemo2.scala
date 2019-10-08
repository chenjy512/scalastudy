package com.cjy.chapter08.staticdemo1

/**
  * 静态效果： 类名.方法、类名.变量
  */
object ScalaStaticDemo2 {
  def main(args: Array[String]): Unit = {
    ScalaStaticDemo2.sayHi()
    println(ScalaStaticDemo2.AA)

    /**
      * 1. 表面上看类似java调用了伴生类的静态方法或静态变量
      * 解析：静态函数（变量也是一个道理了）
      * 2. 其编译底层会在伴生类中生成对应的静态方法，但是实际调用的是伴生对象中的MODULE$ 对象的函数
      */
  }


  //相当于静态函数
  def sayHi(): Unit ={
    println("hi~~~")
  }
  //相当于静态变量
  val AA:Int = 12
}
//伴生类
class ScalaStaticDemo2{

}

/** 伴生类
public class ScalaStaticDemo2
{
  //伴生对象中的变量，在伴生类中提供静态方法获取其值，实际还是通过伴生对象的方法获取值，只能获取不能修改
  public static int AA()
  { //通过伴生对象获取值
    return ScalaStaticDemo2..MODULE$.AA();
  }
  //方法类比上面变量处理方式
  public static void sayHi()
  {
    ScalaStaticDemo2..MODULE$.sayHi();
  }

  public static void main(String[] paramArrayOfString)
  { //实际调用伴生对象的main方法
    ScalaStaticDemo2..MODULE$.main(paramArrayOfString);
  }
}

  //伴生对象
public final class ScalaStaticDemo2$
{
  public static final  MODULE$; //在伴生类中实际操作对象
  private final int AA;

  static
  {
    new ();
  }
  //伴生对象main --实际执行main
  public void main(String[] args)
  { //伴生对象中直接调用
    sayHi();
    Predef..MODULE$.println(BoxesRunTime.boxToInteger(AA()));
  }

  public void sayHi()
  {
    Predef..MODULE$.println("hi~~~");
  }

  public int AA()
  {
    return this.AA;
  }

  private ScalaStaticDemo2$()
  {
    MODULE$ = this;this.AA = 12;
  }
}

8.1.4 伴生对象的小结
1) Scala 中伴生对象采用 object 关键字声明，伴生对象中声明的全是 "静态"内容，可以通过伴生对
象名称直接调用。
2) 伴生对象对应的类称之为伴生类，伴生对象的名称应该和伴生类名一致。
3) 伴生对象中的属性和方法都可以通过伴生对象名(类名)直接调用访问
4) 从语法角度来讲，所谓的伴生对象其实就是类的静态方法和成员的集合
5) 从技术角度来讲， scala 还是没有生成静态的内容，只不过是将伴生对象生成了一个新的类，实
现属性和方法的调用。 [反编译看源码]
6) 从底层原理看，伴生对象实现静态特性是依赖于 public static final MODULE$ 实现的。
7) 伴生对象的声明应该和伴生类的声明在同一个源码文件中(如果不在同一个文件中会运行错
误!)，但是如果没有伴生类，也就没有所谓的伴生对象了，所以放在哪里就无所谓了。
8) 如果 class A 独立存在，那么 A 就是一个类， 如果 object A 独立存在，那么 A 就是一个"静态
"性质的对象[即类对象], 在 object A 中声明的属性和方法可以通过 A.属性 和 A.方法 来实现调用
9) 当一个文件中，存在伴生类和伴生对象时，文件的图标会发生变化
  **/
