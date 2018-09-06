package com.nielsen.scala_demo.test.chapter3_Array

import scala.collection.mutable.ArrayBuffer

object Test03 {
  def main(args: Array[String]): Unit = {
    val a = Array(1, 2, 3, 4, 5)
    val a2 = for (ele <- a) yield ele * ele
    println(a2.mkString("\t"))

    val b = ArrayBuffer[Int]()
    b += (1, 2, 3, 4, 5)
    val b2 = for (ele <- b) yield ele * ele
    println(b2.mkString("\t"))

    val b3 = for (ele <- b if ele % 2 == 0) yield ele * ele
    println(b3.mkString("\t"))

    val b4 = b.filter(_ % 2 == 0).map(p => p * p)
    println(b4.mkString("\t"))
  }
}