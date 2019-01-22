package module9_implicits

object ImplicitParams extends App {
  class Person(val name:String)

  val p = new Person("John")
  def surround(s:String)(implicit person: Person) = s+person.name+s
  println( surround("***")(p)) // ***John***

  {
    implicit val defaultPerson=new Person("Nobody")
    println( surround("***") ) // ***Nobody***
  }

  // Compiler looks for implicit values in:
  // 1) Among all val and def of the desired type that are in scope
  // 2) In the companion object
  object Person {
    implicit val defPerson = new Person("NoOne")
  }
  println(surround("***")) // ***NoOne***

  // NOTE: There can only be one implicit value for a given data type
  // def quote(what: String)(implicit left: String, right: String) // error
  // No! One could not supply two different strings
}
