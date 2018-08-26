package com.nielsen.scala_demo.test.chapter14_match

object Test01 {

  def main(args: Array[String]): Unit = {
    judgeGrade1("D")
    judgeGrade("leo", "D")
  }

  def judgeGrade(grade: String) { //最基本的用法就是对值进行匹配
    grade match {
      case "A" => println("Excellent")
      case "B" => println("Good")
      case "C" => println("Just so so")
      case _   => println("You need work harder")
    }
  }

  def judgeGrade(name: String, grade: String) { //加入守卫
    grade match {
      case "A"                => println(name + ",Excellent")
      case "B"                => println(name + ",Good")
      case "C"                => println(name + ",Just so so")
      case _ if name == "leo" => println(name + ",You are a good boy, come on")
      case _                  => println("You need work harder")
    }
  }

  def judgeGrade1(grade: String) {
    grade match {
      case "A"      => println("you get A grade, Excellent")
      case "B"      => println("you get B grade, Good")
      case "C"      => println("you get C grade, Just so so")
      case badGrade => println("you get " + badGrade + " grade, I hope you can get C grade next time") // 对match的值赋给badGrade
    }
  }

}