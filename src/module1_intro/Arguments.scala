package module1_intro

object Arguments extends App {

  def decorate(s:String, left:String="[", right:String="]") =
    left+s+right

  println( decorate("Hello") ) // prints [Hello]

  // using named arguments
  println( decorate("Hello", right=">") ) // prints [Hello>

  // using variable arguments
  def sum(args: Int*) = {
      var result = 0
      for (arg <- args) result += arg
      result
  }

  println( sum(1,2,3) ) // prints 6

  // procedure: function with no arguments
  def p(s:String) { println(s) }
  def pp(s:String):Unit = { println(s) } // recommended syntax
}
