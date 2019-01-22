package module8_generics

object TutorGenerics extends App {
  // A class with one or more type parameters is generic.

  // TODO create generic class Pair which accepts parameters of any type

  // Scala attempts to infer the actual types from the construction parameters
  // TODO uncomment this
  //val p = new Pair(42, "String") // It's a Pair[Int, String]

  // You can also specify the types yourself:
  //val p2 = new Pair[Any, Any](42, "String")

  // generic functions

  // Functions and methods can also have type parameters
  // TODO create function getLast which returns last element in generic Array

  // Scala infers the actual types from the arguments in the call
  //getLast(Array("Mary", "had", "a", "little", "lamb"))
  // Calls getLast[String]

  // TODO create variable which will point to getLast for Arrays of String



}
