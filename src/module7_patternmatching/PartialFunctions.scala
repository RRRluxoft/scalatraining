package module7_patternmatching

object PartialFunctions extends App {

  // Partial Function - a function which is defined not for all inputs

  val getCapitalPart: PartialFunction[String, String] = {
    case "USA" => "Washington"
    case "Romania" => "Bucharest"
    case "France" => "Paris"
  }
  println(getCapitalPart("France"))
  println(getCapitalPart.isDefinedAt("Russia")) // false
  println(getCapitalPart.applyOrElse("Russia",
      (c:String)=>s"$c capital is unknown")) // Russia capital is unknown
  try {
    getCapitalPart("Russia") // throws MatchError
  } catch {
    case _: MatchError => println("Match Error")
  }

  // you can pipe several partial functions
  val getCapitalPart2: PartialFunction[String, String] = {
    case "Russia" => "Moscow"
    case a => "capital unknown for "+a
  }
  println( getCapital2("Tobago") )

  // getCapital is a combination of getCapitalPart and getCapitalPart2
  val getCapital = getCapitalPart.orElse(getCapitalPart2)
  println(getCapital("Russia")) // Moscow

  // additionally we can use PartialFunction.empty to throw MatchError
  val getCapital2 = getCapitalPart.orElse(getCapitalPart2) // throws MatchError
  try {
    println(getCapital2("Italy"))
  } catch {
    case _:MatchError => println("Match Error")
  } // prints Match Error

  // Some methods accept a PartialFunction as a parameter.
  // For example, collect method of the GenTraversable trait
  // applies a partial function to all elements where it is defined,
  // and returns a sequence of the results.
  val v = "-3+4+1".collect { case '+' => 1 ; case '-' => -1 }
  println(v) // Vector(-1, 1, 1)
}
