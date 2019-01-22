package module5_functions

object Currying extends App {
  def mul(x: Int, y: Int) = x * y

  // currying: turning a function that takes
  // two arguments into a function that takes one argument

  // function mulOneAtATime takes one argument,
  // yielding a function that takes one argument
  def mulOneAtATime(x: Int) = (y: Int) => x * y
  mulOneAtATime(6)(7) // to multiply
  // result of mulOneAtATime is the function (y: Int) => 6 * y
  // That function (closure) is applied to 7, yielding 42.

  // There's is a shortcut for currying:
  def multiply(x: Int)(y: Int) = x * y
  def triple = multiply(3) _
  triple(3) // 9

  val a = Array("Hello", "World")
  val b = Array("hello", "world")

  println( a.corresponds(b)(_.equalsIgnoreCase(_)) )
  // _.equalsIgnoreCase(_) is passed as a curried parameter

}
