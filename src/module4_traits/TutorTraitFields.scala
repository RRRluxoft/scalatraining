package module4_traits

import java.io.PrintStream

object TutorTraitFields extends App {
  // initializing trait fields

  // we cannot have constructor parameters in trait like
  //val acct = new SavingsAccount with FileLogger("myapp.log")

  class SavingsAccount
  // let's define field as abstract
  trait FileLogger {
    val filename: String
    val out = new PrintStream(filename) // we will get NPE here
    def log(msg: String) { out.print(msg) }
  }

  // TODO use early object initialization to define filename before use
  val acct6 = new SavingsAccount with FileLogger {
    val filename = "myapp.log"
  }
  acct6.log("hello");

  // TODO create trait FileLogger2 as copy of FileLogger
  // TODO use lazy variable to initialize out

  val acct8 = new SavingsAccount with FileLogger { // TODO use FileLogger2 here
    val filename = "myapp.log"
  } // here out is not initialized
  acct8.log("hello from lazy") // out is initialized here

}
