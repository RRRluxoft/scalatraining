package module5_functions

object TutorHigherOrderFunction extends App {
  val pi = 3.14
  // TODO define function applyToPi which applies function f to pi
  // TODO it should take function f of type Double=>Double as a parameter

  import math._
  // TODO call applyToPi by passing function ceil and function sqrt
  // TODO don't forget to add _ in the end

  // closures with function producing a function
  // TODO define a function mulBy which takes param of type Double
  // TODO and returns function having x:Double as a parameter
  // TODO and returning x multiplied by parameter as result
  // TODO use f = (function_param) => function_block syntax

  // TODO define functions double and triple as the result of mulBy function
  // TODO use it and print a result
  // double and triple are closures: data+code
}
