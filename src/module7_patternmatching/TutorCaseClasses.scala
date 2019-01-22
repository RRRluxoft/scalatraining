package module7_patternmatching

object TutorCaseClasses extends App {
  // Case classes are a special kind of classes
  // that are optimized for use in pattern matching

  // TODO define case classes Dollar(value:Double) and
  // TODO Currency(value:Double, unit:String) extending Amount
  // TODO create case object Nothing derived from Amount
  abstract class Amount

  // val amt:Amount = Dollar(10) // TODO uncomment this

  // using in pattern matching
  // TODO use pattern matching to find the type of amt
  // TODO if amt is 10 of type Dollar, set res to "$10"
  // TODO if amt is of another Currency, set res to "Oh no, I got "+unit
  // TODO for Nothing, just return empty string
  val res = ""
  println(res) // should print $10.0

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
  // TODO define amt2 as 29.95 EUR
  // TODO use copy() to copy amt2 to price variable

  // you can use named parameters to modify some of the properties
  // TODO use copy with value=19.95 to create a copy with value changed to 19.95
  // TODO set it to price2, print price2.value

  // TODO use amt2.copy with unit="CHF" to create variable Currency(29.95, "CHF")
  // TODO set it to price3, print price3.value


  // TODO use infix notation in pattern matching of list
  // TODO use head :: tail and print "head is $head, tail is $tail"
  val list = List(1,2,3)

}
