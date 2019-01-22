package module2_arrays

object TutorFixedLengthArrays extends App {
  // TODO create array of integers, with size 5
  val arr1 = new Array[Int](5)

  // TODO create array of String, with size 10
  val arr2 = new Array[String](10)

  // TODO create array a with values "Hello" and "World"
  val s = Array("Hello", "World")

  // TODO change first value in array a to "Goodbye"
  s(0) = "Goodbye"

  // TODO print all a values using for loop
  s.foreach(println)
}
