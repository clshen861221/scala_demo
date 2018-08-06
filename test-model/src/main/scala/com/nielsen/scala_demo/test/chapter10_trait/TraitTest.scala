package com.nielsen.scala_demo.test.chapter10_trait

import java.io.PrintStream

object TraitTest {

  def main(args: Array[String]): Unit = {
    val acct = new SavingAccount with ConsoleLogger //在构造对象的时候加入这个特质
    acct.withdraw(2, 1)

    val acct1 = new SavingAccount with ConsoleLogger with TimestampLogger with ShortLogger
    acct1.withdraw(2, 1)

    val acct2 = new SavingAccount with ConsoleLogger with ShortLogger with TimestampLogger //无法判断先执行哪个trait的log，但是可以通过super[TimestampLogger].log来指定执行哪个
    acct2.withdraw(2, 1)

    val acct3 = new {
      val filename = "myapp.log"   //提前定义
    } with SavingAccount with FileLogger
  }
}

trait Logged {
  def log(msg: String) {}
}

trait ConsoleLogger extends Logged {
  override def log(msg: String) { println(msg) }
}

class SavingAccount extends Logged {
  def withdraw(amount: Double, balance: Double) {
    if (amount > balance) log("Insufficient funds")

  }

}

trait TimestampLogger extends Logged {
  override def log(msg: String) {
    super.log(new java.util.Date() + " " + msg)
  }
}

trait ShortLogger extends Logged {
  val maxLength = 15
  override def log(msg: String) {
    super.log(if (msg.length <= maxLength) msg else msg.substring(0, maxLength - 3))
  }
}

trait Logger {
  def log(msg: String)
  def info(msg: String) {
    log("INFO: " + msg) //实际方法使用抽象方法
  }
  def warn(msg: String) {
    log("WARN: " + msg)
  }
  def severe(msg: String) {
    log("SEVERE: " + msg)
  }
}
trait myTimestampLogger extends Logger {
  abstract override def log(msg: String) { // 重写抽象方法
    super.log(new java.util.Date() + " " + msg)
  }
}

trait FileLogger extends Logger {
  val filename: String
  val out = new PrintStream(filename)
  def log(msg: String) { out.println(msg); out.flush() }
}