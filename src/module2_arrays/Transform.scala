package module2_arrays


object Transform extends App {

  val a = Array(2, 3, 5, 7, 11)
  def aaa(a: Array[Any]) = {
    a.length
  }

  // traversing with index
  for (i <- 0 until a.length) print(i+":"+a(i)+" ") // 0:2 1:3 2:5 3:7 4:11

  val result = for (elem <- a) yield 2 * elem // Array(4, 6, 10, 14, 22)

  // double every even element, dropping the odd
  val res2 = for (elem <- a if elem % 2 == 0) yield 2 * elem // 4
  var res3 = a.filter(_ % 2 == 0).map(2 * _) // filter+map approach, 4
  a.count(_>5) // count elements which are >5, result is 2

  val a1 = Array(0,0,0)
  a1.copyToArray(a)
  println(a.mkString(",")) // 0,0,0,7,11

  // multidimensional array
  val matrix = Array.ofDim[Double](3, 4) // Three rows, four columns
  matrix(2)(1) = 42

}
