package com.nielsen.scala_demo.test.chapter14_match

object Test05 {
  val grades = Map("Leo" -> "A", "Jack" -> "B", "Jen" -> "C")

  def getGrade(name: String) {
    val grade = grades.get(name)
    grade match { //Option 匹配
      case Some(_grade) => println("your grade is " + _grade)
      case None         => println("Sorry, your grade information is not in the system.")
    }
  }

  def main(args: Array[String]): Unit = {
    getGrade("Leo")
    getGrade("Albert")
  }
}