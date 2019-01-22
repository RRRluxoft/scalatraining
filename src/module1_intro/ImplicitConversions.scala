
object ImplicitConversions extends App{
  val x: Int = 0

  val from0to5 = x.to(5)
  // x was implicitly converted to RichInt

  // implicit String to StringLike conversion
  val s: String = "abc"
  println(s.capitalize)
  // capitalize is defined in StringLike class

  // with implicits we can use retrospective conversion
}