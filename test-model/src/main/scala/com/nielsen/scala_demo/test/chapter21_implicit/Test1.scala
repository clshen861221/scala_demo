package com.nielsen.scala_demo.test.chapter21_implicit

object Test1 {
  implicit def int2Fraction(n: Int) = new Fraction(n, 1)
  def main(args: Array[String]): Unit = {
    println(3 * new Fraction(4, 1))
  }
}

class Fraction(val x: Int, val y: Int) {

  def *(a: Fraction) = {
    (this.x / this.y) * (a.x / a.y)
  }
}

