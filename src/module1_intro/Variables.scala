package module1_intro

object Variables extends App {

  var x = 1
  var x1: Int = 1
  var x2: Int = 1 + 1
  //var x3(a:Int):Int = 1+1 // this syntax allowed only for def

  var f1 = (a: Int) => a + "aaa"
  val f2 = (a: Int) => a * a

  def f3 = (a: Int) => a * a

  def f4(a: Int) = a * a

  val f5 = f3
  //val f5 = f4 // not allowed
  val f6: (Int) => Int = f4 // allowed

  //val g0 = _+1 // not allowed: _ type is unknown
  val g1: Int => Int = _ + 1 // allowed: type is known
  //p> g1(1)==2 // true
  val g2 = (_: Int) + 1

  def g3 = (_: Int) + 1

  //g1(1)
  g2(1)

  // val vs. def?
  // Executing a definition such as def x = e
  // will not evaluate the expression e

  // val x = e evaluates the right-hand-side e as part
  // of the evaluation of the definition

  class A(a: Int) {
    val x = {
      println("x is set to something"); a
    }

    def y = {
      println("y is set to something"); a
    }
  }

  val aa = new A(1)
  println("now print values")
  println("a.x=" + aa.x)
  println("a.y=" + aa.y)

  // parenthless method
  def f7: Int = 1

  // Uniform access principle:
  // all services should be available through uniform notation
  // which does not betray whether they are implemented
  // through storage or computation
  // val f7 = 1
  // we can replace it by computation:
  val f8 = 1 + 1

}
