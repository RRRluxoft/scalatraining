package module5_functions

object FunctionAsValue extends App {

  import scala.math._
  val num = 3.14
  val fun = ceil _

  println(fun(num)) // 4.0
  // fun is a variable containing a function

  Array(3.14, 1.42, 2.0).map(fun) // Array(4.0, 2.0, 2.0)

  val triple = (x: Double) => 3 * x
  // the same as
  def triple2(x: Double) = 3 * x

  // anonymous function
  // you don't need to name a function:
  Array(3.14, 1.42, 2.0).map((x: Double) => 3 * x)
  // Array(9.42, 4.26, 6.0)

  // another syntax
  Array(3.14, 1.42, 2.0) map{ (x: Double) => 3 * x }

  // we can create anonymous function and execute it in same expression
  println( ((x:Double)=>5*x)(2) ) // 10


}
