package module8_generics

object MultipleBounds extends App {
  // type variable can have both an upper and a lower bound
  // T <% Lower <% Lower
  // for example: T <% Comparable[T] <% Person
  // if we need 2 upper bounds, we can use syntax: T <: T1 with T2
  class Person(val name:String)
  class Employee(_name:String, val salary: Int) extends Person(_name)
    with Comparable[Employee]{
    override def compareTo(o: Employee): Int =
      salary.compareTo(o.salary)
  }
  class Pair[T <: Comparable[T] with Person](val first: T, val second: T) {
    def smaller = if (first.compareTo(second) < 0) first else second
  }
  val smith = new Employee("Smith", 1000)
  val alice = new Employee("Alice", 1100)
  val johnson = new Person("Johnson")

  //val p = new Pair(smith, johnson) // error: cannot create Pair with Person
  val p2 = new Pair(smith, alice) // that's correct
  println ( p2.smaller.name ) // Smith

}
