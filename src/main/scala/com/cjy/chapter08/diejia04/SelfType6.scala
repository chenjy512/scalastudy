package com.cjy.chapter08.diejia04

/**
  * 自身类型：主要是为了解决特质的循环依赖问题，同时可以确保特质在不扩展某个类的情况下，依
  * 然可以做到限制混入该特质的类的类型。
  */
object SelfType6 {
  def main(args: Array[String]): Unit = {
    val d1 = new SelfTypeClass1
    d1.info
  }
}

//1. 这里做了自身类型，那么要求混入该特质的类是，自身类型的子类，也就是Exception
trait SelfTrait {
  //2. 告诉编译器，我就是Exception类型
  this: Exception => //注释这局，则下面getMessage无法调用

  def info: Unit = {
    //3. 调用其中getMessage 方法
    println(getMessage)   //这里编译器会经过处理，并不是特质调用，而是特质继承类来调用getMessage
  }
}
//4. 效果演示
class SelfTypeClass1 extends RuntimeException with SelfTrait {}

/**-------------------------------------------------编译器源码实现
  *
  * ----伴生对象
public final class SelfType6$
{
  public static final  MODULE$;

  static
  {
    new ();
  }

  public void main(String[] args)
  {
    SelfTypeClass1 d1 = new SelfTypeClass1();
    d1.info();  //1. 实际调用
  }

  private SelfType6$()
  {
    MODULE$ = this;
  }
}
----------------------------混入特质类，因为是Exception子类，所以其本身就可以调用 getMessage
  public class SelfTypeClass1
  extends RuntimeException
  implements SelfTrait
{
  public SelfTypeClass1()
  {
    SelfTrait.class.$init$(this);
  }

  public void info()
  {
    SelfTrait.class.info(this);   //2. 将当前对象传入
  }
}
  *
  * SelfTrait$class 根据特质生成抽象类
  *public abstract class SelfTrait$class
{
  public static void info(Exception $this)   //3. 提供静态方法，供实际调用者使用。
  {
    Predef..MODULE$.println($this.getMessage());
  }

  public static void $init$(Exception $this) {}
}
*/


//5. 错误演示
class SelfTypeClass2 {}
//下面编译报错，表示不是自身类型
//class SelfTypeClass3 extends SelfTypeClass2 with SelfTrait {}