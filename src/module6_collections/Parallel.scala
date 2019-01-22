package module6_collections

import scala.collection.mutable.ArrayBuffer

object Parallel extends App {

  val coll = ArrayBuffer(1,2,3,4,5)
  coll.par.sum

  coll.par.count(_ % 2 == 0)

  for (i <- (0 until 100).par) print(i + " ")
  // prints 0 50 12 25 13 14 51 1 52 15 16 17 26 27 ...

  // In a for/yield loop, the results are assembled in order:
  val results = for (i <- (0 until 100).par) yield i + " "
  println( results )
  // ParVector(0 , 1 , 2 , 3 , 4 , 5 , 6 , 7 , 8 , 9 , 10 , ... )

  // parallel collection cannot be passed to Iterable, Seq, Set, Map
  val parColl = coll.par
  val it: Iterable[Int] = coll
  //val it2: Iterable[Int] = parColl // error: ParArray is not Iterable
  val it3: Iterable[Int] = parColl.seq // now it's ok: sequential again

  // Threadsafe collections
  import scala.collection.mutable
  val synchroSet = new mutable.HashSet[Int] with mutable.SynchronizedSet[Int]
  // other collections include SynchronizedBuffer, SynchronizedMap, etc.
  //val syncBuf = new mutable.ArrayBuffer[Int] with mutable.SynchronizedBuffer

  // it's preferred to use ConcurrentHashMap, ConcurrentHashSet, etc:
  val concurrentHashMap = new java.util.concurrent.ConcurrentHashMap


}
