package com.nielsen.scala_demo.test.chapter13_collection

object Test11 {
  def main(args: Array[String]): Unit = {
    //    val prices = List(5.0, 20.0, 9.95, 10.0) //如果一个集合比另一个段，那么结果中的对偶数量和较短的那个集合的元素数量相同
    //    val quantities = List(10, 2, 1)
    //    val mapping = prices zip quantities
    //    println(mapping.map(p => p._1 * p._2) sum)

    val prices1 = List(5.0, 20.0, 9.95, 10.0)
    val quantities1 = List(10, 2, 1)
    val mapping1 = prices1.zipAll(quantities1, 0, 0)
    //    println(mapping1)
    println(mapping1.map(p => p._1.toString().toDouble * p._2.toDouble) sum)
    
    
    "Scala".zipWithIndex  //zipWithIndex返回对偶的列表，其中每个对偶中第二个组成部分是每个元素的下标
    
    "Scala".zipWithIndex.max._2 //具备最大编码的值的下标为。。
  }
}