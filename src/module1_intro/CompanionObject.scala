package module1_intro

class Example1 {
  def f(x: Int): Int = x+1
}

object Example1 {
  def g(x:Int): Int = x+1
}

// Companion class
object Companion1 {
  // like class instance method in Java
  new Example1().f(0)
  // like static method in Java
  Example1.g(0)

}
