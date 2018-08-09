package com.nielsen.scala_demo.test.chapter21_implicit

object Test6 {
  def smaller[T](a: T, b: T)(implicit order: T => Ordered[T]) =
    if (order(a) < b) a else b

  def main(args: Array[String]): Unit = {
    println { smaller(20, 10) }
    println { smaller("Hello", "World!") }
  }
}