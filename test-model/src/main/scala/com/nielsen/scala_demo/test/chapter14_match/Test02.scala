package com.nielsen.scala_demo.test.chapter14_match

import java.io.FileNotFoundException
import java.io.IOException

object Test02 {

  def main(args: Array[String]): Unit = {//对类型进行模式匹配
    processException(new IllegalArgumentException)
    processException(new FileNotFoundException("test.txt not found "))
    processException(new IOException)
    processException(new Exception)
  }

  def processException(e: Exception) {
    e match {
      case e1: IllegalArgumentException => println("you need passed illegal argument. exception is:" + e1)
      case e2: FileNotFoundException    => println("can not find the file. exception is:" + e2)
      case e3: IOException              => println("io error occurs. exception is: " + e3)
      case _: Exception                 => println("exception occurs.")
    }
  }
}