package module1_intro

object TutorIfElse extends App {
  val x = Math.random() - 0.5
  // TODO use if else as expression to set b to 1 if x>0 and to -1 otherwise
  var b = 0
  if (x > 0) b = 1 else b

  // TODO set s to "positive" if x>0 and to -1 otherwise
  // TODO expression type will be inferred as Any
  val s = if (x > 0) "positive" else -1
  println(s.getClass) // will be String or Integer, depending on result

  val o = if (x > 0) 1
  println(o) // prints () - the only value of type Unit
  println(o.getClass) // class scala.runtime.BoxedUnit
  // same as:
  val o1 = if (x > 0) 1 else ()
  println(o1) // prints ()

  // Option type - explicit work with no result
  // TODO define o2 as Option[Int],
  // TODO which returns Some(1) if x>0, and None otherwise

  val o2: Option[Int] = if (x > 0) Some(1) else None
   println(o2.getOrElse(-1)) // prints 1 or -1
}
