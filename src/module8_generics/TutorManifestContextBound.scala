package module8_generics

import scala.collection.mutable.ArrayBuffer

object TutorManifestContextBound {

  // Manifest Context Bound: using Manifest to create classes
  // When type is defined as T:Manifest, compiler will look for
  // implicit Manifest[T] and use it to create objects
  // syntax: [T:Manifest]

  // TODO define method createArrayBuffer
  // TODO taking 2 parameters first and second of type T
  // TODO which creates ArrayBuffer of type T and returns it

  /* TODO uncomment this
  val arr1 = createArrayBuffer(1,2) // should create ArrayBuffer[Int]
  // compiler locates the implicit Manifest[Int]

  // arr1 += "hi" // error: cannot put String to ArrayBuffer[Int]
  arr1 += 1 // correct - put Int to ArrayBuffer[Int]
  */
}
