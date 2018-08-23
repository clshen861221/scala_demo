package com.nielsen.scala_demo.test.fold

object Test01 {
  def main(args: Array[String]): Unit = {
    val numbers = List(5, 4, 8, 6, 2)
    numbers.fold(0) { (z, item) =>
      println(z + "=>" + item)
      z + item
    }
  }
}