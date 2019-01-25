package module7_patternmatching

object TutorPartialFunctions extends App {

  // Partial Function - a function which is defined not for all inputs

  // TODO define getCapitalPart: PartialFunction[String, String]
  // TODO it should return "Washington" for "USA",
  // TODO "Bucharest" for "Romania" and "Paris" for "France"
  def getCapitalPart: PartialFunction[String, String] = {
    case "USA" => "Washington"
    case "Romania" => "Bucharest"
    case "France" => "Paris"
  }

  // println(getCapitalPart("France"))
  // TODO check if getCapitalPart is defined for "Russia" (use isDefinedAt)
  // TODO get capital of Russia or return "Russia capital is unknown" otherwise
  // TODO (use partialFunc.applyOrElse(param, fallbackFunc),
  // TODO fallbackFunc should return result in case if partialFunc is not defined
  // TODO for param
  println(getCapitalPart("France"))
  println(getCapitalPart.isDefinedAt("Russia")) // false
  println(getCapitalPart.applyOrElse("Russia",
    (c: String) => s"$c capital is unknown")) // Russia capital is unknown
  try {
    getCapitalPart("Russia") // throws MatchError
  } catch {
    case _: MatchError => println("Match Error")
  }

  // you can pipe several partial functions
  // TODO define getCapitalPart2: PartialFunction[String, String]
  // TODO which returns "Moscow" for "Russia" param
  def getCapitalPart2: PartialFunction[String, String] = {
    case "Russia" => "Moscow"
    case country => "capital unknown for " + country
  }

  println(getCapitalPart2("Tobago"))

  // getCapital is a combination of getCapitalPart and getCapitalPart2
  // TODO set getCapital to combination of getCapitalPart and getCapitalPart2
  // TODO (use partialFunc.orElse(partialFunc2) )
  // println(getCapital("Russia")) // should be Moscow
  val getCapital = getCapitalPart.orElse(getCapitalPart2)
  println("For rusa  " + getCapital("Russia")) // Moscow

  // additionally we can use PartialFunction.empty to throw MatchError
  val getCapital2 = getCapitalPart.orElse(getCapitalPart2) // throws MatchError
  try {
    println(getCapital2("Italy"))
  } catch {
    case _: MatchError => println("Match Error")
  } // prints Match Error

  // Some methods accept a PartialFunction as a parameter.
  // For example, collect method of the GenTraversable trait
  // applies a partial function to all elements where it is defined,
  // and returns a sequence of the results.
  val v = "-3+4+1".collect { case '+' => 1; case '-' => -1 }
  println(v) // Vector(-1, 1, 1)
}
