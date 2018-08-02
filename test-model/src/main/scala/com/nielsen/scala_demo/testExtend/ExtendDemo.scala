package com.nielsen.scala_demo.testExtend

abstract class Person(val name: String, var age: Int) {
  println("Constructing Person")
  def id: Int //定义抽象字段
  def walk(): Unit = println("Walk like a normal persion")
}

class Student(studentName: String, studentAge: Int, var studentNo: Int) extends Person(studentName, studentAge) {
  println("Constructing Student")

  override val id: Int = 0

  override val name = "secret"

  override def walk(): Unit = {
    super.walk() //调用父类的walk方法
    println("walk like a elegant swan") //增加了自己的实现

  }
}

object AppDemo extends App {
  val stud = new Student("clark", 20, 1)
  println(stud.name + "==>" + stud.age + "==>" + stud.studentNo)
  stud.walk()

  //  if (stud.isInstanceOf[Student]) println(stud.asInstanceOf[Student].name)
  //  if (stud.getClass == classOf[Student]) println(true)

  println(stud match {
    case s: Student => true
    case _          => false
  })

  val s = new Person("Clark", 20) {
    var id: Int = 0
    def myWakl(): Unit = println("This is my walk")
  }

  val p: Person = new Student("xiaoming", 20, 2) //多态
}