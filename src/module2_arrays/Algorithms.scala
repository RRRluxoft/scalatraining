package module2_arrays

import scala.collection.mutable.ArrayBuffer

object Algorithms extends App {
  Array(1, 7, 2, 9).sum // 19
  ArrayBuffer(1,2,3).sum // 6
  ArrayBuffer("Mary", "had", "a", "little", "lamb").max
  val b:ArrayBuffer[Int] = ArrayBuffer(1, 7, 2, 9)
  //val bSorted = b.sorted(_<_)
  val bSorted = b.sorted // bSorted is ArrayBuffer(1, 2, 7, 9)
  val bDescending = b.sortWith(_ > _) // bSorted is ArrayBuffer(9, 7, 2, 1)
  val a = Array(1, 7, 2, 9)
  scala.util.Sorting.quickSort(a) // a is now Array(1, 2, 7, 9)
  //Note: min, max, sorted need element type to have comparision operation

  a.mkString(",") // "1,2,7,9"
  a.mkString(" and ") // "1 and 2 and 7 and 9"
  a.mkString("<", ",", ">") // "<1,2,7,9>"
  a.toString // "[I@b73e5"
  b.toString // "ArrayBuffer(1, 7, 2, 9)"
}
