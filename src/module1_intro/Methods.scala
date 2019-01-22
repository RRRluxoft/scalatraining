
object Methods extends App {

  // Java-style method
  def f0(x:Int, y:Int): Int = {
    return x*x+y*y;
  }

  // Semicolon inference
  def f1(x:Int, y:Int): Int = {
    return x*x+y*y
  }

  // Last expression return
  def f2(x:Int, y:Int): Int = {
    x*x+y*y
  }

  // Single expression
  def f3(x:Int, y:Int): Int = x*x+y*y

  // Return type inference
  def f4(x:Int, y:Int) = x*x+y*y

  def f5(x:Int, y:Int) = {
    def sqr(x:Int) = x*x // this is function
    sqr(x)+sqr(y)
  }


}