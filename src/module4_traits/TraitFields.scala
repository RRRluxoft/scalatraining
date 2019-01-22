package module4_traits

import java.io.PrintStream

object TraitFields {
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

  val acct6 = new SavingsAccount with FileLogger {
    val filename = "myapp.log" // will throw NPE in out initializer
  }

  val acct7 = new {
    val filename = "myapp.log"
  } with SavingsAccount with FileLogger
  // now we have initialized filename
  // before call to SavingsAccount constructor
  acct7.log("hello");
  // note: only concrete field definitions allowed
  // in early object initialization section (no def!)

  // using lazy initialization
  trait FileLogger2 {
    val filename: String
    lazy val out = new PrintStream(filename)
    def log(msg: String) { out.println(msg) }
    // will initialize out on call to log()
  }
  val acct8 = new SavingsAccount with FileLogger2 {
    val filename = "myapp.log"
  } // here out is not initialized
  acct8.log("hello from lazy") // out is initialized here

}
