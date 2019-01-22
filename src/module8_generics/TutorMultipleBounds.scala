package module8_generics

object TutorMultipleBounds extends App {
  // type variable can have both an upper and a lower bound
  // T <% Lower <% Lower
  // for example: T <% Comparable[T] <% Person
  // if we need 2 upper bounds, we can use this syntax:
  // T <: T1 with T2
  class Person(val name:String)
  class Employee(_name:String, val salary: Int) extends Person(_name)
    with Comparable[Employee]{
    override def compareTo(o: Employee): Int =
      salary.compareTo(o.salary)
  }
  // TODO define class Pair with first and second which takes
  // TODO any type which implements Comparable and extends Person

  // TODO implement method smaller by comparing names of first and second Person
  // TODO use compareTo for comparing
  val smith = new Employee("Smith",1000)
  val alice = new Employee("Alice",1100)
  val johnson = new Person("Johnson")

  //val p0 = new Pair(smith, johnson) // error: cannot create Pair with Person
  // TODO uncomment this
  //val p = new Pair(smith, alice)
  //println ( p.smaller.name ) // Smith

}
