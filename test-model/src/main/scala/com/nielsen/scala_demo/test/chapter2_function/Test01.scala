package com.nielsen.scala_demo.test.chapter2_function

object Test01 {
  def sayHello(name: String, age: Int = 20) { //默认参数
    println("name=" + name + "\t age =" + age)
  }

  def sum(nums: Int*) = { //这里的等于号表示有返回值
    var result = 0
    for (num <- nums) {
      result += num
    }
    result
  }

  def sum2(nums: Int*): Int = {
    if (nums.length == 0) 0
    else nums.head + sum2(nums.tail: _*)
  }

  def main(args: Array[String]): Unit = {
    sayHello("Leo")
    sayHello("Leo", 30)
    sayHello(age = 35, name = "Leo") //带名参数调用

    println(sum(1, 2, 3, 4, 5))
    println(sum(1 to 5: _*)) //跟上面一句等同
    println(sum2(1 to 5: _*))
  }

}