package com.nielsen.scala_demo.test.chapter17_type_parameter

object Test04 {
  class Calculator[T: Ordering](val number1: T, val number2: T) {//[T: Ordering]必须要求存在一个隐式参数是Ordering[T]，上下文中必须存在Ordering[T]帮助注入
    def max(implicit order: Ordering[T]) = if (order.compare(number1, number2) > 0) number1 else number2
  }
}