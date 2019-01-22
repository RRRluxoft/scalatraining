package module7_patternmatching

object TutorOptionType extends App {
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
  // TODO use pattern matching to match scores.get("Alice")
  // TODO it should print score or print "No score" in case None

  // otherwise, you can use getOrElse:
  // TODO use getOrElse to get Alice score or "No score" if Alice has no score

  // if you want to skip a None value, use a for comprehension:
  // TODO use for loop to print Alice score if it is present
  for (score <- scores.get("Alice")) println(score)
  // if the get method returns None, nothing happens

  // the same way
  scores.get("Alice").foreach(println _)
  // prints the score or does nothing if get returns None

  // and you are able to create your own function returning Option:
  // TODO define function getCapital(country: String): Option[String]
  // TODO it should match country and return "Washington" for "USA",
  // TODO Bucharest for Romania, Paris for France and None otherwise

  // TODO use getCapital and getOrElse to find capital
  // TODO of Russia or return "unknown" if it was not found

}
