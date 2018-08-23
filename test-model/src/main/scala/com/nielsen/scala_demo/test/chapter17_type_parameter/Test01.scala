package com.nielsen.scala_demo.test.chapter17_type_parameter

object Test01 {
  def main(args: Array[String]): Unit = {
    val s1 = new Student[Int](111)
    println(s1.getSchoolId(2222))
    println(s1.getCard(123)) //自动类型推断getCard[T]中的T是Int

    val s2 = new Student[String]("3333")
    println(s2.getSchoolId("4444"))

  }
}

class Student[T](val localId: T) {
  def getSchoolId(hukouId: T) = "S-" + hukouId + "-" + localId

  def getCard[T](content: T) = {
    if (content.isInstanceOf[Int]) "int card: " + content
    else if (content.isInstanceOf[String]) "string card: " + content
    else "card: " + content
  }
}