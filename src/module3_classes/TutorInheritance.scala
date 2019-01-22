package module3_classes

object TutorInheritance extends App {

  // let we have Person and Employee
  class Person
  class Employee(_salary:Double) extends Person {
    var salary = _salary
    override def toString = " employee having salary " + salary
  }
  val p:Person = new Employee(1000)

  // TODO retrieve salary value from p
  // TODO use type checks and casts: isInstanceOf, asInstanceOf

  // TODO do the same by using pattern matching

  // superclass constructor calls
  class Person1(name:String)

  // TODO create class Employee1(name,salary) extending Person1
  // TODO which will execute Person1 constructor

  // overriding fields
  abstract class Person2 {
    def id = 0 // Each person has an ID that is computed in some way
  }

  // TODO create class Student(id) which extends Person2
  // TODO which will take id as a parameter

  // TODO define val johnny using anonymous class extending Person
  // TODO Define toString so that it will print greeting
  // println(johnny) // should print "Hello, I'm Johnny"


  // abstract fields
  abstract class Person3 {
    val id: Int // we can omit the definition because class is abstract
    var name: String
  }

  // TODO define object extending Person3 which defines id and name
  // TODO use anonymous class

  // TODO define equals method for Person4 (use asInstanceOf)
  class Person4(val name:String)

  val p1, p2 = new Person4("Smith")
  println(p1.eq(p2)) // false: reference equality
  println(p1 == p2) // true: equality by equals

  // TODO define equals method for Person4 using pattern matching

}
