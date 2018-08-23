package com.nielsen.scala_demo.test.chapter17_type_parameter

object Test05 {
  class Meat(val name: String) {
    override def toString = name
  }
  class Vegetable(val name: String)
  def packageFood[T: Manifest](food: T*) = {
    val foodPackage = new Array[T](food.length)
    for (i <- 0 until food.length) foodPackage(i) = food(i)
    foodPackage
  }

  def main(args: Array[String]): Unit = {
    val gongbaojiding = new Meat("gongbaojiding")
    val yuxiangrousi = new Meat("yuxiangrousi")
    val shousiyangpai = new Meat("shousiyangpai")
    val meatPackage = packageFood(gongbaojiding, yuxiangrousi, shousiyangpai)
    println(meatPackage.mkString("\n"))
  }
}