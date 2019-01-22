package module8_generics

object Bounds {
  // bounds for type variables

  // Sometimes, you need to place restrictions on type variables
  // For example, if we need to find the smaller in pair, we need method
  // to compare it: compareTo.
  // We can add an upper bound T <: Comparable[T].
  class Pair2[T <: Comparable[T]](val first: T, val second: T) {
    def smaller = if (first.compareTo(second) < 0) first else second
  }
  // means T must be a subtype of Comparable[T]

  // Now we can instantiate Pair[java.lang.String]
  // but not Pair[java.io.File], since String is a subtype
  // of Comparable[String] but File is not

  val pair = new Pair2("Fred", "Brooks")
  println(pair.smaller) // Prints Brooks

  // lower bound: we need to do replacement of Pair
  class Pair[T](val first: T, val second: String) {
    def replaceFirst(newFirst: T) = new Pair[T](newFirst, second)
  }
  class Person(val name:String)
  class Employee(_name:String) extends Person(_name)
  val smith = new Employee("Smith")
  val johnson = new Person("Johnson")

  val p = new Pair(smith, "director")
  //val pp = p.replaceFirst(johnson) // error: cannot replace Person by Employee

  class Pair1[T](val first: T, val second: String) {
    def replaceFirst[R >: T](newFirst: R) = new Pair1[R](newFirst, second)
  }
  // NOTE if you omit lower bound, method will compile but return Pair[Any]
  val p1 = new Pair1(smith, "director")
  // we have a pair of Employee, but want to replace Employee by Person
  val p2 = p1.replaceFirst(johnson) // now it's ok, returns Pair[Person]
  println(p2.first.name+" : "+p2.second) // Johnson : director

}
