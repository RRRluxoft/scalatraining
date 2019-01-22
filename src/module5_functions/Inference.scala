package module5_functions

object Inference extends App {
  def valueAtOneQuarter(f: (Double) => Double) = f(0.25)
  // parameter inference
  // let's take this function
  valueAtOneQuarter((x: Double) => 3 * x) // 0.75
  // we can write it in more brief form:
  valueAtOneQuarter((x) => 3 * x)
  // or shorter:
  valueAtOneQuarter(x => 3 * x)
  // or even shorter:
  valueAtOneQuarter(3 * _)
  // easy to read - function that multiplies smth by 3

  // also we can define functions this way:
  //val fun1 = 3 * _ // can't infer type
  val fun2 = 3 * (_: Double) // OK
  val fun: (Double) => Double = 3 * _
  // OK because we specified the type for fun

}
