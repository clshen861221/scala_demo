package com.nielsen.scala_demo.test

trait DAO {
  var records = 0

  def delete(id: String): Boolean = {
    true
  }
  def add(o: Any)
  def update(o: Any)
  def query(id: String): List[Any]
}