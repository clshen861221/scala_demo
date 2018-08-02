package com.nielsen.scala_demo.test

class TrafficLightColor {

}

object TrafficLightColor extends Enumeration {
  type MyTrafficLightColor = Value
  val Red = Value("Stop")
  val Yellow = Value("Hurry up")
  val Green = Value("Go")
  
  val a =1
  
  

  def doWaht(color: MyTrafficLightColor) = {
    if (color == Red) "stop"
    else if (color == Yellow) "hurry up"
    else "go"
  }

  def main(args: Array[String]): Unit = {
//    println(TrafficLightColor.Red.id)
//    println(TrafficLightColor.Yellow)
//    println(TrafficLightColor.Green)
      

//    println(TrafficLightColor.Red.isInstanceOf[TrafficLightColor.MyTrafficLightColor])

//    for (c <- TrafficLightColor.values) println(c.id + ": " + c)
//
//    println(TrafficLightColor.values.size)
//    for (i <- 0 to TrafficLightColor.values.size - 1) println(TrafficLightColor(i))
    
    for(i <- 0 until TrafficLightColor.values.size) println(TrafficLightColor(i))

  }
}