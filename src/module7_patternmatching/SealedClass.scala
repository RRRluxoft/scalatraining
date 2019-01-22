package module7_patternmatching

object SealedClass {
  // Sealed is a top class in a case class hierarchy
  // When you use pattern matching with case classes,
  // it allows to be sure that you exhausted all alternatives
  sealed abstract class Amount
  case class Dollar(value: Double) extends Amount
  case class Currency(value: Double, unit: String) extends Amount
  // all subclasses of a sealed class must be defined in the same file

  val a:Amount = Dollar(10)
  a match {
    case Dollar(v) => println(v+" dollars")
  }
  // if you are using sealed class in top of hierarchy, you get a warning:
  // match may not be exhaustive
  // It would fail on the following input: Currency(_,_)



}
