package com.nielsen.scala_demo.test.chapter14_match

object Test04 {
  class Person
  case class Teacher(name: String, subject: String) extends Person
  case class Student(name: String, classroom: String) extends Person

  def judgeIdentify(p: Person) { // case class匹配
    p match {
      case Teacher(name, subject)   => println("Teacher, name is " + name + ", subject is " + subject)
      case Student(name, classroom) => println("Student, name is " + name + ", classroom is " + classroom)
      case _                        => println("Illegal access, please go out of the school!")
    }
  }

  def main(args: Array[String]): Unit = {
    judgeIdentify(new Teacher("Albert", "math"))
    judgeIdentify(new Student("Clark", "classroom 03"))
    judgeIdentify(new Person)
  }
}