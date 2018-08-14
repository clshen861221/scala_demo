package com.nielsen.scala_demo.test.chapter13_collection

object Test10 {
  def main(args: Array[String]): Unit = {
    //    val reduceLeft = List(1, 7, 2, 9).reduceLeft(_ - _)
    //    println(reduceLeft)
    //
    //    val reduceRight = List(1, 7, 2, 9).reduceRight((x, y) => { println("x=" + x); println("y=" + y); x - y })
    //    println(reduceRight)
    //
    //    val reduce = List(1, 7, 2, 9).reduce((x, y) => { println("x=" + x); println("y=" + y); x - y })
    //    println(reduce)
    //
    //    List(1, 7, 2, 9).foldLeft(0)(_ - _) //0-1-7-2-9 = -19

    val freq = scala.collection.mutable.Map[Char, Int]()
    for (c <- "Mississippi") freq(c) = freq.getOrElse(c, 0) + 1
    println(freq.mkString("\t"))
  }
}