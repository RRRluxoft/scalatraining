package module6_collections

import scala.collection.mutable.ArrayBuffer

object TutorSequences extends App {
  // mutable sequence
  val buf = ArrayBuffer(1,2,3)
  buf += 5
  println(buf) // ArrayBuffer(1, 2, 3, 5)

  // immutable sequence
  // Vector is indexed sequence with fast random access
  // Vectors are implemented as trees where each node has up to 32 children
  val vector = Vector(1,2,3)
  // vector += 5 // error: += is not defined for Vector

  val vectorBuf = Vector(buf) // Vector(ArrayBuffer(1,2,3))
  // convert mutable ArrayBuffer to immutable Vector
  // TODO use toIndexedSeq for buf to convert it to Vector

  // update element
  // TODO use updated for vector 2 to set value of element 1 to 9
  // TODO assign result to vector3

  // TODO append 6 to vector3 (use :+=)
  // TODO prepend 6 to vector3 (use +:=)

  // TODO Add 2 new values 10 and 20 to the end of vector (use :+)
  // TODO assign result to vector4
}

// http://www.dotnetperls.com/vector-scala - about vectors
// Scala collections perfomance:
// https://www.tobyhobson.co.uk/scala-collections-performance/