package com.nielsen.scala_demo.test

import scala.io.Source
import java.io.File
import java.io.FileInputStream
import java.io.PrintWriter
import java.io.ObjectOutputStream
import java.io.FileOutputStream
import java.io.ObjectInputStream
import java.net.URL

object TestFile {
  def main(args: Array[String]): Unit = {
    val source = Source.fromFile("F:/study/spark/workspace/scala_demo/test-model/src/main/scala/com/nielsen/scala_demo/test/data/test.txt", "UTF-8")
    /*  val lineIterator = source.getLines()
        lineIterator.foreach(p => println(p))
        println(source.mkString)   //把整个文件读成一个字符串
    */

    /*    for(c <- source) println(c)   //把source当成迭代器读取单个字符  */

    /*
    val iter = source.buffered
    while (iter.hasNext) {
      println(iter.head)    //iter.head 查看某个字符但是不处理掉它
      if ("h".contains(iter.head)) println(true)
      else
        println(false)
      iter.next()
    }
    */

    /*
    val tokens = source.mkString.split("\\s+") //分词
    tokens.foreach(p => println(p))
		*/

    /*
    val age = readInt()  //从控制读取Int型数字
    println(age)
    */

    /*
    val source1 = Source.fromURL("http://www.baidu.com", "UTF-8")  //从URL读入
    val source2 = Source.fromString("baidu")    //从字符串读入
    val source3 = Source.stdin  //从标准输入读入
    */

    /*
    //读取二进制文件
    val file = new File("F:/study/spark/workspace/scala_demo/test-model/src/main/scala/com/nielsen/scala_demo/test/data/test.txt")
    val in = new FileInputStream(file)
    val bytes = new Array[Byte](file.length.toInt)
    in.read(bytes)
    in.close()
    println(bytes)
    */

    /*
    //写入文本文件
    val out = new PrintWriter("F:/study/spark/workspace/scala_demo/test-model/src/main/scala/com/nielsen/scala_demo/test/data/test.txt")
    for (i <- 1 to 100) out.println(i)
    out.close
     */

    /*
    //序列化
    val fred = new Person("Clark", 20)
    val out = new ObjectOutputStream(new FileOutputStream("F:/study/spark/workspace/scala_demo/test-model/src/main/scala/com/nielsen/scala_demo/test/data/Person.obj"))
    out.writeObject(fred)
    out.close()
    val in = new ObjectInputStream(new FileInputStream("F:/study/spark/workspace/scala_demo/test-model/src/main/scala/com/nielsen/scala_demo/test/data/Person.obj"))
    val savedFred = in.readObject().asInstanceOf[Person]
    println(savedFred.name + "=>" + savedFred.age)
		*/

    /*
    //执行shell脚本
    import sys.process._
    "ls -al .." ! //sys.process包包含了一个从字符串到ProcessBuilder对象的隐式转换。!操作符执行的就是这个ProcessBuilder。
    //!操作符返回的结果是被执行程序的返回值： 程序成功执行的话就是0，否则就是显示错误的非0值
    val result = "ls -al .." !! //如果使用!!而不是!的话，输出会以字符串的形式返回

    "ls -al .." #| "grep sec" ! //你还可以将一个程序的输出以管道形式作为输入传送到另一个程序，用#|操作符

    "ls -al .." #> new File("output.txt") //把输出重定向到文件，使用#>

     "ls -al .." #>>  new File("output.txt") //把输出追加到文件，使用#>>

     "grep sec" #< new File("output.txt") //把某个文件的内容作为输入，使用 #<

     "grep Scala" #< new URL("http://xxx.com") //URL重定向输入

     val p = Process("cmd", new File("dirName"),("LANG","en_US"))  //给出命令和起始目录，以及一串（名称,值）对偶来设置环境变量
     "echo 42" #| p !    //使用!执行
     */

    /*
    //正则
    val numPattern = "[0-9]+".r //用String类的r方法构造Regex对象
    for (matchString <- numPattern.findAllIn("99 bottles, 98 bottles")) println(matchString) //findAllIn方法返回遍历所有匹配项的迭代器
    println(numPattern.findFirstIn("99 bottles, 98 bottles"))    //找到字符串中首个匹配项
    println(numPattern.findPrefixOf("99 bottles, 98 bottles"))   //检查是否某个字符串的开始部分能匹配
    println(numPattern.replaceFirstIn("99 bottles, 98 bottles", "xx")) //替换首个匹配
    println(numPattern.replaceAllIn("99 bottles, 98 bottles", "xx"))  //替换所有匹配
    */
    
    /*
    //正则组
    val numitemPattern = "([0-9]+) ([a-z]+)".r //在子正则表达式两侧加上圆括号则就是正则表达式组
    */
  }

}

@SerialVersionUID(42L) class Person(var name: String, var age: Int) extends Serializable {

}