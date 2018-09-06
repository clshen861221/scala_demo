package com.nielsen.scala_demo.test.chapter3_Array

import scala.collection.mutable.ArrayBuffer

object Test01 {
  def main(args: Array[String]): Unit = {
    val a = new Array[Int](10)
    a(0) = 1
    println(a.apply(0))

    val b = Array("hello", "world", "!!!")
    println(b.mkString(" "))

    val bBuffer = b.toBuffer // 把b转换成ArrayBuffer

    for (i <- 0 until (b.length)) println(b(i))
    for (i <- 0 until (b.length, 2)) println(b(i)) //每隔2个元素打印一次
    for (i <- (0 until (b.length)).reverse) println(b(i)) //从尾部开始逐个元素打印
    for (i <- b.reverse) println(i)

    val c = ArrayBuffer[Int]()
    c += 1 //ArrayBuffer加入元素使用+=
    c += (2, 3, 4, 5) //加入多个元素
    c ++= Array(6, 7, 8, 9, 10) //把Array里的元素一起加进来使用 ++=
    c.trimEnd(5) //从尾部开始截断掉指定个数的元素
    c.insert(5, 6) //从index为5的位置插入6
    c.insert(6, 7, 8, 9, 10) //从index为6的位置插入7,8,9,10
    c.remove(2) //删除index为2的元素
    c.remove(3, 3) //从index为3的位置删除3个元素
    val cArray = c.toArray //把c转换成Array
    println(c.mkString("\t"))

  }

}