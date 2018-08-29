package com.nielsen.scala_demo.test.chapter2_function

import scala.util.control.Exception.Catch
import java.io.FileNotFoundException

object ExceptionTest {
  def main(args: Array[String]): Unit = {
    try {
//      throw new IllegalArgumentException("x should not be negative")
      throw new FileNotFoundException
    } catch {
      case e1: IllegalArgumentException => println("IllegalArgumentException exception occured!!!")
      case e                            => println(e + " exception occured!!!")
    } finally {
      println("release io resources!!!")
    }
  }
}