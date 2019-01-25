package module2_arrays

import scala.collection.convert.ImplicitConversions.`seq AsJavaList`


object TutorAlgorithms extends App {

  // TODO create array having values 1,2,3,4 and calculate its sum
  val arr = Array[Int](1, 2, 3, 4)

  // TODO create ArrayBuffer with values "one", "two", "three" and get its maximal value
  import scala.collection.mutable.ArrayBuffer

  val buf = ArrayBuffer[String]("one", "two", "three")
  buf.max

  // TODO create ArrayBuffer b having values 2,6,9,1
  val b = ArrayBuffer(2, 6, 9, 1)

  // TODO sort it in ascending order and print
  println(b.sorted.mkString("<", ",", ">"))

  // TODO sort it in descending order and print (use sortBy)


  // TODO create Array a with values 1,7,2

  // TODO use util.Sorting.quickSort to sort it

  // TODO print a as comma-separated string, like "1,2,6,9"

  // TODO print a as string separated with "and", like "1 and 2 and 6 and 9"

  // TODO print a as comma-separated string in braces, like "(1,2,6,9)"
  // TODO use mkString

}
