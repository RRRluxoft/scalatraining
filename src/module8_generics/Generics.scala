package module8_generics

object Generics extends App {
  // A class with one or more type parameters is generic.

  class Pair[T, S](val first: T, val second: S)

  // Scala attempts to infer the actual types from the construction parameters
  val p = new Pair(42, "String") // It's a Pair[Int, String]

  // You can also specify the types yourself:
  val p2 = new Pair[Any, Any](42, "String")

  // generic functions

  // Functions and methods can also have type parameters.
  def getMiddle[T](a: Array[T]) = a(a.length / 2)

  // Scala infers the actual types from the arguments in the call
  getMiddle(Array("Mary", "had", "a", "little", "lamb")) // Calls getMiddle[String]

  val f = getMiddle[String] _ // The function, saved in f

}
