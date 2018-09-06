package com.nielsen.scala_demo.test.chapter3_Array

import scala.util.Sorting

object Test02 {
  def main(args: Array[String]): Unit = {
    val a = Array(1, 3, 2, 5, 4, 6)
    println(a.max)
    println(a.sum)

    Sorting.quickSort(a)

    println(a.mkString("\t"))

  }
}