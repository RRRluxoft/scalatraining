package module7_patternmatching

object TutorPartialFunctions extends App {

  // Partial Function - a function which is defined not for all inputs

  // TODO define getCapitalPart: PartialFunction[String, String]
  // TODO it should return "Washington" for "USA",
  // TODO "Bucharest" for "Romania" and "Paris" for "France"

  // println(getCapitalPart("France"))
  // TODO check if getCapitalPart is defined for "Russia" (use isDefinedAt)
  // TODO get capital of Russia or return "Russia capital is unknown" otherwise
  // TODO (use partialFunc.applyOrElse(param, fallbackFunc),
  // TODO fallbackFunc should return result in case if partialFunc is not defined
  // TODO for param

  // you can pipe several partial functions
  // TODO define getCapitalPart2: PartialFunction[String, String]
  // TODO which returns "Moscow" for "Russia" param

  // getCapital is a combination of getCapitalPart and getCapitalPart2
  // TODO set getCapital to combination of getCapitalPart and getCapitalPart2
  // TODO (use partialFunc.orElse(partialFunc2) )
  // println(getCapital("Russia")) // should be Moscow


  // Some methods accept a PartialFunction as a parameter.
  // For example, collect method of the GenTraversable trait
  // applies a partial function to all elements where it is defined,
  // and returns a sequence of the results.
  val v = "-3+4+1".collect { case '+' => 1 ; case '-' => -1 }
  println(v) // Vector(-1, 1, 1)
}
