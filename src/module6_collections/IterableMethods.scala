package module6_collections

import scala.collection.mutable.ArrayBuffer

object IterableMethods extends App {

  var seq = Seq(1,2,3,4,5)
  println(seq) // List(1, 2, 3)

  // Iterable trait methods

  println ("*** length, isEmpty ***")
  // basic methods
  println( seq.length ) // 5
  println( seq.isEmpty ) // false

  println ("*** min, max, sum, product ***")
  // basic aggregation functions
  println( seq.min ) // 1
  println( seq.max ) // 5
  println( seq.sum ) // 15
  println( seq.product ) // 120

  println ("*** mapping ***")
  // mapping
  val names = List("Peter", "Paul", "Mary")
  println( names.map(_.toUpperCase) ) // List("PETER", "PAUL", "MARY")
  // this is the same as for (n <- names) yield n.toUpperCase
  println( seq.map(_+1) ) // List(2, 3, 4, 5, 6)
  def nameLen(s:String) = Vector(s, s.length)
  println( names.map(nameLen) )
  // List(Vector(Peter, 5), Vector(Paul, 4), Vector(Mary, 4))
  println( names.flatMap(nameLen) ) // List(Peter, 5, Paul, 4, Mary, 4)
  // collect: using partial function to map defined values
  println( names.collect{ case "Peter"=>"Pier"; case "Mary"=>"Maria" } )
  // List(Pier, Maria)

  println ("*** recudeLeft, reduceRight, reduceLeft, reduce ***")
  // reduce and fold
  println( seq.reduceLeft(_+_) ) // 15
  println( seq.reduceRight(_-_) ) // 3: 1-(2-(3-(4-5)))
  println( seq.reduceLeft(_-_) ) // -13: (((1-2)-3)-4)-5
  println( seq.reduce(_+_) )
  // for reduce operator must be associative: (a op b) op c = a op (b op c)
  println( seq.foldLeft(1)(_+_) ) // 16: 1+((((1+2)+3)+4)+5)
  println( seq.foldLeft("")(_+_) ) // "12345"
  // reduce vs. reduceLeft: _-_ is not associative operation
  println( seq.reduce(_-_) ) // -13
  println( seq.par.reduce(_-_) ) // -5
  println( seq.par.reduceLeft(_-_) ) // -13

  println ("*** count,exists,forall,filter,partition ***")
  // functions with predicates
  println( seq.count(_%2==0) ) // count of even elements, 2
  println( seq.exists(_>3) ) // true
  println( seq.forall(_>3) ) // false
  println( seq.filter(_>3) ) // List(4,5)
  println( seq.partition(_>3) ) // (List(4, 5),List(1, 2, 3))

  println ("*** takeWhile, span, dropWhile ***")
  // get first elements fulfilling the predicate
  println( seq.takeWhile(_<3) ) // List(1,2)
  println( seq.span(_<3) ) // (List(1, 2),List(3, 4, 5))
  println( seq.dropWhile(_<3) ) // List(3, 4, 5)

  println ("*** take, drop, splitAt ***")
  // functions returning elements by its amount
  println( seq.take(3) ) // List(1, 2, 3)
  println( seq.drop(2) ) // List(3, 4, 5)
  println( seq.splitAt(2) ) // (List(1, 2),List(3, 4, 5))

  println ("*** slice ***")
  // slice(from,to) - range from until to
  println( seq.slice(2,4) ) // List(3, 4)

  println ("*** zipping ***")
  // zipping
  val seq2 = Seq(-1,-2,-3)
  println( seq.zip(seq2) ) // List((1,-1), (2,-2), (3,-3))
  // zipAll(col2, fill1, fill2)
  println( seq.zipAll(seq2, 0, 0) ) // List((1,-1), (2,-2), (3,-3), (4,0), (5,0))
  println( seq.zipWithIndex ) // List((1,0), (2,1), (3,2), (4,3), (5,4))

  println ("*** grouping ***")
  // grouping: returns elements 0..n-1, n..2*n-1, ...
  val groups = seq.grouped(2) // returns Iterator
  println(groups.toList) // List(List(1, 2), List(3, 4), List(5))
  // sliding(n): returns elements 0..n-1, 1..n-1, 2..n-1, ...
  println(seq.sliding(2).toList)
  // List(List(1, 2), List(2, 3), List(3, 4), List(4, 5))

  println ("*** mkString, addString ***")
  // mkString(before,between,after)
  println(seq.mkString("(",";",")")) // (1;2;3;4;5)
  // addString(sb,before,between,after)
  val sb = new StringBuilder("SB: ")
  seq.addString(sb, "(",";",")")
  println(sb) // SB: (1;2;3;4;5)

  println ("*** converters ***")
  // converters
  println(seq.toIterable) // List(1, 2, 3, 4, 5)
  println(seq.toSeq) // List(1, 2, 3, 4, 5)
  println(seq.toIndexedSeq) // Vector(1, 2, 3, 4, 5)
  println(seq.toArray) // [I@6acdbdf5
  println(seq.toList) // List(1, 2, 3, 4, 5)
  println(seq.toStream) // Stream(1, ?)
  println(seq.toSet) // Set(5, 1, 2, 3, 4)
  println(seq.zipWithIndex.toMap)
  // Map(5 -> 4, 1 -> 0, 2 -> 1, 3 -> 2, 4 -> 3)
  println(seq.map(e=>(e,e+1)).toMap)
  // Map(5 -> 6, 1 -> 2, 2 -> 3, 3 -> 4, 4 -> 5)

  println ("*** copy methods ***")
  // copy methods: to Array
  val a1,a2 = Array(0,0,0,0)
  seq.copyToArray(a1)
  println(a1.mkString(",")) // 1,2,3,4
  seq.copyToArray(a2,1,2)
  println(a2.mkString(",")) // 0,1,2,0
  // copy methods: to ArrayBuffer
  val buf = ArrayBuffer(1,2,3)
  seq.copyToBuffer(buf)
  println(buf) // ArrayBuffer(1, 2, 3, 1, 2, 3, 4, 5)

}
