package module4_traits

object TutorTraitSelfType extends App {
  // Self Type syntax:
  // this: Type =>

  // trait instance can only be mixed into subclasses of Exception
  // TODO define trait with self type Exception
  trait LoggedException {
    // TODO uncomment log method
    //def log() { println(getMessage()) }
  }

  class MyException extends Exception with LoggedException // OK

  // TODO how to change BadException to make it compilable?
  class BadException extends LoggedException
  // error: BadException does not conform to Exception

  class NewException extends Exception
  val e = new NewException with LoggedException
  // that's ok: e is Exception, so it can use LoggedException

  // structural type: this should have method getMessage()
  // TODO define trait with structural self type
  // TODO { def getMessage() : String }
  trait LoggedException2 {
    // TODO uncomment
    //def log() { println(getMessage()) }
  }
  class MyException2 extends Exception with LoggedException2 // OK

  // TODO how to conform to structural type without extending Exception?
  class MessageException extends LoggedException2 {
  }

}
