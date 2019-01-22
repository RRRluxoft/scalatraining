package module5_functions

object HigherOrderFunction extends App {
  def valueAtOneQuarter(f: Double => Double) = f(0.25)
  // valueAtOneQuarter is a function that receives a function,
  // so it is called a higher-order function

  import math._
  def f2(d:Double):Double = 1+d

  valueAtOneQuarter(f2) // 1.0
  valueAtOneQuarter(sqrt) // 0.5 (because 0.5 × 0.5 = 0.25)

  // closures with function producing a function
  def mulBy(factor : Double) = (x : Double) => factor * x
  // double and triple are closures: data+code
  val double = mulBy(2)
  val triple = mulBy(3)
  double(2) // 4
  triple(3) // 9

  // another form of the mulBy function (shortcut)
  def mulBy2(factor : Double)(x : Double) = factor * x
}
