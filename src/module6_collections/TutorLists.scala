package module6_collections

object TutorLists extends App {

  // List is either Nil (that is, empty)
  // or an object with a head element and a tail that is again a list
  // TODO create list having elements 4 and 2 (use List function)
  val list = List(4, 2, Nil)

  // :: operator makes a new list from a given head and tail
  // TODO use :: to create list having 9 as head and List(4,2) as tail
  val list2 = 9 :: List(4, 2)

  // TODO use :: to create list from elements 9,4,2,Nil
  // :: is right-associative: 9 :: (4 :: (2 :: Nil))
  // TODO print head and tail of list
  val list3 = 9 :: 4 :: 2 :: Nil
  println(list3.head + " -- " + list3.tail)

  // concatenate 2 lists
  // TODO use ::: to concatenate List(1,2,3) and List(4,5,6)
  val list4 = List(1, 2, 3) :: List(4, 5, 6)

  // function evaluating sum using recursion
  // TODO create recursive function sum(lst: List[Int]) which will
  // TODO use head and tail to calculate a sum of List[Int]
  // TODO use it to calculate sum of the list
  def sum(lst: List[Int]): Int = lst match {
    case Nil => 0
    case x :: xs => x + sum(xs)
    case _ => 0
  }

  println(sum(List(3, 5, 6)))

  // using pattern matching
  // TODO create recursive function sum2(lst: List[Int]) which will
  // TODO use pattern matching to calculate sum
  // TODO syntax: lst match {case Nil => 0; case head :: tail => ... }
  def sum2(lst: List[Int]): Int = lst match {
    case Nil => 0
    case x :: xs => x + sum(xs)
    case _ => 0
  }

  // mutable LinkedList works like the immutable List,
  // but you can modify the head by assigning elem
  // and the tail by assigning next
  // NOTE: you cannot assign directly to head or tail

  // removing every second element in LinkedList
  var cur = scala.collection.mutable.LinkedList(1, 2, 3, 4, 5)
  // TODO remove every second element of cur (use cur.next and cur.next.next)
  while (cur != Nil && cur.next != Nil) {
    cur.next = cur.next.next
    cur = cur.next
  }


}
