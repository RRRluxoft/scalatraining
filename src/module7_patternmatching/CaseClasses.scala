package module7_patternmatching

object CaseClasses extends App {
  // Case classes are a special kind of classes
  // that are optimized for use in pattern matching

  abstract class Amount
  case class Dollar(value: Double) extends Amount
  case class Currency(value: Double, unit: String) extends Amount

  case object Nothing extends Amount

  val amt:Amount = Dollar(10)
  // using in pattern matching
  val res = amt match {
    case Dollar(v) => "$" + v
    case Currency(_, u) => "Oh no, I got " + u
    case Nothing => ""
  }
  println(res) // $10.0

   /*
   Case class:
   1) Each of the constructor parameters becomes a val
   unless it is explicitly declared as a var
   2) apply method is provided for the companion object
   that lets you construct objects without new, such as Dollar(29.95)
   3) unapply method is provided that makes pattern matching work
   4) methods toString, equals, hashCode, and copy are generated
   unless they are explicitly provided
   Otherwise, case classes are just any other classes.
   */

  // copy method
  val amt2 = Currency(29.95, "EUR")
  val price = amt2.copy()

  // you can use named parameters to modify some of the properties
  val price2 = amt2.copy(value = 19.95) // Currency(19.95, "EUR")
  println(price2.value) // 19.95

  val price3 = amt2.copy(unit = "CHF") // Currency(29.95, "CHF")
  println(price3.value) // 19.95

  // infix notation for matching Lists
  val cur = Currency(20, "Euro")
  // this is an immutable value class
  cur match {
    case amount Currency unit => println(s"$amount of $unit")
  } // Same as case Currency(amount, unit)
  // prints 20.0 of Euro

  // this feature is meant for matching sequences
  // For example, every List object is either Nil
  // or an object of the case class ::, defined as
  // case class ::[E](head: B, tail: List[E]) extends List[E]
  val list = List(1,2,3)
  list match {
    case head :: tail => println(s"head is $head, tail is $tail")
    case _ =>
  }
  // Same as case ::(h, t), which calls ::.unapply(lst)”


}
