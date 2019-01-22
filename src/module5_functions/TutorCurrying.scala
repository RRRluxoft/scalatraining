package module5_functions

object TutorCurrying extends App {
  def mul(x: Int, y: Int) = x * y

  // currying: turning a function that takes
  // two arguments into a function that takes one argument

  // TODO create function mulOneAtATime which takes one argument,
  // TODO and yields a function that takes one argument
  // TODO syntax: f(param) = (result_func_param) => result_func_code
  // TODO result_func_code can use param and result_func_param
  // mulOneAtATime(6)(7) // to multiply

  // result of mulOneAtATime is the function (y: Int) => 6 * y
  // That function (closure) is applied to 7, yielding 42.

  // TODO Define function multiply using shortcut syntax for currying:
  // TODO func(param)(result_func_param) = result_func_code
  def multiply(x: Int)(y: Int) = x * y
  // TODO use multiply to create function triple which multiplies by 3
  // triple(3) // 9

  val a = Array("Hello", "World")
  val b = Array("hello", "world")
  // TODO use curried function corresponds to compare 2 values
  // TODO pass equalsIgnoreCase as a curried function parameter


}
