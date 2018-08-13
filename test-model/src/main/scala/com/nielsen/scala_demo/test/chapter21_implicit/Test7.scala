package com.nielsen.scala_demo.test.chapter21_implicit

object Test7 {

  def main(args: Array[String]): Unit = {

    val u1 = new User("u1", 12)
    val u2 = new User("u2", 13)

    implicit val uo = new UserOrderingObject //提供隐式值，隐式值需要提供在创建Pair之前
    val p = new Pair(u1, u2)
    println(p.smaller.age)

  }
}

class User(val userName: String, val age: Int)

class UserOrderingObject extends Ordering[User] {
  override def compare(x: User, y: User): Int = x.age - y.age
}

class Pair[T: Ordering](val first: T, val second: T) { //[T: Ordering]要求作用域中存在Ordering[User]类型的隐式值
  def smaller(implicit ord: Ordering[T]) = {
    if (ord.compare(first, second) > 0)
      second
    else
      first
  }
}
