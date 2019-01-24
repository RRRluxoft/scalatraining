package module6_collections

object TutorCollections extends App {

  // using apply() to define a collection
  // TODO use Iterable, Set and Map to define collections with values
  // TODO use scala.collection.SortedSet to define collection
  Iterable(1, 8, 7)
  Set(2, 3, 4, 5, 6)
  Map("1" -> 1, "e" -> -1)

  scala.collection.SortedSet("word", "hello")

  // collections are mutable or immutable
  // TODO define Set from scala.collection.mutable having elements 1,2,3
  // TODO add 5 to collection, print it
  val set = scala.collection.mutable.Set(1, 2, 3)
  set += 5
  set.foreach(e => print(e.toString.mkString("< ", ", ", " >")))

  // TODO create immutable set with elements 1,2,3
  var set2 = Set(1, 2, 3)
  set2 += 5
  println("\n" +set2)

}
