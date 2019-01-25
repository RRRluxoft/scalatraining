package module8_generics

object TutorBounds extends App {
  // bounds for type variables

  // Sometimes, you need to place restrictions on type variables
  // For example, if we need to find the smaller in pair, we need method
  // to compare it: compareTo
  // syntax to define upper bound: T <: Type
  // TODO create generic class Pair with upper bound Comparable[T]
  // TODO implement function smaller which will use compareTo
  // TODO to compare first and second
//  class Pair[S <: Comparable[S]](val first: S, val second: S)
  class Pair1[T](val first: T, val second: String) {
    def replaceFirst[R >: T](newFirst: R) = new Pair1[R](newFirst, second)
  }

  class Pair2[T <: Comparable[T]](val first: T, val second: T) {
    def smaller = if (first.compareTo(second) < 0) first else second
  }

  // means T must be a subtype of Comparable[T]

  // Now we can instantiate Pair[java.lang.String]
  // but not Pair[java.io.File], since String is a subtype
  // of Comparable[String] but File is not
  // TODO create Pair("Fred", "Brooks") and print smaller from this pair
  val pair = new Pair2("Fred", "Brooks")
  println(pair.smaller)

  // lower bound: we need to do replacement of Pair
  // TODO use upper bound in method replaceFirst so that
  // TODO newFirst could accept types upper than T
  class Pair[T](val first: T, val second: String) {
    def replaceFirst(newFirst: T) = new Pair[T](newFirst, second)
  }
  class Person(val name:String)
  class Employee(_name:String) extends Person(_name)
  val smith = new Employee("Smith")
  val johnson = new Person("Johnson")

  val p = new Pair1(smith, "director")
  // TODO uncomment, it should work with upper bound
//  val pp = p.replaceFirst(johnson) // error: cannot replace Person by Employee
  val pp = p.replaceFirst(johnson) // error: cannot replace Person by Employee
  // TODO print pp.first.name and pp.second
  println(pp.first.name + " : " + pp.second)

}
