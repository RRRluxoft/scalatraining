package module6_collections

import scala.collection.mutable.ArrayBuffer

object TutorOperations extends App {

  val vec = Vector(1,2,3)
  // Seq has :+ operator to add elements
  // TODO create vector1 by appending 5 to vec

  // TODO create vector2 by prepending 1 to vec

  var vector3 = Vector(1, 2, 3)
  vector3 :+= 5 // += does not work since vectors don't have a + operator
  vector3(2)
  println(vector3)

  // ++ is available for Iterable
  // TODO use ++ to concatenate vector1 and vector2

  // operations for mutable collections
  val numbers = ArrayBuffer(1, 2, 3)
  // TODO append 5 to numbers

  var numbers2 = Set(1, 2, 3)
  // TODO append 5 to numbers2, print the result
  // TODO remove 2 from numbers2, print the result
  // TODO append (3,4) tuple to numbers2, print the result

  // TODO append numbers2 to numbers by using ++=

  // TODO remove all elements in numbers2 from numbers, use --=

}
