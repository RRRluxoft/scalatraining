package module3_classes


object TutorClassConstructors extends App {

  // TODO create simple class First and create instance of the class
  class First
  val c1 = new First()

  // TODO create class Second and instance, print hello from constructor body
  class Second {
    println("Hello")
  }
  val c2 = new Second

  // TODO create class Third with a class parameter
  // TODO create var and val properties in class
  // TODO set its default values to this parameter
  class  Third(_a: Int) {
    val a = _a
    var b = _a
  }

  // TODO create class instance, access property defined as val
  // TODO change and access property defined as var

  // TODO create class Forth with constructor parameters a and b
  // TODO which will be read-write properties
  class Forth(var a:Int, var b:Int=2) { // b has default value
    override def toString = a+":"+b // overriding
  }
  val b = new Forth(1,2)
  println(b) // 1:2
  val c = new Forth(3)
  println(c) // 3:2

  // TODO for parameter b set the default value

  // TODO define auxiliary no-parameter constructor using this()

  // TODO define toString method

  // TODO create Forth instances,
  // TODO create it using one param and 2 params
  // TODO print each of them
}
