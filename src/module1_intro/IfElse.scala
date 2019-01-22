package module1_intro

object IfElse extends App {
  val x = Math.random()-0.5
  var b = if (x > 0) 1 else -1
  // same as:
  if (x > 0) b = 1 else b = -1

  val s = if (x > 0) "positive" else -1 // expression of type Any
  println(s.getClass) // will be String or Integer

  val o = if (x>0) 1
  println(o) // prints () - the only value of type Unit
  println(o.getClass) // class scala.runtime.BoxedUnit
  // same as:
  val o1 = if (x>0) 1 else ()
  println(o1) // prints ()

  // Option type - explicit work with no result
  val o2:Option[Int] = if (x>0) Some(1) else None
  println(o2.getOrElse(0)) // prints 0
}
