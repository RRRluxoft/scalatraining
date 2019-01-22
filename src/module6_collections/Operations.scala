package module6_collections

import scala.collection.mutable.ArrayBuffer

object Operations extends App {

  // Seq has :+ operator to add elements
  val vector1 = Vector(1, 2, 3) :+ 5
  println(vector1) // Yields Vector(1, 2, 3, 5)

  val vector2 = 1 +: Vector(1, 2, 3) // Yields Vector(1, 1, 2, 3)
  println(vector2) // Yields Vector(1, 2, 3, 5)

  var vector3 = Vector(1, 2, 3)
  vector3 :+= 5 // += does not work since vectors don't have a + operator
  vector3(2)
  println(vector3)

  // ++ is available for Iterable
  println(vector1 ++ vector2) // Vector(1, 2, 3, 5, 1, 1, 2, 3)

  // operations for mutable collections
  val numbers = ArrayBuffer(1, 2, 3)
  numbers += 5 // Adds 5 to numbers

  var numbers2 = Set(1, 2, 3)
  numbers2 += 5 // adds element to the set
  println(numbers2) // Set(1, 2, 3, 5)
  numbers2 -= 2 // removes element from the set
  println(numbers2) // Set(1, 3, 5)
  numbers2 += (3,4) // adds elements from tuple (-= will remove elements)
  println(numbers2) // Set(1, 3, 5, 4)

  numbers ++= numbers2 // adds numbers2 to numbers
  println(numbers) // numbers is ArrayBuffer(1, 2, 3, 5, 1, 3, 5, 4)

  numbers --= numbers2 // removes all elements in numbers2 from numbers
  println(numbers) // numbers is ArrayBuffer(2, 1, 3, 5)


}
