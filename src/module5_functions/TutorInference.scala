package module5_functions

object TutorInference extends App {
  def valueAtOneQuarter(f: (Double) => Double) = f(0.25)
  // parameter inference
  // let's take this function
  valueAtOneQuarter((x: Double) => 3 * x) // 0.75

  // TODO pass parameter to valueAtOneQuarter without type, like (x)
  // TODO pass parameter to valueAtOneQuarter without brackets, like x
  // TODO pass parameter to valueAtOneQuarter without param, like _ + 1

  // also we can define functions this way:
  // val fun1 = 3 * _ // can't infer type
  // TODO add type to the _ so that it was compilable, syntax (_:Type)

  // TODO define function variable with a type and assign its value
  // syntax: val func: (param-type) => (result-type) = code
  // variable should multiply by 3

}
