package com.nielsen.scala_demo.test.chapter14_match

object Test03 {

  def main(args: Array[String]): Unit = {
    greeting(Array("Leo"))
    greeting(Array("jen", "marry", "lory"))
    greeting(Array("Leo", "Clark"))
    greeting(Array("Albert", "Clark"))

    greeting(List("Leo"))
    greeting(List("jen", "marry", "lory"))
    greeting(List("Leo", "jen", "marry", "lory"))
    greeting(List("Albert", "Clark"))
  }

  def greeting(arr: Array[String]) { //匹配Array
    arr match {
      case Array("Leo")               => println("Hi, Leo!") //匹配只有一个元素是Leo的Array
      case Array(girl1, girl2, girl3) => println("Nice to meet you " + girl1 + " and nice to meet you " + girl2 + " and nice to meet you " + girl3) // 匹配只有三个元素的Array
      case Array("Leo", _*)           => println("Hi, Leo, please introduce your friends to me.") // 匹配以Leo打头后面是若干个元素的Array
      case stranger                   => println(stranger.mkString(" ") + ",hey, who are you? ")
    }
  }

  def greeting(list: List[String]) { //匹配List
    list match {
      case "Leo" :: Nil                   => println("Hi, Leo!")
      case girl1 :: girl2 :: girl3 :: Nil => println("Hi girls, nice to meet you " + girl1 + " and " + girl2 + " and " + girl3)
      case "Leo" :: tail                  => println("Hi Leo, please introduce your firends to me.")
      case stranger                       => println(stranger + "hey, who are you?")
    }
  }
}