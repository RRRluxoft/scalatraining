package module6_collections

import scala.collection.mutable

object TutorSets extends App {
  var s = Set(2, 0, 1)
  // Set is a collection of distinct elements
  // TODO create set by appending 1 to s, use +

  // set do not retain order (unlike lists or ArrayBuffer/Vector)
  val set2 = Set(1,2,3,4,5,6)
  // TODO use foreach to print every element of set, see the result

  // linked hash set remembers the order in which elements were inserted
  val linkedSet = mutable.LinkedHashSet(6,5,4,3,2,1)
  // TODO print linkedSet, is it ordered? how?

  // if you want to keep elements in sorted order, use SortedSet
  val sortedSet = mutable.SortedSet(6,5,4,3,2,1)
  // TODO print sortedSet, is it ordered?

  // contains and subsetOf methods
  val digits = Set(1, 7, 2, 9)
  // TODO check if 0 is element of digits (use contains)
  // TODO check if 1 is element of digits (use contains)
  // TODO check if Set(1,2) is subset of digits (use subsetOf)

  // union (or ++) , intersect (or &), and diff (or --) methods
  val primes = Set(2, 3, 5, 7)
  // TODO use ++ to get union of digits and primes
  // TODO use & to get intersection of digits and primes
  // TODO use -- to get diff of digits and primes


}
