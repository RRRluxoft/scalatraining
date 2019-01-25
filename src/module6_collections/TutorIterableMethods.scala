package module6_collections

import scala.collection.mutable.ArrayBuffer

object TutorIterableMethods extends App {

  var seq = Seq(1, 2, 3, 4, 5)
  println(seq) // List(1, 2, 3)

  // Iterable trait methods

  println("*** length, isEmpty ***")
  // basic methods
  // TODO print seq length
  // TODO use isEmpty to check if seq is empty
  println(seq.length)
  println(seq.isEmpty)

  println("*** min, max, sum, product ***")
  // basic aggregation functions
  // TODO find min
  // TODO find max
  // TODO find sum
  // TODO find product
  println(seq.min)
  println(seq.max)
  println(seq.sum)
  println(seq.product)

  println("*** mapping ***")
  // mapping
  val names = List("Peter", "Paul", "Mary")
  // TODO use map and toUpperCase to get List("PETER", "PAUL", "MARY")
  println(names.map(_.toUpperCase))

  // this is the same as for (n <- names) yield n.toUpperCase
  // TODO use map to get list with elements incremented by 1
  println(seq.map(_ + 1))

  def nameLen(s: String) = Vector(s, s.length)

  println(names.map(nameLen))
  // List(Vector(Peter, 5), Vector(Paul, 4), Vector(Mary, 4))
  // TODO use flatMap to get List(Peter, 5, Paul, 4, Mary, 4)
  println(names.flatMap(nameLen))

  // collect: using partial function to map defined values
  // TODO use collect to replace all Peter by Pier, all Mary to Maria
  println(names.collect {
    case "Peter" => "Pier"
    case "Mary" => "Maria"
  })
  // TODO use syntax: case old_val=>new_val;
  // result should be List(Pier, Maria)

  println("*** recudeLeft, reduceRight, reduceLeft, reduce ***")
  // reduce and fold
  // TODO use reduceLeft to calculate sum of all elements
  // TODO use reduceRight with _-_ function, result should be 3: 1-(2-(3-(4-5)))
  // TODO use reduceLeft with _-_ function, result should be -13: (((1-2)-3)-4)-5
  println(seq.reduceLeft(_ - _))

  println(seq.reduceRight(_ - _)) // 3: 1-(2-(3-(4-5)))
  println(seq.reduceLeft(_ - _)) // -13: (((1-2)-3)-4)-5
  // TODO use reduce to calculate sum of all elements
  // for reduce operator must be associative: (a op b) op c = a op (b op c)
  println(seq.reduce(_ + _))

  // TODO use foldLeft to calculate sum of elements, starting from 1
  // TODO use foldLeft to calculate sum of elements, starting from ""
  println(seq.foldLeft(1)(_ + _))
  println(names.foldLeft("")(_ + _))

  // reduce vs. reduceLeft: _-_ is not associative operation
  println(seq.reduce(_ - _)) // -13
  // TODO use seq.par.reduce and seq.par.reduceLeft
  // TODO what are the results? why they are different?
  println(seq.par.reduce(_ - _))
  println(seq.par.reduceLeft(_ - _))

  println("*** count,exists,forall,filter,partition ***")
  // functions with predicates
  // TODO calculate the count of even elements (use count)
  // TODO check if there are elements more than 3 (use exists)
  // TODO check if all elements are bigger than 3 (use forall)
  // TODO filter elements leaving only bigger than 3 (use filter)
  // TODO split sequence in 2, having elements more than 3
  // TODO and less than 3 (use partition)
  println(seq.count(_ % 2 == 0))
  println(seq.exists(_ > 3))
  println(seq.forall(_ > 3))
  println(seq.filter(_ > 3))
  println(seq.partition(_ > 3))

  println("*** takeWhile, span, dropWhile ***")
  // get first elements fulfilling the predicate
  // TODO get first elements which are less than 3 (use takeWhile)
  // TODO get tuple having elements less than 3 and more than 3 (use span)
  // TODO drop all elements less than 3 (use dropWhile)
  println(seq.takeWhile(_ < 3))
  println(seq.span(_ < 3))
  println(seq.dropWhile(_ < 3))

  println("*** take, drop, splitAt ***")
  // functions returning elements by its amount
  // TODO get first 3 elements (use take)
  // TODO drop 2 elements, get all others (use drop)
  // TODO get tuple of lists by splitting at index 2
  println(seq take 3)
  println(seq drop (2))
  println(seq.splitAt(2))

  println("*** slice ***")
  // slice(from,to) - range from until to
  // TODO get elements from index 2 to index 4
  println(seq.slice(2, 4))
  // zipping
  val seq2 = Seq(-1, -2, -3)
  // TODO use zip to do zipping of seq and seq2
  // zipAll(col2, fill1, fill2)

  println("*** zipping ***")
  println(seq.zip(seq2))
  // TODO use zipAll to do zipping of seq and seq2, filling empty elements with 0
  // TODO use zipWithIndex to do zipping of seq elements with indexes
  println(seq.zipAll(seq2, 0, 0))
  println(seq.zipWithIndex)

  println("*** grouping ***")
  // grouping: returns elements 0..n-1, n..2*n-1, ...
  // TODO use grouped to create Iterator having groups with 2 elements in each
  val groups = seq.grouped(2) // returns Iterator

  // TODO use toList to print Iterator values
  println(groups.toList)

  // sliding(n): returns elements 0..n-1, 1..n-1, 2..n-1, ...
  // TODO use sliding by 2 to create slided lists iterator
  println(seq.sliding(2))

  println("*** mkString, addString ***")
  // mkString(before,between,after)
  // TODO use mkString to get String representation like "(1;2;3;4;5)"
  println(seq.mkString("(", ";", ")"))

  // addString(sb,before,between,after)
  // TODO create StringBuilder
  val stringBuilder = new StringBuilder("SB")
  // TODO use addString to append String representation of seq to it
  seq.addString(stringBuilder, "(", ";", ")")

  println("*** converters ***")
  // converters
  // TODO use converters toIterable, toSeq, toIndexedSeq, toArray,
  // TODO toList, toStream, toSet
  println(seq.toIterable)
  println(seq.toSeq)
  println(seq.toIndexedSeq)
  println(seq.toArray)
  println(seq.toList)
  println(seq.toStream)
  println(seq.toSet)

  // TODO create a map with zipWithIndex, use toMap to get map
  val map = seq.zipWithIndex.toMap
  println(map)

  // TODO use map to get map of elements having element as a key
  // TODO and incremented element as a value
  println(seq.map(e => (e, e + 1)).toMap)

  println("*** copy methods ***")
  // copy methods: to Array
  val a1, a2 = Array(0, 0, 0, 0)
  // TODO use copyToArray to fill array with seq values
  // TODO use copyToArray(array, indexFrom, indexTo) to fill elements 1 and 2
  println(seq.copyToArray(a1))
  println(a1.mkString(","))
  println(seq.copyToArray(a2, 1, 2))
  println(a2.mkString(","))
  // copy methods: to ArrayBuffer
  val buf = ArrayBuffer(1, 2, 3)
  // TODO use copyToBuffer to append seq elements to buffer, print buf
  seq.copyToBuffer(buf)
  println(buf)


}
