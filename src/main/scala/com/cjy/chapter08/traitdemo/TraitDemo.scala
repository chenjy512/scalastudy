package com.cjy.chapter08.traitdemo

//trait Serializable extends Any with java.io.Serializable  特质
object TraitDemo extends Serializable {

}

//java中的接口都可以当做特质来使用，如下使用方式
//trait Cloneable extends java.lang.Cloneable
class Demo1 extends Cloneable {

}

trait A {
}

trait B {}

//继承多个特质
class C extends A with B {}

class D {}

//继承父类、多个特质
class E extends D with A with B {}

//继承单个特质
class F extends A {}