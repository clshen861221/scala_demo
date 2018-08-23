package com.nielsen.scala_demo.test.chapter17_type_parameter

object Test06 {
  class Master
  class Professional extends Master

  class Card1[+T](val name: String) { //协变：Card1的父子类型的继承方向跟T是一致的
    def enterMeet(card: Card1[Master]) {
      println("welcome to have this meeting")
    }
  }

  class Card2[-T](val name: String) { //只要专家级别的名片就可以进入会场，如果大师级别的过来了，当然也可以！
    def enterMeet(card: Card2[Professional]) {
      println("welcome to have this meeting")
    }
  }

  def main(args: Array[String]): Unit = {
    //    val leo = new Card1[Master]("leo")
    //    val jack = new Card1[Professional]("jack") // 因为Card1[+T]且Master是Professional的父类，所以Card1[Master]是Card1[Professional]的父类
    //    leo.enterMeet(leo)
    //    leo.enterMeet(jack)

    val leo2 = new Card2[Master]("leo2")
    val jack2 = new Card2[Professional]("jack2") // 因为Card2[-T]且Master是Professional的父类，所以Card2[Master]是Card2[Professional]的子类
    jack2.enterMeet(leo2)
    jack2.enterMeet(jack2)

  }

}