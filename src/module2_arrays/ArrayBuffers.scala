package module2_arrays

object ArrayBuffers {
  import scala.collection.mutable.ArrayBuffer

  // An empty array buffer, ready to hold integers
  val b = new ArrayBuffer[Int] // Or ArrayBuffer[Int]()

  // Add an element at the end with +=
  b += 1 // ArrayBuffer(1)
  // Add multiple elements at the end by enclosing them in parentheses
  b += (1, 2, 3, 5) // ArrayBuffer(1, 1, 2, 3, 5)

  // You can append any collection with the ++= operator
  b ++= Array(8, 13, 21) // ArrayBuffer(1, 1, 2, 3, 5, 8, 13, 21)

  // Removes the last five elements
  b.trimEnd(5) // ArrayBuffer(1, 1, 2)

  // Insert before index 2
  b.insert(2, 6) // ArrayBuffer(1, 1, 6, 2)

  // You can insert as many elements as you like
  b.insert(2, 7, 8, 9) // ArrayBuffer(1, 1, 7, 8, 9, 6, 2)
  b.remove(2) // ArrayBuffer(1, 1, 8, 9, 6, 2)
  // The second parameter tells how many elements to remove
  b.remove(2, 3) // ArrayBuffer(1, 1, 2)
  b-=1 // same as b.remove(1), result is ArrayBuffer(1, 2)

  b.toArray // Array(1, 2)

}
