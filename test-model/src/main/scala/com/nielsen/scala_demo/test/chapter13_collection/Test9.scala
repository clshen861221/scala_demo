package com.nielsen.scala_demo.test.chapter13_collection

object Test9 {

  def main(args: Array[String]): Unit = {
    val myList = "-3+4".collect { case '+' => 1; case '-' => -1 }
    println(myList.mkString("\t"))
  }
}