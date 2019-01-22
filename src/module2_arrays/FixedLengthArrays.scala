package module2_arrays

/**
  * Created by vladson on 5/25/16.
  */
object FixedLengthArrays extends App {
  val nums = new Array[Int](10) // array of 10 integers, all are 0
  val a = new Array[String](10) // string array, every string is null

  val s = Array("Hello", "World") // array of string, type is inferred
  s(0) = "Goodbye" // use () to access elements
  for (a <- s) print(a) // prints GoodbyeWorld
}
