package module6_collections

import scala.collection.mutable.ArrayBuffer

object TutorParallel extends App {

  val coll = ArrayBuffer(1,2,3,4,5)
  println(coll.par.sum)

  // TODO perform parallel calculation of count of even elements
  println(coll.par.count(_ % 2 == 0))

  // TODO print elements from range 0 until 100 in parallel way (use for print)
  // TODO look at results, why are the unordered?
  for (i <- (0 until 100).par) print(i + " ")

  // In a for/yield loop, the results are assembled in order:
  // TODO use for yield for the same task; are the results ordered?
  val res = for (i <- (0 to 100).par) yield i + " "
  println( res)

  // parallel collection cannot be passed to Iterable, Seq, Set, Map
  val parColl = coll.par
  val it: Iterable[Int] = coll
  // TODO assign parColl to it; can you?
  // TODO how can we assign parColl to it? (use seq)
  //val it2: Iterable[Int] = parColl // error: ParArray is not Iterable
  val it3: Iterable[Int] = parColl.seq // now it's ok: sequential again

}
