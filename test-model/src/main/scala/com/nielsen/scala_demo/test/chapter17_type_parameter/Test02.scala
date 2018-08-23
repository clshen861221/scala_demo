package com.nielsen.scala_demo.test.chapter17_type_parameter

import scala.xml.Elem

object Test02 {

  class Person(val name: String) {
    def sayHello = println("Hello, I'm " + name)
    def makeFriends(p: Person) {
      sayHello
      p.sayHello
    }
  }

  class Student1(name: String) extends Person(name)

  class Part[T <: Person](p1: T, p2: T) { // <: 表示T必须是Person或者Person的子类，泛型类型的上边界
    def play = p1.makeFriends(p2)
  }

  class Father(val name: String)
  class Child(name: String) extends Father(name) {
    def getIDCard[R >: Child](person: R) { //R必须是Child或者Child的父类，泛型类型的下边界
      if (person.getClass == classOf[Child]) println("please tell us your parents' name.")
      else if (person.getClass == classOf[Father]) println("sign your name for your child's id card.")
      else println("sorry, you are not allowed to get id card.")
    }
  }

  class Dog(val name: String) {
    def sayHello = println("Wang, Wang, I'm " + name)
  }

  implicit def dog2person(dog: Object): Person = if (dog.isInstanceOf[Dog]) { val _dog = dog.asInstanceOf[Dog]; new Person(_dog.name) } else Nil

}






