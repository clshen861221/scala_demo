package com.nielsen.scala_demo.test.chapter14_apply

object Test02 {

  val p1 = Person1("Leo", 25) //样例类默认自带apply方法，所以不需要写new

}

case class Person1(name: String, age: Int)