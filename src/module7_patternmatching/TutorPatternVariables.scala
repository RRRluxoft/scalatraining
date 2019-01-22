package module7_patternmatching

object TutorPatternVariables extends App {
  // define 2 variables
  // TODO define variables x and y with values 1 and 2 in one command

  // assign 2 variables to tuple returned with expression
  // TODO set q to quotient and r to reminder in expression BigInt(10) /% 3
  // “/% method returns tuple (quotient, remainder)

  // using pattern for array
  val arr = Array(2,3,4,5)
  // TODO set first to first array item, second to second array item
  // TODO using pattern matching
  // println(s"first = $first, second = $second") // TODO uncomment
  // first = 2, second = 3

  // pattern in for
  import scala.collection.JavaConversions.propertiesAsScalaMap
  // Converts Java Properties to a Scala map—just to get an interesting example

  // TODO print all keys and values of System.getProperties()
  // TODO using pattern matching: for ((key, value)<-map) ...

  // print all keys with empty value, skipping over all others
  // TODO print only pairs where value is ""
  // TODO using pattern matching: for ((key, "")<-map) ...

  // using guard
  // TODO print only pairs where value is ""
  // TODO using pattern matching: for ((key, value)<-map if value=="") ...
  for ((k, v) <- System.getProperties() if v == "")
    println(k)

}
