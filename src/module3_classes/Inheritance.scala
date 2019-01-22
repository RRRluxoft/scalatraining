package module3_classes

object Inheritance extends App {

  // inheritance
  class Person
  class Employee extends Person {
    var salary = 0
    override def toString = " employee having salary " + salary
  }

  val p:Person = new Employee
  // type checks and casts: isInstanceOf, asInstanceOf
  if (p.isInstanceOf[Employee]) {
    var e = p.asInstanceOf[Employee]
  }
  // if p is not Employee, p.asInstanceOf[Employee] throws an exception

  // using classOf (like .class in Java)
  if (p.getClass == classOf[Employee]) {
    // p is Employee
  }

  // using pattern matching
  p match {
    case e: Employee => println(e.salary) // Process s as an Employee
    case _ => println(p) // p wasn't an Employee
  }

  // superclass constructor calls
  class Person1(name:String)
  class Employee1(name:String,val salary:Double)
    extends Person1(name)
  // like in Java super(name)

  // extending Java class in Scala
  class Square(x: Int, y: Int, width: Int)
    extends java.awt.Rectangle(x, y, width, width)

  // overriding fields
  abstract class Person2 {
    def id = 0 // Each person has an ID that is computed in some way
  }

  // we need override here
  class Student(override val id: Int) extends Person2
  // A student ID is simply provided in the constructor

  // override rules:
  // def can only override another def
  // val can only override another val or a parameterless def
  // var can only override an abstract var

  // anonymous subclass
  val johnny = new Person {
    override def toString = "Hello, I'm Johnny!"
  }

  // abstract fields
  abstract class Person3 {
    val id: Int // we can omit the definition because class is abstract
    var name: String
  }

  val alice = new Person3 { // create concrete object with anonymous class
    val id = 1
    var name = "Alice"
  }

  // equals in Scala
  class Person4(val name:String) {
    override def equals(other: Any) = {
      if (other.isInstanceOf[Person4]) {
        val that = other.asInstanceOf[Person4]
        if (that == null) false
        else name == that.name
      } else false
    }
  }
  val p1 = new Person4("Smith")
  val p2 = new Person4("Smith")
  println(p1.eq(p2)) // false: reference equality
  println(p1 == p2) // true: equality by equals

  class Person5(val name:String) {
    override def equals(that: Any) = {
      that match {
        case that: Person5 => name == that.name
        case _ => false
      }
    }
  }
  val p3, p4 = new Person5("Bond")
  println(p3.eq(p4)) // false
  println(p3 == p4) // true

}
