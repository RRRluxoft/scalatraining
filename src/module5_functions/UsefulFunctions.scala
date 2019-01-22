package module5_functions

object UsefulFunctions extends App {

  println( (1 to 3).map(2 * _) )
  // prints Vector(2,4,6)

  (1 to 3).map("*" * _ + " ").foreach(print(_))
  // prints * ** ***

  (1 to 9).filter(_ % 2 == 0) // 2, 4, 6, 8

  (1 to 9).reduceLeft(_ * _) // 9! (1 * 2 * 3 * 4 * 5 * 6 * 7 * 8 * 9)

  val words =
    "Mary had a little lamb".split(" ")
      .sortWith(_.length < _.length)
      .mkString(",")

  println(words) // a,had,Mary,lamb,little


}
