package module6_collections

import scala.collection.mutable.ArrayBuffer

object TutorIterableMethods extends App {

  var seq = Seq(1,2,3,4,5)
  println(seq) // List(1, 2, 3)

  // Iterable trait methods

  println ("*** length, isEmpty ***")
  // basic methods
  // TODO print seq length
  // TODO use isEmpty to check if seq is empty

  println ("*** min, max, sum, product ***")
  // basic aggregation functions
  // TODO find min
  // TODO find max
  // TODO find sum
  // TODO find product

  println ("*** mapping ***")
  // mapping
  val names = List("Peter", "Paul", "Mary")
  // TODO use map and toUpperCase to get List("PETER", "PAUL", "MARY")
  // this is the same as for (n <- names) yield n.toUpperCase
  // TODO use map to get list with elements incremented by 1
  def nameLen(s:String) = Vector(s, s.length)
  println( names.map(nameLen) )
  // List(Vector(Peter, 5), Vector(Paul, 4), Vector(Mary, 4))
  // TODO use flatMap to get List(Peter, 5, Paul, 4, Mary, 4)
  // collect: using partial function to map defined values
  // TODO use collect to replace all Peter by Pier, all Mary to Maria
  // TODO use syntax: case old_val=>new_val;
  // result should be List(Pier, Maria)

  println ("*** recudeLeft, reduceRight, reduceLeft, reduce ***")
  // reduce and fold
  // TODO use reduceLeft to calculate sum of all elements
  // TODO use reduceRight with _-_ function, result should be 3: 1-(2-(3-(4-5)))
  // TODO use reduceLeft with _-_ function, result should be -13: (((1-2)-3)-4)-5

  println( seq.reduceRight(_-_) ) // 3: 1-(2-(3-(4-5)))
  println( seq.reduceLeft(_-_) ) // -13: (((1-2)-3)-4)-5
  // TODO use reduce to calculate sum of all elements
  // for reduce operator must be associative: (a op b) op c = a op (b op c)

  // TODO use foldLeft to calculate sum of elements, starting from 1
  // TODO use foldLeft to calculate sum of elements, starting from ""

  // reduce vs. reduceLeft: _-_ is not associative operation
  println( seq.reduce(_-_) ) // -13
  // TODO use seq.par.reduce and seq.par.reduceLeft
  // TODO what are the results? why they are different?

  println ("*** count,exists,forall,filter,partition ***")
  // functions with predicates
  // TODO calculate the count of even elements (use count)
  // TODO check if there are elements more than 3 (use exists)
  // TODO check if all elements are bigger than 3 (use forall)
  // TODO filter elements leaving only bigger than 3 (use filter)
  // TODO split sequence in 2, having elements more than 3
  // TODO and less than 3 (use partition)

  println ("*** takeWhile, span, dropWhile ***")
  // get first elements fulfilling the predicate
  // TODO get first elements which are less than 3 (use takeWhile)
  // TODO get tuple having elements less than 3 and more than 3 (use span)
  // TODO drop all elements less than 3 (use dropWhile)

  println ("*** take, drop, splitAt ***")
  // functions returning elements by its amount
  // TODO get first 3 elements (use take)
  // TODO drop 2 elements, get all others (use drop)
  // TODO get tuple of lists by splitting at index 2

  println ("*** slice ***")
  // slice(from,to) - range from until to
  // TODO get elements from index 2 to index 4

  println ("*** zipping ***")
  // zipping
  val seq2 = Seq(-1,-2,-3)
  // TODO use zip to do zipping of seq and seq2
  // zipAll(col2, fill1, fill2)
  // TODO use zipAll to do zipping of seq and seq2, filling empty elements with 0
  // TODO use zipWithIndex to do zipping of seq elements with indexes

  println ("*** grouping ***")
  // grouping: returns elements 0..n-1, n..2*n-1, ...
  // TODO use grouped to create Iterator having groups with 2 elements in each
  // TODO use toList to print Iterator values
  // sliding(n): returns elements 0..n-1, 1..n-1, 2..n-1, ...
  // TODO use sliding by 2 to create slided lists iterator

  println ("*** mkString, addString ***")
  // mkString(before,between,after)
  // TODO use mkString to get String representation like "(1;2;3;4;5)"
  // addString(sb,before,between,after)
  // TODO create StringBuilder
  // TODO use addString to append String representation of seq to it

  println ("*** converters ***")
  // converters
  // TODO use converters toIterable, toSeq, toIndexedSeq, toArray,
  // TODO toList, toStream, toSet

  // TODO create a map with zipWithIndex, use toMap to get map

  // TODO use map to get map of elements having element as a key
  // TODO and incremented element as a value

  println ("*** copy methods ***")
  // copy methods: to Array
  val a1,a2 = Array(0,0,0,0)
  // TODO use copyToArray to fill array with seq values
  // TODO use copyToArray(array, indexFrom, indexTo) to fill elements 1 and 2
  // copy methods: to ArrayBuffer
  val buf = ArrayBuffer(1,2,3)
  // TODO use copyToBuffer to append seq elements to buffer, print buf


}
