package com.nielsen.scala_demo.test.chapter21_implicit

import java.io.File
import scala.io.Source



object Test2 {
  implicit def file2RichFile(from: File) = new RichFile(from)

  def main(args: Array[String]): Unit = {
    val content = new File("F:/study/spark/workspace/scala_demo/test-model/src/main/scala/com/nielsen/scala_demo/test/data/test.txt").read
    println(content)
  }
}

class RichFile(val from: File) {
  def read = Source.fromFile(from.getPath).mkString
}