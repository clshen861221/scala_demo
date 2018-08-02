package com.nielsen.scala_demo.test

object Problem {
  def flipAndInvertImage1(A: Array[Array[Int]]): Array[Array[Int]] = {
    A.map(_.reverse.map(1 - _))
  }

  def flipAndInvertImage2(A: Array[Array[Int]]): Array[Array[Int]] = {
    for (e1 <- A) yield (for (e2 <- e1.reverse) yield (1 - e2))
  }

  def main(args: Array[String]): Unit = {
    val a = Array(Array(1, 1, 0), Array(1, 0, 1), Array(0, 0, 0))
    val a1 = flipAndInvertImage1(a)
    a.foreach(e => println(e.mkString(" , ")))
    //    a1.foreach(e1 => e1.foreach(e2 => println(e2)))
  }
}