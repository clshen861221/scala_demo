package com.nielsen.scala_demo.test.chapter4_mapAndTuple

object Test01 {
  def main(args: Array[String]): Unit = {
    //创建一个不可变的Map
    val ages1 = Map("Leo" -> 30, "Jen" -> 25, "Jack" -> 23)
    val ages2 = Map(("Leo", 30), ("Jen", 25), ("Jack", 23))

    //创建一个可变的Map
    val ages3 = scala.collection.mutable.Map("Leo" -> 30, "Jen" -> 25, "Jack" -> 23)

    //创建一个空Map
    val ages4 = new scala.collection.mutable.HashMap[String, Int]

    println(ages3("Leo"))
    println(ages3.getOrElse("Leo1", 0))

    //增加多个元素
    ages3 += ("Mike" -> 35, "Tom" -> 40)

    //移除元素
    ages3 -= "Mike"

    //更新不可变的map ages1,这里更新了Leo的值
    val ages5 = ages1 + ("Leo" -> 35)

    println(ages5)

    //移除不可变map的元素
    val ages6 = ages1 - "Leo"

    //遍历map
    for ((key, value) <- ages1) println(key + "\t" + value)

    //遍历map的key
    for (key <- ages1.keySet) println(key)

    //遍历map的value
    for (value <- ages1.values) println(value)

    //生成新map，反转key和value
    for ((key, value) <- ages1) yield (value, key)

    //SortedMap可以自动对Map的key进行排序
    val ages7 = scala.collection.immutable.SortedMap("Leo" -> 30, "Alice" -> 15, "Jen" -> 25)

    //LinkedHashMap可以记住插入entry的顺序
    val ages8 = new scala.collection.mutable.LinkedHashMap[String, Int]
    ages8("Leo") = 30
    ages8("Alice") = 15
    ages8("Jen") = 25
    println(ages8)

  }
}