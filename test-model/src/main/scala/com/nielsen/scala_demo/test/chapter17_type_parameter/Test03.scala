package com.nielsen.scala_demo.test.chapter17_type_parameter

object Test03 {
  class Person(val name: String) {
    def sayHello = println("Hello, I'm " + name)
    def makeFriends(p: Person) {
      sayHello
      p.sayHello
    }
  }

  class Student(name: String) extends Person(name)

  class Dog(val name: String) {
    def sayHello = println("Wang, Wang, I'm " + name)
  }

  implicit def dog2person(dog: Object): Person = if (dog.isInstanceOf[Dog]) { val _dog = dog.asInstanceOf[Dog]; new Person(_dog.name) } else Nil

  class Part[T <% Person](p1: T, p2: T) { // <% 表示T必须是Person或者Person的子类或者隐式转换之后是Person或者Person的子类
    def play = p1.makeFriends(p2)
  }
  
  

}