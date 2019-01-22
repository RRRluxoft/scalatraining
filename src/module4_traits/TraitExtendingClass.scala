package module4_traits

import java.io.IOException

object TraitExtendingClass {

  // trait extending class
  trait Logged { def log(msg: String) {} }
  // LoggedException is a trait extending Exception class
  trait LoggedException extends Exception with Logged {
    def log() { log(getMessage()) }
  }
  // now UnhappyException extends class IOException
  // with LoggedException (which itself extends Exception)
  class UnhappyException extends IOException with LoggedException

  // however, it is not allowed to extends something unrelated
  class Person
  class Worker
  trait Working extends Worker
  //class Employee extends Person with Working
  // illegal inheritance: superclass Person is not a subclass of Worker
  // but it would work if we define Person as
  // class Person extends Worker
}
