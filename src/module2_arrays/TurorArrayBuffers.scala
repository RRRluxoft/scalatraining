package module2_arrays

object TurorArrayBuffers extends App {

  // An empty array buffer, ready to hold integers
  // TODO create b as ArrayBuffer of Int

  // Add an element at the end with +=
  // TODO Add element 1 to b
  // Add multiple elements at the end by enclosing them in parentheses
  // TODO Add elements 1,2,3,5 to b, use b+=(...,...)
  // should be ArrayBuffer(1, 1, 2, 3, 5)

  // You can append any collection with the ++= operator
  // TODO append Array(8,13,21) to b
  // ArrayBuffer(1, 1, 2, 3, 5, 8, 13, 21)

  // Removes the last five elements
  // TODO use trimEnd to remove last 5 elements
  // ArrayBuffer(1, 1, 2)

  // Insert before index 2
  // TODO use insert(position,value) to insert 6 in position 2
  // ArrayBuffer(1, 1, 6, 2)

  // You can insert as many elements as you like
  // TODO insert values 7,8,9 to position 2: use insert(position,val1,val2...)
  // should be ArrayBuffer(1, 1, 7, 8, 9, 6, 2)
  // TODO remove element at position 2, use remove(position)
  // should be ArrayBuffer(1, 1, 8, 9, 6, 2)

  // The second parameter tells how many elements to remove
  // TODO remove 3 elements at position 2, use remove(position, amount)
  // should be ArrayBuffer(1, 1, 2)
  // TODO remove element at position 1, use b-=position
  // should be ArrayBuffer(1, 2)

  // TODO convert b to array, use toArray
  // should be Array(1, 2)

}
