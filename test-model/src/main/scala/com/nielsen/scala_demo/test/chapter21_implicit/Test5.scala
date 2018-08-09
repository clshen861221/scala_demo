package com.nielsen.scala_demo.test.chapter21_implicit

object Test5 {
  def quote(what: String)(implicit delims: Delimiters) =
    delims.left + what + delims.right

  def main(args: Array[String]): Unit = {
    //    print(quote("Bonjour le monde")(Delimiters("<<", ">>")))

    implicit val quoteDelimiters = Delimiters("<<", ">>")
    print(quote("Bonjour le monde"))
  }
}

case class Delimiters(left: String, right: String) {
}

