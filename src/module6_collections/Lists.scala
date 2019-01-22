package module6_collections

object Lists extends App {

  // List is either Nil (that is, empty)
  // or an object with a head element and a tail that is again a list
  val digits = List(4, 2)

  // :: operator makes a new list from a given head and tail
  val list2 = 9 :: List(4, 2)
  println(list2) // List(9, 4, 2)

  val list3 = 9 :: 4 :: 2 :: Nil
  println(list3) // List(9, 4, 2)
  // :: is right-associative: 9 :: (4 :: (2 :: Nil))
  println(list3.head) // 9
  println(list3.tail) // List(4, 2)

  // concatenate 2 lists
  val list4 = List(1,2,3) ::: List(4,5,6)
  println(list4) // List(1, 2, 3, 4, 5, 6)

  // function evaluating sum using recursion
  def sum(lst: List[Int]): Int =
    if (lst == Nil) 0 else lst.head + sum(lst.tail)

  println(sum(List(1,2,3))) // 6

  // using pattern matching
  def sum2(lst: List[Int]): Int = lst match {
    case Nil => 0
    case h :: t => h + sum2(t) // h is lst.head, t is lst.tail
  }

  println(sum2(List(1,2,3))) // 6

  // actually, you can do sum operation much simplier
  List(9, 4, 2).sum // Yields 15

  // mutable LinkedList works like the immutable List,
  // but you can modify the head by assigning elem
  // and the tail by assigning next
  // NOTE: you cannot assign directly to head or tail

  // removing every second element in LinkedList
  var cur = scala.collection.mutable.LinkedList(1,2,3,4,5)
  while (cur != Nil && cur.next != Nil) {
    cur.next = cur.next.next
    cur = cur.next
  }


}
