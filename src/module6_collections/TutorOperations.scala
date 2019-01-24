package module6_collections

import scala.collection.mutable.ArrayBuffer

object TutorOperations extends App {

  var vec = Vector(1,2,3)
  // Seq has :+ operator to add elements
  // TODO create vector1 by appending 5 to vec
  val vector1 = vec :+ 5

  // TODO create vector2 by prepending 1 to vec
  var vector2 = 1 +: vec
  vector2 :+= 7

  var vector3 = Vector(1, 2, 3)
  vector3 :+= 5 // += does not work since vectors don't have a + operator
  vector3(2)
  println(vector3)

  // ++ is available for Iterable
  // TODO use ++ to concatenate vector1 and vector2
  println(vector2 ++ vector3)

  // operations for mutable collections
  val numbers = ArrayBuffer(1, 2, 3)
  // TODO append 5 to numbers
  numbers += 5

  var numbers2 = Set(1, 2, 3)
  // TODO append 5 to numbers2, print the result
  // TODO remove 2 from numbers2, print the result
  // TODO append (3,4) tuple to numbers2, print the result
  numbers2 += 5
  numbers2 -= 2
  numbers2 += (3,4)

  // TODO append numbers2 to numbers by using ++=
  numbers ++= numbers2

  // TODO remove all elements in numbers2 from numbers, use --=
  numbers --= numbers2

}
