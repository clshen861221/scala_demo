package com.nielsen.scala_demo.test.chapter4_mapAndTuple

object Test02 {
  def main(args: Array[String]): Unit = {
    //简单Tuple
    val t = ("leo", 30)

    //访问Tuple
    println(t._1)
    println(t._2)

    //zip操作（拉链操作）
    val names = Array("leo", "jack", "mike")
    val ages = Array(30, 24, 26)
    val nameAges = names.zip(ages)
    for ((name, age) <- nameAges) println(name + ":" + age)

  }
}