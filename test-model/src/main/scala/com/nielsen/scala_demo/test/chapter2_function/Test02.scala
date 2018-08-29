package com.nielsen.scala_demo.test.chapter2_function

import scala.io.Source

object Test02 {
  def main(args: Array[String]): Unit = {
    lazy val lines = Source.fromFile("F:/study/spark/workspace/scala_demo/test-model/src/main/scala/com/nielsen/scala_demo/test/data/test.txt").mkString
    println(lines) //对于lazy的常量只有在第一次使用的时候才会去调用

  }
}