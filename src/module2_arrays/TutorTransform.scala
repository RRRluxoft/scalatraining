package module2_arrays

object TutorTransform extends App {

  // TODO create array a having values 2, 3, 5, 7, 11
  val array = Array[Int](2, 3, 5, 7, 11)

  // TODO use for .. until to print values with indexes, like "0:2 1:3 2:5 3:7 4:11"
  for (i <- 0 until array.length) print(s"$i:${array(i)}")

  // TODO use for ... yield to multiply every element by 2 and return the result
  val result = for (e <- array) yield e * 2 // should be Array(4, 6, 10, 14, 22)

  // TODO double every even element, dropping the odd,
  // TODO using for ... yield with guard
  val doubled = for (e <- array if e % 2 == 0) yield e * 2

  // TODO do the same using filter() and map()
  array.filter(_ % 2 == 0).map(_ * 2)

  // TODO calculate amount of elements bigger than 5 (should be 2)
  println(s"\nCount ${array.count(_ > 5)}")

  // TODO create multidimensional array matrix of type Double,
  // TODO with 3 rows and 4 columns
  val matrix = Array.ofDim[Double](3, 4)

  // TODO set matrix element (2,1) to value 42
  matrix(2)(1) = 42

}
