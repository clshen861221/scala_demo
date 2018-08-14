package com.nielsen.scala_demo.test.chapter13_collection

object Test13 {
  def numsFrom(n: BigInt): Stream[BigInt] = n #:: numsFrom(n + 1) //#:: 很像是列表::操作符，只不过它构建出来的是一个流。

  def main(args: Array[String]): Unit = {
    val tenOrMore = numsFrom(10)
    println(tenOrMore)
    println(tenOrMore.tail.tail.tail)
    val squares = numsFrom(1).map(x => x * x) //流的方法是懒执行的，产出Stream(1,?),需要调用squares.tail来强制对下一个元素求值。
    println(squares)
    println(squares.take(5).force)  //强制对下5个元素求值，Stream(1, 4, 9, 16, 25)
//    println(squares.force)    //别！内存溢出
  }

}