package module6_collections

import scala.collection.mutable.ArrayBuffer

object Sequences extends App {
  // mutable sequence
  val buf = ArrayBuffer(1,2,3)
  buf += 5
  println(buf) // ArrayBuffer(1, 2, 3, 5)

  // immutable sequence
  // Vector is indexed sequence with fast random access
  // Vectors are implemented as trees where each node has up to 32 children
  val vector = Vector(1,2,3) // not do convert like java: Vector(ArrayBuffer(1,2,3))
  // vector += 5 // error: += is not defined for Vector
  println(vector) // Vector (1,2,3)
  val vectorBuf = Vector(buf)
  // convert mutable ArrayBuffer to immutable Vector
  val vector2 = buf.toIndexedSeq
  println(vector2) // Vector (1, 2, 3, 5)
  // update element
  var vector3 = vector2 updated(1,9)
  println(vector3) // Vector(1, 9, 3, 5)
  vector3 :+= 6 // append
  println(vector3) // Vector(1, 9, 3, 5, 6)
  vector3 +:= 6 // prepend
  println(vector3) // Vector(6, 1, 9, 3, 5, 6)
  // Add 2 new values at end of vector.
  val vector4 = vector3 :+ 10 :+ 20 // calls :+ from RichInt (:+ applied to 10)
  // because :+ is right-associative
  //val vector5 = vector3 +: 10 +: 20 // error: cannot resolve +:
  // because +: is not defined in Vector
  val vector6 = 10 +: vector3 // calls +: from RichInt, which is correct
  println(vector4) // Vector(6, 1, 9, 3, 5, 6, 10, 20)


}

// http://www.dotnetperls.com/vector-scala - about vectors
// Scala collections perfomance:
// https://www.tobyhobson.co.uk/scala-collections-performance/