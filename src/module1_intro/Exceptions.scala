package module1_intro

object Exceptions extends App {

  def throwException(i: Int) =
    if (i < 0) throw new IllegalArgumentException()

  throwException(-1)
  // program will stop with
  // Exception in thread "main" java.lang.IllegalArgumentException
  // and stack trace

  class CustomException(s: String) extends Exception {
    override def getMessage = s
  }

  case class CustomCaseException(s: String) extends Exception

  def testException(i: Int) = {
    if (i < 0) throw new IllegalArgumentException()
    if (i<10) throw new CustomException("arg < 10")
    if (i<20) throw new CustomCaseException("arg < 20")
    println("no exception - normal execution")
  }

  def checkExceptions(i:Int) = {
    try {
      testException(i)
    } catch {
      case _: IllegalArgumentException => println("wrong parameter")
      case ex: CustomException => println("custom exception with arg " + ex.getMessage)
      case CustomCaseException(msg) => println("custom case exception with arg " + msg)
      case _: Throwable => println("any other Exception")
    }
  }
  checkExceptions(-5) // wrong parameter
  checkExceptions(5) // custom exception with arg arg < 10
  checkExceptions(15) // custom case exception with arg arg < 20
  checkExceptions(25) // no exception - normal execution
}
