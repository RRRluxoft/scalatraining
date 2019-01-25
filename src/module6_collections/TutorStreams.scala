package module6_collections

object TutorStreams extends App {
  // stream is an immutable list in which the tail is computed lazily

  // TODO create function numsFrom which will generate
  // TODO stream with elements starting from n and incrementing by 1
  // TODO use #:: to append to the end of stream and recursion
  def numsFrom(n: BigInt): Stream[BigInt] = n #:: numsFrom(n + 1)

  // #:: operator is like the :: operator for lists, but it constructs a stream

  val tenOrMore = numsFrom(10) // TODO uncomment

  // The tail is unevaluated
  // TODO print tail of tenOrMore
  // TODO print tail.tail(0), tail.tail(3); expain the results
  println(tenOrMore)
  println(tenOrMore.tail(0))
  println(tenOrMore.tail.tail(3))

  // TODO set squares to stream of squares starting from square of 2
  val squares = numsFrom(2).map(e => e * e)

  // to take more than one answer, use take with force:
  // TODO use take(5).force to get 5 results from squares
  println(squares.take(5).force)
  //squares.force // NO! We get infinite stream causing OutOfMemoryError


  // you can construct Stream from any iterator
  val seq = Seq(1, 2, 3)
  // TODO use toStream to get stream from seq
  val stream = seq.toStream
  println(stream)
  println(seq.toStream(2))
}
