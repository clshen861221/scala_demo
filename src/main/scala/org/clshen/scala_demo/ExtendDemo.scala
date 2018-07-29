package org.clshen.scala_demo

abstract class Person(var name: String, var age: Int) {
  println("Constructing Person")
  def walk(): Unit = println("Walk like a normal persion")
}

class Student(name: String, age: Int, var studentNo: Int) extends Person(name, age) {
  println("Constructing Student")
  override def walk(): Unit = {
    super.walk() //调用父类的walk方法
    println("walk like a elegant swan") //增加了自己的实现

  }
}

object AppDemo extends App {
  val stud = new Student("clark", 20, 1)
  println(stud.name + "==>" + stud.age + "==>" + stud.studentNo)
  stud.walk()

  val s = new Person("Clark", 20) {
    def myWakl(): Unit = println("This is my walk")
  }

  val p: Person = new Student("xiaoming", 20, 2) //多态
}