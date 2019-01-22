package module6_collections

object TutorSeqMethods extends App {
  // Seq methods

  println ("*** contains ***")
  // contains
  // TODO check if 4 can be found in seq (use contains)
  // TODO check if sequence (1,2) can be found in seq (use containsSlice)
  // TODO check if seq starts with sequence (1,2) (use startsWith)
  // TODO check if seq ends with sequence (1,2) (use endsWith)

  println ("*** indexOf ***")
  // indexOf
  // TODO find the index of element having value 4 (use indexOf)
  // TODO find the last index of element having value 4 (use lastIndexOf)
  // TODO find the index of sequence (3,4) in seq (use indexOfSlice)
  // TODO find the index of first element which is more than 3 (use indexWhere)

  println ("*** padTo ***")
  // padTo(n, value): fill elements up to n with value
  // TODO use padTo to get list filled with 0 to 10 elements

  println ("*** intersect and diff ***")
  // diff and intersect
  val seq3 = Seq(5,6,7)
  // TODO use intersect to find intersection of seq and seq3
  // TODO use diff to find difference of seq and seq3
  // TODO get the reversed list from seq (se reverse)

  println ("*** sorting ***")
  // sorting
  // TODO use sorted to sort seq in natural order (use sorted)
  // TODO use sortWith to sort seq in descendind order like List(5, 4, 3, 2, 1)
  val s = "Hello my dear"
  // TODO use split and sortBy to sort words by length of the word
  // TODO use mkString to get String representation "my,dear,Hello"

  println ("*** permutations and combinations ***")
  // permutations and combinations
  val seq4 = Seq(1,2)
  // TODO use permutations to get all possible variants of elements in seq4
  // TODO use combinations to get all possible combinations of size 2
  // TODO with values in seq
}
