package com.nielsen.scala_demo.test.chapter12_higherOrderFunction

import scala.math._
object Test {
  def main(args: Array[String]): Unit = {
    val fun = ceil _ //ceil函数后面的_意味着你确实指的是这个函数，而不是碰巧忘记了给它送参数
    val ceilArray = Array(3.14, 1.42, 2.0).map(fun(_))
    println(ceilArray.mkString(" "))
    val triple = (x: Double) => 3 * x //匿名函数传递给triple

    val myArray = Array(3.14, 1.42, 2.0).map((x: Double) => 3 * x) //map的括号可以用{}代替
    println(myArray.mkString(" "))

    println(f2(f1 _, 1, 2))

    println(f4((x: Int) => 1 + x, 1))
    println(f4(x => 1 + x, 1)) //由于f4知道你会传入一个类型为(Int) => Int的函数所以这可以简化掉Int，并且对于只有一个参数的函数，可以略去参数外围的()
    println(f4(1 + _, 1)) //如果参数在=>右侧只出现一次，可以用_替换掉它

    (1 to 9).map("*" * _).foreach(println)

    val f6 = f5(1)
    println(f6(2))

    val a = Array("Hello", "World")
    val b = Array("hello", "world")
    println(a.corresponds(b)(_ equalsIgnoreCase _))

  }

  def f1(x: Int, y: Int) = {
    x + y
  }
  def f2(f: (Int, Int) => Int, x: Int, y: Int) = {
    f(x, y)
  }

  def f4(f: Int => Int, x: Int) = {
    f(x)
  }

  def f5(x: Int): Int => Int = {
    (y: Int) => x + y
  }
}