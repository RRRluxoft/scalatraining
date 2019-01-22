package module6_collections

object Collections extends App {

  // using apply() to define a collection
  Iterable(0xFF, 0xFF00, 0xFF0000)
  Set(1, 2, 3, 2)
  Map(1 -> 0xFF0000, 2 -> 0xFF00, 3 -> 0xFF)
  scala.collection.SortedSet("Hello", "World")

  // collections are mutable or immutable
  val set = scala.collection.mutable.Set(1,2,3) // mutable
  set += 5 // mutable - will add value to set
  println(set) // Set(1, 5, 2, 3)
  val set2 = scala.collection.immutable.Set(1,2,3) // immutable
  //set2 += 5 // immutable: += is not allowed operation


}
