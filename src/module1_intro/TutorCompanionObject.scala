package module1_intro

class Example {
  def f(x: Int): Int = x+1
}

// TODO create companion object for Example
// TODO define function g which takes Int argument and increments it

object Companion extends App {
  // like class instance method in Java
  new Example().f(0)
  // like static method in Java
  // Example.g(0) // TODO uncomment this

}
