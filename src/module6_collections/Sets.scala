package module6_collections

import scala.collection.mutable

object Sets extends App {
  // Set is a collection of distinct elements
  val set = Set(2, 0, 1) + 1
  println(set) // Set(2, 0, 1)

  // set do not retain order (unlike lists or ArrayBuffer/Vector)
  val set2 = Set(1,2,3,4,5,6)
  set2.foreach(print(_)) // prints 516234
  println(set2) // Set(5, 1, 6, 2, 3, 4)

  // linked hash set remembers the order in which elements were inserted
  val linkedSet = mutable.LinkedHashSet(6,5,4,3,2,1)
  println(linkedSet) // Set(6, 5, 4, 3, 2, 1)
  // if you want to keep elements in sorted order, use SortedSet
  val sortedSet = mutable.SortedSet(6,5,4,3,2,1)
  println(sortedSet) // TreeSet(1, 2, 3, 4, 5, 6)

  // contains and subsetOf methods
  val digits = Set(1, 7, 2, 9)
  println(digits contains 0) // false
  println(digits contains 1) // true
  Set(1, 2) subsetOf digits // true

  // union (or ++) , intersect (or &), and diff (or --) methods
  val primes = Set(2, 3, 5, 7)
  println(digits ++ primes) // Set(5, 1, 9, 2, 7, 3)
  println(digits & primes) // Set(7, 2)
  println(digits -- primes) // Set(1, 9)


}
