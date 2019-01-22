package module7_patternmatching

object OptionType extends App {
  /*
    Option type in the standard library uses case classes
    to express values that might or might not be present.
    The case subclass Some wraps a value, for example Some("Fred")
    The case object None indicates that there is no value.

    This is less ambiguous than using an empty string
    and safer than using null for a missing value.
   */

  // using Option in pattern matching: get returns Option
  val scores = Map("Alice"->5, "Bob"->4)
  scores.get("Alice") match {
    case Some(score) => println(score)
    case None => println("No score")
  }

  // otherwise, you can use getOrElse:
  println(scores.getOrElse("Alice", "No score")) // 5

  // if you want to skip a None value, use a for comprehension:
  for (score <- scores.get("Alice")) println(score)
  // if the get method returns None, nothing happens

  // the same way
  scores.get("Alice").foreach(println _)
  // prints the score or does nothing if get returns None

  // and you are able to create your own function returning Option:
  def getCapital(country: String): Option[String] = {
    country match {
      case "USA" => Some("Washington")
      case "Romania" => Some("Bucharest")
      case "France" => Some("Paris")
      case _ => None
    }
  }

  println(getCapital("Russia").getOrElse("unknown"))

}
