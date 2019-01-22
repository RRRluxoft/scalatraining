package module1_intro

object TutorArguments extends App {

  // TODO create function decorate(s,left,right) which adds left
  // TODO before the string and right after the string s
  // TODO left should have default value [, and right ]

  def decorate(s: String, left: String = "[", right: String = "]") =
    left + s + right

  // TODO uncomment this
  println(decorate("Hello")) // prints [Hello]

  // using named arguments
  // TODO use only argument named right equals to ">"
  // TODO should print [Hello>
  println(decorate("Hello", right = ">"))

  // using variable arguments
  // TODO define function sum with variable arguments args:Int*
  // TODO use for (arg <- args) to iterate over args and calculate its sum
  def sum(args: Int*): Int = {
//    var res = 0
//    for (a <- args) res += a
//    res
     args.fold(0)(_ + _)
  }

  println(sum(1, 2, 3)) // TODO uncomment, shoud print 6

  // procedure: function with no returning value
  def p(s: String) {
    println(s)
  }

  // TODO define function pp as function returning Unit (procedure)
  def pp(s: String): Unit = println(s)
}
