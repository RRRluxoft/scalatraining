package module6_collections

object Range extends App {
  // Range represents integer sequence
  val range = 1 to 5
  println(range) // Range(1, 2, 3, 4, 5)
  val range2 = 1 until 5
  println(range2) // Range(1, 2, 3, 4)
  // converting ranges
  println(range.toIndexedSeq)
  // Range is already IndexedSeq, so we get Range(1, 2, 3, 4, 5)
  println(range.toArray) // Array is not Seq, and has no toString overrided
  // use mkString(",") to print Array contents
  println(range.toSet) // Set(5, 1, 2, 3, 4)
  println(range.toList) // List(1, 2, 3, 4, 5)

}
