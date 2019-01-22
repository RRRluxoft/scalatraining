package module1_intro

object TutorMethods extends App {

  // Java-style method
  def f0(x:Int, y:Int): Int = {
    return x*x+y*y;
  }

  // Semicolon inference
  // TODO define method f1 with no ; in the end

  // Last expression return
  // TODO define method f2 with no return

  // Single expression
  // TODO define method f3 with no {} brackets

  // Return type inference
  // TODO define method f4 with no return type

  // inner method
  def f5(x:Int, y:Int) = {
    def sqr(x:Int) = x*x // this is function
    sqr(x)+sqr(y)
  }

}