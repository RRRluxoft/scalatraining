package module6_collections

object Streams extends App {
  // stream is an immutable list in which the tail is computed lazily

  def numsFrom(n: BigInt): Stream[BigInt] = n #:: numsFrom(n + 1)
  // #:: operator is like the :: operator for lists, but it constructs a stream

  val tenOrMore = numsFrom(10)
  println( tenOrMore ) // Stream(10, ?)
  // The tail is unevaluated
  println( tenOrMore.tail ) // Stream(11, ?)
  println( tenOrMore.tail.tail(0) ) // 12
  println( tenOrMore.tail.tail(3) ) // 15

  tenOrMore(5) // 15
  println(tenOrMore) // Stream(10,11,12,13,14,15,?)

  val squares = numsFrom(2).map(x => x * x)
  println(squares) // Stream(4, ?)

  // to take more than one answer, use take with force:
  println( squares.take(5).force ) // Stream(4, 9, 16, 25, 36)
  //squares.force // NO! We get infinite stream causing OutOfMemoryError

  // you can construct Stream from any iterator
  val seq = Seq(1,2,3)
  println( seq.toStream ) // Stream(1, ?)
  seq.toStream.take(5).force // Stream(1,2,3)
  seq.toStream(3) // IndexOutOfBoundsException
}
