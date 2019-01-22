package module6_collections

object SeqMethods {
  var seq = Seq(1,2,3,4,5)
  // Seq methods

  println ("*** contains ***")
  // contains
  println( seq.contains(4) ) // true
  println( seq.containsSlice(Seq(1,2)) ) // true
  println( seq.startsWith(Seq(1,2)) ) // true
  println( seq.endsWith(Seq(1,2)) ) // false

  println ("*** indexOf ***")
  // indexOf
  println( seq.indexOf(4) ) // 3
  println( seq.lastIndexOf(4) ) // 3
  println( seq.indexOfSlice(Seq(3,4)) ) // 2
  println( seq.indexWhere(_>3) ) // 3

  println ("*** padTo ***")
  // padTo(n, value): fill elements up to n with value
  println( seq.padTo(10, 0) ) // List(1, 2, 3, 4, 5, 0, 0, 0, 0, 0)

  println ("*** intersect and diff ***")
  // diff and intersect
  val seq3 = Seq(5,6,7)
  println( seq.intersect(seq3) ) // List(5)
  println( seq.diff(seq3) ) // List(1, 2, 3, 4)

  println( seq.reverse ) // List(5, 4, 3, 2, 1)

  println ("*** sorting ***")
  // sorting
  println( seq.sorted ) // List(1, 2, 3, 4, 5)
  println( seq.sortWith(_>_) ) // List(5, 4, 3, 2, 1)
  println( "Hello my dear".split(" ").sortBy(_.length).mkString(",") )
  // my,dear,Hello

  println ("*** permutations and combinations ***")
  // permutations and combinations
  val seq4 = Seq(1,2)
  println( seq4.permutations.mkString(",") ) // List(1, 2),List(2, 1)
  println( seq.combinations(2).mkString(",") )
  // List(1, 2),List(1, 3),List(1, 4),List(1, 5),List(2, 3),
  // List(2, 4),List(2, 5),List(3, 4),List(3, 5),List(4, 5)

}
