package com.nielsen.scala_demo.test.chapter14_apply

object Test01 {
  def main(args: Array[String]): Unit = {
//    val p = Person("Leo", 25) //会调用apply方法

    val Person(name, age) = "leo 25" //会调用unapply方法（把一个字符串赋给一个类型的时候调用unapply方法）
  }
}

class Person(val name: String, val age: Int)

object Person {
  def apply(name: String, age: Int) = new Person(name, age)

  def unapply(str: String) = {
    val splitIndex = str.indexOf(" ")
    if (splitIndex == -1) None
    else Some((str.substring(0, splitIndex), str.substring(splitIndex + 1)))
  }

}