package module4_traits

object TraitSelfType extends App {
  // Self Type syntax:
  // this: Type =>

  // trait instance can only be mixed into subclasses of Exception
  trait LoggedException {
    this: Exception =>
    def log() { println(getMessage()) }
  }

  class MyException extends Exception with LoggedException // OK

  //class BadException extends LoggedException
  // error: BadException does not conform to Exception

  class NewException extends Exception
  val e = new NewException with LoggedException
  // that's ok: e is Exception, so it can use LoggedException

  // structural type: this should have method getMessage()
  trait LoggedException2 {
    this: { def getMessage() : String } =>
    def log() { println(getMessage()) }
  }
  class MyException2 extends Exception with LoggedException2 // OK

  // that's also OK: we define getMessage() method inside
  class MessageException extends LoggedException2 {
    def getMessage() : String = "message exception"
  }

}
