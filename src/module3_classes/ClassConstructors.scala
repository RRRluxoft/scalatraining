package module3_classes

import common.p

object ClassConstructors extends App {

  class First
  val o1 = new First

  class Second {
    // constructor body is right here
    println("Hello from Second")
  }
  val o2 = new Second

  class Third(_a:Int) { // _a is a class parameter
    var a = _a // getter and setter
    val b = _a // only getter
  }
  val o3 = new Third(1)
  p> o3.a // prints 1
  o3.a = 2
  p> o3.a // prints 2
  p> o3.b // prints 1

  // create variables a and b, with getter and setter
  class Forth(var a:Int, var b:Int=2) { // b has default value
    override def toString = a+":"+b // overriding
  }
  val b = new Forth(1,2)
  println(b) // 1:2
  val c = new Forth(3)
  println(c) // 3:2

}
