package com.nielsen.scala_demo.test.chapter11_operator

object TestOperator {
  def main(args: Array[String]): Unit = {
    val f1 = new Fraction(2, 3)
    val f2 = new Fraction(4, 5)

//    println(f1 toString)  //一元操作符
//    println(f2 toString)
//    println(f1 * f2)     //中置操作符
    println(f1.unapply(f2))
    
    val scores = new scala.collection.mutable.HashMap[String, Int]
    scores("Bob") = 100   //等同于scores.update("Bob", 100) 
    scores.update("Bob", 101) 
    println(scores)
    
  }
}

class Fraction(var n: Int, var d: Int) {
  def *(other: Fraction) = new Fraction(n * other.n, d * other.d)
  
  def unapply(fraction: Fraction) = {
    fraction.toString
  }

  override def toString() = {
    s"n=>$n d=>$d"
  }

}