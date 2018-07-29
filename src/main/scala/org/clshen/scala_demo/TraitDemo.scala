package org.clshen.scala_demo

trait DAO {
  var records = 0

  def delete(id: String): Boolean = {
    true
  }
  def add(o: Any)
  def update(o: Any)
  def query(id: String): List[Any]
}