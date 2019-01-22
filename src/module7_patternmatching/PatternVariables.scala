package module7_patternmatching

object PatternVariables extends App {
  // define 2 variables
  val (x, y) = (1, 2)

  // assign 2 variables to tuple returned with expression
  val (q, r) = BigInt(10) /% 3
  // “/% method returns tuple (quotient, remainder)

  // using pattern for array
  val arr = Array(2,3,4,5)
  val Array(first, second, _*) = arr
  println(s"first = $first, second = $second")
  // first = 2, second = 3

  // pattern in for
  import scala.collection.JavaConversions.propertiesAsScalaMap
  // Converts Java Properties to a Scala map—just to get an interesting example

  for ((k, v) <- System.getProperties())
    println(k + " -> " + v)

  // print all keys with empty value, skipping over all others
  for ((k, "") <- System.getProperties())
    println(k)

  // using guard
  for ((k, v) <- System.getProperties() if v == "")
    println(k)

}
