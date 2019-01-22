package module4_traits

import java.io.IOException

object TutorTraitExtendingClass extends App {

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
  // TODO uncomment this and make it compilable
  //class Employee extends Person with Working


}
