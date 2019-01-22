package module9_implicits

object TutorImplicitParams extends App {
  class Person(val name:String)

  val p = new Person("John")
  // TODO create method surround which takes String
  // TODO and Person as implicit parameter
  // TODO and returns person's name surrounded with s
  //println( surround("***")(p)) // should be ***John***

  {
    // TODO define implicit value of type Person with name "Nobody"
    //println( surround("***") ) // should be ***Nobody***
  }

  // Compiler looks for implicit values in:
  // 1) Among all val and def of the desired type that are in scope
  // 2) In the companion object
  // TODO define implicit Person value in companion object
  // println(surround("***")) // should be ***NoOne***

  // NOTE: There can only be one implicit value for a given data type
  // def quote(what: String)(implicit left: String, right: String) // error
  // No! One could not supply two different strings
}
